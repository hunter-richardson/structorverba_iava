package officia.src.main.java.com.structorverba.officia.enumerationes;

import officia.src.main.java.com.structorverba.officia.miscella.Utilitas;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Actus;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec d\u0113signat utrum verbum est certum necne.
 * @see Actus
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Specialitas {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br>
   * Numquam scr\u012Bnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur.
   */
  NULLUM(StringUtils.EMPTY),

  /**
   * Valor hic verbum certum d\u0113signat.
   */
  COMMUNE("comm\u016Bne"),

  /**
   * Valor hic verbum incertum d\u0113signat.
   */
  PROPRIUM("proprium");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   */
  public static final @NotNull String pittacium = Utilitas.minisculasScribo(Specialitas.class.getSimpleName().replace('a', '\u0101'));

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NotNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Specialitas(@NotNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Specialitas} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #NULLUM} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scr\u012Bpti\u014D val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Specialitas} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NotNull public static Specialitas definiam(@NotNull final String scriptio) {
    return Stream.of(values())
                 .filter(specialitas -> specialitas.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUM);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Specialitas} quadrat; {@link #NULLUM} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Specialitas ut(@NotNull final Enum <@NotNull ?> illud) {
    final Specialitas hoc = (Specialitas) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUM;
  }
}
