package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.conditōrēs.multiplicia.ConditōrAdverbiīs;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import net.strūctorverba.ēnumerātiōnēs.Gradus;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Adverbium} repraesentat adverbia ut coniectēris. <br> Rēs classis huius catēgoriam {@link
 * Catēgoria#ADVERBIUM} ūtuntur cōnservātaque sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adverbia.
 * @see LēctorMultiplicibus.LēctorAdverbiīs
 * @see TenorMultiplicibus.TenorAdverbiīs
 * @see ConditōrAdverbiīs
 * @see Nūntius.NūntiusAdverbiōrum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public class Adverbium extends VerbumMultiplex <Adverbium> {
  /**
   * Valor hic potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NotNull public final Gradus gradus;
  @Getter(lazy = true)
  @NotNull private final Nūntius.NūntiusAdverbiōrum nūntius = Nūntius.NūntiusAdverbiōrum.fac.get();

  public Adverbium(@NotNull final Gradus gradus, @NotNull final String lemma,
                   @NotNull final String scrīptiō) {
    super(Catēgoria.ADIECTĪVUM, lemma, scrīptiō);
    this.gradus = gradus;
    nūntius.plūsGarriō("Scrībor ut", scrīptiō);
  }
}
