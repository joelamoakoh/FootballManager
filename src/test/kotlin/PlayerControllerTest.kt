import controller.PlayerController
import model.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayerControllerTest {

    @Test
    fun `adding a player increases the number of players`() {
        val playerController = PlayerController()

        val player = Player(
            "Test Player",
            "GK",
            1,
            20,
            10
        )

        playerController.addPlayer(player)

        assertEquals(1, playerController.getPlayers().size)
    }
    @Test
    fun `deleting a player decreases the number of players`() {
        val playerController = PlayerController()

        val player = Player(
            "Test Player",
            "GK",
            1,
            20,
            10
        )

        playerController.addPlayer(player)

        playerController.removePlayer(player)

        assertEquals(0, playerController.getPlayers().size)
    }
    @Test
    fun `updating a player changes the player details`() {
        val playerController = PlayerController()

        val player = Player(
            "Old Name",
            "GK",
            1,
            20,
            10
        )

        playerController.addPlayer(player)

        val updatedPlayer = Player(
            "New Name",
            "FWD",
            10,
            25,
            20
        )

        playerController.updatePlayer(0, updatedPlayer)

        assertEquals("New Name", playerController.getPlayers()[0].name)
    }
    @Test
    fun `finding a player by name returns the correct player`() {
        val playerController = PlayerController()

        val player = Player(
            "John",
            "MID",
            8,
            22,
            15
        )

        playerController.addPlayer(player)

        val foundPlayer = playerController.findPlayer("John")

        assertEquals("John", foundPlayer?.name)
    }

    @Test
    fun `listing players by position returns matching players`() {
        val playerController = PlayerController()

        playerController.addPlayer(Player("John", "GK", 1, 22, 15))
        playerController.addPlayer(Player("Mike", "FWD", 9, 21, 20))

        val goalkeepers = playerController.listPlayersByPosition("GK")

        assertEquals(1, goalkeepers.size)
        assertEquals("John", goalkeepers[0].name)
    }

    }
