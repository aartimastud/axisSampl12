package com.training.entities;

public class Customer {
    int customerId;
    String cName;
    String cEmail;
    String cAddress;
    String CPhone;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCPhone() {
        return CPhone;
    }

    public void setCPhone(String CPhone) {
        this.CPhone = CPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", cName='" + cName + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", CPhone='" + CPhone + '\'' +
                '}';
    }
}
