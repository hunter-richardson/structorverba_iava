package net.structorverba.bibliotheca.verba.multiplicia;

import net.structorverba.bibliotheca.miscella.Ūtilitās;
import net.structorverba.bibliotheca.verba.Verbum;
import net.structorverba.bibliotheca.enumerationes.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Nōminālis} verbum aliquem dēclīnātum repraesentat.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Nōminālis <Hoc extends VerbumMultiplex <Hoc>> extends VerbumMultiplex <Hoc> {
  /**
   * Valor hic dēsignat utrum rēs hae repraesentat certum necne.
   * @see Speciālitās
   */
  @NotNull public final Speciālitās speciālitās;

  /**
   * Valor hic generem reī huius dēsignat.
   * @see Genus
   */
  @NotNull public final Genus genus;

  /**
   * Valor hic cāsum reī huius dēsignat.
   * @see Cāsus
   */
  @NotNull public final Cāsus cāsus;

  /**
   * Valor hic numerum reī huius dēsignat.
   * @see Numerālis
   */
  @NotNull public final Numerālis numerālis;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param catēgoria  valōrem {@link Verbum#catēgoria} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @param lemma  valōrem {@link Verbum#lemma} indicat.
   * @param scrīptiō valōrem {@link #scrīptiō} indicat.
   */
  protected Nōminālis(@NotNull final Catēgoria catēgoria, @NotNull final Speciālitās spclt,
                      @NotNull final Genus gns, @NotNull final Cāsus css, @NotNull final Numerālis nmrl,
                      @NotNull final String lemma, @NotNull final String scrīptiō) {
    super(catēgoria, lemma, Speciālitās.PROPRIUM.equals(spclt) ? Ūtilitās.prīmamCapitāneamScrībō(scrīptiō)
                                                         : scrīptiō);
    speciālitās = spclt;
    genus = gns;
    cāsus = css;
    numerālis = nmrl;
  }
}
