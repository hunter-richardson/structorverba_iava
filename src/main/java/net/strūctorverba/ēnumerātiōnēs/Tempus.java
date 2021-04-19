package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Āctum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;


/**
 * Ēnumerātiō haec temporem verbī omnis dēsignat.
 * @see Āctum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Tempus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUM(StringUtils.EMPTY),

  /**
   * Valor hic temporem praesēntem dēsignat.
   */
  PRAESĒNS("praesēns"),

  /**
   * Valor hic temporem infectum dēsignat.
   */
  INFECTUM("infectum"),

  /**
   * Valor hic temporem futūrum dēsignat.
   */
  FUTŪRUM("futūrum"),

  /**
   * Valor hic temporem perfectum dēsignat.
   */
  PERFECTUM("perfectum"),

  /**
   * Valor hic temporem plūperfectum dēsignat.
   */
  PLUPERFECTUM("plūperfectum"),

  /**
   * Valor hic temporem perfectum futūrum dēsignat.
   * Curtātum ā verbīs duōbus est scrīptiōnem facilem in scāpīs XML licēre.
   */
  PERFUTŪRUM("perfutūrum");

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
  Tempus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Tempus} ā parametrō dēsignātō advenit.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return rem ēnumerātiō {@link Tempus} quod parametrum dēsignātum quadrat.
   * @apiNote Modus hic valōrem {@link #NŪLLUM} refert sī nihil valōrem {@code scrīptiō} quadrat
   */
  public static @NotNull Tempus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(tempus -> tempus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUM);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Tempus} quadrat; {@link #NŪLLUM} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Tempus ut(@NotNull final Enum<@NotNull ?> illud) {
    final Tempus hoc = (Tempus) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUM;
  }
}
