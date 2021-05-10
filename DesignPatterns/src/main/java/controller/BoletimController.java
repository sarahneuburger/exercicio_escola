package controller;

import java.util.ArrayList;

import model.Boletim;
import model.BoletimDAO;
import model.Prova;
import persistence.ArrayListPersistenceBoletim;

/**
 * Classe BoletimController
 * 
 * Classe para interação com o DAO e trativas necessárias.
 */
public class BoletimController {

	private Boletim boletimModel;
	private BoletimDAO boletimDAO;
	private ArrayListPersistenceBoletim dbBoletim = new ArrayListPersistenceBoletim();

	/**
	 * Classe de controle do boletim.
	 * 
	 * Recebe um boletim e verifica se o boletim já existe na persistência. Se não
	 * existir, cria um novo.
	 * 
	 * @param boletimEntrada
	 */
	public BoletimController(Boletim boletimEntrada) {
		this.boletimDAO = new BoletimDAO(dbBoletim);
		this.boletimModel = boletimEntrada;
	}

	/**
	 * Adiciona um novo boletim.
	 * 
	 * @return boletimModel
	 */
	public Boletim addBoletim() {
		if (this.boletimModel.getId() == null) {
			return this.boletimDAO.add(this.boletimModel);
		}
		return this.boletimModel;
	}

	/**
	 * Adiciona uma avalição ao boletim.
	 * 
	 * Ao adicionar uma prova, a média é recalculada.
	 * 
	 * @param prova
	 * @throws Exception
	 */
	public void addProva(Prova prova, Double notaProva) throws Exception {
		ProvaController provaController = new ProvaController(prova);
		if (prova.getId() == null) {
			prova.setNota(notaProva);
			provaController.addProva(prova, notaProva);
		} else {
			provaController.get(prova.getId());
		}
		boletimModel.getProvas().add(prova);
		this.calcularMedia();
	}

	/**
	 * Remove uma avalição ao boletim.
	 * 
	 * Ao remover uma prova, a média é recalculada.
	 * 
	 * @param index
	 * @return void
	 */
	public void removeProva(int index) {
		ProvaController provaController = new ProvaController(index);
		provaController.removeProva(index);
		try {
			boletimModel.getProvas().remove(index);
			this.calcularMedia();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Remove todas as provas.
	 * 
	 * Limpa a lista de provas e recalcula a média.
	 * 
	 * @return void
	 */
	public void removeTodasProvas() {
		ArrayList<Prova> provas = this.boletimModel.getProvas();
		for (Prova prova : provas) {
			ProvaController provaController = new ProvaController(prova);
			provaController.removeProva(prova.getId());
		}
		this.boletimModel.getProvas().clear();
		this.calcularMedia();
	}

	/**
	 * Calcula a média ponderada das provas.
	 * 
	 * Realiza o cálculo da média das notas das provas e atualiza o valor da média.
	 * 
	 * @return media
	 */
	private void calcularMedia() {
		Double total = 0.0;
		int pesos = 0;
		// Duas formas de fazer o cálculo
		for (Prova prova : boletimModel.getProvas()) {
			total += prova.getNota() * prova.getPeso();
			pesos += prova.getPeso();
		}
//		for (int index = 0; index < provas.size(); index++) {
//			total += provas.get(index).getNota();		
//		}		
		boletimModel.setMedia(total / pesos);
	}

	public Boletim getBoletim() {
		return this.boletimModel;
	}

}
