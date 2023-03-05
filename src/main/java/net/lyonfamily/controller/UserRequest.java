package net.lyonfamily.controller;


import com.fasterxml.jackson.annotation.JsonClassDescription;
import io.micronaut.core.annotation.Introspected;

@Introspected
@JsonClassDescription

public class UserRequest {
    private String fname;
    private String lname;
    private String phoneNumber;
    private int userID;

    public UserRequest(String fname, String lname, String phoneNumber){
        this.fname = fname;
        this.lname =lname;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setNumber(String number) {
        if (number != null && number.length() >=10){
            this.phoneNumber = number;
        }

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String name) {
        if(name != null){
            this.fname = name;
        }
    }

    public String getLname(){return lname;}

    public void setLname(String lastName){
        if (lastName != null){
            lname =lastName;
        }
    }



    @Override
    public String toString(){
        System.out.println(this.getLname());
        System.out.println(this.getFname());
        System.out.println(this.getPhoneNumber());

        return(
                this.getFname() + " " + this.getLname() + ": " + this.getPhoneNumber());
    }
}
