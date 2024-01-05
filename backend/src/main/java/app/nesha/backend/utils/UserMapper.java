package app.nesha.backend.utils;

import app.nesha.backend.controllers.user.UserRequest;
import app.nesha.backend.controllers.user.UserResponse;
import app.nesha.backend.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserMapper implements EntityMapper<User, UserRequest, UserResponse>{
    @Override
    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.isActive(), user.getEmail(), user.getPhoneNumber());
    }

    @Override
    public List<UserResponse> toResponseList(List<User> users) {
        return users.stream().map(this::toResponse).toList();
    }

    @Override
    public User toEntity(UserRequest request) {
        return new User(request.username(), request.password(), request.email(),request.phoneNumber());
    }

    @Override
    public List<User> toEntityList(List<UserRequest> requestList) {
        return requestList.stream().map(this::toEntity).toList();
    }
}
