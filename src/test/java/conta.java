import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class conta {
	private int saldo;
	private String cliente;

	/**
	 * @param saldo Recebe saldo do cliente especial -200
	 * 
	 */
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer saldo) {
		cliente = "especial";
		this.saldo = saldo;
	}

	/**
	 * 
	 * @param valorSacar Recebe valor a ser sacado pelo cliente especial
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer valorSacar) {
		if (cliente == "especial") {
			saldo -= valorSacar;
		}
	}

	/**
	 * 
	 * @param saldoAtual Atualiza saldo da conta do cliente
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer saldoAtual) {
		if (saldo == saldoAtual) {
			System.out.println("Saque realizado com sucesso. " + "\n Saldo " + saldoAtual);
		}
	}

	/**
	 * 
	 * @param saldo Saldo cliente comum
	 */
	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer saldo) {
		cliente = "comum";
		this.saldo = saldo;
	}

	/**
	 * 
	 * @param valorSacar Recebe valor a ser sacado pelo cliente comum
	 */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer valorSacar) {
		if (cliente == "comum") {
			não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente();
		}
	}

	/**
	 * 
	 *@param Retorna mensagem de saldo insuficiente
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		System.out.println("Saldo Insuficiente");
	}
}
