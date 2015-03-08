package br.com.ufpb.projetopoo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
public class ExercicioFacadeTest {
	private ExercicioFacade exercicio;
	
	private ExercicioFacade professores;
	private List<RespostaDeQuestao> respostas;
	@Before
	public void setUp() throws Exception {
		this.exercicio = new ExercicioFacade();
		this.professores = new ExercicioFacade();
		this.respostas = new ArrayList<RespostaDeQuestao>();
	}
	@Test
	public void testCadastrarExercicio(){
		Exercicio e = new Exercicio();
		Professor p = new Professor("ayla","123");
		e.setNomeExercicio("poo");
		e.setProfessor(p);
		e.cadastrarQuestao(1, "java é uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		try {
			Exercicio e1 = exercicio.pesquisarExercicio("poo");
			assertEquals("poo", e1.getNomeExercicio());
			Professor prof = e1.getProfessor();
			assertEquals("ayla", prof.getNome());
			List<Questao> q = e1.getQuestoes();
			int quantQuestao = q.size();
			assertTrue(1 == quantQuestao);
			assertEquals("java é uma linguagem de alto nivel V ou F?", q.get(0).getQuestao());
			assertEquals("v", q.get(0).getResposta());
		} catch (ExercicioInexistenteException e1) {
			fail("não deve lançar essa exceção");
		}
	}
	@Test
	public void testRemoveExercicio(){
		Exercicio e = new Exercicio();
		Professor p = new Professor("ayla","333");
		e.setNomeExercicio("lp");
		e.setProfessor(p);
		e.cadastrarQuestao(1, "linguagem de programação é orientada a objetos V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		List<Exercicio> l = exercicio.listarExercíciosCadastrados();
		int quantExercicio = l.size();
		assertTrue(1 == quantExercicio);
		try {
			exercicio.removeExercico("lp");
			int quantExercicio2 = l.size();
			assertTrue(0 == quantExercicio2);
		} catch (ExercicioInexistenteException e1) {
			fail("não deve lançar essa exceção");
		}
		
	}
	@Test
	public void testCadastrarProfessor() {
		try {
			exercicio.cadastrarProfessor("ayla", "123");
			Professor p = exercicio.pesquisaProfessorPelaMatricula("123");
			assertEquals("ayla", p.getNome());
		} catch (ProfessorJaExisteException e) {
			fail("não deve lançar essa exceção");
		} catch (ProfessorInexistenteException e) {
			fail("não deve lançar essa exceção");
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
			fail("não deve lançar essa exceção");
		} catch (ProfessorInexistenteException e) {
			fail("não deve lançar essa exceção");
		}
	}
	@Test
	public void testCadastrarAluno() {
		try {
			exercicio.cadastrarAluno("fernando", "123");
			Aluno a = exercicio.pesquisaAlunoPelaMatricula("123");
			assertEquals("fernando", a.getNome());
		} catch (AlunoJaExisteException e) {
			fail("não deve lançar essa exceção");
		} catch (AlunoInexistenteException e) {
			fail("não deve lançar essa exceção");
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
			fail("não deve lançar essa exceção");
		} catch (AlunoInexistenteException e) {
			fail("não deve lançar essa exceção");
		}
	}
	@Test
	public void testPesquisarExercicio(){
		Exercicio e = new Exercicio();
		Professor p = new Professor("ayla","123");
		e.setNomeExercicio("poo");
		e.setProfessor(p);
		e.cadastrarQuestao(1, "java é uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		try {
			Exercicio e1 = exercicio.pesquisarExercicio("poo");
			assertEquals("poo", e1.getNomeExercicio());
		} catch (ExercicioInexistenteException e1) {
			fail("não deve lançar essa exceção");
		}
	}
	@Test
	public void testAtualizarExercício(){
		Exercicio e = new Exercicio();
		Professor p = new Professor("ayla","123");
		e.setNomeExercicio("lp");
		e.setProfessor(p);
		e.cadastrarQuestao(1, "java é uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		try {
			Exercicio e1 = exercicio.pesquisarExercicio("lp");
			assertEquals("java é uma linguagem de alto nivel V ou F?", e1.getQuestoes().get(0).getQuestao());
			exercicio.atualizarExercício("lp", 1, "java é uma linguagem oo  V ou F?");
			assertEquals("java é uma linguagem oo  V ou F?", e1.getQuestoes().get(0).getQuestao());
		} catch (ExercicioInexistenteException e1) {
			fail("não deve lançar essa exceção");
		}
	}
	@Test
	public void testSortearExercício(){
		Exercicio e = new Exercicio();
		Professor p = new Professor("ayla","123");
		e.setNomeExercicio("lp");
		e.setProfessor(p);
		e.cadastrarQuestao(1, "java é uma linguagem de alto nivel V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e);
		
		Exercicio e2 = new Exercicio();
		Professor p2 = new Professor("ana","111");
		e2.setNomeExercicio("ld");
		e2.setProfessor(p2);
		e2.cadastrarQuestao(1, "prolog é uma linguagem declarativa V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e2);
		
		Exercicio exer = exercicio.sortearExercício();
		if(exer.getProfessor().getNome().equals("ayla")){
			assertEquals("lp", exer.getNomeExercicio());
		}else{
			assertEquals("ld",exer.getNomeExercicio());
		}
	}
	@Test
	public void testPesquisarQuestaoDeExercicio(){
		Exercicio e3 = new Exercicio();
		
		e3.cadastrarQuestao(1, "Libras é uma linguagem de sinais?", "Sim", TipoQuestao.QUESTAO_DISSERTATIVA);
		e3.cadastrarQuestao(2, "html é uma linguagem de programação?", "F", TipoQuestao.QUESTAO_V_OU_F);
		exercicio.cadastrarExercicio(e3);
		assertEquals(1,e3.getQuestoes().get(0).getNumQuestao());
		
		
	}
	@Test
	public void testPesquisaProfessorPelaMatricula(){
		try {
			this.professores.cadastrarProfessor("Ayla", "777");
			this.professores.cadastrarProfessor("Diogo", "454");
		} catch (ProfessorJaExisteException e1) {
			fail("Erro ao cadastrar professor");
		}
		
		try {
			assertEquals("Ayla",this.professores.pesquisaProfessorPelaMatricula("777").getNome());
		} catch (ProfessorInexistenteException e) {
			fail("Erro ao pesquisar o professor");
		}
		
		
		
	}
	@Test
	public void testObterListaDeProfessores(){
		try {
			this.professores.cadastrarProfessor("Diogo", "111");
			this.professores.cadastrarProfessor("Fernando", "000");
			this.professores.cadastrarProfessor("Ana", "222");
		} catch (ProfessorJaExisteException e) {
			fail("O professor já existe");
		}
		
		assertEquals(3,this.professores.obterListaDeProfessores().size());
	}
	@Test
	public void testCadastraEGetResposta(){
		RespostaDoExercicio r1 = new RespostaDoExercicio();
		r1.cadastrarRespostaDeQuestao(1, "V", TipoQuestao.QUESTAO_V_OU_F);
		RespostaDoExercicio r2 = new RespostaDoExercicio();
		r2.cadastrarRespostaDeQuestao(2, "Sim", TipoQuestao.QUESTAO_DISSERTATIVA);
		this.exercicio.cadastrarRespostaDoExercicio(r1);
		this.exercicio.cadastrarRespostaDoExercicio(r2);
		assertEquals(2,this.exercicio.getRespostaDoExercicio().size());
		assertEquals("V",this.exercicio.getRespostaDoExercicio().get(0).getResposta().get(0).getResposta());
		
	}
	
}