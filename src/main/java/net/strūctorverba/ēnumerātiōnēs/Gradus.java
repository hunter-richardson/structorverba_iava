package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Adiectīvum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec potentiam adiectīvī omnis dēsignat.
 * @see Adiectīvum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Gradus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUS(StringUtils.EMPTY),

  /**
   * Valor hic potentiam nōrmāle dēsignat.
   */
  NŌRMĀlIS("nōrmālis"),

  /**
   * Valor hic potentiam comparātīvum dēsignat.
   */
  COMPARĀTĪVUS("comparātīvus"),

  /**
   * Valor hic potentiam superlātīvum dēsignat.
   */
  SUPERLĀTĪVUS("superlātīvus");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Gradus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Gradus} ā parametrō dēsignātō advenit.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return rem ēnumerātiō {@link Gradus} quod parametrum dēsignātum quadrat.
   * @apiNote Modus hic valōrem {@link #NŪLLUS} refert sī nihil valōrem {@code scrīptiō} quadrat
   */
  public static @NotNull Gradus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(gradus -> gradus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUS);
  }
  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Gradus} quadrat; {@link #NŪLLUS} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Gradus ut(@NotNull final Enum<@NotNull ?> illud) {
    final Gradus hoc = (Gradus) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUS;
  }
}
