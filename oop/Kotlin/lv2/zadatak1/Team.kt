package zadatak1

import plusPackage.Formation
import plusPackage.ManageableTeam

abstract class Team(val name: String = "TeamX", var formation: Formation = Formation.F442, open val numPlayer: Int = 50): ManageableTeam {

    var registeredPlayers = SimpleFootballPlayerCollectionImpl(numPlayer)
    var startingEleven = SimpleFootballPlayerCollectionImpl(11)

    override fun addPlayerToStartingEleven(player: FootballPlayer): Boolean {
        if (registeredPlayers.contains(player)) return startingEleven.add(player)
        return false
    }

    override fun clearStartingEleven() {
        startingEleven = SimpleFootballPlayerCollectionImpl(11)
    }

    override fun isPlayerRegistered(player: FootballPlayer): Boolean {
        return registeredPlayers.contains(player)
    }

    override fun getTeamFormation(): Formation {
       return formation
    }

    override fun setTeamFormation(formation: Formation) {
        this.formation = formation
    }

    override fun getTeamStartingEleven(): SimpleFootballPlayerCollectionImpl {
        return startingEleven
    }

    override fun getTeamRegisteredPlayers(): SimpleFootballPlayerCollectionImpl {
        return registeredPlayers
    }
}