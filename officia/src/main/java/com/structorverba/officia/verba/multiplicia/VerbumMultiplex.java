package officia.src.main.java.com.structorverba.officia.verba.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.multiplicia.ConditorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.inventores.Inventor;
import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.tenores.TenorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.verba.*;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link VerbumMultiplex} repraesentat verbum aliquem quod f\u014Drm\u0101s mult\u0101s habet. <br>
 * R\u0113s classis {@link Inventor} r\u0113bus classis huius adsunt \u016Btilissimaeque sunt r\u0113s classis huius perc\u014Dlere. <br>
 * Discr\u012Bmina pr\u012Bm\u014Dria inter classibus h\u0101c classeque {@link VerbumSimplex}
 * sunt huius val\u014Dr\u0113s {@link #scriptio}que {@link #encliticum}que.
 * @param <Hoc> Tabell\u0101 h\u0101c classis {@link Hoc} ext\u0113nsi\u014Dnem aptam dat\u012Bs pet\u012Bt\u012Bs repraesentat.
 * @see LectorMultiplicibus
 * @see TenorMultiplicibus
 * @see ConditorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class VerbumMultiplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Valor hic f\u014Drmam f\u012Bnem verb\u012B repraesentat. <br>
   * Condici\u014Dnibus pl\u016Brim\u012Bs est ut \u016Bs\u016Bfructu\u0101ri\u012B pet\u012Bvit.
   */
  public final @NotNull String scriptio;

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subi\u016Bnctum d\u0113signat.
   * @see Encliticum
   */
  protected @NotNull Encliticum encliticum;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param ctgr  val\u014Drem {@link Verbum#categoria} indicat.
   * @param lm  val\u014Drem {@link Verbum#lemma} indicat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  protected VerbumMultiplex(@NotNull final Categoria ctgr,
                            @NotNull final String lm, @NotNull final String scrpt) {
    super(ctgr, lm);
    scriptio = scrpt;
    encliticum = Encliticum.NOLENS;
  }

  /**
   * Modus hic \u016Bs\u016Bfructu\u0101ri\u014Ds licet val\u014Drem {@link #encliticum} allegere.
   * @param cltm val\u014Drem {@link #encliticum} indicat
   * @return Rem hanc
   * @see Encliticum
   */
  @SuppressWarnings("UnusedReturnValue")
  @NotNull public VerbumMultiplex <Hoc> allego(@NotNull final Encliticum cltm) {
    encliticum = Stream.of(Encliticum.values())
                       .anyMatch(e -> lemma.endsWith(e.scriptio)) ? Encliticum.NOLENS
                                                                  : cltm;
    return this;
  }

  /**
   * @return {@link #encliticum}
   */
  @NotNull public Encliticum encliticum() {
    return encliticum;
  }

  /**
   * @return Repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius. <br>
   * Val\u014Drem {@link #encliticum} val\u014Dr\u012B {@link #scriptio} addit.
   */
  @Override @NotNull
  public String toString() {
    return Encliticum.NOLENS.equals(encliticum) ? scriptio
                                                : String.format("%s%s", scriptio, encliticum.scriptio);
  }
}
