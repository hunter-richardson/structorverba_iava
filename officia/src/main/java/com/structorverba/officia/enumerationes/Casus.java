package com.structorverba.officia.enumerationes;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.multiplicia.Nominalis;

import org.apache.commons.lang3.StringUtils;
import androidx.annotation.NonNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec c\u0101sum verb\u012B omnis d\u0113signat.
 * @see Nominalis
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
public enum Casus {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br> S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc d\u0113rigitur.
   */
  DERECTUS(StringUtils.EMPTY),

  /**
   * Valor hic c\u0101sum n\u014Dmin\u0101t\u012Bvum d\u0113signat.
   */
  NOMINATIVUS("nomin\u0101t\u012Bvus"),

  /**
   * Valor hic c\u0101sum genit\u012Bvum d\u0113signat.
   */
  GENITIVUS("genit\u012Bvus"),

  /**
   * Valor hic c\u0101sum dat\u012Bvum d\u0113signat.
   */
  DATIVUS("dat\u012Bvus"),

  /**
   * Valor hic c\u0101sum acc\u016Bs\u0101t\u012Bvum d\u0113signat.
   */
  ACCUSATIVUS("acc\u016Bs\u0101t\u012Bvus"),

  /**
   * Valor hic c\u0101sum abl\u0101t\u012Bvum d\u0113signat.
   */
  ABLATIVUS("abl\u0101t\u012Bvus"),

  /**
   * Valor hic c\u0101sum voc\u0101t\u012Bvum d\u0113signat.
   */
  VOCATIVUS("voc\u0101t\u012Bvus"),

  /**
   * Valor hic c\u0101sum loc\u0101t\u012Bvum d\u0113signat.
   */
  LOCATIVUS("loc\u0101t\u012Bvus"),

  /**
   * Valor hic c\u0101sum \u012Bnstr\u016Bment\u0101lem d\u0113signat.
   */
  INSTRUMENTALIS("\u012Bnstr\u016Bment\u0101lis");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   * */
  public static final @NonNull String pittacium = Utilitas.minusculasScribo(Casus.class.getSimpleName().replace('a', '\u0101'));

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Casus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Casus} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #DERECTUS} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scriptio val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Casus} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NonNull public static Casus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(casus -> casus.scriptio.equals(scriptio))
                 .findFirst().orElse(DERECTUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Casus} quadrat; {@link #DERECTUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Casus ut(@NonNull final Enum <?> illud) {
    final Casus hoc = (Casus) illud;
    return hoc.equals(illud) ? hoc
                             : DERECTUS;
  }
}
