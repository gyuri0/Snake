package math;

/**
 * 
 * Kétdimenziós vektorok ábrázolására alkalmas osztály.
 *
 */
public class Vector2D {
	
	/**
	 * A vektor x koordinátája.
	 */
	private double x;
	
	/**
	 * A vektor y koordinátája.
	 */
	private double y;
	
	/**
	 * Létrehoz egy új {@code Vector2D} objektumot
	 * @param x a vektor x koordinátája
	 * @param y a vektor y koordinátája
	 */
	public Vector2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Létrehoz egy új {@code Vector2D} objektumot egy másik másolataként.
	 * @param pos a másik {@code Vector2D} objektum
	 */
	public Vector2D(Vector2D pos) {
		this.x=pos.x;
		this.y=pos.y;
	}
	
	/**
	 * Visszaadja az aktuális vektor x koordinátáját.
	 * @return az aktuális vektor x koordinátája
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Beállítja az aktuális vektor x koordinátáját.
	 * @param x az aktuális vektor x koordinátája
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Visszaadja az aktuális vektor y koordinátáját.
	 * @return az aktuális vektor y koordinátája
	 */
	public double getY() {
		return y;
	}
	
	/**
	* Beállítja az aktuális vektor y koordinátáját.
	* @param x az aktuális vektor y koordinátája
	*/
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Visszaad egy új {@code Vector2D} objektumot, mely az aktuális és a {@code b} vektorok összege. 
	 * @param b a másik vektor
	 * @return az aktuális és a {code b} vektorok összege
	 */
	public Vector2D add(Vector2D b){
		return new Vector2D(this.x+b.x,this.y+b.y);
	}
	
	/**
	 * Visszaad egy új {@code Vector2D} objektumot, mely az aktuális vektor és az {@code a} skalár szorzata.
	 * @param a szorzó
	 * @return az aktuális és a {@code a} skalár szorzata
	 */
	public Vector2D multiply(double a){
		return new Vector2D(this.x*a,this.y*a);
	}
	
	/**
	 * Visszaad egy új {@code Vector2D} objektumot, mely az aktuális vektor {@code degree} fokkal történő elforgatásából adódik.
	 * Az elforgatás az origó körül történik.
	 * @param degree
	 * @return az aktuális vektor {@code degree} szöggel történő elforgatásából adódó vektor
	 */
	public Vector2D rotate(double degree){
		/*x' = cos(a) * x - sin(a) * y
      	  y' = sin(a) * x + cos(a) * y*/
		double newX;
		double newY;
		double radian=Math.toRadians(degree);
		newX=Math.cos(radian)*this.x-Math.sin(radian)*this.y;
		newY=Math.sin(radian)*this.x+Math.cos(radian)*this.y;
		return new Vector2D(newX,newY);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null  || !(obj instanceof Vector2D)) return false;
		Vector2D b = (Vector2D) obj;
		return Math.abs(x-b.x) < 0.00001 && Math.abs(y-b.y) < 0.00001;
	}
	
	/**
	 * Visszaadja az aktuális vektorból készített {@link String} objektumot.
	 */
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}
