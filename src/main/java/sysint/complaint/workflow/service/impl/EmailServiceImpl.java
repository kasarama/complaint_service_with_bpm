package sysint.complaint.workflow.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import sysint.complaint.workflow.model.EmailDataDTO;
import sysint.complaint.workflow.service.EmailService;

public class EmailServiceImpl implements EmailService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String EMAIL_SERVICE_URI = "http://localhost:8090/emails/message";

    @Override
    public String sendEmail(EmailDataDTO emailData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> mediaTypeList = new ArrayList();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypeList);
        HttpEntity<EmailDataDTO> request =
                new HttpEntity<>(emailData, headers);
        try {
            String response = restTemplate.postForObject(EMAIL_SERVICE_URI, request, String.class);
            System.out.println(response);
            return response;

        } catch (Exception e) {
            //TODO add valid uri for email service, handle exception
            e.printStackTrace();
            return "Sending not working";
        }
    }
}
