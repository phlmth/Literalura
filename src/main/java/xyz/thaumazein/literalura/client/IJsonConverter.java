package xyz.thaumazein.literalura.client;

public interface IJsonConverter {
    <T> T convert(String json, Class<T> cls);
}
