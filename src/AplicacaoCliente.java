import StrategyServico.Rendimento;
import StrategyServico.TipoRendimento;

import java.util.Scanner;

public class AplicacaoCliente {

    //Facade
    public static void main(String[] args) {
        ClienteDoBanco cliente = new ClienteDoBanco("Luiz Marcelo Carvalho de Azevedo");
        ContaBancaria conta = new ContaBancaria("1365-9");

        Facade facade = new Facade();
        facade.fazerDeposito(1000, cliente, conta);

    //Strategy
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("\nDigite o valor que pretende aplicar:\n");
            double aplicacao = entrada.nextDouble();
            if(aplicacao>conta.obterSaldo())
            { System.out.println("\n           SALDO INSUFICIENTE!\nPara valores maiores que o saldo apenas a simulação é aplicada.");

                double opcao = conta.obterSaldo();
                double N = opcao + opcao * 0.05;
                double O = opcao + opcao * 0.10;

                System.out.printf("Para aplicação total do saldo atual de R$" + opcao + " na categoria NORMAL o rendimento será de " + N);
                System.out.printf("\nPara aplicação total do saldo atual de R$" + opcao + " na categoria OURO o rendimento será de " + O);

            }
            System.out.print("\nQual o tipo de aplicação?\n   (1) Normal - 0,05/mês\n   (2) Ouro   - 0,1/mês\n");
            int opcaoRendimento = entrada.nextInt();
            TipoRendimento tipoRendimento = TipoRendimento.values()[opcaoRendimento - 1];

            Rendimento rendimento = tipoRendimento.obterRendimento();
            double total = rendimento.calcularRendimento(aplicacao);
            System.out.printf("O valor total (" + aplicacao + " + rendimento) ao final do mês será de R$%.2f\n", total);
            System.out.printf("\nConexão com Banco de dados singleton - STATUS:\n\n");
        }

        //Singleton
        ConexaoBancoDados.getInstance().conectar();
       // operações diversas
        ConexaoBancoDados.getInstance().desconectar();


    }

}
