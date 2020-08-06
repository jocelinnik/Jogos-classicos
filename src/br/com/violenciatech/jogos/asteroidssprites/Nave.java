package br.com.violenciatech.jogos.asteroidssprites;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import br.com.violenciatech.jogos.asteroidssprites.base.Elemento;

public class Nave extends Elemento{
	public static final float ROTACAO_VEL = 5f;
	public static final float LIMITE_VEL = 9f;
	
	private float angulo;
	private float velEmX;
	private float velEmY;
	private short pontos;
	private short erros;
	private short seguidos;
	
	@Override
	public void atualiza() {
		if(!isAtivo()) return;
		
		if(getLargura()!=getImagem().getIconWidth()) {
			setAltura(getImagem().getIconHeight());
			setLargura(getImagem().getIconWidth());
		}
		
		setPx(getPx() + velEmX);
		setPy(getPy() + velEmY);
	}
	
	@Override
	public void desenha(Graphics2D g) {
		if(!isAtivo()) return;
		
		float rad = (float)Math.toRadians(getAngulo());
		afAnterior = g.getTransform();
		g.rotate(rad, getLargura()/2 + getPx(), getAltura()/2 + getPy());
		g.translate(getPx(), getPy());
		g.drawImage(getImagem().getImage(), 0, 0, null);
		g.setTransform(afAnterior);
	}
	
	@Override
	public void setImagem(ImageIcon img) {
		super.setImagem(img);
		super.setAltura(img.getIconHeight());
		super.setLargura(img.getIconWidth());
	}
	
	public void somaPontos(short p) {
		seguidos++;
		pontos += p * seguidos;
	}
	
	public void errou() {
		seguidos = 0;
		erros++;
	}
	
	public float getAngulo() {
		return angulo;
	}
	
	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}
	
	public float getVelEmX() {
		return velEmX;
	}
	
	public void setVelEmX(float vel) {
		if(vel>LIMITE_VEL) vel = LIMITE_VEL;
		else if(vel<(-LIMITE_VEL)) vel = -LIMITE_VEL;
		
		this.velEmX = vel;
	}
	
	public float getVelEmY() {
		return velEmY;
	}
	
	public void setVelEmY(float vel) {
		if(vel>LIMITE_VEL) vel = LIMITE_VEL;
		else if(vel<(-LIMITE_VEL)) vel = -LIMITE_VEL;
		
		this.velEmY = vel;
	}
	
	public short getPontos() {
		return pontos;
	}
	
	public void setPontos(short pontos) {
		this.pontos = pontos;
	}
	
	public short getErros() {
		return erros;
	}
	
	public void setErros(short erros) {
		this.erros = erros;
	}
	
	public short getSeguidos() {
		return seguidos;
	}
	
	public void danos() {
		errou();
		setVelEmX(getVelEmX() * -0.5f);
		setVelEmY(getVelEmY() * -0.5f);
	}
}