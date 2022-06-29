package com.structorverba.officia.verba.multiplicia;

import com.structorverba.officia.conditores.multiplicia.ConditorNominibus;
import com.structorverba.officia.inventores.InventorNominibus;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;

import lombok.*;

/**
 * Classis {@link Nomen} repraesentat n\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#NOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/n\u014Dmina.
 * @see LectorMultiplicibus.LectorNominibus
 * @see TenorMultiplicibus.TenorNominibus
 * @see InventorNominibus
 * @see ConditorNominibus
 * @see Nuntius.NuntiusNominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Nomen extends Nominalis <Nomen> {
  /**
   * Valor hic tempus re\u012B huius d\u0113signat.
   * @see Modus
   */
  @NonNull public final Tempus tempus;

  @Getter(lazy = true)
  @NonNull private final Nuntius.NuntiusNominum nuntius = Nuntius.NuntiusNominum.fac.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Nomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                @NonNull final Tempus tempus, @NonNull final String lemma,
                @NonNull final String scriptio) {
    super(Categoria.NOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.tempus = tempus;
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }
}
