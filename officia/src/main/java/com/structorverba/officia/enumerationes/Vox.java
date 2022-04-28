package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.miscella.Utilitas;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Actus;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec v\u014Dcem verb\u012B omnis d\u0113signat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Vox {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br> S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc est invoc\u0101bile.
   */
  NULLA(StringUtils.EMPTY),

  /**
   * Valor hic v\u014Dcem \u0101ct\u012Bvam d\u0113signat.
   */
  ACTIVA("\u0101ct\u012Bva"),

  /**
   * Valor hic v\u014Dcem pass\u012Bvam d\u0113signat.
   */
  PASSIVA("pass\u012Bva");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   */
  public static final @NotNull String pittacium = Utilitas.minimasScribo(Vox.class.getSimpleName().replace('o', '\u014D'));

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  final @NotNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Vox(@NotNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Vox} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #NULLA} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scr\u012Bpti\u014D val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Vox} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NotNull public static Vox definiam(@NotNull final String scriptio) {
    return Stream.of(values())
                 .filter(vox -> vox.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLA);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Vox} quadrat; {@link #NULLA} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Vox ut(@NotNull final Enum <@NotNull ?> illud) {
    final Vox hoc = (Vox) illud;
    return hoc.equals(illud) ? hoc
                             : NULLA;
  }
}
