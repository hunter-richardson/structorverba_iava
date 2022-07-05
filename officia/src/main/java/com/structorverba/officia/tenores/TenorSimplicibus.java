package com.structorverba.officia.tenores;

import androidx.annotation.*;
import com.structorverba.officia.curatores.CuratorSimplicibus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link TenorSimplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link VerbumSimplex}
 * extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see CuratorSimplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class TenorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Tenor <Hoc> {
  /**
   * Hic valor est vās classis {@link CuratorSimplicibus} classī extentī huius.
   */
  @NonNull protected final CuratorSimplicibus<Hoc> curator;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param nts   valōrem {@link Tenor#nuntius} supplet.
   * @param ctr valōrem {@link #curator} supplet.
   */
  protected TenorSimplicibus(@NonNull final Supplier <? extends Nuntius> nts,
                             @NonNull final Supplier <? extends CuratorSimplicibus<Hoc>> ctr) {
    super(nts);
    curator = ctr.get();
  }

  /**
   * {@inheritDoc}
   */
  @Override protected final void finiam() {
    hoc = curator.curam();
    if (hoc == null) {
      nuntius.moneo("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  /**
   * @return Valōrem {@link #hoc}
   */
  @Nullable public Hoc refero() {
    return hoc;
  }

  /**
   * {@inheritDoc}
   * @param scriptio fōrmam scrīptam indendus
   * @see Verbum#lemma
   */
  @Override protected void scribo(@NonNull String scriptio) {
    curator.funde(scriptio);
  }

  /**
   * Classis {@link TenorConiunctionibus} est vās classis {@link Tenor} classī {@link VerbumSimplex.Coniunctio}
   * @see VerbumSimplex.Coniunctio
   * @see NuntiusTenoriConiunctionibus
   * @see CuratorSimplicibus.CuratorConiunctionibus
   */
  @Singleton
  @DependsOn({ "ConditorConiunctivis", "NuntiusTenoriConiunctivis" })
  public static final class TenorConiunctionibus extends TenorSimplicibus <VerbumSimplex.Coniunctio> {
    @Nullable private static TenorConiunctionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorConiunctionibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorConiunctionibus());

    private TenorConiunctionibus() {
      super(NuntiusTenoriConiunctionibus.faciendum, CuratorSimplicibus.CuratorConiunctionibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusTenoriConiunctionibus} est vās classis {@link Nuntius} classī {@link
     * TenorConiunctionibus}
     * @see TenorConiunctionibus
     */
    @Singleton
    private static final class NuntiusTenoriConiunctionibus extends Nuntius {
      @Nullable private static NuntiusTenoriConiunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusTenoriConiunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriConiunctionibus());

      private NuntiusTenoriConiunctionibus() {
        super(ParametriNuntii.para(TenorConiunctionibus.class));
      }
    }
  }

  /**
   * Classis {@link TenorInteriectionibus} est vās classis {@link Tenor} classī {@link VerbumSimplex.Interiectio}
   * @see VerbumSimplex.Interiectio
   * @see NuntiusTenoriInteriectionibus
   * @see CuratorSimplicibus.CuratorInteriectionibus
   */
  @Singleton
  @DependsOn({ "ConditorConiunctivis", "NuntiusTenoriConiunctivis" })
  public static final class TenorInteriectionibus extends TenorSimplicibus <VerbumSimplex.Interiectio> {
    @Nullable private static TenorInteriectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <TenorInteriectionibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new TenorInteriectionibus());

    private TenorInteriectionibus() {
      super(NuntiusTenoriInteriectionibus.faciendum, CuratorSimplicibus.CuratorInteriectionibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link NuntiusTenoriInteriectionibus} est vās classis {@link Nuntius} classī {@link
   * TenorSimplicibus.TenorInteriectionibus}
   * @see TenorSimplicibus.TenorInteriectionibus
   */
  @Singleton
  private static final class NuntiusTenoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusTenoriInteriectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusTenoriInteriectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusTenoriInteriectionibus());

    private NuntiusTenoriInteriectionibus() {
      super(ParametriNuntii.para(TenorSimplicibus.TenorInteriectionibus.class));
    }
  }
}
