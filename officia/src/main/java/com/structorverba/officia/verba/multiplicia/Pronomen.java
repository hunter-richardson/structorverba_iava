package com.structorverba.officia.verba.multiplicia;

import com.structorverba.officia.conditores.multiplicia.ConditorPronominibus;
import com.structorverba.officia.inventores.InventorPronominibus;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;

import lombok.Getter;

/**
 * Classis {@link Pronomen} repraesentat pr\u014Dn\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#PRONOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/pr\u014Dn\u014Dmina.
 * @see LectorMultiplicibus.LectorPronominibus
 * @see TenorMultiplicibus.TenorPronominibus
 * @see InventorPronominibus
 * @see ConditorPronominibus
 * @see Nuntius.NuntiusPronominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Pronomen extends Nominalis <Pronomen> {
  @Getter(lazy = true)
  @NonNull private final Nuntius.NuntiusPronominum nuntius = Nuntius.NuntiusPronominum.fac.get();

  public Pronomen(@NonNull final Specialitas specialitas, @NonNull final Genus genus,
                   @NonNull final Casus casus, @NonNull final Numeralis numeralis,
                   @NonNull final String lemma, @NonNull final String scriptio) {
    super(Categoria.PRONOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }
}
