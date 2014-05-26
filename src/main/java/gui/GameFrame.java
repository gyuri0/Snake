package gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import game.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	public GameFrame(Map map) {
		 this.setSize(map.getWidth(),map.getHeight());
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     GamePanel mypanel = new GamePanel(map);
	     this.add(mypanel);
	}
	public GameFrame(){
		this(Map.getDefaultMap());
	}
	
	class GamePanel extends JPanel{
		Map map;
	    BufferedImage image;
	    
	    Timer timer;
	    GamePanel(Map map){
	    	this.map=map;
	    	
	    	image = map.getImage();
	    	
	        
	        addKeyListener(new KeyboardController(map.getSnakes().get(0),KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT));
	        addKeyListener(new KeyboardController(map.getSnakes().get(1),KeyEvent.VK_A,KeyEvent.VK_D));
	        setFocusable(true);
	        
	        ActionListener listener = new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                iterate();
	            }
	        };
	        timer = new Timer(10, listener);
	        timer.start();
	    }
	    public void iterate(){
	        if(!map.isEnd()){
	        	map.update(10);
	        	repaint();    
	        }
	        else{if(map.isEnd()){
	        		if(map.getSnakes().get(0).isLive()){
	        			JOptionPane.showMessageDialog(this, "Az első játékos nyert");
	        			timer.stop();
	        			GameFrame.this.dispose();
	        		}
	        		else{
	        			JOptionPane.showMessageDialog(this, "A második játékos Nyert");
	        			timer.stop();
	        			GameFrame.this.dispose();
	        		}
	        	}
	        }
	    }
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        g.drawImage(image,0,0,null);
	    }

	    
	}
}
