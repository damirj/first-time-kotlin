package zadatak1;

import plusPackage.Formation;

public class ClubTeam extends Team{
	public static int DEFAULT_MAXPLAYERS = 25;
	public static int DEFAULT_REPUTATION = 50;
	private int reputation = DEFAULT_REPUTATION;
	
	public ClubTeam(String name, Formation formation, int reputation) {
		super(DEFAULT_MAXPLAYERS, name, formation);
		if(reputation < 0 || reputation > 100) {
			throw new IllegalArgumentException("Izvan raspona");
		}
		this.reputation = reputation;
	}
	
	public ClubTeam() {
		super(DEFAULT_MAXPLAYERS);
	}
	
	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		if(reputation < 0 || reputation > 100) {
			throw new IllegalArgumentException("Izvan raspona");
		}
		this.reputation = reputation;
	}

	@Override
	public boolean registerPlayer(FootballPlayer player) {
		if(player.getPlayingSkill() >= this.reputation && !getRegisteredPlayers().contains(player) && getRegisteredPlayers().add(player)) {
			return true;
		}
		return false;
	}
	
	@Override
	public double calculateRating() {
		return (0.7 * getRegisteredPlayers().calculateSkillSum() + 0.3 * getRegisteredPlayers().calculateEmotionSum());
	}
}
