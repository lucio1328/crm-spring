package com.lucio.crmspring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("external_id")
    private String externalId;
    private String name;
    private String email;
    private String address;

    @JsonProperty("primary_number")
    private String primaryNumber;

    @JsonProperty("secondary_number")
    private String secondaryNumber;

    private String language;

    @JsonProperty("deleted_at")
    private String deletedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    private String avatar;

    // Getters et setters
    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPrimaryNumber() { return primaryNumber; }
    public void setPrimaryNumber(String primaryNumber) { this.primaryNumber = primaryNumber; }

    public String getSecondaryNumber() { return secondaryNumber; }
    public void setSecondaryNumber(String secondaryNumber) { this.secondaryNumber = secondaryNumber; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getDeletedAt() { return deletedAt; }
    public void setDeletedAt(String deletedAt) { this.deletedAt = deletedAt; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}
