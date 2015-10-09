public class Shot
{
	/**
	x: x-hnit Shot
	y: y-hnit Shot
	speed: hra�i, �kvar�ar hversu hratt Shot hreyfist yfir skj�inn
	direction: stefna Shot, ef 1 �� hreyfist Shot upp, ef -1 �� hreyfist Shot ni�ur
	me: Rectangle sem umlykur Shot
	type: myndin sem notu� er til �ess a� birta Shot
	*/
	private double x, y, speed;
	private int direction;
	private Rectangle me;
	private String type;
	
	//N: x = new Shot(x,y,d,s,t)
	//F: d er 1 e�a -1
	//E: x er Shot me� hnit (x,y), stefnu d, hra�a s og mynd t
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
	//E: a er hreyft til h�gri e�a vinstri um �a� sem nemur speed 
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
	//E: a prentast � skj�inn
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
	
	
	