package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class GerenteDeExercicio {
	private List < Exercicio > exercicios;
	private List<RespostaDoExercicio> respostaDoExercicio;	
	public GerenteDeExercicio(){
		this.exercicios = new LinkedList<Exercicio>();
		this.respostaDoExercicio = new ArrayList<RespostaDoExercicio>();
	}
	public List<RespostaDoExercicio> getRespostaDoExercicio(){
		return this.respostaDoExercicio;
	}
	public void cadastrarRespostaDoExercicio(RespostaDoExercicio r){
		this.respostaDoExercicio.add(r);
	}
	public void cadastrarExercicio(Exercicio e){
		this.exercicios.add(e);
	}
	public void removeExercicio(String nomeExercicio)throws ExercicioInexistenteException{
		boolean inexistente = false;
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				this.exercicios.remove(e);
				inexistente = true;
				break;
			}
		}
		if(!inexistente){
			throw new ExercicioInexistenteException("Exercicio inexistente "+nomeExercicio);
		}
	}
	public Questao pesquisaQuestaoDeExercicio(String nomeExercicio, int numQuestao)
			throws QuestaoInexistenteException, ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		for(Questao y: e.getQuestoes()){
			if(y.getNumQuestao() == numQuestao){
				return y;
			}
		}
		throw new QuestaoInexistenteException("Questao Inexistente "+numQuestao);
	}
	public Exercicio pesquisarExercicio(String nomeExercicio)
			throws ExercicioInexistenteException {
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				return e;
			}
		}
		throw new ExercicioInexistenteException("Exercicio Inexistente "+nomeExercicio);
	}
	public List<Exercicio> listarExercíciosCadastrados() {
		return exercicios;
	}
	public Exercicio sortearExercício() {
		//Collections.shuffle(exercicios);// altera a ordem aleatóriamente
		//return exercicios.get(0);// pega qualquer indice. pegamos o primeiro para conveniencia.
		Random rnd = new Random();
		int quantElemento = exercicios.size();
		int numSorteior = rnd.nextInt(quantElemento);//Gera um número aleatório (0 – n)
		return exercicios.get(numSorteior);
	}
	public String atualizarExercicio(String nomeExercicio, int numQuestao, String questao) 
			throws ExercicioInexistenteException{	
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				for(Questao q: e.getQuestoes()){
					if(q.getNumQuestao()==numQuestao){
						q.setQuestao(questao);
						return "Exercicio atualizado com sucesso!";
					}
				}
			}
		}
		throw new ExercicioInexistenteException("exercicio não existe");
	}
	public String corrigirExercicio(String nomeExercicio, String matriculaAluno) 
			throws ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		String pulaLinha = "\n";
	    for(RespostaDoExercicio r: this.respostaDoExercicio){
	        if(r.getAluno().getMatricula().equals(matriculaAluno)){
	        	pulaLinha += "Resposta do(a) aluno(a): "+r.getAluno().toString()+"\n";
	    	    for(int i=0; i < e.getQuestoes().size(); i++){
	    	    	if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_DISSERTATIVA)){
	    	    		pulaLinha += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta para essa questão Dissertativa foi:  "+r.getResposta().get(i).getResposta()+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
	    	    	}else if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
	    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
	    	    			pulaLinha += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta CORRETA";
	    	    		}else{
	    	    			pulaLinha += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
	    	    		}
	    	    	}else{
	    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
	    	    			pulaLinha += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta CORRETA";
	    	    		}else{
	    	    			pulaLinha += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
	    	    		}
	    	    	}			    
			    }
	        }
	    }
	    return pulaLinha;
	}
}