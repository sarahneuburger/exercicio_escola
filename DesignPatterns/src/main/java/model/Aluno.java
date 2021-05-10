package model;

import uteis.Verificacoes;

/**
 * Pessoa que estuda na escola.
 * 
 * Um aluno é uma pessoa que estuda na escola. O aluno tem Nota {@link Nota} e
 * boletim {@link Boletim}.
 * 
 * @author Professor Ricardo
 * @see Turma
 * @see Nota
 * @see Boletim
 */
public class Aluno {

	private String nome;

	private String sobrenome;

	private Integer idade;

	/**
	 * Primeiro nome do aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Primeiro nome do aluno. Utilizar apenas caracteres alfabéticos.
	 * 
	 * @throws Exception
	 */
	public void setNome(String nome) throws Exception {
		if (!Verificacoes.verificarCaracteresString(nome)) {
			// matches verifica se há números entre as letras
			// o + significa que pode haver mais de um.
			throw new Exception("Nome deve conter apenas caracteres alfabéticos.");
			// A exceção "encaminha" o erro para quem está utilizando o
			// método incorretamente. Mensagem útil para o usuário.
		}
		this.nome = nome;
	}

	/**
	 * Último sobrenome do aluno.
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Último sobrenome do aluno. Utilizar apenas caracteres alfabéticos.
	 * 
	 * @throws Exception
	 */
	public void setSobrenome(String sobrenome) throws Exception {
		if (!Verificacoes.verificarCaracteresString(sobrenome)) {
			throw new Exception("Nome deve conter apenas caracteres alfabéticos.");
		}
		this.sobrenome = sobrenome;
	}

	/**
	 * Define a idade do aluno. Idade em anos.
	 * 
	 * @return idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * Define a idade do aluno. Idade em anos, deve ser um numero inteiro, maior ou
	 * igual a 0 e menor que 130.
	 * 
	 * @param Integer idade
	 * @return idade
	 * @throws Exception
	 */
	public void setIdade(Integer idade) throws Exception {
		if (Verificacoes.verificarFaixaEtaria(idade) == false) {
			throw new Exception("Idade inválida, deve estar em 0 e 130 " + "anos.");
		}
		this.idade = idade;
	}

}
