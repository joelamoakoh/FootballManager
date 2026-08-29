
package model

data class Match(
    var opponent: String,
    var date: String,
    var competition: String,
    var score: String,
    var homeMatch: Boolean
)