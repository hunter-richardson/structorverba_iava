package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Āctum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec dēsignat sīve verbum est certum sīve incertum.
 * @see Āctum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Speciālitās {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUM(StringUtils.EMPTY),

  /**
   * Valor hic verbum certum dēsignat.
   */
  COMMŪNE("commūne"),

  /**
   * Valor hic verbum incertum dēsignat.
   */
  PROPRIUM("proprium");

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
  Speciālitās(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Speciālitās} ā parametrō dēsignātō advenit.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return rem ēnumerātiō {@link Speciālitās} quod parametrum dēsignātum quadrat.
   * @apiNote Modus hic valōrem {@link #NŪLLUM} refert sī nihil valōrem {@code scrīptiō} quadrat
   */
  public static @NotNull Speciālitās dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(speciālitās -> speciālitās.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUM);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Speciālitās} quadrat; {@link #NŪLLUM} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Speciālitās ut(@NotNull final Enum<@NotNull ?> illud) {
    final Speciālitās hoc = (Speciālitās) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUM;
  }
}
