package DAO;

import Classes.Ferramentas;
import Util.conexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 291021
 */
public class FerramentasDAO {
    private Connection conn;

    public FerramentasDAO() {
        try {
            this.conn = conexaoAulaDAO.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + ":\n" + e.getMessage());
        }
    }
    
    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList ferramentas = new ArrayList();
        try {
            String SQL = "SELECT * FROM ferramentas";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Item = rs.getString("Item");
                String Marca = rs.getString("Marca");
                String Cor = rs.getString("Cor");
                float Peso = rs.getFloat("Peso");
                String Fabricante = rs.getString("Fabricante");
                Date Ano_de_Fabricacao = rs.getDate("Ano_de_Fabricacao");
                float Preco = rs.getFloat("Preco");
                char Isolado;
                if (rs.getString("Isolado") == null) {
                    Isolado = ' ';
                } else {
                    Isolado = (rs.getString("Isolado")).charAt(0);
                }
                ferramentas.add(new Ferramentas(ID, Item, Marca, Cor, Peso, Fabricante, Ano_de_Fabricacao, Preco, Isolado));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar ferramentas " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
        return ferramentas;
    }

    public void inserir(Ferramentas ferramenta) {
        PreparedStatement ps = null;
        Connection connL = null;

        if (ferramenta == null) {
            JOptionPane.showMessageDialog(null, "O objeto ferramenta não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO ferramentas (Item, Marca, Cor, Peso, Fabricante, Ano_de_Fabricacao"
                    + ", Preco, Isolado) values (?,?,?,?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, ferramenta.getItem());
            ps.setString(2, ferramenta.getMarca());
            ps.setString(3, ferramenta.getCor());
            ps.setFloat(4, ferramenta.getPeso());
            ps.setString(5, ferramenta.getFabricante());
            java.util.Date dataJAVA = ferramenta.getAno_de_Fabricacao();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(6, dataSQL);
            ps.setFloat(7, ferramenta.getPreco());
            ps.setString(8, Character.toString(ferramenta.getIsolado()));
            ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir um nova ferramenta" + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

    public Ferramentas procurar(int ID) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Ferramentas ferramenta = new Ferramentas();
        ferramenta = null;
        try {
            String SQL = "SELECT * FROM ferramentas WHERE ID = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
//                int codigo = rs.getInt("codigo");
                String Item = rs.getString("Item");
                String Marca = rs.getString("Marca");
                String Cor = rs.getString("Cor");
                float Peso = rs.getFloat("Peso");
                String Fabricante = rs.getString("Fabricante");
                Date Ano_de_Fabricacao = rs.getDate("Ano_de_Fabricacao");
                float Preco = rs.getFloat("Preco");
                char Isolado;
                if (rs.getString("Isolado") == null) {
                    Isolado = ' ';
                } else {
                    Isolado = (rs.getString("Isolado")).charAt(0);
                }
                ferramenta = new Ferramentas(ID, Item, Marca, Cor, Peso, Fabricante, Ano_de_Fabricacao, Preco, Isolado);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao listar ferramentas " + sqle);
        } finally {
           // conexaoAulaDAO.close(connL, ps);
        }
        return ferramenta;
    }

    public void atualizar(Ferramentas ferramenta) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (ferramenta == null) {
            JOptionPane.showMessageDialog(null, "O objeto ferramenta não pode ser nulo.");
        }
        try {
            String SQL = "UPDATE ferramentas set Item=?, Marca=?, Cor=?, Peso=?, Fabricante=?, "
                    + "Ano_de_Fabricacao=?, Preco=?, Isolado=? WHERE ID=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, ferramenta.getItem());
            ps.setString(2, ferramenta.getMarca());
            ps.setString(3, ferramenta.getCor());
            ps.setFloat(4, ferramenta.getPeso());
            ps.setString(5, ferramenta.getFabricante());
            java.util.Date dataJAVA = ferramenta.getAno_de_Fabricacao();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(6, dataSQL);
            ps.setFloat(7, ferramenta.getPreco());
            ps.setString(8, Character.toString(ferramenta.getIsolado()));
            ps.setInt(9, ferramenta.getID());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao editar ferramenta " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }

    public void excluir(Ferramentas ferramenta) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (ferramenta == null) {
            JOptionPane.showMessageDialog(null, "O objeto ferramenta não pode ser nulo.");
        }
        try {
            String SQL = "DELETE FROM ferramentas WHERE ID=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ferramenta.getID());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir ferramenta " + sqle);
        } finally {
            conexaoAulaDAO.close(connL, ps);
        }
    }
}