import java.util.*;

public class Game
{
	/**
	user: notendanafn spilara
	xwing: geimskip spilara
	enemyReload: ákvarðar erfiðleikastig leiksins, óvinir skjóta meira þegar enemyReload lækkar
	xhnit: x-hnit skota frá  óvinum
	yhnit: y-hnit skota frá óvinum
	gameOver: gameOver verður true þegar spilari hefur tapað
	counter: fjöldi ramma sem við birtum sprengingarmynd
	tiefighters: Array list sem inniheldur alla óvini
	laser: Array list sem inniheldur skot frá spilara
	enemyLaser: Array list sem inniheldur skot frá óvinum
	*/
	private String user;
	private Xwing xwing;
	private double enemyReload, xhnit, yhnit;
	private boolean gameOver;
    private int counter;
	
	ArrayList<TieFighter> tiefighters = new ArrayList<TieFighter>();
	ArrayList<Shot> laser = new ArrayList<Shot>();
	ArrayList<Shot> enemyLasers = new ArrayList<Shot>();
	
	//N: x = new Game(username)
	//F: ekkert
	//E: x er nýr leikur með notanda username
	public Game(String user)
	{
		this.user = user;
		this.gameOver = false;
	}
	
	//Býr til geimskip notanda og óvini
	//N: a.initialize()
	//F: a er Game
	//E: Búið er að búa til og staðsetja óvini og notanda
	public void initialize()
	{
		buildTieFighters();
		this.enemyReload = 0.98;
		this.xwing = new Xwing(0.5,0,0.04,0.04);
	}
	
	//N: a.play()
	//F: a er Game, búið að keyra a.initialize()
	//E: leikurinn byrjar
	public void play(String playerName)
	{
		int playerScore = 0;
		while(!this.gameOver)
		{
			String Skorid = Integer.toString(playerScore);
		
			if(tiefighters.isEmpty()) // næsta level
			{
				enemyLasers.clear();
				Stopwatch sw = new Stopwatch();
				double timeNow = 0;
				while (timeNow < 3)
				{
					StdDraw.clear();
					StdDraw.setPenColor();	// set svartan sem default lit		
					StdDraw.filledSquare(0.5, 0.5, 0.6); // bakgrunnur
					StdDraw.setPenColor(StdDraw.YELLOW);	
					StdDraw.text(0.5, 0.7, "Well done, " + playerName + "!");
					StdDraw.text(0.5, 0.6, "But harder enemies await you at the...");
					StdDraw.picture(0.5,1.0,"intrologo.png");
					StdDraw.picture(0.5,0.45,"next.png");
					timeNow = sw.elapsedTime(); // tímataka
					StdDraw.show(20);
				}
				buildTieFighters();
				this.enemyReload -= 0.02;
			} 
			StdDraw.clear();
			StdDraw.picture(0.5,0.5,"space1.jpg",1.2,1.2);
            StdDraw.picture(0.8,0.7,"star.png",0.2,0.2);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.text(0.97, 1.0, "Score: " + Skorid);
			showTieFighters();
			xwing.show();
			moveTieFighters();
			xwing.move();
			xwingFire();
			fightersFire();
			playerScore = removeEnemies(playerScore);
			isGameOver(playerName, playerScore);
			StdDraw.show(10);
		}	
	}
	
	//N: buildTieFighters()
	//F: ekkert
	//E: búið að bæta við 15 óvinum í tiefighters array listann og staðsetja þá í efra vinstra horni skjásins
	public void buildTieFighters()
	{
		double xPos = -0.1;
		double yPos = 1.15;
		for(int i = 0; i < 15; i++)
		{
			if(i % 5 == 0)
			{
				yPos -= 0.16;
				xPos = -0.1;
			}
			xPos += 0.15;
			tiefighters.add(new TieFighter(xPos,yPos,0.05,0.01));
		}
	}
	
	//N: showTieFighters()
	//F: ekkert
	//E: óvinir prentaðir á skjáinn
	public void showTieFighters()
	{
		for(int i = 0; i < tiefighters.size(); i++)
		{
			tiefighters.get(i).show();
		}
	}
	
	//N: moveTieFighters()
	//F: ekkert
	//E: óvinir eru hreyfðir til hægri, vinstri eða niður eftir því hvar þeir eru staðsettir
	public void moveTieFighters()
	{
		for(int i = 0; i < tiefighters.size(); i++)
		{
			tiefighters.get(i).move();
			boolean isOnEdge = tiefighters.get(i).getX() < 0 || tiefighters.get(i).getX() > 1;
			if(isOnEdge) tiefighters.get(i).moveDown();
		}
	}
	
	//N: xwingFire()
	//F: ekkert
	//E: notandi skýtur og/eða skotið er hreyft ásamt því að vera prentað á skjáinn
	public void xwingFire()
	{
		if(StdDraw.isKeyPressed(32) && laser.isEmpty())
		{
			laser.add(new Shot(xwing.getX(), 0, 1, 0.04, "shot.gif"));
			StdAudio.play("gunshot.wav");
			StdAudio.close();
		}
		if(!laser.isEmpty())
		{
			laser.get(0).show();
			laser.get(0).move();
		}
		if(!laser.isEmpty() && laser.get(0).getY() > 1.1)
		{
			laser.remove(0);
		}
	}
	
	//N: fightersFire()
	//F: ekkert
	//E: óvinur skýtur og/eða skotið er prentað á skjáinn, öll skot eru hreyfð
	public void fightersFire()
	{
		if(Math.random() > this.enemyReload) //óvinur skýtur aðeins ef Math.random gefur hærri tölu en enemy reload
		{
			int shooter = (int) (Math.random()*tiefighters.size());
			enemyLasers.add(new Shot(tiefighters.get(shooter).getX(), tiefighters.get(shooter).getY(), -1, 0.03, "shot3.gif"));
			StdAudio.play("LAZER.wav");
			StdAudio.close();
		}
		if(!enemyLasers.isEmpty()) //hreyfum öll skot
		{
			for(int i = 0; i < enemyLasers.size(); i++)
			{
				enemyLasers.get(i).show();
				enemyLasers.get(i).move();
				if(enemyLasers.get(i).getY() < -0.1)
				{
					enemyLasers.remove(i);
				}
			}
		}
	}
	
	//N: removeEnemies()
	//F: ekkert
	//E: ef óvinur og skot frá notanda skerast er viðkomandi óvinur fjarlægður úr array listanum
	public int removeEnemies(int playerScore)
	{
		if(!laser.isEmpty())
		{
			for(int i = 0; i < tiefighters.size(); i++)
			{
				if(laser.get(0).getRec().intersects(tiefighters.get(i).getRec()))
				{
					xhnit = laser.get(0).getX();
					yhnit = laser.get(0).getY();
                    counter = 10;
					laser.remove(0);
					tiefighters.remove(i);
					playerScore++;
					break;
				}
            }
        }
        if(counter > 0) //birtum sprengimynd
        {
            StdDraw.picture(xhnit,yhnit,"explosion.png",0.08,0.08);
            counter--;
        }
		return playerScore;
	}
	
	//N: isGameOver()
	//F: notandi er enn á lífi, xwing.getHealth() gefur stærra en 0
	//E: this.gameOver = true ef skot frá óvini sker notanda, eða ef óvinir komast alla leið niður
	public void isGameOver(String playerName, int playerScore)
	{
		//Athugum hvort notandi sker skot frá óvini
		for(int i = 0; i < enemyLasers.size(); i++)
		{
			if(enemyLasers.get(i).getRec().intersects(xwing.getRec()))
			{
				xwing.setHealth(xwing.getHealth() - 1); //Notandi missir health
			}
		}
		
		if(xwing.getHealth() <= 0) //Ef notandi er dauður
		{
			this.gameOver = true; //leik lokið, game lúppa hættir að keyra
			HighScores.Start(playerName, playerScore);
		}
		
		for(int j = 0; j < tiefighters.size(); j++)
		{
			if(tiefighters.get(j).getY() <= 0) //Ef óvinur kemst alla leið niður
			{
				this.gameOver = true;
				HighScores.Start(playerName, playerScore);
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		String playerName = Prelude.Intro();
		Game a = new Game(playerName);
		a.initialize();
		a.play(playerName);
	}
}
