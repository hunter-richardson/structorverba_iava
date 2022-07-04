package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō modum āctī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Modus {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>
   * Numquam scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Hic valor modum indicātīvum dēsignat.
   */
  INDICATIVUS("indicātīvus"),

  /**
   * Hic valor modum subiūnctīvum dēsignat.
   */
  SUBIUNCTIVUS("subiūnctīvus"),

  /**
   * Hic valor modum īnfīnītīvum dēsignat.
   */
  INFINITIVUS("īnfīnītīvus"),

  /**
   * Hic valor modum imperātīvum dēsignat.
   */
  IMPERATIVUS("imperātīvus"),

  /**
   * Hic valor modum participiālem dēsignat.
   */
  PARTICIPALIS("participiālis");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "modus";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Hoc officum cōnstrūctōrem reī huius classis perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Modus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Casus} ā parametrō dēsignāqtō advenit. <br>
   * Valōrem {@link #NULLUS} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Casus} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Modus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(modus -> modus.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Casus} quadrat; {@link #NULLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Modus ut(@NonNull final Enum <?> illud) {
    final Modus hoc = (Modus) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUS;
  }
}
