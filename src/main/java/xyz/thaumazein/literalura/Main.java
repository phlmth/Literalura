package xyz.thaumazein.literalura;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import xyz.thaumazein.literalura.client.ApiResponse;
import xyz.thaumazein.literalura.client.JsonConverter;
import xyz.thaumazein.literalura.dto.resultsDTO;
import xyz.thaumazein.literalura.entity.Author;
import xyz.thaumazein.literalura.entity.Book;
import xyz.thaumazein.literalura.repository.AuthorRepository;
import xyz.thaumazein.literalura.repository.BookRepository;


import java.beans.Transient;
import java.util.Scanner;


@Service
public class Main {
    private final ApiResponse apiResponse = new ApiResponse();
    private final JsonConverter jsonConverter = new JsonConverter();
    private final Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void run() {
        var menu = """
                Literalura
                
                1 - buscar livro
                2 - listar livros registrado
                3 - listar autores registrados
                4 - listar autores vivos em um determinado ano
                5 - listar livros em um determinado idioma
                
                0 - Sair""";

        var option = -1;

        while (option != 0) {
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> searchBook();
                case 2 -> getAllBooks();
                case 3 -> getAllAuthors();
                case 4 -> getLivingAuthorsInYear();
                case 5 -> getBooksInLanguage();
                case 0 -> {
                    System.out.println("Encerrando...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
        }
        return;
    }

    private void searchBook() {
        System.out.println("Digite o nome do livro: ");
        var bookTitle = scanner.nextLine();
        var json = apiResponse.get(bookTitle);
        var result = jsonConverter.convert(json, resultsDTO.class);
        var bookDto = result.results().get(0);

        var book = new Book(bookDto);
        var author = new Author(bookDto.authors().get(0));
        author.addBook(book);
        bookRepository.save(book);

        System.out.println(book);

    }

    private void getAllBooks() {
        bookRepository.findAll().forEach(System.out::println);
    }

    private void getAllAuthors() {
        authorRepository.findAll().forEach(System.out::println);
    }

    private void getLivingAuthorsInYear() {
        System.out.println("Digite o ano que deseja buscar: ");
        var year = scanner.nextInt();
        authorRepository.findAuthorsAliveInYear(year).forEach(System.out::println);
    }

    private void getBooksInLanguage() {
        System.out.println("digite o idioma dos livros que deseja buscar: ");
        bookRepository.findAll().stream().map(Book::getLanguage).forEach(System.out::println);
        var language = scanner.nextLine();
        bookRepository.findByLanguage(language).forEach(System.out::println);
    }
}
