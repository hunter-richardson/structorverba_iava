package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō temporem verbī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Tempus {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod hoc verbum temporem nōn pertinet.
   */
  INTEMPORALE(StringUtils.EMPTY),

  /**
   * Hic valor temporem praesēntem dēsignat.
   */
  PRAESENS("praesēns"),

  /**
   * Hic valor temporem infectum dēsignat.
   */
  INFECTUM("infectum"),

  /**
   * Hic valor temporem futūrum dēsignat.
   */
  FUTURUM("futūrum"),

  /**
   * Hic valor temporem perfectum dēsignat.
   */
  PERFECTUM("perfectum"),

  /**
   * Hic valor temporem plūsquamperfectum dēsignat.
   */
  PLUSQUAMPERFECTUM("plūsquamperfectum"),

  /**
   * Hic valor temporem futūrum exāctum dēsignat. <br>
   * Curtātum ā verbīs duōbus est scrīptiōnem facilem in scāpīs XML licēre.
   */
  FUTURUM_EXACTUM("futrexāctum"),

  /**
   * Hic valor modum participiālem dēsignat.
   */
  GERUNDIVUS("gerundīvus"),

  /**
   * Hic valor modum participiālem dēsignat.
   */
  SUPINUS("supīnus");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "tempus";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  Tempus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Tempus} ā parametrō dēsignātō advenit. <br>
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
