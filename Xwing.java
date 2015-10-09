import java.util.*;

public class Xwing
{
	/**
	x: x-hnit
	speed: hra�i, �kvar�ar hversu hratt Xwing hreyfist yfir skj�inn
	y: y-hnit Xwing, er alltaf 0
	wi: breidd Xwing
	hi: h�� Xwing
	image: myndin sem notu� er til �ess a� birta Xwing
	health: fj�ldi l�fa sem Xwing � eftir, � �essari �tg�fu hefur Xwing 1 l�f
	me: Rectangle sem umlykur Xwing
	 */
	private double x, speed;
	private final double y, wi, hi;
	private String image;
	private int health;
	public Rectangle me;
	
	//N: a = new Xwing(x,y,w,h)
	//F: ekkert
	//E: a er Xwing me� hnit (x,y), breidd w og h�� h
	public Xwing(double x, double y, double w, double h)
	{
		this.x = x;
		this.y = y;
		this.wi = w;
		this.hi = h;
		this.speed = 0.02;
		this.image = "x_wing.gif";
		this.me = new Rectangle(x, y, w, h);
		this.health = 1;
	}
	
	//N: a.move()
	//F: a er Xwing
	//E: a er f�r�ur til h�gri e�a vinstri
	public void move()
	{
		if(StdDraw.isKeyPressed(39)) this.moveRight();
		else if(StdDraw.isKeyPressed(37)) this.moveLeft();
	}
	
	//N: a.moveLeft()
	//F: a er Xwing
	//E: a er f�r�ur til vinstri um �a� sem nemur hra�a a
	private void moveLeft()
	{	
		me.setX(this.x - speed);
		this.x -= speed;
		if(this.x < 0) this.x = 0;
	}
	
	//N: a.moveRight()
	//F: a er Xwing
	//E: a er f�r�ur til h�gri um �a� sem nemur hra�a a
	private void moveRight()
	{
		me.setX(this.x + speed);
		this.x += speed;
		if(this.x > 1) this.x = 1;
	}
	
	//N: x = a.getRec()
	//F: a er Xwing
	//E: x er Rectangle sem umlykur a
	public Rectangle getRec()
	{
		return this.me;
	}
	
	//N: x = a.getX()
	//F: a er Xwing
	//E: x er x-hnit a
	public double getX()
	{
		return this.x;
	}
	
	//N: a.show()
	//F: a er Xwing
	//E: a prentast � skj�inn
	public void show()
	{
		StdDraw.picture(x,y,image,0.08,0.08);
	}
	
	//N: x = a.isDead()
	//F: a er Xwing
	//E: x er true ef a.health er 0 e�a minna, false annars
	public boolean isDead()
	{
		return this.health == 0;
	}
	
	//N: a.setHealth(h)
	//F: a er Xwing
	//E: a.health = h
	public void setHealth(int h)
	{
		this.health = h;
	}
	
	//N: x = a.getHealth()
	//F: a er Xwing
	//E: x = a.health
	public int getHealth()
	{
		return this.health;
	}
	
	public static void main(String args[])
	{
		Xwing luke = new Xwing(0.5,0,1,1);
		TieFighter vader = new TieFighter(0,1,1,1);
		while(true)
		{
			luke.show();
			vader.show();
			StdDraw.show(10);
			luke.move();
			vader.move();
			StdDraw.clear();
		}
	}
}