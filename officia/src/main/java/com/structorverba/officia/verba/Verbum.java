package officia.src.main.java.com.structorverba.officia.verba;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.inventores.Inventor;
import officia.src.main.java.com.structorverba.officia.lectores.Lector;
import officia.src.main.java.com.structorverba.officia.miscella.*;
import officia.src.main.java.com.structorverba.officia.tenores.Tenor;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.VerbumMultiplex;
import officia.src.main.java.com.structorverba.officia.enumerationes.Categoria;

import org.jetbrains.annotations.NotNull;

/**
 * Classis {@link Verbum} repraesentat verba Lat\u012Bna, f\u014Drm\u0101s omn\u0113s
 * dat\u014Drum qu\u0101s \u016Bs\u016Bfructu\u0101ri\u012B petunt. <br>
 * Rem omnem classis huius r\u0113s classis {@link Lector} colliget
 * r\u0113s classis {@link Tenor} s\u0113liget r\u0113sque classis {@link Conditor} tandem c\u014Dnstruet. <br>
 * R\u0113s classis {@link Lector} colliget data \u0101 sc\u0101p\u014D XML intr\u0101
 * scr\u012Bnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>. <br>
 * R\u0113s classis {@link Inventor} \u016Btitur c\u014Dl\u0101re r\u0113s
 * multiplic\u0113s classis huius quae classem {@link VerbumMultiplex} extendit.
 * @param <Hoc> Tabell\u0101 h\u0101c classis {@link Hoc} ext\u0113nsi\u014Dnem
 *             aptam dat\u012Bs pet\u012Bt\u012Bs repraesentat.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Verbum <Hoc extends Verbum <Hoc>> extends Omne {
  /**
   * Valor hic repraesentat f\u014Drmam verb\u012B cui r\u0101d\u012Bc\u0113scit. <br>
   * Quoque n\u014Dmin\u0101tur sc\u0101pum XML qu\u014D c\u014Dnserv\u0101tum est.
   */
  @NotNull public final String lemma;

  /**
   * Valor hic ext\u0113nsi\u014Dnem class\u012B huic re\u012B huic d\u0113signat.
   * {@link Categoria#scriptio} quoque n\u014Dmin\u0101tur scr\u012Bnium
   * intr\u0101 qu\u014D sc\u0101pum eius c\u014Dnserv\u0101tum est.
   * @see Categoria
   */
  @NotNull public final Categoria catagoria;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param ctgr val\u014Drem {@link #catagoria} indicat.
   * @param lm val\u014Drem {@link #lemma} indicat.
   */
  protected Verbum(@NotNull final Categoria ctgr, @NotNull final String lm) {
    catagoria = ctgr;
    lemma = Utilitas.minusculaScribo(lm);
  }

  /**
   * @return Repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B classis {@link Verbum}.
   */
  @Override @NotNull
  public abstract String toString();
}
