package com.example.client.client.controller;

import com.example.server.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Value("http://localhost:8083")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/client-start")
    public String getStarted() {
        return "Client is ready.";
    }

    /**
     *
     * @param login
     * @param password
     * @return
     */
    @GetMapping("/get/accounts/by/{login}/{password}")
    public List<AccountDto> getAccountById(@PathVariable("login") String login, @PathVariable("password") String password) {
        AccountDto[] responses =
                restTemplate.getForObject(url + "/account/get-accounts-by/" + login + "/" + password, AccountDto[].class);
        List<AccountDto> list = Arrays.asList(responses);
        return list;
    }

    /**
     *
     * @param from
     * @param to
     * @param id
     * @return
     */
    @GetMapping("convert/{from}/{to}/by/{personId}")
    public String convert(@PathVariable("from") String from,
                          @PathVariable("to") String to,
                          @PathVariable("personId") Integer id) {
        return restTemplate.getForObject(url + "/account/convert/" + from + "/" + to + "/by/" + id, String.class);
    }
}