package com.spike.poker.hands

import com.spike.poker.hands.Result.Tie
import com.spike.poker.hands.Result.Winner
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PokerRoundTest {
    @Nested
    inner class GivenTwoPlayersNinjaAndBatman {
        val ninja = Player("ninja")
        val batman = Player("batman")

        @Nested
        inner class AndPokerRules {
            val rules = PokerRules(setOf(HighCard(), Pair()))

            @Nested
            inner class WhenNinjaRevealsAHighCard {
                val ninjaHand = Hand(ninja, setOf(Card(10)))

                @Nested
                inner class AndWhenBatmanRevealsAHighCardOfSameMaxvalue {
                    val batmanHand = Hand(batman, setOf(Card(10)))

                    @Test
                    fun thenThePokerRoundIsTiedAndThereAreNoWinners() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Tie, round.winner())
                    }
                }

                @Nested
                inner class AndWhenBatmanRevealsAHighCardOfHigherMaxValue {
                    private val batmanHand = Hand(batman, setOf(Card(15)))

                    @Test
                    fun thenBatmanWinsTheRound() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Winner(batmanHand), round.winner())
                    }
                }

                @Nested
                inner class AndWhenBatmanRevealsAHighCardOfLowerMaxValue {
                    private val batmanHand = Hand(batman, setOf(Card(5)))

                    @Test
                    fun thenNinjaWinsThePokerRound() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Winner(ninjaHand), round.winner())
                    }
                }

                @Nested
                inner class AndWhenBatmanRevealsAPair() {
                    private val batmanHand = Hand(batman, setOf(Card(1), Card(1)))

                    @Test
                    fun thenBatmanWinsThePokerRound() {
                        val round = PokerRound(ninjaHand, batmanHand, rules)

                        assertEquals(Winner(batmanHand), round.winner())
                    }
                }
            }
        }
    }
}