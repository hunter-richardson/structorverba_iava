package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class ConditōrMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Conditōr <Hoc> {
  protected @NotNull String scrīptiō = StringUtils.EMPTY;

  public ConditōrMultiplicibus(@NotNull final Supplier <@NotNull ? extends Nūntius> nūntius) {
    super(nūntius);
  }

  public final void ut(@NotNull final String scrpt) {
    scrīptiō = scrpt;
    nūntius.garriō("Cōntrūctiōnī adiēcī conditiōnem novam:", "scrīptiō est", scrpt);
  }

  public abstract void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor);

  public abstract void restituō( );
}
