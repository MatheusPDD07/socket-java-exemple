package Trabalho;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{

     static      ServerSocket                servidor;
                 Socket                      conexao;
                 ObjectInputStream           inputStream;
                 String                      mensagem;
                 String                      mensagem1;
                 String                      mensagem2;
                 String                      mensagem3;
                 ControleProduto             dao = new ControleProduto ();

    public Servidor(Socket con){
        this.conexao = con;
        try {

            inputStream = new ObjectInputStream (conexao.getInputStream ());

        } catch (IOException e) {
            System.out.println ( "ERRO "+e.getMessage () );
        }
    }

    public void run(){
        try {

            mensagem = inputStream.readUTF ();
            mensagem1 = inputStream.readUTF ();
            mensagem2 = inputStream.readUTF ();
            mensagem3 = inputStream.readUTF ();

            while (mensagem != null){

                mensagem = inputStream.readUTF ();
                mensagem1 = inputStream.readUTF ();
                mensagem2 = inputStream.readUTF ();
                mensagem3 = inputStream.readUTF ();

                switch (mensagem){
                    case "I":
                        dao.incluir (mensagem1);
                        break;
                    case "E":
                        dao.excluir (mensagem2);
                        break;
                    case "C":
                        dao.aumente (mensagem2,mensagem3);
                        break; //aumente
                    case "V":
                        dao.diminui (mensagem2,mensagem3);
                        break;//diminui
                    case "L":
                        dao.mostra ();
                        break;
                    default:
                        JOptionPane.showMessageDialog (null,"Comando incorreto");
                        break;
                }
            }


        } catch (IOException e) {
            System.out.println ( "ERRO "+e.getMessage () );
        }
    }

    public static void main(String []args) {

        try{
            servidor            = new ServerSocket(12345);

            while(true){
                System.out.println("Aguardando conexão...");
                Socket con = servidor.accept();
                System.out.println("Cliente conectado...");
                Thread t = new Servidor(con);
                t.start();
            }

        }catch (Exception e) {

            System.out.println ( "ERRO "+e.getMessage () );
        }
    }
}

