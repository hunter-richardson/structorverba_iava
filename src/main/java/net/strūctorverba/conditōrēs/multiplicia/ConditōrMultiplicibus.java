package net.strūctorverba.conditōrēs.multiplicia;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.conditōrēs.Conditōr;
import net.strūctorverba.verba.multiplicia.VerbumMultiplex;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link ConditōrMultiplicibus} est vās classis {@link Conditōr} classibus omnibus quibus classem {@link VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class ConditōrMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Conditōr <Hoc> {
  /**
   * Valor hic valōrem {@link VerbumMultiplex#scrīptiō} reī prōductae repraehentat.
   */
  @NotNull protected String scrīptiō = StringUtils.EMPTY;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nūntius valōrem {@link Conditōr#nūntius} supplet.
   */
  public ConditōrMultiplicibus(@NotNull final Supplier <@NotNull ? extends Nūntius> nūntius) {
    super(nūntius);
  }

  /**
   * Modus hic valōrem {@link #scrīptiō} indit.
   * @param scrpt valōrem indendum
   */
  public final void ut(@NotNull final String scrpt) {
    scrīptiō = scrpt;
    nūntius.garriō("Cōntrūctiōnī adiēcī conditiōnem novam: scrīptiō est", scrpt);
  }

  /**
   * Modus hic valōrem cognitum per valōre {@code nōmen} cum valōre {@code dēscrīptor} indit.
   * @param nōmen valōrem cognendum
   * @param dēscrīptor valōrem indendum
   */
  public abstract void allegō(@NotNull final String nōmen, @NotNull final String dēscrīptor);

  /**
   * Modus hic rem hanc restituit.
   */
  public abstract void restituō( );
}
