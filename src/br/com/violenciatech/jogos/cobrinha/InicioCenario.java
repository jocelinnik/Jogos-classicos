package br.com.violenciatech.jogos.cobrinha;

import java.awt.Graphics2D;

import br.com.violenciatech.jogos.cobrinha.base.CenarioPadrao;
import br.com.violenciatech.jogos.cobrinha.base.Menu;
import br.com.violenciatech.jogos.cobrinha.base.Util;

public class InicioCenario extends CenarioPadrao{
    private Menu menuJogo;
    private Menu menuVelInicial;

    public InicioCenario(int largura, int altura){
        super(largura, altura);
    }

    @Override
    public void carregar(){
        int cont;
        String[] opcoes = new String[Nivel.niveis.length + 1];

        menuJogo = new Menu("Fase");
        for(cont=0;cont<opcoes.length;cont++) opcoes[cont] = "Nivel " + cont;

        opcoes[opcoes.length-1] = "Do Russo";
        menuJogo.addOpcoes(opcoes);

        menuVelInicial = new Menu("Vel.");
        menuVelInicial.addOpcoes("Normal", "Rapido", "Lento");
        Util.centraliza(menuJogo, largura, altura);
        Util.centraliza(menuVelInicial, largura, altura);

        menuVelInicial.setPy(menuJogo.getPy() + menuJogo.getAltura());
        menuJogo.setAtivo(true);
        menuJogo.setSelecionado(true);
        menuVelInicial.setAtivo(true);
    }

    @Override
    public void descarregar(){
        Jogo.nivel = menuJogo.getOpcaoId();

        switch(menuVelInicial.getOpcaoId()){
            case 0: Jogo.velocidade = 4; break;
            case 1: Jogo.velocidade = 8; break;
            case 2: Jogo.velocidade = 2; break;
        }
    }

    @Override
    public void atualizar(){
        if(Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]){
            if(menuJogo.isSelecionado()){
                menuJogo.setSelecionado(false);
                menuVelInicial.setSelecionado(true);
            }else{
                menuJogo.setSelecionado(true);
                menuVelInicial.setSelecionado(false);
            }
        }else if(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]){
            menuJogo.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
            menuVelInicial.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
        }

        Jogo.liberaTeclas();
    }

    @Override
    public void desenhar(Graphics2D g){
        menuJogo.desenha(g);
        menuVelInicial.desenha(g);
    }
}