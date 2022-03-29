package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVorstellung {

    private KinoVerwaltung kinoVerwaltung;
    private Ticket ticket;
    private Vorstellung vs;
    private KinoSaal ks;

    @BeforeEach
    void setup(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);

        ks = new KinoSaal("LadyX", map);
        ticket = new Ticket(ks.getName(), Zeitfenster.ABEND, LocalDate.of(2022, Month.DECEMBER, 12), 'A', 10);
        kinoVerwaltung = new KinoVerwaltung();
        vs = new Vorstellung(ks, ticket.getZeitfenster(), ticket.getDatum(), "IMB", 20);

    }

    @Test
    void testKaufeTicket(){
        Ticket testTicket = kinoVerwaltung.kaufeTicket(vs, ticket.getReihe(), ticket.getPlatz(), 20);
        assertEquals(ticket.getPlatz(), testTicket.getPlatz());
        assertEquals(ticket.getReihe(), testTicket.getReihe());
        assertEquals(ticket.getDatum(), testTicket.getDatum());
        assertEquals(ticket.getSaal(), testTicket.getSaal());
        assertEquals(ticket.getZeitfenster(), testTicket.getZeitfenster());
    }

    @Test
    void testGetFilm(){
        assertEquals("IMB", vs.getFilm());
    }

    @Test
    void testGetSaal(){
        assertEquals(ks, vs.getSaal());
    }

    @Test
    void testGetZeitfenster(){
        assertEquals(Zeitfenster.ABEND, vs.getZeitfenster());
    }

    @Test
    void testGetDatum(){
        assertEquals(LocalDate.of(2022, Month.DECEMBER, 12), vs.getDatum());
    }

}
