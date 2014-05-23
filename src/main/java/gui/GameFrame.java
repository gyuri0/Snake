package gui;

import game.Map;
import javax.swing.JFrame;



@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	public GameFrame(Map map) {
		 this.setSize(600,600);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     GamePanel mypanel = new GamePanel(map);
	     this.add(mypanel);
	}
	public GameFrame(){
		this(Map.getDefaultMap());
	}
}
