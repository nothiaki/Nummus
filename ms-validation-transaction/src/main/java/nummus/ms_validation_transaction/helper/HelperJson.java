package nummus.ms_validation_transaction.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HelperJson<T> {
  private ObjectMapper objectMapper;
  private final Class<T> typeClass;

  public HelperJson(Class<T> typeClass) {
    this.typeClass = typeClass;
  }

  public String toJson(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (Exception ex) {
      return "";
    }
  }

  public T JsonTo(String json) {
    try {
      return objectMapper.readValue(json, typeClass);
    } catch (Exception ex) {
      return null;
    }
  }
}
