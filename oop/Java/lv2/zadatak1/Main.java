package zadatak1;
import plusPackage.Formation;
import plusPackage.PlayingPosition;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Wello Hord");
		
		FootballPlayer damir = new FootballPlayer("Damir", "Croatia", 78, 99, PlayingPosition.DF);
		FootballPlayer josipa = new FootballPlayer("Josipa", "Hercegovina", 1, 99, PlayingPosition.GK);
		System.out.println( damir.getPlayingPosition() );
		
		ClubTeam NoviUsisivac = new ClubTeam("Novi Usisivac", Formation.F541, 30);
		NoviUsisivac.setFormation(Formation.F352);
		System.out.println(NoviUsisivac.registerPlayer(damir));
		System.out.println(NoviUsisivac.registerPlayer(josipa));
		NoviUsisivac.addPlayerToStartingEleven(damir);
		
		Coach dinko = new Coach("Dinko", "Croatia", 66, 88, Formation.F442);
		dinko.setManagingTeam(NoviUsisivac);
		dinko.forceMyFormation();
		System.out.println(NoviUsisivac.getFormation());
	}

}
