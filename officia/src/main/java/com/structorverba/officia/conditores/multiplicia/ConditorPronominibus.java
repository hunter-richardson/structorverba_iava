package officia.src.main.java.com.structorverba.officia.conditores.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.Pronomen;
import officia.src.main.java.com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 * Classis {@link ConditorPronominibus} est v\u0101s classis {@link Conditor} class\u012B {@link Pronomen}.
 * @see Pronomen
 * @see Nuntius.NuntiusConditoriPronominibus
 */
@SuppressWarnings("SpellCheckingInspection")
@Singleton
@DependsOn("NuntiusConditoriPronominibus")
public final class ConditorPronominibus extends ConditorMultiplicibus <Pronomen> {
  @Nullable private static ConditorPronominibus instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public static final Supplier <ConditorPronominibus> fac =
    ( ) -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorPronominibus());

  @NotNull private Specialitas specialitas = Specialitas.NULLUM;
  @NotNull private Genus       genus       = Genus.NULLUM;
  @NotNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NotNull private Casus       casus       = Casus.DERECTUS;

  private ConditorPronominibus( ) {
    super(Nuntius.NuntiusConditoriPronominibus.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Pronomen}. <br>
   * Modus hid valorem {@code null} refert s\u012B non valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable @SuppressWarnings("ConstantConditions")
  public Pronomen condam() {
    if (ObjectUtils.allNotNull(specialitas, genus, casus, numeralis)
        && StringUtils.isNoneBlank(lemma, scriptio)) {
      final Pronomen hoc = new Pronomen(specialitas, genus, casus, numeralis, lemma, scriptio);
      if (Objects.isNull(hoc)) {
        nuntius.moneo(Pronomen.class.getSimpleName().replace("en", "inis"),
                      StringUtils.firstNonBlank(lemma, scriptio),
                      "pr\u014Dducti\u014D f\u014Drmae nullae pr\u014Dcessit.");
        return null;
      } else {
        nuntius.certioro(Pronomen.class.getSimpleName(),
                         scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
        return hoc;
      }
    } else {
      nuntius.moneo(Pronomen.class.getSimpleName().replace("en", "inis"),
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
   * @see Verbum#lemma
   */
  @Override public void allego(@NotNull final String nomen, @NotNull final String descriptor) {
    switch (nomen) {
      case "speci\u0101lit\u0101s" -> specialitas = Specialitas.definiam(descriptor);
      case "genus" -> genus = Genus.definiam(descriptor);
      case "numer\u0101lis" -> numeralis = Numeralis.definiam(descriptor);
      case "c\u0101sus" -> casus = Casus.definiam(descriptor);
      case "lemma" -> lemma = descriptor.trim();
      default -> {
        nuntius.moneo(Pronomen.class.getSimpleName().replace("en", '\u012B'),
                      "attrib\u016Bta inop\u012Bn\u0101ta est \u016Bsa:", nomen, "est", descriptor);
        return;
      }
    }

    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                   nomen, "est", descriptor);
  }

  /**
   * {@inheritDoc}
   * @see Specialitas#NULLUM
   * @see Genus#NULLUM
   * @see Casus#DERECTUS
   * @see Numeralis#NULLUS
   */
  @Override public void restituo( ) {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    casus = Casus.DERECTUS;
    numeralis = Numeralis.NULLUS;
    scriptio = StringUtils.EMPTY;
    nuntius.certioro("Restit\u016Btus sum");
  }
}
