package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("GUNTASH SINGH.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("guntashgill", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("GUNTASH SINGH."),"Team should contain GUNTASH SINGH.");
        assertTrue(t.getMembers().contains("ANDREW."),"Team should contain ANDREW.");
        assertTrue(t.getMembers().contains("JAYDEN."),"Team should contain JAYDEN.");
        assertTrue(t.getMembers().contains("KELVIN APOLLO."),"Team should contain KELVIN APOLLO.");
        assertTrue(t.getMembers().contains("TIM VAN."),"Team should contain TIM VAN.");
        assertTrue(t.getMembers().contains("AKUL."),"Team should contain AKUL.");

    }



}
