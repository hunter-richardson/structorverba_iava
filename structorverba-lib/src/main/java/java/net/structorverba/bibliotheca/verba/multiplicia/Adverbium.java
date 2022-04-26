package net.structorverba.bibliotheca.verba.multiplicia;

import net.structorverba.bibliotheca.conditores.multiplicia.ConditōrAdverbiīs;
import net.structorverba.bibliotheca.lectores.LēctorMultiplicibus;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.tenores.TenorMultiplicibus;
import net.structorverba.bibliotheca.enumerationes.*;

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
