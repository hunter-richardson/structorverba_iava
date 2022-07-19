package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.interfacta.Declinabile;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō dēsignat utrum verbum est certum necne.
 * @see Declinabile
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Specialitas {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br>
   * Numquam scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur.
   */
  NULLUM(StringUtils.EMPTY),

  /**
   * Hic valor verbum certum dēsignat.
   */
  COMMUNE("commūne"),

  /**
   * Hic valor verbum incertum dēsignat.
   */
  PROPRIUM("proprium");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium ="speciālitās";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  Specialitas(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Specialitas} ā parametrō dēsignātō advenit. <br>
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
