package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import com.structorverba.officia.curatores.multiplicia.CuratorMultiplicibus;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.Inventor;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.verba.*;

import java.util.stream.Stream;

/**
 * Classis {@link VerbumMultiplex} repraesentat verbum aliquem quod fōrmās multās habet. <br>
 * Rēs classis {@link Inventor} rēbus huius classis adsunt ūtilissimaeque sunt rēs huius classis percōlere. <br>
 * Discrīmina prīmōria inter hīs classibus classeque {@link VerbumSimplex}
 * sunt huius valōrēs {@link #scriptio}que {@link #encliticum}que.
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see LectorMultiplicibus
 * @see TenorMultiplicibus
 * @see CuratorMultiplicibus
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class VerbumMultiplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Hic valor fōrmam fīnem verbī repraesentat. <br>
   * Condiciōnibus plūrimīs est ut ūsūfructuāriī petīvit.
   */
  public final @NonNull String scriptio;

  /**
   * Hic valor <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subiūnctum dēsignat.
   * @see Encliticum
   */
  protected @NonNull Encliticum encliticum;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
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
   * Hic modus ūsūfructuāriōs licet valōrem {@link #encliticum} allegere.
   * @param cltm valōrem {@link #encliticum} indicat
   * @return Hanc rem
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
   * @return Repraesentātiōnem scrīpta huius. <br>
   * Valōrem {@link #encliticum} valōrī {@link #scriptio} addit.
   */
  @Override @NonNull
  public String toString() {
    return Encliticum.NOLENS.equals(encliticum) ? scriptio
                                                : String.format("%s%s", scriptio, encliticum.scriptio);
  }

}
