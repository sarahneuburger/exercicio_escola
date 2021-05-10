package model;

import persistence.ArrayListPersistenceBoletim;

public class BoletimDAO {
	
	ArrayListPersistenceBoletim db;
	
	public BoletimDAO(ArrayListPersistenceBoletim db) {
		this.db = db;
	}
	
	/**
	 * Adiciona um novo boletim.
	 * 
	 * @param boletim 
	 */
	public Boletim add(Boletim boletim) {
			return db.add(boletim);
	}
	
	/**
	 * Remove um boletim.
	 *  
	 * @param index
	 * @return void
	 */
	public void remove(int index) {
		db.remove(index);
	}
	
	/**
	 * Remove todas os boletins.
	 * 
	 * @return void	
	 */
	public void removeAll() {
		db.removeAll();
	}
	
	public Boletim get(int index) {
		return db.get(index);
	}

}
