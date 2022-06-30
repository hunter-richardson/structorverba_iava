package com.structorverba.officia.conditores;

import androidx.annotation.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.VerbumSimplex;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.*;

/**
 * Classis {@link ConditorSimplicibus} est v\u0101s classis {@link Conditor} classibus omnibus quibus classem {@link
 * VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class ConditorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Conditor <Hoc> {
  /**
   * Valor hic viam re\u012B classis {@link Hoc} facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">Function</a>
   */
  @NonNull protected final Function <String, Hoc> constructor;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param nts   val\u014Drem {@link Conditor#nuntius} supplet.
   * @param cnstr val\u014Drem {@link #constructor} supplet.
   */
  protected ConditorSimplicibus(@NonNull final Supplier <? extends Nuntius> nts,
                                @NonNull final Function <String, Hoc> cnstr) {
    super(nts);
    constructor = cnstr;
  }

  /**
   * {@inheritDoc}
   */
  @Override @Nullable
  public final Hoc condam() {
    final Hoc hoc = StringUtils.isNotBlank(lemma) ? constructor.apply(lemma)
                                                  : null;
    refero(hoc);
    return hoc;
  }

  /**
   * Classis {@link ConditorConiunctivis} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Coniunctivum}.
   * @see VerbumSimplex.Coniunctivum
   * @see NuntiusConditoriConiunctivis
   */
  @Singleton
  @DependsOn("NuntiusConditoriAdverbiis")
  public static final class ConditorConiunctivis extends ConditorSimplicibus <VerbumSimplex.Coniunctivum> {
    @Nullable private static ConditorConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <ConditorConiunctivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorConiunctivis());

    private ConditorConiunctivis() {
      super(NuntiusConditoriConiunctivis.fac, lemma -> VerbumSimplex.Coniunctivum.builder().lemma(lemma).build());
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic rem classis {@link VerbumSimplex.Coniunctivum} accipit val\u014Dr\u012Bque {@link ConditorConiunctivis#nuntius}
     * ita refert.
     * @param hoc rem tentanda
     */
    protected void refero(@Nullable final VerbumSimplex.Coniunctivum hoc) {
      if (hoc == null) {
        nuntius.certioro("Coni\u016Bnct\u012Bvum", lemma, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
      } else {
        nuntius.moneo("Coni\u016Bnct\u012Bv\u012B pr\u014Dducti\u014D formae n\u016Bllae pr\u014Dcessit.");
      }
    }

    /**
     * Classis {@link NuntiusConditoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
     * ConditorSimplicibus.ConditorConiunctivis}
     * @see ConditorSimplicibus.ConditorConiunctivis
     */
    @Singleton
    private static final class NuntiusConditoriConiunctivis extends Nuntius {
      @Nullable private static NuntiusConditoriConiunctivis instantia = null;

      /**
       * Valor hic viam re\u012B classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusConditoriConiunctivis> fac =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriConiunctivis());

      private NuntiusConditoriConiunctivis() {
        super(ParametriNuntii.para(ConditorSimplicibus.ConditorConiunctivis.class));
      }
    }
  }

  /**
   * Classis {@link ConditorInteriectionibus} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Interiectio}.
   * @see VerbumSimplex.Interiectio
   * @see NuntiusConditoriInteriectionibus
   */
  @Singleton
  @DependsOn("NuntiusConditoriAdverbiis")
  public static final class ConditorInteriectionibus extends ConditorSimplicibus <VerbumSimplex.Interiectio> {
    @Nullable private static ConditorInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <ConditorInteriectionibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorInteriectionibus());

    private ConditorInteriectionibus() {
      super(NuntiusConditoriInteriectionibus.fac, lemma -> VerbumSimplex.Interiectio.builder().lemma(lemma).build());
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic rem classis {@link VerbumSimplex.Coniunctivum} accipit val\u014Dr\u012Bque {@link Conditor#nuntius} ita refert.
     * @param hoc rem tentanda
     */
    protected void refero(@Nullable final VerbumSimplex.Interiectio hoc) {
      if (hoc == null) {
        nuntius.certioro("Interiecti\u014D", lemma, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
      } else {
        nuntius.moneo("Interiecti\u014Dn\u012B pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      }
    }
  }

  /**
   * Classis {@link NuntiusConditoriInteriectionibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * ConditorSimplicibus.ConditorInteriectionibus}
   * @see ConditorSimplicibus.ConditorInteriectionibus
   */
  @Singleton
  private static final class NuntiusConditoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusConditoriInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriInteriectionibus> fac =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriInteriectionibus());

    private NuntiusConditoriInteriectionibus() {
      super(ParametriNuntii.para(ConditorSimplicibus.ConditorInteriectionibus.class));
    }
  }
}
