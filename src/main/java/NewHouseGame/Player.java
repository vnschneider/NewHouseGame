package NewHouseGame;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	private int x, y;
	private int dx, dy;
	private Image imagem;


	private int altura, largura;
	
	
	public Player() {
		this.x = 50;
		this.y = 330;
	}
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\spritealien01.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public void update() {
		x = getX() + dx;
		
	}
	
		
	
  public void setY(int y) {
		this.y = y;
	}

	public void KeyPressed(KeyEvent tecla){
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=3;
		}
		if(codigo == KeyEvent.VK_LEFT){
			dx=-3;
	}
		
		
	}
		public void KeyReleased(KeyEvent tecla){
			int codigo = tecla.getKeyCode();
			
			if(codigo == KeyEvent.VK_RIGHT) {
				dx=0;
				
			}
			if(codigo == KeyEvent.VK_LEFT) {
				dx=0;
			}

		
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

}
