package com.spike.poker.hands

import com.spike.poker.hands.Result.*

class PokerRound(private val first: Hand, val second: Hand, private val rules: PokerRules) {
    fun winner(): Result {
        val firstHandScore = rules.score(first.cards)
        val secondHandScore = rules.score(second.cards)

        if (firstHandScore == secondHandScore) return Tie
        if (firstHandScore > secondHandScore) return Winner(first)
        return Winner(second)
    }
}

open class Result {
    object Tie : Result()
    data class Winner(val hand: Hand) : Result()
}
