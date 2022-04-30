package Trabalho;

import java.util.*;
import javax.swing.JOptionPane;

public class ControleProduto {
    List<Produto> listaProduto;

    public ControleProduto(){
        listaProduto = new ArrayList<Produto> (  );
    }

    public void incluir(String nome){
        Produto p = new Produto ();
        p.setNome (nome);
        p.setQuantidade ("1");
        p.setCodigo ("123"+listaProduto.size ());
        listaProduto.add (p);
        JOptionPane.showMessageDialog (null,"Produto inserido");
    }

    public void excluir(String codigo){
        for (int i = 0; i < listaProduto.size (); i++) {
            if(listaProduto.get (i).getCodigo ().equals (codigo)){
                listaProduto.remove (i);
                JOptionPane.showMessageDialog (null,"Produto excluido excluido");
            }else {
                JOptionPane.showMessageDialog (null,"Produto nao encontrado");
            }
        }
    }

    public void mostra(){
        StringBuilder msg = new StringBuilder ( );
        for(int i=0 ; i < listaProduto.size ( ) ; i++){
            msg.append ("Produto(").append (i + 1).append
                    (")").append ("\nProduto CODIGO = ").append
                    (listaProduto.get (i).getCodigo ( )).append ("\nProduto Nome = ").append
                    (listaProduto.get (i).getNome ( )).append ("\nProduto quantidade = ").append
                    (listaProduto.get (i).getQuantidade ( )).append ("\n--------------------------------\n");
        }
        JOptionPane.showMessageDialog(null, msg.toString ( ));
    }

    public void aumente(String codigo, String valor){
        for (int i = 0; i < listaProduto.size (); i++) {
            if(listaProduto.get (i).getCodigo ().equals (codigo)){
                //listaProduto.remove (i);
                int numero = Integer.parseInt (valor);
                int numero1 = Integer.parseInt (listaProduto.get (i).getQuantidade ());
                int numero2 = numero + numero1;
                listaProduto.get (i).setQuantidade (String.valueOf (numero2));
                JOptionPane.showMessageDialog (null,"Produto aumentado");
            }else {
                JOptionPane.showMessageDialog (null,"Produto nao encontrado");
            }
        }
    }

    public void diminui(String codigo, String valor){
        for (int i = 0; i < listaProduto.size (); i++) {
            if(listaProduto.get (i).getCodigo ().equals (codigo)){
                //listaProduto.remove (i);
                int numero = Integer.parseInt (valor);
                int numero1 = Integer.parseInt (listaProduto.get (i).getQuantidade ());
                int numero2 = numero - numero1;
                listaProduto.get (i).setQuantidade (String.valueOf (numero2));
                JOptionPane.showMessageDialog (null,"Produto diminuido");
            }else {
                JOptionPane.showMessageDialog (null,"Produto nao encontrado");
            }
        }
    }
}
