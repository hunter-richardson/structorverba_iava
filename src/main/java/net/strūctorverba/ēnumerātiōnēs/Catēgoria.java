package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.*;
import net.strūctorverba.verba.multiplicia.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Ēnumerātiō haec extēnsiōnem classī {@link Verbum} dēsignat cui verbum omne respondet.
 * @see Verbum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public enum Catēgoria {
  /**
   * Valor hic classem {@link Nōmen} respondet.
   */
  NŌMEN("nōmina"),

  /**
   * Valor hic classem {@link Adiectīvum} respondet.
   */
  ADIECTĪVUM("adiectīva"),

  /**
   * Valor hic classem {@link Prōnōmen} respondet.
   */
  PRŌNŌMEN("prōnōmina"),

  /**
   * Valor hic classem {@link Āctum} respondet.
   */
  ĀCTUM("ācta"),

  /**
   * Valor hic classem {@link Adverbium} respondet.
   */
  ADVERBIUM("adverbia"),

  /**
   * Valor hic classem {@link VerbumSimplex.Coniūnctīvum} respondet.
   */
  CONIŪNCTĪVUM("coniūnctīva"),

  /**
   * Valor hic classem {@link VerbumSimplex.Praepositiō} respondet.
   */
  PRAEPOSITIŌ("praepositiōnēs"),

  /**
   * Valor hic classem {@link VerbumSimplex.Numerus} respondet.
   */
  NUMERUM(StringUtils.EMPTY);

  /**
   * Valor hic nōminātur scrīnium intrā quō scāpum verbī omnī cōnservātum est.
   */
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Catēgoria(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }
}
