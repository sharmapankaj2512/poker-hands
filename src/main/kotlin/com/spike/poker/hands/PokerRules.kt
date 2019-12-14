package com.spike.poker.hands

class PokerRules(private val rules: Set<PokerRule>) {
    fun score(hand: Hand): Int {
        return rules.find { it.isApplicable(hand) }?.score(hand) ?: 0
    }
}

class HighCard : PokerRule {
    override fun score(hand: Hand): Int {
        return hand.maxValue()
    }

    override fun isApplicable(hand: Hand): Boolean {
        return hand.isHighCard()
    }
}

class Pair : PokerRule {
    override fun score(hand: Hand): Int {
        return 15 * hand.maxValue()
    }

    override fun isApplicable(hand: Hand): Boolean {
        return hand.isPair()
    }
}

interface PokerRule {
    fun score(hand: Hand): Int
    fun isApplicable(hand: Hand): Boolean
}
