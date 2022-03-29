package at.itkolleg.ase.tdd.kino;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import at.itkolleg.ase.tdd.kino.Zeitfenster;

/**
 *
 * Dieses Beispiel stammt aus https://training.cherriz.de/cherriz-training/1.0.0/testen/junit5.html
 */
public class App 
{
    public static void main( String[] args )
    {
        //Saal anlegen
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        KinoSaal ks = new KinoSaal("LadyX",map);


        Vorstellung vs = new Vorstellung(ks, Zeitfenster.NACHMITTAG, LocalDate.of(2022, Month.DECEMBER, 12), "IMB", 20);
        Vorstellung vs2 = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2022, Month.DECEMBER, 12), "IMB2", 20);

        KinoVerwaltung kinoVerwaltung = new KinoVerwaltung();
        Ticket ticket = new Ticket(ks.getName(), vs.getZeitfenster(), LocalDate.of(2022, Month.DECEMBER, 12), 'A', 10);

        /*

        System.out.println(ticket.getReihe());
        System.out.println(ticket.getPlatz());
        System.out.println(ticket.getDatum());
        System.out.println(ticket.getSaal());
        System.out.println(ticket.getZeitfenster());

        */


        kinoVerwaltung.einplanenVorstellung(vs);
        kinoVerwaltung.einplanenVorstellung(vs2);
        kinoVerwaltung.kaufeTicket(vs,ticket.getReihe(), ticket.getPlatz(), 20);


        for (Vorstellung vorstellung : kinoVerwaltung.getVorstellungen() ){
            System.out.println(vorstellung.getFilm());
            System.out.println(vorstellung.getDatum());
            System.out.println(vorstellung.getZeitfenster());
            System.out.println(vorstellung.getSaal());
            System.out.println("------------------");
        }


        //Platz prüfen
        System.out.println(ks.pruefePlatz('A',11));
        System.out.println(ks.pruefePlatz('A',10));
        System.out.println(ks.pruefePlatz('B',10));
        System.out.println(ks.pruefePlatz('C',14));

        //...

    }
}
