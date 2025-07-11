package com.thaumazein.Literalura.mapper;


import com.thaumazein.Literalura.dto.BookDTO;
import com.thaumazein.Literalura.model.Book;

public class BookMapper {
    public static Book fromDto(BookDTO dto) {
        return new Book(dto.bookTitle(), AuthorMapper.fromDto(dto.authors().get(0)), dto.languages().get(0), dto.downloadCount());
    }
}
