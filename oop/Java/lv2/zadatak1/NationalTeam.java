package zadatak1;

import plusPackage.Formation;

public class NationalTeam extends Team {
	public static int DEFAULT_MAXPLAYERS = 23;
	public static String DEFAULT_COUNTRY = "Noland";
	final private String country;
	
	public NationalTeam(String name, Formation formation, String country) {
		super(DEFAULT_MAXPLAYERS, name, formation);
		this.country = country;
	}
	
	public NationalTeam() {
		super(DEFAULT_MAXPLAYERS);
		this.country = DEFAULT_COUNTRY;
	}
	
	@Override
	public boolean registerPlayer(FootballPlayer player) {
		if(player.getCountry() == country && !getRegisteredPlayers().contains(player) && getRegisteredPlayers().add(player)) {
			return true;
		}
		return false;
	}
	
	@Override
	public double calculateRating() {
		return (0.3 * getRegisteredPlayers().calculateSkillSum() + 0.7 * getRegisteredPlayers().calculateEmotionSum());
	}
	
}
