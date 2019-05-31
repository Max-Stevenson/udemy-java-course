package SetsChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    private HeavenlyBody testPlanet = new Planet("testPlanet", 365d);
    private final HeavenlyBody testMoon = new Moon("testMoon", 27d);
    private final HeavenlyBody notAMoon = new DwarfPlanet("notAMoon", 100d);

    @Test
    void addSatellite() {
        // Should only be able to add a moon as a satellite.
        assertTrue(testPlanet.addSatellite(testMoon));
        assertFalse(testPlanet.addSatellite(notAMoon));
    }
}