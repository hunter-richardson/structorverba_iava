package net.strūctorverba.verba.multiplicia;

import lombok.*;
import lombok.experimental.Accessors;
import net.strūctorverba.lēctōrēs.LēctorMultiplicibus;
import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.nūntiī.*;
import net.strūctorverba.ēnumerātiōnēs.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link Āctum} repraesentat nōmina ut coniectēris.
 * Nōmina catēgoriam {@link Catēgoria#ĀCTUM} ūtuntur et cōnservāta sunt in scrīniō <a href="../src/main/resources/ācta">ācta</a>.
 * @see LēctorMultiplicibus.LēctorĀctīs
 * @see TenorMultiplicibus.TenorĀctīs
 * @see InventorĀctīs
 * @see ConditōrĀctīs
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class Āctum extends VerbumMultiplex <Āctum> {
  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorAdiectīvīs adiectīva = LēctorMultiplicibus.LēctorAdiectīvīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull LēctorMultiplicibus.LēctorĀctīs ācta = LēctorMultiplicibus.LēctorĀctīs.fac.get();

  @Getter(lazy = true) @Accessors(fluent = true)
  private final @NotNull NūntiusĀctōrum nūntius = NūntiusĀctōrum.fac.get();

  /**
   * Valor hic modum reī huius dēsignat.
   * @see Modus
   */
  public final @NotNull Modus modus;

  /**
   * Valor hic vōcem reī huius dēsignat.
   * @see Modus
   */
  public final @NotNull Vōx vōx;

  /**
   * Valor hic temporem reī huius dēsignat.
   * @see Tempus
   */
  public final @NotNull Tempus tempus;

  /**
   * Valor hic numerum reī huius dēsignat.
   * @see Numerāle
   */
  public final @NotNull Numerāle numerāle;

  /**
   * Valor hic persōnam reī huius dēsignat.
   * @see Persōna
   */
  public final @NotNull Persōna persōna;

  @Builder(builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Āctum(@NotNull final Modus modus, @NotNull final Vōx vōx, @NotNull final Tempus tempus,
                @NotNull final Numerāle numerāle, @NotNull final Persōna persōna,
                @NotNull final String fundāmen, @NotNull final String scrīptiō) {
    super(Catēgoria.ĀCTUM, fundāmen, Ūtilitās.minusculāsScrībō(scrīptiō));
    this.modus = modus;
    this.vōx = vōx;
    this.tempus = tempus;
    this.numerāle = numerāle;
    this.persōna = persōna;
    nūntius().plūsGarriō("Scrībor ut", scrīptiō);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrī dēsignātīs advenit.
   * @return rem classis {@link Adiectīvum} quod parametrōs dēsignātōs quadrat.
   * @param vx valōrem {@link #vōx} indicat.
   * @param tmps valōrem {@link #tempus} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns valōrem {@link Nōminālis#genus} indicat.
   * @param css valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl valōrem {@link Nōminālis#numerāle} indicat.
   * @param grds valōrem {@link Adiectīvum#gradus} indicat.
   */
  public @Nullable Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Tempus tmps,
                                         @NotNull final Speciālitās spclt, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerāle nmrl, @NotNull final Gradus grds) {
    if(Modus.PARTICIPIUM.equals(modus)
       && vōx.equals(vx)
       && tempus.equals(tmps)) {
      return adiectīva().adveniam(toString(), spclt, gns, css, nmrl, grds);
    } else {
      Āctum alium = ācta().adveniam(fundāmen, Modus.PARTICIPIUM, vx, tmps);
      return Objects.isNull(alium) ? null
                                   : adiectīva().adveniam(alium.toString(), spclt, gns, css, nmrl, Gradus.NŌRMĀlE);
    }
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrī dēsignātīs advenit.
   * @return rem classis {@link Adiectīvum} quod parametrōs dēsignātōs quadrat.
   * @param vx valōrem {@link #vōx} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns valōrem {@link Nōminālis#genus} indicat.
   * @param css valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl valōrem {@link Nōminālis#numerāle} indicat.
   * @param grds valōrem {@link Adiectīvum#gradus} indicat.
   */
  public @Nullable Adiectīvum participem(@NotNull final Vōx vx, @NotNull final Speciālitās spclt,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerāle nmrl, @NotNull final Gradus grds) {
    return participem(vx, tempus, spclt, gns, css, nmrl, grds);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrī dēsignātīs advenit.
   * @return rem classis {@link Adiectīvum} quod parametrōs dēsignātōs quadrat.
   * @param tmps valōrem {@link #tempus} indicat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns valōrem {@link Nōminālis#genus} indicat.
   * @param css valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl valōrem {@link Nōminālis#numerāle} indicat.
   * @param grds valōrem {@link Adiectīvum#gradus} indicat.
   */
  public @Nullable Adiectīvum participem(@NotNull final Tempus tmps, @NotNull final Speciālitās spclt,
                                         @NotNull final Genus gns, @NotNull final Cāsus css,
                                         @NotNull final Numerāle nmrl, @NotNull final Gradus grds) {
    return participem(vōx, tmps, spclt, gns, css, nmrl, grds);
  }

  /**
   * Modus hic rem classis {@link Adiectīvum} ā parametrī dēsignātīs advenit.
   * @return rem classis {@link Adiectīvum} quod parametrōs dēsignātōs quadrat.
   * @param spclt valōrem {@link Nōminālis#speciālitās} indicat.
   * @param gns valōrem {@link Nōminālis#genus} indicat.
   * @param css valōrem {@link Nōminālis#cāsus} indicat.
   * @param nmrl valōrem {@link Nōminālis#numerāle} indicat.
   * @param grds valōrem {@link Adiectīvum#gradus} indicat.
   */
  public @Nullable Adiectīvum participem(@NotNull final Speciālitās spclt, @NotNull final Genus gns,
                                         @NotNull final Cāsus css, @NotNull final Numerāle nmrl,
                                         @NotNull final Gradus grds) {
    return participem(vōx, tempus, spclt, gns, css, nmrl, grds);
  }

  public static final class NūntiusĀctōrum extends Nūntius {
    private static @Nullable Āctum.NūntiusĀctōrum īnstantia = null;

    public static final @NotNull Supplier<NūntiusĀctōrum> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new NūntiusĀctōrum());

    private NūntiusĀctōrum( ) {
      super(ParametrīNūntiī.parā(Āctum.Conditōr.class));
    }
  }
}
