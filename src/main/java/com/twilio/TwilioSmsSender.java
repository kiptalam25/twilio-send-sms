package com.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {


    private final static Logger LOGGER= LoggerFactory.getLogger(TwilioSmsSender.class);
    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioSmsSender(TwilioConfig twilioConfig){
        this.twilioConfig=twilioConfig;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {
        PhoneNumber to =new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
if(isPhoneNumberValid(smsRequest.getPhoneNumber())) {
    MessageCreator creator = Message.creator(
            to,
            from,
            smsRequest.getMessage());
    creator.create();
    LOGGER.info("Send sms {} "+ smsRequest);
}
else{
    throw new IllegalArgumentException("Phone Number "+smsRequest.getPhoneNumber()+"is  Not a Valid Number");
}
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
