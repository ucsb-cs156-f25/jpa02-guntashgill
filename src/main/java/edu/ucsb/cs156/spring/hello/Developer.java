package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {

        return "GUNTASH SINGH";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "guntashgill";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("f25-15");
        team.addMember("GUNTASH SINGH");
        team.addMember("ANDREW");
        team.addMember("JAYDEN");
        team.addMember("KELVIN APOLLO");
        team.addMember("TIM VAN");
        team.addMember("AKUL");
        return team;
    }
}
