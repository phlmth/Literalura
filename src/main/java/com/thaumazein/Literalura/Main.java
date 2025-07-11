package com.thaumazein.Literalura;

import com.thaumazein.Literalura.dto.BookSearchResponseDTO;
import com.thaumazein.Literalura.mapper.BookMapper;
import com.thaumazein.Literalura.model.Book;
import com.thaumazein.Literalura.service.GetJson;
import com.thaumazein.Literalura.service.JsonToObj;


import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    JsonToObj converter = new JsonToObj();

    public void init() {
        var menu = """
                LITERALURA
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros em um determinado idioma
                0 - Sair""";

        var option = -1;
        while (option != 0){
            System.out.println(menu);
            option = scanner.nextInt();
            switch (option) {
                case 1 -> searchBookByTitle();
                case 2 -> getAllRegistredBooks();
                case 3 -> getAllRegistredAuthors();
                case 4 -> getAllAuthorsAliveInYear();
                case 5 -> getAllBookInLanguage();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção Inválida");
            }
        }
    }
    private void getAllBookInLanguage() {

    }

    private void getAllAuthorsAliveInYear() {

    }

    private void getAllRegistredAuthors() {

    }

    private void getAllRegistredBooks() {

    }

    public void searchBookByTitle() {
        System.out.println("Qual livro deseja buscar:\n");
        var bookRequested = scanner.nextLine();
        String json = GetJson.get("https://gutendex.com/books/?search=" + bookRequested.replace(" ", "+"));
        BookSearchResponseDTO bookSearch = converter.convert(json, BookSearchResponseDTO.class);
        Book book = BookMapper.fromDto(bookSearch.bookList().get(0));
        System.out.println(book);
    }
}
