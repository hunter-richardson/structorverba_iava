package com.structorverba.officia.lectores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.*;
import com.structorverba.officia.verba.*;
import jakarta.ejb.*;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * Classis {@link LectorSimplicibus} est vās classis {@link Lector} classibus omnibus quibus classem {@link
 * VerbumSimplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumSimplex}
 * @see TenorSimplicibus
 */
@SuppressWarnings({ "SpellCheckingInspection" })
public abstract class LectorSimplicibus <Hoc extends VerbumSimplex <Hoc>> extends Lector <Hoc> {
  /**
   * Hoc officum cōnstrūctōrem reī huius classis perpetrat.
   * @param ctgr valōrem {@link Lector#categoria} indicat.
   * @param nts  valōrem {@link Lector#nuntius} supplet.
   * @param tnr  valōrem {@link Lector#tenor} supplet.
   */
  protected LectorSimplicibus(@NonNull Categoria ctgr,
                              @NonNull Supplier <? extends Nuntius> nts,
                              @NonNull Supplier <? extends Tenor <Hoc>> tnr) {
    super(ctgr, nts, tnr);
  }

  /**
   * Hic modus ūtitur modus {@link Lector#legam(String)} ut rem classis {@link Hoc} ā valōre {@link Lector#tenor}
   * adveniat.
   * @param verbum lemma verbō quod haec rēs cōnābitur advenīre
   * @return Rem classis {@link Hoc} quam valōrem {@code verbum} quadrat. <br>
   * Hic modus valōrem {@code null} refert sī nihil quadrat valōrem {@code verbum}.
   */
  @Nullable public final Hoc adveniam(@NonNull final String verbum) {
    legam(verbum);
    final Hoc hoc = ((TenorSimplicibus<Hoc>) tenor).refero();
    if (hoc == null) {
      nuntius.moneo("Nīl advenī");
    } else {
      nuntius.garrio("Advenī hoc:", hoc);
    }
    return hoc;
  }

  /**
   * {@inheritDoc}
   * */
  @Nullable public final Hoc fortuitumLegam() {
    try {
      legam(Utilitas.fortuitumLegam(categoria));
    } catch (IOException e) {
      nuntius.terreo(e);
      return null;
    }

    final Hoc hoc = ((TenorSimplicibus<Hoc>) tenor).refero();
    if (hoc == null) {
      nuntius.moneo("Nīl advenī");
    } else {
      nuntius.garrio("Advenī hoc:", hoc);
    }
    return hoc;
  }

  /**
   * Classis {@link LectorConiunctionibus} est vās classis {@link Lector} classī {@link VerbumSimplex.Coniunctio}.
   * @see Categoria#CONIUNCTIO
   * @see TenorSimplicibus.TenorConiunctionibus
   * @see NuntiusLectoriConiunctionibus
   */
  @Singleton
  @DependsOn({ "TenorConiunctivis", "NuntiusLectoriConiunctivis" })
  public static final class LectorConiunctionibus extends LectorSimplicibus <VerbumSimplex.Coniunctio> {
    @Nullable private static LectorConiunctionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <LectorConiunctionibus> faciendum =
      () -> ObjectUtils.firstNonNull(instantia, instantia = new LectorConiunctionibus());

    private LectorConiunctionibus() {
      super(Categoria.CONIUNCTIO, NuntiusLectoriConiunctionibus.faciendum, TenorSimplicibus.TenorConiunctionibus.faciendum);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Classis {@link NuntiusLectoriConiunctionibus} est vās classis {@link Nuntius} classī {@link
     * LectorConiunctionibus}
     * @see LectorConiunctionibus
     */
    @Singleton
    private static final class NuntiusLectoriConiunctionibus extends Nuntius {
      @Nullable private static NuntiusLectoriConiunctionibus instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusLectoriConiunctionibus> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriConiunctionibus());

      private NuntiusLectoriConiunctionibus() {
        super(ParametriNuntii.para(LectorConiunctionibus.class));
      }
    }
  }

  /**
   * Classis {@link LectorInteriectionibus} est vās classis {@link Lector} classi {@link VerbumSimplex.Interiectio}.
   * @see Categoria#INTERIECTIO
   * @see TenorSimplicibus.TenorInteriectionibus
   * @see NuntiusLectoriInteriectionibus
   */
  @Singleton
  @DependsOn({ "TenorConiunctivis", "NuntiusLectoriConiunctivis" })
  public static final class LectorInteriectionibus extends LectorSimplicibus <VerbumSimplex.Interiectio> {
    @Nullable private static LectorInteriectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
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
   * Classis {@link NuntiusLectoriInteriectionibus} est vās classis {@link Nuntius} classī {@link
   * LectorConiunctionibus}
   * @see LectorConiunctionibus
   */
  @Singleton
  private static final class NuntiusLectoriInteriectionibus extends Nuntius {
    @Nullable private static NuntiusLectoriInteriectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusLectoriInteriectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusLectoriInteriectionibus());

    private NuntiusLectoriInteriectionibus() {
      super(ParametriNuntii.para(LectorSimplicibus.LectorInteriectionibus.class));
    }
  }
}
