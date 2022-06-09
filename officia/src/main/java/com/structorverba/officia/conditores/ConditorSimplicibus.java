package com.structorverba.officia.conditores;

import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.VerbumSimplex;

import org.apache.commons.lang3.*;
import androidx.annotation.*;

import java.util.Objects;
import java.util.function.*;

import javax.ejb.*;

/**
 * Classis {@link Condit\u014DrSimplicibus} est v\u0101s classis {@link Conditor} classibus omnibus quibus classem {@link
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
   * Modus hic rem classis {@link Hoc} accipit val\u014Dr\u012Bque {@link Conditor#nuntius} ita refert.
   * @param hoc rem tentanda
   */
  protected abstract void refero(@Nullable final Hoc hoc);

  /**
   * Classis {@link ConditorConiunctivis} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Coniunctivum}.
   * @see VerbumSimplex.Coniunctivum
   * @see Nuntius.NuntiusConditoriConiunctivis
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
      super(Nuntius.NuntiusConditoriConiunctivis.fac, VerbumSimplex.Coniunctivum::new);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic rem classis {@link VerbumSimplex.Coniunctivum} accipit val\u014Dr\u012Bque {@link ConditorConiunctivis#nuntius}
     * ita refert.
     * @param hoc rem tentanda
     */
    protected void refero(@Nullable final VerbumSimplex.Coniunctivum hoc) {
      if (hoc == null) {
        nuntius.certioro(Utilitas.primamCapitaneamScribo(Categoria.CONIUNCTIVUM.scriptio.replaceLast("a", "um")),
                         lemma, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
      } else {
        nuntius.moneo(Utilitas.primamCapitaneamScribo(Categoria.CONIUNCTIVUM.scriptio.replaceLast('a', '\u012B')),
                      "pr\u014Dducti\u014D formae n\u016Bllae pr\u014Dcessit.");
      }
    }
  }

  /**
   * Classis {@link ConditorInteriectionibus} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Interiectio}.
   * @see VerbumSimplex.Interiectio
   * @see Nuntius.NuntiusConditoriInteriectionibus
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
      super(Nuntius.NuntiusConditoriInteriectionibus.fac, VerbumSimplex.Interiectio::new);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Modus hic rem classis {@link VerbumSimplex.Coniunctivum} accipit val\u014Dr\u012Bque {@link Conditor#nuntius} ita refert.
     * @param hoc rem tentanda
     */
    protected void refero(@Nullable final VerbumSimplex.Interiectio hoc) {
      if (hoc == null) {
        nuntius.certioro(Utilitas.primamCapitaneamScribo(Categoria.INTERIECTIO.scriptio.replaceLast("n\u0113s", StringUtils.EMPTY)),
                         lemma, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
      } else {
        nuntius.moneo(Utilitas.primamCapitaneamScribo(Categoria.INTERIECTIO.scriptio.replaceLast("\u0113s", "\u012B")),
                      "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      }
    }
  }
}
