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
    fun findPlayer(name : String): Player? {
        return players.find { it.name.equals(name, ignoreCase = true) }
    }
}
