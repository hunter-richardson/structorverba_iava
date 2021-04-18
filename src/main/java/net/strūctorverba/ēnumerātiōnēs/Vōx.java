package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec vōcem verbī omnis dēsignat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Vōx {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUM(StringUtils.EMPTY),

  /**
   * Valor hic vōcem āctīvam dēsignat.
   */
  ĀCTĪVA("āctīva"),

  /**
   * Valor hic vōcem passīvam dēsignat.
   */
  PASSĪVA("passīva");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Vōx(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Vōx} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Vōx} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @implSpec {@code null} veniet sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Vōx dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  /**
   * Modus hic rem ēnumerātiō {@link Vōx} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Vōx} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @param dēfecta valor reventus sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Vōx dēfīniam(@NotNull final String scrīptiō, @Nullable final Vōx dēfecta) {
    return Stream.of(values())
                 .filter(vōx -> vōx.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Vōx} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @param dēfecta valor reventus sī rēs nūlla {@code illud} quadrat.
   */
  public static @NotNull Vōx ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Vōx dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Vōx} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @implSpec {@code null} veniet sī rēs nūlla {@code illud} quadrat.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Vōx ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Vōx hoc = (Vōx) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
