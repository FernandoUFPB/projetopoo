package br.com.ufpb.projetopoo;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeedbackFacadeTest {
	
	
	@Test
	public void testCadastraFeedback() {
		GerenteDeFeedback gerente = new GerenteDeFeedback();
		Exercicio exer = new Exercicio();
		Professor p = new Professor("Diogo", "03");
		Aluno a = new Aluno("Fernado","99");
		
		gerente.CadastarFeedback(exer.getNomeExercicio(), p.getMatricula(), "Parabéns pela resposta correta!");
		gerente.CadastarFeedback(exer.getNomeExercicio(), a.getMatricula(), "Estava difícil, mas consegui!");
		
		try {
			assertEquals("Parabéns pela resposta correta!",gerente.PesquisaFeedback(exer.getNomeExercicio(), p.getMatricula()));
			assertTrue("Parabéns pela resposta correta!",gerente.PesquisaFeedback(exer.getNomeExercicio(), p.getMatricula()).startsWith("P"));
			
			assertEquals("Estava difícil, mas consegui!", gerente.PesquisaFeedback(exer.getNomeExercicio(), a.getMatricula()));
			
			
		} catch (FeedbackInexistenteException e) {
			fail("Falhoou");
		}
		
		try {
			assertFalse(gerente.PesquisaFeedback(exer.getNomeExercicio(), p.getMatricula())=="Parabéns");
			assertFalse(gerente.PesquisaFeedback(exer.getNomeExercicio(), a.getMatricula())=="você errou as questões");
		} catch (FeedbackInexistenteException e) {
			fail("FeedBack inexistente!!");
		}
	}

}
