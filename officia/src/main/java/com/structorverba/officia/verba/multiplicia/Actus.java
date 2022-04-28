package officia.src.main.java.com.structorverba.officia.verba.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.multiplicia.ConditorActis;
import officia.src.main.java.com.structorverba.officia.inventores.InventorActis;
import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.miscella.Utilitas;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.tenores.TenorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.jetbrains.annotations.*;

import java.util.Objects;

import lombok.Getter;

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
  @NotNull public final Modus modus;
  /**
   * Valor hic v\u014Dcem re\u012B huius d\u0113signat.
   * @see Vox
   */
  @NotNull public final Vox vox;
  /**
   * Valor hic temporem re\u012B huius d\u0113signat.
   * @see Tempus
   */
  @NotNull public final Tempus tempus;
  /**
   * Valor hic numerum re\u012B huius d\u0113signat.
   * @see Numeralis
   */
  @NotNull public final Numeralis numeralis;
  /**
   * Valor hic pers\u014Dnam re\u012B huius d\u0113signat.
   * @see Persona
   */
  @NotNull public final Persona persona;
  @Getter(lazy = true)
  @NotNull private final LectorMultiplicibus.LectorAdiectivis adiectiva = LectorMultiplicibus.LectorAdiectivis.fac.get();
  @Getter(lazy = true)
  @NotNull private final LectorMultiplicibus.LectorNominibus nomina = LectorMultiplicibus.LectorNominibus.fac.get();
  @Getter(lazy = true)
  @NotNull private final LectorMultiplicibus.LectorActis acta = LectorMultiplicibus.LectorActis.fac.get();
  @Getter(lazy = true)
  @NotNull private final Nuntius.NuntiusActorum nuntius = Nuntius.NuntiusActorum.fac.get();

  public Actus(@NotNull final Modus modus, @NotNull final Vox vox, @NotNull final Tempus tempus,
               @NotNull final Numeralis numeralis, @NotNull final Persona persona,
               @NotNull final String lemma, @NotNull final String scriptio) {
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
  @Nullable public Adiectivum participem(@NotNull final Vox vx, @NotNull final Tempus tmps,
                                         @NotNull final Genus gns, @NotNull final Casus css,
                                         @NotNull final Numeralis nmrl) {
    if (Modus.PARTICIPALIS.equals(modus)
        && vox.equals(vx)
        && tempus.equals(tmps)) {
      return adiectiva.adveniam(toString(), Specialitas.COMMUNE, gns, css, nmrl);
    } else {
      Actus alium = acta.adveniam(lemma, Modus.PARTICIPALIS, vx, tmps);
      return Objects.isNull(alium) ? null
                                   : adiectiva.adveniam(alium.toString(),
                                                        Specialitas.COMMUNE, gns, css, nmrl);
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
  @Nullable public Adiectivum participem(@NotNull final Vox vx, @NotNull final Genus gns,
                                         @NotNull final Casus css, @NotNull final Numeralis nmrl) {
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
  @Nullable public Adiectivum participem(@NotNull final Tempus tmps, @NotNull final Genus gns,
                                         @NotNull final Casus css, @NotNull final Numeralis nmrl) {
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
  @Nullable public Adiectivum participem(@NotNull final Genus gns, @NotNull final Casus css,
                                         @NotNull final Numeralis nmrl) {
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
  @Nullable public Nomen nomen(@NotNull final Tempus tmps, @NotNull final Casus css) {
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
  @Nullable public Nomen gerundivus(@NotNull final Casus css) {
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
  @Nullable public Nomen supinus(@NotNull final Casus css) {
    return nomen(Tempus.SUPINUS, css);
  }
}
