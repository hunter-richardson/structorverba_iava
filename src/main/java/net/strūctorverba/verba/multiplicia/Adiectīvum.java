package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrAdiectīvīs;
import net.strūctorverba.inventōrēs.InventorAdiectīvīs;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Adiectīvum} repraesentat adiectīva ut coniectēris. <br>
 * Rēs classis huius catēgoriam {@link Catēgoria#NŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva. <br>
 * Discrīmina prīmōria inter classibus hāc et {@link Prōnōmen} est huius valor {@link #gradus}.
 * @see LēctorMultiplicibus.LēctorAdiectīvīs
 * @see TenorMultiplicibus.TenorAdiectīvīs
 * @see InventorAdiectīvīs
 * @see ConditōrAdiectīvīs
 * @see Nūntius.NūntiusAdiectīvōrum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Adiectīvum extends Nōminālis <Adiectīvum> {
  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final Nūntius.NūntiusAdiectīvōrum nūntius = Nūntius.NūntiusAdiectīvōrum.fac.get();

  /**
   * Valor hic potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NotNull public final Gradus gradus;

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
           builderMethodName = "conditōr", buildMethodName = "condam")
  private Adiectīvum(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                     @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                     @NotNull final Gradus gradus, @NotNull final String fundāmen,
                     @NotNull final String scrīptiō) {
    super(Catēgoria.ADIECTĪVUM, speciālitās, genus, cāsus, numerālis, fundāmen, scrīptiō);
    this.gradus = gradus;
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }
}

