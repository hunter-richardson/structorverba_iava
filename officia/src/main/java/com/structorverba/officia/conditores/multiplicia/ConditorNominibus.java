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
 * Classis {@link ConditorNominibus} est v\u0101s classis {@link Conditor} class\u012B {@link Nomen}.
 * @see Nomen
 * @see Nuntius.NuntiusConditoriNominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriNominibus")
public final class ConditorNominibus extends ConditorMultiplicibus <Nomen> {
  @Nullable private static ConditorNominibus instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditorNominibus> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorNominibus());

  @NotNull private Specialitas specialitas = Specialitas.NULLUM;
  @NotNull private Genus       genus       = Genus.NULLUM;
  @NotNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NotNull private Casus       casus       = Casus.DERECTUS;
  @NotNull private Tempus      tempus      = Tempus.INTEMPORALE;

  private ConditorNominibus() {
    super(Nuntius.NuntiusConditoriNominibus.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Nomen}. <br>
   * Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s haec continet.
   */
  @SuppressWarnings("ConstantConditions")
  @Override @Nullable
  public Nomen condam() {
    if (ObjectUtils.allNotNull(specialitas, genus, casus, numeralis)
        && StringUtils.isNoneBlank(lemma, scriptio)) {
      final Nomen hoc = new Nomen(specialitas, genus, casus, numeralis, tempus, lemma, scriptio);
      if (Objects.isNull(hoc)) {
        nuntius.moneo(Nomen.class.getSimpleName().replace("en", "inis"),
                      StringUtils.firstNonBlank(lemma, scriptio),
                      "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
        return null;
      } else {
        nuntius.certioro(Nomen.class.getSimpleName(), scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
        return hoc;
      }
    } else {
      nuntius.moneo(Nomen.class.getSimpleName().replace("en", "inis"),
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
   * @see Tempus#definiam(String)
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
    } else if (Tempus.pittacium.equals(nomen)) {
      tempus = Tempus.definiam(descriptor);
    } else if (pittaciumLemmae.equals(nomen)) {
      lemma = descriptor.trim();
    } else {
      nuntius.moneo(Nomen.class.getSimpleName().replace("en", "\u012B"),
                    "attrib\u016Bta inop\u012Bnata \u016Bsa'st:", nomen, descriptor);
      return;
    }

    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                   nomen, descriptor);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Casus#DERECTUS
   * @see Numeralis#NULLUS
   * @see Tempus#INTEMPORALE
   */
  @Override public void restituo() {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    casus = Casus.DERECTUS;
    numeralis = Numeralis.NULLUS;
    tempus = Tempus.INTEMPORALE;
    scriptio = StringUtils.EMPTY;
    nuntius.certioro("Restit\u016Btus sum");
  }
}
