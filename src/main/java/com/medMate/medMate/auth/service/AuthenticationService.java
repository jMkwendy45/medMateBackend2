package com.medMate.medMate.auth.service;

import com.medMate.medMate.auth.dto.request.AuthenticationRequest;
import com.medMate.medMate.auth.dto.request.RegisterDoctorRequest;
import com.medMate.medMate.auth.dto.response.AuthenticationResponse;
import com.medMate.medMate.auth.exception.AlreadyExistException;
import com.medMate.medMate.medications.medicationexception.NotFoundException;
import com.medMate.medMate.security.config.JwtService;
import com.medMate.medMate.user.data.models.User;
import com.medMate.medMate.auth.data.repositories.UserRepository;
import com.medMate.medMate.user.dto.request.RegisterRequest;
import com.medMate.medMate.user.enums.Role;
import com.medMate.medMate.user.services.PatientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.EMAIL_ALREADY_EXIST;
import static com.medMate.medMate.medications.medicationexception.ExceptionMessage.EMAIL_OR_PASSWORD_IS_NOT_CORRECT;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private  final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PatientProfileService patientProfileService;

    public User register(RegisterRequest request){
        Optional<User> founderUser = userRepository.findByEmail(request.getEmail());
        if (founderUser.isPresent()){
            throw new AlreadyExistException(EMAIL_ALREADY_EXIST.name());
        }
        else {
            var user = User.builder()
                    .firstName(request.getFirstname())
                    .lastName(request.getLastname())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .email(request.getEmail())
                    .role(Role.PATIENT)
                    .build();
            userRepository.save(user);
            patientProfileService.createPatientProfile(user);
            return user;
        }

//    var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
    }
    public User registerDoctor(RegisterDoctorRequest request){
        Optional<User> founderUser = userRepository.findByEmail(request.getEmail());
        if (founderUser.isPresent()){
            throw new AlreadyExistException(EMAIL_ALREADY_EXIST.name());
        }
        else {
            var user = User.builder()
                    .password(passwordEncoder.encode(request.getPassword()))
                    .email(request.getEmail())
                    .role(Role.MEDICAL_PRACTITIONER)
                    .build();
            userRepository.save(user);
            patientProfileService.createPatientProfile(user);
            return user;
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isEmpty()){
            throw new NotFoundException(EMAIL_OR_PASSWORD_IS_NOT_CORRECT.name());
        }  else {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            ));
            var jwtToken = jwtService.generateToken((UserDetails) user.get());
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .userId(user.get().getId())
                    .email(user.get().getEmail())
                    .firstName(user.get().getFirstName())
                    .lastName(user.get().getLastName())
                    .build();
        }

    }
}
