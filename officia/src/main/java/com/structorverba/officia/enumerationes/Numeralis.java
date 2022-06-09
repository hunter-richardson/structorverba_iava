package com.structorverba.officia.enumerationes;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.multiplicia.*;

import org.apache.commons.lang3.StringUtils;
import androidx.annotation.NonNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec numerum verb\u012B omnis d\u0113signat.
 * @see Nominalis
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Numeralis {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br> S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc est innumer\u0101bile.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Valor hic numerum singul\u0101rem d\u0113signat.
   */
  SINGULARIS("singul\u0101ris"),

  /**
   * Valor hic numerum pl\u016Br\u0101lem d\u0113signat.
   */
  PLURALIS("pl\u016Br\u0101lis");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   */
  public static final @NonNull String pittacium = Utilitas.minusculasScribo(Numeralis.class.getSimpleName().replace('a', '\u0101'));

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Numeralis(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Numeralis} \u0101 parametr\u014D d\u0113sign\u010t\u014D advenit. <br>
   * Val\u014Drem {@link #NULLUS} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scriptio val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Numeralis} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NonNull public static Numeralis definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(numerale -> numerale.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Numeralis} quadrat; {@link #NULLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Numeralis ut(@NonNull final Enum <?> illud) {
    final Numeralis hoc = (Numeralis) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUS;
  }
}
