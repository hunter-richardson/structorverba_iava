package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.structorverba.officia.conditores.multiplicia.ConditorPronominibus;
import com.structorverba.officia.inventores.InventorPronominibus;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link Pronomen} repraesentat pr\u014Dn\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#PRONOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/pr\u014Dn\u014Dmina.
 * @see LectorMultiplicibus.LectorPronominibus
 * @see TenorMultiplicibus.TenorPronominibus
 * @see InventorPronominibus
 * @see ConditorPronominibus
 * @see NuntiusPronominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Pronomen extends Nominalis <Pronomen> {
  @Getter(lazy = true)
  @NonNull private final NuntiusPronominum nuntius = NuntiusPronominum.fac.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Pronomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                   @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                   @NonNull final String lemma, @NonNull final String scriptio) {
    super(Categoria.PRONOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusPronominum} est v\u0101s classis {@link Nuntius} class\u012B {@link Pronomen}}
   * @see Pronomen
   */
  @Singleton
  private static final class NuntiusPronominum extends Nuntius {
    @Nullable private static NuntiusPronominum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusPronominum> fac =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusPronominum());

    private NuntiusPronominum() {
      super(ParametriNuntii.para(Pronomen.class));
    }
  }
}
