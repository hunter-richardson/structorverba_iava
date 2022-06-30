package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.structorverba.officia.conditores.multiplicia.ConditorAdiectivis;
import com.structorverba.officia.inventores.InventorAdiectivis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link Adiectivum} repraesentat adiect\u012Bva ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#NOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in scr\u012Bni\u014D
 * <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva. <br>
 * Discr\u012Bmina pr\u012Bm\u014Dria inter classibus h\u0101c classeque {@link Pronomen} est huius valor {@link #gradus}.
 * @see LectorMultiplicibus.LectorAdiectivis
 * @see TenorMultiplicibus.TenorAdiectivis
 * @see InventorAdiectivis
 * @see ConditorAdiectivis
 * @see NuntiusAdiectivorum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Adiectivum extends Nominalis <Adiectivum> {
  /**
   * Valor hic potentiam re\u012B huius d\u0113signat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @Getter(lazy = true)
  @NonNull private final NuntiusAdiectivorum nuntius = NuntiusAdiectivorum.fac.get();


  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Adiectivum(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                     @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                     @NonNull final Gradus gradus, @NonNull final String lemma,
                     @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }

  /**
   * Classis {@link NuntiusAdiectivorum} est v\u0101s classis {@link Nuntius} class\u012B {@link Adiectivum}}
   * @see Adiectivum
   */
  @Singleton
  private static final class NuntiusAdiectivorum extends Nuntius {
    @Nullable private static NuntiusAdiectivorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusAdiectivorum> fac =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdiectivorum());

    private NuntiusAdiectivorum() {
      super(ParametriNuntii.para(Actus.class));
    }
  }
}

