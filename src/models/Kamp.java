package models;

import models.personen.Lid;
import models.personen.Personeelslid;

import java.io.Serializable;

public class Kamp implements Serializable {
    private String kampnaam;
    private Kampplaats kampplaats;
    private int lengte;
    private Lid[] leden;
    private Personeelslid[] personeel;

    public Kamp(String kampnaam, Kampplaats kampplaats, int lengte) {
        this.kampnaam = kampnaam;
        this.kampplaats = kampplaats;
        this.lengte = lengte;
    }

    public Kamp(String kampnaam, Kampplaats kampplaats, int lengte, Lid[] leden, Personeelslid[] personeel) {
        this.kampnaam = kampnaam;
        this.kampplaats = kampplaats;
        this.lengte = lengte;
        this.leden = leden;
        this.personeel = personeel;
    }

    public String getKampnaam() {
        return kampnaam;
    }

    public void setKampnaam(String kampnaam) {
        this.kampnaam = kampnaam;
    }

    public Kampplaats getKampplaats() {
        return kampplaats;
    }

    public void setKampplaats(Kampplaats kampplaats) {
        this.kampplaats = kampplaats;
    }

    public Lid[] getLeden() {
        return leden;
    }

    public void setLeden(Lid[] leden) {
        this.leden = leden;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public Personeelslid[] getPersoneel() {
        return personeel;
    }

    public void setPersoneel(Personeelslid[] personeel) {
        this.personeel = personeel;
    }

    @Override
    public String toString() {
        return "Kamp info{" +
                "Naam: " + kampnaam +
                ", Kampplaats: " + kampplaats.getAdres() +
                ", lengte: " + lengte +
                '}';
    }
}
