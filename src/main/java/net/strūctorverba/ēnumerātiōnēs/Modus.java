package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Āctus;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec modum āctī omnis dēsignat.
 * @see Āctus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Modus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>
   * Numquam scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur.
   */
  NŪLLUS(StringUtils.EMPTY),

  /**
   * Valor hic modum indicātīvum dēsignat.
   */
  INDICĀTĪVUS("indicātīvus"),

  /**
   * Valor hic modum subiūnctīvum dēsignat.
   */
  SUBIŪNCTĪVUS("subiūnctīvus"),

  /**
   * Valor hic modum īnfīnītīvum dēsignat.
   */
  ĪNFĪNĪTĪVUS("īnfīnītīvus"),

  /**
   * Valor hic modum imperātīvum dēsignat.
   */
  IMPERĀTĪVUS("imperātīvus"),

  /**
   * Valor hic modum participiālem dēsignat.
   */
  PARTICIPĀLIS("participiālis");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Modus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Cāsus} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NŪLLUS} refert sī nihil valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Modus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(modus -> modus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUS);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Cāsus} quadrat; {@link #NŪLLUS} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Modus ut(@NotNull final Enum<@NotNull ?> illud) {
    final Modus hoc = (Modus) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUS;
  }
}
