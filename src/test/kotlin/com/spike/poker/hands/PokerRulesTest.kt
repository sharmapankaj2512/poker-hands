package com.spike.poker.hands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PokerRulesTest {
    @Test
    fun score_highHand() {
        val rules = PokerRules(setOf(HighCard()))
        val cards = setOf(Card(1), Card(3))

        assertEquals(3, rules.score(cards))
    }
}