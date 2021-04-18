package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec numerum verbī omnis dēsignat.
 * @see Nōminālis
 * @see Āctum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Numerāle {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUS(StringUtils.EMPTY),

  /**
   * Valor hic numerum singulārem dēsignat.
   */
  SINGULĀRIS("singulāris"),

  /**
   * Valor hic numerum plūrālem dēsignat.
   */
  PLŪRĀLIS("plūrālis");

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
  Numerāle(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Numerāle} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Numerāle} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @implSpec {@code null} veniet sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Numerāle dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  /**
   * Modus hic rem ēnumerātiō {@link Numerāle} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Numerāle} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @param dēfecta valor reventus sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Numerāle dēfīniam(@NotNull final String scrīptiō, @Nullable final Numerāle dēfecta) {
    return Stream.of(values())
                 .filter(numerāle -> numerāle.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Numerāle} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @param dēfecta valor reventus sī rēs nūlla {@code illud} quadrat.
   */
  public static @NotNull Numerāle ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Numerāle dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Numerāle} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @implSpec {@code null} veniet sī rēs nūlla {@code illud} quadrat.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Numerāle ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Numerāle hoc = (Numerāle) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
