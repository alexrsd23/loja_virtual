package com.rosendo.loja_virtual.controller.security;

import com.rosendo.loja_virtual.config.security.auth.AuthenticationResponse;
import com.rosendo.loja_virtual.config.security.auth.RequisicaoLogin;
import com.rosendo.loja_virtual.services.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody RequisicaoLogin request
    ) {
        return ResponseEntity.ok(authenticationService.autenticar(request));
    }
}
