package Classes;

import java.util.Date;

/**
 *
 * @author 291021
 */
public class Ferramentas{
    int ID;
    String Item;
    String Marca;
    String Cor;
    float Peso;
    String Fabricante;
    Date Ano_de_Fabricacao;
    float Preco;
    char Isolado;

    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Date getAno_de_Fabricacao() {
        return Ano_de_Fabricacao;
    }

    public void setAno_de_Fabricacao(Date Ano_de_Fabricacao) {
        this.Ano_de_Fabricacao = Ano_de_Fabricacao;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public char getIsolado() {
        return Isolado;
    }

    public void setIsolado(char Isolado) {
        this.Isolado = Isolado;
    }

    public Ferramentas() {
    }

    public Ferramentas(String Item, String Marca, String Cor, float Peso, String Fabricante, Date Ano_de_Fabricacao, float Preco, char Isolado) {
        this.Item = Item;
        this.Marca = Marca;
        this.Cor = Cor;
        this.Peso = Peso;
        this.Fabricante = Fabricante;
        this.Ano_de_Fabricacao = Ano_de_Fabricacao;
        this.Preco = Preco;
        this.Isolado = Isolado;
    }
    
    public Ferramentas(int ID, String Item, String Marca, String Cor, float Peso, String Fabricante, Date Ano_de_Fabricacao, float Preco, char Isolado) {
        this.ID = ID;
        this.Item = Item;
        this.Marca = Marca;
        this.Cor = Cor;
        this.Peso = Peso;
        this.Fabricante = Fabricante;
        this.Ano_de_Fabricacao = Ano_de_Fabricacao;
        this.Preco = Preco;
        this.Isolado = Isolado;
    }
    
}
