package com.twilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Data
@ToString
public class SmsRequest {

    private final String phoneNumber;
    private final String message;

    public  SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                       @JsonProperty("message") String message){
        this.phoneNumber=phoneNumber;
        this.message=message;
    }


}
