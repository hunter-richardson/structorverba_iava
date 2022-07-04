package com.structorverba.officia.lectores;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.Tenor;
import com.structorverba.officia.verba.Verbum;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.*;
import java.util.function.Supplier;

/**
 * Classis {@link Lector} colliget data ā scāpō XML intrā
 * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>
 * ut rēbus classis {@link Verbum} scrībat.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Lector <Hoc extends Verbum <Hoc>> extends Omne {
  /**
   * Valor hic est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Valor hic est vās classis {@link Tenor} classī hui.
   */
  @NonNull protected final Tenor <Hoc> tenor;

  /**
   * Valor hic extēnsiōnem classī {@link Verbum} dēsignat scrībere.
   * {@link Categoria#scriptio} quoque nōminātur scrīnium
   * intrā quō scāpum eius cōnservātum est.
   * @see Categoria
   */
  @NonNull protected final Categoria categoria;

  @Nullable public abstract Hoc fortuitumLegam();

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link #categoria} indicat.
   * @param nts  valōrem {@link #nuntius} supplet.
   * @param tnr  valōrem {@link #tenor} supplet.
   */
  protected Lector(@NonNull final Categoria ctgr, @NonNull final Supplier <? extends Nuntius> nts,
                   @NonNull final Supplier<? extends Tenor <Hoc>> tnr) {
    nuntius = nts.get();
    tenor = tnr.get();
    categoria = ctgr;
  }

  private boolean quaero(@NonNull final String verbum) {
    final Path nomen = Paths.get(categoria.scriptio, String.format("%s.xml", Utilitas.minusculasScribo(verbum)));
    nuntius.noto("Iam exspectō scāpum auxiliārem", nomen);
    final File scapus = Paths.get(Utilitas.auxilior(nomen.toString())).toFile();
    return scapus.exists() && scapus.isFile() && scapus.canRead() && scapus.length() > 0;
  }

  /**
   * Modus hic verbum cōnābitur legere ā scāpō XML intrā
   * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>.
   * @param verbum lemma verbō quod rēs haec cōnābitur legere.
   */
  protected final void legam(@NonNull final String verbum) {
    final Path nomen = Paths.get(categoria.scriptio, String.format("%s.xml", Utilitas.minusculasScribo(verbum)));
    if (quaero(verbum)) {
      try {
        final XMLReader lector = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        lector.setContentHandler(tenor);
        nuntius.noto("Iam legō scāpum auxiliārem", nomen);
        lector.parse(Utilitas.auxilior(nomen.toString()));
      } catch (IOException | ParserConfigurationException | SAXException e) {
        nuntius.terreo(e);
      }
    } else {
      nuntius.moneo("Abest scāpum auxiliāris", nomen);
    }
  }
}
