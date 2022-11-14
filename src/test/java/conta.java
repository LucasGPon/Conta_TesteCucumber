import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class conta {
    private boolean cliente;
    private int saldo;

    /**
     * 
     * @param cliente Retorna valor de cliente
     */
    public boolean isClienteEspecial() {
        return cliente;
    }

    /**
     * 
     * @param saldo Retorna saldo do cliente
     */
    public int getSaldoAtual() {
        return saldo;
    }

    /**
     * 
     * @param cliente especial
     */
    public void clienteEspecial() {
        this.cliente = true;
    }

    /**
     * 
     * @param cliente comum
     */
    public void clienteComum() {
        this.cliente = false;
    }
    
    /**
     * 
     * @param saldo recebe saldo do cliente
     */
    public void setSaldoAtual(int saldo) {
        this.saldo = saldo;
    }

    /**
     * 
     * @param valorDoSaque informar valor do saque para verificar elegibilidade cliente para sacar
     * @exception Exception saldo insuficiente
     */
    public boolean sacar(int valorDoSaque) throws Exception {
        // Se o saldo for ficar negativo
        if (this.saldo < valorDoSaque) {
            // E o cliente for especial
            if (isClienteEspecial()) {
                // Libera o saque e atualiza o saldo
                this.atualizarSaldo(valorDoSaque);
                return true;
                // Se o cliente for comum
            } else {
                // Não libera o saque e retorna uma mensagem na Exception
                throw new Exception("Saldo Insuficiente");
            }
            // Se o saldo for ficar positivo
        } else {
            // Libera o saque e atualiza o saldo
            this.atualizarSaldo(valorDoSaque);
            return true;
        }
    }

    /**
     * 
     * @param valorDoSaque atualiza saldo cliente
     */
    private void atualizarSaldo(int valorDoSaque) {
        this.saldo -= valorDoSaque;
    }

    /**
     * 
     * @param arg1 Informa saldo cliente
     */
    @Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
    public void um_cliente_especial_com_saldo_atual_de_reais(int arg1) throws Throwable {
        clienteEspecial();
        setSaldoAtual(arg1);
    }

    /**
     * 
     * @param arg1 Informa valor a sacar pelo cliente
     */
    @When("^for solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais(int arg1) throws Throwable {
        sacar(arg1);
    }

    /**
     * 
     * @param arg1 saldo da conta deve ser atualizado
     */
    @Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int arg1) throws Throwable {
        getSaldoAtual();
    }
}
