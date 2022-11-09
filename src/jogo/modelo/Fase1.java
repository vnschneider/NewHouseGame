package jogo.modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase1 extends JPanel implements ActionListener, Runnable{
	private Image fundo;
	private Player player;
	private Timer timer;
	private List <Inimigo> inimigo;
	private boolean emJogo;
	int ponto = 0;
	int segundos = 60;
	boolean exe = false;
	Thread t;
	
	public void showNotify() {
		exe = true;
		t.start();
	}
	
	public void hideNotify() {
		exe = false;
		t = null;
		System.exit(segundos);
	}

	public Fase1() {
		t = new Thread(this);
		showNotify();
		
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\galaxy.png");
		fundo = referencia.getImage();
	 
		player= new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();
		
		InicializaInimigo();
		emJogo = true;
	}
	
	public void InicializaInimigo() {
		int coordenadas [ ] = new int [10];
		inimigo = new ArrayList <Inimigo>();
		for(int i = 0; i < coordenadas.length; i++) {
			int x = (int)(Math.random() * 900 +528);
			int y = (int)(Math.random() * 400 + 20);
			inimigo.add(new Inimigo(x, y));
		}
	}
	
	
	public void paint(Graphics g) {
	
    Graphics2D graficos = (Graphics2D) g;
    
    if(emJogo == true) {
    graficos.drawImage(fundo, 0, 0, null);
    graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
    graficos.setColor(Color.white);
    graficos.setFont(new Font ("Arial",1,26));
    graficos.drawString("Pontuação: "+ponto, 410, 20);
    graficos.drawString("Tempo: "+segundos,50, 20);
    System.out.println("Tempo: "+segundos);
	List<Tiro> tiros = player.getTiros();
	for(int i = 0; i < tiros.size(); i++) {
		Tiro m = tiros.get(i);
		 m.load();
		graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
		}
	
	 for (int o = 0; o < inimigo.size(); o++) {
		 Inimigo in = inimigo.get(o);
		 in.load();
		 graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
	 }
	}
	 else{
		 ImageIcon fimJogo = new ImageIcon("res\\gameover.png");
		 graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		 }
	 
		
	 g.dispose();
}



	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		
		List<Tiro> tiros = player.getTiros();
		for(int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			  if(m.isVisivel()) {
				  m.update();
			}else {
				tiros.remove(i);
			}
		}
		
		
		for (int o = 0; o < inimigo.size(); o++) {
			Inimigo in = inimigo.get(o);
			if(in.isVisivel()) {
				in.update();
			}else { inimigo.remove(o);
			}
		}
		checarColisoes();
		
		repaint();
	}
	
	public void checarColisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaInimigo;
		Rectangle formaTiro;
		
		for(int i = 0; i < inimigo.size(); i++) {
			Inimigo tempInimigo = inimigo.get(i);
			formaInimigo = tempInimigo.getBounds();
			if(formaNave.intersects(formaInimigo)){
			player.setVisivel(false);
			tempInimigo.setVisivel(false);
			emJogo = false;
			
		}
		}
	List<Tiro> tiro = player.getTiros();
	for(int j = 0; j < tiro.size(); j++){
		Tiro tempTiro = tiro.get(j);
		formaTiro = tempTiro.getBounds();
		for(int o = 0; o < inimigo.size(); o++){
		Inimigo tempInimigo = inimigo.get(o);
		formaInimigo = tempInimigo.getBounds();
		if(formaTiro.intersects(formaInimigo)) {
			ponto += 1;
			tempInimigo.setVisivel(false);
			tempTiro.setVisivel(false);
		}

	}
}
	

	
		
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

	@Override
	public void run() {
		while(exe) {
			segundos -= 1;
			if(segundos <= 0 ) {
				System.out.println("Encerrado!");
				hideNotify();
			}	
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				repaint();
				
			}
	
		}
	}
}

	

