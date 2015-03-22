package br.com.ufpb.projetopoo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
public class GerenteDeProfessor implements Serializable{
	private List<Professor> professores;
	public GerenteDeProfessor(){
		this.professores = new LinkedList<Professor>();
	}
	public void cadastrarProfessor(String nome, String matricula)
			throws ProfessorJaExisteException {
		for(Professor i: professores){
			if(i.getMatricula().equals(matricula)){
				throw new ProfessorJaExisteException("Já existe professor com essa matricula: "+matricula);
			}
		}
		this.professores.add(new Professor(nome, matricula));
	}
	public void removeProfessor(String matricula)
			throws ProfessorInexistenteException {
		boolean inexistente = false;
		for(Professor i: professores){
			if(i.getMatricula().equals(matricula)){
				this.professores.remove(i);
				inexistente = true;
				break;
			}
		}
		if(!inexistente){
			throw new ProfessorInexistenteException("Não existe professor com essa matricula: "+matricula);
		}
	}
	public Professor pesquisaProfessorPelaMatricula(String matricula)
			throws ProfessorInexistenteException {
		for(Professor i: professores){
			if(i.getMatricula().equals(matricula)){
				return i;
			}
		}
		throw new ProfessorInexistenteException("Não existe professor com essa matricula: "+matricula);
	}
	public List<Professor> obterListaDeProfessores() {
		return professores;
	}
}

