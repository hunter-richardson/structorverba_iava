package net.structorverba.bibliotheca.verba.multiplicia;

import net.structorverba.bibliotheca.conditores.multiplicia.ConditōrNōminibus;
import net.structorverba.bibliotheca.inventores.InventorNōminibus;
import net.structorverba.bibliotheca.lectores.LēctorMultiplicibus;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.tenores.TenorMultiplicibus;
import net.structorverba.bibliotheca.enumerationes.*;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Nōmen} repraesentat nōmina ut coniectēris. <br> Rēs classis huius catēgoriam {@link Catēgoria#NŌMEN}
 * ūtuntur cōnservātaque sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/nōmina.
 * @see LēctorMultiplicibus.LēctorNōminibus
 * @see TenorMultiplicibus.TenorNōminibus
 * @see InventorNōminibus
 * @see ConditōrNōminibus
 * @see Nūntius.NūntiusNōminum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Nōmen extends Nōminālis <Nōmen> {
  /**
   * Valor hic tempus reī huius dēsignat.
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
