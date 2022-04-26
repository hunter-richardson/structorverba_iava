package net.structorverba.bibliotheca.verba.multiplicia;

import net.structorverba.bibliotheca.conditores.multiplicia.ConditōrPrōnōminibus;
import net.structorverba.bibliotheca.inventores.InventorPrōnōminibus;
import net.structorverba.bibliotheca.lectores.LēctorMultiplicibus;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.tenores.TenorMultiplicibus;
import net.structorverba.bibliotheca.enumerationes.*;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Prōnōmen} repraesentat prōnōmina ut coniectēris. <br> Rēs classis huius catēgoriam {@link
 * Catēgoria#PRŌNŌMEN} ūtuntur cōnservātaque sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina.
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
