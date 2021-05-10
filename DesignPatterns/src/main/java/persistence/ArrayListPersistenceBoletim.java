package persistence;

import java.util.ArrayList;

import model.Boletim;

public class ArrayListPersistenceBoletim extends ArrayListPersistence<Boletim> {

	@Override
	public boolean removeAll() {
		try {
			dados.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Integer indexItem) {
		try {
			dados.remove((int) indexItem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Boletim add(Boletim item) {
		try {
			Integer id = dados.size() + 1;
			item.setId(id);
			dados.add(item);
			return item;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Boletim get(Integer index) {
		try {
			return dados.get(index);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Boletim> getAll() {
		try {
			return dados;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
