package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec potentiam adiectīvī omnis dēsignat.
 * @see Adiectivum
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Gradus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc nōn graditur.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Valor hic potentiam nōrmāle dēsignat.
   */
  POSITIVUS("positīvus"),

  /**
   * Valor hic potentiam comparātīvum dēsignat.
   */
  COMPARATIVUS("comparātīvus"),

  /**
   * Valor hic potentiam superlātīvum dēsignat.
   */
  SUPERLATIVUS("superlātīvus");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "gradus";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Gradus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Gradus} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NULLUS} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātio {@link Gradus} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Gradus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(gradus -> gradus.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Gradus} quadrat; {@link #NULLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Gradus ut(@NonNull final Enum <?> illud) {
    final Gradus hoc = (Gradus) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUS;
  }
}
