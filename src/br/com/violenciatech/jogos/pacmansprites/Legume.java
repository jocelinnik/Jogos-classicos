package br.com.violenciatech.jogos.pacmansprites;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import br.com.violenciatech.jogos.pacmansprites.JogoCenario.Direcao;
import br.com.violenciatech.jogos.pacmansprites.base.Elemento;

public class Legume extends Elemento{
	public enum Modo{ PRESO, ATIVO, INATIVO, FANTASMA, CACANDO, FUGINDO }
	public enum Tipo { VERMELHO, ROXO, AMARELO, VERDE }
	
	private Tipo tipo;
	private Modo modo = Modo.PRESO;
	private Direcao direcao = Direcao.OESTE;
	private int linha;
	private int coluna;
	private int lnOlhos;
	private static ImageIcon olhos;
	private static ImageIcon sprite;
	
	static {
		olhos = new ImageIcon("imagens/pacmansprites/olhos.png");
		sprite = new ImageIcon("imagens/pacmansprites/sprite_inimigos.png");
	}
	
	public Legume(Tipo tipo) {
		super(0, 0, 16, 16);
		this.tipo = tipo;
		this.coluna = tipo.ordinal();
	}
	
	@Override
	public void atualiza() {
		incPx(getVel() * getDx());
		incPy(getVel() * getDy());
		
		if(getDx()==-1) lnOlhos = 0;
		else if(getDx()==1) lnOlhos = 1;
		else if(getDy()==-1) lnOlhos = 2;
		else if(getDy()==1) lnOlhos = 3;
		
		if(modo==Modo.FUGINDO) linha = 1;
		else linha = 0;
	}
	
	@Override
	public void desenha(Graphics2D g) {
		int pX = getPx() - 6;
		int pY = getPy() + JogoCenario.ESPACO_TOPO - 6;

		int largMoldura = sprite.getIconWidth()/4;
		int altMoldura = sprite.getIconHeight()/2;

		int largImg = largMoldura * coluna;
		int altImg = altMoldura * linha;

		if (modo!=Modo.FANTASMA) g.drawImage(sprite.getImage(), pX, pY, pX + largMoldura, pY + altMoldura, largImg, altImg, largImg + largMoldura, altImg + altMoldura, null);

		largMoldura = olhos.getIconWidth();
		altMoldura = olhos.getIconHeight() / 4;
		altImg = altMoldura * lnOlhos;

		g.drawImage(olhos.getImage(), pX, pY, pX + largMoldura, pY + altMoldura, 0, altImg, largMoldura, altImg + altMoldura, null);
	}
	
	public Direcao getDirecao() {
		return this.direcao;
	}
	
	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}
	
	public Modo getModo() {
		return this.modo;
	}
	
	public void setModo(Modo modo) {
		this.modo = modo;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}