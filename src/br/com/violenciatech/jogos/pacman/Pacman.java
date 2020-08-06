package br.com.violenciatech.jogos.pacman;

import br.com.violenciatech.jogos.pacman.Jogo;

public class Pacman {
	public static void executar() {
		Jogo jogo = new Jogo();
		
		jogo.carregarJogo();
		jogo.iniciarJogo();
	}
}