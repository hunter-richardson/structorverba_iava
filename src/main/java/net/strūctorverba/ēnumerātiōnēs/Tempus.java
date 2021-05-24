package net.strūctorverba.ēnumerātiōnēs;

import net.strūctorverba.verba.multiplicia.Āctus;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec temporem verbī omnis dēsignat.
 * @see Āctus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Tempus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc temporem nōn pertinet.
   */
  INTEMPORĀLE(StringUtils.EMPTY),

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
   * Valor hic temporem plūsquamperfectum dēsignat.
   */
  PLŪSQUAMPERFECTUM("plūsquamperfectum"),

  /**
   * Valor hic temporem futūrum exāctum dēsignat. <br> Curtātum ā verbīs duōbus est scrīptiōnem facilem in scāpīs XML
   * licēre.
   */
  FUTŪRUM_EXĀCTUM("futrexāctum");

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
   * Modus hic rem ēnumerātiō {@link Tempus} ā parametrō dēsignātō advenit. <br> Valōrem {@link #INTEMPORĀLE} refert sī
   * nihil valōrem {@code scrīptiō} quadrat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   * @return Rem ēnumerātiō {@link Tempus} quod parametrum dēsignātum quadrat.
   */
  @NotNull public static Tempus dēfīniam(@NotNull final String scrīptiō) {
    return Stream.of(values())
                 .filter(tempus -> tempus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(INTEMPORĀLE);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Tempus} quadrat; {@link #INTEMPORĀLE} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NotNull public static Tempus ut(@NotNull final Enum <@NotNull ?> illud) {
    final Tempus hoc = (Tempus) illud;
    return hoc.equals(illud) ? hoc
                             : INTEMPORĀLE;
  }
}
