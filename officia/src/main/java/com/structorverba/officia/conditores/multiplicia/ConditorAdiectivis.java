package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Adiectivum;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

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
  @NonNull public static final Supplier <ConditorAdiectivis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorAdiectivis());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;
  @NonNull private Gradus      gradus      = Gradus.NULLUS;

  private ConditorAdiectivis() {
    super(Nuntius.NuntiusConditoriAdiectivis.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Adiectivum}. <br>
   * Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable
  public Adiectivum condam() {
    if (ObjectUtils.allNotNull(specialitas, genus, casus, numeralis, gradus) &&
        StringUtils.isNoneBlank(lemma, scriptio)) {
      final Adiectivum hoc = Adiectivum.builder().specialitas(specialitas).genus(genus).casus(casus)
                                                 .numeralis(numeralis).lemma(lemma).scriptio(scriptio).build();
      refero(hoc);
      return hoc;
    } else {
      nuntius.moneo("Adiect\u012Bv\u012B", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @param hoc rem tentanda
   */
  @Override
  protected void refero(@Nullable Adiectivum hoc) {
    if (hoc == null) {
      nuntius.moneo("Adiect\u012Bv\u012B", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
    } else {
      nuntius.certioro("Adiect\u012Bvum", scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
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
  @Override public void allego(@NonNull final String nomen, @NonNull final String descriptor) {
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
      nuntius.moneo("Adiect\u012Bv\u012B attrib\u016Bta inop\u012Bnata \u016Bsa'st:", nomen, descriptor);
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
  @Override public void restituo() {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    casus = Casus.DERECTUS;
    numeralis = Numeralis.NULLUS;
    gradus = Gradus.NULLUS;
    scriptio = StringUtils.EMPTY;
    nuntius.certioro("Restit\u016Btus sum");
  }
}
