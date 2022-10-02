package com.example.workflow.service.impl;

import com.example.workflow.model.EmailDataDTO;
import com.example.workflow.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class EmailServiceImpl implements EmailService {
    @Autowired
    private RestTemplate restTemplate;

    private final String EmailServiceURI = "";

    @Override
    public String sendEmail(EmailDataDTO emailData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> mediaTypeList = new ArrayList();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypeList);
        HttpEntity<EmailDataDTO> request =
                new HttpEntity<>(emailData, headers);
//        try {
//            String response = restTemplate.postForObject(EmailServiceURI, request, String.class);
//            return response;
//
//        } catch (Exception e) {
//            //TODO add valid uri for email service, handle exception
//            e.printStackTrace();
//
//            return "Email service is not implemented ";
//        }
        System.out.println("Sending not working");
        System.out.println(emailData.getBody());
        return "Sending not working";
    }
}
