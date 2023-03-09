import Servico.connection;

public class ConexaoBancoDados {

    private connection conexao;
    private String nomeBanco;

    private static ConexaoBancoDados instancia;

    private ConexaoBancoDados() {
        //nome,conta, senha, etc.
    }

    public static synchronized ConexaoBancoDados getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBancoDados();
        }
        return instancia;
    }

    public void conectar() {
        System.out.println("Conectado");
    }

    public void desconectar() {
        System.out.println("desconectado");
    }

    public connection getConexao() {
        return conexao;
    }

    public void setConexao(connection conexao) {
        this.conexao = conexao;
    }
}
