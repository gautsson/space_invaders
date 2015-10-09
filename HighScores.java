public class HighScores
{
	public static void main(String[] args) // nota� ef testa �arf klasann � heild sinni
	{
		int playerScore = 20000;					
		String playerName = "TestNameJustForFun"; 
		boolean playerFound = enterScores(playerScore, playerName); 
		HighScoreScreen(playerName, playerFound);
	}
	
	// Notkun: Start(playerName, playerScore)
	// Fyrir: playerName (strengur) er nafn spilara, playerScore (int) er stigafj�ldinn sem hann f�kk
	// Eftir: Falli� HighScoreScreen er keyrt
	public static void Start(String playerName, int playerScore)
	{
		boolean playerFound = enterScores(playerScore, playerName); 
		HighScoreScreen(playerName, playerFound);
	}
	
	// Notkun: HighScoreScreen(playerName, playerFound)
	// Fyrir: playerFound (boolean) er true ef spilari komst a high score listann, annars false. playerName er nafn spilarans
	// Eftir: Skj�r me� high score lista birtist
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
			StdDraw.text(0.5, 0.0, "Bj�rn Sigur�sson, Halld�r Vilhj�lmsson, �orvaldur Gautsson");
			
			In inn = new In("Highscores.csv"); // lesum Highscores.csv til a� birta 
			double ry = 0.6; // y-hnit fyrir fyrsta s�ti � high scores listanum
			int placing = 1; // sta�setning � listanum
			while (inn.hasNextLine()) 
			{
				String line = inn.readLine();
				String[] fields = line.split(",");

				String Player = fields[0];
				String Score = fields[1];
				
				if (!Player.equals("")) // birtum bara allar l�nurnar ef 10 spilarar hafa spila�
				{
					StdDraw.text(0.5, ry, placing + ") " + Player + " ---- " + Score + " points");
					ry = ry - 0.05;
					placing++;
				}
			
			}
			
 			if (StdDraw.isKeyPressed(82)) // ef �tt er � R endursetjum vi� high scores listann
			{
				eraseHighscores();
			} 
			
			StdDraw.show(20);
        }
		
 		if (StdDraw.isKeyPressed(10)) // ef �tt er � enter spilum vi� leikinn aftur!
		{
			Game a = new Game(playerName);
			a.initialize();
			a.play(playerName);
		}
		
		if (StdDraw.isKeyPressed(88)) // ef �tt er � x h�ttum vi�...
		{
			System.exit(0);
		} 
	}
	
	
	// Notkun: playerFound = enterScores(playerScore, playerName)
	// Fyrir: playerScore (int) eru stig spilarans, playerName (strengur) er nafn spilarans
	// Eftir: playerFound (boolean) er true ef spilari komst a high score listann, annars false. Einnig hefur veri� skrifu� �t .csv skr� me� 
	// uppf�r�um lista yfir high scores � leiknum.
    public static boolean enterScores(int playerScore, String playerName)
	{	
		boolean playerFound = false; 	// ver�ur true ef vi� h�fum fundi� spilara � listanum sem hefur l�gra skor en s� sem var a� spila
		int NextScoreCheck = 0; 		//  millibreyta sem er notu� til �ess a� r�lla skorunum � �llum s�tum ni�ur um 1 ef spilari n�r high scori
		String NextNameCheck = ""; 		// millibreyta sem er notu� til �ess a� r�lla skorunum � �llum n�fnum ni�ur um 1 ef spilari n�r high scori
		
        // lesum inn input og skilgreinum output skr�na
        In inn1 = new In("Highscores.csv");
		Out out1 = new Out("HighscoresTEMP.csv"); // getum ekki yfirskrifa� s�mu skr� og vi� lesum inn fr�, svo vi� b�um til n�ja

        while (inn1.hasNextLine()) 
		{
            String line = inn1.readLine();
            String[] fields = line.split(","); // skiptum �llum strengjunum � tvennt

			String Player = fields[0]; // nafn spilara
			String Score = fields[1]; // skor spilara
			int ScoreInt = Integer.parseInt(Score);
			
			if (playerFound == false && playerScore > ScoreInt) // ef vi� fundum spilara � high score listanum sem er me� l�gra skor
			{
				NextScoreCheck = ScoreInt; // gefum millibreytunni gildi� � gamla skorinu
				NextNameCheck = Player; // gerum �a� sama me� n�fnin
				
				ScoreInt = playerScore; // gefum skorinu � �essu tiltekna s�ti gildi� � n�ja skorinu
				Score = Integer.toString(playerScore);
				Player = playerName; // breytum nafni spilara � n�ja nafni�
				playerFound = true; // viljum ekki detta � �essa l�ppu aftur, annars yfirskrifast �ll s�tin me� hinu n�ja skori
				
			}
			
			if (NextScoreCheck > ScoreInt) // �etta l�kkar �ll s�ti � listanum um einn eftir a� s�ti spilara � high score lista hefur veri� �kvar�a�
			{
				int millibreyta = ScoreInt;
				String millistrengur = Player;
				
				Score = Integer.toString(NextScoreCheck);
				Player = NextNameCheck;
		
				NextScoreCheck = millibreyta;
				NextNameCheck = millistrengur;
			}
		
			out1.println(Player + "," + Score); // skrifum �t � .csv skr�na n�fn spilara og skor �eirra

        }
		out1.close();	
		
		//T�kum h�r gildin �r temporary skjalinu og setjum �au � upprunalega skjali�
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
	// Eftir: 10 l�nur af strengnum ",0" hafa veri� skrifa�ar � skr�na Highscores.csv
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
