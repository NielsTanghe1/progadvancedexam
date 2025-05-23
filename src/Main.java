import models.Kamp;
import models.Kampplaats;
import models.personen.Lid;
import models.personen.Personeelslid;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
public ArrayList<Lid> leden = new ArrayList<>();
public ArrayList<Personeelslid> personeelsLeden = new ArrayList<>();
public ArrayList<Kampplaats> kampPlaatsen = new ArrayList<>();
public ArrayList<Kamp> kampen = new ArrayList<>();

public static boolean stopApp = false;

//Maakt default objecten aan
public void maakTestData() {
    //Kampplaatsen
    String[] testFaciliteiten = {"WC", "Douche", "Keuken"};
    Kampplaats plaats1 = new Kampplaats("Hanenbos", 120, testFaciliteiten);
    Kampplaats plaats2 = new Kampplaats("Stroppen", 90, testFaciliteiten);
    kampPlaatsen.add(plaats1);
    kampPlaatsen.add(plaats2);
    System.out.println("Default kampplaatsen:");
    for (Kampplaats kampplaats : kampPlaatsen) {
        System.out.println(kampplaats.getAdres());
    }
    //Kampen
    Kamp kamp1 = new Kamp("Cool kamp", plaats1, 7);
    Kamp kamp2 = new Kamp("Mega cool kamp", plaats1, 14);
    Kamp kamp3 = new Kamp("Minder cool kamp", plaats2, 7);
    Kamp kamp4 = new Kamp("Beetje cool kamp", plaats2, 10);
    kampen.add(kamp1);
    kampen.add(kamp2);
    kampen.add(kamp3);
    kampen.add(kamp4);
    System.out.println("Default kampen:");
    for (Kamp kamp : kampen) {
        System.out.println(kamp.getKampnaam());
    }

    //Leden
    Lid lid1 = new Lid(2006, "Kerkstraat 10 Leuven", "Jan");
    Lid lid2 = new Lid(2008, "Sesamstraat 130 Brussel", "Bert");
    Lid lid3 = new Lid(2005, "Steenlaan 3 Mechelen", "Emma");
    Lid lid4 = new Lid(2009, "Langebroekweg 140 Gent", "Sofie");
    leden.add(lid1);
    leden.add(lid2);
    leden.add(lid3);
    leden.add(lid4);
    System.out.println("Default leden:");
    for (Lid lid : leden) {
        System.out.println(lid.getNaam());
    }

    //Personeelsleden
    Personeelslid personeelslid1 = new Personeelslid(1997, "Lippenslaan 9 Knokke", "Joel", "Begeleider");
    Personeelslid personeelslid2 = new Personeelslid(1993, "Strandstraat 93 Oostende", "Jan", "Begeleider");
    Personeelslid personeelslid3 = new Personeelslid(2001, "Nieuwstraat 23 Brussel", "Jeff", "Kok");
    Personeelslid personeelslid4 = new Personeelslid(2003, "Steenstraat 2 Diest", "Sara", "Verpleegster");
    personeelsLeden.add(personeelslid1);
    personeelsLeden.add(personeelslid2);
    personeelsLeden.add(personeelslid3);
    personeelsLeden.add(personeelslid4);
    System.out.println("Default personeelsleden:");
    for (Personeelslid personeelslid : personeelsLeden) {
        System.out.println(personeelslid.getNaam());
    }
}
//checkt of list een object met de gegeven naam bevat
public boolean containsName(String name) {
    AtomicBoolean found = new AtomicBoolean(false);
    leden.forEach((l) -> {
        if(l.getNaam().equalsIgnoreCase(name)){
            found.set(true);
            System.out.println("Lid gevonden = " + found);
        }
    });
    return found.get();
}
//Vraagt userinput voor de faciliteiten van een kammplaats en checkt op ongeldige invoer
public String[] FaciliteitenInput() {
    ArrayList<String> faciliteiten = new ArrayList<>();

    // Take user elements for the array
    Scanner input = new Scanner(System.in);
    String nieuwefaciliteit;
    do {
        System.out.println("Geef faciliteit in (Geef 0 in om te af te ronden): ");
        nieuwefaciliteit = input.nextLine();
        if (nieuwefaciliteit == "0") {
            System.out.println("Kampplaats is aangemaakt.");
        } else {
            System.out.println("Faciliteit is toegevoegt.");
            faciliteiten.add(nieuwefaciliteit);
        }
    } while (!Objects.equals(nieuwefaciliteit, "0"));

    String[] arr = new String[faciliteiten.size()];
    faciliteiten.removeLast(); //removes the 0
    arr = faciliteiten.toArray(arr);

    System.out.println("De faciliteiten zijn: ");
    System.out.println(faciliteiten);

    return arr;
}
//Zoekt voor een lid op naam
public Lid vindLid(String naam, List<Lid> leden) {
    Lid tezoeken = null;
    for (Lid lid : leden) {
        if (lid.getNaam().equals(naam)) {
            tezoeken = lid;
        }
    }
    return tezoeken;
}
//Zoekt voor een personeelslid op naam
public Personeelslid vindPersoneelsLid(String naam, List<Personeelslid> personeelsleden) {
    for (Personeelslid personeelslid : personeelsleden) {
        if (personeelslid.getNaam().equals(naam)) {
            return personeelslid;
        }
    }
    return null;
}
//Toont het meerkeuze-menu
public int menu() {

    int keuze;
    Scanner input = new Scanner(System.in);

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
public void maakNiewLid() {
    String naam;
    String adres;
    int geboortejaar;

    Scanner input = new Scanner(System.in);
    try{
    System.out.println("Naam lid:");
    naam = input.nextLine();
    System.out.println("Adres lid:");
    adres = input.nextLine();
    System.out.println("Geboortejaar:");
    geboortejaar = input.nextInt();

    Lid nieuwLid = new Lid(geboortejaar, adres, naam);
    leden.add(nieuwLid);
    }catch(Exception e){
        System.out.println(e + " Ongeldige waarde, lid niet aangemaakt.");
    }


}
//Maken van een nieuw persoeelslid via user input
public void maakNiewPersoneelslid() {
    Scanner input = new Scanner(System.in);

    try {
        String naam;
        String adres;
        String taak;
        int geboortejaar;

        System.out.println("Naam personeelslid:");
        naam = input.nextLine().toUpperCase();
        System.out.println("Adres personeelslid:");
        adres = input.nextLine();
        System.out.println("Taak:");
        taak = input.nextLine();
        System.out.println("Geboortejaar:");
        geboortejaar = input.nextInt();

        Personeelslid nieuwPersoneelsLid = new Personeelslid(geboortejaar, adres, naam, taak);
        personeelsLeden.add(nieuwPersoneelsLid);
    } catch (Exception e) {
        System.out.println(e+ " Ongeldige input, personeelslid niet aangemaakt. Probeer opnieuw.");
    }


}
//Maken van een nieuwe kampplaats via user input
public void maakNieweKampplaats() {
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
public void maakNiewKamp() {
    String naam;
    int duur;

    Scanner input = new Scanner(System.in);

    System.out.println("Kampnaam:");
    naam = input.nextLine();
    System.out.println("Kies kamplaats:");
    final int[] keuzeplaats = {0};
    kampPlaatsen.forEach(kampplaats -> {
        keuzeplaats[0]++;
        System.out.println(keuzeplaats[0] + ". " + kampplaats.getAdres() + "Capaciteit: " + kampplaats.getMaximumcapaciteit());
    });
    Kampplaats locatie = kampPlaatsen.get(input.nextInt() - 1);

    System.out.println("Duur van kamp in dagen:");
    duur = input.nextInt();

    Kamp nieuwKamp = new Kamp(naam, locatie, duur);
    kampen.add(nieuwKamp);
}
//Voegt personeelsleden toe aan een kamp naar keuze
public void voegPersoneelsledenToeAanKamp() {
    // Take user elements for the array
    Scanner input = new Scanner(System.in);
    // Array om toegevoegde leden op te slaan
    ArrayList<Personeelslid> addedpersoneelsleden = new ArrayList<>();

    System.out.println("Kies kamp:");
    final int[] keuzekamp = {0};
    kampen.forEach(kamp -> {
        keuzekamp[0]++;
        System.out.println(keuzekamp[0] + ". " + kamp.getKampnaam() + "Lengte: " + kamp.getLengte());
    });
    Kamp selectedKamp = kampen.get(input.nextInt() - 1);

    System.out.println("Hoeveel personeelsleden wil je toevoegen (max " + personeelsLeden.size() + "):");
    int hoeveel = 1;
    boolean geldig = false;
    try {
        hoeveel = input.nextInt();
        if (hoeveel >= 1 && hoeveel <= personeelsLeden.size()) {
            geldig = true;
        }
    }catch (Exception e) {
        System.out.println("Ongeldige hoeveelheid");
    }

    String naampersoneelslid;
    if (geldig) {
        try {
            for (int i = 0; i < hoeveel; i++) {
                System.out.println("Geef naam personeelslid "+ (i+1) +":");
                naampersoneelslid = input.nextLine();
                if (containsName(naampersoneelslid)) {
                    addedpersoneelsleden.add(vindPersoneelsLid(naampersoneelslid, personeelsLeden));
                    System.out.println(naampersoneelslid + " is toegevoegd.");
                }else {
                    System.out.println(naampersoneelslid + " is niet toegevoegd, personeelslid bestaat niet.");
                }
            }
        }catch (Exception e) {
            System.out.println("Ongeldige input");
        }
    }

    System.out.println("Volgende personeelsleden zijn toegevoegd.");
    addedpersoneelsleden.forEach(personeelslid -> {
        System.out.println(personeelslid.getNaam());
    });

    Personeelslid[] arr = new Personeelslid[addedpersoneelsleden.size()];

    arr = addedpersoneelsleden.toArray(arr);

    System.out.println("De toegevoegde personeelsleden zijn: ");
    System.out.println(Arrays.toString(arr));

    selectedKamp.setPersoneel(arr);
}
//Voegt leden toe aan een kamp naar keuze
public void voegLedenToeAanKamp() {
    // Take user elements for the array
    Scanner input = new Scanner(System.in);

    System.out.println("Kies kamp:");
    Kamp selectedKamp = new Kamp("placeholder", null, 0);
    try{
        final int[] keuzekamp = {0};
        kampen.forEach(kamp -> {
            keuzekamp[0]++;
            System.out.println(keuzekamp[0] + ". " + kamp.getKampnaam() + "Lengte: " + kamp.getLengte());
        });
        selectedKamp = kampen.get(input.nextInt() - 1);
    }catch (Exception e) {
        System.out.println("Ongeldige input, actie geannuleerd.");
    }


    ArrayList<Lid> addedleden = new ArrayList<>();
    int hoeveel = 1;
    boolean geldig = false;
    try {
        System.out.println("Hoeveel leden wil je toevoegen (max " + leden.size() + "):");
        hoeveel = input.nextInt();
        if (hoeveel >= 1 && hoeveel <= leden.size()) {
            geldig = true;
        }
    }catch (Exception e) {
        System.out.println("Ongeldige hoeveelheid");
    }

    String naamlid;
    if (geldig) {
        try {
            for (int i = 0; i < hoeveel; i++) {
                System.out.println("Geef naam lid "+ (i+1) +":");
                naamlid = input.nextLine();
                if (containsName(naamlid)) {
                    addedleden.add(vindLid(naamlid, leden));
                    System.out.println(naamlid + " is toegevoegd.");
                }else {
                    System.out.println(naamlid + " is niet toegevoegd, lid bestaat niet.");
                }
            }
        }catch (Exception e) {
            System.out.println("Ongeldige input");
        }
    }

    System.out.println("Volgende leden zijn toegevoegd.");
    addedleden.forEach(lid -> {
        System.out.println(lid.getNaam());
    });

    Lid[] arr = new Lid[addedleden.size()];

    arr = addedleden.toArray(arr);

    System.out.println("De toegevoegde leden zijn: ");
    System.out.println(Arrays.toString(arr));

    selectedKamp.setLeden(arr);
}
//Print alle info van een kamo uit naar een bestand
public void printKampInfo () {
    try {
        Scanner input = new Scanner(System.in);

        final int[] keuze = {0};
        System.out.println("Kies kamp.");
        kampen.forEach(kamp -> {
            keuze[0]++;
            System.out.println(keuze[0] + ". " + kamp.getKampnaam());
        });
        Kamp kamp = kampen.get(input.nextInt() - 1);
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("kamp.data")
        )) {
            output.writeObject(kamp);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } catch (Exception e) {
        System.out.println(e);
    }
}

public void main() {
    maakTestData();
    do {
        try {
            switch (menu()) {
                case 0:
                    stopApp = true;
                    break;
                case 1:
                    maakNiewPersoneelslid();
                    break;
                case 2:
                    maakNiewLid();
                    break;
                case 3:
                    maakNieweKampplaats();
                    break;
                case 4:
                    maakNiewKamp();
                    break;
                case 5:
                    voegPersoneelsledenToeAanKamp();
                    break;
                case 6:
                    voegLedenToeAanKamp();
                    break;
                case 7:
                    printKampInfo();
                    break;
                default:
                    break;
            }
        }catch (Exception e) {
            System.out.println("Ongeldige input");
        }

    } while (!stopApp);
}