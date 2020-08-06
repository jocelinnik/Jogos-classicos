package br.com.violenciatech.jogos.asteroidssprites;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import br.com.violenciatech.jogos.asteroidssprites.base.Elemento;

public class Animacao extends Elemento{
	private short coluna;
	private short temporizador;
	
	public Animacao(ImageIcon imagem) {
		super.setImagem(imagem);
	}
	
	@Override
	public void atualiza() {
		if(!isAtivo()) return;
		
		if(coluna==0) {
			setAtivo(false);
		}else if(temporizador==2) {
			coluna++;
			temporizador = 0;
		}else {
			temporizador++;
		}
	}
	
	@Override
	public void desenha(Graphics2D g) {
		if(!isAtivo()) return;
		
		int largMoldura = getImagem().getIconWidth()/6;
		int largImg = largMoldura * coluna;
		int altImg = getImagem().getIconHeight();
		
		g.drawImage(getImagem().getImage(), getPx(), getPy(), getPx() + largMoldura, getPy() + altImg, largImg, 0, largImg + largMoldura, altImg, null);
	}
	
	@Override
	public void setAtivo(boolean ativo) {
		super.setAtivo(ativo);
		coluna = 0;
		temporizador = 0;
	}
}