import java.util.*;

public class Game
{
	/**
	user: notendanafn spilara
	xwing: geimskip spilara
	enemyReload: �kvar�ar erfi�leikastig leiksins, �vinir skj�ta meira �egar enemyReload l�kkar
	xhnit: x-hnit skota fr�  �vinum
	yhnit: y-hnit skota fr� �vinum
	gameOver: gameOver ver�ur true �egar spilari hefur tapa�
	counter: fj�ldi ramma sem vi� birtum sprengingarmynd
	tiefighters: Array list sem inniheldur alla �vini
	laser: Array list sem inniheldur skot fr� spilara
	enemyLaser: Array list sem inniheldur skot fr� �vinum
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
	//E: x er n�r leikur me� notanda username
	public Game(String user)
	{
		this.user = user;
		this.gameOver = false;
	}
	
	//B�r til geimskip notanda og �vini
	//N: a.initialize()
	//F: a er Game
	//E: B�i� er a� b�a til og sta�setja �vini og notanda
	public void initialize()
	{
		buildTieFighters();
		this.enemyReload = 0.98;
		this.xwing = new Xwing(0.5,0,0.04,0.04);
	}
	
	//N: a.play()
	//F: a er Game, b�i� a� keyra a.initialize()
	//E: leikurinn byrjar
	public void play(String playerName)
	{
		int playerScore = 0;
		while(!this.gameOver)
		{
			String Skorid = Integer.toString(playerScore);
		
			if(tiefighters.isEmpty()) // n�sta level
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
					timeNow = sw.elapsedTime(); // t�mataka
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
	//E: b�i� a� b�ta vi� 15 �vinum � tiefighters array listann og sta�setja �� � efra vinstra horni skj�sins
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
	//E: �vinir prenta�ir � skj�inn
	public void showTieFighters()
	{
		for(int i = 0; i < tiefighters.size(); i++)
		{
			tiefighters.get(i).show();
		}
	}
	
	//N: moveTieFighters()
	//F: ekkert
	//E: �vinir eru hreyf�ir til h�gri, vinstri e�a ni�ur eftir �v� hvar �eir eru sta�settir
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
	//E: notandi sk�tur og/e�a skoti� er hreyft �samt �v� a� vera prenta� � skj�inn
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
	//E: �vinur sk�tur og/e�a skoti� er prenta� � skj�inn, �ll skot eru hreyf�
	public void fightersFire()
	{
		if(Math.random() > this.enemyReload) //�vinur sk�tur a�eins ef Math.random gefur h�rri t�lu en enemy reload
		{
			int shooter = (int) (Math.random()*tiefighters.size());
			enemyLasers.add(new Shot(tiefighters.get(shooter).getX(), tiefighters.get(shooter).getY(), -1, 0.03, "shot3.gif"));
			StdAudio.play("LAZER.wav");
			StdAudio.close();
		}
		if(!enemyLasers.isEmpty()) //hreyfum �ll skot
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
	//E: ef �vinur og skot fr� notanda skerast er vi�komandi �vinur fjarl�g�ur �r array listanum
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
	//F: notandi er enn � l�fi, xwing.getHealth() gefur st�rra en 0
	//E: this.gameOver = true ef skot fr� �vini sker notanda, e�a ef �vinir komast alla lei� ni�ur
	public void isGameOver(String playerName, int playerScore)
	{
		//Athugum hvort notandi sker skot fr� �vini
		for(int i = 0; i < enemyLasers.size(); i++)
		{
			if(enemyLasers.get(i).getRec().intersects(xwing.getRec()))
			{
				xwing.setHealth(xwing.getHealth() - 1); //Notandi missir health
			}
		}
		
		if(xwing.getHealth() <= 0) //Ef notandi er dau�ur
		{
			this.gameOver = true; //leik loki�, game l�ppa h�ttir a� keyra
			HighScores.Start(playerName, playerScore);
		}
		
		for(int j = 0; j < tiefighters.size(); j++)
		{
			if(tiefighters.get(j).getY() <= 0) //Ef �vinur kemst alla lei� ni�ur
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
