package uteis;

import static org.junit.Assert.*;

import org.junit.Test;

import uteis.Verificacoes;

public class VerificacoesTest {

	@Test
	public void testVerificarCaracteresCorreto() {
		assertTrue(Verificacoes.verificarCaracteresString("Sarah"));
	}

	@Test
	public void testVerificarCaracteresErrado() {
		assertFalse(Verificacoes.verificarCaracteresString("1Sarah?"));
	}

	@Test
	public void testVerificarIdadeCorreta() {
		assertTrue(Verificacoes.verificarFaixaEtaria(15));
	}
	
	@Test
	public void testVerificarIdadeErrada() {
		assertFalse(Verificacoes.verificarFaixaEtaria(150));
	}
	
}
