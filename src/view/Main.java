package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
	RedesController redesController = new RedesController(); 
	
	//Chamada Identificador de Sistema Operacional
	String identificarso = redesController.os();
	
	if(identificarso.contains("Windows")) {
	  //Op��es Windows 
	  int opc = 0;
	  while(opc != 3) {
		opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Adaptadores ethernet - ipv4 \n 2 - Tempo m�dio - Ping \n 3 - Sair"));
		if(opc == 3) {
	     break;
		}
		redesController.menuWindows(opc);
	  }  
	 }
	//Op��es Linux
	else if (identificarso.contains("Linux")) {
      //Op��es Linux
      int opc = 0;
	  while(opc != 3) {
		opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Adaptadores ethernet - ipv4 \n 2 - Tempo m�dio - Ping \n 3 - Sair"));
		if(opc == 3) {
		 break;
		}
		redesController.menuLinux(opc);
	  }  
	}		
		
 }
}
