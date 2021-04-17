package net.strūctorverba.conditōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Conditōr <Hoc extends Verbum <Hoc>> {
  protected final @NotNull Nūntius nūntius;
  protected       @NotNull String  fundāmen = StringUtils.EMPTY;

  protected Conditōr(@NotNull final Supplier <@NotNull ? extends Nūntius> nts) {
    nūntius = nts.get();
  }

  public final void funde(@NotNull final String fdmn) {
    fundāmen = fdmn.trim();
  }

  public abstract @Nullable Hoc condam( );
}
