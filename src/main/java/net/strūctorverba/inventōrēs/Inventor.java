package net.strūctorverba.inventōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Inventor <Hoc extends VerbumMultiplex <Hoc>> {
  protected final @NotNull Nūntius nūntius;

  protected Inventor(@NotNull final Supplier <? extends Nūntius> nts) {
    nūntius = nts.get();
  }

  public final @NotNull Inventor <Hoc> allegō(@NotNull final Enum <@NotNull ?>... illa) {
    Arrays.stream(illa).forEach(this::allegam);
    return this;
  }

  public abstract @NotNull Predicate <@NotNull Hoc> inquīram( );

  public abstract void restituō( );

  protected abstract void allegam(final Enum <@NotNull ?> illud);
}