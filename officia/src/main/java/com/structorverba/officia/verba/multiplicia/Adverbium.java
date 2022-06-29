package com.structorverba.officia.verba.multiplicia;

import com.structorverba.officia.conditores.multiplicia.ConditorAdverbiis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;

import lombok.*;

/**
 * Classis {@link Adverbium} repraesentat adverbia ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#ADVERBIUM} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bnio <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adverbia.
 * @see LectorMultiplicibus.LectorAdverbiis
 * @see TenorMultiplicibus.TenorAdverbiis
 * @see ConditorAdverbiis
 * @see Nuntius.NuntiusAdverbiorum
 */
@SuppressWarnings("SpellCheckingInspection")
public class Adverbium extends VerbumMultiplex <Adverbium> {
  /**
   * Valor hic potentiam re\u012B huius d\u0113signat.
   * @see Gradus
   */
  @NonNull public final Gradus gradus;
  @Getter(lazy = true)
  @NonNull private final Nuntius.NuntiusAdverbiorum nuntius = Nuntius.NuntiusAdverbiorum.fac.get();

  @Builder(access = AccessLevel.PUBLIC)
  private Adverbium(@NonNull final Gradus gradus, @NonNull final String lemma,
                    @NonNull final String scriptio) {
    super(Categoria.ADIECTIVUM, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scr\u012Bbor ut", scriptio);
  }
}
