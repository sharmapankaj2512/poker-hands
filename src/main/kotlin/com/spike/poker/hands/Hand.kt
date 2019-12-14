package com.spike.poker.hands

class Hand(player: Player, private val cards: Set<Card>) {
    fun maxValue(): Int {
        return cards.map { it.value }.max()!!
    }

    fun isHighCard(): Boolean {
        val values = cards.map { it.value }.distinct()
        return cards.isNotEmpty() && values.size == cards.size
    }

    fun isPair(): Boolean {
        val values = cards.map { it.value }.distinct()
        return cards.isNotEmpty() && values.size == cards.size - 1
    }
}
