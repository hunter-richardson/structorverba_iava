package net.strūctorverba.verba.multiplicia;

import net.strūctorverba.conditōrēs.multiplicia.ConditōrPrōnōminibus;
import net.strūctorverba.inventōrēs.InventorPrōnōminibus;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import net.strūctorverba.ēnumerātiōnēs.Cāsus;
import net.strūctorverba.ēnumerātiōnēs.Genus;
import net.strūctorverba.ēnumerātiōnēs.Numerālis;
import net.strūctorverba.ēnumerātiōnēs.Speciālitās;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Prōnōmen} repraesentat prōnōmina ut coniectēris. <br> Rēs classis huius catēgoriam {@link
 * Catēgoria#PRŌNŌMEN} ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina.
 * @see LēctorMultiplicibus.LēctorPrōnōminibus
 * @see TenorMultiplicibus.TenorPrōnōminibus
 * @see InventorPrōnōminibus
 * @see ConditōrPrōnōminibus
 * @see Nūntius.NūntiusPrōnōminum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Prōnōmen extends Nōminālis <Prōnōmen> {
  @Getter(lazy = true)
  @NotNull private final Nūntius.NūntiusPrōnōminum nūntius = Nūntius.NūntiusPrōnōminum.fac.get();

  public Prōnōmen(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                   @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                   @NotNull final String lemma, @NotNull final String scrīptiō) {
    super(Catēgoria.PRŌNŌMEN, speciālitās, genus, cāsus, numerālis, lemma, scrīptiō);
    nūntius.plūsGarriō("Scrībor ut", scrīptiō);
  }
}
