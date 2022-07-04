package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.conditores.multiplicia.ConditorPronominibus;
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
 * @see ConditorPronominibus
 * @see NuntiusPronominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Pronomen extends Nominalis <Pronomen> {
  @NonNull @Getter(lazy = true)
  private final NuntiusPronominum nuntius = NuntiusPronominum.faciendum.get();

  @Builder(access = AccessLevel.PRIVATE, toBuilder = true)
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

  public static final class ConstructorPronominis extends Constructor<Pronomen> {
    @NonNull private Specialitas specialitas = Specialitas.NULLUM;
    @NonNull private Genus genus = Genus.NULLUM;
    @NonNull private Casus casus = Casus.DERECTUS;
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;
    public void specialitas(@NonNull final Specialitas specialitas) {
      this.specialitas = specialitas;
    }

    public void genus(@NonNull final Genus genus) {
      this.genus = genus;
    }

    public void casus(@NonNull final Casus casus) {
      this.casus = casus;
    }

    public void numeralis(@NonNull final Numeralis numeralis) {
      this.numeralis = numeralis;
    }

    @Nullable @Override
    public Pronomen build() {
      return paratus() ? Pronomen.builder().lemma(lemma).specialitas(specialitas).genus(genus).casus(casus)
                                           .numeralis(numeralis).scriptio(scriptio).build()
                       : null;
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Casus#DERECTUS
     * @see Numeralis#NULLUS
     */
    @Override public void restituo() {
      specialitas = Specialitas.NULLUM;
      genus = Genus.NULLUM;
      casus = Casus.DERECTUS;
      numeralis = Numeralis.NULLUS;
      scriptio = StringUtils.EMPTY;
      lemma = StringUtils.EMPTY;
    }
  }
}
