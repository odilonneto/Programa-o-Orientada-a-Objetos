import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Simulador1 {
    private static int qtdVeiculos;
    private Veiculo1[] veiculos;

    public Simulador1() {
        Simulador1.qtdVeiculos = 0;
        this.veiculos = new Veiculo1[20];
    }

    public int getQtdVeiculos() {
        return Simulador1.qtdVeiculos;
    }

    public void incluirCarro(Scanner teclado) {
        if (getQtdVeiculos() < this.veiculos.length) {
            System.out.println("\nINCLUIR VEICULO");
            System.out.print("\nDigite o valor do veiculo: ");
            Double valor = teclado.nextDouble();
            Random ipva = new Random();
            Random id = new Random();
            this.veiculos[getQtdVeiculos()] = new Veiculo1(id.nextInt(100) + 1, ipva.nextBoolean(), valor);
            Simulador1.qtdVeiculos++;
            System.out.println("VEICULO ADICIONADO!");

        } else
            System.out.println("NAO E POSSIVEL, SIMULADOR CHEIO!");
    }

    public void removerCarro(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.println("\nREMOVER VEICULO");
            imprimirIds();
            int id = pedirId(teclado);
            for (int j = procurarVeiculo(id); j < getQtdVeiculos(); j++) {
                this.veiculos[j] = this.veiculos[j + 1];
                this.veiculos[j + 1] = null;
            }
            Simulador1.qtdVeiculos--;
            System.out.print("VEICULO REMOVIDO!\n");

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void mover(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nMOVIMENTAR VEICULO\n");
            imprimirIds();
            int id = pedirId(teclado);
            int i = procurarVeiculo(id);
            if (this.veiculos[i].getIPVA() && this.veiculos[i].checkRodas()
                    && this.veiculos[i].getCombustivel() >= 0.55) {
                this.veiculos[i].moverCarro();
                System.out.println("Veiculo movido!");
            } else
                System.out.println("Veiculo nao pode ser movido!");

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void moverTodos() {
        if (getQtdVeiculos() > 0) {
            for (int i = 0; i < getQtdVeiculos(); i++) {
                if (this.veiculos[i].getIPVA() && this.veiculos[i].checkRodas()
                        && this.veiculos[i].getCombustivel() >= 0.55) {
                    this.veiculos[i].moverCarro();
                }
            }
            System.out.print("\nVeiculos com IPVA's pagos, rodas calibradas e com combustivel serao movidos!\n");
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void pagarIPVA(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nPAGAR IPVA\n");
            imprimirIds();
            int id = pedirId(teclado);
            if (veiculos[procurarVeiculo(id)].getIPVA() == false) {
                this.veiculos[procurarVeiculo(id)].setIPVA(true);
                System.out.println("IPVA foi pago!");
            } else
                System.out.println("IPVA ja tinha sido pago!");

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void abastacer(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            int id;
            double qtd;
            System.out.print("\nABASTECER VEICULO\n");
            imprimirIds();
            id = pedirId(teclado);
            System.out.print("Digite a quantidade de litros que quer abastecer: ");
            qtd = teclado.nextDouble();
            this.veiculos[procurarVeiculo(id)].setCombustivel(qtd);
            System.out.println("Veiculo abastecido!");

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void calibrarRodaX(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nESVAZIAR/CALIBRAR PNEU\n");
            imprimirIds();
            int id = pedirId(teclado);
            int i = procurarVeiculo(id);
            System.out.print("Digite qual pneu voce quer esvaziar/calibrar: ");
            int pneu = teclado.nextInt();
            if (pneu <= veiculos[i].getQtdRodas()) {
                System.out.print("Digite 1 para esvaziar ou 2 para calibrar: ");
                int x = teclado.nextInt();
                if (x == 1) {
                    this.veiculos[i].setRoda(pneu, false);
                    System.out.println("Pneu esvaziado!");
                } else if (x == 2) {
                    this.veiculos[i].setRoda(pneu, true);
                    System.out.println("Pneu calibrado!");
                } else
                    System.out.println("Opcao invalida!");
            } else
                System.out.println("Roda " + pneu + " nao existe no veiculo!\n");
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void calibrarTodasRodas(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nESVAZIAR/CALIBRAR PNEU\n");
            imprimirIds();
            int id = pedirId(teclado);
            int i = procurarVeiculo(id);
            System.out.print("Digite 1 para esvaziar ou 2 para calibrar: ");
            int x = teclado.nextInt();
            if (x == 1) {
                for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                    this.veiculos[i].setRoda(j + 1, false);
                System.out.println("Pneus esvaziados!");
            } else if (x == 2) {
                for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                    this.veiculos[i].setRoda(j + 1, true);
                System.out.println("Pneus calibrados!");
            } else
                System.out.println("Opcao invalida!");

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void imprimirDadosVeiculo(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nDADOS DE UM VEICULOS\n");
            imprimirIds();
            int id = pedirId(teclado);
            veiculos[procurarVeiculo(id)].imprimirDados();

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void imprimirTodosDados() {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nDADOS DE TODOS OS VEICULOS\n");
            for (int i = 0; i < getQtdVeiculos(); i++) {
                veiculos[i].imprimirDados();
                System.out.print("\n");
            }
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void imprimirPista() {
        if (getQtdVeiculos() > 0) {
            System.out.println("\nPISTA DE CORRIDA\n");
            for (int i = 0; i < getQtdVeiculos(); i++) {
                veiculos[i].desenhaCarro();
            }
        } else
            System.out.println("\nSIMULADOR VAZIO!");
    }

    public void gravarArquivo() {
        if (getQtdVeiculos() > 0) {
            File arquivo = new File("Corrida.dat");
            try {
                FileOutputStream fout = new FileOutputStream(arquivo);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(this.veiculos);
                oos.flush();
                oos.close();
                fout.close();
            } catch (Exception ex) {
                System.err.println("erro: " + ex.toString());
            }
            System.out.println("\nARQUIVO GRAVADO!");
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void lerArquivo() {
        File arquivo = new File("Corrida.dat");

        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            this.veiculos = (Veiculo1[]) oin.readObject();
            oin.close();
            fin.close();

            int cont = 0;
            for (Veiculo1 p : this.veiculos) {
                if (p != null) {
                    p.imprimirDados();
                    cont++;
                }
            }
            Simulador1.qtdVeiculos = cont;
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
        System.out.println("\nLEITURA EFETIVADA!");
    }

    public void imprimirIds() {
        System.out.print("\nID's DOS VEICULOS DISPONIVEIS: ");
        for (int i = 0; i < getQtdVeiculos(); i++) {
            System.out.print(this.veiculos[i].getID() + "  ");
        }
    }

    public int procurarVeiculo(int id) {
        for (int i = 0; i < getQtdVeiculos(); i++) {
            if ((id == this.veiculos[i].getID()))
                return i;
        }
        return -1;
    }

    public int pedirId(Scanner ler) {
        int id;
        do {
            System.out.print("\nDigite o id do veiculo: ");
            id = ler.nextInt();
            if (procurarVeiculo(id) == -1)
                System.out.println("id invalido!");
        } while (procurarVeiculo(id) == -1);
        return id;
    }

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        System.out.println("\n..:: Bem Vindo ao simulador de corrida ::..");
        do {
            System.out.println("\nMENU");
            System.out.println("1 - Incluir veiculo");
            System.out.println("2 - Remover veiculo");
            System.out.println("3 - Abastecer veiculo");
            System.out.println("4 - Movimentar um veiculo");
            System.out.println("5 - Movimentar todos os veiculos");
            System.out.println("6 - Imprimir todos os dados de um veiculo");
            System.out.println("7 - Imprimir todos os dados de todos os veiculos");
            System.out.println("8 - Esvaziar/calibrar um pneu especifico");
            System.out.println("9 - Esvaziar/calibrar todos os pneus de um veiculo especifico");
            System.out.println("10 - Imprimir pista de corrida");
            System.out.println("11 - Gravar veiculos em arquivo");
            System.out.println("12 - Ler veiculos do arquivo");
            System.out.println("13 -  Pagar IPVA");
            System.out.println("14 -  Sair do simulador");
            System.out.print("Entre com uma opcao: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    incluirCarro(teclado);
                    break;
                case 2:
                    removerCarro(teclado);
                    break;
                case 3:
                    abastacer(teclado);
                    break;
                case 4:
                    mover(teclado);
                    break;
                case 5:
                    moverTodos();
                    break;
                case 6:
                    imprimirDadosVeiculo(teclado);
                    break;
                case 7:
                    imprimirTodosDados();
                    break;
                case 8:
                    calibrarRodaX(teclado);
                    break;
                case 9:
                    calibrarTodasRodas(teclado);
                    break;
                case 10:
                    imprimirPista();
                    break;
                case 11:
                    gravarArquivo();
                    break;
                case 12:
                    lerArquivo();
                    break;
                case 13:
                    pagarIPVA(teclado);
                    break;
                case 14:
                    System.out.println("\nSaindo!");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente!");
            }
        } while (opcao != 14);
        teclado.close();
    }
}
