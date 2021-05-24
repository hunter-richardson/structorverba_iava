package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Nōminālis;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec generem verbī omnis dēsignat.
 * @see Nōminālis
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Genus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc nōn ingenerat.
   */
  NŪLLUM(StringUtils.EMPTY),

  /**
   * Valor hic generem neutrum dēsignat.
   */
  NEUTRUM("neutrum"),

  /**
   * Valor hic generem masculīnum dēsignat.
   */
  MASCULĪNUM("masculīnum"),

  /**
   * Valor hic generem fēminīnum dēsignat.
   */
  FĒMINĪNUM("fēminīnum");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Genus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Genus} ā parametrō dēsignātō advenit. <br> Valōrem {@link #NŪLLUM} refert sī nihil
   * valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Genus} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Genus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(genus -> genus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUM);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Genus} quadrat; {@link #NŪLLUM} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Genus ut(@NotNull final Enum <@NotNull ?> illud) {
    final Genus hoc = (Genus) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUM;
  }
}
