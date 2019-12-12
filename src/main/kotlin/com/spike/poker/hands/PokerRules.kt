package com.spike.poker.hands

class PokerRules(private val rules: Set<PokerRule>) {
    fun score(cards: Set<Card>): Int {
        return rules.first().score(cards)
    }
}

class HighCard : PokerRule {
    override fun score(cards: Set<Card>): Int {
        return 1 * cards.map { it.value }.max()!!
    }
}

interface PokerRule {
    fun score(cards: Set<Card>): Int
}