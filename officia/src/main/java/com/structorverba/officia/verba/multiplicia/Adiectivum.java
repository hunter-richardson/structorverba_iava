package officia.src.main.java.com.structorverba.officia.verba.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.multiplicia.ConditorAdiectivis;
import officia.src.main.java.com.structorverba.officia.inventores.InventorAdiectivis;
import officia.src.main.java.com.structorverba.officia.lectores.LectorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.tenores.TenorMultiplicibus;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Classis {@link Adiectivum} repraesentat adiect\u012Bva ut coniect\u0113ris. <br>
 * R\u0113s classis huius cat\u0113goriam {@link Categoria#NOMEN} \u016Btuntur c\u014Dnserv\u0101taque sunt in scr\u012Bni\u014D
 * <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/adiect\u012Bva. <br>
 * Discr\u012Bmina pr\u012Bm\u014Dria inter classibus h\u0101c classeque {@link Pronomen} est huius valor {@link #gradus}.
 * @see LectorMultiplicibus.LectorAdiectivis
 * @see TenorMultiplicibus.TenorAdiectivis
 * @see InventorAdiectivis
 * @see ConditorAdiectivis
 * @see Nuntius.NuntiusAdiectivorum
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Adiectivum extends Nominalis <Adiectivum> {
  /**
   * Valor hic potentiam re\u012B huius d\u0113signat.
   * @see Gradus
   */
  @NotNull public final Gradus gradus;
  @Getter(lazy = true)
  @NotNull private final Nuntius.NuntiusAdiectivorum nuntius = Nuntius.NuntiusAdiectivorum.fac.get();

  public Adiectivum(@NotNull final Specialitas specialitas, @NotNull final Genus genus,
                     @NotNull final Casus casus, @NotNull final Numeralis numeralis,
                     @NotNull final Gradus gradus, @NotNull final String lemma,
                     @NotNull final String scriptio) {
    super(Categoria.ADIECTIVUM, specialitas, genus, casus, numeralis, lemma, scriptio);
    this.gradus = gradus;
    nuntius.plusGarrio("Scr\u016Bbor ut", scriptio);
  }
}

