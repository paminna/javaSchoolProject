package com.example.client.client.controller;
import ch.qos.logback.core.status.Status;
import com.example.client.AuthService;
import com.example.client.LoginRequest;
import com.example.client.client.ClientRequest;
import com.example.server.controller.PersonController;
import com.example.server.dto.AccountDto;
import com.example.server.security.SecurityConfig;
import com.example.server.security.UserDetailsServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("http://localhost:8083")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client-start")
    public String getStarted() {
        return "Client is ready.";
    }

    @PostMapping("/get/accounts/by")
    public List<AccountDto> getAccountById(@RequestBody ClientRequest request)
    {
        AccountDto[] responses =
                restTemplate.postForObject(url + "/account/get-accounts-by", request, AccountDto[].class);
        List<AccountDto> list = Arrays.asList(responses);
        return list;
    }


    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/auth/{login}/{password}")
    public void  auth(@PathVariable("login") String login, @PathVariable("password") String password) throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin(login);
        loginRequest.setPassword(password);
        authService.sendRequestWithHeader(loginRequest);
    }

}