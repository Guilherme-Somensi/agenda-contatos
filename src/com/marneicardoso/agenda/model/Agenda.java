package com.marneicardoso.agenda.model;
import com.marneicardoso.agenda.view.Tela;

public class Agenda {

	// M�todos
	public void iniciarAgenda() {
		// Cria o objeto da classe Tela
		Tela tela = new Tela();

		// Monta o Menu
		String menu = ":: Agenda de Contatos ::\n\n" +
				"1. Cadastrar\n" +
				"2. Buscar\n" +
				"3. Editar\n" +
				"4. Excluir\n\n";

		// Mant�m o Menu ativo
		boolean isAtivo = true;

		// Loop principal do Sistema
		while (isAtivo) {
			String opcao = tela.informar(menu, "Informe uma op��o do Menu", -1);

			switch (opcao) {
			case "1":
				cadastrarContato(tela);
				break;

			case "2":
				buscarContato(tela);
				break;

			case "3":
				editarContato(tela);
				break;

			case "4":
				excluirContato(tela);
				break;

			default:
				int sair = tela.confirmar("Deseja sair?", "Encerrar", 3);

				if (sair == 0) {
					isAtivo = false;
					tela.mostrar("Encerrando o sistema...", "Encerrando", 1);
				}
			} // fecha o switch
		} // fecha o while
	} // fecha o m�todo iniciarAgenda()

	private void cadastrarContato(Tela tela) {
		
		// Usu�rio informa os dados
		String nome = tela.informar("Informe o Nome", "Nome", 1);
		String email = tela.informar("Informe o E-mail", "E-mail", 1);
		String fone = tela.informar("Informe o Telefone", "Fone", 1);
		
		// Cria o objeto da classe Contato
		Contato contato = new Contato(nome, email, fone);
		
		Lista.getInstance().add(contato);
	} 
	
	private void buscarContato(Tela tela) {
		// Guarda o n�mero de registros na Lista
		int numeroRegistros = Lista.getInstance().size();
				
		if (numeroRegistros > 0) {
			String listaContatos = "";
			
			for (int i = 0; i < numeroRegistros; i++) {
				listaContatos +=
					"ID: " + (i +1) +
					"\nNome: " + Lista.getInstance().get(i).getNome() +
					"\nE-mail: " + Lista.getInstance().get(i).getEmail() +
					"\nFone: " + Lista.getInstance().get(i).getFone() +
					"\n\n";
			}
			
			// Mostra o resultado da busca
			tela.mostrar(listaContatos, "Contatos", 1);
			
		} else {
			tela.mostrar("Nehum contato registrado", "Contatos", 1);
		}
	}

	private void editarContato(Tela tela) {
		
		buscarContato(tela);
		
        int id;

        id = (Integer.parseInt(tela.informar("Informe o Id do usuario que deseja editar", "Editar Contato", 1)) - 1);

        String _nome = tela.informar("informe um novo nome", "Editar", 1);

        String _email = tela.informar("informe um novo email", "Editar", 1);

        String _fone = tela.informar("informe um novo telefone", "Editar", 1);
        
        Lista.getInstance().get(id).setNome(_nome);
        Lista.getInstance().get(id).setFone(_email);
        Lista.getInstance().get(id).setEmail(_fone);;
        
	}
	
	private void excluirContato(Tela tela) {

        buscarContato(tela);
    
        int id;

        id = (Integer.parseInt(tela.informar("Informe o Id do usuario que deseja remover", "Remover Contato", 1)) - 1);
       
        Lista.getInstance().remove(id);
    }
	
	
}








