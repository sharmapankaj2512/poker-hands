package com.spike.poker.hands

class PokerRules(val rules: Set<PokerRule>) {
    fun score(cards: Set<Card>): Int {
        return rules.first().score(cards)
    }
}

class HighCard : PokerRule {
    override fun score(cards: Set<Card>): Int {
        return cards.map { it.value }.max()!!
    }
}

interface PokerRule {
    fun score(cards: Set<Card>): Int
}
