package net.strūctorverba.lēctōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorSimplibus;
import net.strūctorverba.verba.VerbumSimplex;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class LēctorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Lēctor <Hoc> {
  protected LēctorSimplicibus(@NotNull final Catēgoria catēgoria, @NotNull final Supplier <? extends Nūntius> nūntius,
                              @NotNull final Supplier <@NotNull ? extends TenorSimplibus <Hoc>> tenor) {
    super(catēgoria, nūntius, tenor);
  }

  public final @Nullable Hoc adveniam(@NotNull final String verbum) {
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

  @Singleton @DependsOn({ "TenorAdverbiīs", "NūntiusLēctōrīAdverbiīs" })
  public static final class LēctorAdverbiīs extends LēctorSimplicibus <VerbumSimplex.Adverbium> {
    private static @Nullable LēctorAdverbiīs īnstantia = null;

    public static final @NotNull Supplier <LēctorAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorAdverbiīs());

    private LēctorAdverbiīs( ) {
      super(Catēgoria.ADVERBIUM,
            Nūntius.NūntiusLēctōrīAdverbiīs.fac,
            TenorSimplibus.TenorAdverbiīs.fac);
    }
  }

  @Singleton @DependsOn({ "TenorConiūnctivīs", "NūntiusLēctōrīConiūnctīvīs" })
  public static final class LēctorConiūnctīvīs extends LēctorSimplicibus <VerbumSimplex.Coniūnctīvum> {
    private static @Nullable LēctorConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <LēctorConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new LēctorConiūnctīvīs());

    private LēctorConiūnctīvīs( ) {
      super(Catēgoria.CONIŪNCTĪVUM,
            Nūntius.NūntiusLēctōrīConiūnctīvīs.fac,
            TenorSimplibus.TenorConiūnctivīs.fac);
    }
  }
}
