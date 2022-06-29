package com.structorverba.officia.verba.multiplicia;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.structorverba.officia.conditores.multiplicia.ConditorActis;
import com.structorverba.officia.inventores.InventorActis;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.enumerationes.*;

import lombok.*;

/**
 * Classis {@link Actus} repraesentat n\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#ACTUS} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/\u0101ct\u012B.
 * @see LectorMultiplicibus.LectorActis
 * @see TenorMultiplicibus.TenorActis
 * @see InventorActis
 * @see ConditorActis
 * @see Nuntius.NuntiusActorum
 */
@SuppressWarnings({"SpellCheckingInspection", "unused" })
public final class Actus extends VerbumMultiplex <Actus> {
  /**
   * Valor hic modum re\u012B huius d\u0113signat.
   * @see Modus
   */
  @NonNull public final Modus modus;
  /**
   * Valor hic v\u014Dcem re\u012B huius d\u0113signat.
   * @see Vox
   */
  @NonNull public final Vox vox;
  /**
   * Valor hic temporem re\u012B huius d\u0113signat.
   * @see Tempus
   */
  @NonNull public final Tempus tempus;
  /**
   * Valor hic numerum re\u012B huius d\u0113signat.
   * @see Numeralis
   */
  @NonNull public final Numeralis numeralis;
  /**
   * Valor hic pers\u014Dnam re\u012B huius d\u0113signat.
   * @see Persona
   */
  @NonNull public final Persona persona;
  @Getter(lazy = true)
  @NonNull private final LectorMultiplicibus.LectorAdiectivis adiectiva = LectorMultiplicibus.LectorAdiectivis.fac.get();
  @Getter(lazy = true)
  @NonNull private final LectorMultiplicibus.LectorNominibus nomina = LectorMultiplicibus.LectorNominibus.fac.get();
  @Getter(lazy = true)
  @NonNull private final LectorMultiplicibus.LectorActis acta = LectorMultiplicibus.LectorActis.fac.get();
  @Getter(lazy = true)
  @NonNull private final Nuntius.NuntiusActorum nuntius = Nuntius.NuntiusActorum.fac.get();

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
    nuntius.plusGarrio("Scr\u012Bbor ut", scriptio);
  }

  /**
   * Modus hic rem classis {@link Adiectivum} \u0101 parametr\u012Bs d\u0113sign\u0101t\u012Bs advenit.
   * @param vx    val\u014Drem {@link #vox} indicat.
   * @param tmps  val\u014Drem {@link #tempus} indicat.
   * @param gns   val\u014Drem {@link Nominalis#genus} indicat.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @param nmrl  val\u014Drem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra d\u0113sign\u0101ta quadrat.
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
   * Modus hic rem classis {@link Adiectivum} \u0101 parametr\u012Bs d\u0113sign\u0101t\u012Bs advenit.
   * @param vx    val\u014Drem {@link #vox} indicat.
   * @param gns   val\u014Drem {@link Nominalis#genus} indicat.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @param nmrl  val\u014Drem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra d\u0113sign\u0101ta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Vox vx, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vx, tempus, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectivum} \u0101 parametr\u012Bs d\u0113sign\u0101t\u012Bs advenit.
   * @param tmps  val\u014Drem {@link #tempus} indicat.
   * @param gns   val\u014Drem {@link Nominalis#genus} indicat.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @param nmrl  val\u014Drem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra d\u0113sign\u0101ta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Tempus tmps, @NonNull final Genus gns,
                                         @NonNull final Casus css, @NonNull final Numeralis nmrl) {
    return participem(vox, tmps, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Adiectivum} \u0101 parametr\u012Bs d\u0113sign\u0101t\u012Bs advenit.
   * @param gns   val\u014Drem {@link Nominalis#genus} indicat.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @param nmrl  val\u014Drem {@link Nominalis#numeralis} indicat.
   * @return Rem classis {@link Adiectivum} quod parametra d\u0113sign\u0101ta quadrat.
   * @see LectorMultiplicibus.LectorAdiectivis#adveniam(String, Enum[])
   * @see Modus#PARTICIPALIS
   * @see #participem(Vox, Tempus, Genus, Casus, Numeralis)
   */
  @Nullable public Adiectivum participem(@NonNull final Genus gns, @NonNull final Casus css,
                                         @NonNull final Numeralis nmrl) {
    return participem(vox, tempus, gns, css, nmrl);
  }

  /**
   * Modus hic rem classis {@link Nomen} \u0101 parametr\u012Bs d\u0113sign\u0101t\u012Bs advenit.
   * @param tmps  val\u014Drem {@link Nomen#tempus} indicat.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @return Rem classis {@link Nomen} quod parametra d\u0113sign\u0101ta quadrat.
   * @see LectorMultiplicibus.LectorNominibus#adveniam(String, Enum[])
   * @see Tempus#GERUNDIVUS
   * @see Tempus#SUPINUS
   * @see Genus#NEUTRUM
   * @see Specialitas#COMMUNE
   */
  @Nullable public Nomen nomen(@NonNull final Tempus tmps, @NonNull final Casus css) {
    return nomina.adveniam(lemma, tmps, css, Genus.NEUTRUM, Specialitas.COMMUNE);
  }

  /**
   * Modus hic rem classis {@link Nomen} \u0101 r\u0113 {@link Casus}
   * r\u0113que {@link Tempus#GERUNDIVUS} d\u0113sign\u0101t\u012Bs advenit.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @return Rem classis {@link Nomen} quod parametra d\u0113sign\u0101ta quadrat.
   * @see Tempus#GERUNDIVUS
   * @see #nomen(Tempus, Casus)
   */
  @Nullable public Nomen gerundivus(@NonNull final Casus css) {
    return nomen(Tempus.GERUNDIVUS, css);
  }

  /**
   * Modus hic rem classis {@link Nomen} \u0101 r\u0113 {@link Casus}
   * r\u0113que {@link Tempus#SUPINUS} d\u0113sign\u0101t\u012Bs advenit.
   * @param css   val\u014Drem {@link Nominalis#casus} indicat.
   * @return Rem classis {@link Nomen} quod parametra d\u0113sign\u0101ta quadrat.
   * @see Tempus#SUPINUS
   * @see #nomen(Tempus, Casus)
   */
  @Nullable public Nomen supinus(@NonNull final Casus css) {
    return nomen(Tempus.SUPINUS, css);
  }
}
