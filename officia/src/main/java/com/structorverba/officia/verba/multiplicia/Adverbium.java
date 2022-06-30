package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.structorverba.officia.conditores.multiplicia.ConditorAdverbiis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link Adverbium} repraesentat adverbia ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#ADVERBIUM} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bnio <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adverbia.
 * @see LectorMultiplicibus.LectorAdverbiis
 * @see TenorMultiplicibus.TenorAdverbiis
 * @see ConditorAdverbiis
 * @see NuntiusAdverbiorum
 */
@SuppressWarnings("SpellCheckingInspection")
public class Adverbium extends VerbumMultiplex <Adverbium> {
  /**
   * Valor hic potentiam re\u012B huius d\u0113signat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @Getter(lazy = true)
  @NonNull private final NuntiusAdverbiorum nuntius = NuntiusAdverbiorum.fac.get();

  @Builder(access = AccessLevel.PUBLIC)
  private Adverbium(@NonNull final Gradus gradus, @NonNull final String lemma,
                    @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scr\u012Bbor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusAdverbiorum} est v\u0101s classis {@link Nuntius} class\u012B {@link Adverbium}
   * @see Adverbium
   */
  @Singleton
  private static final class NuntiusAdverbiorum extends Nuntius {
    @Nullable private static NuntiusAdverbiorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static Supplier<NuntiusAdverbiorum> fac =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdverbiorum());

    private NuntiusAdverbiorum() {
      super(ParametriNuntii.para(Adverbium.class));
    }
  }
}
