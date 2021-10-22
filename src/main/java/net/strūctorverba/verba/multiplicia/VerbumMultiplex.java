package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.conditōrēs.multiplicia.ConditōrMultiplicibus;
import net.strūctorverba.inventōrēs.Inventor;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.verba.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link VerbumMultiplex} repraesentat verbum aliquem quod fōrmās multās habet. <br> Rēs classis {@link
 * Inventor} rēbus classis huius adsunt et ūtilissimae sunt rēs classis huius percōlere. <br> Discrīmina prīmōria inter
 * classibus hāc et {@link VerbumSimplex} sunt huius valōrēs {@link #scrīptiō} et {@link #encliticum}.
 * @param <Hoc> Tabellā hāc classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 * @see LēctorMultiplicibus
 * @see TenorMultiplicibus
 * @see ConditōrMultiplicibus
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class VerbumMultiplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Valor hic fōrmam fīnem verbī repraesentat. Condiciōnibus plūrimīs est ut ūsūfructuāriī petīvit.
   */
  public final @NotNull String scrīptiō;

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subiūnctum dēsignat.
   * @see Encliticum
   */
  protected @NotNull Encliticum encliticum;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr  valōrem {@link Verbum#catēgoria} indicat.
   * @param lm  valōrem {@link Verbum#lemma} indicat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  protected VerbumMultiplex(@NotNull final Catēgoria ctgr,
                            @NotNull final String lm, @NotNull final String scrpt) {
    super(ctgr, lm);
    scrīptiō = scrpt;
    encliticum = Encliticum.NŌLĒNS;
  }

  /**
   * Modus hic ūsūfructuāriōs licet valōrem {@link #encliticum} allegere.
   * @param cltm valōrem {@link #encliticum} indicat
   * @return Rem hanc
   * @see Encliticum
   */
  @SuppressWarnings("UnusedReturnValue")
  @NotNull public VerbumMultiplex <Hoc> allegō(@NotNull final Encliticum cltm) {
    encliticum = cltm;
    return this;
  }

  /**
   * @return {@link #encliticum}
   */
  @NotNull public Encliticum encliticum( ) {
    return encliticum;
  }

  /**
   * @return Repraesentātiōnem scrīpta reī huius. <br> Valōrem {@link #encliticum} valōrī {@link #scrīptiō} addit.
   */
  @Override @NotNull
  public String toString( ) {
    return Encliticum.NŌLĒNS.equals(encliticum) ? scrīptiō
                                                : String.format("%s%s", scrīptiō, encliticum.scrīptiō);
  }
}
