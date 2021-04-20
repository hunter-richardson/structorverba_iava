package net.strūctorverba.verba;

import net.strūctorverba.verba.disposita.Verba;
import net.strūctorverba.verba.multiplicia.PrōnōmenConiūnctīvum;
import org.jetbrains.annotations.*;

import java.util.LinkedList;

/**
 * Congressus {@link Coniugiāle} sit classis aut {@link VerbumSimplex.Coniūnctīvum} aut {@link PrōnōmenConiūnctīvum} et uterque dēfīnītōs itidem dēdūcit.
 * @see VerbumSimplex.Coniūnctīvum
 * @see PrōnōmenConiūnctīvum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public interface Coniugiāle {
  /**
   * Modus hic valōrēs trēs coniugat cum rē hāc mediō.
   * @param prīmus valor prīmus
   * @param secundus valor secundus
   * @param <Ille> classis quae valōrēs et {@code prīmus} et {@code secundus} quadrat
   * @return Seriēs classis {@link Verbum} quae valōrum et {@code prīmus} et huius et {@code secundus} ōrdine constat
   */
  <Ille extends Verbum <Ille>> @NotNull LinkedList <Verbum <@Nullable ?>> coniugō(@Nullable final Ille prīmus,
                                                                                  @Nullable final Ille secundus);

  /**
   * Modus hic valōrēs trēs coniugat.
   * @param prīmus valor prīmus
   * @param secundus valor secundus
   * @return Rēs classis {@link Verba} quae valōrum et {@code prīmus} et huius et {@code secundus} constat
   */
  @NotNull Verba coniugō(@NotNull final Verba prīmus, @NotNull final Verba secundus);

  /**
   * Modus hic valōrēs trēs coniugat.
   * @param prīmus valor prīmus
   * @param secundus valor secundus
   * @return Rēs classis {@link Verba} quae valōrum et {@code prīmus} et huius et {@code secundus} constat
   */
  @NotNull Verba coniugō(@NotNull final Verba prīmus, @NotNull final LinkedList <Verbum <@Nullable ?>> secundus);

  /**
   * @return Repraesentātiōnem scrīpta reī huius.
   * @see Verbum#toString()
   */
  @Override @NotNull String toString( );
}
