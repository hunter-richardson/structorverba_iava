package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.verba.Verbum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class VerbumMultiplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  protected final @NotNull String     scrīptiō;
  protected       @NotNull Encliticum encliticum;

  protected VerbumMultiplex(@NotNull final Catēgoria ctgr, @NotNull final String fdmn, @NotNull final String scrpt) {
    super(ctgr, fdmn);
    scrīptiō = scrpt;
    encliticum = Encliticum.NŌLĒNS;
  }

  @SuppressWarnings("UnusedReturnValue")
  public @NotNull VerbumMultiplex <Hoc> allege(@NotNull final Encliticum cltm) {
    encliticum = cltm;
    return this;
  }

  public @Override @NotNull String toString( ) {
    return Encliticum.NŌLĒNS.equals(encliticum) ? scrīptiō
                                                : String.format("%s%s", scrīptiō, encliticum.scrīptiō);
  }
}
