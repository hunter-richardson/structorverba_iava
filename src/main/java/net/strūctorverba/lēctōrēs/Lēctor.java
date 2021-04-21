package net.strūctorverba.lēctōrēs;

import net.strūctorverba.mīscella.*;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;
import net.strūctorverba.verba.Verbum;
import net.strūctorverba.ēnumerātiōnēs.Catēgoria;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Classis {@link Lēctor} colliget data ā scāpō XML intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a> rēbus classis {@link Verbum} scrībere.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Lēctor <Hoc extends Verbum <Hoc>> extends Omnum {
  /**
   * Valor hic est vās classis {@link Nūntius} classī hui.
   */
  @NotNull protected final Nūntius nūntius;

  /**
   * Valor hic est vās classis {@link Tenor} classī hui.
   */
  @NotNull protected final Tenor <Hoc> tenor;

  /**
   * Valor hic extēnsiōnem classī {@link Verbum} dēsignat scrībere.
   * {@link Catēgoria#scrīptiō} quoque nōminātur scrīnium intrā quō scāpum eius cōnservātum est.
   * @see Catēgoria
   */
  @NotNull protected final Catēgoria catēgoria;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param ctgr valōrem {@link #catēgoria} indicat.
   * @param nts valōrem {@link #nūntius} supplet.
   * @param tnr valōrem {@link #tenor} supplet.
   */
  protected Lēctor(@NotNull final Catēgoria ctgr, @NotNull final Supplier <? extends Nūntius> nts,
                   @NotNull final Supplier <@NotNull ? extends Tenor <Hoc>> tnr) {
    nūntius = nts.get();
    tenor = tnr.get();
    catēgoria = ctgr;
  }

  private boolean quaerō(@NotNull final String verbum) {
    final Path nōmen = Path.of(catēgoria.scrīptiō, String.format("%s.xml", Ūtilitās.minusculāsScrībō(verbum)));
    nūntius.notō("Iam exspectō scāpum auxiliārem", nōmen);
    final File scāpus = Path.of(Ūtilitās.auxilior(nōmen.toString())).toFile();
    return scāpus.exists() && scāpus.isFile() && scāpus.canRead() && scāpus.length() > 0;
  }

  /**
   * Modus hic verbum cōnābitur legere ā scāpō XML intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>.
   * @param verbum fundāmen verbō quod rēs haec cōnābitur legere.
   */
  protected final void legam(@NotNull final String verbum) {
    final Path nōmen = Path.of(catēgoria.scrīptiō, String.format("%s.xml", Ūtilitās.minusculāsScrībō(verbum)));
    if(quaerō(verbum)) {
      try {
        final XMLReader lēctor = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        lēctor.setContentHandler(tenor);
        nūntius.notō("Iam legō scāpum auxiliārem", nōmen);
        lēctor.parse(Ūtilitās.auxilior(nōmen.toString()));
      } catch (IOException | ParserConfigurationException | SAXException e) {
        nūntius.terreō(e);
      }
    } else {
      nūntius.moneō("Abest scāpum auxiliāris", nōmen);
    }
  }
}
