package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Nōminālis <Hoc extends VerbumMultiplex <Hoc>> extends VerbumMultiplex <Hoc> {
  public final @NotNull Speciālitās speciālitās;
  public final @NotNull Genus       genus;
  public final @NotNull Cāsus       cāsus;
  public final @NotNull Numerāle    numerāle;

  public Nōminālis(@NotNull final Catēgoria ctgr, @NotNull final Speciālitās spclt,
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
