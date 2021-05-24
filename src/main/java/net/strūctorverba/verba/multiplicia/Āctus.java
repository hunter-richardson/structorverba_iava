package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.conditōrēs.multiplicia.ConditōrĀctīs;
import net.strūctorverba.inventōrēs.InventorĀctīs;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.TenorMultiplicibus;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.jetbrains.annotations.*;

import java.util.Objects;

/**
 * Classis {@link Āctus} repraesentat nōmina ut coniectēris. <br> Rēs classis huius catēgoriam {@link Catēgoria#ĀCTUS}
 * ūtuntur et cōnservāta sunt in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/āctī.
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
  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorAdiectīvīs adiectīva =
    LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();
  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final LēctorMultiplicibus.LēctorĀctīs ācta = LēctorMultiplicibus.LēctorĀctīs.fac.get();
  @Getter(lazy = true) @Accessors(fluent = true)
  @NotNull private final Nūntius.NūntiusĀctōrum nūntius = Nūntius.NūntiusĀctōrum.fac.get();

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr",
           builderMethodName = "conditōr", buildMethodName = "condam")
  private Āctus(@NotNull final Modus modus, @NotNull final Vōx vōx, @NotNull final Tempus tempus,
                @NotNull final Numerālis numerālis, @NotNull final Persōna persōna,
                @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.ĀCTUS, fundāmen, Ūtilitās.minusculāsScrībō(scrīptiō));
    this.modus = modus;
    this.vōx = vōx;
    this.tempus = tempus;
    this.numerālis = numerālis;
    this.persōna = persōna;
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param vx    valōrem {@link #vōx} indicat.
   * @param tmps  valōrem {@link #tempus} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   */
  @Nullable public Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Tempus tmps,
                                         @NotNull final Speciālitās spclt, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerālis nmrl) {
    if (Modus.PARTICIPĀLIS.equals(modus)
        && vōx.equals(vx)
        && tempus.equals(tmps)) {
      return adiectīva().adveniam(toString(), spclt, gns, css, nmrl);
    } else {
      Āctus alium = ācta().adveniam(fundāmen, Modus.PARTICIPĀLIS, vx, tmps);
      return Objects.isNull(alium) ? null
                                   : adiectīva().adveniam(alium.toString(), spclt, gns, css, nmrl);
    }
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param vx    valōrem {@link #vōx} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see #participem(Vōx, Tempus, Speciālitās, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Speciālitās spclt,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerālis nmrl) {
    return participem(vx, tempus, spclt, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param tmps  valōrem {@link #tempus} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see #participem(Vōx, Tempus, Speciālitās, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum participem(@NotNull final Tempus tmps, @NotNull final Speciālitās spclt,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerālis nmrl) {
    return participem(vōx, tmps, spclt, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrīs dēsignātīs advenit.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns   valōrem {@link Nōminālis#genus} indicat.
   * @param css   valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl  valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see #participem(Vōx, Tempus, Speciālitās, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum participem(@NotNull final Speciālitās spclt, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerālis nmrl) {
    return participem(vōx, tempus, spclt, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} advenit ā et parametrīs dēsignātīs et {@link Vōx#PASSĪVA} et {@link
   * Tempus#FUTŪRUM} et {@link Speciālitās#COMMŪNE} et {@link Genus#MASCULĪNUM}.
   * @param css  valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl valōrem {@link Nōminālis#numerālis} indicat.
   * @return Rem classis {@link Adiectīvum} quod parametra dēsignāta quadrat.
   * @see LēctorMultiplicibus.LēctorAdiectīvīs#adveniam(String, Enum[])
   * @see Modus#PARTICIPĀLIS
   * @see Vōx#PASSĪVA
   * @see Tempus#FUTŪRUM
   * @see Speciālitās#COMMŪNE
   * @see Genus#MASCULĪNUM
   * @see #participem(Vōx, Tempus, Speciālitās, Genus, Cāsus, Numerālis)
   */
  @Nullable public Adiectīvum gerundīvum(@NotNull final Cāsus css, @NotNull final Numerālis nmrl) {
    return participem(Vōx.PASSĪVA, Tempus.FUTŪRUM, Speciālitās.COMMŪNE, Genus.MASCULĪNUM, css, nmrl);
  }
}
