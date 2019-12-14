package com.spike.poker.hands

import com.spike.poker.hands.Result.*

class PokerRound(private val first: Hand,
                 private val second: Hand,
                 private val rules: PokerRules) {
    fun winner(): Result {
        val firstHandScore = rules.score(first)
        val secondHandScore = rules.score(second)

        if (firstHandScore > secondHandScore) return Winner(first)
        if (firstHandScore < secondHandScore) return Winner(second)
        return Tie
    }
}

open class Result {
    object Tie : Result()
    data class Winner(val hand: Hand) : Result()
}
