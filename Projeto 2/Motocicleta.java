import java.util.Arrays;

public class Motocicleta extends VeiculoMotorizado {

    public Motocicleta(int id, double valor, int rodas) {
        super(id, valor, rodas,
                new String[] { "        _\n",
                        "        _\\D\n",
                        " _.-,_./_)\\\n",
                        "' (o)'--' (o)\n\n" });
        super.setValorIPVA(calcIPVA());
    }

    public void desenhaVeiculo() {
        Arrays.stream(getDesenho()).forEach(System.out::print);
    }

    public void moverVeiculo() {
        if (super.getCombustivel() >= super.getGastoMotocicleta() && super.getIPVA() && super.checkRodas()) {
            String[] d = getDesenho();
            for (int i = 0; i < d.length; i++) {
                d[i] = " " + " " + " " + d[i];
            }
            setDistancia();
            setDesenho(d);
            setCombustivel(super.getCombustivel() - super.getGastoMotocicleta());
        }
    }

    public double calcIPVA() {
        return IPVA.Motocicleta * IPVA.base;
    }
}
