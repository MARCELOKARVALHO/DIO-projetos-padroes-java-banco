package StrategyServico;

public class Ouro implements Rendimento {

    public double calcularRendimento(double aplicacao) {
        return aplicacao + (aplicacao * 0.1);
    }
}
