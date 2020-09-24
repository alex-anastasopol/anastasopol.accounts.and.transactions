package com.anastasopol.accounts.and.transactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@RestController
public class RestApiController {
    String jwtToken = "";
    String username = null;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {

        return "This is Home page";
    }

    @GetMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String login(@RequestParam(value = "username") String username) throws JsonProcessingException {
        this.username = username;
        HttpHeaders headers;

        try {
            headers = createHeaders();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return npe.getMessage();
        }

        //org.springframework.web.bind.MissingServletRequestParameterException

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String response = restTemplate.exchange("http://localhost:8080/login", HttpMethod.POST, entity, String.class).getBody();

        Map<String, String> jsonMap = objectMapper.readValue(response,
                new TypeReference<Map<String, String>>() {
                });
        jwtToken = jsonMap.get("token");

        return response;
    }

    @GetMapping(value = "/accounts", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getAccounts() {
        HttpHeaders headers;

        try {
            headers = createHeaders();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return npe.getMessage();
        }

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String response = restTemplate.exchange("http://localhost:8080/accounts", HttpMethod.GET, entity, String.class).getBody();
        return response;
    }

    @GetMapping(value = "/transactions", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getTransactions() {
        HttpHeaders headers;

        try {
            headers = createHeaders();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            return npe.getMessage();
        }

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String response = restTemplate.exchange("http://localhost:8080/transactions", HttpMethod.GET, entity, String.class).getBody();

        return response;
    }

    private HttpHeaders createLoginHeaders() throws NullPointerException {
        if (this.username == null) {
            throw new NullPointerException("Username must be specified on login.");
        }

        HttpHeaders loginHeaders = new HttpHeaders();
        loginHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        loginHeaders.set("username", username);
        return loginHeaders;
    }

    private HttpHeaders createHeaders() throws NullPointerException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        if (jwtToken == null) {
            throw new NullPointerException("Session token must not be null. Please login then try again.");
        }

        headers.set("X-AUTH", jwtToken);
        return headers;
    }

}