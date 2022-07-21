package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.interfacta.Inflectabile;
import com.structorverba.officia.verba.multiplicia.*;
import com.structorverba.officia.verba.simplicia.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Haec ēnumerātiō extēnsiōnem classī {@link Verbum} dēsignat cui verbum omne respondet.
 * @see Verbum
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Categoria {
  /**
   * Hic valor classem {@link Nomen} respondet.
   */
  NOMEN(Nomen.declinatio),

  /**
   * Hic valor classem {@link Adiectivum} respondet.
   */
  ADIECTIVUM(Adiectivum.declinatio),

  /**
   * Hic valor classem {@link Pronomen} respondet.
   */
  PRONOMEN(Pronomen.declinatio),

  /**
   * Hic valor classem {@link Actus} respondet.
   */
  ACTUS(Actus.declinatio),

  /**
   * Hic valor classem {@link Adverbium} respondet.
   */
  ADVERBIUM(Adverbium.declinatio),

  /**
   * Hic valor classem {@link Coniunctio} respondet.
   */
  CONIUNCTIO(Coniunctio.declinatio),

  /**
   * Hic valor classem {@link Interiectio} respondet.
   */
  INTERIECTIO(Interiectio.declinatio),

  /**
   * Hic valor classem {@link Praepositio} respondet.
   */
  PRAEPOSITIO(Praepositio.declinatio),

  /**
   * Hic valor classem {@link Numerus} respondet.
   */
  NUMERUS(Numerus.declinatio);

  @NonNull private final BiFunction<Casus, Numeralis, String> declinatio;

  /**
   * Hic valor nōminātur scrīnium intrā quō scāpum verbī omnī cōnservātum est.
   */
  public final @NotNull String scriptio;

  Categoria(@NonNull final BiFunction<Casus, Numeralis, String> dclnt) {
      declinatio = dclnt;
      scriptio = declinatio.apply(Casus.NOMINATIVUS, Numeralis.PLURALIS);
  }

    /**
     * Hic modus dēclīnat dē valōribus imputātīs verbum ly {@link Categoria}.
     * @param casus  Valor classis {@link Casus} dēclīnātiōnī
     * @param numeralis  Valor classis {@link Numeralis} dēclīnātiōnī
     * @param primaCapitanea indīcat utrum littera prīma capitānea sit necne
     * */
    @NonNull public String declina(@NonNull final Casus casus, @NonNull final Numeralis numeralis,
                                   final boolean primaCapitanea) {
        final String verbum = declinatio.apply(casus, numeralis);
        return primaCapitanea ? Utilitas.primaCapitanea.apply(verbum) : verbum;
    }

    /**
     * Hic modus dēclīnat dē valōribus imputātīs verbum ly {@link Categoria}.
     * @param casus  Valor classis {@link Casus} dēclīnātiōnī
     * @param numeralis  Valor classis {@link Numeralis} dēclīnātiōnī
     * @param primaCapitanea indīcat utrum littera prīma capitānea sit necne
     * */
    @SuppressWarnings("unused")
    @NonNull public static String declina(@NonNull final Categoria categoria, @NonNull final Casus casus,
                                          @NonNull final Numeralis numeralis, final boolean primaCapitanea) {
        return categoria.declina(casus, numeralis, primaCapitanea);
    }

    /**
   * Hic modus dēterminat utrum rēs classis {@link Verbum} catēgoriae {@code categoria} classem {@link Inflectabile} impleant necne.
   * @param categoria  Rēs dēterminanda
   * @return {@code true} sī  rēs catēgoriae {@code categoria} classem {@link Inflectabile} implent; {@code false} aliter
   * */
  public static boolean inflectabile(@NonNull final Categoria categoria) {
    return !Arrays.asList(CONIUNCTIO, INTERIECTIO, PRAEPOSITIO, NUMERUS).contains(categoria);
  }

  /**
   * Hic modus dēterminat utrum rēs quaeque classis {@link Verbum} catēgoriae {@code categoria} in scāpō singulō contineātur necne.
   * @param categoria  Rēs dēterminanda
   * @return {@code true} sī  rēs catēgoriae {@code categoria} in scāpō singulō continētur; {@code false} aliter
   * */
  public static boolean singulaScapis(@NonNull final Categoria categoria) {
    return !Arrays.asList(PRAEPOSITIO, NUMERUS).contains(categoria);
  }
}
