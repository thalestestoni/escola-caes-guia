package hkeller.escolacaesguia.common.enums;

public enum EstadoCivilEnum {
  solteiro,
  uniao_estavel,
  casado,
  divorciado,
  viuvo;

  @Override
  public String toString() {
    switch (this) {
      case solteiro:
        return "Solteiro";
      case uniao_estavel:
        return "União estável";
      case casado:
        return "Casado";
      case divorciado:
        return "Divorciado";
      case viuvo:
        return "Viuvo";
    }
    return null;
  }
}
