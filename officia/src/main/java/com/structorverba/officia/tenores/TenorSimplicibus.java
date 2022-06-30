package com.structorverba.officia.tenores;

import androidx.annotation.*;
import com.structorverba.officia.conditores.ConditorSimplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link TenorSimplicibus} est v\u0101s classis {@link Tenor} classibus omnibus quibus classem {@link VerbumSimplex}
 * extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see ConditorSimplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class TenorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Valor hic est v\u0101s classis {@link ConditorSimplicibus} class\u012B extent\u012B huius.
   */
  @NonNull protected final ConditorSimplicibus <Hoc> conditor;

  /**
   * Officium hoc c\u014dnstr\u016Bct\u014drem re\u012B classis huius perpetrat.
   * @param nts   val\u014drem {@link Tenor#nuntius} supplet.
   * @param cndtr val\u014drem {@link #conditor} supplet.
   */
  protected TenorSimplicibus(@NonNull final Supplier <? extends Nuntius> nts,
                             @NonNull final Supplier <? extends ConditorSimplicibus <Hoc>> cndtr) {
    super(nts);
    conditor = cndtr.get();
  }

  /**
   * {@inheritDoc}
   */
  @Override protected final void finiam() {
    hoc = conditor.condam();
    if (hoc == null) {
      nuntius.moneo("Pr\u014dducti\u014d verb\u012B pr\u014dcessimus n\u016Bllae f\u014drmae.");
    }
  }

  /**
   * @return Val\u014Drem {@link #hoc}
   */
  @Nullable public Hoc refero() {
    return hoc;
  }

  /**
   * {@inheritDoc}
   * @param scriptio f\u014drmam scr\u012Bptam indendus
   * @see Verbum#lemma
   */
  @Override protected void scribo(@NonNull String scriptio) {
    conditor.funde(scriptio);
  }

  /**
   * Classis {@link TenorConiunctivis} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Coniunctivum}
   * @see VerbumSimplex.Coniunctivum
   * @see NuntiusTenoriConiunctivis
   * @see ConditorSimplicibus.ConditorConiunctivis
   */
  @Singleton
  @DependsOn({ "ConditorConiunctivis", "NuntiusTenoriConiunctivis" })
  public static final class TenorConiunctivis extends TenorSimplicibus <VerbumSimplex.Coniunctivum> {
    @Nullable private static TenorConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorConiunctivis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorConiunctivis());

    private TenorConiunctivis() {
      super(NuntiusTenoriConiunctivis.faciendum, ConditorSimplicibus.ConditorConiunctivis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusTenoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
     * TenorSimplicibus.TenorConiunctivis}
     * @see TenorSimplicibus.TenorConiunctivis
     */
    @Singleton
    private static final class NuntiusTenoriConiunctivis extends Nuntius {
      @Nullable private static NuntiusTenoriConiunctivis instantia = null;

      /**
       * Valor hic viam re\u012B classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusTenoriConiunctivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriConiunctivis());

      private NuntiusTenoriConiunctivis() {
        super(ParametriNuntii.para(TenorSimplicibus.TenorConiunctivis.class));
      }
    }
  }

  /**
   * Classis {@link TenorInteriectionibus} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Interiectio}
   * @see VerbumSimplex.Interiectio
   * @see NuntiusTenoriInteriectionibus
   * @see ConditorSimplicibus.ConditorInteriectionibus
   */
  @Singleton
  @DependsOn({ "ConditorConiunctivis", "NuntiusTenoriConiunctivis" })
  public static final class TenorInteriectionibus extends TenorSimplicibus <VerbumSimplex.Interiectio> {
    @Nullable private static TenorInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorInteriectionibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorInteriectionibus());

    private TenorInteriectionibus() {
      super(NuntiusTenoriInteriectionibus.faciendum, ConditorSimplicibus.ConditorInteriectionibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link NuntiusTenoriInteriectionibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * TenorSimplicibus.TenorInteriectionibus}
   * @see TenorSimplicibus.TenorInteriectionibus
   */
  @Singleton
  private static final class NuntiusTenoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusTenoriInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusTenoriInteriectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriInteriectionibus());

    private NuntiusTenoriInteriectionibus() {
      super(ParametriNuntii.para(TenorSimplicibus.TenorInteriectionibus.class));
    }
  }
}
