package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō persōnam verbī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Persona {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod hoc verbum persōnam nōn pertinet.
   */
  NULLA(StringUtils.EMPTY),

  /**
   * Hic valor persōnam prīmam dēsignat.
   */
  PRIMA("prīma"),

  /**
   * Hic valor persōnam secundam dēsignat.
   */
  SECUNDA("secunda"),

  /**
   * Hic valor persōnam tertiam dēsignat.
   */
  TERTIA("tertia");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "persōna";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Persona(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Persona} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NULLA} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Persona} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Persona definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(persona -> persona.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLA);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Persona} quadrat; {@link #NULLA} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Persona ut(@NonNull final Enum <?> illud) {
    final Persona hoc = (Persona) illud;
    return hoc.equals(illud) ? hoc
                             : NULLA;
  }
}
