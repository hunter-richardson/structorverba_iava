package net.structorverba.bibliotheca.conditores;

import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.tenores.Tenor;
import net.structorverba.bibliotheca.verba.VerbumSimplex;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 * Classis {@link ConditōrSimplicibus} est vās classis {@link Conditōr} classibus omnibus quibus classem {@link
 * VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class ConditōrSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Conditōr <Hoc> {
  /**
   * Valor hic viam reī classis {@link Hoc} facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">Function</a>
   */
  @NotNull protected final Function <@NotNull String, @NotNull Hoc> cōnstrūctor;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param nts   valōrem {@link Conditōr#nūntius} supplet.
   * @param cnstr valōrem {@link #cōnstrūctor} supplet.
   */
  protected ConditōrSimplicibus(@NotNull final Supplier <@NotNull ? extends Nūntius> nts,
                                @NotNull final Function <@NotNull String, @NotNull Hoc> cnstr) {
    super(nts);
    cōnstrūctor = cnstr;
  }

  /**
   * {@inheritDoc}
   */
  @Override @Nullable
  public final Hoc condam( ) {
    final Hoc hoc = StringUtils.isNotBlank(lemma) ? cōnstrūctor.apply(lemma)
                                                  : null;
    referō(hoc);
    return hoc;
  }

  /**
   * Modus hic rem classis {@link Hoc} accipit valōrīque {@link Conditōr#nūntius} ita refert.
   * @param hoc rem tentanda
   */
  protected abstract void referō(@Nullable final Hoc hoc);

  /**
   * Classis {@link ConditōrConiūnctīvīs} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniūnctīvum}.
   * @see VerbumSimplex.Coniūnctīvum
   * @see Nūntius.NūntiusConditōrīConiūnctivīs
   */
  @Singleton
  @DependsOn("NūntiusConditōrīAdverbiīs")
  public static final class ConditōrConiūnctīvīs extends ConditōrSimplicibus <VerbumSimplex.Coniūnctīvum> {
    @Nullable private static ConditōrConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <ConditōrConiūnctīvīs> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrConiūnctīvīs());

    private ConditōrConiūnctīvīs( ) {
      super(Nūntius.NūntiusConditōrīConiūnctivīs.fac, VerbumSimplex.Coniūnctīvum::new);
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * Modus hic rem classis {@link VerbumSimplex.Coniūnctīvum} accipit valōrīque {@link ConditōrConiūnctīvīs#nūntius}
     * ita refert.
     * @param hoc rem tentanda
     */
    protected void referō(@Nullable final VerbumSimplex.Coniūnctīvum hoc) {
      if (Objects.isNull(hoc)) {
        nūntius.certiōrō(VerbumSimplex.Coniūnctīvum.class.getSimpleName(), lemma, "fīnītur prōdūcere.");
      } else {
        nūntius.moneō(VerbumSimplex.Coniūnctīvum.class.getSimpleName().replace("um", "ī"),
                      "prōductiō fōrmae nūllae prōcessit.");
      }
    }
  }

  /**
   * Classis {@link ConditōrInteriectiōnibus} est vās classis {@link Tenor} classī {@link VerbumSimplex.Interiectiō}.
   * @see VerbumSimplex.Interiectiō
   * @see Nūntius.NūntiusConditōrīInteriectiōnibus
   */
  @Singleton
  @DependsOn("NūntiusConditōrīAdverbiīs")
  public static final class ConditōrInteriectiōnibus extends ConditōrSimplicibus <VerbumSimplex.Interiectiō> {
    @Nullable private static ConditōrInteriectiōnibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <ConditōrInteriectiōnibus> fac =
      ( ) -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrInteriectiōnibus());

    private ConditōrInteriectiōnibus( ) {
      super(Nūntius.NūntiusConditōrīInteriectiōnibus.fac, VerbumSimplex.Interiectiō::new);
      nūntius.plūrimumGarriō("Factus sum");
    }

    /**
     * Modus hic rem classis {@link VerbumSimplex.Coniūnctīvum} accipit valōrīque {@link Conditōr#nūntius} ita refert.
     * @param hoc rem tentanda
     */
    protected void referō(@Nullable final VerbumSimplex.Interiectiō hoc) {
      if (Objects.isNull(hoc)) {
        nūntius.certiōrō(VerbumSimplex.Interiectiō.class.getSimpleName(), lemma, "fīnītur prōdūcere.");
      } else {
        nūntius.moneō(VerbumSimplex.Interiectiō.class.getSimpleName().replace("um", "ī"),
                      "prōductiō fōrmae nūllae prōcessit.");
      }
    }
  }
}
