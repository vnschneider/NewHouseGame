package jogo;

import javax.swing.JFrame;

import jogo.modelo.Fase1;

public class Container extends JFrame{
	
	public Container() {
	add (new Fase1());
	setTitle("Meu Jogo");
	setSize(1050, 528);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	this.setResizable(true);
	setVisible(true);
	}
	
	public static void main(String []args) {
		new Container();
	}
	
	
	}