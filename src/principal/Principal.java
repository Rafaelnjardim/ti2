package principal;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Inserir Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    List<Produto> produtos = produtoDAO.listarProdutos();
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    Produto novoProduto = new Produto(nome, preco, quantidade);
                    produtoDAO.inserirProduto(novoProduto);
                    break;

                case 3:
                    System.out.print("ID do produto a excluir: ");
                    int idExcluir = scanner.nextInt();
                    produtoDAO.excluirProduto(idExcluir);
                    break;

                case 4:
                    System.out.print("ID do produto a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.next();
                    System.out.print("Novo Preço: ");
                    double novoPreco = scanner.nextDouble();
                    System.out.print("Nova Quantidade: ");
                    int novaQuantidade = scanner.nextInt();

                    Produto produtoAtualizar = new Produto(novoNome, novoPreco, novaQuantidade);
                    produtoAtualizar.setId(idAtualizar);
                    produtoDAO.atualizarProduto(produtoAtualizar);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}