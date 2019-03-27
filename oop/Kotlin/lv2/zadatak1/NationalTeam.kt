package zadatak1

import plusPackage.Formation

class NationalTeam(name: String = "TeamX", formation: Formation = Formation.F442, val country: String = "Noland"): Team(name, formation, numPlayer = 23) {

    override fun registerPlayer(player: FootballPlayer): Boolean {
        if (player.country == this.country) return registeredPlayers.add(player)
        return false
    }

    override fun calculateRating(): Double {
        return registeredPlayers.emotionSum * 0.7 + registeredPlayers.skillSum * 0.3
    }
}