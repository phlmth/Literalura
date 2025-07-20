package xyz.thaumazein.literalura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xyz.thaumazein.literalura.dto.AuthorDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author(AuthorDTO dto) {
        name = dto.name();
        birthYear = dto.birthYear();
        deathYear = dto.deathYear();
    }

    @Override
    public String toString() {
        List<String> bookList = getBooks().stream().map(Book::getBookTitle).toList();
        return """
                %nAutor: %s
                Ano de Nascimento: %d
                Ano de Falescimento: %d
                Livros: %s""".formatted(name, birthYear, deathYear, bookList);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}