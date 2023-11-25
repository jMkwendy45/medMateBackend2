package com.medMate.medMate.auth.controller;

import com.medMate.medMate.auth.dto.request.AuthenticationRequest;
import com.medMate.medMate.auth.dto.request.RegisterDoctorRequest;
import com.medMate.medMate.auth.dto.response.AuthResponse;
import com.medMate.medMate.auth.dto.response.AuthenticationResponse;
import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.auth.exception.AlreadyExistException;
import com.medMate.medMate.auth.service.AuthenticationService;
import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.user.dto.request.RegisterRequest;
import com.medMate.medMate.user.dto.response.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("/**")
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        System.out.println("hi");
        try {
            User user = service.register(request);
            return new ResponseEntity<>(
                    new RegisterUserResponse(true, HttpStatus.CREATED.value(), "successful",
                            LocalDateTime.now(), user)
                    ,HttpStatus.CREATED);
        }
        catch (AlreadyExistException e){
            return new ResponseEntity<>(
                    new BaseResponse(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                            LocalDateTime.now())
                    ,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/registerUserDoctor")
    public ResponseEntity<?> registerUserMedicalPractioner(@RequestBody RegisterDoctorRequest request) {
        try {
            User user = service.registerDoctor(request);
            return new ResponseEntity<>(
                    new RegisterUserResponse(true, HttpStatus.CREATED.value(), "successful",
                            LocalDateTime.now(), user)
                    ,HttpStatus.CREATED);
        }
        catch (AlreadyExistException e){
            return new ResponseEntity<>(
                    new BaseResponse(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                            LocalDateTime.now())
                    ,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        System.out.println("eme");
        try {
            AuthenticationResponse response = service.authenticate(request);
            System.out.println(response);
            return new ResponseEntity<>(
                    new AuthResponse(true, HttpStatus.OK.value(), "successful",
                            LocalDateTime.now(), response)
                    ,HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(
                    new BaseResponse(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                            LocalDateTime.now())
                    ,HttpStatus.BAD_REQUEST);
        }

    }
}
