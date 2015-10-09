public class Interval 
{
	private final double left,right;
	// t�knar bili� [left,right] ef left <= right, annars t�ma mengi�
	
	// Notkun: a = new Interval(left,right)
	// Fyrir: ekkert
	// Eftir: a er bili� [left,right] ef left <= right, annars t�ma mengi�
	public Interval(double left, double right) 
	{
		this.left = left;
		this.right = right;
	}
	
	// Notkun: c = a.contains(x)
	// Fyrir: ekkert
	// Eftir: c er satt ef x er � bilinu a
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
	// Eftir: c er satt ef a inniheldur bili� b e�a b er t�mt
	public boolean contains(Interval b) 
	{
		return !b.proper() || this.contains(b.left) && this.contains(b.right);
	}
	
	// Notkun: c = a.proper()
	// Fyrir: ekkert
	// Eftir: c er true ef bili� a er ekki t�mt
	private boolean proper() 
	{
		return this.left <= this.right;
	}
}