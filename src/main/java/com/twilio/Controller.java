package com.twilio;

import com.twilio.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

    @Autowired
    private  TwilioService service;

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest){
        service.sensSms(smsRequest);

    }
}
