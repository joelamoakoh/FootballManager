package controller

import model.Match
import java.util.ArrayList
/**
 * Controls and manages the collection of matches in the application
 */
class MatchController {

    private val matches = ArrayList<Match>()
    /**
     * Adds a match to collection
     *
     * @param match the match to add
     */
    fun addMatch(match: Match) {
        matches.add(match)
    }
    /**
     * Returns all matches that are stored
     *
     * @return the list of  matches stored
     */
    fun getMatches(): ArrayList<Match> {
        return matches
    }
    /**
     * Removes a match from the collection
     *
     * @param match the player to remove
     */

    fun removeMatch(match: Match) {
        matches.remove(match)
    }
    /**
     * Finds a match its index in collection
     *
     * @param index the index of the match to find
     * @return match with that index or null if index is not used
     */
    fun findMatch(index: Int): Match? {
        return if (index >= 0 && index < matches.size) {
            matches[index]
        } else {
            null
        }
    }
    /**
     * Updates the details of a match
     *
     * @param indexToUpdate the index of the match you want to update
     * @param match the new match details
     * @return true if the match was updated successfully, false if not
     */


    fun updateMatch(indexToUpdate: Int, match: Match?): Boolean {
        val foundMatch = findMatch(indexToUpdate)

        if ((foundMatch != null) && (match != null)) {
            foundMatch.opponent = match.opponent
            foundMatch.date = match.date
            foundMatch.competition = match.competition
            foundMatch.score = match.score
            foundMatch.homeMatch = match.homeMatch
            return true
        }

        return false
    }
    /**
     * Finds a match by its opponent
     *
     * @param opponent the opponent to search for
     * @return the matching match null if theres no match
     */
    fun findMatch(opponent: String): Match? {
        return matches.find {
            it.opponent.equals(opponent, ignoreCase = true)
        }
    }
}