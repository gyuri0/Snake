package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import xml.XmlParser;

@SuppressWarnings("serial")
public class GameFromXml extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameFromXml() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		JButton btnNewGame = new JButton("New Game From Xml");
		btnNewGame.setBounds(200, 100, 200, 50);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(GameFromXml.this);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						GameFrame game = new GameFrame(XmlParser.mapFromXmlFile(chooser.getSelectedFile().getPath()));
						game.setVisible(true);
						GameFromXml.this.dispose();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			    }
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(200, 300, 200, 50);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuFrame menu = new MenuFrame();
				menu.setVisible(true);
				GameFromXml.this.dispose();
			}
		});
		contentPane.add(btnNewGame);
		contentPane.add(btnBack);
		
	}

}
