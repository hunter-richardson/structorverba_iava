package com.structorverba.officia.quadriiugia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.github.chaosfirebolt.converter.constants.Patterns;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.*;
import com.structorverba.officia.verba.interfacta.*;
import com.structorverba.officia.verba.multiplicia.*;
import com.structorverba.officia.verba.simplicia.*;
import jakarta.ejb.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.*;

import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;

/**
 * Classis {@link Curator} data ā rēbus classis {@link Tenor} accipit eacumque rēs classis extentārum {@link Verbum}
 * cōnstruet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Curator<Hoc extends Curabile<Hoc>> extends Omne {
  @Nullable @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
  private static final Function<Categoria, Curator<?>> curator =
          categoria -> (Curator<?>) switch (categoria) {
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
   * Hic valor extentum classem reī huic dēsignat sīcut valor {@link Verbum#catagoria}.
   * {@link Categoria#scriptio} quoque nōminātur scrīnium
   * intrā quō scāpum eius cōnservātum est.
   * @see Categoria
   */
  @NonNull protected final Categoria categoria;

  /**
   * Hic valor viam reī classis {@link Hoc} facit.
   *
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html">Function</a>
   */
  @NonNull protected final Constructor<Hoc> constructor;

  /**
   * Hic valor est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param ctgr valōrem {@link #categoria} indicat.
   */
  @SuppressWarnings("unchecked")
  protected Curator(@NonNull final Categoria ctgr) {
    categoria = ctgr;
    constructor = (Constructor<Hoc>) Constructor.verbi().apply(categoria);
    nuntius = Nuntius.Curatori.nuntius().apply(categoria);
  }

  /**
   * Hic modus rem classis {@link Hoc} cōnābitur cōnstruere.
   * @return Rem novam classis {@link Hoc}. <br> Modus hid valōrem {@code null} refert sī nōn valet valor aliquis haec rēs continet.
   */
  @Nullable public abstract Hoc curam();

  /**
   * Hic modus rem classis {@link Hoc} accipit valōrīque {@link Curator#nuntius}
   * ita refert.
   * @param hoc rem tentanda
   */
  protected void refero(@Nullable final Hoc hoc) {
    if (hoc == null) {
      nuntius.certioro(categoria.declina(Casus.NOMINATIVUS, Numeralis.SINGULARIS, true),
                       "fīnītur prōdūcere.");
    } else {
      nuntius.moneo(categoria.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                    "prōductiō formae nūllae prōcessit.");
    }
  }

  /**
   * Classis {@link Simplicibus} est vās classis {@link Curator} classibus omnibus quibus classem {@link Verbum.Simplex} extendit.
   * @param <Hoc> classis extenta classis {@link Verbum.Simplex}
   */
  public static abstract class Simplicibus<Hoc extends Immutans<Hoc> & Curabile<Hoc>> extends Curator<Hoc> {

    /**
     * Hic valor valōrem {@link Verbum#lemma} reī prōductae repraehentat.
     */
    @NonNull protected String lemma = StringUtils.EMPTY;

    /**
     * Hoc officum cōnstrūctōrem reī huius classis perpetrat.
     *
     * @param categoria valōrem {@link #categoria} indicat.
     */
    protected Simplicibus(@NonNull final Categoria categoria) {
      super(categoria);
    }

    /**
     * Hic modus valōrem {@link #lemma} indit.
     * @param lm valōrem indendum
     */
    public final void funde(@NonNull final String lm) {
      lemma = lm.trim();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public final Hoc curam() {
      final Hoc hoc = StringUtils.isNotBlank(lemma) ? constructor.lemma(lemma).build()
                                                    : null;
      refero(hoc);
      return hoc;
    }
  }

  /**
   * Classis {@link Coniunctionibus} est vās classis {@link Tenor} classī {@link Coniunctio}.
   *
   * @see Coniunctio
   * @see Nuntius.Curatori.Coniunctionibus
   */
  @Singleton @DependsOn({"Nuntius.Conditori.Coniunctionibus", "Constructor.Coniunctionis"})
  public static final class Coniunctionibus extends Simplicibus<Coniunctio> {
    @Nullable
    private static Coniunctionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull
    public static final Supplier<Coniunctionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Coniunctionibus());

    private Coniunctionibus() {
      super(Categoria.CONIUNCTIO);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Interiectionibus} est vās classis {@link Tenor} classī {@link Interiectio}.
   *
   * @see Interiectio
   * @see Nuntius.Curatori.Interiectionibus
   */
  @Singleton @DependsOn({"Nuntius.Conditori.Interiectionibus", "Constructor.Interiectionis"})
  public static final class Interiectionibus extends Simplicibus<Interiectio> {
    @Nullable
    private static Interiectionibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull
    public static final Supplier<Interiectionibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Interiectionibus());

    private Interiectionibus() {
      super(Categoria.INTERIECTIO);
      nuntius.plurimumGarrio("Factus sum");
    }
  }

  /**
   * Classis {@link Multiplicibus} est vās classis {@link Curator} classibus omnibus quibus classem {@link Verbum.Multiplex} extendit.
   * @param <Hoc> classis extenta classis {@link Verbum.Multiplex}
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static abstract class Multiplicibus<Hoc extends Inflectabile<Hoc> & Curabile<Hoc>> extends Curator<Hoc> {
    /**
     * Hic valor reparesentātiōnem scrīpta lemmae dēsignat.
     */
    public static final @NonNull String pittaciumLemmae = "lemma";

    @Nullable protected Hoc hoc = null;

    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param categoria valōrem {@link #categoria} indicat.
     */
    public Multiplicibus(@NonNull final Categoria categoria) {
      super(categoria);
    }

    /**
     * Hic modus {@link Constructor.Multiplicis#scriptio(String)} invocat.
     * @param scrpt valōrem indendum
     */
    public final void ut(@NonNull final String scrpt) {
      ((Constructor.Multiplicis<Hoc>) constructor).scriptio(scrpt);
      nuntius.garrio("Cōntrūctiōnī adiecī conditiōnem novam: scrīptu'st", scrpt);
    }

    @Override
    public final Hoc curam() {
      if(constructor.paratus()) {
        final Hoc hoc = constructor.build();
        refero(hoc);
        return hoc;
      } else {
        nuntius.moneo(categoria.declina(Casus.GENITIVUS, Numeralis.PLURALIS, true),
                      "prōductiō fōrmae nūllae prōcessit.");
        return null;
      }
    }

    protected final void allectioDefecit(@NonNull final String nomen, @NonNull final String descriptor) {
      nuntius.moneo(categoria.declina(Casus.GENITIVUS, Numeralis.PLURALIS, true),
                    "attribūta inopīnata ūsa'st", nomen, descriptor);
    }

    protected final void allectioFinita(@NonNull final String nomen, @NonNull final String descriptor) {
      nuntius.garrio("Cōntrūctiōnī adiēcī conditiōnem novam:", nomen, descriptor);
    }

    /**
     / * Hic modus hanc valōrem {@link Constructor.Multiplicis} restituit.
     * @see  Constructor.Multiplicis#restituo()
    / */
    public final void restituo() {
      constructor.restituo();
    }

    /**
     * Hic modus valōrem cognitum per valōre {@code nomen} cum valōre {@code descriptor} indit.
     * @param nomen      valōrem cognendum
     * @param descriptor valōrem indendum
     */
    public abstract void allegam(@NonNull final String nomen, @NonNull final String descriptor);
  }

  /**
   * Classis {@link Actis} est vās classis {@link Curator} classī {@link Actus}.
   * @see Actus
   * @see Nuntius.Curatori.Actis
   */
  @Singleton @DependsOn({"Nuntius.Conditori.Actis", "Constructor.Acti"})
  public static final class Actis extends Multiplicibus<Actus> {
    @Nullable private static Actis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Actis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

    private Actis() {
      super(Categoria.ACTUS);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * {@inheritDoc}
     * @see Modus#definiam(String)
     * @see Vox#definiam(String)
     * @see Tempus#definiam(String)
     * @see Numeralis#definiam(String)
     * @see Persona#definiam(String)
     * @see Verbum#lemma
     */
    @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
      switch (nomen) {
        case Modus.pittacium     -> ((Constructor.Acti) constructor).modus(Modus.definiam(descriptor));
        case Vox.pittacium       -> ((Constructor.Acti) constructor).vox(Vox.definiam(descriptor));
        case Tempus.pittacium    -> ((Constructor.Acti) constructor).tempus(Tempus.definiam(descriptor));
        case Numeralis.pittacium -> ((Constructor.Acti) constructor).numeralis(Numeralis.definiam(descriptor));
        case Persona.pittacium   -> ((Constructor.Acti) constructor).persona(Persona.definiam(descriptor));
        case pittaciumLemmae     -> constructor.lemma(descriptor.trim());
        default -> {
          allectioDefecit(nomen, descriptor);
          return;
        }
      }

      allectioFinita(nomen, descriptor);
    }
  }

  /**
   * Classis {@link Adiectivis} est vās classis {@link Curator} classī {@link Adiectivum}.
   * @see Adiectivum
   * @see Nuntius.Curatori.Adiectivis
   */
  @SuppressWarnings("SpellCheckingInspection")
  @Singleton @DependsOn("Nuntius.Conditori.Adiectivis")
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

    /**
     * {@inheritDoc}
     * @see Specialitas#definiam(String)
     * @see Genus#definiam(String)
     * @see Casus#definiam(String)
     * @see Numeralis#definiam(String)
     * @see Gradus#definiam(String)
     * @see Verbum#lemma
     */
    @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
      switch (nomen) {
        case Specialitas.pittacium -> ((Constructor.Adiectivi) constructor).specialitas(Specialitas.definiam(descriptor));
        case Genus.pittacium       -> ((Constructor.Adiectivi) constructor).genus(Genus.definiam(descriptor));
        case Numeralis.pittacium   -> ((Constructor.Adiectivi) constructor).numeralis(Numeralis.definiam(descriptor));
        case Persona.pittacium     -> ((Constructor.Adiectivi) constructor).casus(Casus.definiam(descriptor));
        case Gradus.pittacium      -> ((Constructor.Adiectivi) constructor).gradus(Gradus.definiam(descriptor));
        case pittaciumLemmae       -> constructor.lemma(descriptor.trim());
        default -> {
          allectioDefecit(nomen, descriptor);
          return;
        }
      }

      allectioFinita(nomen, descriptor);
    }
  }

  /**
   * Classis {@link Adverbiis} est vās classis {@link Curator} classī {@link Adverbium}.
   * @see Adverbium
   * @see Nuntius.Curatori.Adverbiis
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static class Adverbiis extends Multiplicibus<Adverbium> {
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

    /**
     * {@inheritDoc}
     * @see Gradus#definiam(String)
     * @see Verbum#lemma
     */
    @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
      switch (nomen) {
        case Gradus.pittacium -> ((Constructor.Adverbii) constructor).gradus(Gradus.definiam(descriptor));
        case pittaciumLemmae  -> constructor.lemma(descriptor.trim());
        default -> {
          allectioDefecit(nomen, descriptor);
          return;
        }
      }

      allectioFinita(nomen, descriptor);
    }
  }

  /**
   * Classis {@link Nominibus} est vās classis {@link Curator} classī {@link Nomen}.
   * @see Nomen
   * @see Nuntius.Curatori.Nominibus
   */
  @SuppressWarnings("SpellCheckingInspection")
  @Singleton @DependsOn("Nuntius.Conditori.Nominibus")
  public static final class Nominibus extends Multiplicibus<Nomen> {
    @Nullable private static Nominibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Nominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

    private Nominibus() {
      super(Categoria.NOMEN);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#definiam(String)
     * @see Genus#definiam(String)
     * @see Casus#definiam(String)
     * @see Numeralis#definiam(String)
     * @see Tempus#definiam(String)
     * @see Verbum#lemma
     */
    @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
      switch (nomen) {
        case Specialitas.pittacium -> ((Constructor.Nominis) constructor).specialitas(Specialitas.definiam(descriptor));
        case Genus.pittacium       -> ((Constructor.Nominis) constructor).genus(Genus.definiam(descriptor));
        case Numeralis.pittacium   -> ((Constructor.Nominis) constructor).numeralis(Numeralis.definiam(descriptor));
        case Persona.pittacium     -> ((Constructor.Nominis) constructor).casus(Casus.definiam(descriptor));
        case Tempus.pittacium      -> ((Constructor.Nominis) constructor).tempus(Tempus.definiam(descriptor));
        case pittaciumLemmae       -> constructor.lemma(descriptor.trim());
        default -> {
          allectioDefecit(nomen, descriptor);
          return;
        }
      }

      allectioFinita(nomen, descriptor);
    }
  }

  /**
   * Classis {@link Pronominibus} est vās classis {@link Curator} classī {@link Pronomen}.
   * @see Pronomen
   * @see Nuntius.Curatori.Pronominibus
   */
  @SuppressWarnings("SpellCheckingInspection")
  @Singleton @DependsOn({"Nuntius.Conditori.Pronominibus", "Constructor.Pronominis"})
  public static final class Pronominibus extends Multiplicibus<Pronomen> {
    @Nullable private static Pronominibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Pronominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Pronominibus());

    private Pronominibus() {
      super(Categoria.PRONOMEN);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#definiam(String)
     * @see Genus#definiam(String)
     * @see Casus#definiam(String)
     * @see Numeralis#definiam(String)
     * @see Verbum#lemma
     */
    @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
      switch (nomen) {
        case Specialitas.pittacium -> ((Constructor.Pronominis) constructor).specialitas(Specialitas.definiam(descriptor));
        case Genus.pittacium       -> ((Constructor.Pronominis) constructor).genus(Genus.definiam(descriptor));
        case Numeralis.pittacium   -> ((Constructor.Pronominis) constructor).numeralis(Numeralis.definiam(descriptor));
        case Persona.pittacium     -> ((Constructor.Pronominis) constructor).casus(Casus.definiam(descriptor));
        case pittaciumLemmae       -> constructor.lemma(descriptor.trim());
        default -> {
          allectioDefecit(nomen, descriptor);
          return;
        }
      }

      allectioFinita(nomen, descriptor);
    }
  }

  @Singleton @DependsOn("Nuntius.Curator.Numeris")
  public static class Numeris extends Omne {
    @Nullable private static Numeris instantia = null;

    @NonNull public static Supplier<Numeris> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Numeris());

    @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private final Nuntius.Curatori.Numeris nuntius = Nuntius.Curatori.Numeris.faciendum.get();

    @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private final Range<Short> TRACTUS_NUMERORUM = Range.between(Numerus.MINUMUM, Numerus.MAXIMUM);

    @NonNull @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private final Function<Range<Short>, IntStream> fors =
            tractus -> new Random().ints(Math.max(tractus.getMinimum(), Numerus.MINUMUM),
                                         Math.min(tractus.getMaximum(), Numerus.MAXIMUM));

    /**
     * Hic modus fōrmam temere sēligit.
     * @return Rem classis {@link Numerus} fortuītam
     * @see Random#ints()
     * @implNote  Valōrem {@code X} refert sī fūnctiō fortis dēficit.
     * */
    @Nullable public Numerus fortuitumNumeram() {
      return fortuitumNumeram(TRACTUS_NUMERORUM);
    }

    /**
     * Hic modus fōrmam temere sēligit.
     * @param tractus numerōs possibilēs fīnit.
     * @return Rem classis {@link Numerus} fortuītam
     * @see Random#ints()
     * @implNote  Valōrem {@code X} refert sī fūnctiō fortis dēficit.
     * */
    @Nullable public Numerus fortuitumNumeram(@NonNull final Range<Short> tractus) {
      return numeram(Integer.valueOf(fors.apply(tractus).distinct().findFirst().orElse(10)).shortValue());
    }

    /**
     * @param numerus numerus mathematicus
     * @return Rem classis {@link Numerus}
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     */
    @Nullable public Numerus numeram(final short numerus) {
      if(TRACTUS_NUMERORUM.contains(numerus)) {
        try {
          return Constructor.Numeri.faciendum.get().numerus(numerus).build();
        } catch (IllegalArgumentException e) {
          nuntius.terreo(e);
          return null;
        }
      } else {
        return null;
      }
    }

    /**
     * @param scriptio repraesentātiōnem scrīpta numerī mathēmaticī
     * @return Rem classis {@link Numerus}
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     */
    @Nullable public Numerus numeram(final @NonNull String scriptio) {
      if(Patterns.ROMAN_PATTERN.matcher(scriptio).matches()) {
        try {
          return Constructor.Numeri.faciendum.get().lemma(scriptio).build();
        } catch (IllegalArgumentException e) {
          nuntius.terreo(e);
          return null;
        }
      } else {
        return null;
      }
    }
  }
}
