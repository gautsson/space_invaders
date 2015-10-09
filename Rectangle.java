public class Rectangle extends Shape
{
	//Tilviksbreytur
	//Fastayr�ing gagna: x og y eru raunt�lur
	//                   width og height eru st�rri en 0
	private double x, y; 
	private double width, height;
	
	//N: x = new Rectangle(a,b,c,d)
	//F: ekkert
	//E: x er r�tthyrningur me� mi�ju � (a,b), breidd c og h�� d
	public Rectangle(double x0, double y0, double w, double h)
	{
		x = x0;
		y = y0;
		width = w;
		height = h;
	}
	
	//N: x = a.getCenter()
	//F: ekkert
	//E: x er punkturinn � mi�ju a
	public Point2D getCenter()
	{
		return new Point2D(this.x, this.y);
	}
	
	//N: x = a.getBoundingBox()
	//F: ekkert
	//E: x er minnsti ferhyrningur sem passar utan um a
	public Rectangle getBoundingBox()
	{
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
	
	//N: c = a.intersects(b)
	//F: ekkert
	//E: c er true ef a og b skarast
	public boolean intersects(Shape o)
	{
		Rectangle thatBox = o.getBoundingBox();
		Rectangle thisBox = this.getBoundingBox();
		boolean r = true;
		r = r && thisBox.getXInterval().intersects(thatBox.getXInterval());
		r = r && thisBox.getYInterval().intersects(thatBox.getYInterval());
		return r;
	}
	
	//N: a.scale(f)
	//F: f > 0
	//E: a er f-sinnum st�rra og mi�jan er �breytt
	public void scale(double f)
	{
		if(f <= 0) throw new RuntimeException("Input <= 0");
		this.setWidth(this.width * f);
		this.setHeight(this.height * f);
	}

	// Notkun: xb = a.getXInterval()
	// Fyrir: ekkert
	// Eftir: xb er bili� fyrir x-�sinn
	public Interval getXInterval()
	{
		return new Interval(this.getX() - this.getWidth()/2, this.getX() + this.getWidth()/2);
	}
	
	// Notkun: yb = a.getYInterval()
	// Fyrir: ekkert
	// Eftir: yb er bili� fyrir y-�sinn
	public Interval getYInterval()
	{
		return new Interval(this.getY() - this.getHeight()/2, this.getY() + this.getHeight()/2);
	}
	
	//N: a = b.getX()
	//F: ekkert
	//E: a er x-hnit mi�ju b
	private double getX()
	{
		return this.x;
	}
	
	//N: a = b.getY()
	//F: ekkert
	//E: a er y-hnit mi�ju b
	private double getY()
	{
		return this.y;
	}
	
	//N: x = a.getWidth()
	//F: ekkert
	//E: x er breidd a
	public double getWidth()
	{
		return this.width;
	}
	
	//N: x = a.getHeight()
	//F: ekkert
	//E: x er h�� a
	public double getHeight()
	{
		return this.height;
	}
	
	//N: a.setWidth(w)
	//F: w > 0
	//E: breidd a er n� w
	public void setWidth(double w)
	{
		if(w <= 0) throw new RuntimeException("Width must be larger than 0");
		this.width = w;
	}
	
	//N: a.setHeight(h)
	//F: h > 0
	//E: h�� a er n� h
	public void setHeight(double h)
	{
		if(h <= 0) throw new RuntimeException("Height must be larger than 0");
		this.height = h;
	}
	
	public void setX(double x)
	{	this.x = x;	}
	
	public void setY(double y)
	{	this.y = y;	}
	
	public void show()
	{
		StdDraw.filledRectangle(this.x, this.y, this.width/2, this.height/2);
	}
}
		
		
		