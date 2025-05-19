package models.personen;

public class Persoon {
    public String naam, adres;
    public int geboortejaar;

    public Persoon(int geboortejaar, String adres, String naam) {
        this.geboortejaar = geboortejaar;
        this.adres = adres;
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}

