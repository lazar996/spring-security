package com.controller;

import com.dto.LoginDTO;
import com.model.Korisnik;
import com.repository.KorisnikRepo;
import com.securityClass.TokenUtils;
import com.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class KorisnikController {

    @Autowired
    KorisnikService korisnikService;

    @Autowired
    KorisnikRepo korisnikRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @CrossOrigin
    @GetMapping("api/korisnici")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Korisnik>>(this.korisnikService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            return new ResponseEntity<String>(tokenUtils.generateToken(details),
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Invalid login", HttpStatus.BAD_REQUEST);
        }
    }

}
