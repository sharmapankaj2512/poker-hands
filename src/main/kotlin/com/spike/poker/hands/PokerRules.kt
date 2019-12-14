package com.spike.poker.hands

class PokerRules(private val rules: Set<PokerRule>) {
    fun score(cards: Set<Card>): Int {
        return rules.find { it.isApplicable(cards) }?.score(cards) ?: 0
    }
}

class HighCard : PokerRule {
    override fun score(cards: Set<Card>): Int {
        return cards.map { it.value }.max()!!
    }

    override fun isApplicable(cards: Set<Card>): Boolean {
        val values = cards.map { it.value }
        return cards.isNotEmpty() && values.size == cards.size
    }
}

interface PokerRule {
    fun score(cards: Set<Card>): Int
    fun isApplicable(cards: Set<Card>): Boolean
}
