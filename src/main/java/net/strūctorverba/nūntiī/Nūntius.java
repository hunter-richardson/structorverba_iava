package net.strūctorverba.nūntiī;

import net.strūctorverba.conditōrēs.ConditōrSimplicibus;
import net.strūctorverba.conditōrēs.multiplicia.*;
import net.strūctorverba.inventōrēs.*;
import net.strūctorverba.lēctōrēs.*;
import net.strūctorverba.tenōrēs.*;
import net.strūctorverba.verba.VerbumSimplex;
import net.strūctorverba.verba.disposita.VerbaPraepositiōne;
import net.strūctorverba.verba.multiplicia.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import javax.ejb.Singleton;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Classis {@link Nūntius} nūntia dē exsecūtiōne programmātis StrūctorVerba in scāpīs LOG scrībit. <br>
 * Classēs plūrimae aliae in programmātem StrūctorVerba rem classis huius habet.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Nūntius {
  @NotNull private final GradusNūntiī gradusMinimus;
  @NotNull private final Logger praecō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param parametrī continet parametrōs ūsōs organum internum reī huius generāre.
   */
  protected Nūntius(@NotNull final ParametrīNūntiī parametrī) {
    Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());
    gradusMinimus = parametrī.gradusMinimus;
    praecō = parametrī.praecōnium.get();
  }

  private void nūntiō(@NotNull final GradusNūntiī gradus, @Nullable final Object... nūntia) {
    if(GradusNūntiī.compareTo(gradus, gradusMinimus) >= 0) {
      if(nūntia != null) {
        final StringBuilder strūctor = new StringBuilder();
        Stream.of(nūntia)
              .filter(Objects::nonNull)
              .filter(pars -> StringUtils.isNotBlank(pars.toString()))
              .forEachOrdered(pars -> strūctor.append(pars).append(' '));
        praecō.log(gradus.gressus.get(), strūctor.toString());
      } else {
        praecō.log(gradus.gressus.get(), StringUtils.EMPTY);
      }
    }
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba errōrem continuātur.
   * @param error error continuātus
   * @see #terreō(Object...)
   */
  public final void terreō(@NotNull final Throwable error) {
    final StackTraceElement historia = Stream.of(error.getStackTrace())
                                             .filter(historicus -> historicus.getModuleName().contains(getClass().getModule().getName()))
                                             .findFirst().orElse(error.getStackTrace()[0]);
    praecō.throwing(historia.getClassName(), historia.getMethodName(), error);
    terreō("Modus", historia.getMethodName(), "classe",
           historia.getClassName(), "continātum est errōrem:",
           error.getClass().getSimpleName(), error.getMessage());
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam errōrem indicat.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#GRAVIS
   */
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

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam auctōribus programmātis intersit.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#PRAEGRESSŪRUS
   */
  public final void notō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.PRAEGRESSŪRUS, nūntia);
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam errōrem addūcat.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#PRAEMONITŌRIUS
   */
  public final void moneō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.PRAEMONITŌRIUS, nūntia);
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam ūsūfructuāriīs programmātis intersit.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#ĪNFŌRMĀTĪVUS
   */
  public final void certiōrō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.ĪNFŌRMĀTĪVUS, nūntia);
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam nēminī fortasse intersit.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#SCRŪTĀNS
   */
  @SuppressWarnings("unused")
  public final void garriō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.SCRŪTĀNS, nūntia);
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam nēminī probābiliter intersit.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#SCRŪTĀNTIOR
   */
  @SuppressWarnings("unused")
  public final void plūsGarriō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.SCRŪTĀNTIOR, nūntia);
  }

  /**
   * Modus hic persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem aliquam nēminī certissime intersit.
   * @param nūntia seriēs reī persignāre
   * @see GradusNūntiī#SCRŪTĀNTISSIMUS
   */
  @SuppressWarnings("unused")
  public final void plūrimumGarriō(@Nullable final Object... nūntia) {
    nūntiō(GradusNūntiī.SCRŪTĀNTISSIMUS, nūntia);
  }

  /**
   * Classis {@link NūntiusTenōrīAdverbiīs} est vās classis {@link Nūntius} classī {@link TenorSimplicibus.TenorAdverbiīs}
   * @see TenorSimplicibus.TenorAdverbiīs
   */
  @Singleton public static final class NūntiusTenōrīAdverbiīs extends Nūntius {
    @Nullable private static NūntiusTenōrīAdverbiīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusTenōrīAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīAdverbiīs());

    private NūntiusTenōrīAdverbiīs( ) {
      super(ParametrīNūntiī.parā(TenorSimplicibus.TenorAdverbiīs.class));
    }
  }

  /**
   * Classis {@link NūntiusTenōrīConiūnctivīs} est vās classis {@link Nūntius} classī {@link TenorSimplicibus.TenorConiūnctivīs}
   * @see TenorSimplicibus.TenorConiūnctivīs
   */
  @Singleton public static final class NūntiusTenōrīConiūnctivīs extends Nūntius {
    @Nullable private static NūntiusTenōrīConiūnctivīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusTenōrīConiūnctivīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīConiūnctivīs());

    private NūntiusTenōrīConiūnctivīs( ) {
      super(ParametrīNūntiī.parā(TenorSimplicibus.TenorConiūnctivīs.class));
    }
  }

  /**
   * Classis {@link NūntiusTenōrīNōminibus} est vās classis {@link Nūntius} classī {@link TenorMultiplicibus.TenorNōminibus}
   * @see TenorMultiplicibus.TenorNōminibus
   */
  @Singleton public static final class NūntiusTenōrīNōminibus extends Nūntius {
    @Nullable private static NūntiusTenōrīNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     * @see TenorMultiplicibus.TenorNōminibus
     */
    @NotNull public static final Supplier <NūntiusTenōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīNōminibus());

    private NūntiusTenōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorNōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusTenōrīAdiectīvīs} est vās classis {@link Nūntius} classī {@link TenorMultiplicibus.TenorAdiectīvīs}
   * @see TenorMultiplicibus.TenorAdiectīvīs
   */
  @Singleton public static final class NūntiusTenōrīAdiectīvīs extends Nūntius {
    @Nullable private static NūntiusTenōrīAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusTenōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīAdiectīvīs());

    private NūntiusTenōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorAdiectīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusTenōrīPrōnōminibus} est vās classis {@link Nūntius} classī {@link TenorMultiplicibus.TenorPrōnōminibus}
   * @see TenorMultiplicibus.TenorPrōnōminibus
   */
  @Singleton public static final class NūntiusTenōrīPrōnōminibus extends Nūntius {
    @Nullable private static NūntiusTenōrīPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusTenōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīPrōnōminibus());

    private NūntiusTenōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorPrōnōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusTenōrīPrōnōmibusConiūnctīvīs} est vās classis {@link Nūntius} classī {@link TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs}
   * @see TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs
   */
  @Singleton public static final class NūntiusTenōrīPrōnōmibusConiūnctīvīs extends Nūntius {
    @Nullable private static NūntiusTenōrīPrōnōmibusConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusTenōrīPrōnōmibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīPrōnōmibusConiūnctīvīs());

    private NūntiusTenōrīPrōnōmibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorPrōnōminibusConiūnctīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusTenōrīĀctīs} est vās classis {@link Nūntius} classī {@link TenorMultiplicibus.TenorĀctīs}
   * @see TenorMultiplicibus.TenorĀctīs
   */
  @Singleton public static final class NūntiusTenōrīĀctīs extends Nūntius {
    @Nullable private static NūntiusTenōrīĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusTenōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusTenōrīĀctīs());

    private NūntiusTenōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(TenorMultiplicibus.TenorĀctīs.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīAdverbiīs} est vās classis {@link Nūntius} classī {@link ConditōrSimplicibus.ConditōrAdverbiīs}
   * @see ConditōrSimplicibus.ConditōrAdverbiīs
   */
  @Singleton public static final class NūntiusConditōrīAdverbiīs extends Nūntius {
    @Nullable private static NūntiusConditōrīAdverbiīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīAdverbiīs());

    private NūntiusConditōrīAdverbiīs( ) {
      super(ParametrīNūntiī.parā(ConditōrSimplicibus.ConditōrAdverbiīs.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīConiūnctivīs} est vās classis {@link Nūntius} classī {@link ConditōrSimplicibus.ConditōrConiūnctīvīs}
   * @see ConditōrSimplicibus.ConditōrConiūnctīvīs
   */
  @Singleton public static final class NūntiusConditōrīConiūnctivīs extends Nūntius {
    @Nullable private static NūntiusConditōrīConiūnctivīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīConiūnctivīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīConiūnctivīs());

    private NūntiusConditōrīConiūnctivīs( ) {
      super(ParametrīNūntiī.parā(ConditōrSimplicibus.ConditōrConiūnctīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīNōminibus} est vās classis {@link Nūntius} classī {@link ConditōrNōminibus}
   * @see ConditōrNōminibus
   */
  @Singleton public static final class NūntiusConditōrīNōminibus extends Nūntius {
    @Nullable private static NūntiusConditōrīNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīNōminibus());

    private NūntiusConditōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(ConditōrNōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīAdiectīvīs} est vās classis {@link Nūntius} classī {@link ConditōrAdiectīvīs}
   * @see ConditōrAdiectīvīs
   */
  @Singleton public static final class NūntiusConditōrīAdiectīvīs extends Nūntius {
    @Nullable private static NūntiusConditōrīAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīAdiectīvīs());

    private NūntiusConditōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(ConditōrAdiectīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīPrōnōminibus} est vās classis {@link Nūntius} classī {@link ConditōrPrōnōminibus}
   * @see ConditōrPrōnōminibus
   */
  @Singleton public static final class NūntiusConditōrīPrōnōminibus extends Nūntius {
    @Nullable private static NūntiusConditōrīPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīPrōnōminibus());

    private NūntiusConditōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(ConditōrPrōnōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīPrōnōmibusConiūnctīvīs} est vās classis {@link Nūntius} classī {@link ConditōrPrōnōminibusConiūnctīvīs}
   * @see ConditōrPrōnōminibusConiūnctīvīs
   */
  @Singleton public static final class NūntiusConditōrīPrōnōmibusConiūnctīvīs extends Nūntius {
    @Nullable private static NūntiusConditōrīPrōnōmibusConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīPrōnōmibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīPrōnōmibusConiūnctīvīs());

    private NūntiusConditōrīPrōnōmibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(ConditōrPrōnōminibusConiūnctīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusConditōrīĀctīs} est vās classis {@link Nūntius} classī {@link ConditōrĀctīs}
   * @see ConditōrĀctīs
   */
  @Singleton public static final class NūntiusConditōrīĀctīs extends Nūntius {
    @Nullable private static NūntiusConditōrīĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusConditōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConditōrīĀctīs());

    private NūntiusConditōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(ConditōrĀctīs.class));
    }
  }

  /**
   * Classis {@link NūntiusInventōrīNōminibus} est vās classis {@link Nūntius} classī {@link InventorNōminibus}
   * @see InventorNōminibus
   */
  @Singleton public static final class NūntiusInventōrīNōminibus extends Nūntius {
    @Nullable private static NūntiusInventōrīNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusInventōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīNōminibus());

    private NūntiusInventōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(InventorNōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusInventōrīAdiectīvīs} est vās classis {@link Nūntius} classī {@link InventorAdiectīvīs}
   * @see InventorAdiectīvīs
   */
  @Singleton public static final class NūntiusInventōrīAdiectīvīs extends Nūntius {
    @Nullable private static NūntiusInventōrīAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusInventōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīAdiectīvīs());

    private NūntiusInventōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(InventorAdiectīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusInventōrīPrōnōminibus} est vās classis {@link Nūntius} classī {@link InventorPrōnōminibus}
   * @see InventorPrōnōminibus
   */
  @Singleton public static final class NūntiusInventōrīPrōnōminibus extends Nūntius {
    @Nullable private static NūntiusInventōrīPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusInventōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīPrōnōminibus());

    private NūntiusInventōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(InventorPrōnōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusInventōrīPrōnōmibusConiūnctīvīs} est vās classis {@link Nūntius} classī {@link InventorPrōnōminibusConiūnctīvīs}
   * @see InventorPrōnōminibusConiūnctīvīs
   */
  @Singleton public static final class NūntiusInventōrīPrōnōmibusConiūnctīvīs extends Nūntius {
    @Nullable private static NūntiusInventōrīPrōnōmibusConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusInventōrīPrōnōmibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīPrōnōmibusConiūnctīvīs());

    private NūntiusInventōrīPrōnōmibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(InventorPrōnōminibusConiūnctīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusInventōrīĀctīs} est vās classis {@link Nūntius} classī {@link InventorĀctīs}
   * @see InventorĀctīs
   */
  @Singleton public static final class NūntiusInventōrīĀctīs extends Nūntius {
    @Nullable private static NūntiusInventōrīĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusInventōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusInventōrīĀctīs());

    private NūntiusInventōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(InventorĀctīs.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīAdverbiīs} est vās classis {@link Nūntius} classī {@link LēctorSimplicibus.LēctorAdverbiīs}
   * @see LēctorSimplicibus.LēctorAdverbiīs
   */
  @Singleton public static final class NūntiusLēctōrīAdverbiīs extends Nūntius {
    @Nullable private static NūntiusLēctōrīAdverbiīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīAdverbiīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīAdverbiīs());

    private NūntiusLēctōrīAdverbiīs( ) {
      super(ParametrīNūntiī.parā(LēctorSimplicibus.LēctorAdverbiīs.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīConiūnctīvīs} est vās classis {@link Nūntius} classī {@link LēctorSimplicibus.LēctorConiūnctīvīs}
   * @see LēctorSimplicibus.LēctorConiūnctīvīs
   */
  @Singleton public static final class NūntiusLēctōrīConiūnctīvīs extends Nūntius {
    @Nullable private static NūntiusLēctōrīConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīConiūnctīvīs());

    private NūntiusLēctōrīConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(LēctorSimplicibus.LēctorConiūnctīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīNōminibus} est vās classis {@link Nūntius} classī {@link LēctorMultiplicibus.LēctorNōminibus}
   * @see LēctorMultiplicibus.LēctorNōminibus
   */
  @Singleton public static final class NūntiusLēctōrīNōminibus extends Nūntius {
    @Nullable private static NūntiusLēctōrīNōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīNōminibus());

    private NūntiusLēctōrīNōminibus( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorNōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīAdiectīvīs} est vās classis {@link Nūntius} classī {@link LēctorMultiplicibus.LēctorAdiectīvīs}
   * @see LēctorMultiplicibus.LēctorAdiectīvīs
   */
  @Singleton public static final class NūntiusLēctōrīAdiectīvīs extends Nūntius {
    @Nullable private static NūntiusLēctōrīAdiectīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīAdiectīvīs());

    private NūntiusLēctōrīAdiectīvīs( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorAdiectīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīPrōnōminibus} est vās classis {@link Nūntius} classī {@link LēctorMultiplicibus.LēctorPrōnōminibus}
   * @see LēctorMultiplicibus.LēctorPrōnōminibus
   */
  @Singleton public static final class NūntiusLēctōrīPrōnōminibus extends Nūntius {
    @Nullable private static NūntiusLēctōrīPrōnōminibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīPrōnōminibus());

    private NūntiusLēctōrīPrōnōminibus( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorPrōnōminibus.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīPrōnōminibusConiūnctīvīs} est vās classis {@link Nūntius} classī {@link LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs}
   * @see LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs
   */
  @Singleton public static final class NūntiusLēctōrīPrōnōminibusConiūnctīvīs extends Nūntius {
    @Nullable private static NūntiusLēctōrīPrōnōminibusConiūnctīvīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīPrōnōminibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīPrōnōminibusConiūnctīvīs());

    private NūntiusLēctōrīPrōnōminibusConiūnctīvīs( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorPrōnōminibusConiūnctīvīs.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīĀctīs} est vās classis {@link Nūntius} classī {@link LēctorMultiplicibus.LēctorĀctīs}
   * @see LēctorMultiplicibus.LēctorĀctīs
   */
  @Singleton public static final class NūntiusLēctōrīĀctīs extends Nūntius {
    @Nullable private static NūntiusLēctōrīĀctīs īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīĀctīs());

    private NūntiusLēctōrīĀctīs( ) {
      super(ParametrīNūntiī.parā(LēctorMultiplicibus.LēctorĀctīs.class));
    }
  }

  /**
   * Classis {@link NūntiusLēctōrīPraepositiōnibus} est vās classis {@link Nūntius} classī {@link LēctorPraepositiōnibus}
   * @see LēctorPraepositiōnibus
   */
  @Singleton public static final class NūntiusLēctōrīPraepositiōnibus extends Nūntius {
    @Nullable private static NūntiusLēctōrīPraepositiōnibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusLēctōrīPraepositiōnibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusLēctōrīPraepositiōnibus());

    private NūntiusLēctōrīPraepositiōnibus( ) {
      super(ParametrīNūntiī.parā(LēctorPraepositiōnibus.class));
    }
  }

  /**
   * Classis {@link NūntiusAdverbiōrum} est vās classis {@link Nūntius} classī {@link VerbumSimplex.Adverbium}
   * @see VerbumSimplex.Adverbium
   */
  @Singleton public static final class NūntiusAdverbiōrum extends Nūntius {
    @Nullable private static NūntiusAdverbiōrum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull Supplier<NūntiusAdverbiōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusAdverbiōrum());

    private NūntiusAdverbiōrum() {
      super(ParametrīNūntiī.parā(VerbumSimplex.Adverbium.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusConiūnctīvōrum} est vās classis {@link Nūntius} classī {@link VerbumSimplex.Coniūnctīvum}}
   * @see VerbumSimplex.Coniūnctīvum
   */
  @Singleton public static final class NūntiusConiūnctīvōrum extends Nūntius {
    @Nullable private static NūntiusConiūnctīvōrum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull Supplier<NūntiusConiūnctīvōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusConiūnctīvōrum());

    private NūntiusConiūnctīvōrum() {
      super(ParametrīNūntiī.parā(VerbumSimplex.Coniūnctīvum.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusPraepositiōnum} est vās classis {@link Nūntius} classī {@link VerbumSimplex.Praepositiō}}
   * @see VerbumSimplex.Praepositiō
   */
  @Singleton public static final class NūntiusPraepositiōnum extends Nūntius {
    @Nullable private static NūntiusPraepositiōnum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NotNull Supplier<NūntiusPraepositiōnum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusPraepositiōnum());

    private NūntiusPraepositiōnum( ) {
      super(ParametrīNūntiī.parā(VerbumSimplex.Praepositiō.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusNumerōrum} est vās classis {@link Nūntius} classī {@link VerbumSimplex.Numerus}}
   * @see VerbumSimplex.Numerus
   */
  @Singleton public static final class NūntiusNumerōrum extends Nūntius {
    @Nullable private static NūntiusNumerōrum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier<NūntiusNumerōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusNumerōrum());

    private NūntiusNumerōrum() {
      super(ParametrīNūntiī.parā(VerbumSimplex.Numerus.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusNōminum} est vās classis {@link Nūntius} classī {@link Nōmen}}
   * @see Nōmen
   */
  @Singleton public static final class NūntiusNōminum extends Nūntius {
    @Nullable private static NūntiusNōminum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusNōminum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusNōminum());

    private NūntiusNōminum( ) {
      super(ParametrīNūntiī.parā(Nōmen.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusAdiectīvōrum} est vās classis {@link Nūntius} classī {@link Adiectīvum}}
   * @see Adiectīvum
   */
  @Singleton public static final class NūntiusAdiectīvōrum extends Nūntius {
    @Nullable private static NūntiusAdiectīvōrum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusAdiectīvōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusAdiectīvōrum());

    private NūntiusAdiectīvōrum() {
      super(ParametrīNūntiī.parā(Āctum.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusPrōnōminum} est vās classis {@link Nūntius} classī {@link Prōnōmen}}
   * @see Prōnōmen
   */
  @Singleton public static final class NūntiusPrōnōminum extends Nūntius {
    @Nullable private static NūntiusPrōnōminum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusPrōnōminum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusPrōnōminum());

    private NūntiusPrōnōminum() {
      super(ParametrīNūntiī.parā(Prōnōmen.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusPrōnōminumConiūnctīvōrum} est vās classis {@link Nūntius} classī {@link PrōnōmenConiūnctīvum}}
   * @see PrōnōmenConiūnctīvum
   */
  @Singleton public static final class NūntiusPrōnōminumConiūnctīvōrum extends Nūntius {
    @Nullable private static NūntiusPrōnōminumConiūnctīvōrum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusPrōnōminumConiūnctīvōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusPrōnōminumConiūnctīvōrum());

    private NūntiusPrōnōminumConiūnctīvōrum() {
      super(ParametrīNūntiī.parā(PrōnōmenConiūnctīvum.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusĀctōrum} est vās classis {@link Nūntius} classī {@link Āctum}}
   * @see Āctum
   */
  @Singleton public static final class NūntiusĀctōrum extends Nūntius {
    @Nullable private static NūntiusĀctōrum īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier<NūntiusĀctōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusĀctōrum());

    private NūntiusĀctōrum( ) {
      super(ParametrīNūntiī.parā(Āctum.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusVerbōrumPraepositiōnibus} est vās classis {@link Nūntius} classī {@link VerbaPraepositiōne}}
   * @see VerbaPraepositiōne
   */
  public static final class NūntiusVerbōrumPraepositiōnibus extends Nūntius {
    @Nullable private static NūntiusVerbōrumPraepositiōnibus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusVerbōrumPraepositiōnibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusVerbōrumPraepositiōnibus());

    private NūntiusVerbōrumPraepositiōnibus() {
      super(ParametrīNūntiī.parā(VerbaPraepositiōne.Conditōr.class));
    }
  }

  /**
   * Classis {@link NūntiusErrōribus} est vās classis {@link Nūntius} ipsīusmet. <br>
   * Indicat quod exsecūtiōnem programmātis StrūctorVerba errōrem inopīnātum continuātur.
   * @see <a href="https://docs.oracle.com/javase/9/docs/api/java/lang/Thread.UncaughtExceptionHandler.html">Thread.UncaughtExceptionHandler</a>
   */
  @Singleton public static final class NūntiusErrōribus extends Nūntius implements Thread.UncaughtExceptionHandler {
    @Nullable private static NūntiusErrōribus īnstantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NotNull public static final Supplier <NūntiusErrōribus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusErrōribus());

    private NūntiusErrōribus( ) {
      super(ParametrīNūntiī.parā(NūntiusErrōribus.class));
    }

    /**
     * Modus hic invocātur quandōque exsecūtiōnem programmātis StrūctorVerba errōrem inopīnātum continuātur.
     */
    public final @Override void uncaughtException(@NotNull final Thread līnea, @NotNull final Throwable error) {
      terreō(error);
    }
  }
}
