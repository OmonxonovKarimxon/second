package com.company.controller;

import com.company.dto.AuthDTO;
import com.company.dto.ProfileDTO;
import com.company.dto.RegistrationDTO;
import com.company.dto.ResponseInfoDTO;
import com.company.dto.email.EmailUpdateDTO;
import com.company.service.AuthService;
import com.company.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/public/registration")
    public ResponseEntity<?> registration(@RequestBody @Valid RegistrationDTO dto) {

        String response = authService.registration(dto);
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/public/login")
    public ResponseEntity<ProfileDTO> login(@RequestBody  AuthDTO dto) {
        ProfileDTO profileDto = authService.login(dto);

        return ResponseEntity.ok().body(profileDto);
    }


}
