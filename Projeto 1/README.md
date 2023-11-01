# Projeto 1
No âmbito da disciplina, foi desenvolvido um projeto que envolveu a criação de um simulador de corrida de veículos. Neste projeto, os veículos competiam em uma corrida e eram controlados através de um centro de comandos. O objetivo era aplicar diversos conceitos importantes de programação orientada a objetos, incluindo o encapsulamento de dados, modificadores de acesso, getters e setters, métodos construtores parametrizados, sobrecarga de métodos, a palavra reservada "this," atributos estáticos e relacionamentos entre classes. Além disso, o projeto foi meticulosamente planejado para garantir que não apresentasse erros em tempo de execução, e um diagrama UML foi criado para documentar a estrutura do sistema.

## Roda1.java
Este arquivo representa uma classe simples que modela o estado de uma roda, permitindo que você defina o estado inicial aleatoriamente ou o atualize, obtenha o estado atual e obtenha uma representação em forma de texto do estado da roda.

1) A classe Roda1 possui um atributo booleano chamado roda, que indica se a roda está cheia (true) ou vazia (false).

2) O construtor Roda1 é responsável por criar uma instância da classe Roda1. Dentro do construtor, um objeto da classe Random é usado para gerar um valor booleano aleatório para inicializar o estado da roda.

3) Existem métodos na classe Roda1 para interagir com o estado da roda:
   
    - setCalibragem: Este método permite definir o estado da roda (cheia ou vazia) com base no valor booleano acao passado como argumento. Ele permite que você mude o estado da roda de acordo com as necessidades.

    - getCalibragem: Este método retorna o estado atual da roda como um valor booleano. Ele pode ser usado para verificar se a roda está cheia ou vazia.

    - rodaToString: Este método retorna uma representação textual do estado da roda como uma String. Se a roda estiver cheia, ele retorna "cheia!"; caso contrário, retorna "vazia!". Isso fornece uma descrição mais legível do estado da roda.

## Veiculo1.java
No geral, essa classe Veiculo1 representa um modelo simples de um veículo com recursos básicos de manipulação de dados e interação com o veículo, como adicionar combustível, mover o veículo e verificar o status das rodas. É importante mencionar que esta classe usa um array de objetos da classe Roda1

1) A classe Veiculo1 implementa a interface Serializable, o que significa que objetos dessa classe podem ser serializados e desserializados, o que é útil para salvar e restaurar objetos em arquivos ou transmiti-los pela rede.

2) A classe possui diversos atributos, incluindo id (identificador), qtdRodas (quantidade de rodas), desenho (um array de strings que representa o desenho do veículo), rodas (um array de objetos da classe Roda1 que representam as rodas do veículo), combustivel (quantidade de combustível), IPVA (um valor booleano que indica se o IPVA está pago ou não), distancia (a distância percorrida pelo veículo) e valor (o valor do veículo).

3) A classe possui três construtores, permitindo a criação de objetos Veiculo1 com diferentes parâmetros. O primeiro construtor cria um objeto com um ID, o segundo cria um objeto com um ID e um valor, e o terceiro cria um objeto com um ID, um valor e um status de IPVA.

4) Há métodos getters e setters para acessar e modificar os atributos da classe. Por exemplo, getID() retorna o ID do veículo, getCombustivel() retorna a quantidade de combustível, setIPVA() permite definir o status do IPVA e assim por diante.

    - checkRodas: verifica se todas as rodas do veículo têm calibragem correta, retornando true se todas estiverem calibradas e false caso contrário.

    - setCombustivel: permite adicionar combustível ao veículo.

    - setRoda: permite calibrar ou descalibrar uma roda específica do veículo com base no parâmetro x, que é o número da roda.

    - desenhaCarro: imprime o desenho do carro na saída padrão.

    - moverCarro: move o carro, atualizando o desenho, reduzindo o combustível e incrementando a distância percorrida.

    - imprimirDados: imprime informações detalhadas sobre o veículo, incluindo ID, valor, combustível, distância percorrida, status do IPVA e informações sobre as rodas.

## Simulador1.java
A classe Simulador1 é uma interface para interagir com os objetos da classe Veiculo1. Os métodos permitem realizar ações como adicionar, remover, mover e gerenciar os veículos no simulador.

1) A classe Simulador1 possui um atributo estático qtdVeiculos para rastrear a quantidade de veículos no simulador e um array de objetos Veiculo1 chamado veiculos para armazenar os veículos.

2) O construtor Simulador1 inicializa a quantidade de veículos como zero e cria um array de tamanho 20 para armazenar os veículos.

3) Existem vários métodos para realizar ações no simulador, incluindo:

    - incluirCarro: Permite a inclusão de um novo veículo no simulador, pedindo ao usuário para fornecer informações como valor, ID e status do IPVA.

    - removerCarro: Remove um veículo do simulador com base no ID fornecido pelo usuário.

    - mover: Move um veículo no simulador, verificando se ele tem IPVA pago, rodas calibradas e combustível suficiente.

    - moverTodos: Move todos os veículos no simulador que atendem aos critérios de IPVA pago, rodas calibradas e combustível suficiente.

    - pagarIPVA: Permite ao usuário pagar o IPVA de um veículo no simulador.

    - abastecer: Permite ao usuário abastecer um veículo com uma quantidade específica de combustível.

    - calibrarRodaX: Permite ao usuário esvaziar ou calibrar uma roda específica de um veículo.

    - calibrarTodasRodas: Permite ao usuário esvaziar ou calibrar todas as rodas de um veículo.

    - imprimirDadosVeiculo: Imprime os dados de um veículo específico com base no ID fornecido pelo usuário.

    - imprimirTodosDados: Imprime os dados de todos os veículos no simulador.

    - imprimirPista: Imprime uma representação gráfica dos veículos na pista de corrida.

    - gravarArquivo: Grava os dados dos veículos em um arquivo chamado "Corrida.dat".

    - lerArquivo: Lê os dados dos veículos a partir do arquivo "Corrida.dat".

    - imprimirIds: Imprime os IDs de todos os veículos no simulador.

    - procurarVeiculo: Procura um veículo com um ID específico no simulador e retorna o índice no array de veículos.

    - pedirId: Solicita ao usuário que insira um ID de veículo válido.

    - menu: Implementa um menu interativo que permite ao usuário escolher entre várias opções para interagir com os veículos no simulador.

## UsaSimulador1.java
Responsável por iniciar o simulador e permitir que o usuário interaja com ele por meio de um menu interativo. Ao executar o programa, o usuário terá a capacidade de realizar várias ações relacionadas aos veículos no simulador, de acordo com as opções fornecidas no menu.
