package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Aluno;
import model.Materia;
import model.Prova;
import model.ProvaDAO;

public class ProvaControllerTest {
	
	static Prova provaModel;
	static int periodoPadrao = 202105;
	static ProvaController controller;
	static BoletimController controllerBoletim;
	static ProvaDAO dao;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = periodoPadrao;
		Materia materia = new Materia();
		Prova prova = new Prova(periodo, aluno, materia);
		prova.setNota(10.0);
		controller = new ProvaController(prova);
	}

	@Test
	public void testProvaController() {
		assertNotNull(controller.getProva());
	}
	
	@Test
	public void testAddProva() {
		controller.removerTodasProvas();
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova1 = new Prova(periodoPadrao, aluno, materia);
		controller.addProva(prova1, 10.0);
		assertEquals(10.0, controller.getProva().getNota(), 0.01);
	}

	@Test
	public void testRemoveProva() {
		controller.removerTodasProvas();
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova1 = new Prova(periodoPadrao, aluno, materia);
		controller.addProva(prova1, 10.0);
		controller.removeProva(0);
		assertNull(controller.get(0));
	}
	
	@Test
	public void testGetID() {
		controller.removerTodasProvas();
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova1 = new Prova(periodoPadrao, aluno, materia);
		controller.addProva(prova1, 10.0);
		Prova provaRecuperada = controller.get(0);
		assertEquals(10.0, provaRecuperada.getNota(), 0.01);
	}
	
	@Test
	public void testRemoverTodas() {
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova1 = new Prova(periodoPadrao, aluno, materia);
		controller.addProva(prova1, 10.0);
		controller.removerTodasProvas();
		assertNull(controller.get(0));
	}
}
