package app.nesha.backend.controllers.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank String username,
                          @NotBlank String password,
                          @NotBlank @Email String email,
                          @Nullable String phoneNumber) {
}
