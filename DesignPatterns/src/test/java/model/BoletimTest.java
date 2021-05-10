package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.BoletimController;

public class BoletimTest {

	static Boletim boletim;
	static int periodoPadrao = 202105;
	BoletimController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = periodoPadrao;
		boletim = new Boletim(aluno, periodo);
	}

	@Test
	public void testBoletim() {
		assertNotNull(boletim);
	}

	@Test
	public void testGetAluno() {
		assertNotNull(boletim.getAluno());
	}

	@Test
	public void testGetPeriodo() {
		assertEquals(periodoPadrao, (int) boletim.getPeriodo());
	}

	@Test
	public void testGetMedia() {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, boletim.getAluno(), materia);
		try {
			controller.addProva(prova, 10.0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertEquals(10.0, (Double) boletim.getMedia(), 0.01);
	}

	@Before
	public void limparArray() {
		boletim.getProvas().clear();
		;
	}
}
