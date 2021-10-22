package net.strūctorverba.tenōrēs;

import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import net.strūctorverba.verba.VerbumSimplex;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 * Classis {@link TenorSimplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link VerbumSimplex}
 * extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see ConditōrSimplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class TenorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Valor hic est vās classis {@link ConditōrSimplicibus} classī extentī huius.
   */
  @NotNull protected final ConditōrSimplicibus <@NotNull Hoc> condītōr;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nts   valōrem {@link Tenor#nūntius} supplet.
   * @param cndtr valōrem {@link #condītōr} supplet.
   */
  protected TenorSimplicibus(@NotNull final Supplier <@NotNull ? extends Nūntius> nts,
                             @NotNull final Supplier <@NotNull ? extends ConditōrSimplicibus <@NotNull Hoc>> cndtr) {
    super(nts);
    condītōr = cndtr.get();
  }

  /**
   * {@inheritDoc}
   */
  @Override protected final void fīniam( ) {
    hoc = condītōr.condam();
    if (Objects.isNull(hoc)) {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  /**
   * {@inheritDoc}
   * @param scrīptiō fōrmam scrīptam indendus
   * @see Verbum#lemma
   */
  @Override protected void scrībō(@NotNull String scrīptiō) {
    condītōr.funde(scrīptiō);
  }

  /**
   * Classis {@link TenorConiūnctivīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniūnctīvum}
   * @see VerbumSimplex.Coniūnctīvum
   * @see Nūntius.NūntiusTenōrīConiūnctivīs
   * @see ConditōrSimplicibus.ConditōrConiūnctīvīs
   */
  @Singleton
  @DependsOn({ "CondītōrConiūnctīvīs", "NūntiusTenōrīConiūnctivīs" })
  public static final class TenorConiūnctivīs extends TenorSimplicibus <VerbumSimplex.Coniūnctīvum> {
    @Nullable private static TenorConiūnctivīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <TenorConiūnctivīs> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorConiūnctivīs());

    private TenorConiūnctivīs( ) {
      super(Nūntius.NūntiusTenōrīConiūnctivīs.fac, ConditōrSimplicibus.ConditōrConiūnctīvīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }

  /**
   * Classis {@link TenorInteriectiōnibus} est vās classis {@link Tenor} classī {@link VerbumSimplex.Interiectiō}
   * @see VerbumSimplex.Interiectiō
   * @see Nūntius.NūntiusTenōrīInteriectiōnibus
   * @see ConditōrSimplicibus.ConditōrInteriectiōnibus
   */
  @Singleton
  @DependsOn({ "CondītōrConiūnctīvīs", "NūntiusTenōrīConiūnctivīs" })
  public static final class TenorInteriectiōnibus extends TenorSimplicibus <VerbumSimplex.Interiectiō> {
    @Nullable private static TenorInteriectiōnibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <TenorInteriectiōnibus> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorInteriectiōnibus());

    private TenorInteriectiōnibus( ) {
      super(Nūntius.NūntiusTenōrīInteriectiōnibus.fac, ConditōrSimplicibus.ConditōrInteriectiōnibus.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }
}
