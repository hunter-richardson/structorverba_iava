package officia.src.main.java.com.structorverba.officia.conditores.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Actus;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.*;

/**
 * Classis {@link ConditorActis} est v\u0101s classis {@link Conditor} class\u012B {@link Actus}.
 * @see Actus
 * @see Nuntius.NuntiusConditoriActis
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriActis")
public final class ConditorActis extends ConditorMultiplicibus <Actus> {
  @Nullable private static ConditorActis instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditorActis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorActis());

  @NotNull private Modus     modus     = Modus.NULLUS;
  @NotNull private Vox       vox       = Vox.NULLA;
  @NotNull private Tempus    tempus    = Tempus.INTEMPORALE;
  @NotNull private Numeralis numeralis = Numeralis.NULLUS;
  @NotNull private Persona   persona   = Persona.NULLA;

  private ConditorActis() {
    super(Nuntius.NuntiusConditoriActis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Actus}. <br>
   * Modus hid valorem {@code null} refert s\u012B non valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable @SuppressWarnings("ConstantConditions")
  public Actus condam() {
    if (ObjectUtils.allNotNull(modus, vox, tempus, numeralis, persona, numeralis)
        && StringUtils.isNoneBlank(lemma, scriptio)) {
      final Actus hoc = new Actus(modus, vox, tempus, numeralis, persona, lemma, scriptio);
      if (Objects.isNull(hoc)) {
        nuntius.moneo(Actus.class.getSimpleName().replace("us", "\u012B"),
                      StringUtils.firstNonBlank(lemma, scriptio),
                      "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
        return null;
      } else {
        nuntius.certioro(Actus.class.getSimpleName(), scriptio,
                         "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
        return hoc;
      }
    } else {
      nuntius.moneo(Actus.class.getSimpleName().replace("us", "\u012B"),
                    StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
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
  @Override public void allego(@NotNull final String nomen, @NotNull final String descriptor) {
    if(Modus.pittacium.equals(nomen)) {
      modus = Modus.definiam(descriptor);
    } else if (Vox.pittacium.equals(nomen)) {
      vox = Vox.definiam(descriptor);
    } else if (Tempus.pittacium.equals(nomen)) {
      tempus = Tempus.definiam(descriptor);
    } else if (Numeralis.pittacium.equals(nomen)) {
      numeralis = Numeralis.definiam(descriptor);
    } else if (Persona.pittacium.equals(nomen)) {
      persona = Persona.definiam(descriptor);
    } else if (pittaciumLemmae.equals(nomen)) {
      lemma = descriptor.trim();
    } else {
      nuntius.moneo(Actus.class.getSimpleName().replace("us", "\u014D"),
                    "attrib\u016Bta inop\u012Bnata \u016Bsa'st:", nomen, descriptor);
      return;
    }

    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                   nomen, descriptor);
  }

  /**
   * {@inheritDoc}
   * @see Modus#NULLUS
   * @see Vox#NULLA
   * @see Tempus#INTEMPORALE
   * @see Numeralis#NULLUS
   * @see Persona#NULLA
   */
  @Override public void restituo() {
    numeralis = Numeralis.NULLUS;
    persona = Persona.NULLA;
    tempus = Tempus.INTEMPORALE;
    modus = Modus.NULLUS;
    vox = Vox.NULLA;
    scriptio = StringUtils.EMPTY;
    nuntius.certioro("Restit\u016Btus sum");
  }
}
