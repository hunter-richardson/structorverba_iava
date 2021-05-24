package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrAdverbiīs;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Adverbium} repraesentat adverbia ut coniectēris. <br> Rēs classis huius catēgoriam {@link
 * Catēgoria#ADVERBIUM} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adverbia.
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
  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final Nūntius.NūntiusAdverbiōrum nūntius = Nūntius.NūntiusAdverbiōrum.fac.get();

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
           builderMethodName = "conditōr", buildMethodName = "condam")
  private Adverbium(@NotNull final Gradus gradus, @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.ADIECTĪVUM, fundāmen, scrīptiō);
    this.gradus = gradus;
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }
}
