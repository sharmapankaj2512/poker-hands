package com.spike.poker.hands

import com.spike.poker.hands.Result.*

class PokerRound(private val first: Hand,
                 private val second: Hand,
                 private val rules: PokerRules) {
    fun winner(): Result {
        val firstScore = rules.score(first.cards)
        val secondScore = rules.score(second.cards)

        if (firstScore < secondScore) return Winner(second)
        if (firstScore > secondScore) return Winner(first)
        return Tie
    }
}

open class Result {
    data class Winner(val hand: Hand) : Result()
    object Tie : Result()
}
