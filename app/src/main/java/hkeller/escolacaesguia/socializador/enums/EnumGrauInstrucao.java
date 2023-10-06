package hkeller.escolacaesguia.socializador.enums;

public enum EnumGrauInstrucao {
  nao_alfabetizado(1),
  ensino_fundamental_incompleto(2),
  ensino_fundamental_completo(3),
  ensino_medio_incompleto(4),
  ensino_medio_completo(5),
  graduacao_incompleta(6),
  graduacao_completa(7),
  pos_graduacao(8),
  mestrado_ou_doutorado_incompleto(9),
  mestrado_ou_doutorado_completo(10);

  private Integer grauInstrucao;

  EnumGrauInstrucao(Integer grauInstrucao) {
    this.grauInstrucao = grauInstrucao;
  }

  public Integer getGrauInstrucao() {
    return grauInstrucao;
  }
}
