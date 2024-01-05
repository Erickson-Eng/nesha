package app.nesha.backend.controllers.user;

import jakarta.annotation.Nullable;

public record UserResponse(Long id, String username, boolean active, String email, @Nullable String phoneNumber) {
}
