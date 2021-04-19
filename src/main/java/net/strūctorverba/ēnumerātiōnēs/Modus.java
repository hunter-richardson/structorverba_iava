package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Āctum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec modum āctī omnis dēsignat.
 * @see Āctum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Modus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
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

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusĒnumerātiōnum nūntius = Nūntius.NūntiusĒnumerātiōnum.fac.get();

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
   * Modus hic rem ēnumerātiō {@link Cāsus} ā parametrō dēsignātō advenit.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   * @apiNote Modus hic valōrem {@link #NŪLLUS} refert sī nihil valōrem {@code scrīptiō} quadrat
   */
  public static @NotNull Modus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(modus -> modus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUS);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Cāsus} quadrat; {@link #NŪLLUS} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Modus ut(@NotNull final Enum<@NotNull ?> illud) {
    final Modus hoc = (Modus) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUS;
  }
}
