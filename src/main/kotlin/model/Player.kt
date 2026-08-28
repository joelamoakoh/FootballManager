
/**
*This file represents a football player in the application
*
* Name the players name
* Positions the player
* Puts a squad number on player
* Gives player an age
* Shows appearances
*/

package model

data class Player(
    var name: String,
    var position: String,
    var squadNumber: Int,
    var age: Int,
    var appearances: Int
)