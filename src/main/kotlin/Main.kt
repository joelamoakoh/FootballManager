import controller.PlayerController
import controller.MatchController
import model.Player
import model.Match
import sun.security.util.KnownOIDs
import sun.security.util.KnownOIDs.findMatch

val playerController = PlayerController()
    val matchController = MatchController()

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
          7) Add Match
          8) List Matches
          9) Find Match
          10) Update match
          11) Delete Match
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
            7 -> addMatch()
            8 -> listMatches()
            9 -> findMatch()
            10 -> updateMatch()
            11 -> deleteMatch()
            0 -> exitApp()
            else -> println("Invalid option entered: $option")
        }

    } while (true)
}

fun findMatch() {
    print("Enter opponent to search for: ")
    val opponent = readLine() ?: ""

    val match = matchController.findMatch(opponent)

    if (match != null) {
        println("Match found: $match")
    } else {
        println("Match not found")
    }
}

fun deleteMatch() {
    listMatches()

    val matches = matchController.getMatches()

    if (matches.isNotEmpty()) {
        print("Enter the number of the match to delete: ")
        val indexToDelete = (readLine()?.toIntOrNull() ?: 0) - 1

        if (indexToDelete >= 0 && indexToDelete < matches.size) {
            val matchToDelete = matches[indexToDelete]

            matchController.removeMatch(matchToDelete)

            println("Match Deleted Successfully")
        } else {
            println("Invalid match number")
        }
    }
}

fun updateMatch() {
    listMatches()

    val matches = matchController.getMatches()

    if (matches.isNotEmpty()) {
        print("Enter the number of the match to update: ")
        val indexToUpdate = (readLine()?.toIntOrNull() ?: 0) - 1

        if (indexToUpdate >= 0 && indexToUpdate < matches.size) {

            print("Enter opponent: ")
            val opponent = readLine() ?: ""

            print("Enter date: ")
            val date = readLine() ?: ""

            print("Enter competition: ")
            val competition = readLine() ?: ""

            print("Enter score: ")
            val score = readLine() ?: ""

            print("Is this a home match? (true/false): ")
            val homeMatch = readLine()?.toBooleanStrictOrNull() ?: false

            val updatedMatch = Match(
                opponent,
                date,
                competition,
                score,
                homeMatch
            )

            if (matchController.updateMatch(indexToUpdate, updatedMatch)) {
                println("Update Successful")
            } else {
                println("Update Failed")
            }

        } else {
            println("Invalid match number")
        }
    }
}

fun listMatches() {
    if (matchController.getMatches().isNotEmpty()) {
        println("========== MATCHES ==========")

        matchController.getMatches().forEachIndexed { index, match ->
            println("${index + 1}. $match")
        }
    } else {
        println("No matches stored")
    }
}

fun addMatch() {
    print("Enter opponent: ")
    val opponent = readLine() ?: ""

    print("Enter date: ")
    val date = readLine() ?: ""

    print("Enter competition: ")
    val competition = readLine() ?: ""

    print("Enter score: ")
    val score = readLine() ?: ""

    print("Is this a home match? (true/false): ")
    val homeMatch = readLine()?.toBooleanStrictOrNull() ?: false

    val match = Match(
        opponent,
        date,
        competition,
        score,
        homeMatch
    )

    matchController.addMatch(match)

    println("Match Added Successfully")
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


