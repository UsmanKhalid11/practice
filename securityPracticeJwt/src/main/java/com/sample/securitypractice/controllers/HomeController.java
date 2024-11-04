package com.sample.securitypractice.controllers;


import com.sample.securitypractice.entities.AuthRequest;
import com.sample.securitypractice.entities.AuthResponse;
import com.sample.securitypractice.entities.JwtTokenEntities;
import com.sample.securitypractice.reposotory.JwtDetailRepo;
import com.sample.securitypractice.service.JwtRepoService;
import com.sample.securitypractice.service.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/")
public class HomeController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtRepoService jwtRepoService;

    @Autowired
    private  JwtUtilService jwtUtilService;

@GetMapping("hello")
    public String hello() {
    return "Hello World!";
}
    @GetMapping("home")
    public String home() {
        return "Home allowed for all no auth needed!";
    }
    @GetMapping("admin")
    public String admin() {
        return "Only admin is allowed";
    }
    @GetMapping("user")
    public String user() {
        return "Only user is allowed";
    }

    @GetMapping("authenticate")
    public ResponseEntity<?> getjwt(@RequestParam String username,@RequestParam String password){
    ///initial start point will check credentials and if those are okay will generate jwt token
        try {

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            return ResponseEntity.ok(new AuthResponse(jwtUtilService.generateToken(username)));
        }catch (BadCredentialsException E)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }
    @GetMapping("jwts")
    public List<JwtTokenEntities> jwts() {
        return jwtRepoService.get();
    }


}
