package controller

import model.Match
import java.util.ArrayList

class MatchController {

    private val matches = ArrayList<Match>()

    fun addMatch(match: Match) {
        matches.add(match)
    }

    fun getMatches(): ArrayList<Match> {
        return matches
    }

    fun removeMatch(match: Match) {
        matches.remove(match)
    }

    fun findMatch(index: Int): Match? {
        return if (index >= 0 && index < matches.size) {
            matches[index]
        } else {
            null
        }
    }

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

    fun findMatch(opponent: String): Match? {
        return matches.find {
            it.opponent.equals(opponent, ignoreCase = true)
        }
    }
}