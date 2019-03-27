package plusPackage

interface Manager {


    /**
     * A manager uses his formation to set team's formation.
     */
    fun forceMyFormation()


    /**
     * A method used to pick the starting eleven from a team he manages (NOTE: only the players
     * from registered players collection are eligible);
     * a method must be careful to pick such players who can form a team formation
     * (e.g., a number of forwards within first eleven should match a number of forwards in a team formation).
     */
    fun pickStartingEleven()
}