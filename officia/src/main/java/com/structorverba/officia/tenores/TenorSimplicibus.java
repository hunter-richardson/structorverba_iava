package officia.src.main.java.com.structorverba.officia.tenores;

import officia.src.main.java.com.structorverba.officia.conditores.ConditorSimplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;
import officia.src.main.java.com.structorverba.officia.verba.VerbumSimplex;

import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

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
  @NotNull protected final ConditorSimplicibus <@NotNull Hoc> conditor;

  /**
   * Officium hoc c\u014dnstr\u016Bct\u014drem re\u012B classis huius perpetrat.
   * @param nts   val\u014drem {@link Tenor#nuntius} supplet.
   * @param cndtr val\u014drem {@link #conditor} supplet.
   */
  protected TenorSimplicibus(@NotNull final Supplier <@NotNull ? extends Nuntius> nts,
                             @NotNull final Supplier <@NotNull ? extends ConditorSimplicibus <@NotNull Hoc>> cndtr) {
    super(nts);
    conditor = cndtr.get();
  }

  /**
   * {@inheritDoc}
   */
  @Override protected final void finiam() {
    hoc = conditor.condam();
    if (Objects.isNull(hoc)) {
      nuntius.moneo("Pr\u014dducti\u014d verb\u012B pr\u014dcessimus n\u016Bllae f\u014drmae.");
    }
  }

  /**
   * {@inheritDoc}
   * @param scriptio f\u014drmam scr\u012Bptam indendus
   * @see Verbum#lemma
   */
  @Override protected void scribo(@NotNull String scriptio) {
    conditor.funde(scriptio);
  }

  /**
   * Classis {@link TenorConiunctivis} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Coniunctivum}
   * @see VerbumSimplex.Coniunctivum
   * @see Nuntius.NuntiusTenoriConiunctivis
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
    @NotNull public static final Supplier <TenorConiunctivis> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new TenorConiunctivis());

    private TenorConiunctivis() {
      super(Nuntius.NuntiusTenoriConiunctivis.fac, ConditorSimplicibus.ConditorConiunctivis.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link TenorInteriectionibus} est v\u0101s classis {@link Tenor} class\u012B {@link VerbumSimplex.Interiectio}
   * @see VerbumSimplex.Interiectio
   * @see Nuntius.NuntiusTenoriInteriectionibus
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
    @NotNull public static final Supplier <TenorInteriectionibus> fac =
      ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new TenorInteriectionibus());

    private TenorInteriectionibus() {
      super(Nuntius.NuntiusTenoriInteriectionibus.fac, ConditorSimplicibus.ConditorInteriectionibus.fac);
      nuntius.plurimumGarrio("Factus sum");
    }
  }
}
