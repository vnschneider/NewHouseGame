package NewHouseGame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase1 extends JPanel implements ActionListener {
	
	private Image fundo;
	private Player player;
	private Timer timer;
	
	
	public Fase1() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\galaxy.png");
		fundo = referencia.getImage();
	 
		player= new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();
		
	}
	
	
	
	
	public void paint(Graphics g) {
    Graphics2D graficos = (Graphics2D) g;
    graficos.drawImage(fundo, 0, 0, null);
    graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		repaint();
		
	}
	
private class TecladoAdapter implements KeyListener{
        
        
        @Override
        public void keyTyped(KeyEvent ke) {
           throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void keyPressed(KeyEvent ke) {
           player.KeyPressed(ke);
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            player.KeyReleased(ke);
        }
        
    }
}