package br.com.violenciatech.jogos.asteroidssprites;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import br.com.violenciatech.jogos.asteroidssprites.base.Elemento;
import br.com.violenciatech.jogos.asteroidssprites.base.MatUtil;

public class Asteroide extends Elemento{
	public enum Tamanho{ GRANDE, MEDIO, PEQUENO, POEIRA; }
	
	private float angulo;
	private float anguloRotacao;
	private Tamanho tamanho = Tamanho.GRANDE;
	
	@Override
	public void atualiza() {
		if(!isAtivo()) return;
		
		if(getLargura()!=getImagem().getIconWidth()) {
			setAltura(getImagem().getIconWidth());
			setLargura(getImagem().getIconHeight());
		}
		
		MatUtil.move(this, angulo, getVel());
		anguloRotacao = MatUtil.corrigeGraus(anguloRotacao + getVel());
	}
	
	@Override
	public void desenha(Graphics2D g) {
		if(!isAtivo()) return;
		
		af.setTransform(g.getTransform());
		af.rotate(Math.toRadians(anguloRotacao), getLargura()/2 + getPx(), getAltura()/2 + getPy());
		af.translate(getPx(), getPy());
		g.drawImage(getImagem().getImage(), af, null);
	}
	
	@Override
	public void setImagem(ImageIcon img) {
		super.setImagem(img);
		super.setAltura(img.getIconHeight());
		super.setLargura(img.getIconWidth());
	}
	
	public boolean divide() {
		switch(tamanho) {
			case GRANDE: 
				tamanho = Tamanho.MEDIO;
				setImagem(Recursos.getImagem(Recursos.Imagem.AST_B));
				break;
			case MEDIO:
				tamanho = Tamanho.PEQUENO;
				setImagem(Recursos.getImagem(Recursos.Imagem.AST_C));
				break;
			case PEQUENO:
				tamanho = Tamanho.POEIRA;
			default:
				break;
		}
		
		return tamanho!=Tamanho.POEIRA;
	}

	public float getAngulo() {
		return angulo;
	}

	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	
	public short getPonto() {
		switch(tamanho) {
			case GRANDE: return 10;
			case MEDIO: return 15;
			case PEQUENO: return 20;
			case POEIRA:
			default: return 0;
		}
	}
}