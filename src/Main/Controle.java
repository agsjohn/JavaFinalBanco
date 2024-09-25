package Main;

import Classes.Ferramentas;
import DAO.FerramentasDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 291021
 */
public class Controle {
    
    public static void listarFun(ArrayList<Ferramentas> ferramentas) {
        try {
            FerramentasDAO funDAO = new FerramentasDAO();
            ferramentas = funDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Lista de ferramentas: \n";
        int tamanho = ferramentas.size();
        Ferramentas ferramenta = new Ferramentas();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma ferramenta salva");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID: " + ferramentas.get(i).getID();
                msg = msg + "\nItem: " + ferramentas.get(i).getItem();
                msg = msg + "\nMarca: " + ferramentas.get(i).getMarca();
                msg = msg + "\nCor: " + ferramentas.get(i).getCor();
                msg = msg + "\nPeso: " + ferramentas.get(i).getPeso();
                msg = msg + "\nFabricante: " + ferramentas.get(i).getFabricante();
                msg = msg + "\nAno de Fabricação: " + sdf.format(ferramentas.get(i).getAno_de_Fabricacao());
                msg = msg + "\nPreço: " + ferramentas.get(i).getPreco();
                if(ferramenta.getIsolado() == 'S' || ferramenta.getIsolado() == 's'){
                    msg = msg + "\nIsolado: Sim";
                } else{
                    msg = msg + "\nIsolado: Não";
                }
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void inserir() {

        Ferramentas ferramenta = new Ferramentas();

        ferramenta.setItem(JOptionPane.showInputDialog("Digite o Item: "));
        ferramenta.setMarca(JOptionPane.showInputDialog("Digite a Marca: "));
        ferramenta.setCor(JOptionPane.showInputDialog("Digite a Cor: "));
        ferramenta.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Digite o Peso: ")));
        ferramenta.setFabricante(JOptionPane.showInputDialog("Digite a Fabricante: "));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Digite a Data de Fabricação: "));
            ferramenta.setAno_de_Fabricacao(dt);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ferramenta.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preço: ")));
        ferramenta.setIsolado(JOptionPane.showInputDialog("Digite se é Isolado (s/n): ").charAt(0));
        while(ferramenta.getIsolado() != 's' && ferramenta.getIsolado() != 'S' && ferramenta.getIsolado()
                != 'n' && ferramenta.getIsolado() != 'N'){
            ferramenta.setIsolado(JOptionPane.showInputDialog("Inválido, a ferramenta é Isolada? (s/n): ").charAt(0));
        }
        FerramentasDAO fdao = new FerramentasDAO();
        fdao.inserir(ferramenta);
    }

    public static void procurar() {

        int ID = 0;
        Ferramentas ferramenta = new Ferramentas();

        ID = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da Ferramenta para localizar"));

        try {
            FerramentasDAO x = new FerramentasDAO();
            ferramenta = x.procurar(ID);
        } catch (Exception ex) {
            System.out.println("problema");
        }
        String msg = "Dados da Ferrmenta com ID indicado \n";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (ferramenta == null) {
            JOptionPane.showMessageDialog(null, "Não encontrado !!");
        } else {
            msg = msg + "ID: " + ferramenta.getID();
                msg = msg + "\nItem: " + ferramenta.getItem();
                msg = msg + "\nMarca: " + ferramenta.getMarca();
                msg = msg + "\nCor: " + ferramenta.getCor();
                msg = msg + "\nPeso: " + ferramenta.getPeso();
                msg = msg + "\nFabricante: " + ferramenta.getFabricante();
                msg = msg + "\nAno de Fabricação: " + sdf.format(ferramenta.getAno_de_Fabricacao());
                msg = msg + "\nPreço: " + ferramenta.getPreco();
                if(ferramenta.getIsolado() == 'S' || ferramenta.getIsolado() == 's'){
                    msg = msg + "\nIsolado: Sim";
                } else{
                    msg = msg + "\nIsolado: Não";
                }
            msg = msg + "\n___________________________________________________ \n";
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void excluirFun() {
        Ferramentas ferramenta = new Ferramentas();
        FerramentasDAO fdao = new FerramentasDAO();
        int ID;
        ID = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da ferramenta a excluir"));
        ferramenta = fdao.procurar(ID);
        if (ferramenta != null) {
            fdao.excluir(ferramenta);
            JOptionPane.showMessageDialog(null, "A ferramenta com o ID " + ID + " foi excluido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "A ferramenta com o ID " + ID + " não foi localizado.");
        }
    }

    public static void atualizarFun() {
        Ferramentas ferramenta = new Ferramentas();
        FerramentasDAO fdao = new FerramentasDAO();
        int ID;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ID = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da ferramenta a atualizar"));
        ferramenta = fdao.procurar(ID);
        if (ferramenta != null) {
            ferramenta.setID(ID);
            ferramenta.setItem(JOptionPane.showInputDialog(null, "Digite o nome: ", ferramenta.getItem()));
            ferramenta.setMarca(JOptionPane.showInputDialog(null, "Digite a marca: ", ferramenta.getMarca()));
            ferramenta.setCor(JOptionPane.showInputDialog(null, "Digite a cor: ", ferramenta.getCor()));
            ferramenta.setPeso(Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o peso: ", ferramenta.getPeso())));
            ferramenta.setFabricante(JOptionPane.showInputDialog(null, "Digite o fabricante: ", ferramenta.getFabricante()));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Digite a data de fabricação: ", sdf.format(ferramenta.getAno_de_Fabricacao())));
                ferramenta.setAno_de_Fabricacao(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ferramenta.setPreco(Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o preço: ", ferramenta.getPreco())));
            char Isolado = JOptionPane.showInputDialog(null, "Digite se é isolado (s/n): ", ferramenta.getIsolado()).charAt(0);
            while(Isolado != 's' && Isolado != 'S' && Isolado != 'n' && Isolado != 'N'){
                Isolado = JOptionPane.showInputDialog("Inválido, a ferramenta é Isolada? (s/n): ").charAt(0);
            }
            ferramenta.setIsolado(Isolado);
            fdao.atualizar(ferramenta);
        } else {
            JOptionPane.showMessageDialog(null, "A ferramenta com o ID " + ID + " não foi localizado.");
        }
    }
}