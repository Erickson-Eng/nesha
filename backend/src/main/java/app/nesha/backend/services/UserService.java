package app.nesha.backend.services;

import app.nesha.backend.controllers.user.UserRequest;
import app.nesha.backend.controllers.user.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);

    void updateUserInfo(String username, UserRequest request);

    UserResponse getUserByUsername(String username);
}
