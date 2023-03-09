package StrategyServico;


public enum TipoRendimento {

    NORMAL {
        @Override
        public Rendimento obterRendimento() {
            return new Normal();
        }
    },
    SEDEX {
        @Override
        public Rendimento obterRendimento() {
            return new Ouro();
        }
    };

    public abstract Rendimento obterRendimento();
}
