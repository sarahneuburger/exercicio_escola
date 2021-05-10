package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Aluno;
import model.Boletim;
import model.Materia;
import model.Prova;

public class BoletimControllerTest {

	static Boletim boletim;
	static int periodoPadrao = 202105;
	static BoletimController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = periodoPadrao;
		Boletim boletim = new Boletim(aluno, periodo);
		controller = new BoletimController(boletim);
	}

	@Test
	public void testBoletimController() {
		assertNotNull(controller.getBoletim());
	}

	@Test
	public void testAddProva() throws Exception {
		controller.removeTodasProvas();
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		Prova prova2 = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		controller.addProva(prova, 9.0);
		controller.addProva(prova2, 8.0);
		assertEquals(2, (int) controller.getBoletim().getProvas().size());
		assertEquals(8.5, controller.getBoletim().getMedia(), 0.01);
	}

	@Test
	public void testRemoveProva() throws Exception {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		Prova prova2 = new Prova(202105, controller.getBoletim().getAluno(), materia);
		controller.removeTodasProvas();
		controller.addProva(prova, 10.0);
		controller.addProva(prova2, 8.0);
		controller.removeProva(0);
		assertEquals(1, controller.getBoletim().getProvas().size());
		assertEquals(8.0, controller.getBoletim().getMedia(), 0.01);
	}

	@Test
	public void testRemoveProvaInexistente() throws Exception {
		controller.removeTodasProvas();
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		Prova prova2 = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		controller.removeTodasProvas();
		controller.addProva(prova, 10.0);
		controller.addProva(prova2, 8.0);
		controller.removeProva(4);
		assertEquals(2, controller.getBoletim().getProvas().size());
		assertEquals(9.0, controller.getBoletim().getMedia(), 0.01);
	}

	@Test
	public void testRemoveTodasProvas() throws Exception {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		controller.addProva(prova, 10.0);
		controller.removeTodasProvas();
		assertTrue(controller.getBoletim().getProvas().size() == 0);
	}

}
