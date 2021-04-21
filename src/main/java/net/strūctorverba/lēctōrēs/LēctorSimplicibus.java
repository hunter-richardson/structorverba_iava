package net.strūctorverba.lēctōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorSimplicibus;
import net.strūctorverba.verba.VerbumSimplex;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.Supplier;

/**
 * Classis {@link LēctorSimplicibus} est vās classis {@link Lēctor} classibus omnibus quibus classem {@link VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see TenorSimplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class LēctorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Lēctor <Hoc> {
  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param catēgoria valōrem {@link Lēctor#catēgoria} indicat.
   * @param nūntius valōrem {@link Lēctor#nūntius} supplet.
   * @param tenor valōrem {@link Lēctor#tenor} supplet.
   */
  protected LēctorSimplicibus(@NotNull final Catēgoria catēgoria, @NotNull final Supplier <? extends Nūntius> nūntius,
                              @NotNull final Supplier <@NotNull ? extends TenorSimplicibus <Hoc>> tenor) {
    super(catēgoria, nūntius, tenor);
  }

  /**
   * Modus hic ūtitur modus {@link Lēctor#legam(String)} rem classis {@link Hoc} ā valōre {@link Lēctor#tenor} advenīre.
   * @param verbum fundāmen verbō quod rēs haec cōnābitur advenīre
   * @return Rem classis {@link Hoc} quam valōrem {@code verbum} quadrat. <br>
   * Modus hic valōrem {@code null} refert sī nihil quadrat valōrem {@code verbum}.
   */
  @Nullable public final Hoc adveniam(@NotNull final String verbum) {
    legam(verbum);
    final Hoc hoc = tenor.referō();
    if(hoc == null) {
      nūntius.moneō("Nihil advenī");
      return null;
    } else {
      nūntius.garriō("Advenī hoc:", hoc);
      return hoc;
    }
  }

  /**
   * Classis {@link LēctorConiūnctīvīs} est vās classis {@link Lēctor} classī {@link VerbumSimplex.Coniūnctīvum}.
   * @see Catēgoria#CONIŪNCTĪVUM
   * @see TenorSimplicibus.TenorConiūnctivīs
   * @see Nūntius.NūntiusLēctōrīConiūnctīvīs
   */
  @Singleton @DependsOn({ "TenorConiūnctivīs", "NūntiusLēctōrīConiūnctīvīs" })
  public static final class LēctorConiūnctīvīs extends LēctorSimplicibus <VerbumSimplex.Coniūnctīvum> {
    @Nullable private static LēctorConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <LēctorConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorConiūnctīvīs());

    private LēctorConiūnctīvīs( ) {
      super(Catēgoria.CONIŪNCTĪVUM, Nūntius.NūntiusLēctōrīConiūnctīvīs.fac, TenorSimplicibus.TenorConiūnctivīs.fac);
      nūntius.plūrimumGarriō("Factus sum");
    }
  }
}
