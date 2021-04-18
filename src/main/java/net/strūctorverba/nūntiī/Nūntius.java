package net.strūctorverba.nūntiī;

import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.conditōrēs.multiplicia.*;
import net.strūctorverba.inventōrēs.*;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.tenōrēs.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.Singleton;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Nūntius {
  private final @NotNull Logger praecō;

  protected Nūntius(@NotNull final ParametrīNūntiī parametrī) {
    praecō = parametrī.praecōnium.get();
  }

  protected final void nūntiō(@NotNull final GradusNūntiī gradus, @Nullable final Object... nūntia) {
    if(GradusNūntiī.compareTo(gradus, GradusNūntiī.gradior(praecō.getLevel())) >= 0) {
      if(nūntia != null) {
        final StringBuilder strūctor = new StringBuilder();
        Stream.of(nūntia)
              .filter(Objects::nonNull)
              .filter(pars -> StringUtils.isNotBlank(pars.toString()))
              .forEachOrdered(pars -> strūctor.append(pars).append(' '));
        praecō.log(gradus.gressus, strūctor.toString());
      } else {
        praecō.log(gradus.gressus, StringUtils.EMPTY);
      }
    }
  }

  public final void terreō(@NotNull final Throwable error) {
    final StackTraceElement historia = Stream.of(error.getStackTrace())
                                             .filter(historicus -> historicus.getModuleName().contains(getClass().getModule().getName()))
                                             .findFirst().orElse(error.getStackTrace()[0]);
    praecō.throwing(historia.getClassName(), historia.getMethodName(), error);
    terreō("Fūnctiō", historia.getMethodName(), "classe",
           historia.getClassName(), "continātum est errōrem:",
           error.getClass().getSimpleName(), error.getMessage());
  }

  public final void terreō(@Nullable final Object... nūntia) {
    if(ArrayUtils.isEmpty(nūntia)) {
      Stream.of(nūntia)
            .filter(Objects::nonNull)
            .filter(pars -> pars instanceof Throwable)
            .forEach(pars -> terreō((Throwable) pars));
      nūntiō(GradusNūntiī.GRAVIS, Stream.of(nūntia)
                                        .filter(Objects::nonNull)
                                        .filter(pars -> !(pars instanceof Throwable))
                                        .filter(pars -> StringUtils.isNotBlank(pars.toString()))
                                        .toArray());
    } else {
      nūntiō(GradusNūntiī.GRAVIS);
    }
  }

  public final void notō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.PRAEGRESSŪRUS, nūntia);
  }

  public final void moneō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.PRAEMONITŌRIUS, nūntia);
  }

  public final void certiōrō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.ĪNFŌRMĀTĪVUS, nūntia);
  }

  @SuppressWarnings("unused")
  public final void garriō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.SCRŪTĀNS, nūntia);
  }

  @SuppressWarnings("unused")
  public final void plūsGarriō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.SCRŪTĀNTIOR, nūntia);
  }

  @SuppressWarnings("unused")
  public final void plūrimumGarriō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.SCRŪTĀNTISSIMUS, nūntia);
  }

  @SuppressWarnings("unused")
  public final void praeconor(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.OMNIS, nūntia);
  }

  @Singleton public static final class NūntiusTenōrīAdverbiīs extends Nūntius {
    private static @Nullable NūntiusTenōrīAdverbiīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīAdverbiīs());

    private NūntiusTenōrīAdverbiīs( ) {
      super(ParametrīNūntiī.parā(TenorSimplibus.TenorAdverbiīs.class));
    }
  }

  @Singleton public static final class NūntiusTenōrīConiūnctivīs extends Nūntius {
    private static @Nullable NūntiusTenōrīConiūnctivīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīConiūnctivīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīConiūnctivīs());

    private NūntiusTenōrīConiūnctivīs( ) {
      super(ParametrīNūntiī.parā(TenorSimplibus.TenorConiūnctivīs.class));
    }
  }

  @Singleton public static final class NūntiusTenōrīNōminibus extends Nūntius {
    private static @Nullable NūntiusTenōrīNōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīNōminibus());

    private NūntiusTenōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorNōminibus.class));
    }
  }

  @Singleton public static final class NūntiusTenōrīAdiectīvīs extends Nūntius {
    private static @Nullable NūntiusTenōrīAdiectīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīAdiectīvīs());

    private NūntiusTenōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorAdiectīvīs.class));
    }
  }

  @Singleton public static final class NūntiusTenōrīPrōnōminibus extends Nūntius {
    private static @Nullable NūntiusTenōrīPrōnōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīPrōnōminibus());

    private NūntiusTenōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorPrōnōminibus.class));
    }
  }

  @Singleton public static final class NūntiusTenōrīPrōnōmibusConiūnctīvīs extends Nūntius {
    private static @Nullable NūntiusTenōrīPrōnōmibusConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīPrōnōmibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīPrōnōmibusConiūnctīvīs());

    private NūntiusTenōrīPrōnōmibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs.class));
    }
  }

  @Singleton public static final class NūntiusTenōrīĀctīs extends Nūntius {
    private static @Nullable NūntiusTenōrīĀctīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusTenōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīĀctīs());

    private NūntiusTenōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorĀctīs.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīAdverbiīs extends Nūntius {
    private static @Nullable NūntiusConditōrīAdverbiīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīAdverbiīs());

    private NūntiusConditōrīAdverbiīs( ) {
      super(ParametrīNūntiī.parā(ConditōrSimplicibus.ConditōrAdverbiīs.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīConiūnctivīs extends Nūntius {
    private static @Nullable NūntiusConditōrīConiūnctivīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīConiūnctivīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīConiūnctivīs());

    private NūntiusConditōrīConiūnctivīs( ) {
      super(ParametrīNūntiī.parā(ConditōrSimplicibus.ConditōrConiūnctīvīs.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīNōminibus extends Nūntius {
    private static @Nullable NūntiusConditōrīNōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīNōminibus());

    private NūntiusConditōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(ConditōrNōminibus.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīAdiectīvīs extends Nūntius {
    private static @Nullable NūntiusConditōrīAdiectīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīAdiectīvīs());

    private NūntiusConditōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(ConditōrAdiectīvīs.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīPrōnōminibus extends Nūntius {
    private static @Nullable NūntiusConditōrīPrōnōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīPrōnōminibus());

    private NūntiusConditōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(ConditōrPrōnōminibus.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīPrōnōmibusConiūnctīvīs extends Nūntius {
    private static @Nullable NūntiusConditōrīPrōnōmibusConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīPrōnōmibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīPrōnōmibusConiūnctīvīs());

    private NūntiusConditōrīPrōnōmibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(ConditōrPrōnōminibusConiūnctīvīs.class));
    }
  }

  @Singleton public static final class NūntiusConditōrīĀctīs extends Nūntius {
    private static @Nullable NūntiusConditōrīĀctīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusConditōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīĀctīs());

    private NūntiusConditōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(ConditōrĀctīs.class));
    }
  }

  @Singleton public static final class NūntiusInventōrīNōminibus extends Nūntius {
    private static @Nullable NūntiusInventōrīNōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusInventōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīNōminibus());

    private NūntiusInventōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(InventorNōminibus.class));
    }
  }

  @Singleton public static final class NūntiusInventōrīAdiectīvīs extends Nūntius {
    private static @Nullable NūntiusInventōrīAdiectīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusInventōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīAdiectīvīs());

    private NūntiusInventōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(InventorAdiectīvīs.class));
    }
  }

  @Singleton public static final class NūntiusInventōrīPrōnōminibus extends Nūntius {
    private static @Nullable NūntiusInventōrīPrōnōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusInventōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīPrōnōminibus());

    private NūntiusInventōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(InventorPrōnōminibus.class));
    }
  }

  @Singleton public static final class NūntiusInventōrīPrōnōmibusConiūnctīvīs extends Nūntius {
    private static @Nullable NūntiusInventōrīPrōnōmibusConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusInventōrīPrōnōmibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīPrōnōmibusConiūnctīvīs());

    private NūntiusInventōrīPrōnōmibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(InventorPrōnōminibusConiūnctīvīs.class));
    }
  }

  @Singleton public static final class NūntiusInventōrīĀctīs extends Nūntius {
    private static @Nullable NūntiusInventōrīĀctīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusInventōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīĀctīs());

    private NūntiusInventōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(InventorĀctīs.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīAdverbiīs extends Nūntius {
    private static @Nullable NūntiusLēctōrīAdverbiīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīAdverbiīs());

    private NūntiusLēctōrīAdverbiīs( ) {
      super(ParametrīNūntiī.parā(LēctorSimplicibus.LēctorAdverbiīs.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīConiūnctīvīs extends Nūntius {
    private static @Nullable NūntiusLēctōrīConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīConiūnctīvīs());

    private NūntiusLēctōrīConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(LēctorSimplicibus.LēctorConiūnctīvīs.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīNōminibus extends Nūntius {
    private static @Nullable NūntiusLēctōrīNōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīNōminibus());

    private NūntiusLēctōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorNōminibus.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīAdiectīvīs extends Nūntius {
    private static @Nullable NūntiusLēctōrīAdiectīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīAdiectīvīs());

    private NūntiusLēctōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorAdiectīvīs.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīPrōnōminibus extends Nūntius {
    private static @Nullable NūntiusLēctōrīPrōnōminibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīPrōnōminibus());

    private NūntiusLēctōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorPrōnōminibus.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīPrōnōminibusConiūnctīvīs extends Nūntius {
    private static @Nullable NūntiusLēctōrīPrōnōminibusConiūnctīvīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīPrōnōminibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīPrōnōminibusConiūnctīvīs());

    private NūntiusLēctōrīPrōnōminibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīĀctīs extends Nūntius {
    private static @Nullable NūntiusLēctōrīĀctīs īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīĀctīs());

    private NūntiusLēctōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorĀctīs.class));
    }
  }

  @Singleton public static final class NūntiusLēctōrīPraepositiōnibus extends Nūntius {
    private static @Nullable NūntiusLēctōrīPraepositiōnibus īnstantia = null;

    public static final @NotNull Supplier <NūntiusLēctōrīPraepositiōnibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīPraepositiōnibus());

    private NūntiusLēctōrīPraepositiōnibus( ) {
      super(ParametrīNūntiī.parā(LēctorPraepositiōnibus.class));
    }
  }

  @Singleton public static final class NūntiusErrōribus extends Nūntius implements Thread.UncaughtExceptionHandler {
    private static @Nullable NūntiusErrōribus īnstantia = null;

    public static final @NotNull Supplier <NūntiusErrōribus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusErrōribus());

    protected NūntiusErrōribus( ) {
      super(ParametrīNūntiī.parā(NūntiusErrōribus.class));
    }

    public final @Override void uncaughtException(@NotNull final Thread līnea, @NotNull final Throwable error) {
      terreō(error);
    }
  }
}
