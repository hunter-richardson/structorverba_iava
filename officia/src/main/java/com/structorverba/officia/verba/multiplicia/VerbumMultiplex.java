package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.multiplicia.ConditorMultiplicibus;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.Inventor;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.verba.*;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * Classis {@link VerbumMultiplex} repraesentat verbum aliquem quod fōrmās multās habet. <br>
 * Rēs classis {@link Inventor} rēbus classis huius adsunt ūtilissimaeque sunt rēs classis huius percōlere. <br>
 * Discrīmina prīmōria inter classibus hāc classeque {@link VerbumSimplex}
 * sunt huius valōrēs {@link #scriptio}que {@link #encliticum}que.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see LectorMultiplicibus
 * @see TenorMultiplicibus
 * @see ConditorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class VerbumMultiplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Valor hic fōrmam fīnem verbī repraesentat. <br>
   * Condiciōnibus plūrimīs est ut ūsūfructuāriī petīvit.
   */
  public final @NonNull String scriptio;

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subiūnctum dēsignat.
   * @see Encliticum
   */
  protected @NonNull Encliticum encliticum;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr  valōrem {@link Verbum#catagoria} indicat.
   * @param lm  valōrem {@link Verbum#lemma} indicat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  protected VerbumMultiplex(@NonNull final Categoria ctgr,
                            @NonNull final String lm, @NonNull final String scrpt) {
    super(ctgr, lm);
    scriptio = scrpt;
    encliticum = Encliticum.NOLENS;
  }

  /**
   * Modus hic ūsūfructuāriōs licet valōrem {@link #encliticum} allegere.
   * @param cltm valōrem {@link #encliticum} indicat
   * @return Rem hanc
   * @see Encliticum
   */
  @SuppressWarnings("UnusedReturnValue")
  @NonNull public VerbumMultiplex <Hoc> allego(@NonNull final Encliticum cltm) {
    encliticum = Stream.of(Encliticum.values())
                       .anyMatch(e -> lemma.endsWith(e.scriptio)) ? Encliticum.NOLENS
                                                                  : cltm;
    return this;
  }

  /**
   * @return {@link #encliticum}
   */
  @SuppressWarnings("unused")
  @NonNull public Encliticum encliticum() {
    return encliticum;
  }

  /**
   * @return Repraesentātiōnem scrīpta reī huius. <br>
   * Valōrem {@link #encliticum} valōrī {@link #scriptio} addit.
   */
  @Override @NonNull
  public String toString() {
    return Encliticum.NOLENS.equals(encliticum) ? scriptio
                                                : String.format("%s%s", scriptio, encliticum.scriptio);
  }

  public static abstract class Constructor<Hoc extends VerbumMultiplex<Hoc>> {
    @NonNull protected String lemma     = StringUtils.EMPTY;
    @NonNull protected String scriptio  = StringUtils.EMPTY;

    protected Constructor() {  }

    public void lemma(@NonNull final String lemma) {
      this.lemma = lemma;
    }

    public void scriptio(@NonNull final String scriptio) {
      this.scriptio = scriptio;
    }

    public boolean paratus() {
      return StringUtils.isNoneBlank(lemma, scriptio);
    }

    @Nullable public abstract Hoc build();
    public abstract void restituo();
  }
}
