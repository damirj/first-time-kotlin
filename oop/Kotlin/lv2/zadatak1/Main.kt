package zadatak1

import plusPackage.Formation
import plusPackage.PlayingPosition

fun main() {
    println("hll")
    var damir = FootballPlayer("Damir", "Croatia", 60, 99, PlayingPosition.DF)
    var rando = FootballPlayer("Rando", "Croatia", 0, 98, PlayingPosition.GK)

    var LoserUnited = ClubTeam("Loser United", Formation.F541, 97)

    var gazda = Coach("Gazda", "Egipat", 55, 15, Formation.F442)

    println(LoserUnited.registerPlayer(damir))
    println(LoserUnited.isPlayerRegistered(damir))

    gazda.managingTeam = LoserUnited
    gazda.forceMyFormation()

    println(LoserUnited.formation)

    gazda.managingTeam.registerPlayer(rando)

    println(LoserUnited.isPlayerRegistered(rando))
}
