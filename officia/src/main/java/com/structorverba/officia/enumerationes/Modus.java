package com.structorverba.officia.enumerationes;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.multiplicia.Actus;

import org.apache.commons.lang3.StringUtils;
import androidx.annotation.NonNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec modum \u0101ct\u012B omnis d\u0113signat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Modus {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br>
   * Numquam scr\u012Bnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Valor hic modum indic\u0101t\u012Bvum d\u0113signat.
   */
  INDICATIVUS("indic\u0101t\u012Bvus"),

  /**
   * Valor hic modum subi\u016Bnct\u012Bvum d\u0113signat.
   */
  SUBIUNCTIVUS("subi\u016Bnct\u012Bvus"),

  /**
   * Valor hic modum \u012Bnf\u012Bn\u012Bt\u012Bvum d\u0113signat.
   */
  INFINITIVUS("\u012Bnf\u012Bn\u012Bt\u012Bvus"),

  /**
   * Valor hic modum imper\u0101t\u012Bvum d\u0113signat.
   */
  IMPERATIVUS("imper\u0101t\u012Bvus"),

  /**
   * Valor hic modum participi\u0101lem d\u0113signat.
   */
  PARTICIPALIS("participi\u0101lis");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   */
  public static final @NonNull String pittacium = Utilitas.minusculasScribo(Modus.class.getSimpleName());

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Modus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Casus} \u0101 parametr\u014D d\u0113sign\u0101qt\u014D advenit. <br>
   * Val\u014Drem {@link #NULLUS} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scriptio val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Casus} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NonNull public static Modus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(modus -> modus.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Casus} quadrat; {@link #NULLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Modus ut(@NonNull final Enum <?> illud) {
    final Modus hoc = (Modus) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUS;
  }
}
