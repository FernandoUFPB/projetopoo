package br.com.ufpb.projetopoo;

import static org.junit.Assert.*;
import java.util.Collection;
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
	public void testCadastrarExercicio(){
		Exercicio e = new Exercicio("poo");		
		e.cadastrarQuestao(1, "java � uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		try {
			Exercicio e1 = exercicio.pesquisarExercicio("poo");
			assertEquals("poo", e1.getNomeExercicio());
			List<Questao> q = e1.getQuestoes();
			int quantQuestao = q.size();
			assertTrue(1 == quantQuestao);
			assertEquals("java � uma linguagem de alto nivel V ou F?", q.get(0).getQuestao());
			assertEquals("v", q.get(0).getResposta());
		} catch (ExercicioInexistenteException e1) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	@Test
	public void testRemoveExercicio(){
		Exercicio e = new Exercicio("lp");	
		e.cadastrarQuestao(1, "linguagem de programa��o � orientada a objetos V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		List<Exercicio> l = exercicio.listarExerc�ciosCadastrados();
		int quantExercicio = l.size();
		assertTrue(1 == quantExercicio);
		try {
			exercicio.removeExercico("lp");
			int quantExercicio2 = l.size();
			assertTrue(0 == quantExercicio2);
		} catch (ExercicioInexistenteException e1) {
			fail("n�o deve lan�ar essa exce��o");
		}		
	}
	@Test
	public void testCadastrarProfessor() {
		try {
			exercicio.cadastrarProfessor("ayla", "123");
			Professor p = exercicio.pesquisaProfessorPelaMatricula("123");
			assertEquals("ayla", p.getNome());
		} catch (ProfessorJaExisteException e) {
			fail("n�o deve lan�ar essa exce��o");
		} catch (ProfessorInexistenteException e) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	public void testRemoverProfessor(){
		try {
			exercicio.cadastrarProfessor("ayla", "999");
			List<Professor> prof = exercicio.obterListaDeProfessores();
			int quantProf = prof.size();
			assertTrue(1 == quantProf);
			exercicio.removeProfessor("999");
			int quantProf2 = prof.size();
			assertTrue(0 == quantProf2);
		} catch (ProfessorJaExisteException e) {
			fail("n�o deve lan�ar essa exce��o");
		} catch (ProfessorInexistenteException e) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	@Test
	public void testCadastrarAluno() {
		try {
			exercicio.cadastrarAluno("fernando", "123");
			Aluno a = exercicio.pesquisaAlunoPelaMatricula("123");
			assertEquals("fernando", a.getNome());
		} catch (AlunoJaExisteException e) {
			fail("n�o deve lan�ar essa exce��o");
		} catch (AlunoInexistenteException e) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	@Test
	public void testRemoverAluno(){
		try {
			exercicio.cadastrarAluno("tomaz", "999");
			Collection<Aluno> a = exercicio.obterListaDeAlunos();
			int quantAluno = a.size();
			assertTrue(1 == quantAluno);
			exercicio.removeAluno("999");
			int quantAluno2 = a.size();
			assertTrue(0 == quantAluno2);
		} catch (AlunoJaExisteException e) {
			fail("n�o deve lan�ar essa exce��o");
		} catch (AlunoInexistenteException e) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	@Test
	public void testPesquisarExercicio(){
		Exercicio e = new Exercicio("poo");
		e.cadastrarQuestao(1, "java � uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		try {
			Exercicio e1 = exercicio.pesquisarExercicio("poo");
			assertEquals("poo", e1.getNomeExercicio());
		} catch (ExercicioInexistenteException e1) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	@Test
	public void testAtualizarExerc�cio(){
		Exercicio e = new Exercicio("lp");
		e.cadastrarQuestao(1, "java � uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		try {
			Exercicio e1 = exercicio.pesquisarExercicio("lp");
			assertEquals("java � uma linguagem de alto nivel V ou F?", e1.getQuestoes().get(0).getQuestao());
			exercicio.atualizarExerc�cio("lp", 1, "java � uma linguagem oo  V ou F?");
			assertEquals("java � uma linguagem oo  V ou F?", e1.getQuestoes().get(0).getQuestao());
		} catch (ExercicioInexistenteException e1) {
			fail("n�o deve lan�ar essa exce��o");
		}
	}
	@Test
	public void testSortearExerc�cio(){
		Exercicio e = new Exercicio("poo");
		e.cadastrarQuestao(1, "java � uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		
		Exercicio exer = exercicio.sortearExerc�cio();
		assertEquals("poo", exer.getNomeExercicio());
	}
	
}