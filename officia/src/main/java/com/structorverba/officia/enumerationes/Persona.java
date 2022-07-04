package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec persōnam verbī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Persona {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc persōnam nōn pertinet.
   */
  NULLA(StringUtils.EMPTY),

  /**
   * Valor hic persōnam prīmam dēsignat.
   */
  PRIMA("prīma"),

  /**
   * Valor hic persōnam secundam dēsignat.
   */
  SECUNDA("secunda"),

  /**
   * Valor hic persōnam tertiam dēsignat.
   */
  TERTIA("tertia");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "persōna";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Persona(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Persona} ā parametrō dēsignātō advenit. <br>
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
