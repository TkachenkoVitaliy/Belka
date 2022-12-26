package ru.vtkachenko.belka_backend.security.payload.request;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String username;
    private Set<String> roles;
    private String password;
}
