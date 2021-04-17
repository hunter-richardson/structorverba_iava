package net.strūctorverba.lēctōrēs;

import net.strūctorverba.mīscella.Ūtilitās;
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

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Lēctor <Hoc extends Verbum <Hoc>> {
  protected final @NotNull Nūntius     nūntius;
  protected final @NotNull Tenor <Hoc> tenor;
  protected final @NotNull Catēgoria   catēgoria;

  protected Lēctor(@NotNull final Catēgoria ctgr, @NotNull final Supplier <? extends Nūntius> nts,
                   @NotNull final Supplier <@NotNull ? extends Tenor <Hoc>> tnr) {
    nūntius = nts.get();
    tenor = tnr.get();
    catēgoria = ctgr;
  }

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
      nūntius.moneō("Abest ōrdō auxiliāris", nōmen);
    }
  }

  private boolean quaerō(@NotNull final String verbum) {
    final Path nōmen = Path.of(catēgoria.scrīptiō, String.format("%s.xml", Ūtilitās.minusculāsScrībō(verbum)));
    nūntius.notō("Iam exspectō scāpum auxiliārem", nōmen);
    final File scāpus = Path.of(Ūtilitās.auxilior(nōmen.toString())).toFile();
    return scāpus.exists() && scāpus.isFile() && scāpus.canRead() && scāpus.length() > 0;
  }
}
