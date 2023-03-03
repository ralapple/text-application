package net.lyonfamily.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class TwilioService {
    private static final Logger logger = LoggerFactory.getLogger(TwilioService.class);

    @Value("${twilio.account-sid}")
    protected String accountSid;

    @Value("${twilio.auth-token}")
    protected String authToken;

    @Value("${twilio.phone-number}")
    protected String sendingPhoneNumber;

    public Message sendTextMessage(String phoneNumber, String text) {

        logger.info(phoneNumber);
        logger.info(text);
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber(sendingPhoneNumber),
                        text)
                .create();

        logger.info(message.toString());

        return message;


    }

    public int sendGroup(String[] numbers, String text) {
        int i =0;
        if (numbers == null || text == null){
            return 0;
        }else{
            while(numbers[i]!= null){
                Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(numbers[i]),
                        new com.twilio.type.PhoneNumber(sendingPhoneNumber),
                        text).create();
                logger.info(message.toString());
                i++;
            }
            return 1;
        }
    }


    String getAccountSid() {
        return accountSid;
    }

    String getAuthToken() {
        return authToken;
    }

}
