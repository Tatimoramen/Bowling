package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    public GameTest() {
    }

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void shouldBeAbleToScoreAGameWithAllZeros() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(0, game.score());
    }

    @Test
    public void shouldBeAbleToScoreAGameWithNoStrikesOrSpares() {
        int[] rolls = { 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6 };

        game.playGame(rolls);
        assertEquals(90, game.score());
    }

    @Test
    public void aSpareFollowedByZerosIsWorthTenPoints() {
        int[] rolls = { 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(10, game.score());
    }

    @Test
    public void pointsScoredInTheRollAfterASpareAreCountedTwice() {
        int[] rolls = { 6, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(16, game.score());
    }

    @Test
    public void consecutiveSparesEachGetAOneRollBonus() {
        int[] rolls = { 5, 5, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(31, game.score());
    }

    @Test
    public void aSpareInTheLastFrameGetsAOneRollBonusThatIsCountedOnce() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 7 };

        game.playGame(rolls);
        assertEquals(17, game.score());
    }

    @Test
    public void aStrikeEarnsTenPointsInFrameWithASingleRoll() {
        int[] rolls = { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(10, game.score());
    }

    @Test
    public void pointsScoredInTheTwoRollsAfterAStrikeAreCountedTwiceAsABonus() {
        int[] rolls = { 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(26, game.score());
    }

    @Test
    public void consecutiveStrikesEachGetTheTwoRollBonus() {
        int[] rolls = { 10, 10, 10, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        game.playGame(rolls);
        assertEquals(81, game.score());
    }

    @Test
    public void aStrikeInTheLastFrameGetsATwoRollBonusThatIsCountedOnce() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 1 };

        game.playGame(rolls);
        assertEquals(18, game.score());
    }

    @Test
    public void rollingASpareWithTheTwoRollBonusDoesNotGetABonusRoll() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 3 };

        game.playGame(rolls);
        assertEquals(20, game.score());
    }

    @Test
    public void strikesWithTheTwoRollBonusDoNotGetBonusRolls() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10 };

        game.playGame(rolls);
        assertEquals(30, game.score());
    }

    @Test
    public void aStrikeWithTheOneRollBonusAfterASpareInTheLastFrameDoesNotGetABonus() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 3, 10 };

        game.playGame(rolls);
        assertEquals(20, game.score());
    }

    @Test
    public void allStrikesIsAPerfectGame() {
        int[] rolls = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

        game.playGame(rolls);
        assertEquals(300, game.score());
    }

    @Test
    public void twoBonusRollsAfterAStrikeInTheLastFrameCanScoreMoreThan10PointsIfOneIsAStrike() {
        int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 6 };

        game.playGame(rolls);

        assertEquals(26, game.score());
    }
}
