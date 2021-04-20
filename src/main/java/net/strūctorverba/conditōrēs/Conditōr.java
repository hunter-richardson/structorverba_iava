package net.strūctorverba.conditōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.Verbum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link Conditōr} data ā rēbus classis {@link Tenor} accipit et eacum rēs classis extentārum {@link Verbum} cōnstruet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Conditōr <Hoc extends Verbum <Hoc>> {
  /**
   * Valor hic est vās classis {@link Nūntius} classī hui.
   */
  protected final @NotNull Nūntius nūntius;

  /**
   * Valor hic valōrem {@link Verbum#fundāmen} reī prōductae repraehentat.
   */
  protected @NotNull String fundāmen = StringUtils.EMPTY;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nts valōrem {@link #nūntius} supplet.
   */
  protected Conditōr(@NotNull final Supplier <@NotNull ? extends Nūntius> nts) {
    nūntius = nts.get();
  }

  /**
   * Modus hic valōrem {@link #fundāmen} indit.
   * @param fdmn valōrem indendum
   */
  public final void funde(@NotNull final String fdmn) {
    fundāmen = fdmn.trim();
  }

  /**
   * Modus hic rem classis {@link Hoc} cōnābitur cōnstruere.
   * @return Rem novam classis {@link Hoc}
   */
  public abstract @Nullable Hoc condam( );
}
