package xadrez.peca;

import placagame.Placa;
import placagame.Posicao;
import xadrez.PecaXadrez;
import xadrez.Color;

public class Rainha extends PecaXadrez{
    
    public Rainha(Placa placa,Color color) {
        super(color, placa);
    }
    
    @Override
    public String toString(){
        return "Q";
    }
    
    @Override
    public boolean[][] movimentoPossiveis() {
        boolean [][] matriz = new boolean[getPlaca().getLinhas()][getPlaca().getColunas()];
        
        Posicao p = new Posicao(0,0);
        
        //Definir Posicçao a cima
        p.definirValores(posicao.getLinha() - 1,posicao.getColuna());
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir Posição a esquerda
        p.definirValores(posicao.getLinha(),posicao.getColuna() - 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir Posição a Direita
        p.definirValores(posicao.getLinha(),posicao.getColuna() + 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir posição a abaixo
        p.definirValores(posicao.getLinha() + 1,posicao.getColuna());
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() - 1,posicao.getColuna() - 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.definirValores(p.getLinha() - 1, p.getColuna() - 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() - 1,posicao.getColuna() + 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
            p.definirValores(p.getLinha() - 1, p.getColuna() + 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() + 1,posicao.getColuna() + 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
             p.definirValores(p.getLinha() + 1, p.getColuna() + 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() + 1,posicao.getColuna() - 1);
        while(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
             p.definirValores(p.getLinha() + 1, p.getColuna() - 1);
        }
        if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        return matriz;
    }
}
