package org.example.classes;

import org.example.enums.IndustryOption;

import java.util.List;

public class Account {
    private int id;
    private static int counter = 0;
    private IndustryOption industryOption;
    private int employeeCount;
    private String city;
    private String country;
    private List<Opportunity> opportunityList;
    private List<Contact> contactList;


    public Account(IndustryOption industryOption, int employeeCount, String city, String country, List<Opportunity> opportunityList, List<Contact> contactList) {
        setIndustryOption(industryOption);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setOpportunityList(opportunityList);
        setContactList(contactList);
        counter++;
        this.id=counter;
    }

    public int getId() {
        return id;
    }

    public IndustryOption getIndustryOption() {
        return industryOption;
    }

    public void setIndustryOption(IndustryOption industryOption) {
        this.industryOption = industryOption;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
