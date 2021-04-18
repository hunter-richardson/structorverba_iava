package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrPrōnōminibus;
import net.strūctorverba.inventōrēs.InventorPrōnōminibus;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Prōnōmen} repraesentat nōmina ut coniectēris.
 * Prōnōmina catēgoriam {@link Catēgoria#PRŌNŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/prōnōmina">prōnōmina</a>.
 * @see LēctorMultiplicibus.LēctorPrōnōminibus
 * @see TenorMultiplicibus.TenorPrōnōminibus
 * @see InventorPrōnōminibus
 * @see ConditōrPrōnōminibus
 * @see Nūntius.NūntiusPrōnōminum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Prōnōmen extends Nōminālis <Prōnōmen> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull Nūntius.NūntiusPrōnōminum nūntius = Nūntius.NūntiusPrōnōminum.fac.get();

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Prōnōmen(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                   @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                   @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.PRŌNŌMEN, speciālitās, genus, cāsus, numerālis, fundāmen, scrīptiō);
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }
}
