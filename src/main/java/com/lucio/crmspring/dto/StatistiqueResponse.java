package com.lucio.crmspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatistiqueResponse {
    private int clients = 0;
    private int projets = 0;
    private int taches = 0;
    private int offres = 0;
    private int factures = 0;
    private int paiements = 0;

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public int getProjets() {
        return projets;
    }

    public void setProjets(int projets) {
        this.projets = projets;
    }

    public int getTaches() {
        return taches;
    }

    public void setTaches(int taches) {
        this.taches = taches;
    }

    public int getOffres() {
        return offres;
    }

    public void setOffres(int offres) {
        this.offres = offres;
    }

    public int getFactures() {
        return factures;
    }

    public void setFactures(int factures) {
        this.factures = factures;
    }

    public int getPaiements() {
        return paiements;
    }

    public void setPaiements(int paiements) {
        this.paiements = paiements;
    }
}
