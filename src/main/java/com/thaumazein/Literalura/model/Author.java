package com.thaumazein.Literalura.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class Author {
        private Long id;
        private String name;
        private int birthYear;
        private int deathYear;

        public Author() {
        }

        public Author(String name, int birthYear, int deathYear) {
                this.name = name;
                this.birthYear = birthYear;
                this.deathYear = deathYear;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getBirthYear() {
                return birthYear;
        }

        public void setBirthYear(int birthYear) {
                this.birthYear = birthYear;
        }

        public int getDeathYear() {
                return deathYear;
        }

        public void setDeathYear(int deathYear) {
                this.deathYear = deathYear;
        }

        @Override
        public String toString() {
            return """
                    Autor: %s
                    Nascimento: %d,
                    Falescimento: %d""".formatted(name, birthYear, deathYear);

        }
}
