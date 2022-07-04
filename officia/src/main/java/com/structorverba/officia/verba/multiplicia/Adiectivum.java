package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.conditores.multiplicia.ConditorAdiectivis;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.InventorAdiectivis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link Adiectivum} repraesentat adiectīva ut coniectēris. <br>
 * Rēs classis huius catēgoriam {@link Categoria#NOMEN} ūtuntur cōnservātaque sunt in scrīniō
 * <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva. <br>
 * Discrīmina prīmōria inter classibus hāc classeque {@link Pronomen} est huius valor {@link #gradus}.
 * @see LectorMultiplicibus.LectorAdiectivis
 * @see TenorMultiplicibus.TenorAdiectivis
 * @see InventorAdiectivis
 * @see ConditorAdiectivis
 * @see NuntiusAdiectivorum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Adiectivum extends Nominalis <Adiectivum> {
  /**
   * Valor hic potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @Getter(lazy = true)
  @NonNull private final NuntiusAdiectivorum nuntius = NuntiusAdiectivorum.faciendum.get();

  @Builder(access = AccessLevel.PRIVATE, toBuilder = true)
  private Adiectivum(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                     @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                     @NonNull final Gradus gradus, @NonNull final String lemma,
                     @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusAdiectivorum} est vās classis {@link Nuntius} classī {@link Adiectivum}}
   * @see Adiectivum
   */
  @Singleton
  private static final class NuntiusAdiectivorum extends Nuntius {
    @Nullable private static NuntiusAdiectivorum instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusAdiectivorum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdiectivorum());

    private NuntiusAdiectivorum() {
      super(ParametriNuntii.para(Actus.class));
    }
  }

  public static final class ConstructorAdiectivi extends Constructor<Adiectivum> {
    @NonNull private Specialitas specialitas = Specialitas.NULLUM;
    @NonNull private Genus genus = Genus.NULLUM;
    @NonNull private Casus casus = Casus.DERECTUS;
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;
    @NonNull private Gradus gradus = Gradus.NULLUS;

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

    public void gradus(@NonNull final Gradus gradus) {
      this.gradus = gradus;
    }

    @Nullable @Override
    public Adiectivum build() {
      return paratus() ? Adiectivum.builder().lemma(lemma).specialitas(specialitas).genus(genus).casus(casus)
                                             .numeralis(numeralis).gradus(gradus).scriptio(scriptio).build()
                       : null;
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Casus#DERECTUS
     * @see Numeralis#NULLUS
     * @see Gradus#NULLUS
     */
    @Override public void restituo() {
      specialitas = Specialitas.NULLUM;
      genus = Genus.NULLUM;
      casus = Casus.DERECTUS;
      numeralis = Numeralis.NULLUS;
      gradus = Gradus.NULLUS;
      scriptio = StringUtils.EMPTY;
      lemma = StringUtils.EMPTY;
    }
  }
}
