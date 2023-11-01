import java.util.Arrays;

public class CarEsportivo extends VeiculoMotorizado {

    public CarEsportivo(int id, double valor, int rodas) {
        super(id, valor, rodas,
                new String[] { "                   \\\n",
                        "    _______________/_>_________\n",
                        "o  /  _____ \\ <>     |  _____  \\\n",
                        " o=\\_/ ,-. \\_\\_______|_/ ,-. \\__D\n",
                        "      ( o )             ( o )\n",
                        "       `-'               `-'\n\n" });
        super.setValorIPVA(calcIPVA());
    }

    public void desenhaVeiculo() {
        Arrays.stream(getDesenho()).forEach(System.out::print);
    }

    public void moverVeiculo() {
        if (super.getCombustivel() >= super.getGastoEsportivo() && super.getIPVA() && super.checkRodas()) {
            String[] d = getDesenho();
            for (int i = 0; i < d.length; i++) {
                d[i] = " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + d[i];
            }
            setDistancia();
            setDesenho(d);
            setCombustivel(super.getCombustivel() - super.getGastoEsportivo());
        }
    }

    public double calcIPVA() {
        return IPVA.Esportivo * IPVA.base;
    }
}
