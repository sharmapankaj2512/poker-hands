package com.spike.poker.hands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PokerRulesTest {
    @Test
    fun score_shouldBeSameAsTheMaxValueForAHighCard() {
        val rules = PokerRules(setOf(HighCard()))
        val cards = setOf(Card(1), Card(10))

        assertEquals(10, rules.score(cards))
    }

    @Test
    fun score_shouldBeZeroWhenNoRuleIsApplicable() {
        val rules = PokerRules(setOf(HighCard()))

        assertEquals(0, rules.score(setOf()))
    }
}