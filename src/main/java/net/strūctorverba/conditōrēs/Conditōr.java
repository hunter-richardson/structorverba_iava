package net.strūctorverba.conditōrēs;

import net.strūctorverba.mīscella.Omnum;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.Verbum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link Conditōr} data ā rēbus classis {@link Tenor} accipit eacumque rēs classis extentārum {@link Verbum}
 * cōnstruet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Conditōr <Hoc extends Verbum <Hoc>> extends Omnum {
  /**
   * Valor hic est vās classis {@link Nūntius} classī hui.
   */
  @NotNull protected final Nūntius nūntius;

  /**
   * Valor hic valōrem {@link Verbum#lemma} reī prōductae repraehentat.
   */
  @NotNull protected String lemma = StringUtils.EMPTY;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nts valōrem {@link #nūntius} supplet.
   */
  protected Conditōr(@NotNull final Supplier <@NotNull ? extends Nūntius> nts) {
    nūntius = nts.get();
  }

  /**
   * Modus hic valōrem {@link #lemma} indit.
   * @param fdmn valōrem indendum
   */
  public final void funde(@NotNull final String fdmn) {
    lemma = fdmn.trim();
  }

  /**
   * Modus hic rem classis {@link Hoc} cōnābitur cōnstruere.
   * @return Rem novam classis {@link Hoc}. <br> Modus hid valōrem {@code null} refert sī nōn valet valor aliquis rēs
   *   haec continet.
   */
  @Nullable public abstract Hoc condam( );
}
