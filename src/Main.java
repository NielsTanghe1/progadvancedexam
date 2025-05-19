import models.Kamp;
import models.Kampplaats;
import models.personen.Lid;
import models.personen.Personeelslid;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Lid> leden = new ArrayList<>();
    public static ArrayList<Personeelslid> personeelsLeden = new ArrayList<>();
    public static ArrayList<Kampplaats> kampPlaatsen = new ArrayList<>();
    public static ArrayList<Kamp> kampen = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    public static boolean stopApp = false;

    //Vraagt userinput voor de faciliteiten van een kammplaats en checkt op ongeldige invoer
    public static String[] FaciliteitenInput(){
        ArrayList<String> faciliteiten = new ArrayList<>();

            // Take user elements for the array
        String nieuwefaciliteit;
        do{
            System.out.println("Geef faciliteit in (Geef 0 in om te af te ronden): ");
            nieuwefaciliteit = input.nextLine();
            if(Objects.equals(nieuwefaciliteit, "0")){
                System.out.println("Kampplaats is aangemaakt.");
            }else{
                System.out.println("Faciliteit is toegevoegt.");
                faciliteiten.add(nieuwefaciliteit);
            }
;
        }while(!Objects.equals(nieuwefaciliteit, "0"));

        String[] arr = new String[faciliteiten.size()];
        arr = faciliteiten.toArray(arr);

        System.out.println("De faciliteiten zijn: ");
        System.out.println(faciliteiten);

        return arr;
    }

    //Zoekt voor een lid op naam
    public static Lid vindLid(String naam, List<Lid> leden) {
        Iterator<Lid> iterator = leden.iterator();
        while (iterator.hasNext()) {
            Lid lid = iterator.next();
            if (lid.getNaam().equals(naam)) {
                return lid;
            }
        }
        return null;
    }
    //Zoekt voor een personeelslid op naam
    public static Personeelslid vindPersoneelsLid(String naam, List<Personeelslid> personeelsleden) {
        Iterator<Personeelslid> iterator = personeelsleden.iterator();
        while (iterator.hasNext()) {
            Personeelslid personeelslid = iterator.next();
            if (personeelslid.getNaam().equals(naam)) {
                return personeelslid;
            }
        }
        return null;
    }

    //Toont het meerkeuze-menu
    public static int menu() {

        int keuze;


        /***************************************************/

        System.out.println("Maak je keuze:");
        System.out.println("-------------------------\n");
        System.out.println("1 - Maak nieuw personeelslid aan");
        System.out.println("2 - Maak nieuw lid aan");
        System.out.println("-------------------------\n");
        System.out.println("3 - Maak nieuwe kampplaats aan");
        System.out.println("4 - Maak nieuw kamp aan");
        System.out.println("-------------------------\n");
        System.out.println("5 - Voeg personeel toe aan een kamp");
        System.out.println("6 - Schrijf lid in in een kamp");
        System.out.println("-------------------------\n");
        System.out.println("7 - Print kampinfo uit");
        System.out.println("-------------------------\n");
        System.out.println("0 - Stop applicatie");

        keuze = input.nextInt();
        return keuze;
    }

    //Maken van een nieuw lid via user input
    public static void maakNiewLid() {
        String naam;
        String adres;
        int geboortejaar;

        Scanner input = new Scanner(System.in);

        System.out.println("Naam lid:");
        naam = input.nextLine();
        System.out.println("Adres lid:");
        adres = input.nextLine();
        System.out.println("Geboortejaar:");
        geboortejaar = input.nextInt();

        Lid nieuwLid = new Lid(geboortejaar, adres, naam);
        leden.add(nieuwLid);
    }
    //Maken van een nieuw persoeelslid via user input
    public static void maakNiewPersoneelslid(){
        String naam;
        String adres;
        String taak;
        int geboortejaar;

        Scanner input = new Scanner(System.in);

        System.out.println("Naam personeelslid:");
        naam = input.nextLine();
        System.out.println("Adres personeelslid:");
        adres = input.nextLine();
        System.out.println("Geboortejaar:");
        geboortejaar = input.nextInt();
        System.out.println("Taak:");
        taak = input.nextLine();

        Personeelslid nieuwPersoneelsLid = new Personeelslid(geboortejaar, adres, naam, taak);
        personeelsLeden.add(nieuwPersoneelsLid);
    }
    //Maken van een nieuwe kampplaats via user input
    public static void maakNieweKampplaats(){
        ArrayList<String> faciliteiten = new ArrayList<String>();
        String adres;
        int maximumcapaciteit;

        Scanner input = new Scanner(System.in);

        System.out.println("Adres kampplaats:");
        adres = input.nextLine();
        System.out.println("Maximumcapaciteit kampplaats:");
        maximumcapaciteit = input.nextInt();
        String[] faciliteitenArray = FaciliteitenInput();

        Kampplaats nieuweKampplaats = new Kampplaats(adres, maximumcapaciteit, faciliteitenArray);
        kampPlaatsen.add(nieuweKampplaats);
    }
    //Maken van een nieuw kamp via user input
    public static void maakNiewKamp(){
        String naam;
        int duur;
        ArrayList<Lid> ingeschrevenLeden = new ArrayList<>();
        ArrayList<Personeelslid> ingeschrevenPersoneelseden = new ArrayList<>();
        boolean stop = false;

        Scanner input = new Scanner(System.in);

        System.out.println("Kampnaam:");
        naam = input.nextLine();
        System.out.println("Kies kamplaats:");
        final int[] keuzeplaats = {0};
        kampPlaatsen.forEach(kampplaats -> {
            keuzeplaats[0]++;
            System.out.println(keuzeplaats[0] + ". " + kampplaats.getAdres() + "Capaciteit: " + kampplaats.getMaximumcapaciteit());
        });
        Kampplaats locatie = kampPlaatsen.get(input.nextInt()-1);

        System.out.println("Duur van kamp in dagen:");
        duur = input.nextInt();

        Kamp nieuwKamp = new Kamp(naam, locatie, duur);
    }

    public static void main(String[] args) {
        do{
            switch (menu()){
                case 0: stopApp=true;
                    break;
                case 1: maakNiewPersoneelslid();
                    break;
                case 2: maakNiewLid();
                    break;
                case 3: maakNieweKampplaats();
                    break;
                case 4: maakNiewKamp();
                    break;
                default:
                    break;
            }
        }while(!stopApp);
    }
}