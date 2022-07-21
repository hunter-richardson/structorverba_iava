package com.structorverba.officia.quadriiugia;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.interfacta.*;
import com.structorverba.officia.verba.multiplicia.*;
import jakarta.ejb.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.function.*;

/**
 * Classis {@link Inventor} cōlit rēs classis {@link Verbum.Multiplex} quās rēs classis {@link Tenor.Multiplicibus}
 * referat.
 * @param <Hoc> classis extenta classis {@link Verbum.Multiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Inventor <Hoc extends Inventabile<Hoc> & Inflectabile<Hoc>> extends Omne {
  @NonNull @Accessors(fluent = true) @Getter(value = AccessLevel.PUBLIC, lazy = true)
  private static final Function<Categoria, Inventor<?>> inventor =
          categoria -> (Inventor<?>) switch (categoria) {
            case ACTUS       -> Actis.faciendum;
            case ADIECTIVUM  -> Adiectivis.faciendum;
            case ADVERBIUM   -> Adverbiis.faciendum;
            case NOMEN       -> Nominibus.faciendum;
            case PRONOMEN    -> Pronominibus.faciendum;
            default          -> null;
          };

  /**
   * Hic valor est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Hoc officium cōnstructōrem reī huius classis perpetrat.
   * @param categoria valōrem extēnsiōnem classī {@link Verbum} dēsignat scrībere.
   * @see Categoria
   */
  protected Inventor(@NonNull final Categoria categoria) {
    nuntius = Nuntius.Inventori.nuntius().apply(categoria);
  }

  /**
   * Hic modus seriem {@code illa} huic reī indit.
   * @param illa seriem ēnumerātiōnum indendam
   * @return Huius rem
   * @see #allegam(Enum)
   */
  @NonNull public final Inventor <Hoc> allego(@NonNull final Enum <?>... illa) {
    Arrays.stream(illa).forEach(this::allegam);
    return this;
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link Lector.Multiplicibus} ūtātur rēs classis {@link Hoc} percolere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @NonNull public abstract Predicate <Hoc> inquiram();

  /**
   * Hic modus hanc rem restituit.
   */
  public abstract void restituo();

  /**
   * Hic modus ēnumerātiōnem singulum {@code illud} huic reī indit.
   * @param illud ēnumerātiōnem indendam
   */
  protected abstract void allegam(final Enum <?> illud);

  /**
   * Classis {@link Actis} est vās classis {@link Inventor} classī {@link Actus}.
   * @see Actus
   * @see Nuntius.Inventori.Actis
   */
  @Singleton @DependsOn("Nuntius.Inventori.Actis")
  public static final class Actis extends Inventor <Actus> {
    @Nullable
    private static Actis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Actis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Actis());

    @NonNull private Vox       vox       = Vox.NULLA;
    @NonNull private Tempus    tempus    = Tempus.INTEMPORALE;
    @NonNull private Numeralis numeralis = Numeralis.NULLUS;
    @NonNull private Persona   persona   = Persona.NULLA;
    @NonNull private Modus     modus     = Modus.NULLUS;

    private Actis() {
      super(Categoria.ACTUS);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * @return Quaestiōnem quam rēs classis {@link Lector.Actis} ūtātur rēs classis {@link Actus}
     *   percōlere
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
     */
    @Override @NonNull
    public Predicate <Actus> inquiram() {
      return actum -> modus.equals(actum.modus) &&
                      vox.equals(actum.vox) &&
                      tempus.equals(actum.tempus) &&
                      numeralis.equals(actum.numeralis) &&
                      persona.equals(actum.persona);
    }

    /**
     * {@inheritDoc}
     * @see Vox#NULLA
     * @see Tempus#INTEMPORALE
     * @see Numeralis#NULLUS
     * @see Persona#NULLA
     * @see Modus#NULLUS
     */
    @Override public void restituo() {
      vox = Vox.NULLA;
      tempus = Tempus.INTEMPORALE;
      numeralis = Numeralis.NULLUS;
      persona = Persona.NULLA;
      modus = Modus.NULLUS;
      nuntius.certioro("Restitūtus sum");
    }

    /**
     * {@inheritDoc}
     * @param illud ēnumerātiōnem indendam
     * @see Vox#ut(Enum)
     * @see Tempus#ut(Enum)
     * @see Numeralis#ut(Enum)
     * @see Persona#ut(Enum)
     * @see Modus#ut(Enum)
     */
    @Override protected void allegam(@NonNull final Enum <?> illud) {
      String pittacium;
      if (illud instanceof Vox) {
        vox = Vox.ut(illud);
        pittacium = Vox.pittacium;
      } else if (illud instanceof Tempus) {
        tempus = Tempus.ut(illud);
        pittacium = Tempus.pittacium;
      } else if (illud instanceof Numeralis) {
        numeralis = Numeralis.ut(illud);
        pittacium = Numeralis.pittacium;
      } else if (illud instanceof Persona) {
        persona = Persona.ut(illud);
        pittacium = Persona.pittacium;
      } else if (illud instanceof Modus) {
        modus = Modus.ut(illud);
        pittacium = Modus.pittacium;
      } else {
        nuntius.moneo(Categoria.ACTUS.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                      "inquīsītiō inopīnāta ūsa'st:", illud);
        return;
      }

      nuntius.garrio("Quaestionī adiēcī conditiōnem novam:", pittacium, illud);
    }
  }

  /**
   * Classis {@link Adverbiis} est vās classis {@link Inventor} classī {@link Adverbium}.
   * @see Adverbium
   * @see Nuntius.Inventori.Adverbiis
   */
  @Singleton @DependsOn({"Nuntius.Inventori.Adverbiis", "Constructor.Adverbii"})
  public static class Adverbiis extends Inventor <Adverbium> {
    @Nullable private static Adverbiis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Adverbiis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Adverbiis());

    @NonNull private Gradus gradus = Gradus.NULLUS;

    private Adverbiis() {
      super(Categoria.ADVERBIUM);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * @return Quaestiīnem quam rēs classis {@link Lector.Adverbiis} ūtātur rēs classis {@link
     *   Adverbium} percīlere
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
     */
    @Override @NonNull
    public Predicate <Adverbium> inquiram() {
      return adverbium -> gradus.equals(adverbium.gradus);
    }

    /**
     * Hic modus hanc rem restituit.
     * @see Gradus#NULLUS
     */
    @Override public void restituo() {
      gradus = Gradus.NULLUS;
    }

    /**
     * Hic modus ēnumerātiīnem singulum {@code illud} huic reī indit.
     * @param illud ēnumerātiīnem indendam
     * @see Gradus#ut(Enum)
     */
    @Override protected void allegam(Enum <?> illud) {
      if (illud instanceof Gradus) {
        gradus = Gradus.ut(illud);
        nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", Gradus.pittacium, illud);
      } else {
        nuntius.moneo(Categoria.ADVERBIUM.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                      "inquīsītiō adiectīvō inopīnāta ūsa'st:", illud);
      }
    }
  }

  static abstract class Declinabilibus<Hoc extends Verbum.Multiplex.Declinabile<Hoc>> extends Inventor<Hoc> {
    /**
     * Hic valor dēsignat utrum haec rēs repraesentat certum necne.
     * @see Specialitas
     */
    @NonNull protected Specialitas specialitas = Specialitas.NULLUM;

    /**
     * Hic valor generem reī huius dēsignat.
     * @see Genus
     */
    @NonNull protected Genus       genus       = Genus.NULLUM;

    /**
     * Hic valor cāsum reī huius dēsignat.
     * @see Casus
     */
    @NonNull protected Casus       casus       = Casus.DERECTUS;

    /**
     * Hic valor numerum reī huius dēsignat.
     * @see Numeralis
     */
    @NonNull protected Numeralis   numeralis   = Numeralis.NULLUS;

    /**
     * Hoc officium cōnstructōrem reī huius classis perpetrat.
     * @param categoria valōrem extēnsiōnem classī {@link Verbum} dēsignat scrībere.
     */
    protected Declinabilibus(@NonNull final Categoria categoria) {
      super(categoria);
    }
  }

  /**
   * Classis {@link Adiectivis} est vās classis {@link Inventor} classī {@link Adiectivum}.
   * @see Adiectivum
   * @see Nuntius.Inventori.Adiectivis
   */
  @Singleton @DependsOn({"Nuntius.Inventori.Adiectivis", "Constuctor.Adiectivi"})
  public static final class Adiectivis extends Declinabilibus <Adiectivum> {
    @Nullable private static Adiectivis instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Adiectivis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Adiectivis());

    @NonNull private Gradus gradus = Gradus.NULLUS;

    private Adiectivis() {
      super(Categoria.ADIECTIVUM);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * @return Quaestiōnem quam rēs classis {@link Lector.Adiectivis} ūtātur rēs classis {@link
     *   Adiectivum} percōlere
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
     */
    @Override @NonNull
    public Predicate <Adiectivum> inquiram() {
      return adiectivum -> specialitas.equals(adiectivum.specialitas) &&
                           genus.equals(adiectivum.genus) &&
                           casus.equals(adiectivum.casus) &&
                           numeralis.equals(adiectivum.numeralis) &&
                           gradus.equals(adiectivum.gradus);
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Numeralis#NULLUS
     * @see Casus#DERECTUS
     * @see Gradus#NULLUS
     */
    @Override public void restituo() {
      specialitas = Specialitas.NULLUM;
      genus = Genus.NULLUM;
      numeralis = Numeralis.NULLUS;
      casus = Casus.DERECTUS;
      gradus = Gradus.NULLUS;
      nuntius.certioro("Restitūtus sum");
    }

    /**
     * {@inheritDoc}
     * @param illud ēnumerātiōnem indendam
     * @see Specialitas#ut(Enum)
     * @see Genus#ut(Enum)
     * @see Numeralis#ut(Enum)
     * @see Casus#ut(Enum)
     * @see Gradus#ut(Enum)
     */
    @Override protected void allegam(@NonNull final Enum <?> illud) {
      String pittacium;
      if (illud instanceof Specialitas) {
        specialitas = Specialitas.ut(illud);
        pittacium = Specialitas.pittacium;
      } else if (illud instanceof Genus) {
        genus = Genus.ut(illud);
        pittacium = Genus.pittacium;
      } else if (illud instanceof Numeralis) {
        numeralis = Numeralis.ut(illud);
        pittacium = Numeralis.pittacium;
      } else if (illud instanceof Casus) {
        casus = Casus.ut(illud);
        pittacium = Casus.pittacium;
      } else if (illud instanceof Gradus) {
        gradus = Gradus.ut(illud);
        pittacium = Gradus.pittacium;
      } else {
        nuntius.moneo(Categoria.ADIECTIVUM.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                      "inquīsītiō adiectīvō inopīnāta ūsa'st:", illud);
        return;
      }

      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", pittacium, illud);
    }
  }

  /**
   * Classis {@link Nominibus} est vās classis {@link Inventor} classī {@link Nomen}.
   * @see Nomen
   * @see Nuntius.Inventori.Nominibus
   */
  @Singleton @DependsOn({"Nuntius.Inventori.Nominibus",  "Constructor.Nominis"})
  public static final class Nominibus extends Declinabilibus <Nomen> {
    @Nullable private static Nominibus instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier <Nominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new Nominibus());

    @NonNull private Tempus tempus = Tempus.INTEMPORALE;

    private Nominibus() {
      super(Categoria.NOMEN);
      nuntius.plurimumGarrio("Factus sum");
    }

    /**
     * @return Quaestionem quam rēs classis {@link Lector.Nominibus} ūtātur rēs classis {@link Nomen}
     *   percolere
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
     */
    @Override @NonNull
    public Predicate <Nomen> inquiram() {
      return nomen -> specialitas.equals(nomen.specialitas) &&
                      genus.equals(nomen.genus) &&
                      casus.equals(nomen.casus) &&
                      numeralis.equals(nomen.numeralis) &&
                      tempus.equals(nomen.tempus);
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Numeralis#NULLUS
     * @see Casus#DERECTUS
     * @see Tempus#INTEMPORALE
     */
    @Override public void restituo() {
      specialitas = Specialitas.NULLUM;
      genus = Genus.NULLUM;
      numeralis = Numeralis.NULLUS;
      casus = Casus.DERECTUS;
      tempus = Tempus.INTEMPORALE;
      nuntius.certioro("Restitūtus sum");
    }

    /**
     * {@inheritDoc}
     * @param illud ēnumerātiōnem indendam
     * @see Specialitas#ut(Enum)
     * @see Genus#ut(Enum)
     * @see Numeralis#ut(Enum)
     * @see Casus#ut(Enum)
     * @see Tempus#ut(Enum)
     */
    @Override protected void allegam(@NonNull final Enum <?> illud) {
      String pittacium;
      if (illud instanceof Specialitas) {
        specialitas = Specialitas.ut(illud);
        pittacium = Specialitas.pittacium;
      } else if (illud instanceof Genus) {
        genus = Genus.ut(illud);
        pittacium = Genus.pittacium;
      } else if (illud instanceof Numeralis) {
        numeralis = Numeralis.ut(illud);
        pittacium = Numeralis.pittacium;
      } else if (illud instanceof Casus) {
        casus = Casus.ut(illud);
        pittacium = Casus.pittacium;
      } else if (illud instanceof Tempus) {
        tempus = Tempus.ut(illud);
        pittacium = Tempus.pittacium;
      } else {
        nuntius.moneo(Categoria.NOMEN.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                      "inquīsītiō nōminī inopīnāta ūsa'st:", illud);
        return;
      }

      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", pittacium, illud);
    }
  }

  /**
   * Classis {@link Pronominibus} est vēs classis {@link Inventor} classī {@link Pronomen}.
   * @see Pronomen
   * @see Nuntius.Inventori.Pronominibus
   */
  @Singleton @DependsOn({"Nuntius.Inventori.Pronominibus", "Constructor.Pronominis"})
  public static final class Pronominibus extends Declinabilibus <Pronomen> {
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
     * @return Quaestiōnem quam rēs classis {@link Lector.Pronominibus} ūtūtur rēs classis {@link
     *   Pronomen} percōlere
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
     */
    @Override @NonNull
    public Predicate <Pronomen> inquiram() {
      return pronomen -> specialitas.equals(pronomen.specialitas) &&
                         genus.equals(pronomen.genus) &&
                         casus.equals(pronomen.casus) &&
                         numeralis.equals(pronomen.numeralis);
    }

    /**
     * {@inheritDoc}
     * @see Specialitas#NULLUM
     * @see Genus#NULLUM
     * @see Numeralis#NULLUS
     * @see Casus#DERECTUS
     */
    @Override public void restituo() {
      specialitas = Specialitas.NULLUM;
      genus = Genus.NULLUM;
      numeralis = Numeralis.NULLUS;
      casus = Casus.DERECTUS;
      nuntius.certioro("Restitūtus sum");
    }

    /**
     * {@inheritDoc}
     * @param illud ēnumerūtionem indendam
     * @see Specialitas#ut(Enum)
     * @see Genus#ut(Enum)
     * @see Numeralis#ut(Enum)
     * @see Casus#ut(Enum)
     */
    @Override protected void allegam(@NonNull final Enum <?> illud) {
      String pittacium;
      if (illud instanceof Specialitas) {
        specialitas = Specialitas.ut(illud);
        pittacium = Specialitas.pittacium;
      } else if (illud instanceof Genus) {
        genus = Genus.ut(illud);
        pittacium = Genus.pittacium;
      } else if (illud instanceof Numeralis) {
        numeralis = Numeralis.ut(illud);
        pittacium = Numeralis.pittacium;
      } else if (illud instanceof Casus) {
        casus = Casus.ut(illud);
        pittacium = Casus.pittacium;
      } else {
        nuntius.moneo(Categoria.PRONOMEN.declina(Casus.DATIVUS, Numeralis.SINGULARIS, true),
                      "inquīsītiō inopīnūta ūsa'st:", illud);
        return;
      }

      nuntius.garrio("Quaestiōnī adiēcī conditiōnem novam:", pittacium, illud);
    }
  }
}