package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.curatores.multiplicia.CuratorAdverbiis;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link Adverbium} repraesentat adverbia ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#ADVERBIUM} ūtuntur cōnservātaque sunt in
 * scrīnio <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adverbia.
 * @see LectorMultiplicibus.LectorAdverbiis
 * @see TenorMultiplicibus.TenorAdverbiis
 * @see CuratorAdverbiis
 * @see NuntiusAdverbiorum
 */
@SuppressWarnings("SpellCheckingInspection")
public class Adverbium extends VerbumMultiplex <Adverbium> {
  /**
   * Hic valor potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @Getter(lazy = true)
  @NonNull private final NuntiusAdverbiorum nuntius = NuntiusAdverbiorum.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Adverbium(@NonNull final Gradus gradus, @NonNull final String lemma,
                    @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusAdverbiorum} est vās classis {@link Nuntius} classī {@link Adverbium}
   * @see Adverbium
   */
  @Singleton
  private static final class NuntiusAdverbiorum extends Nuntius {
    @Nullable private static NuntiusAdverbiorum instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusAdverbiorum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdverbiorum());

    private NuntiusAdverbiorum() {
      super(ParametriNuntii.para(Adverbium.class));
    }
  }
}
