package app.nesha.backend.services.postgresql;

import app.nesha.backend.controllers.user.UserRequest;
import app.nesha.backend.controllers.user.UserResponse;
import app.nesha.backend.models.User;
import app.nesha.backend.repositories.UserRepository;
import app.nesha.backend.services.UserService;
import app.nesha.backend.utils.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintDeclarationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserServicePostgresql implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServicePostgresql.class);

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserResponse registerUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        try {

            user =  userRepository.save(user);
        } catch (DataIntegrityViolationException | ConstraintDeclarationException e){
            logger.error("Erro ao salvar {}", e.getMessage());
        }
        return userMapper.toResponse(user);

    }

    @Override
    public void updateUserInfo(String username, UserRequest request) {
        User user = verifyIfExist(username);
        updateData(user, request);
        userRepository.save(user);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        User user = verifyIfExist(username);
        return userMapper.toResponse(user);
    }


    protected User verifyIfExist(String username){
        return userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Não foi encontrado usuário com username %s informado", username)));
    }

    protected void updateData(User user, UserRequest userRequest){
        user.setEmail(Objects.requireNonNullElse(userRequest.email(), user.getEmail()));
        user.setPassword(Objects.requireNonNullElse(userRequest.password(), user.getPassword()));
        if (userRequest.phoneNumber() != null){
            user.setPhoneNumber(userRequest.phoneNumber());
        }

    }


}
