package aplication;

import placagame.PlacaException;
import java.util.InputMismatchException;
import java.util.Scanner;
import xadrez.XadrezException;
import xadrez.JogoXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProgramaLpoo {
    
    // ArrayList de usuario e Login para guardar os dados
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
     static ArrayList<Login> logins = new ArrayList<Login>();
    
      private static String password;
    private static String userName;
    public static void main(String[] args) {
        
        
        cadastroUsuario(); // Verificador -  Cadastro de usuario referente ao login para ter acesso ao Menu. O usuario so consegue
        //entrar no menu apos inserir o nome de usuario e a senha.
        int i = 0;

        //Vai precisar duplicar a chamada num if:
        if ((usuarios.get(i).getUserName() == null ? logins.get(i).getUserNameLogar() == null : usuarios.get(i).getUserName().equals(logins.get(i).getUserNameLogar()))) {

            if (usuarios.get(i).getPassword() == null ? logins.get(i).getPasswordLogar() == null : usuarios.get(i).getPassword().equals(logins.get(i).getPasswordLogar())) {

               JOptionPane.showMessageDialog(null, usuarios.get(i).getUserName() + "\nLogado com sucesso.", "Aviso\n", 1);
            }

       } else {

            JOptionPane.showMessageDialog(null, "User Name ou Password Invalidos.", "Aviso", 1);
            cadastroUsuario();

        }

        Scanner sc = new Scanner(System.in);
        JogoXadrez partidaXadrez = new JogoXadrez();
        List<PecaXadrez> capturada = new ArrayList<>();
        
        while (!partidaXadrez.getCheckMate()){
            try {
                InterfaceTabuleiro.limpaTela();
                InterfaceTabuleiro.impressaoJogo(partidaXadrez,capturada);
                System.out.println();
                System.out.print("Source: ");
                PosicaoXadrez source = InterfaceTabuleiro.readPosicaoXadrez(sc);
                
                boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(source);
                InterfaceTabuleiro.limpaTela();
                InterfaceTabuleiro.bordaImpressao(partidaXadrez.getPecas(), movimentosPossiveis);
                
                System.out.println();
                System.out.print("Alvo: ");
                PosicaoXadrez target = InterfaceTabuleiro.readPosicaoXadrez(sc); //Alvo
                PecaXadrez capturaPeca = partidaXadrez.realizarMovimentoXadrez(source, target);
                
                if(capturaPeca != null){
                    capturada.add(capturaPeca);
                }
                
                if(partidaXadrez.getPromovido() != null){
                    System.out.print("Insira peça para cargo (T/Q/C/B) : ");
                    String type = sc.nextLine();
                    partidaXadrez.substituirPecaPromovida(type);
                }
            } 
            catch (XadrezException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } 
            catch (PlacaException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InvalidParameterException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        InterfaceTabuleiro.limpaTela();
        InterfaceTabuleiro.impressaoJogo(partidaXadrez, capturada);
    }
      public static void cadastroUsuario() { //Metodo para cadastrar o Usuario e fazer o login no sistema

          
          
        //Declarei  as variaveis
        String userName;
        String password;

        String userName2;
        String password2;

        
        //opcao 
        if (usuarios.size() == 0) {
            //pega os valores
            //userName = JOptionPane.showInputDialog(null, "Cadastre o seu Nome para acessar o Jogo: ");
            //password = JOptionPane.showInputDialog(null, "Cadastre seu Password para fazer o Login: ");
            
            //boolean soLetras;
            //do {//verificaçao para ver se tem somente letras
                //userName = JOptionPane.showInputDialog("Cadastre o seu Nome para acessar o Jogo:");
                //soLetras = true;
                //if (userName.matches("^[a-zA-Z]+$")) {
                //    soLetras = false;
                    
               // }

           // } while (soLetras);
                //System.out.println(userName);
                //armazene o aux no seu array de nomes
                //boolean soNumeros;
                //do {//verificaçao para ver se tem somente numeros
                 //   password = JOptionPane.showInputDialog("Cadastre seu Password para fazer o Login: ");
                 //   soNumeros = true;
                 //   if (!password.matches("\\d+")) {
                  //      soNumeros = false;
                  //  }
            //} while (!soNumeros);
              // System.out.println(password);
    //armazene o aux no seu array de numero de pessoas
            //Fim - pega os valores das variaveis

            //adiciona os valores no arraylist usuarios
            //usuarios.add(new Usuario(userName, password));
            //cadastroUsuario();
            boolean soLetras;
            do {//verificaçao para ver se tem somente letras

                userName = JOptionPane.showInputDialog("Cadastre o seu Nome para acessar o Jogo:");
                soLetras = true;
                    
                //if(JOptionPane.OK_CANCEL_OPTION == JOptionPane.OK_OPTION) {   
                if (userName == null){
                   System.out.println("Sistema Finalizado");
                   JOptionPane.showMessageDialog(null, "Sistema FInalizado", "Saindo", JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
                    
                }else{
                    if(userName.matches("^[a-zA-Z]+$")) {
                        soLetras = false;
                    }
                }
            } while (soLetras);

                        boolean soNumeros;
                        do {//verificaçao para ver se tem somente numeros

                        password = JOptionPane.showInputDialog("Cadastre seu Password para fazer o Login: ");
                        soNumeros = true;
                    
                       // if(JOptionPane.OK_CANCEL_OPTION == JOptionPane.OK_OPTION) {   
                            if (password == null){
                               System.out.println("Sistema Finalizado");
                               JOptionPane.showMessageDialog(null, "Sistema FInalizado", "Saindo", JOptionPane.INFORMATION_MESSAGE);
                               System.exit(0);
                            
                        }else{
                            if(!password.matches("\\d+")) {
                                soNumeros = false;
                            
                            }
                            }
                        }while (!soNumeros);

                            usuarios.add(new Usuario(userName, password));
                            cadastroUsuario();
                        
                        
                        
                        
                
        
                
            
        } else {

            //pega os valores das variaveis declarada
            userName2 = JOptionPane.showInputDialog(null, "Entre com o seu Nome cadastrado: ");
                if(userName2 == null){
                   System.out.println("Sistema Finalizado");
                   JOptionPane.showMessageDialog(null, "Sistema FInalizado", "Saindo", JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
                }
            password2 = JOptionPane.showInputDialog(null, "Entre com o seu Password cadastrado: ");
                if(password2 == null){
                   System.out.println("Sistema Finalizado");
                   JOptionPane.showMessageDialog(null, "Sistema FInalizado", "Saindo", JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
                    
                }
            //fim - pega os valores
            //adiciona os valores no arraylist logins
            JOptionPane.showMessageDialog(null, "Seja Bem Vindo(a)\n" + userName2, "Boas Vindas", JOptionPane.WARNING_MESSAGE);
            logins.add(new Login(userName2, password2));
            

        }
        
        

    }
}


