package xadrez.peca;

import placagame.Placa;
import placagame.Posicao;
import xadrez.PecaXadrez;
import xadrez.Color;

public class Torre extends PecaXadrez{
    
    public Torre(Placa placa,Color color) {
        super(color, placa);
    }
    
    @Override
    public String toString(){
        return "T";
    }
    
    @Override
    public boolean[][] movimentoPossiveis() {
        boolean [][] matriz = new boolean[getPlaca().getLinhas()][getPlaca().getColunas()];
        
        Posicao p = new Posicao(0,0);
        
        //Definir valor para cima
        p.definirValores(posicao.getLinha() - 1,posicao.getColuna());
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir valor a Esquerda
        p.definirValores(posicao.getLinha(),posicao.getColuna() - 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //
        p.definirValores(posicao.getLinha(),posicao.getColuna() + 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //torre abaixo
        p.definirValores(posicao.getLinha() + 1,posicao.getColuna());
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        return matriz;
    }
}
