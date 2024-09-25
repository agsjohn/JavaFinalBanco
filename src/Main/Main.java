package Main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 291021
 */
public class Main {
    public static void main(String[] args) {
        ArrayList ferramentas = new ArrayList();
        int esc;
        do{
            esc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n"
            + "1 - Inserir ferramenta\n"
            + "2 - Remover ferramenta\n"
            + "3 - Listar ferramentas\n"
            + "4 - Editar ferramenta\n"
            + "5 - Procurar ferramenta\n"
            + "0 - Sair"));
            switch(esc){
                case 3:
                    Controle.listarFun(ferramentas);
                    break;
                case 1:
                    Controle.inserir();
                    break;
                case 5:
                    Controle.procurar();
                    break;
                case 2:
                    Controle.excluirFun();
                    break;
                case 4:
                    Controle.atualizarFun();
                    break;
            }
        }while(esc != 0);
    }
}
