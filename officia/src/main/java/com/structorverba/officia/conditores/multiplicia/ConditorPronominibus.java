package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Pronomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorPronominibus} est v\u0101s classis {@link Conditor} class\u012B {@link Pronomen}.
 * @see Pronomen
 * @see NuntiusConditoriPronominibus
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
  @NonNull public static final Supplier <ConditorPronominibus> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorPronominibus());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;

  private ConditorPronominibus() {
    super(NuntiusConditoriPronominibus.faciendum);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Pronomen}. <br>
   * Modus hid valorem {@code null} refert s\u012B non valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable
  public Pronomen condam() {
    if (ObjectUtils.allNotNull(specialitas, genus, casus, numeralis) &&
        StringUtils.isNoneBlank(lemma, scriptio)) {
      final Pronomen hoc = Pronomen.builder().specialitas(specialitas).genus(genus).casus(casus).numeralis(numeralis)
                                             .lemma(lemma).scriptio(scriptio).build();
      refero(hoc);
      return hoc;
    } else {
      nuntius.moneo("Pr\u014Dn\u014Dminis", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @param hoc rem tentanda
   */
  @Override
  protected void refero(@Nullable Pronomen hoc) {
    if (hoc == null) {
      nuntius.moneo("Pr\u014Dn\u014Dminis", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae nullae pr\u014Dcessit.");
    } else {
      nuntius.certioro("Pr\u014Dn\u014Dmen", scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
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
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    if (Specialitas.pittacium.equals(nomen)) {
      specialitas = Specialitas.definiam(descriptor);
    } else if (Genus.pittacium.equals(nomen)) {
      genus = Genus.definiam(descriptor);
    } else if (Numeralis.pittacium.equals(nomen)) {
      numeralis = Numeralis.definiam(descriptor);
    } else if (Persona.pittacium.equals(nomen)) {
      casus = Casus.definiam(descriptor);
    } else if (pittaciumLemmae.equals(nomen)) {
      lemma = descriptor.trim();
    } else {
      nuntius.moneo("Pr\u014Dn\u014Dminis attrib\u016Bta inop\u012Bnata \u016Bsa'st:", nomen, descriptor);
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
   */
  @Override public void restituo() {
    specialitas = Specialitas.NULLUM;
    genus = Genus.NULLUM;
    casus = Casus.DERECTUS;
    numeralis = Numeralis.NULLUS;
    scriptio = StringUtils.EMPTY;
    nuntius.certioro("Restit\u016Btus sum");
  }

  /**
   * Classis {@link NuntiusConditoriPronominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorPronominibus}
   * @see ConditorPronominibus
   */
  @Singleton
  private static final class NuntiusConditoriPronominibus extends Nuntius {
    @Nullable private static NuntiusConditoriPronominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriPronominibus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriPronominibus());

    private NuntiusConditoriPronominibus() {
      super(ParametriNuntii.para(ConditorPronominibus.class));
    }
  }
}
