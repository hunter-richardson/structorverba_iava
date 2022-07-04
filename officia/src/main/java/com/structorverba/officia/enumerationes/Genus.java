package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Nominalis;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec generem verbī omnis dēsignat.
 * @see Nominalis
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Genus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc nōn ingenerat.
   */
  NULLUM(StringUtils.EMPTY),

  /**
   * Valor hic generem neutrum dēsignat.
   */
  NEUTRUM("neutrum"),

  /**
   * Valor hic generem masculīnum dēsignat.
   */
  MASCULINUM("masculīnum"),

  /**
   * Valor hic generem fēminīnum dēsignat.
   */
  FEMININUM("fēminīnum");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "genus";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Genus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Genus} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NULLUM} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Genus} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Genus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(genus -> genus.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUM);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Genus} quadrat; {@link #NULLUM} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Genus ut(@NonNull final Enum <?> illud) {
    final Genus hoc = (Genus) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUM;
  }
}
