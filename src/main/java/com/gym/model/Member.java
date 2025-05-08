package com.gym.model;

public class Member {
    private String name;
    private String renewalDate;

    public Member(String name, String renewalDate) {
        this.name = name;
        this.renewalDate = renewalDate;
    }

    public String getName() {
        return name;
    }

    public String getRenewalDate() {
        return renewalDate;
    }
}
