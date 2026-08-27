import controller.PlayerController
import model.Player

val playerController = PlayerController()

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    print(
        """
        ========================================
                 FOOTBALL MANAGER
        ========================================
        
        PLAYER MENU
        
          1) Add Player
          2) List Players
          3) Find Player
          4) Delete Player
          5) Update Player
          6) List Player by Position
          0) Exit
        
        ========================================
        Select an option ==>> 
        """.trimIndent()
    )

    return readLine()?.toIntOrNull() ?: -1
}

fun runMenu() {
    do {
        val option = mainMenu()

        when (option) {
            1 -> addPlayer()
            2 -> listPlayers()
            3 -> findPlayer()
            4 -> deletePlayer()
            5 -> updatePlayer()
            6 -> listPlayersByPosition()
            0 -> exitApp()
            else -> println("Invalid option entered: $option")
        }

    } while (true)
}

fun listPlayersByPosition() {
    print("Enter the position to search for: ")
    val position = readLine() ?: ""

    val playersByPosition = playerController.listPlayersByPosition(position)

    if (playersByPosition.isEmpty()) {
        println("No players found in that position")
    } else {
        println(playersByPosition)
    }
}

fun addPlayer() {
    print("Enter player name: ")
    val name = readLine() ?: ""

    print("Enter player position: ")
    val position = readLine() ?: ""

    print("Enter squad number: ")
    val squadNumber = readLine()?.toIntOrNull() ?: 0

    print("Enter player age: ")
    val age = readLine()?.toIntOrNull() ?: 0

    print("Enter appearances: ")
    val appearances = readLine()?.toIntOrNull() ?: 0

    val player = Player(
        name,
        position,
        squadNumber,
        age,
        appearances
    )

    playerController.addPlayer(player)

    println("Player added successfully!")
}

fun listPlayers() {
    val players = playerController.getPlayers()

    if (players.isEmpty()) {
        println("No players stored.")
    } else {
        println("========== PLAYERS ==========")

        players.forEachIndexed { index, player ->
            println("${index + 1}. $player")
        }
    }
}

fun findPlayer() {
    print("Enter the player name to search for: ")
    val name = readLine() ?: ""

    val player = playerController.findPlayer(name)

    if (player != null) {
        println("Player found:")
        println(player)
    } else {
        println("Player not found.")
    }
}

fun deletePlayer() {
    val players = playerController.getPlayers()

    if (players.isEmpty()) {
        println("No players stored.")
        return
    }

    println("========== PLAYERS ==========")

    players.forEachIndexed { index, player ->
        println("${index + 1}. $player")
    }

    print("Enter the player number to delete: ")
    val index = readLine()?.toIntOrNull()

    if (index == null || index !in 1..players.size) {
        println("Invalid player number.")
        return
    }

    val playerToDelete = players[index - 1]

    playerController.removePlayer(playerToDelete)

    println("Player deleted successfully!")

}
fun updatePlayer() {
    listPlayers()

    val players = playerController.getPlayers()

    if (players.isNotEmpty()) {
        print("Enter the number of the player to update: ")
        val indexToUpdate = (readLine()?.toIntOrNull() ?: 0) - 1

        if (indexToUpdate >= 0 && indexToUpdate < players.size) {

            print("Enter player name: ")
            val name = readLine() ?: ""

            print("Enter player position: ")
            val position = readLine() ?: ""

            print("Enter squad number: ")
            val squadNumber = readLine()?.toIntOrNull() ?: 0

            print("Enter player age: ")
            val age = readLine()?.toIntOrNull() ?: 0

            print("Enter appearances: ")
            val appearances = readLine()?.toIntOrNull() ?: 0

            val updatedPlayer = Player(
                name,
                position,
                squadNumber,
                age,
                appearances
            )

            if (playerController.updatePlayer(indexToUpdate, updatedPlayer)) {
                println("Update Successful")
            } else {
                println("Update Failed")
            }

        } else {
            println("Invalid player number")
        }
    }

}

    fun exitApp() {
        println("Exiting Football Manager... goodbye!")
        kotlin.system.exitProcess(0)


            }


