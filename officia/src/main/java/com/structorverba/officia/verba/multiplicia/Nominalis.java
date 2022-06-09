package com.structorverba.officia.verba.multiplicia;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;

/**
 * Classis {@link Nominalis} verbum aliquem d\u0113cl\u012Bn\u0101tum repraesentat.
 * @param <Hoc> Tabell\u0101 h\u0101c classis {@link Hoc} ext\u0113nsi\u014Dnem aptam dat\u012Bs pet\u012Bt\u012Bs repraesentat.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Nominalis <Hoc extends VerbumMultiplex <Hoc>> extends VerbumMultiplex <Hoc> {
  /**
   * Valor hic d\u0113signat utrum r\u0113s hae repraesentat certum necne.
   * @see Specialitas
   */
  @NonNull public final Specialitas specialitas;

  /**
   * Valor hic generem re\u012B huius d\u0113signat.
   * @see Genus
   */
  @NonNull public final Genus genus;

  /**
   * Valor hic c\u0101sum re\u012B huius d\u0113signat.
   * @see Casus
   */
  @NonNull public final Casus casus;

  /**
   * Valor hic numerum re\u012B huius d\u0113signat.
   * @see Numeralis
   */
  @NonNull public final Numeralis numeralis;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param categoria  val\u014Drem {@link Verbum#categoria} indicat.
   * @param spclt val\u014Drem {@link Nominalis#specialitas} indicat.
   * @param gns   val\u014Drem {@link Nominalis#genus} indicat.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @param nmrl  val\u014Drem {@link Nominalis#numeralis} indicat.
   * @param lemma  val\u014Drem {@link Verbum#lemma} indicat.
   * @param scriptio val\u014Drem {@link #scriptio} indicat.
   */
  protected Nominalis(@NonNull final Categoria categoria, @NonNull final Specialitas spclt,
                      @NonNull final Genus gns, @NonNull final Casus css, @NonNull final Numeralis nmrl,
                      @NonNull final String lemma, @NonNull final String scriptio) {
    super(categoria, lemma, Specialitas.PROPRIUM.equals(spclt) ? Utilitas.primamCapitaneamScribo(scriptio)
                                                               : scriptio);
    specialitas = spclt;
    genus = gns;
    casus = css;
    numeralis = nmrl;
  }
}
