package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrNōminibus;
import net.strūctorverba.inventōrēs.InventorNōminibus;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Nōmen} repraesentat nōmina ut coniectēris. <br>
 * Nōmina catēgoriam {@link Catēgoria#NŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/nōmina.
 * @see LēctorMultiplicibus.LēctorNōminibus
 * @see TenorMultiplicibus.TenorNōminibus
 * @see InventorNōminibus
 * @see ConditōrNōminibus
 * @see Nūntius.NūntiusNōminum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Nōmen extends Nōminālis <Nōmen> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull Nūntius.NūntiusNōminum nūntius = Nūntius.NūntiusNōminum.fac.get();

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Nōmen(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.NŌMEN, speciālitās, genus, cāsus, numerālis, fundāmen, scrīptiō);
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }
}
