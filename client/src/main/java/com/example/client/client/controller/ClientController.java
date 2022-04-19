package com.example.client.client.controller;
import ch.qos.logback.core.status.Status;
import com.example.client.client.ClientRequest;
import com.example.server.controller.PersonController;
import com.example.server.dto.AccountDto;
import com.example.server.security.SecurityConfig;
import com.example.server.security.UserDetailsServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

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
    public String auth(@PathVariable("login") String login, @PathVariable("password") String password) throws Exception {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);

            if(passwordEncoder.matches(password, userDetails.getPassword())) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, null, userDetails.getAuthorities());
                authentication.setDetails(userDetails);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            else {
                return "PASSWORD_NOT_MATCHES";
            }
        }
        catch (UsernameNotFoundException ex) {
            return "USER_NOT_FOUND";
        }

        return "OK";
    }

}