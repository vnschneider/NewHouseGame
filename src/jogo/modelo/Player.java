package jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private List <Tiro> tiros;
	private boolean isVisivel;


	private int altura, largura;
	
	
	public Player() {
		this.x = 50;
		this.y = 330;
		isVisivel = true;
		
		tiros = new ArrayList<Tiro>();
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\spritealien01.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public void update() {
		y += dy;
		x += dx;
		
	}
	
	public void Tiro01() {
		this.tiros.add(new Tiro(x + largura, y + (altura/2)));
	}
	
	public Rectangle getBounds() {
    	return new Rectangle (x, y, altura, largura);
    }
	
		
	
  public void setY(int y) {
		this.y = y;
	}

	public void KeyPressed(KeyEvent tecla){
		int codigo = tecla.getKeyCode();
		if(codigo == KeyEvent.VK_A){
			Tiro01();
			
		}
		if(codigo == KeyEvent.VK_UP) {
			dy=-3;
		}
		if(codigo == KeyEvent.VK_DOWN) {
			dy=3;
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=3;
		}
		if(codigo == KeyEvent.VK_LEFT){
			dx=-3;
	}
		
		
	}
		public void KeyReleased(KeyEvent tecla){
			int codigo = tecla.getKeyCode();
			
			if(codigo == KeyEvent.VK_UP) {
				dy=0;
			}
			if(codigo == KeyEvent.VK_DOWN) {
				dy=0;
			}
			
			if(codigo == KeyEvent.VK_RIGHT) {
				dx=0;
				
			}
			if(codigo == KeyEvent.VK_LEFT) {
				dx=0;
			}
			
			
		

		
	}

		public boolean isVisivel() {
			return isVisivel;
		}

		public void setVisivel(boolean isVisivel) {
			this.isVisivel = isVisivel;
		}

		public int getY() {
		return y;
	}
		public int getX() {
			return x;
		}
		
		public Image getImagem() {
			return imagem;
		}


        public List<Tiro> getTiros() {
		
			return tiros;
		}

		public void setVisivel1(boolean isVisivel) {
			// TODO Auto-generated method stub
			
		}

		
			
			
		}

		
			
			

		
		
		
		

























