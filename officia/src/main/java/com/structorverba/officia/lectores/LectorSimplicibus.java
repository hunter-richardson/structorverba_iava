package com.structorverba.officia.lectores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.*;
import com.structorverba.officia.verba.VerbumSimplex;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * Classis {@link LectorSimplicibus} est v\u0101s classis {@link Lector} classibus omnibus quibus classem {@link
 * VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see TenorSimplicibus
 */
@SuppressWarnings({ "SpellCheckingInspection" })
public abstract class LectorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Lector <Hoc> {
  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param ctgr val\u014Drem {@link Lector#categoria} indicat.
   * @param nts  val\u014Drem {@link Lector#nuntius} supplet.
   * @param tnr  val\u014Drem {@link Lector#tenor} supplet.
   */
  protected LectorSimplicibus(@NonNull Categoria ctgr,
                              @NonNull Supplier <? extends Nuntius> nts,
                              @NonNull Supplier <? extends Tenor <Hoc>> tnr) {
    super(ctgr, nts, tnr);
  }

  /**
   * Modus hic \u016Btitur modus {@link Lector#legam(String)} ut rem classis {@link Hoc} \u0101 val\u014Dre {@link Lector#tenor}
   * adveniat.
   * @param verbum lemma verb\u014D quod r\u0113s haec c\u014Dn\u0101bitur adven\u012Bre
   * @return Rem classis {@link Hoc} quam val\u014Drem {@code verbum} quadrat. <br>
   * Modus hic val\u014Drem {@code null} refert s\u012B nihil quadrat val\u014Drem {@code verbum}.
   */
  @Nullable public final Hoc adveniam(@NonNull final String verbum) {
    legam(verbum);
    final Hoc hoc = ((TenorSimplicibus<Hoc>) tenor).refero();
    if (hoc == null) {
      nuntius.moneo("N\u012Bl adven\u012B");
    } else {
      nuntius.garrio("Adven\u012B hoc:", hoc);
    }
    return hoc;
  }

  @Nullable public final Hoc fortuitumLegam() {
    try {
      legam(Utilitas.fortuitumLegam(categoria));
    } catch (IOException e) {
      nuntius.terreo(e);
      return null;
    }

    final Hoc hoc = ((TenorSimplicibus<Hoc>) tenor).refero();
    if (hoc == null) {
      nuntius.moneo("N\u012Bl adven\u012B");
    } else {
      nuntius.garrio("Adven\u012B hoc:", hoc);
    }
    return hoc;
  }

  /**
   * Classis {@link LectorConiunctivis} est v\u0101s classis {@link Lector} class\u012B {@link VerbumSimplex.Coniunctivum}.
   * @see Categoria#CONIUNCTIVUM
   * @see TenorSimplicibus.TenorConiunctivis
   * @see NuntiusLectoriConiunctivis
   */
  @Singleton
  @DependsOn({ "TenorConiunctivis", "NuntiusLectoriConiunctivis" })
  public static final class LectorConiunctivis extends LectorSimplicibus <VerbumSimplex.Coniunctivum> {
    @Nullable private static LectorConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorConiunctivis> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorConiunctivis());

    private LectorConiunctivis() {
      super(Categoria.CONIUNCTIVUM, NuntiusLectoriConiunctivis.faciendum, TenorSimplicibus.TenorConiunctivis.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusLectoriConiunctivis} est v\u0101s classis {@link Nuntius} class\u012B {@link
     * LectorSimplicibus.LectorConiunctivis}
     * @see LectorSimplicibus.LectorConiunctivis
     */
    @Singleton
    private static final class NuntiusLectoriConiunctivis extends Nuntius {
      @Nullable private static NuntiusLectoriConiunctivis instantia = null;

      /**
       * Valor hic viam re\u012B classis huiuc facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusLectoriConiunctivis> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriConiunctivis());

      private NuntiusLectoriConiunctivis() {
        super(ParametriNuntii.para(LectorSimplicibus.LectorConiunctivis.class));
      }
    }
  }

  /**
   * Classis {@link LectorInteriectionibus} est v\u0101s classis {@link Lector} classi {@link VerbumSimplex.Interiectio}.
   * @see Categoria#INTERIECTIO
   * @see TenorSimplicibus.TenorInteriectionibus
   * @see NuntiusLectoriInteriectionibus
   */
  @Singleton
  @DependsOn({ "TenorConiunctivis", "NuntiusLectoriConiunctivis" })
  public static final class LectorInteriectionibus extends LectorSimplicibus <VerbumSimplex.Interiectio> {
    @Nullable private static LectorInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorInteriectionibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorInteriectionibus());

    private LectorInteriectionibus() {
      super(Categoria.INTERIECTIO, NuntiusLectoriInteriectionibus.faciendum,
            TenorSimplicibus.TenorInteriectionibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link NuntiusLectoriInteriectionibus} est v\u0101s classis {@link Nuntius} class\u012B {@link
   * LectorSimplicibus.LectorConiunctivis}
   * @see LectorSimplicibus.LectorConiunctivis
   */
  @Singleton
  private static final class NuntiusLectoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusLectoriInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusLectoriInteriectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriInteriectionibus());

    private NuntiusLectoriInteriectionibus() {
      super(ParametriNuntii.para(LectorSimplicibus.LectorInteriectionibus.class));
    }
  }
}
