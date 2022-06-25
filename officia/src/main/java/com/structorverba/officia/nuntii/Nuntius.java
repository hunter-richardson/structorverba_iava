package com.structorverba.officia.nuntii;

import androidx.annotation.*;
import com.structorverba.officia.conditores.ConditorSimplicibus;
import com.structorverba.officia.conditores.multiplicia.*;
import com.structorverba.officia.inventores.*;
import com.structorverba.officia.lectores.*;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.tenores.*;
import com.structorverba.officia.verba.VerbumSimplex;
import com.structorverba.officia.verba.multiplicia.*;

import jakarta.ejb.Singleton;
import org.apache.commons.lang3.*;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;


/**
 * Classis {@link Nuntius} n\u016Bntia d\u0113 exsec\u016Bti\u014Dne programm\u0101tis Str\u016BctorVerba in sc\u0101p\u012Bs LOG scr\u012Bbit. <br>
 * Class\u0113s pl\u016Brimae aliae in programm\u0101tem Str\u016BctorVerba rem classis huius habet.
 * @see Omne
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Nuntius {
  @NonNull private final GradusNuntii gradusMinimus;
  @NonNull private final Logger       praeco;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param parametri Valor hic parametr\u014Ds \u016Bs\u014Ds pr\u014D gener\u0101ti\u014Dne organum internum re\u012B huius continet.
   */
  protected Nuntius(@NonNull final ParametriNuntii parametri) {
    gradusMinimus = parametri.gradusMinimus;
    praeco = parametri.praeconium.get();
  }

  private void nuntio(@NonNull final GradusNuntii gradus, @Nullable final Object... nuntia) {
    if (GradusNuntii.compareTo(gradus, gradusMinimus) >= 0) {
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
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BuctorVerba err\u014Drem continu\u0101tur.
   * @param error error continu\u0101tus
   * @see #terreo(Object...)
   */
  public final void terreo(@NonNull final Throwable error) {
    final StackTraceElement historia = error.getStackTrace()[ 0 ];
    praeco.throwing(historia.getClassName(), historia.getMethodName(), error);
    terreo("Modus", historia.getMethodName(), "classe",
           historia.getClassName(), "contin\u0101tu'st errorem:",
           error.getClass().getSimpleName(), error.getLocalizedMessage());
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam err\u014Drem indicat.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#GRAVIS
   */
  public final void terreo(@Nullable final Object... nuntia) {
    if (ArrayUtils.isEmpty(nuntia)) {
      Stream.of(nuntia)
            .filter(Objects::nonNull)
            .filter(pars -> pars instanceof Throwable)
            .forEach(pars -> terreo((Throwable) pars));
      nuntio(GradusNuntii.GRAVIS, Stream.of(nuntia)
                                        .filter(Objects::nonNull)
                                        .filter(pars -> !(pars instanceof Throwable))
                                        .filter(pars -> StringUtils.isNotBlank(pars.toString()))
                                        .toArray());
    } else {
      nuntio(GradusNuntii.GRAVIS);
    }
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam auct\u014Dribus
   * programm\u0101tis intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#PRAEGRESSURUS
   */
  public final void noto(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.PRAEGRESSURUS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam err\u014Drem add\u016Bcat.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#PRAEMONITORIUS
   */
  public final void moneo(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.PRAEMONITORIUS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam \u016Bs\u016Bfructu\u0101ri\u012Bs
   * programm\u0101tis intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#INFORMATIVUS
   */
  public final void certioro(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.INFORMATIVUS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam n\u0113min\u012B fortasse
   * intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#SCRUTANS
   */
  public final void garrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANS, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam n\u0113min\u012B prob\u0101biliter
   * intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#SCRUTANTIOR
   */
  public final void plusGarrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANTIOR, nuntia);
  }

  /**
   * Modus hic persignat quod exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba continu\u0101tur condici\u014Dnem quam n\u0113min\u012B certissime
   * intersit.
   * @param nuntia seri\u0113s re\u012B persign\u0101re
   * @see GradusNuntii#SCRUTANTISSIMUS
   */
  public final void plurimumGarrio(@Nullable final Object... nuntia) {
    nuntio(GradusNuntii.SCRUTANTISSIMUS, nuntia);
  }

  /**
   * Classis {@link NuntiusTenoriAdverbiis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorMultiplicibus.TenorAdverbiis}
   * @see TenorMultiplicibus.TenorAdverbiis
   */
  @Singleton
  public static final class NuntiusTenoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusTenoriAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusTenoriAdverbiis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriAdverbiis());

    private NuntiusTenoriAdverbiis() {
      super(ParametriNuntii.para(TenorMultiplicibus.TenorAdverbiis.class));
    }
  }

  /**
   * Classis {@link NuntiusTenoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorSimplicibus.TenorConiunctivis}
   * @see TenorSimplicibus.TenorConiunctivis
   */
  @Singleton
  public static final class NuntiusTenoriConiunctivis extends Nuntius {
    @Nullable private static NuntiusTenoriConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusTenoriConiunctivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriConiunctivis());

    private NuntiusTenoriConiunctivis() {
      super(ParametriNuntii.para(TenorSimplicibus.TenorConiunctivis.class));
    }
  }

  /**
   * Classis {@link NuntiusTenoriInteriectionibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorSimplicibus.TenorInteriectionibus}
   * @see TenorSimplicibus.TenorInteriectionibus
   */
  @Singleton
  public static final class NuntiusTenoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusTenoriInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusTenoriInteriectionibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriInteriectionibus());

    private NuntiusTenoriInteriectionibus() {
      super(ParametriNuntii.para(TenorSimplicibus.TenorInteriectionibus.class));
    }
  }

  /**
   * Classis {@link NuntiusTenoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorMultiplicibus.TenorNominibus}
   * @see TenorMultiplicibus.TenorNominibus
   */
  @Singleton
  public static final class NuntiusTenoriNominibus extends Nuntius {
    @Nullable private static NuntiusTenoriNominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     * @see TenorMultiplicibus.TenorNominibus
     */
    @NonNull public static final Supplier <NuntiusTenoriNominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriNominibus());

    private NuntiusTenoriNominibus() {
      super(ParametriNuntii.para(TenorMultiplicibus.TenorNominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusTenoriAdiectivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorMultiplicibus.TenorAdiectivis}
   * @see TenorMultiplicibus.TenorAdiectivis
   */
  @Singleton
  public static final class NuntiusTenoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusTenoriAdiectivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusTenoriAdiectivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriAdiectivis());

    private NuntiusTenoriAdiectivis() {
      super(ParametriNuntii.para(TenorMultiplicibus.TenorAdiectivis.class));
    }
  }

  /**
   * Classis {@link NuntiusTenoriPronominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorMultiplicibus.TenorPronominibus}
   * @see TenorMultiplicibus.TenorPronominibus
   */
  @Singleton
  public static final class NuntiusTenoriPronominibus extends Nuntius {
    @Nullable private static NuntiusTenoriPronominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusTenoriPronominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriPronominibus());

    private NuntiusTenoriPronominibus() {
      super(ParametriNuntii.para(TenorMultiplicibus.TenorPronominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusTenoriActis} est v\u0101s classis {@link Nuntius} class\u012B {@link TenorMultiplicibus.TenorActis}
   * @see TenorMultiplicibus.TenorActis
   */
  @Singleton
  public static final class NuntiusTenoriActis extends Nuntius {
    @Nullable private static NuntiusTenoriActis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusTenoriActis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriActis());

    private NuntiusTenoriActis() {
      super(ParametriNuntii.para(TenorMultiplicibus.TenorActis.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriAdverbiis} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorAdverbiis}
   * @see ConditorAdverbiis
   */
  @Singleton
  public static final class NuntiusConditoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusConditoriAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriAdverbiis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriAdverbiis());

    private NuntiusConditoriAdverbiis() {
      super(ParametriNuntii.para(ConditorAdverbiis.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * ConditorSimplicibus.ConditorConiunctivis}
   * @see ConditorSimplicibus.ConditorConiunctivis
   */
  @Singleton
  public static final class NuntiusConditoriConiunctivis extends Nuntius {
    @Nullable private static NuntiusConditoriConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriConiunctivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriConiunctivis());

    private NuntiusConditoriConiunctivis() {
      super(ParametriNuntii.para(ConditorSimplicibus.ConditorConiunctivis.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriInteriectionibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * ConditorSimplicibus.ConditorInteriectionibus}
   * @see ConditorSimplicibus.ConditorInteriectionibus
   */
  @Singleton
  public static final class NuntiusConditoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusConditoriInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriInteriectionibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriInteriectionibus());

    private NuntiusConditoriInteriectionibus() {
      super(ParametriNuntii.para(ConditorSimplicibus.ConditorInteriectionibus.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorNominibus}
   * @see ConditorNominibus
   */
  @Singleton
  public static final class NuntiusConditoriNominibus extends Nuntius {
    @Nullable private static NuntiusConditoriNominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriNominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriNominibus());

    private NuntiusConditoriNominibus() {
      super(ParametriNuntii.para(ConditorNominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriAdiectivis} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorAdiectivis}
   * @see ConditorAdiectivis
   */
  @Singleton
  public static final class NuntiusConditoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusConditoriAdiectivis instantia = null;

    /**
     * Valor hic viam rei classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriAdiectivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriAdiectivis());

    private NuntiusConditoriAdiectivis() {
      super(ParametriNuntii.para(ConditorAdiectivis.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriPronominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorPronominibus}
   * @see ConditorPronominibus
   */
  @Singleton
  public static final class NuntiusConditoriPronominibus extends Nuntius {
    @Nullable private static NuntiusConditoriPronominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriPronominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriPronominibus());

    private NuntiusConditoriPronominibus() {
      super(ParametriNuntii.para(ConditorPronominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusConditoriActis} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorActis}
   * @see ConditorActis
   */
  @Singleton
  public static final class NuntiusConditoriActis extends Nuntius {
    @Nullable private static NuntiusConditoriActis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusConditoriActis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriActis());

    private NuntiusConditoriActis() {
      super(ParametriNuntii.para(ConditorActis.class));
    }
  }

  /**
   * Classis {@link NuntiusInventoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorNominibus}
   * @see InventorNominibus
   */
  @Singleton
  public static final class NuntiusInventoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusInventoriAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusInventoriAdverbiis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriAdverbiis());

    private NuntiusInventoriAdverbiis() {
      super(ParametriNuntii.para(InventorAdverbiis.class));
    }
  }

  /**
   * Classis {@link NuntiusInventoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorNominibus}
   * @see InventorNominibus
   */
  @Singleton
  public static final class NuntiusInventoriNominibus extends Nuntius {
    @Nullable private static NuntiusInventoriNominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusInventoriNominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriNominibus());

    private NuntiusInventoriNominibus() {
      super(ParametriNuntii.para(InventorNominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusInventoriAdiectivis} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorAdiectivis}
   * @see InventorAdiectivis
   */
  @Singleton
  public static final class NuntiusInventoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusInventoriAdiectivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusInventoriAdiectivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriAdiectivis());

    private NuntiusInventoriAdiectivis() {
      super(ParametriNuntii.para(InventorAdiectivis.class));
    }
  }

  /**
   * Classis {@link NuntiusInventoriPronominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorPronominibus}
   * @see InventorPronominibus
   */
  @Singleton
  public static final class NuntiusInventoriPronominibus extends Nuntius {
    @Nullable private static NuntiusInventoriPronominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusInventoriPronominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriPronominibus());

    private NuntiusInventoriPronominibus() {
      super(ParametriNuntii.para(InventorPronominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusInventoriActis} est v\u0101s classis {@link Nuntius} class\u012B {@link InventorActis}
   * @see InventorActis
   */
  @Singleton
  public static final class NuntiusInventoriActis extends Nuntius {
    @Nullable private static NuntiusInventoriActis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusInventoriActis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInventoriActis());

    private NuntiusInventoriActis() {
      super(ParametriNuntii.para(InventorActis.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriAdverbiis} est v\u0101s classis {@link Nuntius} class\u012B {@link LectorMultiplicibus.LectorAdverbiis}
   * @see LectorMultiplicibus.LectorAdverbiis
   */
  @Singleton
  public static final class NuntiusLectoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusLectoriAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012Bclassis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriAdverbiis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriAdverbiis());

    private NuntiusLectoriAdverbiis() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorAdverbiis.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorSimplicibus.LectorConiunctivis}
   * @see LectorSimplicibus.LectorConiunctivis
   */
  @Singleton
  public static final class NuntiusLectoriConiunctivis extends Nuntius {
    @Nullable private static NuntiusLectoriConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriConiunctivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriConiunctivis());

    private NuntiusLectoriConiunctivis() {
      super(ParametriNuntii.para(LectorSimplicibus.LectorConiunctivis.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorSimplicibus.LectorConiunctivis}
   * @see LectorSimplicibus.LectorConiunctivis
   */
  @Singleton
  public static final class NuntiusLectoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusLectoriInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriInteriectionibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriInteriectionibus());

    private NuntiusLectoriInteriectionibus() {
      super(ParametriNuntii.para(LectorSimplicibus.LectorInteriectionibus.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorMultiplicibus.LectorNominibus}
   * @see LectorMultiplicibus.LectorNominibus
   */
  @Singleton
  public static final class NuntiusLectoriNominibus extends Nuntius {
    @Nullable private static NuntiusLectoriNominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriNominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriNominibus());

    private NuntiusLectoriNominibus() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorNominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriAdiectivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorMultiplicibus.LectorAdiectivis}
   * @see LectorMultiplicibus.LectorAdiectivis
   */
  @Singleton
  public static final class NuntiusLectoriAdiectivis extends Nuntius {
    @Nullable private static NuntiusLectoriAdiectivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriAdiectivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriAdiectivis());

    private NuntiusLectoriAdiectivis() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorAdiectivis.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriPronominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorMultiplicibus.LectorPronominibus}
   * @see LectorMultiplicibus.LectorPronominibus
   */
  @Singleton
  public static final class NuntiusLectoriPronominibus extends Nuntius {
    @Nullable private static NuntiusLectoriPronominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriPronominibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriPronominibus());

    private NuntiusLectoriPronominibus() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorPronominibus.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriActis} est v\u0101s classis {@link Nuntius} class\u012B {@link LectorMultiplicibus.LectorActis}
   * @see LectorMultiplicibus.LectorActis
   */
  @Singleton
  public static final class NuntiusLectoriActis extends Nuntius {
    @Nullable private static NuntiusLectoriActis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriActis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriActis());

    private NuntiusLectoriActis() {
      super(ParametriNuntii.para(LectorMultiplicibus.LectorActis.class));
    }
  }

  /**
   * Classis {@link NuntiusLectoriPraepositionibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorPraepositionibus}
   * @see LectorPraepositionibus
   */
  @Singleton
  public static final class NuntiusLectoriPraepositionibus extends Nuntius {
    @Nullable private static NuntiusLectoriPraepositionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusLectoriPraepositionibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriPraepositionibus());

    private NuntiusLectoriPraepositionibus() {
      super(ParametriNuntii.para(LectorPraepositionibus.class));
    }
  }

  /**
   * Classis {@link NuntiusAdverbiorum} est v\u0101s classis {@link Nuntius} class\u012B {@link Adverbium}
   * @see Adverbium
   */
  @Singleton
  public static final class NuntiusAdverbiorum extends Nuntius {
    @Nullable private static NuntiusAdverbiorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NonNull Supplier <NuntiusAdverbiorum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdverbiorum());

    private NuntiusAdverbiorum() {
      super(ParametriNuntii.para(Adverbium.class));
    }
  }

  /**
   * Classis {@link NuntiusConiunctivorum} est v\u0101s classis {@link Nuntius} class\u012B {@link VerbumSimplex.Coniunctivum}}
   * @see VerbumSimplex.Coniunctivum
   */
  @Singleton
  public static final class NuntiusConiunctivorum extends Nuntius {
    @Nullable private static NuntiusConiunctivorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NonNull Supplier <NuntiusConiunctivorum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConiunctivorum());

    private NuntiusConiunctivorum() {
      super(ParametriNuntii.para(VerbumSimplex.Coniunctivum.class));
    }
  }

  /**
   * Classis {@link NuntiusInteriectionum} est v\u0101s classis {@link Nuntius} class\u012B {@link VerbumSimplex.Interiectio}}
   * @see VerbumSimplex.Interiectio
   */
  @Singleton
  public static final class NuntiusInteriectionum extends Nuntius {
    @Nullable private static NuntiusInteriectionum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NonNull Supplier <NuntiusInteriectionum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInteriectionum());

    private NuntiusInteriectionum() {
      super(ParametriNuntii.para(VerbumSimplex.Interiectio.class));
    }
  }

  /**
   * Classis {@link NuntiusPraepositionum} est v\u0101s classis {@link Nuntius} class\u012B {@link VerbumSimplex.Praepositio}}
   * @see VerbumSimplex.Praepositio
   */
  @Singleton
  public static final class NuntiusPraepositionum extends Nuntius {
    @Nullable private static NuntiusPraepositionum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static @NonNull Supplier <NuntiusPraepositionum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusPraepositionum());

    private NuntiusPraepositionum() {
      super(ParametriNuntii.para(VerbumSimplex.Praepositio.class));
    }
  }

  /**
   * Classis {@link NuntiusNumerorum} est v\u0101s classis {@link Nuntius} class\u012B {@link VerbumSimplex.Numerus}}
   * @see VerbumSimplex.Numerus
   */
  @Singleton
  public static final class NuntiusNumerorum extends Nuntius {
    @Nullable private static NuntiusNumerorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusNumerorum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusNumerorum());

    private NuntiusNumerorum() {
      super(ParametriNuntii.para(VerbumSimplex.Numerus.class));
    }
  }

  /**
   * Classis {@link NuntiusNominum} est v\u0101s classis {@link Nuntius} class\u012B {@link Nomen}}
   * @see Nomen
   */
  @Singleton
  public static final class NuntiusNominum extends Nuntius {
    @Nullable private static NuntiusNominum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusNominum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusNominum());

    private NuntiusNominum() {
      super(ParametriNuntii.para(Nomen.class));
    }
  }

  /**
   * Classis {@link NuntiusAdiectivorum} est v\u0101s classis {@link Nuntius} class\u012B {@link Adiectivum}}
   * @see Adiectivum
   */
  @Singleton
  public static final class NuntiusAdiectivorum extends Nuntius {
    @Nullable private static NuntiusAdiectivorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusAdiectivorum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusAdiectivorum());

    private NuntiusAdiectivorum() {
      super(ParametriNuntii.para(Actus.class));
    }
  }

  /**
   * Classis {@link NuntiusPronominum} est v\u0101s classis {@link Nuntius} class\u012B {@link Pronomen}}
   * @see Pronomen
   */
  @Singleton
  public static final class NuntiusPronominum extends Nuntius {
    @Nullable private static NuntiusPronominum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusPronominum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusPronominum());

    private NuntiusPronominum() {
      super(ParametriNuntii.para(Pronomen.class));
    }
  }

  /**
   * Classis {@link NuntiusActorum} est v\u0101s classis {@link Nuntius} class\u012B {@link Actus}}
   * @see Actus
   */
  @Singleton
  public static final class NuntiusActorum extends Nuntius {
    @Nullable private static NuntiusActorum instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusActorum> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusActorum());

    private NuntiusActorum() {
      super(ParametriNuntii.para(Actus.class));
    }
  }

  /**
   * Classis {@link NuntiusErroribus} est v\u0101s classis {@link Nuntius} ips\u012Busmet. <br> Indicat quod exsec\u016Bti\u014Dnem
   * programm\u0101tis Str\u016BctorVerba err\u014Drem inop\u012Bn\u0101tum continu\u0101tur.
   * @see Omne
   * @see <a href="https://docs.oracle.com/javase/9/docs/api/java/lang/Thread.UncaughtExceptionHandler.html">Thread.UncaughtExceptionHandler</a>
   */
  @Singleton
  public static final class NuntiusErroribus extends Nuntius implements Thread.UncaughtExceptionHandler {
    @Nullable private static NuntiusErroribus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <NuntiusErroribus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusErroribus());

    private NuntiusErroribus() {
      super(ParametriNuntii.para(NuntiusErroribus.class));
    }

    /**
     * Modus hic invoc\u0101tur quand\u014Dque exsec\u016Bti\u014Dnem programm\u0101tis Str\u016BctorVerba err\u014Drem inop\u012Bn\u0101tum continu\u0101tur.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.UncaughtExceptionHandler.html#uncaughtException(java.lang.Thread,%20java.lang.Throwable)">UncaughtExceptionHandler.uncaughtException</a>
     */
    public @Override void uncaughtException(@NonNull final Thread linea, @NonNull final Throwable error) {
      terreo(error);
    }
  }
}
