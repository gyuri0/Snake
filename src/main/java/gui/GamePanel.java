package gui;

import game.Map;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
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
        
        map.update(10);
        repaint();    
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
    }

    
}