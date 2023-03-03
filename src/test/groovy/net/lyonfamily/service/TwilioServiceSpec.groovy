package net.lyonfamily.service

import com.twilio.rest.api.v2010.account.Message;
import io.micronaut.test.extensions.spock.annotation.MicronautTest;
import jakarta.inject.Inject;
import net.lyonfamily.services.TwilioService;
import spock.lang.Specification;

@MicronautTest
class TwilioServiceSpec extends Specification {

    @Inject
    TwilioService twilioService;

    void "test sending a text"() {

        when:
        String phoneNumber = '17634587416'
        String message = 'Hello'
        Message result = twilioService.sendTextMessage(phoneNumber, message)

        then:
        result.dateCreated != null
        result.status == 'queued'


        when:
        phoneNumber = '17634587416'
        message = 'Hello'
        result = twilioService.sendTextMessage(phoneNumber, message)

        then:
        result.dateCreated != null
        result.status == 'Sent'


    }

}
