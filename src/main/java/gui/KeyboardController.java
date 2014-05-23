package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Move;
import game.Snake;
import game.SnakeController;

public class KeyboardController extends SnakeController implements KeyListener{
    private int leftKeyCode;
    private int rightKeyCode;
	
	public KeyboardController(Snake s, int leftkeycode, int rightkeycode) {
		super(s);
		leftKeyCode=leftkeycode;
		rightKeyCode=rightkeycode;
	}

	public void keyPressed(KeyEvent key) {
		
		if(key.getKeyCode()==leftKeyCode)
			setMove(Move.LEFT);
		
		if(key.getKeyCode()==rightKeyCode)
			setMove(Move.RIGHT);
	}

	public void keyReleased(KeyEvent key) {
		
		if(key.getKeyCode()==leftKeyCode)
			setMove(Move.FORWARD);
		
		if(key.getKeyCode()==rightKeyCode)
			setMove(Move.FORWARD);
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
