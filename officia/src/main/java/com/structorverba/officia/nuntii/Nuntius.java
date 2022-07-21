package com.structorverba.officia.nuntii;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.Constructor;
import com.structorverba.officia.verba.multiplicia.*;
import com.structorverba.officia.verba.simplicia.*;
import jakarta.ejb.Singleton;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.Stream;


/**
 * Classis {@link Nuntius} nūntia dē exsecūtiōne programmātis StrūctorVerba in scāpīs LOG scrībit. <br>
 * Classēs plūrimae aliae in programmātem StrūctorVerba rem huius classis habet.
 * @see Omne
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Nuntius {
  @NonNull private final Gradus minimus;
  @NonNull private final Logger praeco;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param parametri Hic valor parametrōs ūsōs prō generātiōne organum internum huius reī continet.
   */
  protected Nuntius(@NonNull final ParametriNuntii parametri) {
    minimus = parametri.minimus;
    praeco = parametri.praeconium.get();
  }

  private void nuntio(@NonNull final Gradus gradus, @Nullable final Object... nuntia) {
    if (Gradus.compareTo(gradus, minimus) >= 0) {
      if (nuntia != null) {
        final StringBuilder structor = new StringBuilder();
        Stream.of(nuntia)
              .filter(Objects::nonNull)
              .filter(pars -> StringUtils.isNotBlank(pars.toString()))
              .forEachOrdered(pars -> structor.append(pars).append(' '));
        praeco.log(gradus.gressus.get(), structor.toString());
      } else {
        praeco.log(gradus.gressus.get(), StringUtils.EMPTY);
      }
    }
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūuctorVerba errōrem continuātur.
   * @param error error continuātus
   * @see #terreo(Object...)
   */
  public final void terreo(@NonNull final Throwable error) {
    final StackTraceElement historia = error.getStackTrace()[ 0 ];
    praeco.throwing(historia.getClassName(), historia.getMethodName(), error);
    terreo("Modus", historia.getMethodName(), "classe",
           historia.getClassName(), "continātu'st errorem:",
           error.getClass().getSimpleName(), error.getLocalizedMessage());
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam errōrem indicat.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#GRAVIS
   */
  public final void terreo(@Nullable final Object... nuntia) {
    if (ArrayUtils.isEmpty(nuntia)) {
      Stream.of(nuntia)
            .filter(Objects::nonNull)
            .filter(pars -> pars instanceof Throwable)
            .forEach(pars -> terreo((Throwable) pars));
      nuntio(Gradus.GRAVIS, Stream.of(nuntia)
                                        .filter(Objects::nonNull)
                                        .filter(pars -> !(pars instanceof Throwable))
                                        .filter(pars -> StringUtils.isNotBlank(pars.toString()))
                                        .toArray());
    } else {
      nuntio(Gradus.GRAVIS);
    }
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam auctōribus
   * programmātis intersit.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#PRAEGRESSURUS
   */
  public final void noto(@Nullable final Object... nuntia) {
    nuntio(Gradus.PRAEGRESSURUS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam errōrem addūcat.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#PRAEMONITORIUS
   */
  public final void moneo(@Nullable final Object... nuntia) {
    nuntio(Gradus.PRAEMONITORIUS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam ūsūfructuāriīs
   * programmātis intersit.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#INFORMATIVUS
   */
  public final void certioro(@Nullable final Object... nuntia) {
    nuntio(Gradus.INFORMATIVUS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam nēminī fortasse
   * intersit.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#SCRUTANS
   */
  public final void garrio(@Nullable final Object... nuntia) {
    nuntio(Gradus.SCRUTANS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam nēminī probābiliter
   * intersit.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#SAEPE_SCRUTANS
   */
  public final void plusGarrio(@Nullable final Object... nuntia) {
    nuntio(Gradus.SAEPE_SCRUTANS, nuntia);
  }

  /**
   * Hic modus persignat quod exsecūtiōnem programmātis StrūctorVerba continuātur condiciōnem quam nēminī certissime
   * intersit.
   * @param nuntia seriēs reī persignāre
   * @see Gradus#SEMPER_SCRUTANS
   */
  public final void plurimumGarrio(@Nullable final Object... nuntia) {
    nuntio(Gradus.SEMPER_SCRUTANS, nuntia);
  }

  /**
   * Haec ēnumerātiō persignat gravitātemque nūntiae singulārem et quam verbōsa rēs classis {@link Nuntius} scrībētur.
   * @see ParametriNuntii#minimus
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
   */
  @SuppressWarnings("unused")
  enum Gradus {
    /**
     * Hic valor indicat rem taciturna classis {@link Nuntius}.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a>
     */
    INERS(Level.OFF),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae errōrēs sōlum persignat.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a>
     */
    GRAVIS(Level.SEVERE),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae persignat errōrēs nūntiāsque quās errōrem addūcant.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a>
     */
    PRAEMONITORIUS(Level.WARNING),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās ūsūfructuāriīs programmātis intersit.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a>
     */
    INFORMATIVUS(Level.INFO),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās auctōribus programmātis intersit.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a>
     */
    PRAEGRESSURUS(Level.CONFIG),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās nēminī fortasse intersit.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a>
     */
    SCRUTANS(Level.FINE),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās nēminī probābiliter intersit.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a>
     */
    SAEPE_SCRUTANS(Level.FINER),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās nēminī certissime intersit.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a>
     */
    SEMPER_SCRUTANS(Level.FINEST),

    /**
     * Hic valor indicat rem classis {@link Nuntius} quae nūntiās omnēs persignat.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a>
     */
    OMNIS(Level.ALL);

    /**
     * Hic valor comparātiōnī rērum huius ēnumerātiōnis licet.
     */
    public final int praecellentia;
    /**
     * Hic modus societās intrā rēs huius ēnumerātiōnēs rēsque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
     * dēmōnstrat.
     * <ul>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a> valōrem {@link #INERS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a> valōrem {@link #GRAVIS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a> valōrem {@link #PRAEMONITORIUS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a> valōrem {@link #INFORMATIVUS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a> valōrem {@link #PRAEGRESSURUS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a> valōrem {@link #SCRUTANS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a> valōrem {@link #SAEPE_SCRUTANS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a> valōrem {@link #SEMPER_SCRUTANS} cōnsociat.</li>
     *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a> valōrem {@link #OMNIS} cōnsociat.</li>
     * </ul>
     */
    @NonNull public final Supplier <Level> gressus = () ->
            switch (this) {
              case INERS -> Level.OFF;
              case GRAVIS -> Level.SEVERE;
              case PRAEMONITORIUS -> Level.WARNING;
              case INFORMATIVUS -> Level.INFO;
              case PRAEGRESSURUS -> Level.CONFIG;
              case SCRUTANS -> Level.FINE;
              case SAEPE_SCRUTANS -> Level.FINER;
              case SEMPER_SCRUTANS -> Level.FINEST;
              case OMNIS -> Level.ALL;
            };

    Gradus(@NonNull final Level gressus) {
      praecellentia = gressus.intValue();
    }

    /**
     * Hic modus comparātiōnī intrā rēs ēnumerātiōnis huius classisque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
     * licet.
     * @param gressus valor tentandus
     * @return rēs ēnumerātiōnis huius quam valor {@code gressus} quadrat
     */
    @NonNull public static Gradus gradior(@NonNull final Level gressus) {
      return Stream.of(values())
                   .filter(gradus -> gradus.gressus.get().intValue() == gressus.intValue())
                   .findFirst().orElse(OMNIS);
    }

    /**
     * Hic modus comparātiōnī intrā rēs ēnumerātiōnis huius licet.
     * @param primus   valor tentandus
     * @param secundus valor tentandus
     * @return valor aut positīvus sī valor {@code primus} est maior quam valor {@code secundus} aut negātīvus sī valor
     *   {@code primus} est minor quam valor {@code secundus} aut nūllus sī valor {@code primus} est aequālis valōrī
     *   {@code secundus}
     */
    public static int compareTo(@NonNull final Gradus primus, @NonNull final Gradus secundus) {
      return Integer.compare(primus.praecellentia, secundus.praecellentia);
    }
  }

  /**
   * Classis {@link ParametriNuntii} valōrēs continet quōs rem classis {@link Nuntius} iuvat generāre.
   */
  static final class ParametriNuntii {
    /**
     * Hic valor incidat quam verbōsa haec rēs scrībētur.
     */
    @NonNull public final Nuntius.Gradus minimus = Nuntius.Gradus.OMNIS;
    /**
     * Hic valor viam reī classis <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
     * facit.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public final Supplier<Logger> praeconium;
    private final @NonNull String locus = "logs";

    private ParametriNuntii(@NonNull final Class <?> classis) {
      praeconium = () -> {
        //noinspection ConstantConditions
        final Logger praeco = Logger.getLogger(classis.getCanonicalName().replaceFirst(classis.getPackageName(), StringUtils.EMPTY));
        praeco.setParent(Logger.getGlobal());
        praeco.setUseParentHandlers(false);
        praeco.setLevel(minimus.gressus.get());

        StreamHandler tenor;
        try {
          if (StringUtils.isNotBlank(locus)) {
            tenor = new FileHandler(Paths.get(locus, String.format("%s.log", praeco.getName()))
                                         .toString(), true);
            tenor.setEncoding(Utilitas.LITTERAE.displayName());
          } else {
            tenor = new ConsoleHandler();
          }
        } catch (IOException e) {
          tenor = new ConsoleHandler();
        }

        tenor.setLevel(minimus.gressus.get());
        tenor.setFormatter(new Formatter() {
          @Override
          public String format(LogRecord eventus) {
            return String.format("%s %s <%s> %s%n", Temporis.formem(eventus.getMillis(), true),
                                 Nuntius.Gradus.gradior(eventus.getLevel()), eventus.getLoggerName(),
                                 eventus.getMessage());
          }
        });

        praeco.addHandler(tenor);
        return praeco;
      };
    }

    /**
     * @param classis classis apta
     * @return Rem novam huius classis
     */
    @NonNull public static ParametriNuntii para(@NonNull final Class <?> classis) {
      return new ParametriNuntii(classis);
    }
  }

  /**
   * Classis {@link Erroribus} est vās classis {@link Nuntius} ipsīusmet. <br> Indicat quod exsecūtiōnem
   * programmātis StrūctorVerba errōrem inopīnātum continuātur.
   * @see Omne
   * @see <a href="https://docs.oracle.com/javase/9/docs/api/java/lang/Thread.UncaughtExceptionHandler.html">Thread.UncaughtExceptionHandler</a>
   */
  @Singleton public static final class Erroribus extends Nuntius implements Thread.UncaughtExceptionHandler {
    @Nullable private static Erroribus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier<Erroribus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Erroribus());

    private Erroribus() {
      super(ParametriNuntii.para(Erroribus.class));
    }

    /**
     * Hic modus invocātur quandōque exsecūtiōnem programmātis StrūctorVerba errōrem inopīnātum continuātur.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.UncaughtExceptionHandler.html#uncaughtException(java.lang.Thread,%20java.lang.Throwable)">UncaughtExceptionHandler.uncaughtException</a>
     */
    public @Override void uncaughtException(@NonNull final Thread linea, @NonNull final Throwable error) {
      terreo(error);
    }
  }

  public static class Verbis {
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Nuntius> nuntius =
            categoria -> (Nuntius) switch (categoria) {
              case ACTUS       -> Actis.faciendum;
              case ADIECTIVUM  -> Adiectivis.faciendum;
              case ADVERBIUM   -> Adverbiis.faciendum;
              case NOMEN       -> Nominibus.faciendum;
              case PRONOMEN    -> Pronominibus.faciendum;
              case CONIUNCTIO  -> Coniunctionibus.faciendum;
              case INTERIECTIO -> Interiectionibus.faciendum;
              case PRAEPOSITIO -> Praepositionibus.faciendum;
              case NUMERUS     -> null;
            };

    /**
     * Classis {@link Coniunctionibus} est vās classis {@link Nuntius} classī {@link Coniunctio}}
     * @see Coniunctio
     */
    @Singleton public static final class Coniunctionibus extends Nuntius {
      @Nullable private static Coniunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Coniunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

      private Coniunctionibus() {
        super(ParametriNuntii.para(Coniunctio.class));
      }
    }

    /**
     * Classis {@link Interiectionibus} est vās classis {@link Nuntius} classī {@link Interiectio}}
     * @see Interiectio
     */
    @Singleton public static final class Interiectionibus extends Nuntius {
      @Nullable static Interiectionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static Supplier <Interiectionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

      private Interiectionibus() {
        super(ParametriNuntii.para(Interiectio.class));
      }
    }

    /**
     * Classis {@link Praepositionibus} est vās classis {@link Nuntius} classī {@link Praepositio}}
     * @see Praepositio
     */
    @Singleton public static final class Praepositionibus extends Nuntius {
      @Nullable static Praepositionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static Supplier <Praepositionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Praepositionibus());

      Praepositionibus() {
        super(ParametriNuntii.para(Praepositio.class));
      }
    }

    /**
     * Classis {@link Actis} est vās classis {@link Nuntius} classī {@link Actus}}
     * @see Actus
     */
    @Singleton public static final class Actis extends Nuntius {
      @Nullable private static Actis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Actis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

      private Actis() {
        super(ParametriNuntii.para(Actus.class));
      }
    }

    /**
     * Classis {@link Adiectivis} est vās classis {@link Nuntius} classī {@link Adiectivum}}
     * @see Adiectivum
     */
    @Singleton public static final class Adiectivis extends Nuntius {
      @Nullable private static Adiectivis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Adiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

      private Adiectivis() {
        super(ParametriNuntii.para(Actus.class));
      }
    }

    /**
     * Classis {@link Adverbiis} est vās classis {@link Nuntius} classī {@link Adverbium}
     * @see Adverbium
     */
    @Singleton public static final class Adverbiis extends Nuntius {
      @Nullable private static Adverbiis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Adverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

      private Adverbiis() {
        super(ParametriNuntii.para(Adverbium.class));
      }
    }

    /**
     * Classis {@link Nominibus} est vās classis {@link Nuntius} classī {@link Nomen}}
     * @see Nomen
     */
    @Singleton public static final class Nominibus extends Nuntius {
      @Nullable private static Nominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Nominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

      private Nominibus() {
        super(ParametriNuntii.para(Nomen.class));
      }
    }

    /**
     * Classis {@link Pronominibus} est vās classis {@link Nuntius} classī {@link Pronomen}}
     * @see Pronomen
     */
    @Singleton public static final class Pronominibus extends Nuntius {
      @Nullable private static Pronominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Pronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

      private Pronominibus() {
        super(ParametriNuntii.para(Pronomen.class));
      }
    }

    /**
     * Classis {@link Numeris} est vās classis {@link Nuntius} classī {@link Numerus}}
     * @see Numerus
     */
    @Singleton public static final class Numeris extends Nuntius {
      @Nullable static Numeris instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Numeris> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Numeris());

      Numeris() {
        super(ParametriNuntii.para(Numerus.class));
      }
    }
  }

  public static class Lectori {
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Nuntius> nuntius =
            categoria -> (Nuntius) switch (categoria) {
              case ACTUS       -> Actis.faciendum;
              case ADIECTIVUM  -> Adiectivis.faciendum;
              case ADVERBIUM   -> Adverbiis.faciendum;
              case NOMEN       -> Nominibus.faciendum;
              case PRONOMEN    -> Pronominibus.faciendum;
              case CONIUNCTIO  -> Coniunctionibus.faciendum;
              case INTERIECTIO -> Interiectionibus.faciendum;
              case PRAEPOSITIO -> Praepositionibus.faciendum;
              case NUMERUS     -> null;
            };

    /**
     * Classis {@link Coniunctionibus} est vās classis {@link Nuntius} classī {@link
     * Lector.Coniunctionibus}
     * @see Lector.Coniunctionibus
     */
    @Singleton public static final class Coniunctionibus extends Nuntius {
      @Nullable private static Coniunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Coniunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

      private Coniunctionibus() {
        super(ParametriNuntii.para(Lector.Coniunctionibus.class));
      }
    }

    /**
     * Classis {@link Interiectionibus} est vās classis {@link Nuntius} classī {@link
     * Lector.Coniunctionibus}
     *
     * @see Lector.Coniunctionibus
     */
    @Singleton public static final class Interiectionibus extends Nuntius {
      @Nullable
      private static Interiectionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       *
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Interiectionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

      private Interiectionibus() {
        super(ParametriNuntii.para(Lector.Interiectionibus.class));
      }
    }

    /**
     * Classis {@link Adverbiis} est vās classis {@link Nuntius} classī {@link Lector.Adverbiis}
     * @see Lector.Adverbiis
     */
    @Singleton public static final class Adverbiis extends Nuntius {
      @Nullable private static Adverbiis instantia = null;

      /**
       * Hic valor viam reīhuius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

      private Adverbiis() {
        super(ParametriNuntii.para(Lector.Adverbiis.class));
      }
    }

    /**
     * Classis {@link Nominibus} est vās classis {@link Nuntius} classī {@link
     * Lector.Nominibus}
     * @see Lector.Nominibus
     */
    @Singleton public static final class Nominibus extends Nuntius {
      @Nullable private static Nominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Nominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

      private Nominibus() {
        super(ParametriNuntii.para(Lector.Nominibus.class));
      }
    }

    /**
     * Classis {@link Adiectivis} est vās classis {@link Nuntius} classī {@link Lector.Adiectivis}
     * @see Lector.Adiectivis
     */
    @Singleton public static final class Adiectivis extends Nuntius {
      @Nullable private static Adiectivis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

      private Adiectivis() {
        super(ParametriNuntii.para(Lector.Adiectivis.class));
      }
    }

    /**
     * Classis {@link Pronominibus} est vās classis {@link Nuntius} classī {@link
     * Lector.Pronominibus}
     * @see Lector.Pronominibus
     */
    @Singleton public static final class Pronominibus extends Nuntius {
      @Nullable private static Pronominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Pronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

      private Pronominibus() {
        super(ParametriNuntii.para(Lector.Pronominibus.class));
      }
    }

    /**
     * Classis {@link Actis} est vās classis {@link Nuntius} classī {@link Lector.Actis}
     * @see Lector.Actis
     */
    @Singleton public static final class Actis extends Nuntius {
      @Nullable private static Actis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Actis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

      private Actis() {
        super(ParametriNuntii.para(Lector.Actis.class));
      }
    }

    /**
     * Classis {@link Praepositionibus} est vās classis {@link Nuntius} classī {@link Lector.Praepositionibus}
     * @see Lector.Praepositionibus
     */
    @Singleton public static final class Praepositionibus extends Nuntius {
      @Nullable private static Praepositionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Praepositionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Praepositionibus());

      private Praepositionibus() {
        super(ParametriNuntii.para(Lector.Praepositionibus.class));
      }
    }
  }

  public static class Curatori {
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Nuntius> nuntius =
            categoria -> (Nuntius) switch (categoria) {
              case ACTUS       -> Actis.faciendum;
              case ADIECTIVUM  -> Adiectivis.faciendum;
              case ADVERBIUM   -> Adverbiis.faciendum;
              case NOMEN       -> Nominibus.faciendum;
              case PRONOMEN    -> Pronominibus.faciendum;
              case CONIUNCTIO  -> Coniunctionibus.faciendum;
              case INTERIECTIO -> Interiectionibus.faciendum;
              default          -> null;
            };

    /**
     * Classis {@link Coniunctionibus} est vās classis {@link Nuntius} classī {@link Curator.Coniunctionibus}
     *
     * @see Curator.Coniunctionibus
     */
    @Singleton public static final class Coniunctionibus extends Nuntius {
      @Nullable
      private static Coniunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       *
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Coniunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

      private Coniunctionibus() {
        super(ParametriNuntii.para(Curator.Coniunctionibus.class));
      }
    }

    /**
     * Classis {@link Interiectionibus} est vās classis {@link Nuntius} classī {@link Curator.Interiectionibus}
     *
     * @see Curator.Interiectionibus
     */
    @Singleton public static final class Interiectionibus extends Nuntius {
      @Nullable
      private static Interiectionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       *
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Interiectionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

      private Interiectionibus() {
        super(ParametriNuntii.para(Curator.Interiectionibus.class));
      }
    }

    /**
     * Classis {@link Actis} est vās classis {@link Nuntius} classī {@link Curator.Actis}
     * @see Curator.Actis
     */
    @Singleton public static final class Actis extends Nuntius {
      @Nullable private static Actis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Actis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

      private Actis() {
        super(ParametriNuntii.para(Curator.Actis.class));
      }
    }

    /**
     * Classis {@link Adiectivis} est vās classis {@link Nuntius} classī {@link Curator.Adiectivis}
     * @see Curator.Adiectivis
     */
    @Singleton public static final class Adiectivis extends Nuntius {
      @Nullable private static Adiectivis instantia = null;

      /**
       * Hic valor viam rei huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

      private Adiectivis() {
        super(ParametriNuntii.para(Curator.Adiectivis.class));
      }
    }

    /**
     * Classis {@link Adverbiis} est vās classis {@link Nuntius} classī {@link Curator.Adverbiis}
     * @see Curator.Adverbiis
     */
    @Singleton public static final class Adverbiis extends Nuntius {
      @Nullable private static Adverbiis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

      private Adverbiis() {
        super(ParametriNuntii.para(Curator.Adverbiis.class));
      }
    }

    /**
     * Classis {@link Nominibus} est vās classis {@link Nuntius} classī {@link Curator.Nominibus}
     * @see Curator.Nominibus
     */
    @Singleton public static final class Nominibus extends Nuntius {
      @Nullable private static Nominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Nominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

      private Nominibus() {
        super(ParametriNuntii.para(Curator.Nominibus.class));
      }
    }

    /**
     * Classis {@link Pronominibus} est vās classis {@link Nuntius} classī {@link Curator.Pronominibus}
     * @see Curator.Pronominibus
     */
    @Singleton public static final class Pronominibus extends Nuntius {
      @Nullable private static Pronominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Pronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

      private Pronominibus() {
        super(ParametriNuntii.para(Curator.Pronominibus.class));
      }
    }

    /**
     * Classis {@link Numeris} est vās classis {@link Nuntius} classī {@link Curator.Numeris}
     * @see Curator.Numeris
     */
    @Singleton public static class Numeris extends Nuntius {
      @Nullable private static Numeris instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier<Numeris> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Numeris());

      private Numeris() {
        super(ParametriNuntii.para(Constructor.Numeri.class));
      }
    }
  }

  public static class Inventori {
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Nuntius> nuntius =
            categoria -> (Nuntius) switch (categoria) {
              case ACTUS       -> Actis.faciendum;
              case ADIECTIVUM  -> Adiectivis.faciendum;
              case ADVERBIUM   -> Adverbiis.faciendum;
              case NOMEN       -> Nominibus.faciendum;
              case PRONOMEN    -> Pronominibus.faciendum;
              default          -> null;
            };

    /**
     * Classis {@link Actis} est vās classis {@link Nuntius} classī {@link Inventor.Actis}
     * @see Inventor.Actis
     */
    @Singleton public static final class Actis extends Nuntius {
      @Nullable private static Actis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Actis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

      private Actis() {
        super(ParametriNuntii.para(Inventor.Actis.class));
      }
    }

    /**
     * Classis {@link Adverbiis} est vās classis {@link Nuntius} classī {@link Inventor.Nominibus}
     * @see Inventor.Nominibus
     */
    @Singleton public static final class Adverbiis extends Nuntius {
      @Nullable private static Adverbiis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

      private Adverbiis() {
        super(ParametriNuntii.para(Inventor.Adverbiis.class));
      }
    }

    /**
     * Classis {@link Adiectivis} est vās classis {@link Nuntius} classī {@link Inventor.Adiectivis}
     * @see Inventor.Adiectivis
     */
    @Singleton public static final class Adiectivis extends Nuntius {
      @Nullable private static Adiectivis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

      private Adiectivis() {
        super(ParametriNuntii.para(Inventor.Adiectivis.class));
      }
    }

    /**
     * Classis {@link Nominibus} est vās classis {@link Nuntius} classī {@link Inventor.Nominibus}
     * @see Inventor.Nominibus
     */
    @Singleton public static final class Nominibus extends Nuntius {
      @Nullable private static Nominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Nominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

      private Nominibus() {
        super(ParametriNuntii.para(Inventor.Nominibus.class));
      }
    }

    /**
     * Classis {@link Pronominibus} est vās classis {@link Nuntius} classī {@link Inventor.Pronominibus}
     * @see Inventor.Pronominibus
     */
    @Singleton public static final class Pronominibus extends Nuntius {
      @Nullable private static Pronominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Pronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

      private Pronominibus() {
        super(ParametriNuntii.para(Inventor.Pronominibus.class));
      }
    }
  }

  public static class Tenori {
    @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
    private static final Function<Categoria, Nuntius> nuntius =
            categoria -> (Nuntius) switch (categoria) {
              case ACTUS       -> Actis.faciendum;
              case ADIECTIVUM  -> Adiectivis.faciendum;
              case ADVERBIUM   -> Adverbiis.faciendum;
              case NOMEN       -> Nominibus.faciendum;
              case PRONOMEN    -> Pronominibus.faciendum;
              case CONIUNCTIO  -> Coniunctionibus.faciendum;
              case INTERIECTIO -> Interiectionibus.faciendum;
              default          -> null;
            };

    /**
     * Classis {@link Coniunctionibus} est vās classis {@link Nuntius} classī {@link
     * Tenor.Coniunctionibus}
     * @see Tenor.Coniunctionibus
     */
    @Singleton public static final class Coniunctionibus extends Nuntius {
      @Nullable private static Coniunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Coniunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

      private Coniunctionibus() {
        super(ParametriNuntii.para(Tenor.Coniunctionibus.class));
      }
    }

    /**
     * Classis {@link Interiectionibus} est vās classis {@link Nuntius} classī {@link Tenor.Interiectionibus}
     * @see Tenor.Interiectionibus
     */
    @Singleton public static final class Interiectionibus extends Nuntius {
      @Nullable private static Interiectionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Interiectionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

      private Interiectionibus() {
        super(ParametriNuntii.para(Tenor.Interiectionibus.class));
      }
    }

    /**
     * Classis {@link Adverbiis} est vās classis {@link Nuntius} classī {@link Tenor.Adverbiis}
     * @see Tenor.Adverbiis
     */
    @Singleton public static final class Adverbiis extends Nuntius {
      @Nullable private static Adverbiis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adverbiis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

      private Adverbiis() {
        super(ParametriNuntii.para(Tenor.Adverbiis.class));
      }
    }

    /**
     * Classis {@link Nominibus} est vās classis {@link Nuntius} classī {@link Tenor.Nominibus}
     * @see Tenor.Nominibus
     */
    @Singleton public static final class Nominibus extends Nuntius {
      @Nullable private static Nominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       * @see Tenor.Nominibus
       */
      @NonNull public static final Supplier <Nominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

      private Nominibus() {
        super(ParametriNuntii.para(Tenor.Nominibus.class));
      }
    }

    /**
     * Classis {@link Adiectivis} est vās classis {@link Nuntius} classī {@link Tenor.Adiectivis}
     * @see Tenor.Adiectivis
     */
    @Singleton public static final class Adiectivis extends Nuntius {
      @Nullable private static Adiectivis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Adiectivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

      private Adiectivis() {
        super(ParametriNuntii.para(Tenor.Adiectivis.class));
      }
    }

    /**
     * Classis {@link Pronominibus} est vās classis {@link Nuntius} classī {@link Tenor.Pronominibus}
     * @see Tenor.Pronominibus
     */
    @Singleton public static final class Pronominibus extends Nuntius {
      @Nullable private static Pronominibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Pronominibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

      private Pronominibus() {
        super(ParametriNuntii.para(Tenor.Pronominibus.class));
      }
    }

    /**
     * Classis {@link Actis} est vās classis {@link Nuntius} classī {@link Tenor.Actis}
     * @see Tenor.Actis
     */
    @Singleton public static final class Actis extends Nuntius {
      @Nullable private static Actis instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull public static final Supplier <Actis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

      private Actis() {
        super(ParametriNuntii.para(Tenor.Actis.class));
      }
    }
  }
}
