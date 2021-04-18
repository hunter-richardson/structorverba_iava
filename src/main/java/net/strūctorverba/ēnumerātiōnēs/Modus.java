package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec modum verbī omnis dēsignat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Modus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUM(StringUtils.EMPTY),

  /**
   * Valor hic modum indicātīvum dēsignat.
   */
  INDICĀTĪVUM("indicātīvum"),

  /**
   * Valor hic modum subiūnctīvum dēsignat.
   */
  SUBIŪNCTĪVUM("subiūnctīvum"),

  /**
   * Valor hic modum īnfīnītīvum dēsignat.
   */
  ĪNFĪNĪTĪVUM("īnfīnītīvum"),

  /**
   * Valor hic modum imperātīvum dēsignat.
   */
  IMPERĀTĪVUM("imperātīvum"),

  /**
   * Valor hic modum participiālem dēsignat.
   */
  PARTICIPĀLIS("participiālis");

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
  Modus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Cāsus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @implSpec {@code null} veniet sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Modus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  /**
   * Modus hic rem ēnumerātiō {@link Cāsus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Cāsus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @param dēfecta valor reventus sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Modus dēfīniam(@NotNull final String scrīptiō, @Nullable final Modus dēfecta) {
    return Stream.of(values())
                 .filter(modus -> modus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Cāsus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @param dēfecta valor reventus sī rēs nūlla {@code illud} quadrat.
   */
  public static @NotNull Modus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Modus dēfecta) {
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
  public static @NotNull Modus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Modus hoc = (Modus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
