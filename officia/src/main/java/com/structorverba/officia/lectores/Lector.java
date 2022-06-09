package com.structorverba.officia.lectores;

import com.structorverba.officia.miscella.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.enumerationes.Categoria;

import androidx.annotation.NonNull;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Classis {@link Lector} colliget data \u0101 sc\u0101p\u014D XML intr\u0101
 * scr\u012Bnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>
 * ut r\u0113bus classis {@link Verbum} scr\u012Bbat.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Lector <Hoc extends Verbum <Hoc>> extends Omne {
  /**
   * Valor hic est v\u0101s classis {@link Nuntius} class\u012B hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Valor hic est v\u0101s classis {@link Tenor} class\u012B hui.
   */
  @NonNull protected final Tenor <Hoc> tenor;

  /**
   * Valor hic ext\u0113nsi\u014Dnem class\u012B {@link Verbum} d\u0113signat scr\u012Bbere.
   * {@link Categoria#scriptio} quoque n\u014Dmin\u0101tur scr\u012Bnium
   * intr\u0101 qu\u014D sc\u0101pum eius c\u014Dnserv\u0101tum est.
   * @see Categoria
   */
  @NonNull protected final Categoria categoria;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param ctgr val\u014Drem {@link #categoria} indicat.
   * @param nts  val\u014Drem {@link #nuntius} supplet.
   * @param tnr  val\u014Drem {@link #tenor} supplet.
   */
  protected Lector(@NonNull final Categoria ctgr, @NonNull final Supplier <@NonNull ? extends Nuntius> nts,
                   @NonNull final Supplier<? extends Tenor <Hoc>> tnr) {
    nuntius = nts.get();
    tenor = tnr.get();
    categoria = ctgr;
  }

  private boolean quaero(@NonNull final String verbum) {
    final Path nomen = Path.of(categoria.scriptio, String.format("%s.xml", Utilitas.minusculasScribo(verbum)));
    nuntius.noto("Iam exspect\u014D sc\u0101pum auxili\u0101rem", nomen);
    final File scapus = Path.of(Utilitas.auxilior(nomen.toString())).toFile();
    return scapus.exists() && scapus.isFile() && scapus.canRead() && scapus.length() > 0;
  }

  /**
   * Modus hic verbum c\u014Dn\u0101bitur legere \u0101 sc\u0101p\u014D XML intr\u0101
   * scr\u012Bnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>.
   * @param verbum lemma verb\u014D quod r\u0113s haec c\u014Dn\u0101bitur legere.
   */
  protected final void legam(@NonNull final String verbum) {
    final Path nomen = Path.of(categoria.scriptio, String.format("%s.xml", Utilitas.minusculasScribo(verbum)));
    if (quaero(verbum)) {
      try {
        final XMLReader lector = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        lector.setContentHandler(tenor);
        nuntius.noto("Iam leg\u014D sc\u0101pum auxili\u0101rem", nomen);
        lector.parse(Utilitas.auxilior(nomen.toString()));
      } catch (IOException | ParserConfigurationException | SAXException e) {
        nuntius.terreo(e);
      }
    } else {
      nuntius.moneo("Abest sc\u0101pum auxili\u0101ris", nomen);
    }
  }
}
