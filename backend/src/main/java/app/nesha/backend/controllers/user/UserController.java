package app.nesha.backend.controllers.user;

import app.nesha.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest request) {
        var user = userService.registerUser(request);
        URI uri = URI.create(user.username());
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping
    public ResponseEntity<Void> updateUserInfos(@Valid @RequestBody UserRequest request) {
        userService.updateUserInfo(request.username(), request);
        return ResponseEntity.noContent().build();
    }
}
