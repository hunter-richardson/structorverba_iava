package net.structorverba.bibliotheca.enumerationes;

import net.structorverba.bibliotheca.verba.multiplicia.Āctus;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec persōnam verbī omnis dēsignat.
 * @see Āctus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Persōna {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc persōnam nōn pertinet.
   */
  NŪLLA(StringUtils.EMPTY),

  /**
   * Valor hic persōnam prīmam dēsignat.
   */
  PRĪMA("prīma"),

  /**
   * Valor hic persōnam secundam dēsignat.
   */
  SECUNDA("secunda"),

  /**
   * Valor hic persōnam tertiam dēsignat.
   */
  TERTIA("tertia");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Persōna(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Persōna} ā parametrō dēsignātō advenit. <br> Valōrem {@link #NŪLLA} refert sī nihil
   * valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Persōna} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Persōna dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(persōna -> persōna.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLA);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Persōna} quadrat; {@link #NŪLLA} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Persōna ut(@NotNull final Enum <@NotNull ?> illud) {
    final Persōna hoc = (Persōna) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLA;
  }
}
