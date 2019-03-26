package zadatak1;

import plusPackage.Formation;
import plusPackage.ManageableTeam;
import plusPackage.Manager;
import plusPackage.PlayingPosition;

public class Coach extends Person implements Manager {
	public static int DEFAULT_COACHINGSKILL = 50;
	public static Formation DEFAULT_FORMATION = Formation.F442;
	private int coachingSkill = DEFAULT_COACHINGSKILL;
	private Formation formation = DEFAULT_FORMATION;
	private ManageableTeam managingTeam;
	
	public Coach() {
		super();
	}
	
	public Coach(String name, String country, int emotion, int coachingSkill, Formation formation) {
		super(name, country, emotion);
		if(coachingSkill < 0 || coachingSkill > 100 || formation == null) {
			throw new IllegalArgumentException("nest ti nevalja");
		}
		this.coachingSkill = coachingSkill;
		this.formation = formation;
	}

	@Override
	public void pickStartingEleven() {
		int i = 0;
			for(int j = 0; j < managingTeam.getRegisteredPlayers().size(); j++) {
				if(managingTeam.getRegisteredPlayers().getPlayers()[j].getPlayingPosition() == PlayingPosition.FW && i <managingTeam.getFormation().getNoFW()) {
					managingTeam.addPlayerToStartingEleven(managingTeam.getRegisteredPlayers().getPlayers()[j]);
					i++;
				}	
			}
			
			i = 0;
			for(int j = 0; j < managingTeam.getRegisteredPlayers().size(); j++) {
				if(managingTeam.getRegisteredPlayers().getPlayers()[j].getPlayingPosition() == PlayingPosition.MF && i <managingTeam.getFormation().getNoMF()) {
					managingTeam.addPlayerToStartingEleven(managingTeam.getRegisteredPlayers().getPlayers()[j]);
					i++;
				}	
			}
			
			i = 0;
			for(int j = 0; j < managingTeam.getRegisteredPlayers().size(); j++) {
				if(managingTeam.getRegisteredPlayers().getPlayers()[j].getPlayingPosition() == PlayingPosition.DF && i <managingTeam.getFormation().getNoDF()) {
					managingTeam.addPlayerToStartingEleven(managingTeam.getRegisteredPlayers().getPlayers()[j]);
					i++;
				}	
			}
			
			for(int j = 0; j < managingTeam.getRegisteredPlayers().size(); j++) {
				if(managingTeam.getRegisteredPlayers().getPlayers()[j].getPlayingPosition() == PlayingPosition.GK) {
					managingTeam.addPlayerToStartingEleven(managingTeam.getRegisteredPlayers().getPlayers()[j]);
					break;
				}	
			}
		}	

	@Override
	public void forceMyFormation() {
		managingTeam.setFormation(this.formation);
	}

	@Override
	public void setManagingTeam(ManageableTeam team) {
		if(team != null) {
			managingTeam = team;
		}
	}

	public int getCoachingSkill() {
		return coachingSkill;
	}

	public void setCoachingSkill(int coachingSkill) {
		this.coachingSkill = coachingSkill;
	}

}
