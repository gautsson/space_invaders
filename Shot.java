public class Shot
{
	/**
	x: x-hnit Shot
	y: y-hnit Shot
	speed: hraði, ákvarðar hversu hratt Shot hreyfist yfir skjáinn
	direction: stefna Shot, ef 1 þá hreyfist Shot upp, ef -1 þá hreyfist Shot niður
	me: Rectangle sem umlykur Shot
	type: myndin sem notuð er til þess að birta Shot
	*/
	private double x, y, speed;
	private int direction;
	private Rectangle me;
	private String type;
	
	//N: x = new Shot(x,y,d,s,t)
	//F: d er 1 eða -1
	//E: x er Shot með hnit (x,y), stefnu d, hraða s og mynd t
	public Shot(double x, double y, int dir, double speed, String type)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.direction = dir;
		this.type = type;
		this.me = new Rectangle(x, y, 0.01, 0.06);
	}
	
	//N: a.move()
	//F: a er Shot
	//E: a er hreyft til hægri eða vinstri um það sem nemur speed 
	public void move()
	{
		me.setY(this.y + this.speed * this.direction);
		this.y += this.speed * this.direction;
	}
	
	//N: x = a.getRec()
	//F: a er Shot
	//E: x er Rectangle sem umlykur a
	public Rectangle getRec()
	{
		return this.me;
	}
	
	//N: a.show()
	//F: a er Shot
	//E: a prentast á skjáinn
	public void show()
	{
		StdDraw.picture(this.x, this.y, type, 0.03, 0.07);
	}
	
	/*
	public void setX(double x)
	{
		this.x = x;
	}
	*/
	
	//N: a.setY(y)
	//F: a er Shot
	//E: a.y = y
	public void setY(double y)
	{
		this.y = y;
	}
	
	//N: x = a.getX()
	//F: a er Shot
	//E: x = a.x
	public double getX()
	{
		return this.x;
	}
	
	//N: x = a.getY()
	//F: a er Shot
	//E: x = a.y
	public double getY()
	{
		return this.y;
	}
	
	//N: x = a.getType()
	//F: a er Shot
	//E: x = a.type
	public String getType()
	{
		return this.type;
	}
}
	
	
	