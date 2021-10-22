package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.conditōrēs.multiplicia.ConditōrNōminibus;
import net.strūctorverba.inventōrēs.InventorNōminibus;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import net.strūctorverba.ēnumerātiōnēs.Cāsus;
import net.strūctorverba.ēnumerātiōnēs.Genus;
import net.strūctorverba.ēnumerātiōnēs.Modus;
import net.strūctorverba.ēnumerātiōnēs.Numerālis;
import net.strūctorverba.ēnumerātiōnēs.Speciālitās;
import net.strūctorverba.ēnumerātiōnēs.Tempus;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Nōmen} repraesentat nōmina ut coniectēris. <br> Rēs classis huius catēgoriam {@link Catēgoria#NŌMEN}
 * ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/nōmina.
 * @see LēctorMultiplicibus.LēctorNōminibus
 * @see TenorMultiplicibus.TenorNōminibus
 * @see InventorNōminibus
 * @see ConditōrNōminibus
 * @see Nūntius.NūntiusNōminum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Nōmen extends Nōminālis <Nōmen> {
  /**
   * Valor hic modum reī huius dēsignat.
   * @see Modus
   */
  @NotNull public final Tempus tempus;

  @Getter(lazy = true)
  @NotNull private final Nūntius.NūntiusNōminum nūntius = Nūntius.NūntiusNōminum.fac.get();

  public Nōmen(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                @NotNull final Tempus tmps, @NotNull final String lemma,
                @NotNull final String scrīptiō) {
    super(Catēgoria.NŌMEN, speciālitās, genus, cāsus, numerālis, lemma, scrīptiō);
    tempus = tmps;
    nūntius.plūsGarriō("Scrībor ut", scrīptiō);
  }
}
