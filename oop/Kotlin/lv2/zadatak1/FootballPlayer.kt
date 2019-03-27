package zadatak1

import plusPackage.PlayingPosition

class FootballPlayer(name: String = "John Doe", country: String = "Noland", emotion: Int = 50, var playingSkill: Int = 50, var playingPosition: PlayingPosition = PlayingPosition.MF): Person(name, country, emotion) {
    init {
        if (playingSkill < 0 || playingSkill > 100) {
            throw Exception("Playing skill is out of range! 0 - 100")
        }
    }

}