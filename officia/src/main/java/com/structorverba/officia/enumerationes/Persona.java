package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Actus;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec pers\u014Dnam verb\u012B omnis d\u0113signat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Persona {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br> S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc pers\u014Dnam n\u014Dn pertinet.
   */
  NULLA(StringUtils.EMPTY),

  /**
   * Valor hic pers\u014Dnam pr\u012Bmam d\u0113signat.
   */
  PRIMA("pr\u012Bma"),

  /**
   * Valor hic pers\u014Dnam secundam d\u0113signat.
   */
  SECUNDA("secunda"),

  /**
   * Valor hic pers\u014Dnam tertiam d\u0113signat.
   */
  TERTIA("tertia");

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NotNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Persona(@NotNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Persona} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #NULLA} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scr\u012Bpti\u014D val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Persona} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NotNull public static Persona definiam(@NotNull final String scriptio) {
    return Stream.of(values())
                 .filter(persona -> persona.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLA);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Persona} quadrat; {@link #NULLA} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Persona ut(@NotNull final Enum <@NotNull ?> illud) {
    final Persona hoc = (Persona) illud;
    return hoc.equals(illud) ? hoc
                             : NULLA;
  }
}
