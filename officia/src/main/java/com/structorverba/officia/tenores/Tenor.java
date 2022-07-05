package com.structorverba.officia.tenores;

import androidx.annotation.*;
import com.structorverba.officia.curatores.Curator;
import com.structorverba.officia.lectores.*;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.Verbum;

import org.apache.commons.lang3.StringUtils;

import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.function.*;

/**
 * Classis {@link Tenor} data lēcta ā rēbus classis {@link Lector} sēliget reīque aptae classis {@link Curator}
 * praebet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 * @see Omne
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Tenor <Hoc extends Verbum <Hoc>> extends DefaultHandler {
  /**
   * Hic valor est vās classis {@link Nuntius} classī extentī huius.
   */
  @NonNull protected final Nuntius nuntius;
  /**
   * Hic valor seriem rērum classis {@link Hoc} praebendārum ad rē classis {@link LectorMultiplicibus} tenet.
   */
  protected final @NonNull List <Hoc> series = new ArrayList <>();
  /**
   * Hic valor rem classis {@link Hoc} tenet cōnstruenumque ā reī aptae classis {@link Curator} praebendumque ad rē
   * classis {@link Lector}.
   */
  @Nullable protected Hoc hoc;

  /**
   * Hoc officium cōnstrūctōrem reī classis huius perpetrat.
   * @param nts valōrem {@link #nuntius} supplet.
   */
  protected Tenor(@NonNull final Supplier <? extends Nuntius> nts) {
    Thread.currentThread().setUncaughtExceptionHandler(Omne.NuntiusErroribus.faciendum.get());
    nuntius = nts.get();
  }

  /**
   * Hic modus fōrmam scrīptam prōvīsam ā rē classis <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.xml/org/xml/sax/XMLReader.html">XMLReader</a>
   * prōcēdit.
   * @param litterae litterae prōvīsae
   * @param incepta  positiō incepta in valōrem {@code litterae}
   * @param longitia longitia valōris {@code litterae} ūtendī
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#characters(char[],%20int,%20int)">DefaultHandler.characters</a>
   */
  @Override public final void characters(final char[] litterae, final int incepta, final int longitia) {
    String forma = new String(litterae, incepta, longitia).trim();
    if (StringUtils.isNotBlank(forma)) {
      nuntius.garrio("Verbum illu'st", forma);
      scribo(forma);
      finiam();
    } else {
      nuntius.moneo("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  /**
   * Hic modus rem aptam classis {@link Curator} imperat ut fōrmam scrīptam reī prōductae classis {@link Hoc} indat.
   * @param scriptio fōrmam scrīptam indendus
   * @see #characters(char[], int, int)
   */
  protected abstract void scribo(@NonNull final String scriptio);

  /**
   * Hic modus rem aptam classis {@link Curator} imperat cōnstrūctiōnem reīprōductae classis {@link Hoc} fīnīre.
   */
  protected abstract void finiam();
}
