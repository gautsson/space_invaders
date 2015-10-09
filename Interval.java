public class Interval 
{
	private final double left,right;
	// táknar bilið [left,right] ef left <= right, annars tóma mengið
	
	// Notkun: a = new Interval(left,right)
	// Fyrir: ekkert
	// Eftir: a er bilið [left,right] ef left <= right, annars tóma mengið
	public Interval(double left, double right) 
	{
		this.left = left;
		this.right = right;
	}
	
	// Notkun: c = a.contains(x)
	// Fyrir: ekkert
	// Eftir: c er satt ef x er í bilinu a
	public boolean contains(double x) 
	{
		return (this.left <= x) && (x <= this.right);
	}
	
	// Notkun: c = a.intersects(b)
	// Fyrir: ekkert
	// Eftir: c er satt ef a og b innihalda sameiginlegan punkt
	public boolean intersects(Interval b) 
	{
		return this.proper() && b.proper() &&
			(this.left <= b.right) && (this.right >= b.left);
	}
	
	public String toString() 
	{
		if (this.proper()) 
		{
			return "["+this.left+","+this.right+"]";
		} 
		else {
			return "[]";
		}
	}
	
	// Notkun: c = a.contains(b)
	// Fyrir: ekkert
	// Eftir: c er satt ef a inniheldur bilið b eða b er tómt
	public boolean contains(Interval b) 
	{
		return !b.proper() || this.contains(b.left) && this.contains(b.right);
	}
	
	// Notkun: c = a.proper()
	// Fyrir: ekkert
	// Eftir: c er true ef bilið a er ekki tómt
	private boolean proper() 
	{
		return this.left <= this.right;
	}
}