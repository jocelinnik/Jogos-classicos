package br.com.violenciatech.jogos.tetris;

import java.awt.Graphics2D;

import br.com.violenciatech.jogos.tetris.base.CenarioPadrao;
import br.com.violenciatech.jogos.tetris.base.Menu;
import br.com.violenciatech.jogos.tetris.base.Util;

public class InicioCenario extends CenarioPadrao{
    private Menu menuJogo;

    public InicioCenario(int largura, int altura){
        super(largura, altura);
    }

    @Override
    public void carregar(){
        menuJogo = new Menu("Nivel");
        menuJogo.addOpcoes("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Util.centraliza(menuJogo, largura, altura);
        menuJogo.setPy(menuJogo.getPy() + menuJogo.getAltura());
        menuJogo.setAtivo(true);
        menuJogo.setSelecionado(true);
    }

    @Override
    public void descarregar(){
        Jogo.nivel = menuJogo.getOpcaoId() + 1;
    }

    @Override
    public void atualizar(){
        if(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]){
            menuJogo.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
        }

        Jogo.liberaTeclas();
    }

    @Override
    public void desenhar(Graphics2D g){
        menuJogo.desenha(g);
    }
}