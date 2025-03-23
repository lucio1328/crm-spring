package com.lucio.crmspring.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    @JsonProperty("external_id")
    private String externalId;

    private String title;

    @JsonProperty("client")
    private String clientName;

    @JsonProperty("assignee")
    private String assigneeName;

    private Status status;

    private LocalDate deadline;

    @JsonProperty("created_at")
    private LocalDate createdAt;

    // Getters & Setters
    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getAssigneeName() { return assigneeName; }
    public void setAssigneeName(String assigneeName) { this.assigneeName = assigneeName; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Project{" +
                "externalId='" + externalId + '\'' +
                ", title='" + title + '\'' +
                ", client=" +  clientName + '\'' +
                ", assignee=" + assigneeName +'\'' +
                ", status=" + (status != null ? status.getTitle() : "null") +
                ", deadline=" + deadline +
                ", createdAt=" + createdAt +
                '}';
    }
}
