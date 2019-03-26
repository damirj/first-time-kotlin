package zadatak1;

import plusPackage.PlayingPosition;

public class FootballPlayer extends Person {

	public static int DEFAULT_PLAYINGSKILL = 50;
	public static PlayingPosition DEFAULT_PLAYPOSITION = PlayingPosition.MF;
	private int playingSkill = DEFAULT_PLAYINGSKILL;
	private PlayingPosition playingPostion = DEFAULT_PLAYPOSITION;
	
	public FootballPlayer() {
		super();
	}
	
	public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition) {
		super(name, country, emotion);
		
		if(playingSkill < 0 || playingSkill > 100 || playingPosition == null) {
			throw new IllegalArgumentException("nest ti nevalja");
		}
		
		this.playingSkill = playingSkill;
		this.playingPostion = playingPosition;
	}
	
	public int getPlayingSkill() {
		return playingSkill;
	}

	public void setPlayingSkill(int playingSkill) {
		this.playingSkill = playingSkill;
	}

	public PlayingPosition getPlayingPosition() {
		return playingPostion;
	}

	public void setPlayingPostion(PlayingPosition playingPostion) {
		this.playingPostion = playingPostion;
	}
}
