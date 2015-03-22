package br.com.ufpb.projetopoo;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
public class ExercicioFacade {
	private GerenteDeAluno gerenteDeAluno; 
	private GerenteDeExercicio gerenteDeExercicio;
	private GerenteDeProfessor gerenteDeProfessor;
	GravadorDeFacade gravador = new GravadorDeFacade();
	public ExercicioFacade(){
		try{
			this.gerenteDeExercicio = gravador.leGerenteDeExercicio();
			this.gerenteDeAluno = gravador.leGerenteDeAluno();
			this.gerenteDeProfessor = gravador.leGerenteDeProfessor();
		}catch(IOException e){
			System.out.println(e.getMessage());
			this.gerenteDeExercicio = new GerenteDeExercicio();
			this.gerenteDeAluno = new GerenteDeAluno();
			this.gerenteDeProfessor = new GerenteDeProfessor();
		}
	}
	public void sairDoSistema(){
		try{
			this.gravador.gravaGerenteDeExercicio(this.gerenteDeExercicio);
			this.gravador.gravaGerenteDeAluno(this.gerenteDeAluno);
			this.gravador.gravaGerenteDeProfessor(this.gerenteDeProfessor);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public void cadastrarExercicio(Exercicio e) {
		this.gerenteDeExercicio.cadastrarExercicio(e);
	}
	public void removeExercico(String nomeExercicio) throws ExercicioInexistenteException{
		this.gerenteDeExercicio.removeExercicio(nomeExercicio);
	}
	public List<Exercicio> listarExercíciosCadastrados() {
		return this.gerenteDeExercicio.listarExercíciosCadastrados();
	}
	public Exercicio pesquisarExercicio(String nomeExercicio)
			throws ExercicioInexistenteException {
		return this.gerenteDeExercicio.pesquisarExercicio(nomeExercicio);
	}
	public Exercicio sortearExercício() {
		return this.gerenteDeExercicio.sortearExercício();
	}
	public void atualizarExercício(String nomeExercicio, int numQuestao, String questao) 
			throws ExercicioInexistenteException {
		this.gerenteDeExercicio.atualizarExercicio(nomeExercicio, numQuestao, questao);
	}
	public Questao pesquisaQuestaoDeExercicio(String nomeExercicio, int numQuestao)
			throws QuestaoInexistenteException, ExercicioInexistenteException{
		return this.gerenteDeExercicio.pesquisaQuestaoDeExercicio(nomeExercicio, numQuestao);
	}
	public void cadastrarProfessor(String nome, String matricula)
			throws ProfessorJaExisteException {
		this.gerenteDeProfessor.cadastrarProfessor(nome, matricula);
	}
	public void removeProfessor(String matriculaProf)
			throws ProfessorInexistenteException {
		this.gerenteDeProfessor.removeProfessor(matriculaProf);
	}
	public Professor pesquisaProfessorPelaMatricula(String matricula)
			throws ProfessorInexistenteException {
		return this.gerenteDeProfessor.pesquisaProfessorPelaMatricula(matricula);
	}
	public List<Professor> obterListaDeProfessores() {
		return this.gerenteDeProfessor.obterListaDeProfessores();
	}
	public void cadastrarAluno(String nome, String matricula)
			throws AlunoJaExisteException {
		this.gerenteDeAluno.cadastraAluno(nome, matricula);
	}
	public Aluno pesquisaAlunoPelaMatricula(String matricula)
			throws AlunoInexistenteException {
		return this.gerenteDeAluno.pesquisaAlunoPelaMatricula(matricula);
	}
	public void removeAluno(String matricula) throws AlunoInexistenteException {
		this.gerenteDeAluno.removeAluno(matricula);
	}
	public Collection<Aluno> obterListaDeAlunos() {
		return this.gerenteDeAluno.obterListaDeAlunos();
	}
	public void cadastrarRespostaDoExercicio(RespostaDoExercicio r){
		this.gerenteDeExercicio.cadastrarRespostaDoExercicio(r);
	}
	public String enviarFeedbackParaAlunos(String nome,String matriculaAluno) throws ExercicioInexistenteException {
		return this.gerenteDeExercicio.enviarFeedbackParaAlunos(nome, matriculaAluno);	
	}
	public String enviarFeedbackParaProfessor(String nomeExercicio)throws ExercicioInexistenteException {
			return this.gerenteDeExercicio.enviarFeedbackParaProfessor(nomeExercicio);
	}
	public int corrigirExercicio(String nomeExercicio, String matricula) throws ExercicioInexistenteException {
		return this.gerenteDeExercicio.corrigirExercicio(nomeExercicio, matricula);
	}
}