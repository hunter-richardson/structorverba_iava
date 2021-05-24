package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec numerum verbī omnis dēsignat.
 * @see Nōminālis
 * @see Āctus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Numerālis {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc est innumerābile.
   */
  NŪLLUS(StringUtils.EMPTY),

  /**
   * Valor hic numerum singulārem dēsignat.
   */
  SINGULĀRIS("singulāris"),

  /**
   * Valor hic numerum plūrālem dēsignat.
   */
  PLŪRĀLIS("plūrālis");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Numerālis(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Numerālis} ā parametrō dēsignātō advenit. <br> Valōrem {@link #NŪLLUS} refert sī
   * nihil valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Numerālis} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Numerālis dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(numerāle -> numerāle.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Numerālis} quadrat; {@link #NŪLLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Numerālis ut(@NotNull final Enum <@NotNull ?> illud) {
    final Numerālis hoc = (Numerālis) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUS;
  }
}
