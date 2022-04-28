package officia.src.main.java.com.structorverba.officia.verba.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.multiplicia.ConditorNominibus;
import officia.src.main.java.com.structorverba.officia.inventores.InventorNominibus;
import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.tenores.TenorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Nomen} repraesentat n\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#NOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/n\u014Dmina.
 * @see LectorMultiplicibus.LectorNominibus
 * @see TenorMultiplicibus.TenorNominibus
 * @see InventorNominibus
 * @see ConditorNominibus
 * @see Nuntius.NuntiusNominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Nomen extends Nominalis <Nomen> {
  /**
   * Valor hic tempus re\u012B huius d\u0113signat.
   * @see Modus
   */
  @NotNull public final Tempus tempus;

  @Getter(lazy = true)
  @NotNull private final Nuntius.NuntiusNominum nuntius = Nuntius.NuntiusNominum.fac.get();

  public Nomen(@NotNull final Specialitas specialitas, @NotNull final Genus genus,
                @NotNull final Casus casus, @NotNull final Numeralis numeralis,
                @NotNull final Tempus tmps, @NotNull final String lemma,
                @NotNull final String scriptio) {
    super(Categoria.NOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    tempus = tmps;
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }
}
