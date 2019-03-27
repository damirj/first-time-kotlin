package zadatak1

import plusPackage.Formation
import plusPackage.ManageableTeam
import plusPackage.Manager
import plusPackage.PlayingPosition

class Coach(name: String = "John Doe", country: String = "Noland", emotion: Int = 50, var coachingSkill: Int = 50, var formation: Formation = Formation.F442): Manager, Person(name, country, emotion){

    lateinit var managingTeam: ManageableTeam

    init {
        if (coachingSkill < 0 || coachingSkill > 100){
            throw Exception("Coaching skill is out of range! 0 - 100")
        }
    }

    override fun forceMyFormation() {
        managingTeam.setTeamFormation(this.formation)
    }

    override fun pickStartingEleven() {
        var df = 0
        var mf = 0
        var fw = 0
        var gk = 0

        for (player in managingTeam.getTeamRegisteredPlayers().getPlayers()) {
            if (player.playingPosition == PlayingPosition.DF && df < formation.DF) {
                df++
                managingTeam.getTeamStartingEleven().add(player)
            }

            if (player.playingPosition == PlayingPosition.MF && df < formation.MF) {
                mf++
                managingTeam.getTeamStartingEleven().add(player)
            }

            if (player.playingPosition == PlayingPosition.FW && df < formation.FW) {
                fw++
                managingTeam.getTeamStartingEleven().add(player)
            }

            if (player.playingPosition == PlayingPosition.GK && df < 1) {
                gk++
                managingTeam.getTeamStartingEleven().add(player)
            }

        }
    }
}