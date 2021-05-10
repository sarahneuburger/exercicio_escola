package model;

import persistence.ArrayListPersistenceProva;

public class ProvaDAO {

	ArrayListPersistenceProva db;

	public ProvaDAO(ArrayListPersistenceProva db) {
		this.db = db;
	}

	public void removeAll() {
		db.removeAll();
	}

	public void remove(int index) {
		db.remove(index);
	}

	public Prova add(Prova prova, Double nota) {
		try {
			prova.setNota(nota);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db.add(prova);
	}

	public Prova get(Integer index) {
		return db.get(index);
	}

}
