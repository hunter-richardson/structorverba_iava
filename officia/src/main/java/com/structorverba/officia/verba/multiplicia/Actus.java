package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.interfacta.*;
import jakarta.ejb.DependsOn;
import lombok.*;

import java.util.function.BiFunction;

/**
 * Classis {@link Actus} repraesentat nōmina ut coniectēris. <br>
 * Rēs huius classis catēgoriam {@link Categoria#ACTUS} ūtuntur cōnservātaque sunt in
 * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/āctī.
 * @see Lector.Actis
 * @see Tenor.Actis
 * @see Inventor.Actis
 * @see Curator.Actis
 * @see Nuntius.Verbis.Actis
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
@DependsOn("Nuntius.Verbis.Actis")
public final class Actus extends Verbum.Multiplex<Actus>
        implements Curabile<Actus>, Legibile<Actus>, Tenebile<Actus> {
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
  private final Lector.Adiectivis adiectiva = Lector.Adiectivis.faciendum.get();
  @NonNull @Getter(lazy = true)
  private final Lector.Nominibus nomina = Lector.Nominibus.faciendum.get();
  @NonNull @Getter(lazy = true)
  private final Lector.Actis acta = Lector.Actis.faciendum.get();
  @NonNull @Getter(lazy = true)
  private final Nuntius.Verbis.Actis nuntius = Nuntius.Verbis.Actis.faciendum.get();

  @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
  private Actus(@NonNull final Modus modus, @NonNull final Vox vox, @NonNull final Tempus tempus,
                @NonNull final Numeralis numeralis, @NonNull final Persona persona,
                @NonNull final String lemma, @NonNull final String scriptio) {
    super(Categoria.ACTUS, lemma, scriptio);
    this.modus = modus;
    this.vox = vox;
    this.tempus = tempus;
    this.numeralis = numeralis;
    this.persona = persona;
    nuntius.plusGarrio("Scrībor ut", scriptio);
  }

  /**
   * {@inheritDoc}
   * @see Lector.Adiectivis#adveniam(String, Enum[])
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
   * @see Lector.Adiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Vox vx, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vx, tempus, gns, css, nmrl);
  }

  /**
   * {@inheritDoc}
   * @see Lector.Adiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Tempus tmps, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vox, tmps, gns, css, nmrl);
  }

  /**
   * {@inheritDoc}
   * @see Lector.Adiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Genus gns, @NonNull final Casus css,
                                         @NonNull final Numeralis nmrl) {
    return participem(vox, tempus, gns, css, nmrl);
  }

  /**
   * {@inheritDoc}
   * @see Lector.Nominibus#adveniam(String, Enum[])
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
   * Hic modus verbum dē valōribus imputātīs dēclīnat.
   * */
  @NonNull public static BiFunction<Casus, Numeralis, String> declinatio =
          (casus, numeralis) -> "āct".concat(switch (casus) {
            case NOMINATIVUS, VOCATIVUS, DERECTUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "us";
              case PLURALIS -> "ūs";
            };
            case GENITIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "ūs";
              case PLURALIS -> "uum";
            };
            case DATIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "uī";
              case PLURALIS -> "ibus";
            };
            case ACCUSATIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "um";
              case PLURALIS -> "ūs";
            };
            case ABLATIVUS, INSTRUMENTALIS, LOCATIVUS -> switch (numeralis) {
              case SINGULARIS, NULLUS -> "ū";
              case PLURALIS -> "ibus";
            };
          });
}
