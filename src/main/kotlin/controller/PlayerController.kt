package controller

import model.Player
import java.util.ArrayList

class PlayerController {

    private val players = ArrayList<Player>()

    fun addPlayer(player: Player){
        players.add(player)
    }
    fun getPlayers(): ArrayList<Player>{
        return players
    }
    fun removePlayer(player: Player){
        players.remove(player)
    }

    fun findPlayer(index: Int): Player? {
        return if (index >= 0 && index < players.size) {
            players[index]
        } else {
            null
        }
    }

    fun updatePlayer(indexToUpdate: Int, player: Player?): Boolean {
        val foundPlayer = findPlayer(indexToUpdate)

        if ((foundPlayer != null) && (player != null)) {
            foundPlayer.name = player.name
            foundPlayer.position = player.position
            foundPlayer.squadNumber = player.squadNumber
            foundPlayer.age = player.age
            foundPlayer.appearances = player.appearances
            return true
        }

        return false
    }

    fun findPlayer(name : String): Player? {
        return players.find { it.name.equals(name, ignoreCase = true) }
    }
    fun listPlayersByPosition(position: String): ArrayList<Player> {
        val playersByPosition = ArrayList<Player>()

        for (player in players) {
            if (player.position.equals(position, ignoreCase = true)) {
                playersByPosition.add(player)
            }
        }

        return playersByPosition
    }
}
