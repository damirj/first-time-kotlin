package zadatak1;

import plusPackage.Formation;
import plusPackage.ManageableTeam;
import plusPackage.SimpleFootballPlayerCollection;

public abstract class Team implements ManageableTeam{
	public static String DEFAULT_NAME = "TeamX";
	public static Formation DEFAULT_FORMATION = Formation.F442;
	public static int STARTING_ELEVEN = 11;
	final private String name;
	private Formation formation = DEFAULT_FORMATION;
	private SimpleFootballPlayerCollectionImpl registeredPlayers;
	private SimpleFootballPlayerCollectionImpl startingEleven = new SimpleFootballPlayerCollectionImpl(STARTING_ELEVEN);
	
	public Team(int numPlayers, String name, Formation formation) {
		if(numPlayers <= 0 || name == null || formation == null) {
			throw new IllegalArgumentException("neda mi se za svaku posebno");
		}
		registeredPlayers = new SimpleFootballPlayerCollectionImpl(numPlayers);
		this.name = name;
		this.formation = formation;
	}
	
	public Team(int numPlayers) {
		if(numPlayers <= 0) {
			throw new IllegalArgumentException("buraz moj tim ti nece ici");
		}
		registeredPlayers = new SimpleFootballPlayerCollectionImpl(numPlayers);
		this.name = DEFAULT_NAME;
	}
	

	@Override
	public boolean addPlayerToStartingEleven(FootballPlayer player) {
		if(registeredPlayers.contains(player)) {
			if(startingEleven.add(player) && !startingEleven.contains(player)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean isPlayerRegistered(FootballPlayer player) {
		if(registeredPlayers.contains(player)) {
			return true;
		}
		return false;
	}

	@Override
	public SimpleFootballPlayerCollection getRegisteredPlayers() {
		return registeredPlayers;
	}

	@Override
	public SimpleFootballPlayerCollection getStartingEleven() {
		return startingEleven;
	}


	@Override
	public void setFormation(Formation formation) {
		if(formation != null) {
			this.formation = formation;
		}
		
	}

	@Override
	public Formation getFormation() {
		return formation;
	}

	@Override
	public void clearStartingEleven() {
		startingEleven.clear();	
	}

	
}
