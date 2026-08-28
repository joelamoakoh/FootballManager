package controller

import model.Player
import java.util.ArrayList

/**
 * Controls and manages the collection of players in the application
 */
class PlayerController {

    private val players = ArrayList<Player>()

    /**
     * Adds a player to collection
     *
     * @param player the player to add
     */
    fun addPlayer(player: Player){
        players.add(player)
    }

    /**
     * Returns all players that are stored
     *
     * @return the list of players stored
     */
    fun getPlayers(): ArrayList<Player>{
        return players
    }

    /**
     * Removes a player from the collection
     *
     * @param player the player to remove
     */
    fun removePlayer(player: Player){
        players.remove(player)
    }

    /**
     * Finds a player using their position in collection
     *
     * @param index the index of the player to find
     * @return player with that index or null if index is not used
     */
    fun findPlayer(index: Int): Player? {
        return if (index >= 0 && index < players.size) {
            players[index]
        } else {
            null
        }
    }

    /**
     * Updates the details of a player
     *
     * @param indexToUpdate the index of the player you want to update
     * @param player the new player details
     * @return true if the player was updated successfully, false if not
     */

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

    /**
     * Find player by their name
     *
     * @param namee the name of the player to search for
     * @return the matching player , null if no player is there
     */
    fun findPlayer(name : String): Player? {
        return players.find { it.name.equals(name, ignoreCase = true) }
    }

    /**
     * Shows players who play in that position
     *
     * @param position the position to search for
     * @return a list containing players in that position
     */
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
