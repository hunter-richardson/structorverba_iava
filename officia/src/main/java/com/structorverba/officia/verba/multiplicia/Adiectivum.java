package com.structorverba.officia.verba.multiplicia;

import com.structorverba.officia.conditores.multiplicia.ConditorAdiectivis;
import com.structorverba.officia.inventores.InventorAdiectivis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;

import lombok.Getter;

/**
 * Classis {@link Adiectivum} repraesentat adiect\u012Bva ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#NOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in scr\u012Bni\u014D
 * <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva. <br>
 * Discr\u012Bmina pr\u012Bm\u014Dria inter classibus h\u0101c classeque {@link Pronomen} est huius valor {@link #gradus}.
 * @see LectorMultiplicibus.LectorAdiectivis
 * @see TenorMultiplicibus.TenorAdiectivis
 * @see InventorAdiectivis
 * @see ConditorAdiectivis
 * @see Nuntius.NuntiusAdiectivorum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Adiectivum extends Nominalis <Adiectivum> {
  /**
   * Valor hic potentiam re\u012B huius d\u0113signat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @Getter(lazy = true)
  @NonNull private final Nuntius.NuntiusAdiectivorum nuntius = Nuntius.NuntiusAdiectivorum.fac.get();

  public Adiectivum(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                     @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                     @NonNull final Gradus gradus, @NonNull final String lemma,
                     @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }
}

