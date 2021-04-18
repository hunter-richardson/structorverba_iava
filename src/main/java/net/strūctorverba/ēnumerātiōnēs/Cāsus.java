package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec cāsum verbī omnis dēsignat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Cāsus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   */
  NŪLLUM(StringUtils.EMPTY),

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
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

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
   * @return rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @implSpec {@code null} veniet sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Cāsus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  /**
   * Modus hic rem ēnumerātiō {@link Cāsus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @param dēfecta valor reventus sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Cāsus dēfīniam(@NotNull final String scrīptiō, @Nullable final Cāsus dēfecta) {
    return Stream.of(values())
                 .filter(cāsus -> cāsus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Cāsus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @param dēfecta valor reventus sī rēs nūlla {@code illud} quadrat.
   */
  public static @NotNull Cāsus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Cāsus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }


  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Cāsus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @implSpec {@code null} veniet sī rēs nūlla {@code illud} quadrat.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Cāsus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Cāsus hoc = (Cāsus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
