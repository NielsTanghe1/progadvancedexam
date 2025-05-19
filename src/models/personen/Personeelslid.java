package models.personen;

public class Personeelslid extends Persoon {
    private String taak;

    public Personeelslid(int geboortejaar, String adres, String naam, String taak) {
        super(geboortejaar, adres, naam);
        this.taak = taak;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }
}
