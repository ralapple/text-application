package net.lyonfamily.controller;

import com.twilio.rest.api.v2010.account.Message;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import net.lyonfamily.services.TwilioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExecuteOn(TaskExecutors.IO)
@Controller("/texting")
public class TextingController {

    private static final Logger logger = LoggerFactory.getLogger(TextingController.class);

    @Inject
    TwilioService twilioService;



    //Get all text sent from database
    @Get(uri = "/")
    public HttpResponse<String> index() {
        logger.info("Inside GET of TextingController");
        return HttpResponse.ok("Response from index");
    }

    @Post(uri = "/", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<TextResponse> sendTextMessage(@Body TextRequest textRequest) {
        logger.info("Sending sendTextMessage");
        logger.info("TextRequest: " + textRequest.toString());

        Message messageResponse = twilioService.sendTextMessage(textRequest.getToPhoneNumber(), textRequest.getText());

        TextResponse response = new TextResponse(messageResponse);

        return HttpResponse.ok(response);
    }



}