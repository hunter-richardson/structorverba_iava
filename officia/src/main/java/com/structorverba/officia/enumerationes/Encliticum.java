package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.interfacta.Inflectabile;
import org.apache.commons.lang3.StringUtils;

/**
 * Haec ēnumerātiō <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a>
 * subiūnctum reī omnī classis {@link Verbum.Multiplex} dēsignat.
 * @see Verbum.Multiplex
 * @see Inflectabile
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Encliticum {
  /**
   * Hic valor <a href="https://en.wiktionary.org/wiki/-ne#Latin">encliticum interrogāns</a> dēsignat.
   */
  INTERROGANS("ne"),

  /**
   * Hic valor <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum coniugāns</a> dēsignat.
   */
  CONIUGANS("que"),

  /**
   * Hic valor <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum ēligēns</a> dēsignat.
   */
  ELIGENS("ve"),

  /**
   * Hic valor encliticum nūllum dēsignat.
   */
  NOLENS(StringUtils.EMPTY);


  /**
   * Hic valor repraesentātiōnem scrīpta huius reī dēsignat.
   */
  public final String scriptio;

  Encliticum(@NonNull final String scrpt) {
    scriptio = scrpt;
  }
}
