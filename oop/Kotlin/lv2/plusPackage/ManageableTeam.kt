package plusPackage

import zadatak1.FootballPlayer
import zadatak1.SimpleFootballPlayerCollectionImpl

interface ManageableTeam {

    /**
     *
     * Adds a player to starting eleven if a player is in registered player
     * collection and there is a space for him within starting eleven.
     *
     * @param player
     *            player
     * @return true if a player is added, false otherwise.
     */
    fun addPlayerToStartingEleven(player: FootballPlayer): Boolean


    /**
     * Calculates and returns calculated team rating as follows:
     *
     * Club team: 70% sum of skills from registered players + 30% sum of emotions from registered players;
     *
     *
     * National team: 30% sum of skills from registered players + 70% sum of emotions from registered players.
     *
     * @return returns a team rating.
     */
    fun calculateRating(): Double


    /**
     * Clears a collection of starting eleven.
     */
    fun clearStartingEleven()


    /**
     * Checks whether a player is registered in a team.
     *
     * @param player
     *            player
     * @return true if a player is registered, false otherwise.
     */
    fun isPlayerRegistered(player: FootballPlayer): Boolean


    /**
     * If a team is a national team, a player need to have the same country as a national
     * team; whereas if a team is a club team, a player needs to have player
     * skill which is higher or equal to club's reputation (note: in either case
     * player registration will be successful if there is a space for a player)
     *
     * @param player
     *            player
     * @return true if a player is added, false otherwise.
     */
    fun registerPlayer(player: FootballPlayer): Boolean


    /**
     * Formation getter.
     *
     * @return formation
     */
    fun getTeamFormation(): Formation


    /**
     * Sets the formation if it is not null.
     *
     * @param formation
     *            formation
     */
    fun setTeamFormation(formation: Formation)


    /**
     * Returns a collection of starting eleven.
     *
     * @return starting eleven.
     */
    fun getTeamStartingEleven(): SimpleFootballPlayerCollectionImpl


    /**
     * Returns a collection of registered players.
     *
     * @return registered players.
     */
    fun getTeamRegisteredPlayers(): SimpleFootballPlayerCollectionImpl

}