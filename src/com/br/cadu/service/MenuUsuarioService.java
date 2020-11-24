package com.br.cadu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.br.cadu.dto.Usuario;

public class MenuUsuarioService implements Menu{

	List<Usuario> listaDeUsuario = new ArrayList<>();
	boolean executandoMenu = true;
	Scanner teclado = new Scanner(System.in);
 
	public void iniciar() {
		while (executandoMenu) {
			System.out.println("\n escolha uma opção" + "\n" + "1)Cadastrar usuário \n" + "2) Listar usuários \n"
					+ "3)Deletar usuário \n" + "4) Sair \n");
			String opcaoEscolhida = teclado.nextLine();

			switch (opcaoEscolhida) {
			case "1":
				cadastrarUsuario();
				break;

			case "2":
				System.out.println(listaDeUsuario);
				break;

			case "3":
				deletarUsuario();

				break;
			case "4":
				executandoMenu = false;
				break;

			default:
				System.out.println("Essa opção não existe");
				break;
			}
		}
		teclado.close();
		System.out.println("Adeus");
	}

	public void cadastrarUsuario() {
		System.out.println("Digite o nome do usuário: ");
		String nome = teclado.nextLine();

		System.out.println("Digite a senha: ");
		String senha = teclado.nextLine();

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		listaDeUsuario.add(usuario);
		System.out.println("usuario cadastrado com sucesso");
	}

	public void deletarUsuario() {
		System.out.println("qual nome você quer deletar?");
		String nomePraDeletar = teclado.nextLine();

		Optional<Usuario> usuarioEncontrado = Optional.empty();
		
		for (Usuario usuarioDaLista : listaDeUsuario) {
			if (usuarioDaLista.getNome().equals(nomePraDeletar)) {
				usuarioEncontrado = Optional.of(usuarioDaLista);
			}
		}
		if (usuarioEncontrado.isPresent()) {
			listaDeUsuario.remove(usuarioEncontrado.get());
			System.out.println("Usuario deletado com sucesso!");
			
		} else {
			System.err.println("Usuario não encontrado");
		}
	}
}
