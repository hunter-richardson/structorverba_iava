package net.strūctorverba.tenōrēs;

import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link TenorSimplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see ConditōrSimplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class TenorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Valor hic est vās classis {@link ConditōrSimplicibus} classī extentī huius.
   */
  protected final @NotNull ConditōrSimplicibus <Hoc> condītōr;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nūntius valōrem {@link Tenor#nūntius} supplet.
   * @param cndtr valōrem {@link #condītōr} supplet.
   */
  protected TenorSimplicibus(@NotNull final Supplier <? extends Nūntius> nūntius,
                             @NotNull final Supplier <@NotNull ? extends ConditōrSimplicibus <Hoc>> cndtr) {
    super(nūntius);
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
   * @see Verbum#fundāmen
   */
  @Override protected void scrībō(@NotNull String scrīptiō) {
    condītōr.funde(scrīptiō);
  }

  /**
   * Classis {@link TenorAdverbiīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Adverbium}
   * @see VerbumSimplex.Adverbium
   * @see Nūntius.NūntiusTenōrīAdverbiīs
   * @see ConditōrSimplicibus.ConditōrAdverbiīs
   */
  @Singleton @DependsOn({ "CondītōrAdverbiīs", "NūntiusTenōrīAdverbiīs" })
  public static final class TenorAdverbiīs extends TenorSimplicibus <VerbumSimplex.Adverbium> {
    @Nullable private static TenorAdverbiīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <TenorAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorAdverbiīs());

    private TenorAdverbiīs( ) {
      super(Nūntius.NūntiusTenōrīAdverbiīs.fac, ConditōrSimplicibus.ConditōrAdverbiīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }

  /**
   * Classis {@link TenorConiūnctivīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniūnctīvum}
   * @see VerbumSimplex.Coniūnctīvum
   * @see Nūntius.NūntiusTenōrīConiūnctivīs
   * @see ConditōrSimplicibus.ConditōrConiūnctīvīs
   */
  @Singleton @DependsOn({ "CondītōrConiūnctīvīs", "NūntiusTenōrīConiūnctivīs" })
  public static final class TenorConiūnctivīs extends TenorSimplicibus <VerbumSimplex.Coniūnctīvum> {
    @Nullable private static TenorConiūnctivīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <TenorConiūnctivīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorConiūnctivīs());

    private TenorConiūnctivīs( ) {
      super(Nūntius.NūntiusTenōrīConiūnctivīs.fac, ConditōrSimplicibus.ConditōrConiūnctīvīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }
}
