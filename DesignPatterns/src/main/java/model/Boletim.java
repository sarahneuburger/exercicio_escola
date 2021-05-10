package model;

import java.util.ArrayList;

/**
 * Reúne as avaliações de um Aluno {@link Aluno}. O boletim possui uma lista de
 * Provas {@link Prova} e é referente a um período. Para cada período é
 * calculada a média das provas que resulta na nota do Boletim.
 * 
 * @author Prof Ricardo
 *
 */
public class Boletim {

	private Integer id;
	private Aluno aluno;
	private Integer periodo;
	private Double media;
	private ArrayList<Prova> provas;

	/**
	 * Cria um novo Boletim.
	 * 
	 * O Boletim é criado a partir de um aluno e um período. Conforme as provas são
	 * adionadas, realiza-se o cálculo para a média.
	 * 
	 * @param aluno
	 * @param periodo
	 */
	public Boletim(Aluno aluno, Integer periodo) {
		this.aluno = aluno;
		this.periodo = periodo;
		this.media = 0.0;
		this.provas = new ArrayList<Prova>();
	}

	public Boletim() {
	}

	/**
	 * Id do Boletim.
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Aluno do boletim.
	 * 
	 * @return aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Período no formato YYYYMM.
	 * 
	 * @return periodo
	 */
	public Integer getPeriodo() {
		return periodo;
	}

	/**
	 * Retorna a média das provas atualizada.
	 * 
	 * @return media
	 */
	public Double getMedia() {
		return media;
	}

	/**
	 * Retorna todas as provas.
	 * 
	 * @return ArrayList<Prova>
	 */
	public ArrayList<Prova> getProvas() {
		return provas;

	}

	/**
	 * Seta o valor da média.
	 * 
	 * @param media
	 */
	public void setMedia(Double media) {
		this.media = media;
	}

	/**
	 * Limpa a lista de provas.
	 */
	public void resetProvas() {
		this.provas = new ArrayList<Prova>();
	}

}
