package models;

public class Kampplaats {
    private String adres;
    private int maximumcapaciteit;
    private String[] faciliteiten;

    public Kampplaats(String adres, int maximumcapaciteit, String[] faciliteiten) {
        this.adres = adres;
        this.maximumcapaciteit = maximumcapaciteit;
        this.faciliteiten = faciliteiten;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getMaximumcapaciteit() {
        return maximumcapaciteit;
    }

    public void setMaximumcapaciteit(int maximumcapaciteit) {
        this.maximumcapaciteit = maximumcapaciteit;
    }

    public String[] getFaciliteiten() {
        return faciliteiten;
    }

    public void setFaciliteiten(String[] faciliteiten) {
        this.faciliteiten = faciliteiten;
    }
}
