package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Āctus;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec dēsignat utrum verbum est certum necne.
 * @see Āctus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Speciālitās {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>
   * Numquam scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur.
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
   * Modus hic rem ēnumerātiō {@link Speciālitās} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NŪLLUM} refert sī nihil valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Speciālitās} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Speciālitās dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(speciālitās -> speciālitās.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUM);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Speciālitās} quadrat; {@link #NŪLLUM} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Speciālitās ut(@NotNull final Enum<@NotNull ?> illud) {
    final Speciālitās hoc = (Speciālitās) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUM;
  }
}
