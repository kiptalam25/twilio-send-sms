package com.twilio.service;

import com.twilio.SmsRequest;
import com.twilio.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    private final TwilioSmsSender twilioSmsSender;
    @Autowired
    public TwilioService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender){
        this.twilioSmsSender=twilioSmsSender;
    }

    public void sensSms(SmsRequest smsRequest){
        twilioSmsSender.sendSms(smsRequest);
    }
}
