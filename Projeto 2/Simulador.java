import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Simulador {
    private static int qtdVeiculos;
    private static int qtdBikes;
    private static int qtdMotocicletas;
    private static int qtdCarPasseio;
    private static int qtdCarEsportivo;
    private Veiculo[] veiculos;

    public Simulador() {
        Simulador.qtdVeiculos = 0;
        Simulador.qtdBikes = 0;
        Simulador.qtdMotocicletas = 0;
        Simulador.qtdCarPasseio = 0;
        Simulador.qtdCarEsportivo = 0;
        this.veiculos = new Veiculo[20];
    }

    public static int getQtdVeiculos() {
        return Simulador.qtdVeiculos;
    }

    public static int getQtdBikes() {
        return qtdBikes;
    }

    public static int getQtdMotocicletas() {
        return qtdMotocicletas;
    }

    public static int getQtdCarPasseio() {
        return qtdCarPasseio;
    }

    public static int getQtdCarEsportivo() {
        return qtdCarEsportivo;
    }

    public void incluirVeiculo(Scanner teclado) {
        if (getQtdVeiculos() < this.veiculos.length) {
            char tipo;
            Random id = new Random();
            Double valor;
            System.out.println("\nINCLUIR VEICULO");
            do {
                System.out.println(
                        "\nTIPOS DE VEICULOS:\n(B) Bike\n(M) Motocicleta\n(P) Carro Passeio\n(E) Carro Esportivo");
                System.out.print("Entre com uma opcao: ");
                tipo = teclado.next().charAt(0);
                switch (tipo) {
                    case 'B':
                        System.out.print("\nDigite o valor da Bike: ");
                        valor = teclado.nextDouble();
                        this.veiculos[getQtdVeiculos()] = new Bike(id.nextInt(100) + 1, valor, 2);
                        Simulador.qtdBikes++;
                        break;
                    case 'M':
                        System.out.print("\nDigite o valor da Motocicleta: ");
                        valor = teclado.nextDouble();
                        this.veiculos[getQtdVeiculos()] = new Motocicleta(id.nextInt(100) + 1, valor, 2);
                        Simulador.qtdMotocicletas++;
                        break;
                    case 'P':
                        System.out.print("\nDigite o valor do Carro a Passeio: ");
                        valor = teclado.nextDouble();
                        this.veiculos[getQtdVeiculos()] = new CarPasseio(id.nextInt(100) + 1, valor, 4);
                        Simulador.qtdCarPasseio++;
                        break;
                    case 'E':
                        System.out.print("\nDigite o valor do Carro a Esportivo: ");
                        valor = teclado.nextDouble();
                        this.veiculos[getQtdVeiculos()] = new CarEsportivo(id.nextInt(100) + 1, valor, 4);
                        Simulador.qtdCarEsportivo++;
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Tente novamente!");
                }
            } while (tipo != 'B' && tipo != 'M' && tipo != 'P' && tipo != 'E');
            Simulador.qtdVeiculos++;
            System.out.println("VEICULO ADICIONADO!");

        } else
            System.out.println("NAO E POSSIVEL, SIMULADOR CHEIO!");
    }

    public void removerVeiculo(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.println("\nREMOVER VEICULO");
            imprimirIds();
            int id = pedirId(teclado);
            int i = procurarVeiculo(id);
            if (this.veiculos[i] instanceof Bike)
                Simulador.qtdBikes--;
            else if (this.veiculos[i] instanceof Motocicleta)
                Simulador.qtdMotocicletas--;
            else if (this.veiculos[i] instanceof CarPasseio)
                Simulador.qtdCarPasseio--;
            else
                Simulador.qtdCarEsportivo--;
            for (int j = i; j < getQtdVeiculos(); j++) {
                this.veiculos[j] = this.veiculos[j + 1];
                this.veiculos[j + 1] = null;
            }
            Simulador.qtdVeiculos--;
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
            this.veiculos[i].moverVeiculo();
            System.out.print("\nVeiculo com IPVA pago, rodas calibradas e com combustivel sera movido!\n");
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void moverTipo(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            char tipo;
            do {
                System.out.println(
                        "\nTIPOS DE VEICULOS:\n(B) Bike\n(M) Motocicleta\n(P) Carro Passeio\n(E) Carro Esportivo");
                System.out.print("Entre com uma opcao: ");
                tipo = teclado.next().charAt(0);
                switch (tipo) {
                    case 'B':
                        if (getQtdBikes() > 0) {
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof Bike)
                                    this.veiculos[i].moverVeiculo();
                            }
                            System.out.print("\nBikes com rodas calibradas foram movidas!\n");
                        } else
                            System.out.print("\nNao ha Bikes no simulador!\n");
                        break;
                    case 'M':
                        if (getQtdMotocicletas() > 0) {
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof Motocicleta)
                                    this.veiculos[i].moverVeiculo();
                            }
                            System.out.print(
                                    "\nMotocicletas com IPVA's pagos, rodas calibradas e com combustivel foram movidas!\n");
                        } else
                            System.out.print("\nNao ha Motocicletas no simulador!\n");
                        break;
                    case 'P':
                        if (getQtdCarPasseio() > 0) {
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof CarPasseio)
                                    this.veiculos[i].moverVeiculo();
                            }
                            System.out.print(
                                    "\nCarros a passeio com IPVA's pagos, rodas calibradas e com combustivel foram movidas!\n");
                        } else
                            System.out.print("\nNao ha Carros a Passeio no simulador!\n");
                        break;
                    case 'E':
                        if (getQtdCarEsportivo() > 0) {
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof CarEsportivo)
                                    this.veiculos[i].moverVeiculo();
                            }
                            System.out.print(
                                    "\nCarros esportivos com IPVA's pagos, rodas calibradas e com combustivel foram movidas!\n");
                        } else
                            System.out.print("\nNao ha Carros Esportivos no simulador!\n");
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Tente novamente!");
                }
            } while (tipo != 'B' && tipo != 'M' && tipo != 'P' && tipo != 'E');
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void moverTodos() {
        if (getQtdVeiculos() > 0) {
            for (int i = 0; i < getQtdVeiculos(); i++)
                this.veiculos[i].moverVeiculo();
            System.out.print("\nVeiculos em condicoes serao movidos!\n");
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void pagarIPVA(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nPAGAR IPVA\n");
            imprimirIds();
            int id = pedirId(teclado);
            int i = procurarVeiculo(id);
            if (this.veiculos[i] instanceof VeiculoMotorizado) {
                VeiculoMotorizado aux = (VeiculoMotorizado) this.veiculos[i];
                if (aux.getIPVA() == false) {
                    aux.setIPVA(true);
                    this.veiculos[i] = aux;
                    System.out.println("IPVA foi pago!");
                } else
                    System.out.println("IPVA ja tinha sido pago!");
            } else
                System.out.println("Nao foi possivel pois o veiculo nao eh do tipo motorizado!");
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
            int i = procurarVeiculo(id);
            if (this.veiculos[i] instanceof VeiculoMotorizado) {
                VeiculoMotorizado aux = (VeiculoMotorizado) this.veiculos[i];
                System.out.print("Digite a quantidade de litros que quer abastecer: ");
                qtd = teclado.nextDouble();
                aux.setCombustivel(qtd + aux.getCombustivel());
                this.veiculos[i] = aux;
                System.out.println("Veiculo abastecido!");
            } else
                System.out.println("Nao foi possivel pois o veiculo nao eh do tipo motorizado!");
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

    public void calibrarTodasRodasTipo(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            char tipo;
            int x;
            do {
                System.out.println(
                        "\nTIPOS DE VEICULOS:\n(B) Bike\n(M) Motocicleta\n(P) Carro Passeio\n(E) Carro Esportivo");
                System.out.print("Entre com uma opcao: ");
                tipo = teclado.next().charAt(0);
                switch (tipo) {
                    case 'B':
                        if (getQtdBikes() > 0) {
                            System.out.print("Digite 1 para esvaziar ou 2 para calibrar: ");
                            x = teclado.nextInt();
                            if (x == 1) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof Bike) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, false);
                                    }
                                }
                                System.out.println("Pneus de todas as Bikes foram esvaziados!");
                            } else if (x == 2) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof Bike) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, true);
                                    }
                                }
                                System.out.println("Pneus de todas as Bikes foram calibrados!");
                            } else
                                System.out.println("Opcao invalida!");
                        } else
                            System.out.print("\nNao ha Bikes no simulador!\n");
                        break;
                    case 'M':
                        if (getQtdMotocicletas() > 0) {
                            System.out.print("Digite 1 para esvaziar ou 2 para calibrar: ");
                            x = teclado.nextInt();
                            if (x == 1) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof Motocicleta) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, false);
                                    }
                                }
                                System.out.println("Pneus de todas as Motocicletas foram esvaziados!");
                            } else if (x == 2) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof Motocicleta) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, true);
                                    }
                                }
                                System.out.println("Pneus de todas as Motocicletas foram calibrados!");
                            } else
                                System.out.println("Opcao invalida!");
                        } else
                            System.out.print("\nNao ha Motocicletas no simulador!\n");
                        break;
                    case 'P':
                        if (getQtdCarPasseio() > 0) {
                            System.out.print("Digite 1 para esvaziar ou 2 para calibrar: ");
                            x = teclado.nextInt();
                            if (x == 1) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof CarPasseio) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, false);
                                    }
                                }
                                System.out.println("Pneus de todos os Carros a Passeio foram esvaziados!");
                            } else if (x == 2) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof CarPasseio) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, true);
                                    }
                                }
                                System.out.println("Pneus de todos os Carros a Passeio foram calibrados!");
                            } else
                                System.out.println("Opcao invalida!");
                        } else
                            System.out.print("\nNao ha Carros a Passeio no simulador!\n");
                        break;
                    case 'E':
                        if (getQtdCarEsportivo() > 0) {
                            System.out.print("Digite 1 para esvaziar ou 2 para calibrar: ");
                            x = teclado.nextInt();
                            if (x == 1) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof CarEsportivo) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, false);
                                    }
                                }
                                System.out.println("Pneus de todos os Carros Esportivo foram esvaziados!");
                            } else if (x == 2) {
                                for (int i = 0; i < getQtdVeiculos(); i++) {
                                    if (this.veiculos[i] instanceof CarEsportivo) {
                                        for (int j = 0; j < this.veiculos[i].getQtdRodas(); j++)
                                            this.veiculos[i].setRoda(j + 1, true);
                                    }
                                }
                                System.out.println("Pneus de todos os Carros Esportivo foram calibrados!");
                            } else
                                System.out.println("Opcao invalida!");
                        } else
                            System.out.print("\nNao ha Carros Esportivo no simulador!\n");
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Tente novamente!");

                }
            } while (tipo != 'B' && tipo != 'M' && tipo != 'P' && tipo != 'E');
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

    public void imprimirDados(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            System.out.print("\nDADOS DE UM VEICULOS\n");
            imprimirIds();
            int id = pedirId(teclado);
            veiculos[procurarVeiculo(id)].imprimirDados();

        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void imprimirDadosTipo(Scanner teclado) {
        if (getQtdVeiculos() > 0) {
            char tipo;
            do {
                System.out.println(
                        "\nTIPOS DE VEICULOS:\n(B) Bike\n(M) Motocicleta\n(P) Carro Passeio\n(E) Carro Esportivo");
                System.out.print("Entre com uma opcao: ");
                tipo = teclado.next().charAt(0);
                switch (tipo) {
                    case 'B':
                        if (getQtdBikes() > 0) {
                            System.out.print("\nDADOS DE TODOS AS BIKES\n");
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof Bike) {
                                    this.veiculos[i].imprimirDados();
                                    System.out.print("\n");
                                }
                            }
                        } else
                            System.out.print("\nNao ha Bikes no simulador!\n");
                        break;
                    case 'M':
                        if (getQtdMotocicletas() > 0) {
                            System.out.print("\nDADOS DE TODOS AS MOTOCICLETAS\n");
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof Motocicleta) {
                                    this.veiculos[i].imprimirDados();
                                    System.out.print("\n");
                                }
                            }
                        } else
                            System.out.print("\nNao ha Motocicletas no simulador!\n");
                        break;
                    case 'P':
                        if (getQtdCarPasseio() > 0) {
                            System.out.print("\nDADOS DE TODOS OS CARROS A PASSEIO\n");
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof CarPasseio) {
                                    this.veiculos[i].imprimirDados();
                                    System.out.print("\n");
                                }
                            }
                        } else
                            System.out.print("\nNao ha Carros a Passeio no simulador!\n");
                        break;
                    case 'E':
                        if (getQtdCarEsportivo() > 0) {
                            System.out.print("\nDADOS DE TODOS OS CARROS ESPORTIVOS\n");
                            for (int i = 0; i < getQtdVeiculos(); i++) {
                                if (this.veiculos[i] instanceof CarEsportivo) {
                                    this.veiculos[i].imprimirDados();
                                    System.out.print("\n");
                                }
                            }
                        } else
                            System.out.print("\nNao ha Carros Esportivo no simulador!\n");
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Tente novamente!");
                }
            } while (tipo != 'B' && tipo != 'M' && tipo != 'P' && tipo != 'E');
        } else
            System.out.println("\nNAO E POSSIVEL, SIMULADOR VAZIO!");
    }

    public void imprimirDadosDeTodos() {
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
                veiculos[i].desenhaVeiculo();
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

            this.veiculos = (Veiculo[]) oin.readObject();
            oin.close();
            fin.close();

            int cont = 0;
            for (Veiculo p : this.veiculos) {
                if (p != null) {
                    p.imprimirDados();
                    cont++;
                    if (p instanceof Bike)
                        Simulador.qtdBikes++;
                    else if (p instanceof Motocicleta)
                        Simulador.qtdMotocicletas++;
                    else if (p instanceof CarPasseio)
                        Simulador.qtdCarPasseio++;
                    else
                        Simulador.qtdCarEsportivo++;
                }
            }
            Simulador.qtdVeiculos = cont;
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
            System.out.println("6 - Movimentar veiculos por tipo");
            System.out.println("7 - Imprimir todos os dados de um veiculo");
            System.out.println("8 - Imprimir todos os dados de todos os veiculos");
            System.out.println("9 - Imprimir todos os dados de veiculos por tipo");
            System.out.println("10 - Esvaziar/calibrar um pneu especifico");
            System.out.println("11 - Esvaziar/calibrar todos os pneus de um veiculo especifico");
            System.out.println("12 - Esvaziar/calibrar todos os pneus de veiculo por tipo");
            System.out.println("13 - Imprimir pista de corrida");
            System.out.println("14 - Gravar veiculos em arquivo");
            System.out.println("15 - Ler veiculos do arquivo");
            System.out.println("16 -  Pagar IPVA");
            System.out.println("17 -  Sair do simulador");
            System.out.print("Entre com uma opcao: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    incluirVeiculo(teclado);
                    break;
                case 2:
                    removerVeiculo(teclado);
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
                    moverTipo(teclado);
                    break;
                case 7:
                    imprimirDados(teclado);
                    break;
                case 8:
                    imprimirDadosDeTodos();
                    break;
                case 9:
                    imprimirDadosTipo(teclado);
                    break;
                case 10:
                    calibrarRodaX(teclado);
                    break;
                case 11:
                    calibrarTodasRodas(teclado);
                    break;
                case 12:
                    calibrarTodasRodasTipo(teclado);
                    break;
                case 13:
                    imprimirPista();
                    break;
                case 14:
                    gravarArquivo();
                    break;
                case 15:
                    lerArquivo();
                    break;
                case 16:
                    pagarIPVA(teclado);
                    break;
                case 17:
                    System.out.println("\nSaindo!");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente!");
            }
        } while (opcao != 17);
        teclado.close();
    }
}
