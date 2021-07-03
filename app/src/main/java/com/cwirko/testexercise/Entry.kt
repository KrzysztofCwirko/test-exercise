package com.cwirko.testexercise

import java.util.*

data class Entry(
    val score : Int,
    val gameTime : Int,
    val date : Date,
    val moves : Int
)

fun entriesComparator() = kotlin.Comparator<Entry> { a, b ->
    when {
        (a.score > b.score) -> -1   //a has higher score
        (b.score > a.score) -> 1    //b has higher score
        (a.score == b.score && a.moves < b.moves) -> -1 //scores are tied, but a has lower moves
        (a.score == b.score && b.moves < a.moves) -> 1  //scores are tied, but b has lower moves
        (a.score == b.score && a.moves == b.moves && a.gameTime < b.gameTime) -> -1 //scores and moves are tied, but a has shorter game time
        (a.score == b.score && a.moves == b.moves && b.gameTime < a.gameTime) -> 1  //scores and moves are tied, but b has shorter game time
        else -> 0   //exactly the same, so put lower
    }

}
