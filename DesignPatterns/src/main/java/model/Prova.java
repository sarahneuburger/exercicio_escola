package model;

/**
 * A avaliação do desempenho do Aluno em uma Materia;
 * 
 * A prova registra uma avalição realizada pelo Aluno {@link Aluno} relativo ao
 * conhecimento de uma matéria. O Aluno {@link Aluno} poderá realizar várias
 * avaliações da mesma Materia. A média ponderada das notas das provas é
 * registrada no Boletim {@link Boletim} e verifica se o aluno foi aprovado.
 * 
 * @author Prof Ricardo
 */

public class Prova {

	private Integer id;
	private Integer periodo;
	private Aluno aluno;
	private Materia materia;
	private Double nota = 0.0;
	private int peso = 1;

	/**
	 * Avaliação de desempenho do aluno.
	 * 
	 * No construtor da prova não atribui-se valor para a nota para que seja
	 * possível a criação de provas para depois serem atribuídas as notas.
	 * 
	 * @param periodo Período no formato YYYYMM
	 * @param aluno   Aluno que realizou a prova
	 * @param materia Materia da prova
	 */
	public Prova(Integer periodo, Aluno aluno, Materia materia) {
		this.periodo = periodo;
		this.aluno = aluno;
		this.materia = materia;
	}

	/**
	 * Id da prova.
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta a ID da Prova.
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Valor da avaliação do ano.
	 * 
	 * @return nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * Determina a avaliação do aluno.
	 * 
	 * Não pode ser menor que 0 e nem maior do que o atributo Materia.notamaxima.
	 * 
	 * @param nota
	 * @throws Exception
	 */
	public void setNota(Double nota) throws Exception {
		if (nota < 0 || nota > this.materia.notaMaxima) {
			throw new Exception("Valor da nota inválido");
		}
		this.nota = nota;
	}

	/**
	 * Período no formato YYYYMM.
	 * 
	 * @return periodo da prova
	 */
	public Integer getPeriodo() {
		return periodo;
	}

	/**
	 * Aluno que realizou a prova.
	 * 
	 * @return aluno.
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Matéria da prova.
	 * 
	 * @return materia
	 */
	public Materia getMateria() {
		return materia;
	}

	/**
	 * Peso da prova.
	 * 
	 * Este peso será utilizado ao calcular a média ponderada das notas no Boletim.
	 * 
	 * @return peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * Seta o peso da prova, utilizado no cálculo da média aritmética.
	 * @param peso
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

}
