package Trabalho;

import java.awt.GridLayout;
import javax.swing.*;

public class JanelaProduto extends JFrame{

    JTextField txtComando, txtCodigo, txtNome, txtQuantidade;
    JLabel modelo,cor, placa, renavam;
    JButton btGravar;

    public JanelaProduto(){
        super("Cadastros");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciar();
        this.setVisible(true);
    }

    public void iniciar(){
        txtComando = new JTextField(20);
        txtCodigo = new JTextField(20);
        txtNome = new JTextField(20);
        txtQuantidade = new JTextField(20);
        cor = new JLabel("Codigo");
        placa = new JLabel("nome");
        renavam = new JLabel("quantidade");
        btGravar = new JButton("Gravar");
        modelo = new JLabel("Comando");
        this.add(modelo); this.add(cor);
        this.add(txtComando); this.add(txtCodigo);
        this.add(placa); this.add(renavam);
        this.add(txtNome); this.add(txtQuantidade);

        this.setLayout(new GridLayout(5,2));
        this.add(btGravar);
        this.pack();
    }
}
