package br.com.violenciatech.jogos.pacmansprites;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import br.com.violenciatech.jogos.pacmansprites.JogoCenario.Direcao;
import br.com.violenciatech.jogos.pacmansprites.base.Elemento;

public class Pizza extends Elemento{
	private Direcao direcao = Direcao.OESTE;
	private int linha;
	private int coluna;
	
	public Pizza() {
		super(0, 0, 16, 16);
		setImagem(new ImageIcon("imagens/pacmansprites/sprite_pizza.png"));
	}
	
	@Override
	public void atualiza() {
		incPx(getVel() * getDx());
		incPy(getVel() * getDy());
		
		if(getDx()==1) linha = 0;
		else if(getDx()==-1) linha = 1;
		else if(getDy()==-1) linha = 2;
		else if(getDy()==1) linha = 3;
		
		if((getDx() + getDy())!=0) coluna++;
		if(coluna>3) coluna = 0;
	}
	
	@Override
	public void desenha(Graphics2D g) {
		int px = getPx() - 6;
		int py = getPy() + JogoCenario.ESPACO_TOPO - 6;
		int largMoldura = getImagem().getIconWidth()/4;
		int altMoldura = getImagem().getIconHeight()/4;
		int largImg = largMoldura * coluna;
		int altImg = altMoldura * linha;
		
		g.drawImage(getImagem().getImage(), px, py, px + largMoldura, py + altMoldura, largImg, altImg, largImg + largMoldura, altImg + altMoldura, null);
	}
	
	public Direcao getDirecao() {
		return direcao;
	}
	
	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}
}