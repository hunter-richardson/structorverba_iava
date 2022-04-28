package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.miscella.Utilitas;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Adiectivum;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec potentiam adiect\u012Bv\u012B omnis d\u0113signat.
 * @see Adiectivum
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Gradus {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br> S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc n\u014Dn graditur.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Valor hic potentiam n\u014Drm\u0101le d\u0113signat.
   */
  POSITIVUS("posit\u012Bvus"),

  /**
   * Valor hic potentiam compar\u0101t\u012Bvum d\u0113signat.
   */
  COMPARATIVUS("compar\u0101t\u012Bvus"),

  /**
   * Valor hic potentiam superl\u0101t\u012Bvum d\u0113signat.
   */
  SUPERLATIVUS("superl\u0101t\u012Bvus");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   */
  public static final @NotNull String pittacium = Utilitas.minisculasScribo(Gradus.class.getSimpleName());

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NotNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Gradus(@NotNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Gradus} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #NULLUS} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scr\u012Bpti\u014D val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101tio {@link Gradus} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NotNull public static Gradus definiam(@NotNull final String scriptio) {
    return Stream.of(values())
                 .filter(gradus -> gradus.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Gradus} quadrat; {@link #NULLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Gradus ut(@NotNull final Enum <@NotNull ?> illud) {
    final Gradus hoc = (Gradus) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUS;
  }
}
