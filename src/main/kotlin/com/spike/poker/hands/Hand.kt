package com.spike.poker.hands

data class Hand(private val player: Player, val cards: Set<Card>) {
    override fun toString(): String {
        return "Player name: ${player.name}"
    }
}
