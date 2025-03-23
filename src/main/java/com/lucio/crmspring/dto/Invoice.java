package com.lucio.crmspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    @JsonProperty("client")
    private Client client;

    @JsonProperty("contact_info")
    private ContactInfo contactInfo;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @JsonProperty("sent_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String sentAt;

    @JsonProperty("due_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dueAt;

    @JsonProperty("amount_due")
    private String amountDue;

    @JsonProperty("status")
    private String status;

    @JsonProperty("invoice_number")
    private String invoiceNumber;

    @JsonProperty("source")
    private Map<String, String> source; // Peut contenir "reference" et "url"

    @JsonProperty("offer")
    private Map<String, String> offer; // Peut contenir "external_id"

    public Invoice() {}

    // Getters et Setters
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public ContactInfo getContactInfo() { return contactInfo; }
    public void setContactInfo(ContactInfo contactInfo) { this.contactInfo = contactInfo; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public String getSentAt() { return sentAt; }
    public void setSentAt(String sentAt) { this.sentAt = sentAt; }

    public String getDueAt() { return dueAt; }
    public void setDueAt(String dueAt) { this.dueAt = dueAt; }

    public String getAmountDue() { return amountDue; }
    public void setAmountDue(String amountDue) { this.amountDue = amountDue; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public Map<String, String> getSource() { return source; }
    public void setSource(Map<String, String> source) { this.source = source; }

    public Map<String, String> getOffer() { return offer; }
    public void setOffer(Map<String, String> offer) { this.offer = offer; }
}
