package plusPackage

import zadatak1.FootballPlayer

interface SimpleFootballPlayerCollection {


    /**
     * Adds a player in a collection if he has not been previously added and if
     * there is a space available for a player within a collection.
     *
     * @param player
     *            player
     * @return true if a player is added, false otherwise.
     */
    fun add(player: FootballPlayer): Boolean


    /**
     * Calculates the sum of emotions from all players within a collection.
     *
     * @return the sum of emotions.
     */
    fun calculateEmotionSum(): Int


    /**
     * Calculates the sum of skills from all players within a collection.
     *
     * @return the sum of emotions.
     */
    fun calculateSkillSum(): Int


    /**
     * Clears all players from a collection.
     */
    fun clear()


    /**
     * Checks whether a collection contains a player.
     *
     * @param player
     *            player
     * @return true if a collection contains a player, false otherwise.
     */
    fun contains(player: FootballPlayer): Boolean


    /**
     * Maximum number of players who can be stored in a collection, e.g., if a
     * collection is used to store starting eleven then this method should
     * return 11;
     *
     * @return maximum number of players - a collection's capacity.
     */
    fun getMaxSize(): Int


    /**
     * Method used to get the underlying array in which players are actually stored.
     *
     * @return an array.
     */
    fun getPlayers(): Array<FootballPlayer>


    /**
     *
     * Returns the number of players currently stored in a collection.
     *
     * @return current number of players within a collection.
     */
    fun size(): Int
}