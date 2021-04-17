package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/*
 * Classis {@link Nōminālis} verbum aliquem dēclīnātum repraesentat.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Nōminālis <Hoc extends VerbumMultiplex <Hoc>> extends VerbumMultiplex <Hoc> {
  /**
   * Valor hic dēsignat sīve rēs hae repraesentat certa ({@link Speciālitās#PROPRIUM}) sīve incerta ({@link Speciālitās#COMMŪNE}).
   * @see Speciālitās
   */
  public final @NotNull Speciālitās speciālitās;
  
  /**
   * Valor hic generem eius dēsignat.
   * @see Genus
   */
  public final @NotNull Genus       genus;
  
  /**
   * Valor hic cāsum eius dēsignat.
   * @see Cāsus
   */
  public final @NotNull Cāsus       cāsus;
  
  /**
   * Valor hic numerum eius dēsignat.
   * @see Numerāle
   */
  public final @NotNull Numerāle    numerāle;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link Verbum#catēgoria} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns valōrem {@link Nōminālis#genus} indicat.
   * @param css valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl valōrem {@link Nōminālis#numerāle} indicat.
   * @param fdmn valōrem {@link Verbum#fundāmen} indicat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  protected Nōminālis(@NotNull final Catēgoria ctgr, @NotNull final Speciālitās spclt,
                      @NotNull final Genus gns, @NotNull final Cāsus css, @NotNull final Numerāle nmrl,
                      @NotNull final String fdmn, @NotNull final String scrpt) {
    super(ctgr, fdmn, Speciālitās.PROPRIUM.equals(spclt) ? Ūtilitās.prīmamCapitāneamScrībō(scrpt)
                                                         : scrpt);
    speciālitās = spclt;
    genus = gns;
    cāsus = css;
    numerāle = nmrl;
  }
}
