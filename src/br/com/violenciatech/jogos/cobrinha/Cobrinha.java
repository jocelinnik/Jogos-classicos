package br.com.violenciatech.jogos.cobrinha;

public class Cobrinha {
	public static void executar() {
		Jogo jogo = new Jogo();
		
		jogo.carregarJogo();
		jogo.iniciarJogo();
	}
}