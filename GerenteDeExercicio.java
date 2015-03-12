package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class GerenteDeExercicio {
	private List <Exercicio> exercicios;
	private List<RespostaDoExercicio> respostaDoExercicio;	
	public GerenteDeExercicio(){
		this.exercicios = new LinkedList<Exercicio>();
		this.respostaDoExercicio = new ArrayList<RespostaDoExercicio>();
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
		throw new ExercicioInexistenteException("exercicio não existe "+nomeExercicio);
	}
	public List<Integer> corrigirExercicio(String nomeExercicio) 
			throws ExercicioInexistenteException{
		List<Integer> quantAcertos=new ArrayList<Integer>();
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		int quantVouF = 0;
		int quantMult = 0;
	    for(RespostaDoExercicio r: this.respostaDoExercicio){
   
    	    for(int i=0; i < e.getQuestoes().size(); i++){
    	    	if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_DISSERTATIVA)){
    	    		//txt ++;
    	    	}else if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
    	    			quantVouF ++;
    	    			
    	    		}else{
    	    			//txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
    	    		}
    	    	}else{
    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
    	    			quantMult ++;
    	    		}else{
    	    		//	txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
    	    		}
    	    	}			    
		    }
    	    
	        
	    }
	    quantAcertos.add(quantVouF);//indece 0
	    quantAcertos.add(quantMult);//indece I
	    return quantAcertos;
	}
	public String enviarFeedbackParaAlunos(String nomeExercicio) 
			throws ExercicioInexistenteException {
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		String txt = "\n";
	    for(RespostaDoExercicio r: this.respostaDoExercicio){
	        //txt += "Resposta do(a) aluno(a): "+r.getAluno().toString()+"\n";
    	    for(int i=0; i < e.getQuestoes().size(); i++){
    	    	
    	    	if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_DISSERTATIVA)){
    	    		txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta para essa questão Dissertativa foi:  "+r.getResposta().get(i).getResposta()+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
    	    	}else if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta CORRETA";
    	    		}else{
    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
    	    		}
    	    	}else{
    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta CORRETA";
    	    		}else{
    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
    	    		}
    	    	}			    
		    }
	        
	    }
	    return txt;
	}
	public void enviarFeedbackParaProfessor() {
		 
		
	}
	public List<RespostaDoExercicio> getRespostaDoExercicio(){
		return this.respostaDoExercicio;
	}
	public void cadastrarRespostaDoExercicio(RespostaDoExercicio r){
		this.respostaDoExercicio.add(r);
	}
}