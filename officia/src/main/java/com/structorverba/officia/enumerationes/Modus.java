package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec modum āctī omnis dēsignat.
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Modus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>
   * Numquam scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Valor hic modum indicātīvum dēsignat.
   */
  INDICATIVUS("indicātīvus"),

  /**
   * Valor hic modum subiūnctīvum dēsignat.
   */
  SUBIUNCTIVUS("subiūnctīvus"),

  /**
   * Valor hic modum īnfīnītīvum dēsignat.
   */
  INFINITIVUS("īnfīnītīvus"),

  /**
   * Valor hic modum imperātīvum dēsignat.
   */
  IMPERATIVUS("imperātīvus"),

  /**
   * Valor hic modum participiālem dēsignat.
   */
  PARTICIPALIS("participiālis");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "modus";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Modus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Casus} ā parametrō dēsignāqtō advenit. <br>
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
