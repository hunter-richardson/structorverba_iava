package com.structorverba.officia.enumerationes;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.multiplicia.Actus;

import org.apache.commons.lang3.StringUtils;
import androidx.annotation.NonNull;

import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec temporem verb\u012B omnis d\u0113signat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Tempus {
  /**
   * Valor hic \u016Bt\u0101tur s\u012B \u016Bs\u016Bfructu\u0101ri\u012B val\u014Drem validum n\u014Dn d\u0113notat. <br>S\u014Dlum scr\u012Bnium <a
   * href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a> \u016Btitur indic\u0101re quod verbum hoc temporem n\u014Dn pertinet.
   */
  INTEMPORALE(StringUtils.EMPTY),

  /**
   * Valor hic temporem praes\u0113ntem d\u0113signat.
   */
  PRAESENS("praes\u0113ns"),

  /**
   * Valor hic temporem infectum d\u0113signat.
   */
  INFECTUM("infectum"),

  /**
   * Valor hic temporem fut\u016Brum d\u0113signat.
   */
  FUTURUM("fut\u016Brum"),

  /**
   * Valor hic temporem perfectum d\u0113signat.
   */
  PERFECTUM("perfectum"),

  /**
   * Valor hic temporem pl\u016Bsquamperfectum d\u0113signat.
   */
  PLUSQUAMPERFECTUM("pl\u016Bsquamperfectum"),

  /**
   * Valor hic temporem fut\u016Brum ex\u0101ctum d\u0113signat. <br>
   * Curt\u0101tum \u0101 verb\u012Bs du\u014Dbus est scr\u012Bpti\u014Dnem facilem in sc\u0101p\u012Bs XML lic\u0113re.
   */
  FUTURUM_EXACTUM("futrex\u0101ctum"),

  /**
   * Valor hic modum participi\u0101lem d\u0113signat.
   */
  GERUNDIVUS("gerund\u012Bvus"),

  /**
   * Valor hic modum participi\u0101lem d\u0113signat.
   */
  SUPINUS("sup\u012Bnus");

  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta \u0113numer\u0101ti\u014Dnis d\u0113signat.
   */
  public static final @NonNull String pittacium = Utilitas.minusculasScribo(Tempus.class.getSimpleName());

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Tempus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem \u0113numer\u0101ti\u014D {@link Tempus} \u0101 parametr\u014D d\u0113sign\u0101t\u014D advenit. <br>
   * Val\u014Drem {@link #INTEMPORALE} refert s\u012B nihil val\u014Drem {@code scriptio} quadrat.
   * @param scriptio val\u014Drem {@link #scriptio} indicat.
   * @return Rem \u0113numer\u0101ti\u014D {@link Tempus} quod parametrum d\u0113sign\u0101tum quadrat.
   */
  @NonNull public static Tempus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(tempus -> tempus.scriptio.equals(scriptio))
                 .findFirst().orElse(INTEMPORALE);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} s\u012B val\u014Drem \u0113numer\u0101ti\u014D {@link Tempus} quadrat; {@link #INTEMPORALE} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Tempus ut(@NonNull final Enum <?> illud) {
    final Tempus hoc = (Tempus) illud;
    return hoc.equals(illud) ? hoc
                             : INTEMPORALE;
  }
}
