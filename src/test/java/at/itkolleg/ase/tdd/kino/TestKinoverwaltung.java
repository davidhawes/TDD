package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestKinoverwaltung {

    private KinoSaal ksl;
    private Vorstellung vs;
    private KinoVerwaltung kvw;

    @BeforeEach
    void setup() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        ksl = new KinoSaal("TestSaal", map);
        vs = new Vorstellung(ksl, Zeitfenster.ABEND, LocalDate.of(2022, Month.DECEMBER, 12), "IMB2", 20);
        kvw = new KinoVerwaltung();
    }

    @Test
    void testEinplanenVorstellung(){

        boolean testBool = false;

        try {
            kvw.einplanenVorstellung(vs);
        } catch (Exception exception){
            testBool = true;
        }

        assertFalse(testBool);
    }

    @Test
    void testGetVorstellung(){
        Vorstellung vsTest1 = new Vorstellung(ksl, Zeitfenster.NACHMITTAG, LocalDate.of(2022, Month.DECEMBER, 12), "Film1", 20);
        Vorstellung vsTest2 = new Vorstellung(ksl, Zeitfenster.ABEND, LocalDate.of(2022, Month.DECEMBER, 12), "Film2", 20);
        Vorstellung vsTest3 = new Vorstellung(ksl, Zeitfenster.NACHT, LocalDate.of(2022, Month.DECEMBER, 12), "Film3", 20);
        Vorstellung vsTest4 = new Vorstellung(ksl, Zeitfenster.NACHMITTAG, LocalDate.of(2022, Month.DECEMBER, 13), "Film4", 20);

        kvw.einplanenVorstellung(vsTest1);
        kvw.einplanenVorstellung(vsTest2);
        kvw.einplanenVorstellung(vsTest3);
        kvw.einplanenVorstellung(vsTest4);

        List<Vorstellung> vsList = new LinkedList<>();

        vsList.add(vsTest1);
        vsList.add(vsTest2);
        vsList.add(vsTest3);
        vsList.add(vsTest4);

        assertEquals(vsList, kvw.getVorstellungen());
    }

    @Test
    void testKaufeTicket(){
        assertTrue(kvw.kaufeTicket(vs, 'A', 10, 20) instanceof Ticket);
    }

}
