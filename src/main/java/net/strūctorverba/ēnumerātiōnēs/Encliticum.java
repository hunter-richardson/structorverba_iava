package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Ēnumerātiō haec <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subiūnctum reī omnī classis {@link VerbumMultiplex} dēsignat.
 * @see VerbumMultiplex
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Encliticum {
  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-ne#Latin">encliticum interrogāns</a> dēsignat.
   */
  INTERROGĀNS("ne"),

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum coniugāns</a> dēsignat.
   */
  CONIUGĀNS("que"),

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum ēligēns</a> dēsignat.
   */
  ĒLIGĒNS("ve"),

  /**
   * Valor hic encliticum nūllum dēsignat.
   */
  NŌLĒNS(StringUtils.EMPTY);


  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Encliticum(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }
}
