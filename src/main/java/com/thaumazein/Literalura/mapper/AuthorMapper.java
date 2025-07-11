package com.thaumazein.Literalura.mapper;

import com.thaumazein.Literalura.dto.AuthorDTO;
import com.thaumazein.Literalura.model.Author;

public class AuthorMapper {
    public static Author fromDto(AuthorDTO dto){
        return new Author(dto.name() == null ? "Desconhecido" : dto.name(), dto.birthYear(), dto.deathYear());
    }
}
