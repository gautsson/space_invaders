public class TieFighter
{
	/**
	x: x-hnit TieFighter
	y: y-hnit TieFighter
	speed: hraði, ákvarðar hversu hratt TieFighter hreyfist yfir skjáinn
	wi: breidd TieFighter
	hi: hæð Tiefighter
	diection: stefna, ef -1 þá hreyfist TieFighter til vinstri, ef 1 þá hreyfist TieFighter til hægri
	image: myndin sem notuð er til þess að birta TieFighter
	me: Rectangle sem umlykur TieFighter
	 */
	private double x, y, speed;
	private final double wi, hi;
	private int direction;
	private String image;
	public Rectangle me;
	
	//N: a = new TieFighter(x,y,w,h)
	//F: ekkert
	//E: a er TieFighter með hnit (x,y), breidd w og hæð h
	public TieFighter(double x, double y, double w, double h)
	{
		this.x = x;
		this.y = y;
		this.wi = w;
		this.hi = h;
		this.speed = 0.03;
		this.image = "tfighter.png";
		this.me = new Rectangle(x, y, w, h);
		this.direction = 1;
	}
	
	//N: a.move()
	//F: a er TieFighter
	//E: a er hreyfður til hægri eða vinstri um það sem nemur speed/7
	public void move()
	{
		if(this.direction == 1)
		{
			me.setX(this.x + speed/7);
			this.x += speed/7; //Move right
		}
		else if(this.direction == -1)
		{
			me.setX(this.x - speed/7);
			this.x -= speed/7; //Move left	
		}
	}
	
	//N: a.moveDown()
	//F: a er TieFighter
	//E: a er færður niður um það sem nemur speed+0.05
	public void moveDown()
	{
		me.setY(this.y - speed);
		this.y -= speed+0.05;
		this.direction *= -1;
	}
	
	//N: x = a.getRec()
	//F: a er TieFighter
	//E: x er Rectangle sem umlykur a
	public Rectangle getRec()
	{
		return this.me;
	}
	
	//N: x = a.getDirection()
	//F: a er TieFighter
	//E: x = a.direction()
	public int getDirection()
	{
		return this.direction;
	}
	
	//N: a.setDirection(d)
	//F: a er TieFighter, d er 1 eða -1
	//E: a.direction = d
	public void setDirection(int d)
	{
		this.direction = d;
	}
	
	//N: x = a.getX()
	//F: a er TieFighter
	//E: x er x-hnit a
	public double getX()
	{
		return this.x;
	}
	
	//N: x = a.getY()
	//F: a er TieFighter
	//E: x er y-hnit a
	public double getY()
	{
		return this.y;
	}
	
	//N: a.show()
	//F: a er TieFighter
	//E: a prentast á skjáinn
	public void show()
	{
		StdDraw.picture(x,y,image,0.08,0.08);
	}
	
	public static void main(String args[])
	{
		TieFighter vader = new TieFighter(0,1,1,1);
		while(true)
		{
			vader.show();
			StdDraw.show(10);
			vader.move();
			StdDraw.clear();
		}
	}
}
	
	
