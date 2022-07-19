package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.curatores.multiplicia.CuratorAdiectivis;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.interfacta.*;
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
 * Rēs huius classis catēgoriam {@link Categoria#NOMEN} ūtuntur cōnservātaque sunt in scrīniō
 * <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva. <br>
 * Discrīmina prīmōria inter hīs classibus classeque {@link Pronomen} est huius valor {@link #gradus}.
 * @see LectorMultiplicibus.LectorAdiectivis
 * @see TenorMultiplicibus.TenorAdiectivis
 * @see InventorAdiectivis
 * @see CuratorAdiectivis
 * @see NuntiusAdiectivorum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Adiectivum extends Declinabile<Adiectivum>
        implements Curabile<Adiectivum>, Legibile<Adiectivum>, Tenebile<Adiectivum> {
  /**
   * Hic valor potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @NonNull @Getter(lazy = true)
  private final NuntiusAdiectivorum nuntius = NuntiusAdiectivorum.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
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
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusAdiectivorum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdiectivorum());

    private NuntiusAdiectivorum() {
      super(ParametriNuntii.para(Actus.class));
    }
  }
}
