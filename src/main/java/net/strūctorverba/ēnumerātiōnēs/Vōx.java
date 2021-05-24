package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Āctus;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec vōcem verbī omnis dēsignat.
 * @see Āctus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Vōx {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc est invocābile.
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
   * Modus hic rem ēnumerātiō {@link Vōx} ā parametrō dēsignātō advenit. <br> Valōrem {@link #NŪLLA} refert sī nihil
   * valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Vōx} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Vōx dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(vōx -> vōx.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLA);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Vōx} quadrat; {@link #NŪLLA} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Vōx ut(@NotNull final Enum <@NotNull ?> illud) {
    final Vōx hoc = (Vōx) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLA;
  }
}
