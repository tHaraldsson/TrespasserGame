package se.tommy.adventure.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    private Resident resident;
    private Burglar burglar;


    //BeforeEach ser till att setUp metoden körs innan testet
    //alltså att resident och burglar är initierade innan testet körs
    @BeforeEach
    void setUp() {
        resident = new Resident(100, 50);
        burglar = new Burglar(50, 50);
    }


    @Test
    void punch() {
        // Residents hälsa 100
        int initialHealth = resident.getHealth();

        //Burglar slår resident med 50
        burglar.punch(resident);

        //Residents hälsa efter slag 50 (100-50=50)
        int expectedHealth = initialHealth - burglar.getDamage();

        //Förväntad hälsa 50, residents hälsa 50
        assertEquals(expectedHealth, resident.getHealth());
    }

    @Test
    void takeHit() {

        //Residents hälsa
        int initialHealth = resident.getHealth();

        //Resident tar 10 i skada
        resident.takeHit(10);

        //Förväntad hälsa efter att ha tagit 10 i skada (100-10=90)
        int expectedHealth = initialHealth - 10;

        //Förväntad hälsa (90) och residentens hälsa (90)
        assertEquals(expectedHealth, resident.getHealth());
    }

    @Test
    void isResidentUnconcious() {

        //Burglar slår resident 2 gånger med 50 i skada eftersom resident har 100 i hälsa
        burglar.punch(resident);
        burglar.punch(resident);

        //Residents hälsa blir då 0 och .isConcious är då false
        assertFalse(resident.isConcious());
    }


    @Test
    void isBurglarUnconcious() {

        //Resident slår burglar 1 gång med 50 i skada eftersom burglars hälsa är 50
        resident.punch(burglar);

        //Burglars hälsa blir då 0 och .isConcious är då false
        assertFalse(burglar.isConcious());
    }

    @Test
    void isResidentConcious() {

        //Burglar slår resident med 50 i skada men residents hälsa är 100 (100-50=50)
        burglar.punch(resident);

        //Residents hälsa är då mer än 0 och .isConcious är då true
        assertTrue(resident.isConcious());
    }

    @Test
    void isBurglarConcious() {

        //Settar residents skada till 49
        resident.setDamage(49);

        //Resident slår burglar med 49 i skada men burglars hälsa är 50 (50-49=1)
        resident.punch(burglar);

        //Burglars hälsa är då mer än 0 och .isConcious är då true
        assertTrue(burglar.isConcious());
    }
}