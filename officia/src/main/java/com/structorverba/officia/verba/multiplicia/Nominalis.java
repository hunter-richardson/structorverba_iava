package com.structorverba.officia.verba.multiplicia;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;

/**
 * Classis {@link Nominalis} verbum aliquem dēclīnātum repraesentat.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Nominalis <Hoc extends VerbumMultiplex <Hoc>> extends VerbumMultiplex <Hoc> {
  /**
   * Valor hic dēsignat utrum rēs hae repraesentat certum necne.
   * @see Specialitas
   */
  @NonNull public final Specialitas specialitas;

  /**
   * Valor hic generem reī huius dēsignat.
   * @see Genus
   */
  @NonNull public final Genus genus;

  /**
   * Valor hic cāsum reī huius dēsignat.
   * @see Casus
   */
  @NonNull public final Casus casus;

  /**
   * Valor hic numerum reī huius dēsignat.
   * @see Numeralis
   */
  @NonNull public final Numeralis numeralis;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param categoria  valōrem {@link Verbum#catagoria} indicat.
   * @param spclt valōrem {@link Nominalis#specialitas} indicat.
   * @param gns   valōrem {@link Nominalis#genus} indicat.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @param nmrl  valōrem {@link Nominalis#numeralis} indicat.
   * @param lemma  valōrem {@link Verbum#lemma} indicat.
   * @param scriptio valōrem {@link #scriptio} indicat.
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
