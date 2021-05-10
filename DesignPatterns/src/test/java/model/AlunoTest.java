package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoTest {

	@Test (expected = Exception.class)
	public void testSetNomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Sarah123");
		// No JUnit 4, quando for testar uma exceção, coloca
		// a anotação "expected". Já no Jupiter, existe um
		// assertThrows.
	}
	
	@Test (expected = Exception.class)
	public void testSetNomeComCaractereProibido() 
			throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Sarah*&");
	}
	
	@Test
	public void testSetNomeSemNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Sarah");
		assertNotNull(aluno.getNome());
	}
	
	@Test (expected = Exception.class)
	public void testSetSobrenomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setSobrenome("1Brito2");
	}
	
	@Test (expected = Exception.class)
	public void testSetSobrenomeComCaractereProibido() 
			throws Exception {
		Aluno aluno = new Aluno();
		aluno.setSobrenome("?;Bri*to");
	}
	
	@Test
	public void testSetSobrenomeSemNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setSobrenome("Brito");
		assertNotNull(aluno.getSobrenome());
	}
	
	@Test (expected = Exception.class)
	public void testIdadeNegativa() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(-10);
	}
	
	@Test (expected = Exception.class)
	public void testIdadeAcima130() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(131);
	}
	
	@Test
	public void testIdadeValida() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(20);
		assertEquals((Integer) 20, aluno.getIdade());
	}

}
