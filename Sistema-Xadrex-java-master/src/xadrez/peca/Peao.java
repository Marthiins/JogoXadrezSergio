package xadrez.peca;

import placagame.Placa;
import placagame.Posicao;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.Color;

public class Peao extends PecaXadrez{

    private JogoXadrez partidaXadrez;
    
    public Peao(Placa placa,Color color, JogoXadrez partidaXadrez) {
        super(color, placa);
        this.partidaXadrez = partidaXadrez;
    }

    @Override
    public boolean[][] movimentoPossiveis() {
        boolean [][] matriz = new boolean[getPlaca().getLinhas()][getPlaca().getColunas()];
        
        Posicao p = new Posicao(0,0);
        
        if(getColor() == Color.WHITE){
            p.definirValores(posicao.getLinha() - 1, posicao.getColuna());
            if(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            p.definirValores(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha()-1, posicao.getColuna());
            if(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)&& getPlaca().posicaoExistente(p2) && !getPlaca().haUmaPeca(p2) && getMoveCont() == 0){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            p.definirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            //#Movimento especial no passe branco
            if(posicao.getLinha() == 3){
                Posicao left = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                if(getPlaca().posicaoExistente(left) && existePecaOponente(left) && getPlaca().piece(left) == partidaXadrez.getEnPassandoVulneravel()){
                    matriz[left.getLinha() - 1][left.getColuna()] = true;
                }
                Posicao right = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                if(getPlaca().posicaoExistente(right) && existePecaOponente(right) && getPlaca().piece(right) == partidaXadrez.getEnPassandoVulneravel()){
                    matriz[right.getLinha() - 1][right.getColuna()] = true;
                }
            }
        }
        else{
            p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
            if(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            p.definirValores(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
            if(getPlaca().posicaoExistente(p) && !getPlaca().haUmaPeca(p)&& getPlaca().posicaoExistente(p2) && !getPlaca().haUmaPeca(p2) && getMoveCont() == 0){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if(getPlaca().posicaoExistente(p) && existePecaOponente(p)){
                matriz[p.getLinha()][p.getColuna()] = true;
            }
            
            //#Movimento especial no passe preto
            if(posicao.getLinha() == 4){
                Posicao left = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                if(getPlaca().posicaoExistente(left) && existePecaOponente(left) && getPlaca().piece(left) == partidaXadrez.getEnPassandoVulneravel()){
                    matriz[left.getLinha() + 1][left.getColuna()] = true;
                }
                Posicao right = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                if(getPlaca().posicaoExistente(right) && existePecaOponente(right) && getPlaca().piece(right) == partidaXadrez.getEnPassandoVulneravel()){
                    matriz[right.getLinha() + 1][right.getColuna()] = true;
                }
            }
        }        
            
        return matriz;
    }
    
    @Override
    public String toString(){
        return "P";
    }
}
