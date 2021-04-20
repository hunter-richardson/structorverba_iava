package net.strūctorverba.conditōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.*;

/**
 * Classis {@link ConditōrSimplicibus} est vās classis {@link Conditōr} classibus omnibus quibus classem {@link VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class ConditōrSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Conditōr <Hoc> {
  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">Function</a>
   */
  @NotNull protected final Function <@NotNull String, @NotNull Hoc> cōnstrūctor;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nūntius valōrem {@link Conditōr#nūntius} supplet.
   * @param cnsrt valōrem {@link #cōnstrūctor} supplet.
   */
  protected ConditōrSimplicibus(@NotNull final Supplier <@NotNull ? extends Nūntius> nūntius,
                                @NotNull final Function <@NotNull String, @NotNull Hoc> cnsrt) {
    super(nūntius);
    cōnstrūctor = cnsrt;
  }

  /**
   * {@inheritDoc}
   */
  @Override @Nullable
  public final Hoc condam( ) {
    final Hoc hoc = StringUtils.isNotBlank(fundāmen) ? cōnstrūctor.apply(fundāmen)
                                                     : null;
    referō(hoc);
    return hoc;
  }

  /**
   * Modus hic rem classis {@link Hoc} accipit et valōrī {@link Conditōr#nūntius} ita refert.
   * @param hoc rem tentanda
   */
  protected abstract void referō(@Nullable final Hoc hoc);

  /**
   * Classis {@link ConditōrAdverbiīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Adverbium}.
   * @see VerbumSimplex.Adverbium
   * @see Nūntius.NūntiusConditōrīAdverbiīs
   */
  @Singleton @DependsOn("NūntiusInventōrīAdiectīvīs")
  public static final class ConditōrAdverbiīs extends ConditōrSimplicibus <VerbumSimplex.Adverbium> {
    @Nullable private static ConditōrAdverbiīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <ConditōrAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrAdverbiīs());

    private ConditōrAdverbiīs( ) {
      super(Nūntius.NūntiusConditōrīAdverbiīs.fac,
            fundāmen -> VerbumSimplex.Adverbium.conditōr().fundāmen(fundāmen).condam());
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * {@inheritDoc}
     */
    @Override protected void referō(@Nullable final VerbumSimplex.Adverbium hoc) {
      if (Objects.isNull(hoc)) {
        nūntius.moneō(VerbumSimplex.Adverbium.class.getSimpleName().replace("um", "ī"),
                      "prōductiō fōrmae nūllae prōcessit.");
      } else {
        nūntius.certiōrō(VerbumSimplex.Adverbium.class.getSimpleName(), fundāmen, "fīnītur prōdūcere.");
      }
    }
  }

  /**
   * Classis {@link ConditōrConiūnctīvīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniūnctīvum}.
   * @see VerbumSimplex.Coniūnctīvum
   * @see Nūntius.NūntiusConditōrīConiūnctivīs
   */
  @Singleton @DependsOn("NūntiusConditōrīAdverbiīs")
  public static final class ConditōrConiūnctīvīs extends ConditōrSimplicibus <VerbumSimplex.Coniūnctīvum> {
    @Nullable private static ConditōrConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <ConditōrConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrConiūnctīvīs());

    private ConditōrConiūnctīvīs( ) {
      super(Nūntius.NūntiusConditōrīConiūnctivīs.fac,
            fundāmen -> VerbumSimplex.Coniūnctīvum.conditōr().fundāmen(fundāmen).condam());
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * {@inheritDoc}
     */
    @Override protected void referō(@Nullable final VerbumSimplex.Coniūnctīvum hoc) {
      if (Objects.isNull(hoc)) {
        nūntius.certiōrō(VerbumSimplex.Coniūnctīvum.class.getSimpleName(), fundāmen, "fīnītur prōdūcere.");
      } else {
        nūntius.moneō(VerbumSimplex.Coniūnctīvum.class.getSimpleName().replace("um", "ī"),
                      "prōductiō fōrmae nūllae prōcessit.");
      }
    }
  }
}
