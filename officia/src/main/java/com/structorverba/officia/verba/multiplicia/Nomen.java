package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.curatores.multiplicia.CuratorNominibus;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.InventorNominibus;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link Nomen} repraesentat nōmina ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#NOMEN} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/nōmina.
 * @see LectorMultiplicibus.LectorNominibus
 * @see TenorMultiplicibus.TenorNominibus
 * @see InventorNominibus
 * @see CuratorNominibus
 * @see NuntiusNominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Nomen extends Nominalis <Nomen> {
  /**
   * Hic valor tempus reī huius dēsignat.
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
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusNominum} est vās classis {@link Nuntius} classī {@link Nomen}}
   * @see Nomen
   */
  @Singleton private static final class NuntiusNominum extends Nuntius {
    @Nullable private static NuntiusNominum instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusNominum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusNominum());

    private NuntiusNominum() {
      super(ParametriNuntii.para(Nomen.class));
    }
  }
}
