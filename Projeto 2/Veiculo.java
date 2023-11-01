import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    private int id;
    private int qtdRodas;
    private Roda[] rodas;
    private int distancia;
    private double valor;
    private String[] desenho;

    public Veiculo(int rodas) {
        this.rodas = new Roda[rodas];
        for (int i = 0; i < rodas; i++)
            this.rodas[i] = new Roda();
        this.qtdRodas = rodas;
        this.distancia = 0;
    }

    public Veiculo(int id, double valor, int rodas, String[] d) {
        this.rodas = new Roda[rodas];
        for (int i = 0; i < rodas; i++)
            this.rodas[i] = new Roda();
        this.desenho = d;
        this.id = id;
        this.valor = valor;
        this.qtdRodas = rodas;
        this.distancia = 0;
    }

    public int getID() {
        return this.id;
    }

    public void setDesenho(String[] desenho) {
        this.desenho = desenho;
    }

    public String[] getDesenho() {
        return desenho;
    }

    public void setDistancia() {
        this.distancia++;
    }

    public int getQtdRodas() {
        return this.qtdRodas;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getValor() {
        return this.valor;
    }

    public boolean checkRodas() {
        for (int i = 0; i < getQtdRodas(); i++) {
            if (rodas[i].getCalibragem() == false)
                return false;
        }
        return true;
    }

    public void setRoda(int x, Boolean acao) {
        if (x <= getQtdRodas())
            this.rodas[x - 1].setCalibragem(acao);
    }

    public void imprimirDados() {
        System.out.println("\nVeiculo ID: " + getID());
        System.out.printf("Valor do veiculo: R$%.2f\n", getValor());
        System.out.println("Distancia percorrida: " + getDistancia() + " Km");
        String aux = "";
        for (int i = 0; i < getQtdRodas(); i++)
            aux = aux + "Roda " + (i + 1) + " " + rodas[i].rodaToString();
        System.out.println(aux);
    }

    public abstract void desenhaVeiculo();

    public abstract void moverVeiculo();
}