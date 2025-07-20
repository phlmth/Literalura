package xyz.thaumazein.literalura.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record resultsDTO(List<BookDTO> results) {
}
