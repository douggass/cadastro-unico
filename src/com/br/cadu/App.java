package com.br.cadu;

import com.br.cadu.service.Menu;
import com.br.cadu.service.MenuUsuarioService;

public class App {
	
	public static void main(String[] args){
		
		Menu menu = new MenuUsuarioService();
		menu.iniciar();
	}

}
