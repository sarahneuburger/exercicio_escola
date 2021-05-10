package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProvaTest {

	static Prova prova;
	static int periodoParam = 202105;

	@BeforeClass
	public static void createProva() {
		Materia materia = new Materia();
		Integer periodo = periodoParam;
		Aluno aluno = new Aluno();
		prova = new Prova(periodo, aluno, materia);
	}

	@Test
	public void testProva() {
		assertNotNull(prova);
	}

	@Test
	public void testSetGetNotaCorreta() {
		try {
			prova.setNota(10.0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(10.0, (Double) prova.getNota(), 0.01);
	}

	@Test(expected = Exception.class)
	public void testSetGetNotaInorreta() throws Exception {
		prova.setNota(-10.0);
	}

	@Test
	public void testGetAluno() throws Exception {
		assertNotNull(prova.getAluno());
	}

	@Test
	public void testGetPeriodo() throws Exception {
		assertNotNull(prova.getPeriodo());
	}

	@Test
	public void testGetMateria() throws Exception {
		assertNotNull(prova.getMateria());
	}

}
