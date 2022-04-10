package com.example.client.client;

import com.example.server.account.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@Service
//public class ClientService implements ClientRepository{
//
//    @Autowired
//    private final RestTemplate restTemplate;
//
//    public ClientService(RestTemplate restTemplate, @Value("${application.server.url}") String serverUrl)
//    {
//        this.restTemplate = restTemplate;
//        this.serverUrl = serverUrl;
//    }
//
////    @Override
////    public List<ClientDto> getAccountById(Integer id) {
////        return null;
////    }
//

//    @Autowired
//    RestTemplate restTemplate;
//    @Value("${application.server.url}") String serverUrl;
//
//
//    @Override
//    public List<AccountDto> findAllAccounts() {
////        @PathVariable ("/account/find-all-accounts") String path;
//        List<AccountDto> clientDtos = restTemplate.exchange(serverUrl + "/account/find-all-accounts", HttpMethod.GET, null, new ParameterizedTypeReference<List<AccountDto>>() {
//        }).getBody();
//        System.out.println(clientDtos);
//        return null;
//    }


//    @Override
//    public List<ClientDto> getAccountById(Integer id) {
//        List<ClientDto> clientDtos = restTemplate.exchange(serverUrl + "/account/get-accounts-by-person", HttpMethod.POST, null, new ParameterizedTypeReference<List<ClientDto>>() {
//        }).getBody();
//                return null;
//    }
//}
