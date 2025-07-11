package com.thaumazein.Literalura.service;

public interface IJsonToObj {
    <T> T convert(String json, Class<T> obj);
}
