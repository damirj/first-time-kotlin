package zadatak1;
import plusPackage.SimpleFootballPlayerCollection;

public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection {
	public static int DEFAULT_MAXSIZE = 50;
	private int maxSize = DEFAULT_MAXSIZE;
	private FootballPlayer[] playerCollection = new FootballPlayer[maxSize];
	private int size = 0;
	private int emotionSum = 0;
	private int skillSum = 0;
	
	public SimpleFootballPlayerCollectionImpl(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public SimpleFootballPlayerCollectionImpl() {
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(FootballPlayer player) {
		for(int i = 0; i < size; i++) {
			if(playerCollection[i].equals(player)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(FootballPlayer player) {
		for(int i = 0; i < size; i++) {
			if(playerCollection[i].equals(player)) {
				return false;
			}
		}
		if(size == maxSize) {
			return false;
		    
		}
		playerCollection[size] = player;
		emotionSum += playerCollection[size].getEmotion();
		skillSum += playerCollection[size].getPlayingSkill();
		size++;
		return true;
	}

	@Override
	public void clear() {
		for(int i = 0; i < size; i++) {
			playerCollection[i] = null;
		}
		size = 0;	
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public int calculateEmotionSum() {
		return emotionSum;
	}

	@Override
	public int calculateSkillSum() {
		return skillSum;
	}

	@Override
	public FootballPlayer[] getPlayers() {
		return playerCollection;
	}

}
