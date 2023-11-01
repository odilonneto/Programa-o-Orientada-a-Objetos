import java.io.Serializable;
import java.util.Random;

public class Roda1 implements Serializable {
    private boolean roda;

    public Roda1() {
        Random r = new Random();
        this.roda = r.nextBoolean();
    }

    public void setCalibragem(boolean acao) {
        this.roda = acao;
    }

    public boolean getCalibragem() {
        return this.roda;
    }

    public String rodaToString() {
        if (this.roda == true)
            return "cheia! ";
        else
            return "vazia! ";
    }

}