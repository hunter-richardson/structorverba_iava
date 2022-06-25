package com.structorverba.officia.lectores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.*;
import com.structorverba.officia.verba.VerbumSimplex;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

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
    final Hoc hoc = tenor.refero();
    if (hoc == null) {
      nuntius.moneo("N\u012Bl adven\u012B");
      return null;
    } else {
      nuntius.garrio("Adven\u012B hoc:", hoc);
      return hoc;
    }
  }

  /**
   * Classis {@link LectorConiunctivis} est v\u0101s classis {@link Lector} class\u012B {@link VerbumSimplex.Coniunctivum}.
   * @see Categoria#CONIUNCTIVUM
   * @see TenorSimplicibus.TenorConiunctivis
   * @see Nuntius.NuntiusLectoriConiunctivis
   */
  @Singleton
  @DependsOn({ "TenorConiunctivis", "NuntiusLectoriConiunctivis" })
  public static final class LectorConiunctivis extends LectorSimplicibus <VerbumSimplex.Coniunctivum> {
    @Nullable private static LectorConiunctivis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorConiunctivis> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorConiunctivis());

    private LectorConiunctivis() {
      super(Categoria.CONIUNCTIVUM, Nuntius.NuntiusLectoriConiunctivis.fac, TenorSimplicibus.TenorConiunctivis.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link LectorInteriectionibus} est v\u0101s classis {@link Lector} classi {@link VerbumSimplex.Interiectio}.
   * @see Categoria#INTERIECTIO
   * @see TenorSimplicibus.TenorInteriectionibus
   * @see Nuntius.NuntiusLectoriInteriectionibus
   */
  @Singleton
  @DependsOn({ "TenorConiunctivis", "NuntiusLectoriConiunctivis" })
  public static final class LectorInteriectionibus extends LectorSimplicibus <VerbumSimplex.Interiectio> {
    @Nullable private static LectorInteriectionibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorInteriectionibus> fac =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorInteriectionibus());

    private LectorInteriectionibus() {
      super(Categoria.INTERIECTIO, Nuntius.NuntiusTenoriInteriectionibus.fac,
            TenorSimplicibus.TenorInteriectionibus.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }
}
