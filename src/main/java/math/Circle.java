package math;

/**
 * Ez az osztály segítő függvényeket tartalmaz körökkel kapcsolatban.
 */
public class Circle {
	
	/**
	 * Meghatározza, hogy a pont a körön belül van-e.
	 * @param r a kör sugara
	 * @param center a kör középpontja
	 * @param x a vizsgálandó pont x koordinátája
	 * @param y a vizsgálandó pont y koordinátája
	 * @return
	 */
	public static boolean isInnerPoint(double r,Vector2D center, double x,double y){
		//(x - center_x)^2 + (y - center_y)^2 < radius^2
		if(Math.pow(x-center.getX(), 2)+Math.pow(y-center.getY(), 2)<=Math.pow(r, 2))
			return true;
		
		return false;
	}
	
	/**
	 * Meghatározza, hogy a pont a körön belül van-e.
	 * @param r a kör sugara
	 * @param center a kör középpontja
	 * @param point a vizsgálandó pont
	 * @return
	 */
	public static boolean isInnerPoint(double r,Vector2D center, Vector2D point){
		if (isInnerPoint(r, center, point.getX(), point.getY()))
			return true;
		
		return false;
	}
}
