package ch.noseryoung.test;

import ch.noseryoung.main.GameConsole;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ch.noseryoung.main.NintendoConsoles.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConsoleStreamTest {

    /**
     * Test:        Get the first 3 portable consoles.
     * Expected:    Game & Watch, Game Boy, Virtual Boy.
     */
    @Test
    public void test_GetPortables_FirstThree() {
        List<GameConsole> actual = PORTABLES.stream().toList();
        assertArrayEquals(new GameConsole[]{G_W, GB, VB}, actual.toArray());
    }

    /**
     * Test:        Get the last 3 home consoles.
     * Expected:    Wii, Wii U, Switch.
     */
    @Test
    public void test_GetHomeConsoles_LastThree() {
        List<GameConsole> actual = HOME_CONSOLES.stream().toList();
        assertArrayEquals(new GameConsole[]{WII, WII_U, SWITCH}, actual.toArray());
    }

    /**
     * Test:        Get String of pattern "I have played on a <CONSOLE>!" for each console.
     * Expected:    String as seen below.
     */
    @Test
    public void test_GetString_Played() {
        String actual = "";
        String PLAYED_STRINGS = """
                I have played on a Color TV-Game!
                I have played on a Nintendo Entertainment System!
                I have played on a Super Nintendo Entertainment System!
                I have played on a Nintendo 64!
                I have played on a GameCube!
                I have played on a Wii!
                I have played on a Wii U!
                I have played on a Switch!
                I have played on a Game & Watch!
                I have played on a Game Boy!
                I have played on a Virtual Boy!
                I have played on a Game Boy Color!
                I have played on a Game Boy Advance!
                I have played on a Nintendo DS!
                I have played on a Nintendo 3DS!
                I have played on a New Nintendo 3DS!""";
        assertEquals(PLAYED_STRINGS, actual);
    }

    /**
     * Test:        Get same as above, but with other name of console if available.
     * Expected:    String as seen below.
     */
    @Test
    public void test_GetString_PlayedOtherNames() {
        String actual = "";
        String PLAYED_STRINGS_OTHER_NAMES = """
                I have played on a Color TV-Game!
                I have played on a NES!
                I have played on a SNES!
                I have played on a N64!
                I have played on a GCN!
                I have played on a Wii!
                I have played on a Wii U!
                I have played on a Switch!
                I have played on a G&W!
                I have played on a GB!
                I have played on a VB!
                I have played on a GBC!
                I have played on a GBA!
                I have played on a NDS!
                I have played on a 3DS!
                I have played on a 3DS!""";
        assertEquals(PLAYED_STRINGS_OTHER_NAMES, actual);
    }

    /**
     * Test:        Get portable consoles, sorted by number of units sold worldwide.
     * Expected:    Virtual Boy, New 3DS, Game & Watch, Game Boy, Game Boy Color, 3DS, Game Boy Advance, DS.
     */
    @Test
    public void test_GetPortables_SortedByUnitsSold() {
        List<GameConsole> actual = PORTABLES.stream()
                .sorted(Comparator.comparingInt(GameConsole::getUnitsSoldWorldwide))
                .collect(Collectors.toList());
        assertArrayEquals(new GameConsole[]{VB, N_N3DS, G_W, GB, GBC, N3DS, GBA, NDS}, actual.toArray());
    }

    /**
     * Test:        Get home consoles released before Andrew's birthday (20.10.1997).
     * Expected:    Color TV-Game, NES, SNES, N64.
     */
    @Test
    public void test_GetHomeConsoles_ReleasedBeforeAndrew() {
        List<GameConsole> actual = HOME_CONSOLES.stream().toList();
        assertArrayEquals(new GameConsole[]{COLOR_TV_GAME, NES, SNES, N64}, actual.toArray());
    }

    /**
     * Test:        Get all consoles that have a Mario game as bestselling title.
     * Expected:    NES, SNES, N64, Wii U, Switch, NDS, 3DS, New 3DS.
     */
    @Test
    public void test_GetAllConsoles_HaveMarioGameAsBestSeller() {
        List<GameConsole> actual = ALL_CONSOLES.stream().toList();
        assertArrayEquals(new GameConsole[]{NES, SNES, N64, WII_U, SWITCH, NDS, N3DS, N_N3DS}, actual.toArray());
    }

    /**
     * Test:        Get String containing the best selling game of the best selling console.
     * Expected:    New Super Mario Bros.
     */
    @Test
    public void test_GetString_BestSellerOfBestSellingConsole() {
        String actual = "";
        assertEquals("New Super Mario Bros.", actual);
    }

    /**
     * Test:        Get Boolean that checks if all consoles are developed by Nintendo
     * Expected:    true.
     */
    @Test
    public void test_GetBoolean_AllConsolesDevelopedByNintendo() {
        boolean actual = true;
        for (GameConsole allConsole : ALL_CONSOLES) {
            if (!allConsole.getDeveloper().equals("Nintendo")) {
                actual = false;
                break;
            }
        }
        assertTrue(actual);
    }

    /**
     * Test:       Get Boolean that checks if a console exists that had sold less than 1 million units.
     * Expected:   true.
     */
    @Test
    public void test_GetBoolean_ConsoleExistsLessThanMillionSold() {
        boolean actual = false;
        assertTrue(actual);
    }

    /**
     * Test:        Get the only consoly that had sold less than 1 million units.
     * Expected:    Virtual Boy.
     */
    @Test
    public void test_GetConsole_ExistsLessThanMillionSold() {
        GameConsole actual = null;
        assertEquals(VB, actual);
    }

    /**
     * Test:        Get Boolean that checks if no consoles have been released in January.
     * Expected:    true.
     */
    @Test
    public void test_GetBoolean_NoConsoleReleasedInJanuary() {
        boolean actual = false;
        assertTrue(actual);
    }

    /**
     * Test:        Get Long value of the number of consoles that have the substring "game" in their name.
     * Expected:    6.
     */
    @Test
    public void test_GetInt_ConsolesContainGameInName() {
        long actual = -1;
        assertEquals(6, actual);
    }

    /**
     * Test:        Get Long value of the number of consoles that have the substring "boy" in their name.
     * Expected:    4.
     */
    @Test
    public void test_GetInt_ConsolesContainBoyInName() {
        long actual = -1;
        assertEquals(4, actual);
    }

    /**
     * Test:        Get Long value of the number of consoles that have the substring "game" and "boy" in their name.
     * Expected:    3.
     */
    @Test
    public void test_GetInt_ConsolesContainGameAndBoyInName() {
        long actual = -1;
        assertEquals(3, actual);
    }

    /**
     * Test:        Get portable consoles that do not have an alias.
     * Expected:    <empty list>.
     */
    @Test
    public void test_GetPortables_NoOtherNamesAvailable() {
        List<GameConsole> actual = new ArrayList<GameConsole>();

        for (GameConsole portables : PORTABLES) {
            if (portables.getName().isEmpty()) {
                actual.add(portables);
                break;
            }
        }

        assertArrayEquals(new GameConsole[]{}, actual.toArray());
    }

    /**
     * Test:        Get one home console of the latest generation
     * Expected:    Wii U (or Switch, might need to change the assert statement).
     */
    @Test
    public void test_GetHomeConsole_LatestGeneration() {
        GameConsole actual = null;
        assertEquals(WII_U, actual);
    }

    /**
     * Test:        Get String of pattern "<RELEASE DATE> <CONSOLE NAME>" of consoles released in November, sorted by day.
     * Expected:    String as seen below.
     */
    @Test
    public void test_GetString_ConsoleNameAndReleaseInNovemberSortedByDay() {
        String actual = "";
        String CONSOLE_RELEASE_STRINGS_NOVEMBER_SORTED = """
                2012-11-18 Wii U
                2006-11-19 Wii
                1990-11-21 Super Nintendo Entertainment System
                2004-11-21 Nintendo DS""";
        assertEquals(CONSOLE_RELEASE_STRINGS_NOVEMBER_SORTED, actual);
    }
}
