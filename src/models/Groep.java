package models;

import models.personen.Lid;
import models.personen.Personeelslid;

public class Groep {
    private String naam;
    private int minimumleeftijd;
    private int maximumleeftijd;
    private Lid[] leden;
    private Personeelslid[] begeleiders;

    public Groep(String naam, int minimumleeftijd, int maximumleeftijd, Lid[] leden, Personeelslid[] begeleiders) {
        this.naam = naam;
        this.minimumleeftijd = minimumleeftijd;
        this.maximumleeftijd = maximumleeftijd;
        this.leden = leden;
        this.begeleiders = begeleiders;
    }

    public int getMinimumleeftijd() {
        return minimumleeftijd;
    }

    public void setMinimumleeftijd(int minimumleeftijd) {
        this.minimumleeftijd = minimumleeftijd;
    }

    public Lid[] getLeden() {
        return leden;
    }

    public void setLeden(Lid[] leden) {
        this.leden = leden;
    }

    public int getMaximumleeftijd() {
        return maximumleeftijd;
    }

    public void setMaximumleeftijd(int maximumleeftijd) {
        this.maximumleeftijd = maximumleeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Personeelslid[] getBegeleiders() {
        return begeleiders;
    }
    public void setBegeleiders(Personeelslid[] begeleiders) {
        this.begeleiders = begeleiders;
    }
}
