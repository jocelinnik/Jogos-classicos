package br.com.violenciatech.jogos.asteroids;

public class Asteroids {
	public static void executar() {
		Jogo jogo = new Jogo();
		
		jogo.carregarJogo();
		jogo.iniciarJogo();
	}
}