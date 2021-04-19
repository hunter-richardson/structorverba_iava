package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Nōminālis;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec cāsum verbī omnis dēsignat.
 * @see Nōminālis
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Cāsus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUS(StringUtils.EMPTY),

  /**
   * Valor hic cāsum nōminātīvum dēsignat.
   */
  NŌMINĀTĪVUS("nōminātīvus"),

  /**
   * Valor hic cāsum genitīvum dēsignat.
   */
  GENITĪVUS("genitīvus"),

  /**
   * Valor hic cāsum datīvum dēsignat.
   */
  DATĪVUS("datīvus"),

  /**
   * Valor hic cāsum accūsātīvum dēsignat.
   */
  ACCŪSĀTĪVUS("accūsātīvus"),

  /**
   * Valor hic cāsum ablātīvum dēsignat.
   */
  ABLĀTĪVUS("ablātīvus"),

  /**
   * Valor hic cāsum vocātīvum dēsignat.
   */
  VOCĀTĪVUS("vocātīvus"),

  /**
   * Valor hic cāsum locātīvum dēsignat.
   */
  LOCĀTĪVUS("locātīvus"),

  /**
   * Valor hic cāsum īnstrūmentālem dēsignat.
   */
  ĪNSTRŪMENTĀLIS("īnstrūmentālis");

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
  Cāsus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Cāsus} ā parametrō dēsignātō advenit.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   * @apiNote Modus hic valōrem {@link #NŪLLUS} refert sī nihil valōrem {@code scrīptiō} quadrat
   */
  public static @NotNull Cāsus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(cāsus -> cāsus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(NŪLLUS);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Cāsus} quadrat; {@link #NŪLLUS} aliter.
   * @param illud valor tentandus.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Cāsus ut(@NotNull final Enum<@NotNull ?> illud) {
    final Cāsus hoc = (Cāsus) illud;
    return hoc.equals(illud) ? hoc
                             : NŪLLUS;
  }
}
