package com.lucio.crmspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInfo {
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    public ContactInfo() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

