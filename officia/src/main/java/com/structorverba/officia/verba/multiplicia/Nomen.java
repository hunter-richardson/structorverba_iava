package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.structorverba.officia.conditores.multiplicia.ConditorNominibus;
import com.structorverba.officia.inventores.InventorNominibus;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link Nomen} repraesentat n\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#NOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/n\u014Dmina.
 * @see LectorMultiplicibus.LectorNominibus
 * @see TenorMultiplicibus.TenorNominibus
 * @see InventorNominibus
 * @see ConditorNominibus
 * @see NuntiusNominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Nomen extends Nominalis <Nomen> {
  /**
   * Valor hic tempus re\u012B huius d\u0113signat.
   * @see Modus
   */
  @NonNull public final Tempus tempus;

  @Getter(lazy = true)
  @NonNull private final NuntiusNominum nuntius = NuntiusNominum.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Nomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                @NonNull final Tempus tempus, @NonNull final String lemma,
                @NonNull final String scriptio) {
    super(Categoria.NOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.tempus = tempus;
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusNominum} est v\u0101s classis {@link Nuntius} class\u012B {@link Nomen}}
   * @see Nomen
   */
  @Singleton private static final class NuntiusNominum extends Nuntius {
    @Nullable private static NuntiusNominum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusNominum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusNominum());

    private NuntiusNominum() {
      super(ParametriNuntii.para(Nomen.class));
    }
  }
}
