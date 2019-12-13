package com.spike.poker.hands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PokerRulesTest {
    @Test
    fun highHand_score_shouldBeSameAsTheMaxValue() {
        val rules = PokerRules(setOf(HighCard()))
        val cards = setOf(Card(1), Card(10))

        assertEquals(10, rules.score(cards))
    }
}