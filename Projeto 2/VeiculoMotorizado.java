import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo implements IPVA {
    private final double gastoMotocicleta;
    private final double gastoPasseio;
    private final double gastoEsportivo;
    private double combustivel;
    private boolean IPVA;
    private double valorIPVA;

    public VeiculoMotorizado(int id, double valor, int rodas, String[] d) {
        super(id, valor, rodas, d);
        this.gastoMotocicleta = 0.25;
        this.gastoPasseio = 0.75;
        this.gastoEsportivo = 2.3;
        this.combustivel = 2.5;
        Random ipva = new Random();
        this.IPVA = ipva.nextBoolean();
    }

    public double getGastoMotocicleta() {
        return this.gastoMotocicleta;
    }

    public double getGastoPasseio() {
        return this.gastoPasseio;
    }

    public double getGastoEsportivo() {
        return this.gastoEsportivo;
    }

    public double getCombustivel() {
        return this.combustivel;
    }

    public void setCombustivel(double valor) {
        this.combustivel = valor;
    }

    public boolean getIPVA() {
        return this.IPVA;
    }

    public void setValorIPVA(double valor) {
        this.valorIPVA = valor;
    }

    public double getValorIPVA() {
        return this.valorIPVA;
    }

    public void imprimirDados() {
        super.imprimirDados();
        System.out.printf("Combustivel: %.2f L\n", getCombustivel());
        if (getIPVA())
            System.out.println("IPVA: Pago!");
        else
            System.out.println("IPVA: Devedor!");
        System.out.printf("Valor do IPVA: %.2f R$\n", getValorIPVA());
    }

    public void setIPVA(boolean acao) {
        this.IPVA = acao;
    }

    public abstract double calcIPVA();
}
