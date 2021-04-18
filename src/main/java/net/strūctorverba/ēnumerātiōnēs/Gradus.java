package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.Adiectīvum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec potentiam adiectīvī omnis dēsignat.
 * @see Adiectīvum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Gradus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUS(StringUtils.EMPTY),

  /**
   * Valor hic potentiam nōrmāle dēsignat.
   */
  NŌRMĀlIS("nōrmālis"),

  /**
   * Valor hic potentiam comparātīvum dēsignat.
   */
  COMPARĀTĪVUS("comparātīvus"),

  /**
   * Valor hic potentiam superlātīvum dēsignat.
   */
  SUPERLĀTĪVUS("superlātīvus");

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
  Gradus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Gradus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Gradus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @implSpec {@code null} veniet sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Gradus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  /**
   * Modus hic rem ēnumerātiō {@link Gradus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Gradus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @param dēfecta valor reventus sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Gradus dēfīniam(@NotNull final String scrīptiō, @Nullable final Gradus dēfecta) {
    return Stream.of(values())
                 .filter(gradus -> gradus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Gradus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @param dēfecta valor reventus sī rēs nūlla {@code illud} quadrat.
   */
  public static @NotNull Gradus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Gradus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Gradus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @implSpec {@code null} veniet sī rēs nūlla {@code illud} quadrat.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Gradus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Gradus hoc = (Gradus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
