package net.structorverba.bibliotheca.verba.multiplicia;

import net.structorverba.bibliotheca.conditores.multiplicia.ConditōrAdiectīvīs;
import net.structorverba.bibliotheca.inventores.InventorAdiectīvīs;
import net.structorverba.bibliotheca.lectores.LēctorMultiplicibus;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.tenores.TenorMultiplicibus;
import net.structorverba.bibliotheca.enumerationes.*;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Adiectīvum} repraesentat adiectīva ut coniectēris. <br> Rēs classis huius catēgoriam {@link
 * Catēgoria#NŌMEN} ūtuntur cōnservātaque sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva.
 * <br> Discrīmina prīmōria inter classibus hāc classeque {@link Prōnōmen} est huius valor {@link #gradus}.
 * @see LēctorMultiplicibus.LēctorAdiectīvīs
 * @see TenorMultiplicibus.TenorAdiectīvīs
 * @see InventorAdiectīvīs
 * @see ConditōrAdiectīvīs
 * @see Nūntius.NūntiusAdiectīvōrum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Adiectīvum extends Nōminālis <Adiectīvum> {
  /**
   * Valor hic potentiam reī huius dēsignat.
   * @see Gradus
   */
  @NotNull public final Gradus gradus;
  @Getter(lazy = true)
  @NotNull private final Nūntius.NūntiusAdiectīvōrum nūntius = Nūntius.NūntiusAdiectīvōrum.fac.get();

  public Adiectīvum(@NotNull final Speciālitās speciālitās, @NotNull final Genus genus,
                     @NotNull final Cāsus cāsus, @NotNull final Numerālis numerālis,
                     @NotNull final Gradus gradus, @NotNull final String lemma,
                     @NotNull final String scrīptiō) {
    super(Catēgoria.ADIECTĪVUM, speciālitās, genus, cāsus, numerālis, lemma, scrīptiō);
    this.gradus = gradus;
    nūntius.plūsGarriō("Scrībor ut", scrīptiō);
  }
}

