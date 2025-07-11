package com.thaumazein.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookSearchResponseDTO(@JsonAlias("results") List<BookDTO> bookList) {
}
