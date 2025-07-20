package xyz.thaumazein.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.thaumazein.literalura.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(String language);
}