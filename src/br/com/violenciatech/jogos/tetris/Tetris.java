package br.com.violenciatech.jogos.tetris;

import br.com.violenciatech.jogos.tetris.Jogo;

public class Tetris {
	public static void executar() {
		Jogo jogo = new Jogo();
        
		jogo.carregarJogo();
		jogo.iniciarJogo();
	}
}