package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Āctum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec vōcem verbī omnis dēsignat.
 * @see Āctum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Vōx {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLA(StringUtils.EMPTY),

  /**
   * Valor hic vōcem āctīvam dēsignat.
   */
  ĀCTĪVA("āctīva"),

  /**
   * Valor hic vōcem passīvam dēsignat.
   */
  PASSĪVA("passīva");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Vōx(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Vōx} ā parametrō dēsignātō advenit.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return rem ēnumerātiō {@link Vōx} quod parametrum dēsignātum quadrat.
   * @apiNote Modus hic valōrem {@link #NŪLLA} refert sī nihil valōrem {@code scrīptiō} quadrat
   */
  public static @NotNull Vōx dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(vōx -> vōx.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLA);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Vōx} quadrat; {@link #NŪLLA} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Vōx ut(@NotNull final Enum<@NotNull ?> illud) {
    final Vōx hoc = (Vōx) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLA;
  }
}
