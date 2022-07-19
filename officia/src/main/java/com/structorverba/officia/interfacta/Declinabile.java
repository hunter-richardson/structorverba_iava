package com.structorverba.officia.interfacta;

import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.enumerationes.*;

import androidx.annotation.NonNull;
import com.structorverba.officia.verba.multiplicia.*;

/**
 * Classis {@link Declinabile} verbum aliquem dēclīnātum repraesentat.
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see Adiectivum
 * @see Nomen
 * @see Pronomen
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Declinabile<Hoc extends Multiplex<Hoc>> extends Multiplex<Hoc> {
  /**
   * Hic valor dēsignat utrum haec rēs repraesentat certum necne.
   * @see Specialitas
   */
  @NonNull public final Specialitas specialitas;

  /**
   * Hic valor generem reī huius dēsignat.
   * @see Genus
   */
  @NonNull public final Genus genus;

  /**
   * Hic valor cāsum reī huius dēsignat.
   * @see Casus
   */
  @NonNull public final Casus casus;

  /**
   * Hic valor numerum reī huius dēsignat.
   * @see Numeralis
   */
  @NonNull public final Numeralis numeralis;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param categoria  valōrem {@link Verbum#catagoria} indicat.
   * @param spclt valōrem {@link Declinabile#specialitas} indicat.
   * @param gns   valōrem {@link Declinabile#genus} indicat.
   * @param css   valōrem {@link Declinabile#casus} indicat.
   * @param nmrl  valōrem {@link Declinabile#numeralis} indicat.
   * @param lemma  valōrem {@link Verbum#lemma} indicat.
   * @param scriptio valōrem {@link #scriptio} indicat.
   */
  protected Declinabile(@NonNull final Categoria categoria, @NonNull final Specialitas spclt,
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
