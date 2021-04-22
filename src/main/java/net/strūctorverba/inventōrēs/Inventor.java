package net.strūctorverba.inventōrēs;

import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.mīscella.Omnum;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.*;

/**
 * Classis {@link Inventor} cōlit rēs classis {@link VerbumMultiplex} quās rēs classis {@link TenorMultiplicibus} referat.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Inventor <Hoc extends VerbumMultiplex <Hoc>> extends Omnum {
  /**
   * Valor hic est vās classis {@link Nūntius} classī hui.
   */
  @NotNull protected final Nūntius nūntius;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nts valōrem {@link #nūntius} supplet.
   */
  protected Inventor(@NotNull final Supplier <? extends Nūntius> nts) {
    nūntius = nts.get();
  }

  /**
   * Modus hic seriem {@code illa} reī huic indit.
   * @param illa seriem ēnumerātiōnum indendam
   * @return Rem huius
   * @see #allegam(Enum)
   */
  @NotNull public final Inventor <Hoc> allegō(@NotNull final Enum <@NotNull ?>... illa) {
    Arrays.stream(illa).forEach(this::allegam);
    return this;
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LēctorMultiplicibus} ūtātur rēs classis {@link Hoc} percōlere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @NotNull public abstract Predicate <@NotNull Hoc> inquīram( );

  /**
   * Modus hic rem hanc restituit.
   */
  public abstract void restituō( );

  /**
   * Modus hic ēnumerātiōnem singulum {@code illud} reī huic indit.
   * @param illud ēnumerātiōnem indendam
   */
  protected abstract void allegam(final Enum <@NotNull ?> illud);
}