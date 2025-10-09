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
        t.addMember("Guntash G.");
        t.addMember("Andrew X.");
        t.addMember("Jayden L.");
        t.addMember("Kelvin F.");
        t.addMember("Tim N.");
        t.addMember("Akul S.");
        assertTrue(t.equals(t));
    }

    // Case 2: diff class
    @Test
    void falseDiffClass() {
        Team t = new Team("f25-15");
        t.addMember("Guntash G.");
        t.addMember("Andrew X.");
        t.addMember("Jayden L.");
        assertFalse(t.equals("not a team"));
        assertFalse(t.equals(null));
    }

    // Case  T,T: same name & members
    @Test
    void trueNameAndMemMatch() {
        Team t1 = new Team("f25-15");
        t1.addMember("Guntash G.");
        t1.addMember("Andrew X.");
        t1.addMember("Jayden L.");
        t1.addMember("Kelvin F.");
        t1.addMember("Tim N.");
        t1.addMember("Akul S.");

        Team t2 = new Team("f25-15");
        t2.addMember("Guntash G.");
        t2.addMember("Andrew X.");
        t2.addMember("Jayden L.");
        t2.addMember("Kelvin F.");
        t2.addMember("Tim N.");
        t2.addMember("Akul S.");

        assertTrue(t1.equals(t2));
    }

    // Case T,F: same name, diff members
    @Test
    void falseNameMatches() {
        Team t1 = new Team("f25-15");
        t1.addMember("Guntash G.");
        t1.addMember("Andrew X.");
        t1.addMember("Jayden L.");

        Team t2 = new Team("f25-15");
        t2.addMember("Kelvin F.");
        t2.addMember("Tim N.");
        t2.addMember("Akul S.");

        assertFalse(t1.equals(t2));
    }

    // Case F,T: diff name, same members
    @Test
    void falseMembersMatch() {
        Team t1 = new Team("f25-15");
        t1.addMember("Guntash G.");
        t1.addMember("Andrew X.");
        t1.addMember("Jayden L.");

        Team t2 = new Team("spring25-15");
        t2.addMember("Guntash G.");
        t2.addMember("Andrew X.");
        t2.addMember("Jayden L.");

        assertFalse(t1.equals(t2));
    }

    // F,F both dif
    @Test
    void falseNameAndMembersDiff() {
        Team t1 = new Team("f25-15");
        t1.addMember("Guntash G.");
        t1.addMember("Andrew X.");

        Team t2 = new Team("spring25-15");
        t2.addMember("Tim N.");
        t2.addMember("Akul S.");

        assertFalse(t1.equals(t2));
    }
    // --- hashCode tests ---

    @Test
    void hashSameTeams() {
        Team t1 = new Team("f25-15");
        t1.addMember("Guntash G.");
        t1.addMember("Andrew X.");
        t1.addMember("Jayden L.");

        Team t2 = new Team("f25-15");
        t2.addMember("Guntash G.");
        t2.addMember("Andrew X.");
        t2.addMember("Jayden L.");

        assertTrue(t1.equals(t2));                 
        assertEquals(t1.hashCode(), t2.hashCode());
    }


    @Test
    void hashMatchExpected() {
        Team t = new Team("f25-15");
        t.addMember("Guntash G.");
        t.addMember("Andrew X.");
        t.addMember("Jayden L.");
        int result = t.hashCode();
        int EXPECTED = -1276138022;

        assertEquals(EXPECTED, result);
    }


   

}
