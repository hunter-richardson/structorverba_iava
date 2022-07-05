package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Nominalis;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō cāsum verbī omnis dēsignat.
 * @see Nominalis
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
public enum Casus {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod hoc verbum dērigitur.
   */
  DERECTUS(StringUtils.EMPTY),

  /**
   * Hic valor cāsum nōminātīvum dēsignat.
   */
  NOMINATIVUS("nominātīvus"),

  /**
   * Hic valor cāsum genitīvum dēsignat.
   */
  GENITIVUS("genitīvus"),

  /**
   * Hic valor cāsum datīvum dēsignat.
   */
  DATIVUS("datīvus"),

  /**
   * Hic valor cāsum accūsātīvum dēsignat.
   */
  ACCUSATIVUS("accūsātīvus"),

  /**
   * Hic valor cāsum ablātīvum dēsignat.
   */
  ABLATIVUS("ablātīvus"),

  /**
   * Hic valor cāsum vocātīvum dēsignat.
   */
  VOCATIVUS("vocātīvus"),

  /**
   * Hic valor cāsum locātīvum dēsignat.
   */
  LOCATIVUS("locātīvus"),

  /**
   * Hic valor cāsum īnstrūmentālem dēsignat.
   */
  INSTRUMENTALIS("īnstrūmentālis");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   * */
  public static final @NonNull String pittacium = "cāsus";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  Casus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Casus} ā parametrō dēsignātō advenit. <br>
   * Valōrem {@link #DERECTUS} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Casus} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Casus definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(casus -> casus.scriptio.equals(scriptio))
                 .findFirst().orElse(DERECTUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Casus} quadrat; {@link #DERECTUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Casus ut(@NonNull final Enum <?> illud) {
    final Casus hoc = (Casus) illud;
    return hoc.equals(illud) ? hoc
                             : DERECTUS;
  }
}
