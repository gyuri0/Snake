package game;


/**
 * Egy {@link Snake} írányításához segítséget nyújtó osztály.
 */
public class SnakeController {
	
	/**
	 * Az írányítandó {@link Snake}.
	 */
	Snake s;
	
	/**
	 * Létrehoz egy {@code SnakeController} objektumot.
	 * @param s az írányítandó {@link Snake}
	 */
	public SnakeController(Snake s) {
		super();
		this.s = s;
	}
	
	/**
	 * Beállítja az aktuális {@code SnakeController}-hez tartozó {@link Snake} fordulási szándékát.
	 * @param move
	 */
	public void setMove(Move move){
		s.setMove(move);
	}
}
