package xyz.thaumazein.literalura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xyz.thaumazein.literalura.dto.BookDTO;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String bookTitle;

    @Column(name = "language", length = 10)
    private String language;

    @Column(name = "download_count")
    private Integer downloadCount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(BookDTO dto){
        bookTitle = dto.title();
        language = dto.languages().get(0);
        downloadCount = dto.downloadCount();
        author = new Author(dto.authors().get(0));

    }


    @Override
    public String toString() {
        return """
                %nLivro: %s
                Autor: %s
                Idioma: %s
                Total de Downloads: %d""".formatted(bookTitle, author.getName(), language, downloadCount);
    }
}