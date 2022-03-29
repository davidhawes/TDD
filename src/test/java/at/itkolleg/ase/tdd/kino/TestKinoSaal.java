package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestKinoSaal {


    private KinoSaal kinosaal;

    @BeforeEach
    void setup() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        kinosaal = new KinoSaal("TestSaal", map);
    }

    @Test
    void testPruefePlatz(){
        assertTrue(kinosaal.pruefePlatz('A', 10));
    }

    @Test
    void testGetName(){
        assertEquals("TestSaal", kinosaal.getName());
    }

    @Test
    void testEquals(){
        Object saal = kinosaal;
        assertTrue(kinosaal.equals(saal));
    }

}
