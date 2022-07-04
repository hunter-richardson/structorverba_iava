package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.conditores.multiplicia.ConditorActis;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.inventores.InventorActis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link Actus} repraesentat nōmina ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#ACTUS} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/āctī.
 * @see LectorMultiplicibus.LectorActis
 * @see TenorMultiplicibus.TenorActis
 * @see InventorActis
 * @see ConditorActis
 * @see NuntiusActorum
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
public final class Actus extends VerbumMultiplex <Actus> {
  /**
   * Hic valor modum reī huius dēsignat.
   * @see Modus
   */
  @NonNull public final Modus modus;
  /**
   * Hic valor vōcem reī huius dēsignat.
   * @see Vox
   */
  @NonNull public final Vox vox;
  /**
   * Hic valor temporem reī huius dēsignat.
   * @see Tempus
   */
  @NonNull public final Tempus tempus;
  /**
   * Hic valor numerum reī huius dēsignat.
   * @see Numeralis
   */
  @NonNull public final Numeralis numeralis;
  /**
   * Hic valor persōnam reī huius dēsignat.
   * @see Persona
   */
  @NonNull public final Persona persona;
  @Getter(lazy = true)
  @NonNull private final LectorMultiplicibus.LectorAdiectivis adiectiva = LectorMultiplicibus.LectorAdiectivis.faciendum.get();
  @Getter(lazy = true)
  @NonNull private final LectorMultiplicibus.LectorNominibus nomina = LectorMultiplicibus.LectorNominibus.faciendum.get();
  @Getter(lazy = true)
  @NonNull private final LectorMultiplicibus.LectorActis acta = LectorMultiplicibus.LectorActis.faciendum.get();
  @Getter(lazy = true)
  @NonNull private final NuntiusActorum nuntius = NuntiusActorum.faciendum.get();

  @Builder(access = AccessLevel.PRIVATE, toBuilder = true)
  private Actus(@NonNull final Modus modus, @NonNull final Vox vox, @NonNull final Tempus tempus,
                @NonNull final Numeralis numeralis, @NonNull final Persona persona,
                @NonNull final String lemma, @NonNull final String scriptio) {
    super(Categoria.ACTUS, lemma, Utilitas.minusculasScribo(scriptio));
    this.modus = modus;
    this.vox = vox;
    this.tempus = tempus;
    this.numeralis = numeralis;
    this.persona = persona;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

  /**
   * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
   * @param vx    valōrem {@link #vox} indicat.
   * @param tmps  valōrem {@link #tempus} indicat.
   * @param gns   valōrem {@link Nominalis#genus} indicat.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @param nmrl  valōrem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   */
  @Nullable public Adiectivum participem(@NonNull final Vox vx, @NonNull final Tempus tmps,
                                         @NonNull final Genus gns, @NonNull final Casus css,
                                         @NonNull final Numeralis nmrl) {
    if (Modus.PARTICIPALIS.equals(modus) &&
        vox.equals(vx) &&
        tempus.equals(tmps)) {
      return adiectiva.adveniam(toString(), Specialitas.COMMUNE, gns, css, nmrl);
    } else {
      Actus alium = acta.adveniam(lemma, Modus.PARTICIPALIS, vx, tmps);
      return alium == null ? null
                           : adiectiva.adveniam(alium.toString(), Specialitas.COMMUNE, gns, css, nmrl);
    }
  }

  /**
   * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
   * @param vx    valōrem {@link #vox} indicat.
   * @param gns   valōrem {@link Nominalis#genus} indicat.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @param nmrl  valōrem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Vox vx, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vx, tempus, gns, css, nmrl);
  }

  /**
   * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
   * @param tmps  valōrem {@link #tempus} indicat.
   * @param gns   valōrem {@link Nominalis#genus} indicat.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @param nmrl  valōrem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Tempus tmps, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vox, tmps, gns, css, nmrl);
  }

  /**
   * Hic modus rem classis {@link Adiectivum} ā parametrīs dēsignātīs advenit.
   * @param gns   valōrem {@link Nominalis#genus} indicat.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @param nmrl  valōrem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra dēsignāta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Genus gns, @NonNull final Casus css,
                                         @NonNull final Numeralis nmrl) {
    return participem(vox, tempus, gns, css, nmrl);
  }

  /**
   * Hic modus rem classis {@link Nomen} ā parametrīs dēsignātīs advenit.
   * @param tmps  valōrem {@link Nomen#tempus} indicat.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @return Rem classis {@link Nomen} quod parametra dēsignāta quadrat.
   * @see LectorMultiplicibus.LectorNominibus#adveniam(String, Enum[])
   * @see Tempus#GERUNDIVUS
   * @see Tempus#SUPINUS
   * @see Genus#NEUTRUM
   * @see Specialitas#COMMUNE
   */
  @Nullable public Nomen nominem(@NonNull final Tempus tmps, @NonNull final Casus css) {
    return nomina.adveniam(lemma, tmps, css, Genus.NEUTRUM, Specialitas.COMMUNE);
  }

  /**
   * Hic modus rem classis {@link Nomen} ā rē {@link Casus}
   * rēque {@link Tempus#GERUNDIVUS} dēsignātīs advenit.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @return Rem classis {@link Nomen} quod parametra dēsignāta quadrat.
   * @see Tempus#GERUNDIVUS
   * @see #nominem(Tempus, Casus)
   */
  @Nullable public Nomen geram(@NonNull final Casus css) {
    return nominem(Tempus.GERUNDIVUS, css);
  }

  /**
   * Hic modus rem classis {@link Nomen} ā rē {@link Casus}
   * rēque {@link Tempus#SUPINUS} dēsignātīs advenit.
   * @param css   valōrem {@link Nominalis#casus} indicat.
   * @return Rem classis {@link Nomen} quod parametra dēsignāta quadrat.
   * @see Tempus#SUPINUS
   * @see #nominem(Tempus, Casus)
   */
  @Nullable public Nomen cubem(@NonNull final Casus css) {
    return nominem(Tempus.SUPINUS, css);
  }

  /**
   * Classis {@link NuntiusActorum} est vās classis {@link Nuntius} classī {@link Actus}}
   * @see Actus
   */
  @Singleton
  private static final class NuntiusActorum extends Nuntius {
    @Nullable private static NuntiusActorum instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier<NuntiusActorum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusActorum());

    private NuntiusActorum() {
      super(ParametriNuntii.para(Actus.class));
    }
  }

  public static final class ConstructorActi extends Constructor<Actus> {
    @NonNull private Modus modus = Modus.NULLUS;
    @NonNull private Vox vox = Vox.NULLA;
    @NonNull private Tempus tempus = Tempus.INTEMPORALE;
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;
    @NonNull private Persona persona = Persona.NULLA;

    public void modus(@NonNull Modus modus) {
      this.modus = modus;
    }

    public void vox(@NonNull Vox vox) {
      this.vox = vox;
    }

    public void tempus(@NonNull Tempus tempus) {
      this.tempus = tempus;
    }

    public void numeralis(@NonNull Numeralis numeralis) {
      this.numeralis = numeralis;
    }

    public void persona(@NonNull Persona persona) {
      this.persona = persona;
    }

    @Nullable @Override
    public Actus build() {
      return paratus() ? Actus.builder().lemma(lemma).modus(modus).vox(vox).tempus(tempus)
                                        .numeralis(numeralis).persona(persona).scriptio(scriptio).build()
                       : null;
    }

    /**
     * {@inheritDoc}
     * @see Modus#NULLUS
     * @see Vox#NULLA
     * @see Tempus#INTEMPORALE
     * @see Numeralis#NULLUS
     * @see Persona#NULLA
     */
    @Override public void restituo() {
      numeralis = Numeralis.NULLUS;
      persona = Persona.NULLA;
      tempus = Tempus.INTEMPORALE;
      modus = Modus.NULLUS;
      vox = Vox.NULLA;
      scriptio = StringUtils.EMPTY;
      lemma = StringUtils.EMPTY;
    }
  }
}
