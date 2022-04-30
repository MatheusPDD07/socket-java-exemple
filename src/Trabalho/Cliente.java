package Trabalho;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class Cliente{
    public static void main(String []args) throws IOException {
        Socket socket = new Socket ("localhost", 12345);
        System.out.println ("Connected!");
        ObjectOutputStream outputStream = new ObjectOutputStream (socket.getOutputStream ());//

        JanelaProduto janelaProduto = new JanelaProduto ( );
            janelaProduto.btGravar.addMouseListener (new MouseAdapter ( ) {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        outputStream.writeUTF (janelaProduto.txtComando.getText ( ));
                        outputStream.writeUTF (janelaProduto.txtNome.getText ( ));
                        outputStream.writeUTF (janelaProduto.txtCodigo.getText ( ));
                        outputStream.writeUTF (janelaProduto.txtQuantidade.getText ( ));
                        outputStream.flush ();

                    } catch (IOException exception) {
                        System.out.println ( "ERRO "+ exception.getMessage ());
                    }
                }
            });
        //}
    }
}

