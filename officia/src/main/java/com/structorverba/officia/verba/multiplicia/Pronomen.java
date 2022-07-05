package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.curatores.multiplicia.CuratorPronominibus;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.InventorPronominibus;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link Pronomen} repraesentat prōnōmina ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#PRONOMEN} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina.
 * @see LectorMultiplicibus.LectorPronominibus
 * @see TenorMultiplicibus.TenorPronominibus
 * @see InventorPronominibus
 * @see CuratorPronominibus
 * @see NuntiusPronominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Pronomen extends Nominalis <Pronomen> {
  @NonNull @Getter(lazy = true)
  private final NuntiusPronominum nuntius = NuntiusPronominum.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Pronomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                   @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                   @NonNull final String lemma, @NonNull final String scriptio) {
    super(Categoria.PRONOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusPronominum} est vās classis {@link Nuntius} classī {@link Pronomen}}
   * @see Pronomen
   */
  @Singleton
  private static final class NuntiusPronominum extends Nuntius {
    @Nullable private static NuntiusPronominum instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusPronominum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusPronominum());

    private NuntiusPronominum() {
      super(ParametriNuntii.para(Pronomen.class));
    }
  }
}
