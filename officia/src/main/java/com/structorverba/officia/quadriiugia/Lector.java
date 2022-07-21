package com.structorverba.officia.quadriiugia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
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
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.*;
import java.util.Objects;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * Classis {@link Lector} colliget data ā scāpō XML intrā
 * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>
 * ut rēbus classis {@link Verbum} scrībat.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Lector <Hoc extends Legibile<Hoc> & Tenebile<Hoc> & Curabile<Hoc>> extends Omne {
  @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
  private static final Function<Categoria, Lector<?>> lector =
          categoria -> (Lector<?>) switch (categoria) {
            case ACTUS       -> Actis.faciendum;
            case ADIECTIVUM  -> Adiectivis.faciendum;
            case ADVERBIUM   -> Adverbiis.faciendum;
            case NOMEN       -> Nominibus.faciendum;
            case PRONOMEN    -> Pronominibus.faciendum;
            case CONIUNCTIO  -> Coniunctionibus.faciendum;
            case INTERIECTIO -> Interiectionibus.faciendum;
            default          -> null;
          };

  @NonNull private final Predicate<String> quaestio;

  /**
   * Hic valor est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Hic valor est vās classis {@link Tenor} classī hui.
   */
  @NonNull protected final Tenor <Hoc> tenor;

  /**
   * Hic valor extēnsiōnem classī {@link Verbum} dēsignat scrībere.
   * {@link Categoria#scriptio} quoque nōminātur scrīnium
   * intrā quō scāpum eius cōnservātum est.
   * @see Categoria
   */
  @NonNull protected final Categoria categoria;

  /**
   * Hic modus fōrmam temere sēligit.
   * @return Rem classis {@link Verbum} fortuītam
   * */
  @Nullable public abstract Hoc fortuitumLegam();

  /**
   * Hoc officum cōnstrūctōrem reī huius classis perpetrat.
   * @param ctgr valōrem {@link #categoria} indicat.
   */
  @SuppressWarnings("unchecked")
  protected Lector(@NonNull final Categoria ctgr) {
    categoria = ctgr;
    nuntius = Nuntius.Lectori.nuntius().apply(categoria);
    tenor = (Tenor<Hoc>) Tenor.tenor().apply(categoria);

    quaestio = verbum -> {
      final Path nomen = Paths.get(categoria.scriptio, String.format("%s.xml", Utilitas.minisculae.apply(verbum)));
      nuntius.noto("Iam exspectō scāpum auxiliārem", nomen);
      final File scapus = Paths.get(Utilitas.auxilior(nomen.toString())).toFile();
      return scapus.exists() && scapus.isFile() && scapus.canRead() && scapus.length() > 0;
    };
  }

  /**
   * Hic modus verbum cōnābitur legere ā scāpō XML intrā
   * scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>.
   * @param verbum lemma verbō quod haec rēs cōnābitur legere.
   */
  protected final void legam(@NonNull final String verbum) {
    final Path nomen = Paths.get(categoria.scriptio, String.format("%s.xml", Utilitas.minisculae.apply(verbum)));
    if (quaestio.test(verbum)) {
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

  /**
   * Classis {@link Simplicibus} est vās classis {@link Lector} classibus omnibus quibus classem {@link Verbum.Simplex} extendit.
   * @param <Hoc> classis extenta classis {@link Verbum.Simplex}
   * @see Simplicibus
   */
  @SuppressWarnings({ "SpellCheckingInspection" })
  public static abstract class Simplicibus<Hoc extends Immutans<Hoc> & Legibile<Hoc> & Tenebile<Hoc> & Curabile<Hoc>>
          extends Lector <Hoc> {
    /**
     * Hoc officum cōnstrūctōrem reī huius classis perpetrat.
     * @param ctgr valōrem {@link Lector#categoria} indicat.
     */
    protected Simplicibus(@NonNull Categoria ctgr) {
      super(ctgr);
    }

    /**
     * Hic modus ūtitur modus {@link Lector#legam(String)} ut rem classis {@link Hoc} ā valōre {@link Lector#tenor}
     * adveniat.
     * @param verbum lemma verbō quod haec rēs cōnābitur advenīre
     * @return Rem classis {@link Hoc} quam valōrem {@code verbum} quadrat. <br>
     * Hic modus valōrem {@code null} refert sī nihil quadrat valōrem {@code verbum}.
     */
    @Nullable public final Hoc adveniam(@NonNull final String verbum) {
      legam(verbum);
      final Hoc hoc = ((Tenor.Simplicibus<Hoc>) tenor).refero();
      if (hoc == null) {
        nuntius.moneo("Nīl advenī");
      } else {
        nuntius.garrio("Advenī hoc:", hoc);
      }
      return hoc;
    }

    /**
     * {@inheritDoc}
     * */
    @Nullable public final Hoc fortuitumLegam() {
      try {
        legam(Utilitas.fortuitumLegam(categoria));
      } catch (IOException e) {
        nuntius.terreo(e);
        return null;
      }

      final Hoc hoc = ((Tenor.Simplicibus<Hoc>) tenor).refero();
      if (hoc == null) {
        nuntius.moneo("Nīl advenī");
      } else {
        nuntius.garrio("Advenī hoc:", hoc);
      }
      return hoc;
    }
  }

  /**
   * Classis {@link Coniunctionibus} est vās classis {@link Lector} classī {@link Coniunctio}.
   * @see Categoria#CONIUNCTIO
   * @see Tenor.Coniunctionibus
   * @see Nuntius.Lectori.Coniunctionibus
   */
  @Singleton @DependsOn({ "Tenor.Coniunctivis", "Nuntius.Lectori.Coniunctivis" })
  public static final class Coniunctionibus extends Simplicibus<Coniunctio> {
    @Nullable private static Coniunctionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier<Coniunctionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

    private Coniunctionibus() {
      super(Categoria.CONIUNCTIO);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Interiectionibus} est vās classis {@link Lector} classi {@link Interiectio}.
   * @see Categoria#INTERIECTIO
   * @see Tenor.Interiectionibus
   * @see Nuntius.Lectori.Interiectionibus
   */
  @Singleton @DependsOn({ "Tenor.Coniunctivis", "Nuntius.Lectori.Coniunctivis" })
  public static final class Interiectionibus extends Simplicibus<Interiectio> {
    @Nullable private static Interiectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier<Interiectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

    private Interiectionibus() {
      super(Categoria.INTERIECTIO);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Lector.Multiplicibus} est vās classis {@link Lector} classibus omnibus quibus classem {@link Verbum.Multiplex} extendit.
   * @param <Hoc> classis extenta classis {@link Verbum.Multiplex}
   * @see Inventor
   * @see Tenor.Multiplicibus
   */
  public static abstract class Multiplicibus<Hoc extends Legibile<Hoc> & Inflectabile<Hoc> & Tenebile<Hoc> & Curabile<Hoc>>
          extends Lector <Hoc> {
    @NonNull private final Inventor <Hoc> inventor;

    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param categoria Valōrem {@link Lector#categoria} indicat.
     */
    @SuppressWarnings("unchecked")
    protected Multiplicibus(@NonNull final Categoria categoria) {
      super(categoria);
      inventor = (Inventor<Hoc>) Inventor.inventor().apply(categoria);
    }

    /**
     * Hic modus ūtitur modus {@link Lector#legam(String)} ut rem classis {@link Hoc} ā valōre {@link Lector#tenor}
     * adveniat.
     * @param lemma lemma verbō quod haec rēs cōnābitur advenīre
     * @param illa     seriēs ēnumerātiōnum quam licet {@link #inventor} cōlere ēventīs lēctīs
     * @return Rem classis {@link Hoc} quam valōrem {@code verbum} quadrat. <br>
     * Hic modus valōrem {@code null} refert sī nīl quadrat valōrem {@code verbum}.
     */
    @Nullable public final Hoc adveniam(@NonNull final String lemma, @NonNull final Enum <?>... illa) {
      legam(lemma);
      final Hoc hoc = ((Tenor.Multiplicibus<Hoc>) tenor).referam(inventor.allego(illa).inquiram());
      inventor.restituo();
      if (hoc == null) {
        nuntius.moneo("Nīl advenī");
      } else {
        nuntius.garrio("Advenī hoc:", hoc);
      }
      return hoc;
    }

    /**
     * {@inheritDoc}
     * */
    @Nullable public Hoc fortuitumLegam() {
      try {
        return fortuitumLegam(Utilitas.fortuitumLegam(categoria));
      } catch (IOException e) {
        nuntius.terreo(e);
        return null;
      }
    }

    /**
     * Hic modus fōrmam temere sēligit.
     * @param lemma  Lemma reī referendae
     * @return Rem classis {@link Verbum} fortuītam nōminandam
     * */
    @Nullable public Hoc fortuitumLegam(@NonNull final String lemma) {
      legam(lemma);
      final Hoc hoc = ((Tenor.Multiplicibus<Hoc>) tenor).fortuitumReferam();
      if (hoc == null) {
        nuntius.moneo("Nīl advenī");
      } else {
        nuntius.garrio("Advenī hoc:", hoc);
      }
      return hoc;
    }
  }


  /**
   * Classis {@link Adverbiis} est vās classis {@link Lector} classī {@link Adverbium}.
   * @see Categoria#ADVERBIUM
   * @see Tenor.Adverbiis
   * @see Inventor.Adverbiis
   * @see Nuntius.Lectori.Adverbiis
   */
  @Singleton @DependsOn({ "Tenor.Adverbiis", "Nuntius.Lectori.Adverbiis" })
  public static final class Adverbiis extends Multiplicibus<Adverbium> {
    @Nullable private static Adverbiis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
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
   * Classis {@link Nominibus} est vās classis {@link Lector} classī {@link Nomen}.
   * @see Categoria#NOMEN
   * @see Tenor.Nominibus
   * @see Inventor.Nominibus
   * @see Nuntius.Lectori.Nominibus
   */
  @Singleton @DependsOn({ "Tenor.Nominibus", "Nuntius.Lectori.Nominibus" })
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
   * Classis {@link Adiectivis} est vās classis {@link Lector} classī {@link Adiectivum}.
   * @see Categoria#ADIECTIVUM
   * @see Tenor.Adiectivis
   * @see Inventor.Adiectivis
   * @see Nuntius.Lectori.Adiectivis
   */
  @Singleton @DependsOn({ "Tenor.Adiectivis", "Nuntius.Lectori.Adiectivis" })
  public static final class Adiectivis extends Multiplicibus<Adiectivum> {
    @Nullable private static Adiectivis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Adiectivis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

    private Adiectivis() {
      super(Categoria.ADIECTIVUM);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Hic modus cōnābitur advenīre rem classis {@link Adiectivum} quam adiectīvum possessīvum repraesentat valōrēsque
     * {@code illa} quadrat.
     * @param numeralis dēsignat adiectīvum possessīvum sīve singulāre (id est aut {@code meum} aut {@code tuum}) sīve
     *                  plūrāle (id est aut {@code nostrum} aut {@code vestrum}) petitur
     * @param persona   persōnam adiectīvī petītī dēsignat
     * @param illa      seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @return rem classis {@link Adiectivum} quam valōrēs {@code numeralis}que {@code persona}que {@code illa}que
     *   quadrat. <br> Hic modus valorem {@code null} refert sī nihil valorēs {@code numeralis}que {@code persona}que
     *   {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/meum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/tuum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/nostrum.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/adiectīva/vestrum.xml
     * @see Numeralis
     * @see Persona
     * @see #adveniam(String, Enum[])
     */
    @SuppressWarnings("unused")
    @Nullable public Adiectivum adveniam(final Numeralis numeralis, final Persona persona, final Enum <?>... illa) {
      try {
        return adveniam(switch (persona) {
          case PRIMA -> switch (numeralis) {
            case SINGULARIS -> "meum";
            case PLURALIS   -> "nostrum";
            case NULLUS     -> throw new IllegalArgumentException(String.format("Ūsus prāvu'st %s %s",
                                                                                Numeralis.pittacium, numeralis));
          };
          case SECUNDA -> switch (numeralis) {
            case SINGULARIS -> "tuum";
            case PLURALIS   -> "vestrum";
            case NULLUS     -> throw new IllegalArgumentException(String.format("Ūsus prāvu'st %s %s",
                                                                                Numeralis.pittacium, numeralis));
          };
          case TERTIA -> "suum";
          case NULLA  -> throw new IllegalArgumentException(String.format("Ūsus prāvu'st %se %s",
                                                                          Persona.pittacium, persona));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("Nīl adveni");
        return null;
      }
    }
  }

  /**
   * Classis {@link Pronominibus} est vas classis {@link Lector} classī {@link Pronomen}.
   * @see Categoria#PRONOMEN
   * @see Tenor.Pronominibus
   * @see Inventor.Pronominibus
   * @see Nuntius.Lectori.Pronominibus
   */
  @Singleton @DependsOn({ "Tenor.Pronominibus", "Nuntius.Lectori.Pronominibus" })
  public static final class Pronominibus extends Multiplicibus<Pronomen> {
    private static @Nullable Pronominibus instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NonNull Supplier <Pronominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

    private Pronominibus() {
      super(Categoria.PRONOMEN);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Hic modus cōnābitur advenīre rem classis {@link Pronomen} quam prōnōmen possessīvum repraesentat valōrēsque
     * {@code illa} quadrat.
     * @param persona persōnam prōnimis petītī dēsignat
     * @param illa    seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs
     * @return rem classis {@link Pronomen} quam valōrēs {@code persona}que {@code illa}que quadrat. <br> Hic modus
     *   valorem {@code null} refert sī nihil valōrēs {@code persona}que {@code illa}que quadrat.
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/ego.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/tū.xml
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/prōnōmina/id.xml
     * @see Persona
     */
    @SuppressWarnings("unused")
    public @Nullable Pronomen adveniam(final Persona persona, final Enum <?>... illa) {
      try {
        return adveniam(switch (persona) {
          case PRIMA   -> "ego";
          case SECUNDA -> "tū";
          case TERTIA  -> "id";
          case NULLA   -> throw new IllegalArgumentException(String.format("Ūsus prāvu'st %se %s",
                                                                           Persona.pittacium, persona));
        }, illa);
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        nuntius.moneo("Nīl advenī");
        return null;
      }
    }
  }

  /**
   * Classis {@link Actis} est vās classis {@link Lector} classī {@link Actus}.
   * @see Categoria#ACTUS
   * @see Tenor.Actis
   * @see Inventor.Actis
   * @see Nuntius.Lectori.Actis
   */
  @Singleton @DependsOn({ "Tenor.Actis", "Nuntius.Lectori.Actis" })
  public static final class Actis extends Multiplicibus<Actus> {
    private static @Nullable Actis instantia = null;

    /**
     * Hic valor viam rei huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    public static final @NonNull Supplier <Actis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

    private Actis() {
      super(Categoria.ACTUS);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Hic modus cōnābitur advenīre rem classis {@link Actus} quam fōrma āctī "esse" repraesentat valōrēs {@code
     * illa} quadrat.
     * @param illa seriēs ēnumerātiōnum licent {@link #inventor} colere ēventīs lēctīs. <br>
     *            Hic modus valōrem {@code null} refert sī nihil valōrēs {@code illa} quadrat.
     * @return rem classis {@link Actus} quam valōrem {@code illa} quadrat
     * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/ācta/esse.xml
     */
    @SuppressWarnings("unused")
    public @Nullable Actus adveniam(@NonNull final Enum <?>... illa) {
      return adveniam("esse", illa);
    }
  }

  /**
   * Classis {@link Praepositionibus} colliget data ā scāpō XML in
   * scrinium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs
   * rēbus classis {@link Praepositio} scrībere. <br>
   * Dissimilis ā extēnsiōnibus classis {@link Lector} est quod scāpum omne seriem
   * longa ēventōrum possibilium continet. Ergō classem {@link Lector} nōn extendit. <br>
   * Scāpa quattuor sunt quae huic reī intersunt ut scāpa singulus cāsuī omnī repraesentātō:
   * {@link Casus#ABLATIVUS}QUE {@link Casus#ACCUSATIVUS}QUE {@link
   * Casus#GENITIVUS}QUE {@link Casus#VOCATIVUS}QUE.
   * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/ablātīvus.data
   * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/accūsātīvus.data
   * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/genitīvus.data
   * @see <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs/vocātīvus.data
   * @see Nuntius.Lectori.Praepositionibus
   */
  @SuppressWarnings({ "SpellCheckingInspection", "unused" })
  @Singleton @DependsOn("Nuntius.Lectori.Praepositionibus")
  public static final class Praepositionibus extends Omne {
    @Nullable private static Praepositionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Praepositionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Praepositionibus());

    @NonNull @Getter(lazy = true)
    private final Nuntius.Lectori.Praepositionibus nuntius = Nuntius.Lectori.Praepositionibus.faciendum.get();

    @NonNull private final BiPredicate<String, Casus> quaesitus = (verbum, casus) -> {
      final String nomen = Paths.get(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
      try (final BufferedReader pervidetio = new BufferedReader(new FileReader(nomen))) {
        nuntius.noto("Iam legō scāpum auxiliārem", nomen);
        return pervidetio.lines().anyMatch(linea -> linea.trim().equals(Utilitas.minisculae.apply(verbum)));
      } catch (IOException e) {
        nuntius.terreo(e);
        return false;
      }
    };

    @NonNull private final BiFunction <String, Casus, Praepositio> adventus =
            (verbum, casus) -> {
              final String nomen = Paths.get(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
              try (final BufferedReader pervidetio = new BufferedReader(new FileReader(Utilitas.auxilior(nomen)))) {
                nuntius.noto("Iam legō scāpum auxiliārem", nomen);
                final String lemma = pervidetio.lines().distinct()
                        .filter(Objects::nonNull)
                        .filter(linea -> linea.trim().equals(Utilitas.minisculae.apply(verbum)))
                        .findFirst().orElse(StringUtils.EMPTY);
                if (StringUtils.isNotBlank(lemma)) {
                  nuntius.garrio("Advenī hoc:", lemma);
                  return Constructor.Praepositionis.faciendum.get().lemma(lemma).build();
                } else {
                  nuntius.moneo("Nīl advenī verbō", verbum);
                  nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                          "assūmētur");
                  return Praepositio.assume.get();
                }
              } catch (IOException e) {
                nuntius.terreo(e);
                nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                        "assūmētur");
                return Praepositio.assume.get();
              }
            };

    private Praepositionibus() {
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * Hic modus rem classis {@link Praepositio} ā scāpo XML in scrīnium
     * <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositionēs conābitur advenīre.
     * @param verbum lemma praepositionī quod haec rēs conābitur advenīre
     * @return Rem classis {@link Praepositio} quam valorem {@code verbum} quadrat. <br> Hic modus valorem
     *   {@link Praepositio#assume} supplet sī nihil valorem {@code verbum} quadrat.
     */
    @NonNull public Praepositio adveniam(@NonNull final String verbum) {
      Casus casus = Stream.of(Casus.ABLATIVUS, Casus.ACCUSATIVUS, Casus.GENITIVUS, Casus.VOCATIVUS)
              .filter(css -> quaesitus.test(verbum, css))
              .findFirst().orElse(Casus.DERECTUS);
      if (Casus.DERECTUS.equals(casus)) {
        nuntius.moneo("Nīl advenī verbō", verbum);
        nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                "assūmētur");
        return Praepositio.assume.get();
      } else {
        return adventus.apply(verbum, casus);
      }
    }

    /**
     * Hic modus fōrmam temere sēligit.
     * @return Rem classis {@link Verbum} fortuītam
     * */
    @SuppressWarnings("unchecked")
    @NonNull public Praepositio fortuitumLegam() {
      return fortuitumLegam(Stream.of(Casus.ABLATIVUS, Casus.ACCUSATIVUS, Casus.GENITIVUS, Casus.VOCATIVUS)
              .reduce((BinaryOperator<Casus>) Utilitas.fors).orElse(Casus.DERECTUS));
    }

    /**
     * Hic modus fōrmam temere sēligit.
     * @param casus  Rēs classis {@link Casus} reī referendae
     * @return Rem classis {@link Verbum} fortuītam nōminandam
     * */
    @SuppressWarnings("unchecked")
    public Praepositio fortuitumLegam(@NonNull final Casus casus) {
      if(Casus.DERECTUS.equals(casus)) {
        nuntius.moneo("Nīl advenī verbō");
        nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                "assūmētur");
        return Praepositio.assume.get();
      } else {
        final String nomen = Paths.get(Categoria.PRAEPOSITIO.scriptio, String.format("%s.data", casus.scriptio)).toString();
        try (final BufferedReader pervidetio = new BufferedReader(new FileReader(Utilitas.auxilior(nomen)))) {
          nuntius.noto("Iam legō scāpum auxiliārem", nomen);
          final String lemma = pervidetio.lines().distinct().filter(Objects::nonNull)
                  .reduce((BinaryOperator<String>) Utilitas.fors)
                  .orElse(StringUtils.EMPTY);
          if (StringUtils.isNotBlank(lemma)) {
            nuntius.garrio("Advenī hoc:", lemma);
            return Constructor.Praepositionis.faciendum.get().lemma(lemma).build();
          } else {
            nuntius.moneo("Nīl advenī verbō");
            nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                           "assūmētur");
            return Praepositio.assume.get();
          }
        } catch (IOException e) {
          nuntius.terreo(e);
          nuntius.garrio(Categoria.PRAEPOSITIO.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                         "assūmētur");
          return Praepositio.assume.get();
        }
      }
    }
  }
}
