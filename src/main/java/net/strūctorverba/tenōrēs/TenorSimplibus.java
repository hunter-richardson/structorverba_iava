package net.strūctorverba.tenōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.verba.VerbumSimplex;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class TenorSimplibus <Hoc extends VerbumSimplex <Hoc>> extends Tenor <Hoc> {
  protected final @NotNull ConditōrSimplicibus <Hoc> condītōr;

  public TenorSimplibus(@NotNull final Supplier <? extends Nūntius> nūntius,
                        @NotNull final Supplier <@NotNull ? extends ConditōrSimplicibus <Hoc>> cndtr) {
    super(nūntius);
    condītōr = cndtr.get();
  }

  protected final @Override void fīniam( ) {
    hoc = condītōr.condam();
    if (Objects.isNull(hoc)) {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  protected @Override void scrībō(@NotNull String scrīptiō) {
    condītōr.funde(scrīptiō);
  }

  @Singleton @DependsOn({ "CondītōrAdverbiīs", "NūntiusTenōrīAdverbiīs" })
  public static final class TenorAdverbiīs extends TenorSimplibus <VerbumSimplex.Adverbium> {
    private static @Nullable TenorAdverbiīs īnstantia = null;

    public static final @NotNull Supplier <TenorAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorAdverbiīs());

    private TenorAdverbiīs( ) {
      super(Nūntius.NūntiusTenōrīAdverbiīs.fac, ConditōrSimplicibus.ConditōrAdverbiīs.fac);
    }
  }

  @Singleton @DependsOn({ "CondītōrConiūnctīvīs", "NūntiusTenōrīConiūnctivīs" })
  public static final class TenorConiūnctivīs extends TenorSimplibus <VerbumSimplex.Coniūnctīvum> {
    private static @Nullable TenorConiūnctivīs īnstantia = null;

    public static final @NotNull Supplier <TenorConiūnctivīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorConiūnctivīs());

    private TenorConiūnctivīs( ) {
      super(Nūntius.NūntiusTenōrīConiūnctivīs.fac, ConditōrSimplicibus.ConditōrConiūnctīvīs.fac);
    }
  }
}
