package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.interfacta.Declinabile;
import com.structorverba.officia.verba.multiplicia.*;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Haec ēnumerātiō numerum verbī omnis dēsignat.
 * @see Declinabile
 * @see Actus
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public enum Numeralis {
  /**
   * Hic valor ūtātur sī ūsūfructuāriī valōrem validum nōn dēnotat. <br> Sōlum scrīnium <a
   * href="{@docRoot}/../src/main/resources">auxiliārēs</a> ūtitur indicāre quod hoc verbum est innumerābile.
   */
  NULLUS(StringUtils.EMPTY),

  /**
   * Hic valor numerum singulārem dēsignat.
   */
  SINGULARIS("singulāris"),

  /**
   * Hic valor numerum plūrālem dēsignat.
   */
  PLURALIS("plūrālis");

  /**
   * Hic valor reparesentātiōnem scrīpta ēnumerātiōnis dēsignat.
   */
  public static final @NonNull String pittacium = "numerālis";

  /**
   * Hic valor repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  Numeralis(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus rem ēnumerātiō {@link Numeralis} ā parametrō dēsign\u010tō advenit. <br>
   * Valōrem {@link #NULLUS} refert sī nihil valōrem {@code scriptio} quadrat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   * @return Rem ēnumerātiō {@link Numeralis} quod parametrum dēsignātum quadrat.
   */
  @NonNull public static Numeralis definiam(@NonNull final String scriptio) {
    return Stream.of(values())
                 .filter(numerale -> numerale.scriptio.equals(scriptio))
                 .findFirst().orElse(NULLUS);
  }

  /**
   * @param illud valor tentandus.
   * @return {@code illud} sī valōrem ēnumerātiō {@link Numeralis} quadrat; {@link #NULLUS} aliter.
   */
  @SuppressWarnings("ConstantConditions")
  @NonNull public static Numeralis ut(@NonNull final Enum <?> illud) {
    final Numeralis hoc = (Numeralis) illud;
    return hoc.equals(illud) ? hoc
                             : NULLUS;
  }
}
