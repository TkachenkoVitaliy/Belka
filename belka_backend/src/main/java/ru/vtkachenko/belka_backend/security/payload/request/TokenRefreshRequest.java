package ru.vtkachenko.belka_backend.security.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenRefreshRequest {

    private String refreshToken;
}
