package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec vōcem verbī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Vox {
  /**
   * Valor hic ūtātur sī ūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc est invocābile.
   */
  NULLA(StringUtils.EMPTY),

  /**
   * Valor hic vōcem āctīvam dēsignat.
   */
  ACTIVA("āctīva"),

  /**
   * Valor hic vōcem passīvam dēsignat.
   */
  PASSIVA("passīva");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "vōx";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Vox(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Vox} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NULLA} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Vox} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Vox definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(vox -> vox.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLA);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Vox} quadrat; {@link #NULLA} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Vox ut(@NonNull final Enum <?> illud) {
    final Vox hoc = (Vox) illud;
    return hoc.equals(illud) ? hoc
                             : NULLA;
  }
}
