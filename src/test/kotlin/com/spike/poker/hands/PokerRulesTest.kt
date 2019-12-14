package com.spike.poker.hands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PokerRulesTest {
    private val player = Player("")

    @Test
    fun score_shouldBeSameAsTheMaxValueForAHighCard() {
        val rules = PokerRules(setOf(HighCard()))
        val cards = setOf(Card(1), Card(10))
        val hand = Hand(player, cards)

        assertEquals(10, rules.score(hand))
    }

    @Test
    fun score_shouldBeZeroWhenNoRuleIsApplicable() {
        val rules = PokerRules(setOf(HighCard()))
        val hand = Hand(player, setOf())

        assertEquals(0, rules.score(hand))
    }

    @Test
    fun score_shouldBeCalculatedBasedOnPairRule() {
        val rules = PokerRules(setOf(HighCard(), Pair()))
        val cards = setOf(Card(1), Card(1))
        val hand = Hand(player, cards)

        assertEquals(15, rules.score(hand))
    }
}