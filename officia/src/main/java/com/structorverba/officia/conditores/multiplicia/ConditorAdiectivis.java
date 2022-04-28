package officia.src.main.java.com.structorverba.officia.conditores.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.*;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.*;

/**
 * Classis {@link ConditorAdiectivis} est v\u0101s classis {@link Conditor} class\u012B {@link Adiectivum}.
 * @see Adiectivum
 * @see Nuntius.NuntiusConditoriAdiectivis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriAdiectivis")
public final class ConditorAdiectivis extends ConditorMultiplicibus <Adiectivum> {
  @Nullable private static ConditorAdiectivis instantia = null;

  /**
   * Valor hic viam rei classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditorAdiectivis> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorAdiectivis());

  @NotNull private Specialitas specialitas = Specialitas.NULLUM;
  @NotNull private Genus       genus       = Genus.NULLUM;
  @NotNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NotNull private Casus       casus       = Casus.DERECTUS;
  @NotNull private Gradus      gradus      = Gradus.NULLUS;

  private ConditorAdiectivis() {
    super(Nuntius.NuntiusConditoriAdiectivis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Adiectivum}. <br>
   * Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable @SuppressWarnings("ConstantConditions")
  public Adiectivum condam() {
    if (ObjectUtils.allNotNull(specialitas, genus, casus, numeralis, gradus)
        && StringUtils.isNoneBlank(lemma, scriptio)) {
      final Adiectivum hoc = new Adiectivum(specialitas, genus, casus, numeralis, gradus, lemma, scriptio);
      if (Objects.isNull(hoc)) {
        nuntius.moneo(Adiectivum.class.getSimpleName().replace("um", '\u012B'),
                      StringUtils.firstNonBlank(lemma, scriptio),
                      "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
        return null;
      } else {
        nuntius.certioro(Adiectivum.class.getSimpleName(),
                         scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
        return hoc;
      }
    } else {
      nuntius.moneo(Adiectivum.class.getSimpleName().replace("um", '\u012B'),
                    StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
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
  @Override public void allego(@NotNull final String nomen, @NotNull final String descriptor) {
    if (Specialitas.pittacium.equals(nomen)) {
      specialitas = Specialitas.definiam(descriptor);
    } else if (Genus.pittacium.equals(nomen)) {
      genus = Genus.definiam(descriptor);
    } else if (Numeralis.pittacium.equals(nomen)) {
      numeralis = Numeralis.definiam(descriptor);
    } else if (Persona.pittacium.equals(nomen)) {
      casus = Casus.definiam(descriptor);
    } else if (Gradus.pittacium.equals(nomen)) {
      gradus = Gradus.definiam(descriptor);
    } else if (pittaciumLemmae.equals(nomen)) {
      lemma = descriptor.trim();
    } else {
      nuntius.moneo(Adiectivum.class.getSimpleName().replace("us", '\u014D'),
                    "attrib\u016Bta inop\u012Bnata est \u016Bsa:", nomen, "est", descriptor);
      return;
    }

    nuntius.garrio("C\u014Dntructi\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                   nomen, "est", descriptor);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Casus#DERECTUS
   * @see Numeralis#NULLUS
   * @see Gradus#NULLUS
   */
  @Override public void restituo( ) {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    casus = Casus.DERECTUS;
    numeralis = Numeralis.NULLUS;
    gradus = Gradus.NULLUS;
    scriptio = StringUtils.EMPTY;
    nuntius.certioro("Restit\u016Btus sum");
  }
}
