package net.lyonfamily.controller;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestTest {

    public String fname = "Dan";
    public String lname = "doe";
    public String phoneNumber = "17636451112";
    UserRequest u1 = new UserRequest();



    @Test
    void setFNameToValidName(){ // Tests setting a valid name
        assertEquals(1,u1.setFname("Dan"));
    }

    @Test
    void setNullFname(){ //Tries setting an invalid name
        assertEquals(0,u1.setFname(null));
    }
    @Test
    void checkGetfname() {
        u1.setFname(fname);
        assertEquals(0,u1.getFname().compareTo(fname));
    }


    @Test
    void testGetLname(){
        u1.setLname(lname);
        assertEquals(0,u1.getLname().compareTo(lname));


    }

    @Test
    void testGetPhoneNumber() {
        u1.setNumber(phoneNumber);
        assertEquals(0, u1.getPhoneNumber().compareTo(phoneNumber));
    }

}