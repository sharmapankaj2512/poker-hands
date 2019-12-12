package com.spike.poker.hands

import com.spike.poker.hands.Result.Tie
import com.spike.poker.hands.Result.Winner
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PokerGameTest {

    @Nested
    inner class GivenTwoPlayersNinjaAndBatman {
        val ninja = Player("ninja")
        val batman = Player("batman")

        @Nested
        inner class AndPokerRules {
            val rules = PokerRules(setOf(HighCard()))

            @Nested
            inner class WhenNinjaRevealsHighCard {
                val ninjaHand = Hand(ninja, setOf(Card(10)))

                @Nested
                inner class AndBatmanRevealsHighCardOfLowerValue {
                    private val batmanHand = Hand(batman, setOf(Card(5)))

                    @Test
                    fun thenNinjaWinsThePokerRound() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Winner(ninjaHand), round.winner())
                    }
                }

                @Nested
                inner class AndBatmanRevealsHighCardOfSameValue {
                    private val batmanHand = Hand(ninja, setOf(Card(10)))

                    @Test
                    fun thenTheRoundHasNoWinners() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Tie, round.winner())
                    }
                }

                @Nested
                inner class AndBatmanRevealsHighCardOfHigherValue {
                    private val batmanHand = Hand(ninja, setOf(Card(15)))

                    @Test
                    fun thenBatmanWinsTheRound() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Winner(batmanHand), round.winner())
                    }
                }
            }
        }
    }

}