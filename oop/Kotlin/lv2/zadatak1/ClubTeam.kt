package zadatak1

import plusPackage.Formation

class ClubTeam(name: String = "TeamX", formation: Formation = Formation.F442, var reputation: Int = 50): Team(name, formation, numPlayer = 25) {

    init {
        if (reputation < 0 || reputation > 100) {
            throw Exception("Reputation out of range! 0 - 100")
        }
    }

    override fun registerPlayer(player: FootballPlayer): Boolean {
        if (player.playingSkill >= this.reputation) return registeredPlayers.add(player)
        return false
    }

    override fun calculateRating(): Double {
        return registeredPlayers.emotionSum * 0.3 + registeredPlayers.skillSum * 0.7
    }

}