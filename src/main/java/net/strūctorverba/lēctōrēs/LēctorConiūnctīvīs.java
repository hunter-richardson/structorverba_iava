package net.strūctorverba.lēctōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorConiūnctivīs;
import net.strūctorverba.verba.VerbumSimplex;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.Supplier;

/**
 * Classis {@link LēctorConiūnctīvīs} est vās classis {@link Lēctor} classī {@link VerbumSimplex.Coniūnctīvum}.
 * @see Catēgoria#CONIŪNCTĪVUM
 * @see TenorConiūnctivīs
 * @see Nūntius.NūntiusLēctōrīConiūnctīvīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
@Singleton @DependsOn({ "TenorConiūnctivīs", "NūntiusLēctōrīConiūnctīvīs" })
public final class LēctorConiūnctīvīs extends Lēctor <VerbumSimplex.Coniūnctīvum> {
  @Nullable private static LēctorConiūnctīvīs īnstantia = null;

  /**
   * Valor hic viam reī classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <LēctorConiūnctīvīs> fac =
    () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorConiūnctīvīs());

  private LēctorConiūnctīvīs( ) {
    super(Catēgoria.CONIŪNCTĪVUM, Nūntius.NūntiusLēctōrīConiūnctīvīs.fac, TenorConiūnctivīs.fac);
    nūntius.plūrimumGarriō("Factus sum");
  }

  /**
   * Modus hic ūtitur modus {@link Lēctor#legam(String)} ut rem classis {@link VerbumSimplex.Coniūnctīvum} ā valōre {@link Lēctor#tenor} adveniat.
   * @param verbum fundāmen verbō quod rēs haec cōnābitur advenīre
   * @return Rem classis {@link VerbumSimplex.Coniūnctīvum} quam valōrem {@code verbum} quadrat. <br>
   * Modus hic valōrem {@code null} refert sī nihil quadrat valōrem {@code verbum}.
   */
  @Nullable public final VerbumSimplex.Coniūnctīvum adveniam(@NotNull final String verbum) {
    legam(verbum);
    final VerbumSimplex.Coniūnctīvum hoc = tenor.referō();
    if(hoc == null) {
      nūntius.moneō("Nihil advenī");
      return null;
    } else {
      nūntius.garriō("Advenī hoc:", hoc);
      return hoc;
    }
  }
}
