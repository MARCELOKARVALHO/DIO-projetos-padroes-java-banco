package StrategyServico;

public class Normal implements Rendimento {

    public double calcularRendimento(double aplicacao) {
        return aplicacao + (aplicacao * 0.05);
    }
}
