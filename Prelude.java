public class Prelude
{ 
    public static void main(String[] args) 
	{
		String playerName = Intro();
	}
	
	// Notkun: playerName (strengur) = enterName();
	// Fyrir: Ekkert
	// Eftir: playerName (strengur) er nafn spilarans
	private static String enterName()
	{
		System.out.println();
		System.out.println("Please enter your player name!");
		System.out.println();
		
		String playerName = StdIn.readString();
		
		while (playerName.length() > 20) // ef nöfnin eru of löng fara high score listinn og byrjunarsýningin í hakk!
		{
			System.out.println();
			System.out.println("That name is too long! Try a shorter one.");
			System.out.println();
			
			playerName = StdIn.readString();
		}
		
		System.out.println();
		System.out.println("Hang on a second, " + playerName + ", and may the force be with you...");
		return playerName;
	}
	
	
	// Notkun: playerName (strengur) = Intro();
	// Fyrir: Ekkert
	// Eftir: playerName (strengur) er nafn spilarans, byrjunarsýning spilast þar til að spilari ýtir á einhvern takka
	public static String Intro()
	{
		String playerName = enterName();
		
		// spilum lag með leiknum!
		StdAudio.loop("Prelude.mid");
		
		// eftir hversu margar sek hreyfitextinn birtist
		double appearTime = 1.5;
		
		// x-ás staðsetning hreyfitexta
        double rx = 0.5; 
		
		// y-ás staðsetning hreyfitexta
		double ry1 = 0.15;    
		double ry2 = 0.15;     
		double ry3 = 0.15; 
		double ry4 = 0.15; 
		double ry5 = 0.15; 
		double ry6 = 0.15; 
		double ry7 = 0.15; 
		double ry8 = 0.15; 
		double ry9 = 0.15;
		double ry10 = 0.15;		
		
		// hraði texta á y-ás
        double vy = .001;
		
		// y-hnit textans þar sem hann hverfur
		double finalry = 0.75;

		Stopwatch sw = new Stopwatch(); // til að taka tímann
		
        // hreyfimyndalykkjan
        while (!StdDraw.hasNextKeyTyped()) 
		{ 
			double timeNow = sw.elapsedTime(); // tímataka
			StdDraw.setPenColor();	// set svartan sem default lit		
            StdDraw.filledSquare(0.5, 0.5, 0.6); // bakgrunnur
			
			StdDraw.picture(0.5,1.0,"intrologo.png");
			StdDraw.picture(0.5,0.9,"pressanykey.png");
			
			if (timeNow < 4) // viljum ekki hafa þetta alltaf á skjánum, það er óþarfi
			{
				StdDraw.picture(0.5,0.03,"controls.png");
			}
			StdDraw.setPenColor(StdDraw.YELLOW);		
					
			if (timeNow >= appearTime && ry1 < finalry) // allar næstu if-setningarnar ganga út á að skrifa hreyfitextann
			{ 
				ry1 = ry1 + vy;
				StdDraw.text(rx, ry1, "Jedi Knight " + playerName + "! Your destiny awaits you!");
			}
			
			if (ry1 > 0.23 && ry2 < finalry)
			{
				ry2 = ry2 + vy;
				StdDraw.text(rx, ry2, "It is a period of civil war. Rebel spaceships, striking from a hidden");
			} 
			if (ry2 > 0.23 && ry3 < finalry)
			{
				ry3 = ry3 + vy;
				StdDraw.text(rx, ry3, "base, have won their first victory against the evil Galactic Empire. ");
			} 
			 if (ry3 > 0.23 && ry4 < finalry)
			{
				ry4 = ry4 + vy;
				StdDraw.text(rx, ry4, "During the battle, Rebel spies managed to obtain information about");
			} 
			if (ry4 > 0.23 && ry5 < finalry)
			{
				ry5 = ry5 + vy;
				StdDraw.text(rx, ry5, "the Empire's ultimate weapon, the Death Star, an armored space");
			} 
			if (ry5 > 0.23 && ry6 < finalry)
			{
				ry6 = ry6 + vy;
				StdDraw.text(rx, ry6, "station with enough power to destroy an entire planet.");
			} 
			if (ry6 > 0.33 && ry7 < finalry)
			{
				ry7 = ry7 + vy;
				StdDraw.text(rx, ry7, "While the death star is being built, it is defended by hordes of");
			} 
			if (ry7 > 0.23 && ry8 < finalry)
			{
				ry8 = ry8 + vy;
				StdDraw.text(rx, ry8, "so-called space invaders. You, " + playerName + ", have");
			} 
			if (ry8 > 0.23 && ry9 < finalry)
			{
				ry9 = ry9 + vy;
				StdDraw.text(rx, ry9, "been called upon to conquer these enemies once and for all!");
			}  
			if (ry9 > 0.23 && ry10 < finalry)
			{
				ry10 = ry10 + vy;
				StdDraw.text(rx, ry10, "May the force be with you.");
			}  
			
			StdDraw.show(20);
        } 
		//StdAudio.close();
		
		return playerName;
    }
} 