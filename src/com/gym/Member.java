package com.gym;

public class Member {
    private int id;
    private String name;
    private int age;
    private String renewalDate;

    public Member(int id, String name, int age, String renewalDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.renewalDate = renewalDate;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getRenewalDate() { return renewalDate; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setRenewalDate(String renewalDate) { this.renewalDate = renewalDate; }
}
