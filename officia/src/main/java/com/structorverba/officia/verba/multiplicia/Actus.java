package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.curatores.multiplicia.CuratorActis;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.interfacta.*;
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
 * @see CuratorActis
 * @see NuntiusActorum
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
public final class Actus extends Multiplex<Actus>
        implements Coniugabile<Actus>, Curabile<Actus>, Legibile<Actus>, Tenebile<Actus> {
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
  @NonNull @Getter(lazy = true)
  private final LectorMultiplicibus.LectorAdiectivis adiectiva = LectorMultiplicibus.LectorAdiectivis.faciendum.get();
  @NonNull @Getter(lazy = true)
  private final LectorMultiplicibus.LectorNominibus nomina = LectorMultiplicibus.LectorNominibus.faciendum.get();
  @NonNull @Getter(lazy = true)
  private final LectorMultiplicibus.LectorActis acta = LectorMultiplicibus.LectorActis.faciendum.get();
  @NonNull @Getter(lazy = true)
  private final NuntiusActorum nuntius = NuntiusActorum.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
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
   * {@inheritDoc}
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
   * {@inheritDoc}
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Vox vx, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vx, tempus, gns, css, nmrl);
  }

  /**
   * {@inheritDoc}
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Tempus tmps, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vox, tmps, gns, css, nmrl);
  }

  /**
   * {@inheritDoc}
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Genus gns, @NonNull final Casus css,
                                         @NonNull final Numeralis nmrl) {
    return participem(vox, tempus, gns, css, nmrl);
  }

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
   * @see Tempus#GERUNDIVUS
   * @see #nominem(Tempus, Casus)
   */
  @Nullable public Nomen geram(@NonNull final Casus css) {
    return nominem(Tempus.GERUNDIVUS, css);
  }

  /**
   * {@inheritDoc}
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
}

