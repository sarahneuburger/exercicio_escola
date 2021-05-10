package controller;

import model.Prova;
import model.ProvaDAO;
import persistence.ArrayListPersistenceProva;

/**
 * Classe ProvaController
 * 
 * Classe para interação com o DAO e trativas necessárias.
 *
 */
public class ProvaController {

	private ProvaDAO provaDao;
	private Prova prova;
	private ArrayListPersistenceProva dbProvas = new ArrayListPersistenceProva();

	/**
	 * Contrutores para instanciar a classe com um objeto
	 * Prova ou conforme ID da Prova já cadastrada.
	 */
	public ProvaController(Prova prova) {
		this.provaDao = new ProvaDAO(dbProvas);
		this.prova = prova;
	}

	public ProvaController(int index) {
		this.provaDao = new ProvaDAO(dbProvas);
		this.prova = provaDao.get(index);
	}

	/**
	 * Adiciona uma prova.
	 * 
	 * @param prova
	 * @param nota da prova
	 */
	public Prova addProva(Prova prova, Double nota) {
		if (this.prova.getId() == null) {
			return this.provaDao.add(this.prova, nota);
		}
		return this.prova;
	}

	/**
	 * Remove uma prova.
	 * 
	 * @param prova
	 */
	public void removeProva(int id) {
		try {
			provaDao.remove(id);
		} catch (Exception e) {
			System.out.println("Prova não removida. Erro:" + e.getMessage());
		}
	}
	
	/**
	 * Método que remove todas as provas.
	 */
	public void removerTodasProvas() {
		provaDao.removeAll();
	}

	/**
	 * Busca uma prova conforme ID informado.
	 * 
	 * @param id
	 * @return Prova
	 */
	public Prova get(Integer id) {
		return this.provaDao.get(id);
	}
	
	/**
	 * Método retorna uma prova já cadastrada, utilizado
	 * para os testes.
	 * 
	 * @return Prova
	 */
	public Prova getProva() {
		return this.prova;
	}
}
