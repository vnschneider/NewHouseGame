package jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {
      private Image imagem;
      private int x, y;
      private int altura, largura;
      private boolean isVisivel;
      
     // private static final int LARGURA = 5;
      private static int VELOCIDADE = 1;
      
      public Inimigo(int x, int y) {
    	  this.x = x;
    	  this.y = y;
    	  isVisivel = true;
   }
      public void load() {
    	  ImageIcon referencia = new ImageIcon("res\\inimigo01.png");
    	  imagem = referencia.getImage();
    	  
    	  this.largura = imagem.getWidth(null);
    	  this.altura = imagem.getHeight(null);
   }
      
     public void update(){
    	 this.x -= VELOCIDADE;
    	 //if(this.x >LARGURA) {
    		 //isVisivel = false;
    	 //}
     }
     public Rectangle getBounds() {
     	return new Rectangle (x, y, altura, largura);
     }
     
	public boolean isVisivel() {
		return isVisivel;
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}
	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImagem() {
		return imagem;
	}
	
     
     
     
     
}
