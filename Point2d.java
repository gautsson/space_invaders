public class Point2D 
{
    //Tilviksbreytur
	private final double x,y;

	//N: x = new Point2D(a,b)
	//F: ekkert
	//E: x er punkturinn (a,b) í tvívíðu plani
    public Point2D(double x, double y) 
	{
		this.x = x;
		this.y = y;
    }

    //N: a = b.getX()
	//F: ekkert
	//E: a er x-hnit punktins b
	public double getX() { return x;}
    
    //N: a = b.getY()
	//F: ekkert
	//E: a er y-hnit punktins b
	public double getY() { return y;}
	
	//N: x = a.distanceTo(b)
	//F: ekkert
	//E: x er fjarlægðin milli a og b (í tvívíðu rúmi)
	public double distanceTo(Point2D b)
	{
		double distance = (this.x - b.x)*(this.x - b.x) + (this.y - b.y)*(this.y - b.y);
		distance = Math.sqrt(distance);
		return distance;
	}
	
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
}