public class HighScores
{
	public static void main(String[] args) // notað ef testa þarf klasann í heild sinni
	{
		int playerScore = 20000;					
		String playerName = "TestNameJustForFun"; 
		boolean playerFound = enterScores(playerScore, playerName); 
		HighScoreScreen(playerName, playerFound);
	}
	
	// Notkun: Start(playerName, playerScore)
	// Fyrir: playerName (strengur) er nafn spilara, playerScore (int) er stigafjöldinn sem hann fékk
	// Eftir: Fallið HighScoreScreen er keyrt
	public static void Start(String playerName, int playerScore)
	{
		boolean playerFound = enterScores(playerScore, playerName); 
		HighScoreScreen(playerName, playerFound);
	}
	
	// Notkun: HighScoreScreen(playerName, playerFound)
	// Fyrir: playerFound (boolean) er true ef spilari komst a high score listann, annars false. playerName er nafn spilarans
	// Eftir: Skjár með high score lista birtist
	private static void HighScoreScreen(String playerName, boolean playerFound)
	{
		// animation lykkjan
        while (!StdDraw.isKeyPressed(10) && !StdDraw.isKeyPressed(88)) 
		{ 
			StdDraw.setPenColor();	// set svartan sem default lit		
			StdDraw.filledSquare(0.5, 0.5, 0.6); // bakgrunnur
			
			StdDraw.picture(0.5,1.0,"intrologo.png");
			
			StdDraw.setPenColor(StdDraw.YELLOW);		
			
			if (playerFound == true)
			{
				StdDraw.text(0.5, 0.9, "You made the high score table, " + playerName + "! Congrats!");
			}
			else
			{
				StdDraw.text(0.5, 0.9, "You did not make the high score table, " + playerName + ".");
			}
			
			StdDraw.text(0.5, 0.85, "Press the ENTER key to try again, or the X key to exit the game.");
			StdDraw.text(0.5, 0.80, "Press the R key to reset the high scores.");
			StdDraw.picture(0.5,0.70,"highscores.png");
			
			StdDraw.text(0.5, 0.05, "Game programmed by:");
			StdDraw.text(0.5, 0.0, "Björn Sigurðsson, Halldór Vilhjálmsson, Þorvaldur Gautsson");
			
			In inn = new In("Highscores.csv"); // lesum Highscores.csv til að birta 
			double ry = 0.6; // y-hnit fyrir fyrsta sæti á high scores listanum
			int placing = 1; // staðsetning á listanum
			while (inn.hasNextLine()) 
			{
				String line = inn.readLine();
				String[] fields = line.split(",");

				String Player = fields[0];
				String Score = fields[1];
				
				if (!Player.equals("")) // birtum bara allar línurnar ef 10 spilarar hafa spilað
				{
					StdDraw.text(0.5, ry, placing + ") " + Player + " ---- " + Score + " points");
					ry = ry - 0.05;
					placing++;
				}
			
			}
			
 			if (StdDraw.isKeyPressed(82)) // ef ýtt er á R endursetjum við high scores listann
			{
				eraseHighscores();
			} 
			
			StdDraw.show(20);
        }
		
 		if (StdDraw.isKeyPressed(10)) // ef ýtt er á enter spilum við leikinn aftur!
		{
			Game a = new Game(playerName);
			a.initialize();
			a.play(playerName);
		}
		
		if (StdDraw.isKeyPressed(88)) // ef ýtt er á x hættum við...
		{
			System.exit(0);
		} 
	}
	
	
	// Notkun: playerFound = enterScores(playerScore, playerName)
	// Fyrir: playerScore (int) eru stig spilarans, playerName (strengur) er nafn spilarans
	// Eftir: playerFound (boolean) er true ef spilari komst a high score listann, annars false. Einnig hefur verið skrifuð út .csv skrá með 
	// uppfærðum lista yfir high scores í leiknum.
    public static boolean enterScores(int playerScore, String playerName)
	{	
		boolean playerFound = false; 	// verður true ef við höfum fundið spilara á listanum sem hefur lægra skor en sá sem var að spila
		int NextScoreCheck = 0; 		//  millibreyta sem er notuð til þess að rúlla skorunum í öllum sætum niður um 1 ef spilari nær high scori
		String NextNameCheck = ""; 		// millibreyta sem er notuð til þess að rúlla skorunum í öllum nöfnum niður um 1 ef spilari nær high scori
		
        // lesum inn input og skilgreinum output skrána
        In inn1 = new In("Highscores.csv");
		Out out1 = new Out("HighscoresTEMP.csv"); // getum ekki yfirskrifað sömu skrá og við lesum inn frá, svo við búum til nýja

        while (inn1.hasNextLine()) 
		{
            String line = inn1.readLine();
            String[] fields = line.split(","); // skiptum öllum strengjunum í tvennt

			String Player = fields[0]; // nafn spilara
			String Score = fields[1]; // skor spilara
			int ScoreInt = Integer.parseInt(Score);
			
			if (playerFound == false && playerScore > ScoreInt) // ef við fundum spilara á high score listanum sem er með lægra skor
			{
				NextScoreCheck = ScoreInt; // gefum millibreytunni gildið á gamla skorinu
				NextNameCheck = Player; // gerum það sama með nöfnin
				
				ScoreInt = playerScore; // gefum skorinu í þessu tiltekna sæti gildið á nýja skorinu
				Score = Integer.toString(playerScore);
				Player = playerName; // breytum nafni spilara í nýja nafnið
				playerFound = true; // viljum ekki detta í þessa lúppu aftur, annars yfirskrifast öll sætin með hinu nýja skori
				
			}
			
			if (NextScoreCheck > ScoreInt) // þetta lækkar öll sæti á listanum um einn eftir að sæti spilara á high score lista hefur verið ákvarðað
			{
				int millibreyta = ScoreInt;
				String millistrengur = Player;
				
				Score = Integer.toString(NextScoreCheck);
				Player = NextNameCheck;
		
				NextScoreCheck = millibreyta;
				NextNameCheck = millistrengur;
			}
		
			out1.println(Player + "," + Score); // skrifum út í .csv skrána nöfn spilara og skor þeirra

        }
		out1.close();	
		
		//Tökum hér gildin úr temporary skjalinu og setjum þau í upprunalega skjalið
        In inn2 = new In("HighscoresTEMP.csv");
		Out out2 = new Out("Highscores.csv");
        while (inn2.hasNextLine()) 
		{
            String line = inn2.readLine();
            String[] fields = line.split(",");

			String Player = fields[0];
			String Score = fields[1];
			
			out2.println(Player + "," + Score);
        }
		out2.close();
		
		return playerFound;
    }
	
	// Notkun: eraseHighscores()
	// Fyrir: Ekkert
	// Eftir: 10 línur af strengnum ",0" hafa verið skrifaðar í skrána Highscores.csv
	private static void eraseHighscores()
	{	
		Out out = new Out("Highscores.csv");
		
		for (int i = 1; i < 11; i++)
		{
			out.println(",0");
		}
		out.close();
	}
} 
