package hkeller.escolacaesguia.common.enums;

public enum GrauInstrucaoEnum {
  nao_alfabetizado,
  ensino_fundamental_incompleto,
  ensino_fundamental_completo,
  ensino_medio_incompleto,
  ensino_medio_completo,
  graduacao_incompleta,
  graducao_completa,
  pos_graduacao,
  mestrado_ou_doutorado_incompleto,
  mestrado_ou_douturado_completo;

  @Override
  public String toString() {
    switch (this) {
      case nao_alfabetizado:
        return "Não alfabetizado";
      case ensino_fundamental_incompleto:
        return "Ensino fundamental incompleto";
      case ensino_fundamental_completo:
        return "Ensino fundamental completo";
      case ensino_medio_incompleto:
        return "Ensino médio incompleto";
      case ensino_medio_completo:
        return "Ensino médio completo";
      case graduacao_incompleta:
        return "Graduação incompleta";
      case graducao_completa:
        return "Graduação completa";
      case pos_graduacao:
        return "Pós graduação";
      case mestrado_ou_doutorado_incompleto:
        return "Mestrado ou doutorado incompleto";
      case mestrado_ou_douturado_completo:
        return "Mestrado ou doutorado completo";
    }
    return null;
  }
}
