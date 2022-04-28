package officia.src.main.java.com.structorverba.officia.conditores.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.*;
import officia.src.main.java.com.structorverba.officia.enumerationes.Gradus;

import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Level;

/**
 * Classis {@link ConditorAdverbiis} est v\u0101s classis {@link Conditor} class\u012B {@link Adverbium}.
 * @see Adverbium
 * @see Nuntius.NuntiusConditoriAdverbiis
 */
@SuppressWarnings("SpellCheckingInspection")
public class ConditorAdverbiis extends ConditorMultiplicibus <Adverbium> {
  @Nullable private static ConditorAdverbiis instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditorAdverbiis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorAdverbiis());

  @NotNull private Gradus gradus = Gradus.NULLUS;

  private ConditorAdverbiis() {
    super(Nuntius.NuntiusConditoriAdverbiis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Adiectivum}. <br>
   * Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s haec continet.
   */
  @SuppressWarnings("ConstantConditions")
  @Override @Nullable
  public Adverbium condam() {
    if (Objects.nonNull(gradus)
        && StringUtils.isNoneBlank(lemma, scriptio)) {
      final Adverbium hoc = new Adverbium(gradus, lemma, scriptio);
      if (Objects.isNull(hoc)) {
        nuntius.moneo(Adverbium.class.getSimpleName().replace("um", "\u012B"),
                      StringUtils.firstNonBlank(lemma, scriptio),
                      "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
        return null;
      } else {
        nuntius.certioro(Adverbium.class.getSimpleName(), scriptio,
                         "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
        return hoc;
      }
    } else {
      nuntius.moneo(Adverbium.class.getSimpleName().replace("um", "\u012B"),
                    StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @see Gradus#NULLUS
   */
  @Override public void restituo() {
    gradus = Gradus.NULLUS;
    scriptio = StringUtils.EMPTY;
  }

  /**
   * {@inheritDoc}
   * @see Gradus#definiam(String)
   * @see Verbum#lemma
   */
  @Override public void allego(@NotNull final String nomen, @NotNull final String descriptor) {
    if(Gradus.pittacium.equals(nomen)) {
      gradus = Gradus.definiam(descriptor);
    } else if(pittaciumLemmae.equals(nomen)) {
      lemma = descriptor.trim();
    } else {
        nuntius.moneo(Adiectivum.class.getSimpleName().replace("um", "\u014D"),
                      "attrib\u016Bta inop\u012Bn\u0101ta est \u016Bsa:",
                      nomen, descriptor);
        return;
      }

    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                   nomen, descriptor);
  }
}
