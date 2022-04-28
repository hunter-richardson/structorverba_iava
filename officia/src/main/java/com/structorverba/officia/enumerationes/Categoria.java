package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.verba.*;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.*;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * \u0112numer\u0101ti\u014D haec ext\u0113nsi\u014Dnem class\u012B {@link Verbum} d\u0113signat cui verbum omne respondet.
 * @see Verbum
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Categoria {
  /**
   * Valor hic classem {@link Nomen} respondet.
   */
  NOMEN("n\u014Dmina"),

  /**
   * Valor hic classem {@link Adiectivum} respondet.
   */
  ADIECTIVUM("adiect\u012Bva"),

  /**
   * Valor hic classem {@link Pronomen} respondet.
   */
  PRONOMEN("pr\u014Dn\u014Dmina"),

  /**
   * Valor hic classem {@link Actus} respondet.
   */
  ACTUS("\u0101ct\u012B"),

  /**
   * Valor hic classem {@link Adverbium} respondet.
   */
  ADVERBIUM("adverbia"),

  /**
   * Valor hic classem {@link VerbumSimplex.Coniunctivum} respondet.
   */
  CONIUNCTIVUM("coni\u016Bnct\u012Bva"),

  /**
   * Valor hic classem {@link VerbumSimplex.Interiectio} respondet.
   */
  INTERIECTIO("interiecti\u014Dn\u0113s"),

  /**
   * Valor hic classem {@link VerbumSimplex.Praepositio} respondet.
   */
  PRAEPOSITIO("praepositi\u014Dn\u0113s"),

  /**
   * Valor hic classem {@link VerbumSimplex.Numerus} respondet.
   */
  NUMERUS(StringUtils.EMPTY);

  /**
   * Valor hic n\u014Dmin\u0101tur scr\u012Bnium intr\u0101 qu\u014D sc\u0101pum verb\u012B omn\u012B c\u014Dnserv\u0101tum est.
   */
  public final @NotNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Categoria(@NotNull final String scrpt) {
    scriptio = scrpt;
  }
}
