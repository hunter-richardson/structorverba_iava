package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.verba.Verbum;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link VerbumMultiplex} repraesentat verbum aliquem quod fōrmās multās habet.
 * Rēs classis {@link Inventor} rēbus classis huius adsunt et ūtilissimae quaestiōnibus sunt.
 * Discrīmina prīmōria inter classibus hāc et {@link VerbumSimplex} sunt huius valōrēs {#scrīptiō} et {#encliticum}.
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
  protected final @NotNull String scrīptiō;

  /**
   * Valor hic <a href="https://en.wiktionary.org/wiki/Category:Latin_clitics">encliticum</a> subiūnctum dēsignat.
   * @see Encliticum
   */
  protected @NotNull Encliticum encliticum;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link Verbum#catēgoria} indicat.
   * @param fdmn valōrem {@link Verbum#fundāmen} indicat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  protected VerbumMultiplex(@NotNull final Catēgoria ctgr, @NotNull final String fdmn, @NotNull final String scrpt) {
    super(ctgr, fdmn);
    scrīptiō = scrpt;
    encliticum = Encliticum.NŌLĒNS;
  }

  /**
   * Modus hic ūsūfructuāriōs licet valōrem {@link #encliticum} allegere.
   * @param cltm valōrem {@link #encliticum} indicat.
   * @return rem hunc classis {@link VerbumMultiplex}.
   * @see Encliticum
   */
  @SuppressWarnings("UnusedReturnValue")
  public @NotNull VerbumMultiplex <Hoc> allege(@NotNull final Encliticum cltm) {
    encliticum = cltm;
    return this;
  }

  /**
   * @return repraesentātiōnem scrīpta reī huius. Valōrem {@link #encliticum} valōrī {@link #scrīptiō} addit.
   */
  public @Override @NotNull String toString( ) {
    return Encliticum.NŌLĒNS.equals(encliticum) ? scrīptiō
                                                : String.format("%s%s", scrīptiō, encliticum.scrīptiō);
  }
}
