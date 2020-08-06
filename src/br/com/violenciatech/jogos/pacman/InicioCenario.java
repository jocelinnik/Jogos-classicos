package br.com.violenciatech.jogos.pacman;

import java.awt.Graphics2D;

import br.com.violenciatech.jogos.pacman.base.CenarioPadrao;
import br.com.violenciatech.jogos.pacman.base.Menu;
import br.com.violenciatech.jogos.pacman.base.Util;

public class InicioCenario extends CenarioPadrao{
	private Menu menuJogo;
	
	public InicioCenario(int largura, int altura) {
		super(largura, altura);
	}
	
	@Override
	public void carregar() {
		menuJogo = new Menu("Fome");
		menuJogo.addOpcoes("Sem", "Pouca", "Muita");
		Util.centraliza(menuJogo, largura, altura);
		menuJogo.setPy(menuJogo.getPy() + menuJogo.getAltura());
		menuJogo.setAtivo(true);
		menuJogo.setSelecionado(true);
	}
	
	@Override
	public void descarregar() {
		Jogo.nivel = menuJogo.getOpcaoId();
	}
	
	@Override
	public void atualizar() {
		if(Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
			
		}else if(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
			menuJogo.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
		}
		
		Jogo.liberaTeclas();
	}
	
	@Override
	public void desenhar(Graphics2D g) {
		menuJogo.desenha(g);
	}
}