package SetsChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    private Planet testPlanet = new Planet("testPlanet", 365d);
    private final HeavenlyBody testMoon = new HeavenlyBody("testMoon", 27d, HeavenlyBody.BodyTypes.MOON);
    private final HeavenlyBody notAMoon = new HeavenlyBody("notAMoon", 100d, HeavenlyBody.BodyTypes.ASTEROID);

    @Test
    void addSatellite() {
        // Should only be able to add a moon as a satellite.
        assertTrue(testPlanet.addSatellite(testMoon));
        assertFalse(testPlanet.addSatellite(notAMoon));
    }
}