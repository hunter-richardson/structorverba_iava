package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec temporem verbī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Tempus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc temporem nōn pertinet.
   */
  INTEMPORALE(StringUtils.EMPTY),

  /**
   * Valor hic temporem praesēntem dēsignat.
   */
  PRAESENS("praesēns"),

  /**
   * Valor hic temporem infectum dēsignat.
   */
  INFECTUM("infectum"),

  /**
   * Valor hic temporem futūrum dēsignat.
   */
  FUTURUM("futūrum"),

  /**
   * Valor hic temporem perfectum dēsignat.
   */
  PERFECTUM("perfectum"),

  /**
   * Valor hic temporem plūsquamperfectum dēsignat.
   */
  PLUSQUAMPERFECTUM("plūsquamperfectum"),

  /**
   * Valor hic temporem futūrum exāctum dēsignat. <br>
   * Curtātum ā verbīs duōbus est scrīptiōnem facilem in scāpīs XML licēre.
   */
  FUTURUM_EXACTUM("futrexāctum"),

  /**
   * Valor hic modum participiālem dēsignat.
   */
  GERUNDIVUS("gerundīvus"),

  /**
   * Valor hic modum participiālem dēsignat.
   */
  SUPINUS("supīnus");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "tempus";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Tempus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Tempus} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #INTEMPORALE} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Tempus} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Tempus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(tempus -> tempus.scriptio.equals(scriptio))
                 .findFirst().orElse(INTEMPORALE);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Tempus} quadrat; {@link #INTEMPORALE} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Tempus ut(@NonNull final Enum <?> illud) {
    final Tempus hoc = (Tempus) illud;
    return hoc.equals(illud) ? hoc
                             : INTEMPORALE;
  }
}
