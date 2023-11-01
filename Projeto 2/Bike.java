import java.util.Arrays;

public class Bike extends Veiculo {

    public Bike(int id, double valor, int rodas) {
        super(id, valor, rodas, new String[] { "   __o\n", " _`\\<,_\n", "(*)/ (*)\n\n" });
    }

    public void desenhaVeiculo() {
        Arrays.stream(getDesenho()).forEach(System.out::print);
    }

    public void moverVeiculo() {
        if (checkRodas()) {
            String[] d = getDesenho();
            for (int i = 0; i < d.length; i++) {
                d[i] = " " + " " + d[i];
            }
            setDesenho(d);
            setDistancia();
        }
    }
}