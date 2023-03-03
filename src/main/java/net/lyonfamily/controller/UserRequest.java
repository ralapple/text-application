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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setNumber(String number) {
        this.phoneNumber = number;
    }

    public String getFname() {
        return fname;
    }

    public int setFname(String name) {
        if(name != null){
            this.fname = name;
            return 1;

        }
        return 0;
    }

    public String getLname(){return lname;}

    public void setLname(String lastName){lname =lastName;}



    @Override
    public String toString(){
        System.out.println(this.getLname());
        System.out.println(this.getFname());
        System.out.println(this.getPhoneNumber());

        return(
                this.getFname() + " " + this.getLname() + ": " + this.getPhoneNumber());
    }
}
