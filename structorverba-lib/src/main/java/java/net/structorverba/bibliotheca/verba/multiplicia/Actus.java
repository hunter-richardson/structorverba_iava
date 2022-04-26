package net.structorverba.bibliotheca.verba.multiplicia;

import net.structorverba.bibliotheca.conditores.multiplicia.ConditōrĀctīs;
import net.structorverba.bibliotheca.inventores.InventorĀctīs;
import net.structorverba.bibliotheca.lectores.LēctorMultiplicibus;
import net.structorverba.bibliotheca.miscella.Ūtilitās;
import net.structorverba.bibliotheca.nuntii.Nūntius;
import net.structorverba.bibliotheca.tenores.TenorMultiplicibus;
import net.structorverba.bibliotheca.enumerationes.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import lombok.Getter;

/**
 * Classis {@link Āctus} repraesentat nōmina ut coniectēris. <br> Rēs classis huius catēgoriam {@link Catēgoria#ĀCTUS}
 * ūtuntur cōnservātaque sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/āctī.
 * @see LēctorMultiplicibus.LēctorĀctīs
 * @see TenorMultiplicibus.TenorĀctīs
 * @see InventorĀctīs
 * @see ConditōrĀctīs
 * @see Nūntius.NūntiusĀctōrum
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class Āctus extends VerbumMultiplex <Āctus> {
  /**
   * Valor hic modum reī huius dēsignat.
   * @see Modus
   */
  @NotNull public final Modus modus;
  /**
   * Valor hic vōcem reī huius dēsignat.
   * @see Vōx
   */
  @NotNull public final Vōx vōx;
  /**
   * Valor hic temporem reī huius dēsignat.
   * @see Tempus
   */
  @NotNull public final Tempus tempus;
  /**
   * Valor hic numerum reī huius dēsignat.
   * @see Numerālis
   */
  @NotNull public final Numerālis numerālis;
  /**
   * Valor hic persōnam reī huius dēsignat.
   * @see Persōna
   */
  @NotNull public final Persōna persōna;
  @Getter(lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorAdiectīvīs adiectīva = LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();
  @Getter(lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorNōminibus nōmina = LēctorMultiplicibus.LēctorNōminibus.fac.get();
  @Getter(lazy = true)
  @NotNull private final LēctorMultiplicibus.LēctorĀctīs ācta = LēctorMultiplicibus.LēctorĀctīs.fac.get();
  @Getter(lazy = true)
  @NotNull private final Nūntius.NūntiusĀctōrum nūntius = Nūntius.NūntiusĀctōrum.fac.get();

  public Āctus(@NotNull final Modus modus, @NotNull final Vōx vōx, @NotNull final Tempus tempus,
               @NotNull final Numerālis numerālis, @NotNull final Persōna persōna,
               @NotNull final String lemma, @NotNull final String scrīptiō) {
    super(Catēgoria.ĀCTUS, lemma, Ūtilitās.minusculāsScrībō(scrīptiō));
    this.modus = modus;
    this.vōx = vōx;
    this.tempus = tempus;
    this.numerālis = numerālis;
    this.persōna = persōna;
    nūntius.plūsGarriō("Scrībor ut", scrīptiō);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param vx    valōrem {@link #vōx} indicat.
   * @param tmps  valōrem {@link #tempus} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   */
  @Nullable public Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Tempus tmps,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerālis nmrl) {
    if (Modus.PARTICIPĀLIS.equals(modus)
        && vōx.equals(vx)
        && tempus.equals(tmps)) {
      return adiectīva.adveniam(toString(), Speciālitās.COMMŪNE, gns, css, nmrl);
    } else {
      Āctus alium = ācta.adveniam(lemma, Modus.PARTICIPĀLIS, vx, tmps);
      return Objects.isNull(alium) ? null
                                   : adiectīva.adveniam(alium.toString(),
                                                        Speciālitās.COMMŪNE, gns, css, nmrl);
    }
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param vx    valōrem {@link #vōx} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see #participem(Vōx, Tempus, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerālis nmrl) {
    return participem(vx, tempus, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param tmps  valōrem {@link #tempus} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see #participem(Vōx, Tempus, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum participem(@NotNull final Tempus tmps, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerālis nmrl) {
    return participem(vōx, tmps, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see #participem(Vōx, Tempus, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum participem(@NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerālis nmrl) {
    return participem(vōx, tempus, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Nōmen} ā parametrīs dēsignātīs advenit.
   * @param tmps  valōrem {@link Nōmen#tempus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @return Rem classis {@link Nōmen} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorNōminibus#adveniam(String, Enum[])
   * @see Tempus#GERUNDĪVUS
   * @see Tempus#SUPĪNUS
   * @see Genus#NEUTRUM
   * @see Speciālitās#COMMŪNE
   */
  @Nullable public Nōmen nōmen(@NotNull final Tempus tmps, @NotNull final Cāsus css) {
    return nōmina.adveniam(lemma, tmps, css, Genus.NEUTRUM, Speciālitās.COMMŪNE);
  }

  /**
   * Modus hic rem classis {@link Nōmen} ā rē {@link Cāsus} rēque {@link Tempus#GERUNDĪVUS} dēsignātīs advenit.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @return Rem classis {@link Nōmen} quod parametra dēsignāta quadrat.
   * @see Tempus#GERUNDĪVUS
   * @see #nōmen(Tempus, Cāsus)
   */
  @Nullable public Nōmen gerundīvus(@NotNull final Cāsus css) {
    return nōmen(Tempus.GERUNDĪVUS, css);
  }

  /**
   * Modus hic rem classis {@link Nōmen} ā rē {@link Cāsus} rēque {@link Tempus#SUPĪNUS} dēsignātīs advenit.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @return Rem classis {@link Nōmen} quod parametra dēsignāta quadrat.
   * @see Tempus#SUPĪNUS
   * @see #nōmen(Tempus, Cāsus)
   */
  @Nullable public Nōmen supīnus(@NotNull final Cāsus css) {
    return nōmen(Tempus.SUPĪNUS, css);
  }
}
