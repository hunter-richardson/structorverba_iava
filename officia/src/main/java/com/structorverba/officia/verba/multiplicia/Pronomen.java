package officia.src.main.java.com.structorverba.officia.verba.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.multiplicia.ConditorPronominibus;
import officia.src.main.java.com.structorverba.officia.inventores.InventorPronominibus;
import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.tenores.TenorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Pronomen} repraesentat pr\u014Dn\u014Dmina ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#PRONOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in
 * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/pr\u014Dn\u014Dmina.
 * @see LectorMultiplicibus.LectorPronominibus
 * @see TenorMultiplicibus.TenorPronominibus
 * @see InventorPronominibus
 * @see ConditorPronominibus
 * @see Nuntius.NuntiusPronominum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Pronomen extends Nominalis <Pronomen> {
  @Getter(lazy = true)
  @NotNull private final Nuntius.NuntiusPronominum nuntius = Nuntius.NuntiusPronominum.fac.get();

  public Pronomen(@NotNull final Specialitas specialitas, @NotNull final Genus genus,
                   @NotNull final Casus casus, @NotNull final Numeralis numeralis,
                   @NotNull final String lemma, @NotNull final String scriptio) {
    super(Categoria.PRONOMEN, specialitas, genus, casus, numeralis, lemma, scriptio);
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }
}
