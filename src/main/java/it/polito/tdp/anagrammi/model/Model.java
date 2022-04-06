package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Model {

	List<String> anagrammi= new LinkedList<String>();
	DizionarioDAO diz= new DizionarioDAO(); 
	
	public void anagramma (String s) {
		anagrammi.clear();
		anagramma_ricorsiva("",0,s);
	
		
	}

	private void anagramma_ricorsiva(String parziale, int l, String rimanenti) {
		
		//CASO TERMINALE
		if(rimanenti.length()==0) {
			anagrammi.add(parziale);
			System.out.println(parziale); 
			return;
		}
		
		else {
			for (int pos=0; pos<rimanenti.length(); pos++) {
					String nuova_parziale= parziale+rimanenti.charAt(pos);
					String nuova_rimanenti= rimanenti.substring(0,pos)+rimanenti.substring(pos+1);
					anagramma_ricorsiva(nuova_parziale, l+1, nuova_rimanenti);  
			}
		}
	}
	
	public List <String> paroleGiuste(String s) {
		this.anagramma(s); //richiami anagramma, popola la lista che richiami al metodo
		return diz.getParoleGiuste(anagrammi);
	}
	
	
	public List <String> paroleSbagliate(String s) {
		this.anagramma(s); //richiami anagramma, popola la lista che richiami al metodo
		return diz.getResultSbagliate();
	}
	
}
