package xadrez.peca;

import placagame.Placa;
import placagame.Posicao;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.Color;

public class Rei extends PecaXadrez{
    
    private JogoXadrez partidaXadrez;
    
    public Rei(Placa placa, Color color, JogoXadrez partidaXadrez) {
        super(color, placa);
        this.partidaXadrez = partidaXadrez;
    }
    
    @Override
    public String toString(){
        return "R";
    }

    private boolean canMove(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getPlaca().piece(posicao);
        return p == null || p.getColor() != getColor();
    }
    
    private boolean testeRoque(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getPlaca().piece(posicao);
        return p != null && p instanceof Torre  && p.getColor() == getColor() && p.getMoveCont() == 0;
    }
    
    @Override
    public boolean[][] movimentoPossiveis() {
        boolean [][] matriz = new boolean[getPlaca().getLinhas()][getPlaca().getColunas()];
        
        Posicao p = new Posicao(0,0);
        
        //Definir valor a cima
        p.definirValores(posicao.getLinha() - 1, posicao.getColuna());
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir valor a baixo
        p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir valor a esquerda
        p.definirValores(posicao.getLinha(), posicao.getColuna() - 1);
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //Definir valor a direita
        p.definirValores(posicao.getLinha(), posicao.getColuna() + 1);
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //nw
        p.definirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if(getPlaca().posicaoExistente(p) && canMove(p)){
            matriz[p.getLinha()][p.getColuna()] = true;
        }
        
        //#special testar Roque
        if(getMoveCont() == 0 && !partidaXadrez.getCheck()){
            //#Special Move roque rei torre
            Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
            if(testeRoque(posT1)){
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
                if(getPlaca().piece(p1) == null && getPlaca().piece(p2) == null){
                    matriz[posicao.getLinha()][posicao.getColuna() + 2] = true;
                }
            }
            //#Special Move roque da torre lateral da rainha
            Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
            if(testeRoque(posT2)){
                Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
                Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
                if(getPlaca().piece(p1) == null && getPlaca().piece(p2) == null && getPlaca().piece(p3) == null){
                    matriz[posicao.getLinha()][posicao.getColuna() - 2] = true;
                }    
            }
        }
        return matriz;
    }
}
