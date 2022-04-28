package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Nominalis;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec generem verb\u012B omnis d\u0113signat.
 * @see Nominalis
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Genus {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br> S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc n\u014Dn ingenerat.
   */
  NULLUM(StringUtils.EMPTY),

  /**
   * Valor hic generem neutrum d\u0113signat.
   */
  NEUTRUM("neutrum"),

  /**
   * Valor hic generem mascul\u012Bnum d\u0113signat.
   */
  MASCULINUM("mascul\u012Bnum"),

  /**
   * Valor hic generem f\u0113min\u012Bnum d\u0113signat.
   */
  FEMININUM("f\u0113min\u012Bnum");

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NotNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Genus(@NotNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Genus} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #NULLUM} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scr\u012Bpti\u014D val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Genus} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NotNull public static Genus definiam(@NotNull final String scriptio) {
    return Stream.of(values())
                 .filter(genus -> genus.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUM);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Genus} quadrat; {@link #NULLUM} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Genus ut(@NotNull final Enum <@NotNull ?> illud) {
    final Genus hoc = (Genus) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUM;
  }
}
