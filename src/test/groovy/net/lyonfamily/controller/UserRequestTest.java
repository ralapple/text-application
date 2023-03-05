package net.lyonfamily.controller;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestTest {
    public String fname = "mike";
    public String lname = "doe";
    public String phoneNumber = "17636451112";
    UserRequest u1 = new UserRequest(fname,lname, phoneNumber);



    @Test
    void settingInvalidfName(){
        //Trying to set a null first name
        u1.setFname(null);

        // fnames should be the same since the name isnt updated
        assertEquals(0,u1.getFname().compareTo(fname));
    }


    @Test
    void settingInvalidlName(){
        //Trying to set a null last name
        u1.setLname(null);

        // lnames should be the same since the name isnt updated
        assertEquals(0,u1.getLname().compareTo(lname));
    }

    @Test
    void setNullNumber() {
        u1.setNumber(null);
        assertEquals(0,u1.getPhoneNumber().compareTo(phoneNumber));
    }

    @Test
    void setTooShortNumber(){
        u1.setNumber("19284");
        assertEquals(0,u1.getPhoneNumber().compareTo(phoneNumber));
    }

}