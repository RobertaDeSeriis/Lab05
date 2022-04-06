package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class DizionarioDAO {

	List <String> resultSbagliate = new LinkedList <String>(); 
	
	public List <String> getParoleGiuste (List<String> parole){
		String sql= "SELECT nome " //ricorda spazio dopo asterisco
				+"FROM dizionario.parola "
				+"WHERE nome = ?"; //? inserisco il periodo che mi dice l'utente 

		List <String> result = new LinkedList <String>(); 
		resultSbagliate= new LinkedList<String>();
		//inzializza ogni volta che poi clicchi il bottone
		//serve per pulire, al posto di clear dentro;
		try {
			
			//stbilisci la connessione e fai il preparedStatement
			Connection conn=ConnectDB.getConnection(); 
			PreparedStatement st= conn.prepareStatement(sql); 
			
			//parte dalla posizione 1, e ci metto il parametro che inserisce l'utente
			//che si riferisce al periodo didattico
			
			for (String par: parole) {
				
				st.setString(1, par); 
				ResultSet rs=st.executeQuery(); 
				if (rs.next()) { 
					//vai avanti di una riga
					//se la query torna, --> è presente nel database --> è corrette
				
					
					
					result.add(par);
				}
				else
					resultSbagliate.add(par);
			}
			conn.close(); 
			return result; 
			
			
		} catch (SQLException e) {
			System.err.println("Errore nel DAO"); //err stampa in rosso
			e.printStackTrace();
			return null; 
		}
		
		
		
	}

	public List<String> getResultSbagliate() {
		return resultSbagliate;
	}
	
}
