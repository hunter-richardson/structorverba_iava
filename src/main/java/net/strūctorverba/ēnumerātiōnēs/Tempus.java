package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;


/**
 * Ēnumerātiō haec temporem verbī omnis dēsignat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Tempus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat.
   * Numquam scrīnium <a href="../src/main/resources">auxiliārēs</a> inscrībētur.
   */
  NŪLLUM(StringUtils.EMPTY),

  /**
   * Valor hic temporem praesēntem dēsignat.
   */
  PRAESĒNS("praesēns"),

  /**
   * Valor hic temporem infectum dēsignat.
   */
  INFECTUM("infectum"),

  /**
   * Valor hic temporem futūrum dēsignat.
   */
  FUTŪRUM("futūrum"),

  /**
   * Valor hic temporem perfectum dēsignat.
   */
  PERFECTUM("perfectum"),

  /**
   * Valor hic temporem plūperfectum dēsignat.
   */
  PLUPERFECTUM("plūperfectum"),

  /**
   * Valor hic temporem perfectum futūrum dēsignat.
   * Curtātum ā verbīs duōbus est scrīptiōnem facilem in scāpīs XML licēre.
   */
  PERFUTŪRUM("perfutūrum");

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
  Tempus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Tempus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Tempus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @implSpec {@code null} veniet sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Tempus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  /**
   * Modus hic rem ēnumerātiō {@link Tempus} ā parametrō dēsignātō advenit.
   * @return rem ēnumerātiō {@link Tempus} quod parametrum dēsignātum quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @param dēfecta valor reventus sī rēs nūlla parametrum quadrat.
   */
  public static @Nullable Tempus dēfīniam(@NotNull final String scrīptiō, @Nullable final Tempus dēfecta) {
    return Stream.of(values())
                 .filter(tempus -> tempus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Tempus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @param dēfecta valor reventus sī rēs nūlla {@code illud} quadrat.
   */
  public static @NotNull Tempus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Tempus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  /**
   * @return {@code illud} sī valōrem ēnumerātiō {@link Tempus} quadrat; {@code dēfecta} aliter.
   * @param illud valor tentandus.
   * @implSpec {@code null} veniet sī rēs nūlla {@code illud} quadrat.
   */
  @SuppressWarnings("ConstantConditions")
  public static @NotNull Tempus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Tempus hoc = (Tempus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
