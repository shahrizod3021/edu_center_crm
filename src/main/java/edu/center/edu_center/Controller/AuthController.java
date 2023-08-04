package edu.center.edu_center.Controller;

import edu.center.edu_center.Entity.User;
import edu.center.edu_center.Repository.AuthRepository;
import edu.center.edu_center.Security.JwtTokenProvider;
import edu.center.edu_center.Service.AuthService;
import edu.center.edu_center.payload.GetMal;
import edu.center.edu_center.payload.ReqLogin;
import edu.center.edu_center.payload.ResToken;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthRepository authRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody ReqLogin request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword())
        );
        User user = authRepository.findUserByPhoneNumber(request.getPhoneNumber()).orElseThrow(() -> new ResourceNotFoundException("getUser"));
        ResToken resToken = new ResToken(generateToken(request.getPhoneNumber()));
        System.out.println(ResponseEntity.ok(getmalumot(user, resToken)));
        return ResponseEntity.ok(getmalumot(user, resToken));
    }

    public GetMal getmalumot(User user, ResToken resToken) {
        return new GetMal(user, resToken);
    }


    public String generateToken(String phoneNumber) {
        User user = authRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() -> new ResourceNotFoundException("getUser"));
        return jwtTokenProvider.generateToken(user.getId());
    }
}
