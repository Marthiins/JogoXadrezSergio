package aplication;

import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.Color;
import java.util.Arrays;
import java.util.InputMismatchException; // Os programas só funcionam com números inteiros
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class InterfaceTabuleiro {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console 
    public static void limpaTela() {       
        System.out.print("\033[H\033[2J");       
        System.out.flush();   
    }   
    
    //Metodo imprensão da borda de Xadrez referente a peça
    public static void bordaImpressao(PecaXadrez piece[][]) {
        for (int i = 0; i < piece.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < piece.length; j++) {
                pecaImpressao(piece[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    
    //Metodo imprensão da borda de Xadrez referente aos movimentos possiveis da peça
    public static void bordaImpressao(PecaXadrez piece[][], boolean [][] movimentoPossiveis) {
        for (int i = 0; i < piece.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < piece.length; j++) {
                pecaImpressao(piece[i][j], movimentoPossiveis[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    //Metodo cor da peça de Xadrez
    private static void pecaImpressao(PecaXadrez piece, boolean background){
        if(background){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } 
        else if (piece.getColor() == Color.WHITE) {
            System.out.print(ANSI_RED + piece + ANSI_RESET);
        } 
        else {
            System.out.print(ANSI_BLACK + piece + ANSI_RESET);
        }
        System.out.print(" ");
    }
    
    //Metodo imprensão para a captura de peças
    public static void imprimirPecasCapturadas(List<PecaXadrez> capturado){// remove alguns elementos (no nosso caso, os branco).
        List<PecaXadrez> white = capturado.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<PecaXadrez> black = capturado.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        System.out.println("capturado peças: ");
        System.out.print("Branca/Vermelha: ");
        System.out.print(ANSI_RED);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Preta: ");
        System.out.print(ANSI_BLACK);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
    }
    
    
    public static void impressaoJogo(JogoXadrez partidaXadrez, List<PecaXadrez> capturado){
        bordaImpressao(partidaXadrez.getPecas());
        System.out.println();
        imprimirPecasCapturadas(capturado);
        System.out.println();
        System.out.println("Turno : " + partidaXadrez.getTurno());
        if(!partidaXadrez.getCheckMate()){
            System.out.println("Jogador Atual : " + partidaXadrez.getAtualPlayer());
            JOptionPane.showMessageDialog(null, "Jogador:  " + partidaXadrez.getAtualPlayer(),"Alerta", JOptionPane.WARNING_MESSAGE);
            if(partidaXadrez.getCheck()){
                System.out.println("CHECK");
            }
        }
        else{
            System.out.println("CHECKMATE!");
            System.out.println("Vencedor "+ partidaXadrez.getAtualPlayer());
        }
    }
    
    //Metodo para ler a posição do Xadrez com try cat 
    public static PosicaoXadrez readPosicaoXadrez(Scanner sc){
        try{
            String s = sc.nextLine();
            char coluna = s.charAt(0); // char foi usado como caractere
            int linha = Integer.parseInt(s.substring(1));
            JOptionPane.showMessageDialog(null, "Coluna: " + coluna + "\n Linha:" + linha);
            return new PosicaoXadrez(coluna, linha);
        }
        catch(RuntimeException e){ //mostrar mensagem de erro
            throw new InputMismatchException("Posição de xadrez de leitura de erros. Os valores válidos são de a1 para h8.");
        }
    }
}
