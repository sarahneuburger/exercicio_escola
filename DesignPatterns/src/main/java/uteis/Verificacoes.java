package uteis;

/**
 * Classe de Verificadores
 * 
 * Classe possui métodos para validações utilizados nas demais classes.
 * 
 * @author Prof Ricardo
 *
 */

public class Verificacoes {

	/**
	 * Método verificarCaracteresString
	 * 
	 * Método realiza a verificação se na String recebida constam números
	 * ou caracteres especiais e retorna true, caso existam. 
	 * 
	 * @param verificar String a ser verificada
	 * @return boolean
	 */
	public static boolean verificarCaracteresString(String verificar) {
		return !verificar.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};'"
				+ ":\"\\\\|,.<>\\/?]+.*");
	}
	
	/**
	 * Método verificarFaixaEtaria
	 * 
	 * Método realiza a verificação se a idade atende os parâmetros
	 * de ser maior que 0 e menor que 130.
	 * 
	 * @param verificar Idade Integer a ser verificada
	 * @return boolean
	 */
	public static boolean verificarFaixaEtaria(Integer verificar) {
		if(verificar < 0 || verificar > 130) {
			return false;
		}
		return true;
	}
	
}
