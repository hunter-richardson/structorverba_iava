package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Actus;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec dēsignat utrum verbum est certum necne.
 * @see Actus
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Specialitas {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>
   * Numquam scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur.
   */
  NULLUM(StringUtils.EMPTY),

  /**
   * Valor hic verbum certum dēsignat.
   */
  COMMUNE("commūne"),

  /**
   * Valor hic verbum incertum dēsignat.
   */
  PROPRIUM("proprium");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium ="speciālitās";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Specialitas(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Specialitas} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #NULLUM} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Specialitas} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Specialitas definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(specialitas -> specialitas.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUM);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Specialitas} quadrat; {@link #NULLUM} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Specialitas ut(@NonNull final Enum <?> illud) {
    final Specialitas hoc = (Specialitas) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUM;
  }
}
