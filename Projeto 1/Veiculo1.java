import java.io.Serializable;

public class Veiculo1 implements Serializable {
    private int id;
    private int qtdRodas = 4;
    private String[] desenho = new String[5];
    private Roda1[] rodas = new Roda1[getQtdRodas()];
    private double combustivel = 2.5;
    private boolean IPVA;
    private double distancia = 0;
    private double valor;

    public Veiculo1() {
        this.desenho[0] = "      _______\n";
        this.desenho[1] = "    _/\\______\\\\__\n";
        this.desenho[2] = "o  / ,-. -|-  ,-.`-.\n";
        this.desenho[3] = " o=`( o )----( o )-'\n";
        this.desenho[4] = "     `-'      `-'\n\n";
        for (int i = 0; i < getQtdRodas(); i++)
            this.rodas[i] = new Roda1();
    }

    public Veiculo1(int id) {
        this.desenho[0] = "      _______\n";
        this.desenho[1] = "    _/\\______\\\\__\n";
        this.desenho[2] = "o  / ,-. -|-  ,-.`-.\n";
        this.desenho[3] = " o=`( o )----( o )-'\n";
        this.desenho[4] = "     `-'      `-'\n\n";
        for (int i = 0; i < getQtdRodas(); i++)
            this.rodas[i] = new Roda1();
        this.id = id;
    }

    public Veiculo1(int id, boolean ipva, double valor) {
        this.desenho[0] = "      _______\n";
        this.desenho[1] = "    _/\\______\\\\__\n";
        this.desenho[2] = "o  / ,-. -|-  ,-.`-.\n";
        this.desenho[3] = " o=`( o )----( o )-'\n";
        this.desenho[4] = "     `-'      `-'\n\n";
        for (int i = 0; i < getQtdRodas(); i++)
            this.rodas[i] = new Roda1();
        this.id = id;
        this.IPVA = ipva;
        this.valor = valor;
    }

    public int getID() {
        return this.id;
    }

    public int getQtdRodas() {
        return this.qtdRodas;
    }

    public boolean getIPVA() {
        return this.IPVA;
    }

    public double getCombustivel() {
        return this.combustivel;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getValor() {
        return this.valor;
    }

    public void setIPVA(boolean acao) {
        this.IPVA = acao;
    }

    public boolean checkRodas() {
        for (int i = 0; i < getQtdRodas(); i++) {
            if (rodas[i].getCalibragem() == false)
                return false;
        }
        return true;
    }

    public void setCombustivel(double valor) {
        this.combustivel += valor;
    }

    public void setRoda(int x, Boolean acao) {
        if (x <= getQtdRodas())
            this.rodas[x - 1].setCalibragem(acao);
    }

    public void desenhaCarro() {
        for (int i = 0; i < desenho.length; i++) {
            System.out.print(this.desenho[i]);
        }
    }

    public void moverCarro() {
        for (int i = 0; i < desenho.length; i++) {
            String aux = this.desenho[i];
            this.desenho[i] = " " + aux;
        }
        this.combustivel -= 0.55;
        this.distancia++;
    }

    public void imprimirDados() {
        System.out.println("\nCarro ID: " + getID());
        System.out.printf("Valor do carro: R$%.2f\n", getValor());
        System.out.printf("Combustivel: %.2f L\n", getCombustivel());
        System.out.println("Distancia percorrida: " + getDistancia() + " Km");
        if (getIPVA())
            System.out.println("IPVA: Pago!");
        else
            System.out.println("IPVA: Devedor!");
        String aux = "";
        for (int i = 0; i < getQtdRodas(); i++)
            aux = aux + "Roda " + (i + 1) + " " + rodas[i].rodaToString();
        System.out.println(aux);
    }
}
