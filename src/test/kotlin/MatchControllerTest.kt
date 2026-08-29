import controller.MatchController
import model.Match
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MatchControllerTest {

    @Test
    fun `adding a match increases the number of matches`() {
        val matchController = MatchController()

        val match = Match(
            "Kilkenny",
            "29/08/2026",
            "League",
            "2-1",
            true
        )

        matchController.addMatch(match)

        assertEquals(1, matchController.getMatches().size)
    }

    @Test
    fun `removing a match decreases the number of matches`() {
        val matchController = MatchController()

        val match = Match(
            "Kilkenny",
            "29/08/2026",
            "League",
            "2-1",
            true
        )

        matchController.addMatch(match)
        matchController.removeMatch(match)

        assertEquals(0, matchController.getMatches().size)
    }

    @Test
    fun `finding a match by opponent returns the correct match`() {
        val matchController = MatchController()

        val match = Match(
            "Kilkenny",
            "29/08/2026",
            "League",
            "2-1",
            true
        )

        matchController.addMatch(match)

        val foundMatch = matchController.findMatch("Kilkenny")

        assertEquals("Kilkenny", foundMatch?.opponent)
    }

    @Test
    fun `updating a match changes the match details`() {
        val matchController = MatchController()

        val match = Match(
            "Kilkenny",
            "29/08/2026",
            "League",
            "2-1",
            true
        )

        matchController.addMatch(match)

        val updatedMatch = Match(
            "Laois",
            "30/08/2026",
            "Cup",
            "3-0",
            false
        )

        matchController.updateMatch(0, updatedMatch)

        assertEquals("Laois", matchController.getMatches()[0].opponent)
    }
}