package net.strūctorverba.conditōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class ConditōrSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Conditōr <Hoc> {
  protected final @NotNull Function <@NotNull String, @NotNull Hoc> cōnstrūctor;

  protected ConditōrSimplicibus(@NotNull final Supplier <@NotNull ? extends Nūntius> nūntius,
                                @NotNull final Function <@NotNull String, @NotNull Hoc> cnsrt) {
    super(nūntius);
    cōnstrūctor = cnsrt;
  }

  public final @Override @Nullable Hoc condam( ) {
    final Hoc hoc = StringUtils.isNotBlank(fundāmen) ? cōnstrūctor.apply(fundāmen)
                                                     : null;
    referō(hoc);
    return hoc;
  }

  protected abstract void referō(@Nullable final Hoc hoc);

  @Singleton @DependsOn("NūntiusInventōrīAdiectīvīs")
  public static final class ConditōrAdverbiīs extends ConditōrSimplicibus <VerbumSimplex.Adverbium> {
    private static ConditōrAdverbiīs īnstantia = null;

    public static final @NotNull Supplier <ConditōrAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrAdverbiīs());

    private ConditōrAdverbiīs( ) {
      super(Nūntius.NūntiusConditōrīAdverbiīs.fac,
            fundāmen -> VerbumSimplex.Adverbium.conditōr().fundāmen(fundāmen).condam());
    }

    protected @Override void referō(@Nullable final VerbumSimplex.Adverbium hoc) {
      if (Objects.nonNull(hoc)) {
        nūntius.moneō(VerbumSimplex.Adverbium.class.getSimpleName().replace("um", "ī"),
                      "prōductiō fōrmae nūllae prōcessit.");
      } else {
        nūntius.certiōrō(VerbumSimplex.Adverbium.class.getSimpleName(), fundāmen, "fīnītur prōdūcere.");
      }
    }
  }

  @Singleton @DependsOn("NūntiusConditōrīAdverbiīs")
  public static final class ConditōrConiūnctīvīs extends ConditōrSimplicibus <VerbumSimplex.Coniūnctīvum> {
    private static @Nullable ConditōrConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <ConditōrConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new ConditōrConiūnctīvīs());

    private ConditōrConiūnctīvīs( ) {
      super(Nūntius.NūntiusConditōrīConiūnctivīs.fac,
            fundāmen -> VerbumSimplex.Coniūnctīvum.conditōr().fundāmen(fundāmen).condam());
    }

    protected @Override void referō(@Nullable final VerbumSimplex.Coniūnctīvum hoc) {
      if (Objects.nonNull(hoc)) {
        nūntius.moneō(VerbumSimplex.Coniūnctīvum.class.getSimpleName().replace("um", "ī"),
                      "prōductiō fōrmae nūllae prōcessit.");
      } else {
        nūntius.certiōrō(VerbumSimplex.Coniūnctīvum.class.getSimpleName(), fundāmen, "fīnītur prōdūcere.");
      }
    }
  }
}
