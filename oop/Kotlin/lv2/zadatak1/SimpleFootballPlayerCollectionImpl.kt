package zadatak1

import plusPackage.SimpleFootballPlayerCollection

class SimpleFootballPlayerCollectionImpl(val maxArraySize: Int = 50): SimpleFootballPlayerCollection {
    var allPlayers = Array<FootballPlayer>(maxArraySize){FootballPlayer()}
    var size = 0
    var emotionSum = 0
    var skillSum = 0

    override fun add(player: FootballPlayer): Boolean {
        if (allPlayers.contains(player)) {
            return false
        }

        if (size == maxArraySize) {
            return false
        }

        allPlayers[size] = player
        size++
        emotionSum += player.emotion
        skillSum += player.playingSkill
        return true
    }

    override fun calculateEmotionSum(): Int {
        return emotionSum
    }

    override fun calculateSkillSum(): Int {
        return skillSum
    }

    override fun clear() {
        allPlayers = Array(maxArraySize){FootballPlayer()}
    }

    override fun contains(player: FootballPlayer): Boolean {
        for (thisPlayer in allPlayers) {
            if (thisPlayer.equals(player)) {
                return true
            }
        }
        return false
    }

    override fun getMaxSize(): Int {
        return maxArraySize
    }

    override fun getPlayers(): Array<FootballPlayer> {
        return allPlayers
    }

    override fun size(): Int {
        return size
    }
}