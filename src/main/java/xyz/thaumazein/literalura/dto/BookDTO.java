package xyz.thaumazein.literalura.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(String title,
                      @JsonAlias("authors") List<AuthorDTO> authors,
                      List<String> languages,
                      @JsonAlias("download_count") Integer downloadCount) {
}
