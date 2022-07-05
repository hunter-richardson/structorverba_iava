package com.structorverba.officia.curatores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.*;

/**
 * Classis {@link CuratorSimplicibus} est vās classis {@link Curator} classibus omnibus quibus classem {@link
 * VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class CuratorSimplicibus<Hoc extends VerbumSimplex <Hoc>> extends Curator<Hoc> {
  /**
   * Hic valor viam reī classis {@link Hoc} facit.
   *
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">Function</a>
   */
  @NonNull
  protected final Function<String, Hoc> constructor;

  /**
   * Hic valor valōrem {@link Verbum#lemma} reī prōductae repraehentat.
   */
  @NonNull protected String lemma = StringUtils.EMPTY;

  /**
   * Hoc officum cōnstrūctōrem reī huius classis perpetrat.
   *
   * @param nts   valōrem {@link Curator#nuntius} supplet.
   * @param cnstr valōrem {@link #constructor} supplet.
   */
  protected CuratorSimplicibus(@NonNull final Categoria ctgr, @NonNull final Supplier<? extends Nuntius> nts,
                               @NonNull final Function<String, Hoc> cnstr) {
    super(ctgr, nts);
    constructor = cnstr;
  }

  /**
   * Hic modus valōrem {@link #lemma} indit.
   * @param lm valōrem indendum
   */
  public final void funde(@NonNull final String lm) {
    lemma = lm.trim();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Nullable
  public final Hoc curam() {
    final Hoc hoc = StringUtils.isNotBlank(lemma) ? constructor.apply(lemma)
            : null;
    refero(hoc);
    return hoc;
  }

  /**
   * Classis {@link CuratorConiunctionibus} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniunctio}.
   *
   * @see VerbumSimplex.Coniunctio
   * @see NuntiusConditoriConiunctionibus
   */
  @Singleton
  @DependsOn("NuntiusConditoriAdverbiis")
  public static final class CuratorConiunctionibus extends CuratorSimplicibus<VerbumSimplex.Coniunctio> {
    @Nullable
    private static CuratorConiunctionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull
    public static final Supplier<CuratorConiunctionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorConiunctionibus());

    private CuratorConiunctionibus() {
      super(Categoria.CONIUNCTIO, NuntiusConditoriConiunctionibus.faciendum,
            lemma -> VerbumSimplex.Coniunctio.builder().lemma(lemma).build());
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusConditoriConiunctionibus} est vās classis {@link Nuntius} classī {@link
     * CuratorConiunctionibus}
     *
     * @see CuratorConiunctionibus
     */
    @Singleton
    private static final class NuntiusConditoriConiunctionibus extends Nuntius {
      @Nullable
      private static NuntiusConditoriConiunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       *
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull
      private static final Supplier<NuntiusConditoriConiunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriConiunctionibus());

      private NuntiusConditoriConiunctionibus() {
        super(ParametriNuntii.para(CuratorConiunctionibus.class));
      }
    }
  }

  /**
   * Classis {@link CuratorInteriectionibus} est vās classis {@link Tenor} classī {@link VerbumSimplex.Interiectio}.
   *
   * @see VerbumSimplex.Interiectio
   * @see NuntiusConditoriInteriectionibus
   */
  @Singleton
  @DependsOn("NuntiusConditoriAdverbiis")
  public static final class CuratorInteriectionibus extends CuratorSimplicibus<VerbumSimplex.Interiectio> {
    @Nullable
    private static CuratorInteriectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull
    public static final Supplier<CuratorInteriectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new CuratorInteriectionibus());

    private CuratorInteriectionibus() {
      super(Categoria.INTERIECTIO, NuntiusConditoriInteriectionibus.faciendum,
            lemma -> VerbumSimplex.Interiectio.builder().lemma(lemma).build());
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusConditoriInteriectionibus} est vās classis {@link Nuntius} classī {@link
     * CuratorInteriectionibus}
     *
     * @see CuratorInteriectionibus
     */
    @Singleton
    private static final class NuntiusConditoriInteriectionibus extends Nuntius {
      @Nullable
      private static NuntiusConditoriInteriectionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       *
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull
      private static final Supplier<NuntiusConditoriInteriectionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriInteriectionibus());

      private NuntiusConditoriInteriectionibus() {
        super(ParametriNuntii.para(CuratorInteriectionibus.class));
      }
    }
  }
}
