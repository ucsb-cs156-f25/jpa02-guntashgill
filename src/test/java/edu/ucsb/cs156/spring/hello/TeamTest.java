package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // Case 1: same object
    @Test
    void trueSameObject() {
        Team t = new Team("f25-15");
        t.addMember("GUNTASH SINGH.");
        t.addMember("ANDREW.");
        t.addMember("JAYDEN.");
        t.addMember("KELVIN APOLLO.");
        t.addMember("TIM VAN.");
        t.addMember("AKUL.");
        assertTrue(t.equals(t));
    }

    // Case 2: diff class
    @Test
    void falseDiffClass() {
        Team t = new Team("f25-15");
        t.addMember("GUNTASH SINGH.");
        t.addMember("ANDREW.");
        t.addMember("JAYDEN.");
        assertFalse(t.equals("not a team"));
        assertFalse(t.equals(null));
    }

    // Case  T,T: same name & members
    @Test
    void trueNameAndMemMatch() {
        Team t1 = new Team("f25-15");
        t1.addMember("GUNTASH SINGH.");
        t1.addMember("ANDREW.");
        t1.addMember("JAYDEN.");
        t1.addMember("KELVIN APOLLO.");
        t1.addMember("TIM VAN.");
        t1.addMember("AKUL.");

        Team t2 = new Team("f25-15");
        t2.addMember("GUNTASH SINGH.");
        t2.addMember("ANDREW.");
        t2.addMember("JAYDEN.");
        t2.addMember("KELVIN APOLLO.");
        t2.addMember("TIM VAN.");
        t2.addMember("AKUL.");

        assertTrue(t1.equals(t2));
    }

    // Case T,F: same name, diff members
    @Test
    void falseNameMatches() {
        Team t1 = new Team("f25-15");
        t1.addMember("GUNTASH SINGH.");
        t1.addMember("ANDREW.");
        t1.addMember("JAYDEN.");

        Team t2 = new Team("f25-15");
        t2.addMember("KELVIN APOLLO.");
        t2.addMember("TIM VAN.");
        t2.addMember("AKUL.");

        assertFalse(t1.equals(t2));
    }

    // Case F,T: diff name, same members
    @Test
    void falseMembersMatch() {
        Team t1 = new Team("f25-15");
        t1.addMember("GUNTASH SINGH.");
        t1.addMember("ANDREW.");
        t1.addMember("JAYDEN.");

        Team t2 = new Team("spring25-15");
        t2.addMember("GUNTASH SINGH.");
        t2.addMember("ANDREW.");
        t2.addMember("JAYDEN.");

        assertFalse(t1.equals(t2));
    }

    // F,F both dif
    @Test
    void falseNameAndMembersDiff() {
        Team t1 = new Team("f25-15");
        t1.addMember("GUNTASH SINGH.");
        t1.addMember("ANDREW.");

        Team t2 = new Team("spring25-15");
        t2.addMember("TIM VAN.");
        t2.addMember("AKUL.");

        assertFalse(t1.equals(t2));
    }
    // --- hashCode tests ---

    @Test
    void hashSameTeams() {
        Team t1 = new Team("f25-15");
        t1.addMember("GUNTASH SINGH.");
        t1.addMember("ANDREW.");
        t1.addMember("JAYDEN.");

        Team t2 = new Team("f25-15");
        t2.addMember("GUNTASH SINGH.");
        t2.addMember("ANDREW.");
        t2.addMember("JAYDEN.");

        assertTrue(t1.equals(t2));                 
        assertEquals(t1.hashCode(), t2.hashCode());
    }


    @Test
    void hashMatchExpected() {
        Team t = new Team("f25-15");
        t.addMember("GUNTASH SINGH.");
        t.addMember("ANDREW.");
        t.addMember("JAYDEN.");
        int result = t.hashCode();
        int EXPECTED = -202903684;

        assertEquals(EXPECTED, result);
    }


   

}
