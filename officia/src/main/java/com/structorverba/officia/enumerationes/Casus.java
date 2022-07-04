package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.Nominalis;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Ēnumerātiō haec cāsum verbī omnis dēsignat.
 * @see Nominalis
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
public enum Casus {
  /**
   * Valor hic ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod verbum hoc dērigitur.
   */
  DERECTUS(StringUtils.EMPTY),

  /**
   * Valor hic cāsum nōminātīvum dēsignat.
   */
  NOMINATIVUS("nominātīvus"),

  /**
   * Valor hic cāsum genitīvum dēsignat.
   */
  GENITIVUS("genitīvus"),

  /**
   * Valor hic cāsum datīvum dēsignat.
   */
  DATIVUS("datīvus"),

  /**
   * Valor hic cāsum accūsātīvum dēsignat.
   */
  ACCUSATIVUS("accūsātīvus"),

  /**
   * Valor hic cāsum ablātīvum dēsignat.
   */
  ABLATIVUS("ablātīvus"),

  /**
   * Valor hic cāsum vocātīvum dēsignat.
   */
  VOCATIVUS("vocātīvus"),

  /**
   * Valor hic cāsum locātīvum dēsignat.
   */
  LOCATIVUS("locātīvus"),

  /**
   * Valor hic cāsum īnstrūmentālem dēsignat.
   */
  INSTRUMENTALIS("īnstrūmentālis");

  /**
   * Valor hic reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   * */
  public static final @NonNull String pittacium = "cāsus";

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Casus(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic rem ēnumerātiō {@link Casus} ā parametrō dēsignātō advenit. <br>
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
