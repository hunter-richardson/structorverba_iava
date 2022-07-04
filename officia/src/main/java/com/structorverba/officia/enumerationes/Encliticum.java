package com.structorverba.officia.enumerationes;

import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;

import org.apache.commons.lang3.StringUtils;
import androidx.annotation.NonNull;

/**
 * Ēnumerātiō haec <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a>
 * subiūnctum reī omnī classis {@link VerbumMultiplex} dēsignat.
 * @see VerbumMultiplex
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Encliticum {
  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-ne#Latin">encliticum interrogāns</a> dēsignat.
   */
  INTERROGANS("ne"),

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum coniugāns</a> dēsignat.
   */
  CONIUGANS("que"),

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum ēligēns</a> dēsignat.
   */
  ELIGENS("ve"),

  /**
   * Valor hic encliticum nūllum dēsignat.
   */
  NOLENS(StringUtils.EMPTY);


  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Encliticum(@NonNull final String scrpt) {
    scriptio = scrpt;
  }
}
