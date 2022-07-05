package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō potentiam adiectīvī omnis dēsignat.
 * @see Adiectivum
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Gradus {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod hoc verbum nōn graditur.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Hic valor potentiam nōrmāle dēsignat.
   */
  POSITIVUS("positīvus"),

  /**
   * Hic valor potentiam comparātīvum dēsignat.
   */
  COMPARATIVUS("comparātīvus"),

  /**
   * Hic valor potentiam superlātīvum dēsignat.
   */
  SUPERLATIVUS("superlātīvus");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "gradus";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  Gradus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Gradus} ā parametrō dēsignātō advenit. <br>
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
