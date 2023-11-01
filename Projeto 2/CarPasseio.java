import java.util.Arrays;

public class CarPasseio extends VeiculoMotorizado {

    public CarPasseio(int id, double valor, int rodas) {
        super(id, valor, rodas,
                new String[] { "      _______\n",
                        "    _/\\______\\\\__\n",
                        "o  / ,-. -|-  ,-.`-.\n",
                        " o=`( o )----( o )-'\n",
                        "     `-'      `-'\n\n" });
        super.setValorIPVA(calcIPVA());
    }

    public void desenhaVeiculo() {
        Arrays.stream(getDesenho()).forEach(System.out::print);
    }

    public void moverVeiculo() {
        if (super.getCombustivel() >= super.getGastoPasseio() && super.getIPVA() && super.checkRodas()) {
            String[] d = getDesenho();
            for (int i = 0; i < d.length; i++) {
                d[i] = " " + " " + " " + " " + " " + d[i];
            }
            setDistancia();
            setDesenho(d);
            setCombustivel(super.getCombustivel() - super.getGastoPasseio());
        }
    }

    public double calcIPVA() {
        return IPVA.Passeio * IPVA.base;
    }

}
