package br.com.ufpb.projetopoo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ExercicioFacadeTest {
	private ExercicioFacade exercicio;
	@Before
	public void setUp() throws Exception {
		this.exercicio = new ExercicioFacade();
	}
	@Test
	//NOVO TESTE
	public void testCadastroDeProfessor() {
		try {
			exercicio.cadastrarProfessor("ayla", "123");
			Professor p = exercicio.pesquisaProfessorPelaMatricula("123");
			assertEquals("ayla", p.getNome());
			exercicio.cadastrarProfessor("ayla", "123");
			fail("Teveria ter lançado essa exceção");
		} catch (ProfessorJaExisteException e) {
			System.out.println("De fato a exceção é lançada");
		} catch (ProfessorInexistenteException e) {
			fail("não deve lançar essa exceção");
		}
	}

}