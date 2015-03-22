package br.com.ufpb.projetopoo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class GerenteDeAluno implements Serializable{
	private Map<String, Aluno> alunos;
	public  GerenteDeAluno(){
		this.alunos = new HashMap<String, Aluno>();
	}
	public void cadastraAluno(String nome, String matricula)
			throws AlunoJaExisteException {
		if(this.alunos.containsKey(matricula)){
			throw new AlunoJaExisteException("Já Existe aluno com essa matricula: "+matricula);
		}else{
			this.alunos.put(matricula,new Aluno(nome,matricula));
		}
	}
	public Aluno pesquisaAlunoPelaMatricula(String matricula)
			throws AlunoInexistenteException {
		if(!this.alunos.containsKey(matricula)){
			throw new AlunoInexistenteException("Não existe aluno com essa matricula: "+matricula);
		}else{
			return this.alunos.get(matricula);
		}
	}
	public void removeAluno(String matricula) throws AlunoInexistenteException {
		if(!this.alunos.containsKey(matricula)){
			throw new AlunoInexistenteException("Não existe aluno com essa matricula: "+matricula);
		}else{
			this.alunos.remove(matricula);
		}
	}
	public Collection<Aluno> obterListaDeAlunos() {
		return this.alunos.values();
	}
}
