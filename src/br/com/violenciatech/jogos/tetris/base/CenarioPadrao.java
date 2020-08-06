package br.com.violenciatech.jogos.tetris.base;

import java.awt.Graphics2D;

public abstract class CenarioPadrao{
    protected int altura, largura;

    public CenarioPadrao(int largura, int altura){
        this.largura = largura;
        this.altura = altura;
    }

    public abstract void carregar();
    public abstract void descarregar();
    public abstract void atualizar();
    public abstract void desenhar(Graphics2D g);
}