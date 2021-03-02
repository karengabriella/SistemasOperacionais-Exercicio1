package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {

	public RedesController() {
		super();
	}
	
//Retornar nome do SO-----------------------------------
	
	public String os() {
	    String so = System.getProperty("os.name");
	    return so;
	  }
	
	
//Menu de opções Windows----------------------------------
	
	public void menuWindows(int param) {
	  if(param == 1) {
	   //Busca por Ipv4:
	   String process = "ipconfig"; 
	   ip(process); 
	  }
	  else if(param == 2) {
	  //Média-ping 
	   String process = "PING -4 -n 10 www.google.com.br";
	   ping(process);
	  }
	  else {
		JOptionPane.showInputDialog("Opção Invalida!");  
	  }
		
	}
	
//Menu de opções Linux----------------------------------
	
	public void menuLinux(int param) {
	  if(param == 1) {
	   //Busca por Ipv4:
		 String process = "ifconfig"; 
	     ipLinux(process); 
	   }
	   else if(param == 2) {
		//Média-ping 
		   String process = "ping -4 -c 10 www.google.com.br";
		   pingLinux(process);
		  }
		  else {
			JOptionPane.showInputDialog("Opção Invalida!");  
		  }
			
		}
	
	
	
	
//Busca Ipv4 Windows-------------------------------------------------------------------
	public void ip(String processo) {
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String nome = " ";
	        String linha = buffer.readLine();

			 while(linha != null) {	
				
			 if(linha.contains("Adaptador")) {
			    nome = "\n " + linha;
			 }
			 if(linha.contains("IPv4")) {
				   System.out.println(nome);
				   System.out.println(linha.toString());
			}
			 linha = buffer.readLine();
			}	 		 
			
			buffer.close();
			leitor.close();
			fluxo.close();
		
		 } catch (Exception e) {
			e.printStackTrace(); 

	     }	
		
	 }
	
//Ping Windows--------------------------------------------------------	
	 public void ping(String processo) {
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String media[] = new String [3];
	        String linha = buffer.readLine();
     
			while(linha != null) {	
				 
			 if(linha.contains("ms")) {
				media  = linha.split(","); 
			 }
			 
			 linha = buffer.readLine();
			 
			}
			System.out.println("Pings: " + media[2]);
	  
			buffer.close();
			leitor.close();
			fluxo.close();
			
		 } catch (IOException e) {
			e.printStackTrace(); 

	     }	
	 }
		
//Busca IPV4 Linux------------------------------------------------
	 
	 public void ipLinux(String processo) {
	   try {
		 Process p = Runtime.getRuntime().exec(processo);
		 InputStream fluxo = p.getInputStream();
	  	 InputStreamReader leitor = new InputStreamReader(fluxo);
		 BufferedReader buffer = new BufferedReader(leitor);
		 String inet[] = new String[3];
		 String nome = " ";
		 String linha = buffer.readLine();
		 
		 while(linha != null) {	
			 
			if(linha.contains("flags")) {
			  nome = linha;	
			}
		    if(linha.contains("inet")) {
			   inet = linha.split(" ");
			   System.out.println("nome: " + nome + " : \n" + inet[0]);
			 }
		  
			   linha = buffer.readLine();
			}	 		 
				
				buffer.close();
				leitor.close();
				fluxo.close();
			
			 } catch (Exception e) {
				e.printStackTrace(); 

		     }	
			
		 }

//Média - Ping Linux----------------------------------------------
	 public void pingLinux(String processo) {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String aux[] = new String [2];
		        String linha = buffer.readLine();
	     
				while(linha != null) {	
					 
				 if(linha.contains("rtt")) {
					aux  = linha.split("=");
				 }
				 
				 linha = buffer.readLine();
				 
				}
				String media[] = aux[1].split("/");
				
				System.out.println("Pings: " + media[3]);
		  
				buffer.close();
				leitor.close();
				fluxo.close();
				
			 } catch (IOException e) {
				e.printStackTrace(); 

		     }	
		 }
	 
	 
	 
     

}