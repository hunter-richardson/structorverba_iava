package com.structorverba.officia.quadriiugia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.interfacta.*;
import com.structorverba.officia.verba.multiplicia.*;
import com.structorverba.officia.verba.simplicia.*;
import jakarta.ejb.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.*;
import org.xml.sax.Attributes;
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
public abstract class Tenor <Hoc extends Tenebile<Hoc> & Curabile<Hoc>> extends DefaultHandler {
  @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
  private static final Function<Categoria, Tenor<?>> tenor =
          categoria -> (Tenor<?>) switch (categoria) {
            case ACTUS       -> Actis.faciendum;
            case ADIECTIVUM  -> Adiectivis.faciendum;
            case ADVERBIUM   -> Adverbiis.faciendum;
            case NOMEN       -> Nominibus.faciendum;
            case PRONOMEN    -> Pronominibus.faciendum;
            case CONIUNCTIO  -> Coniunctionibus.faciendum;
            case INTERIECTIO -> Interiectionibus.faciendum;
            default          -> null;
          };

  /**
   * Hic valor est vās classis {@link Nuntius} classī extentī huius.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Hic valor est vās classis {@link Curator.Multiplicibus} huic classī extentae.
   */
  @NonNull protected final Curator<Hoc> curator;

  /**
   * Hic valor rem classis {@link Hoc} tenet cōnstruenumque ā reī aptae classis {@link Curator} praebendumque ad rē
   * classis {@link Lector}.
   */
  @Nullable protected Hoc hoc;

  /**
   * Hoc officium cōnstrūctōrem reī classis huius perpetrat.
   * @param categoria valōrem extēnsiōnem classī {@link Verbum} dēsignat scrībere.
   */
  @SuppressWarnings({"unchecked", "ConstantConditions"})
  protected Tenor(@NonNull final Categoria categoria) {
    Thread.currentThread().setUncaughtExceptionHandler(Nuntius.Erroribus.faciendum.get());
    curator = (Curator<Hoc>) Curator.curator().apply(categoria);
    nuntius = Nuntius.Tenori.nuntius().apply(categoria);
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

  /**
   * Classis {@link Simplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link Verbum.Simplex}
   * extendit.
   * @param <Hoc> classis extenta classis {@link Verbum.Simplex}
   * @see Curator.Simplicibus
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static abstract class Simplicibus<Hoc extends Immutans<Hoc> & Tenebile<Hoc> & Curabile<Hoc>> extends Tenor <Hoc> {
    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param categoria extēnsiōnem classī {@link Verbum} dēsignat scrībere.
     */
    protected Simplicibus(@NonNull final Categoria categoria) {
      super(categoria);
    }

    /**
     * {@inheritDoc}
     */
    @Override protected final void finiam() {
      hoc = curator.curam();
      if (hoc == null) {
        nuntius.moneo("Prōductiō verbī prōcessimus nūllae fōrmae.");
      }
    }

    /**
     * @return Valōrem {@link #hoc}
     */
    @Nullable public Hoc refero() {
      return hoc;
    }

    /**
     * {@inheritDoc}
     * @param scriptio fōrmam scrīptam indendus
     * @see Verbum#lemma
     */
    @Override protected void scribo(@NonNull String scriptio) {
      ((Curator.Simplicibus<Hoc>) curator).funde(scriptio);
    }
  }

  /**
   * Classis {@link Coniunctionibus} est vās classis {@link Tenor} classī {@link Coniunctio}
   * @see Coniunctio
   * @see Nuntius.Tenori.Coniunctionibus
   * @see Curator.Coniunctionibus
   */
  @Singleton @DependsOn({ "Curator.Coniunctivis", "Nuntius.Tenori.Coniunctivis" })
  public static final class Coniunctionibus extends Simplicibus<Coniunctio> {
    @Nullable private static Coniunctionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Coniunctionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

    private Coniunctionibus() {
      super(Categoria.CONIUNCTIO);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Interiectionibus} est vās classis {@link Tenor} classī {@link Interiectio}
   * @see Interiectio
   * @see Nuntius.Tenori.Interiectionibus
   * @see Curator.Interiectionibus
   */
  @Singleton @DependsOn({ "Curator.Coniunctivis", "Nuntius.Tenori.Coniunctivis" })
  public static final class Interiectionibus extends Simplicibus<Interiectio> {
    @Nullable private static Interiectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Interiectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

    private Interiectionibus() {
      super(Categoria.INTERIECTIO);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Multiplicibus} est vās classis {@link Tenor} classibus omnibus quibus classem {@link Verbum.Multiplex} extendit.
   * @param <Hoc> classis extenta classis {@link Verbum.Multiplex}
   * @see Curator.Multiplicibus
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static abstract class Multiplicibus<Hoc extends Tenebile<Hoc> & Inflectabile<Hoc> & Curabile<Hoc>> extends Tenor <Hoc> {
    /**
     * Hic valor seriem rērum classis {@link Hoc} praebendārum ad rē classis {@link Lector.Multiplicibus} tenet.
     */
    protected final @NonNull List <Hoc> series = new ArrayList <>();

    /**
     * Hoc officium cōnstrūctōrem rei huius classis perpetrat.
     * @param categoria   valōrem extēnsiōnem classī {@link Verbum} dēsignat scrībere.
     */
    protected Multiplicibus(@NonNull final Categoria categoria) {
      super(categoria);
    }

    /**
     * Hic modus ēnumerātiōnēs prōcēdit lēctās ā rēbus classis {@link Lector.Multiplicibus}
     * @param locus     Hunc valōrem hic modus nōn ūtitur sed necessārium est ut rē classis <a
     *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
     *                  cōnsociet
     * @param loculus   Hunc valōrem hic modus nōn ūtitur sed necessārium est ut rē classis <a
     *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
     *                  cōnsociet
     * @param qualis    Hunc valōrem hic modus nōn ūtitur sed necessārium est ut rē classis <a
     *                  href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
     *                  cōnsociet
     * @param attributa seriēs valōrum nōminumque sociVtōrum
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#startElement(java.lang.String,%20java.lang.String,%20java.lang.String,%20org.xml.sax.Attributes)">DefaultHandler.startElement</a>
     */
    @Override public final void startElement(@NonNull final String locus, @NonNull final String loculus,
                                             @NonNull final String qualis, @NonNull final Attributes attributa) {

      for (int i = 0; i < attributa.getLength(); i++) {
        nuntius.garrio("Teneō adicere attribūtum novum:",
                attributa.getLocalName(i), "est", attributa.getValue(i));
        ((Curator.Multiplicibus<Hoc>) curator).allegam(attributa.getLocalName(i), attributa.getValue(i));
      }
    }

    /**
     * Hic modus rem aptam classis {@link Curator.Multiplicibus} imperat restitui.
     * @param locus   Hunc valōrem hic modus nōn ūtitur sed necessārium est ut rē classis <a
     *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
     *                cōnsociet
     * @param loculus Hunc valōrem hic modus nōn ūtitur sed necessārium est ut rē classis <a
     *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
     *                cōnsociet
     * @param qualis  Hunc valōrem hic modus nōn ūtitur sed necessārium est ut rē classis <a
     *                href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html">DefaultHandler</a>
     *                cōnsociet
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html#endElement(java.lang.String,%20java.lang.String,%20java.lang.String)">DefaultHandler.endElement</a>
     */
    @Override public final void endElement(@NonNull final String locus,
                                           @NonNull final String loculus, @NonNull final String qualis) {
      ((Curator.Multiplicibus<Hoc>) curator).restituo();
    }

    /**
     * {@inheritDoc}
     * @see Tenor.Multiplicibus#series
     */
    @Override protected final void finiam() {
      hoc = curator.curam();
      if (hoc == null) {
        nuntius.moneo("Prōductiō verbī prōcessimus nūllae fōrmae.");
      } else {
        nuntius.garrio("Aggregāvī verbum novum", hoc);
        series.add(hoc);
      }
    }

    /**
     * {@inheritDoc}
     * @param scriptio fōrmam scriptam indendus
     * @see Verbum.Multiplex#scriptio
     */
    @Override protected void scribo(@NonNull String scriptio) {
      ((Curator.Multiplicibus<Hoc>) curator).ut(scriptio);
    }

    /**
     * Hic modus rem temere in valōre {@link #series} sēligit.
     * @return Rem fortuītam
     * */
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    @Nullable public final Hoc fortuitumReferam() {
      return series.stream().distinct().filter(Objects::nonNull)
                   .reduce((BinaryOperator<Hoc>) Utilitas.fors)
                   .orElseGet(null);
    }


    /**
     * Hic modus valōrem {@link #series} per valōrem {@code quaestio} cōlat ut rem singulam prōdūcat.
     * @param quaestio quaestiō tentanda
     * @return valōrem {@link #series} valōrem {@code quaestio} percōlāta
     */
    @Nullable public final Hoc referam(Predicate<Hoc> quaestio) {
      return series.stream().distinct().filter(quaestio)
                   .findFirst().orElse(null);
    }
  }

  /**
   * Classis {@link Adverbiis} est vās classis {@link Tenor} classi {@link Adverbium}
   * @see Adverbium
   * @see Nuntius.Tenori.Adverbiis
   * @see Curator.Adverbiis
   */
  @Singleton @DependsOn({ "Curator.Adverbiis", "Nuntius.Tenori.Adverbiis" })
  public static final class Adverbiis extends Multiplicibus<Adverbium> {
    @Nullable private static Adverbiis instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Adverbiis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

    private Adverbiis() {
      super(Categoria.ADVERBIUM);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Nominibus} est vās classis {@link Tenor} classi {@link Nomen}
   * @see Nomen
   * @see Nuntius.Tenori.Nominibus
   * @see Curator.Nominibus
   */
  @Singleton @DependsOn({ "Curator.Nominibus", "Nuntius.Tenori.Nominibus" })
  public static final class Nominibus extends Multiplicibus<Nomen> {
    @Nullable private static Nominibus instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Nominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

    private Nominibus() {
      super(Categoria.NOMEN);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Adiectivis} est vās classis {@link Tenor} classi {@link Adiectivum}
   * @see Adiectivum
   * @see Nuntius.Tenori.Adiectivis
   * @see Curator.Adiectivis
   */
  @Singleton @DependsOn({ "Curator.Adiectivis", "Nuntius.Tenori.Adiectivis" })
  public static final class Adiectivis extends Multiplicibus<Adiectivum> {
    @Nullable private static Adiectivis instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Adiectivis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

    private Adiectivis() {
      super(Categoria.ADIECTIVUM);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Pronominibus} est vās classis {@link Tenor} classi {@link Pronomen}
   * @see Pronomen
   * @see Nuntius.Tenori.Pronominibus
   * @see Curator.Pronominibus
   */
  @Singleton
  @DependsOn({ "Curator.Pronominibus", "Nuntius.Tenori.Pronominibus" })
  public static final class Pronominibus extends Multiplicibus<Pronomen> {
    @Nullable private static Pronominibus instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Pronominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

    private Pronominibus() {
      super(Categoria.PRONOMEN);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Actis} est vās classis {@link Tenor} classi {@link Actus}
   * @see Actus
   * @see Nuntius.Tenori.Actis
   * @see Curator.Actis
   */
  @Singleton @DependsOn({ "ConditorActis", "Nuntius.Tenori.Actis" })
  public static final class Actis extends Multiplicibus<Actus> {
    @Nullable private static Actis instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Actis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

    private Actis() {
      super(Categoria.ACTUS);
      nuntius.plurimumGarrio("Factus sum");
    }
  }
}
