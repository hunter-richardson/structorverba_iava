package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.verba.multiplicia.VerbumMultiplex;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * \u0112numer\u0101ti\u014D haec <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a>
 * subi\u016Bnctum re\u012B omn\u012B classis {@link VerbumMultiplex} d\u0113signat.
 * @see VerbumMultiplex
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Encliticum {
  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-ne#Latin">encliticum interrog\u0101ns</a> d\u0113signat.
   */
  INTERROGANS("ne"),

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum coniug\u0101ns</a> d\u0113signat.
   */
  CONIUGANS("que"),

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/-que#Latin">encliticum \u0113lig\u0113ns</a> d\u0113signat.
   */
  ELIGENS("ve"),

  /**
   * Valor hic encliticum n\u016Bllum d\u0113signat.
   */
  NOLENS(StringUtils.EMPTY);


  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Encliticum(@NotNull final String scrpt) {
    scriptio = scrpt;
  }
}
