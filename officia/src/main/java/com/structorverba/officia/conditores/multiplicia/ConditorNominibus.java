package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Nomen;
import jakarta.ejb.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorNominibus} est v\u0101s classis {@link Conditor} class\u012B {@link Nomen}.
 * @see Nomen
 * @see NuntiusConditoriNominibus
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
  @NonNull public static final Supplier <ConditorNominibus> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorNominibus());

  @NonNull private Specialitas specialitas = Specialitas.NULLUM;
  @NonNull private Genus       genus       = Genus.NULLUM;
  @NonNull private Numeralis   numeralis   = Numeralis.NULLUS;
  @NonNull private Casus       casus       = Casus.DERECTUS;
  @NonNull private Tempus      tempus      = Tempus.INTEMPORALE;

  private ConditorNominibus() {
    super(NuntiusConditoriNominibus.fac);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Nomen}. <br>
   * Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable
  public Nomen condam() {
    if (ObjectUtils.allNotNull(specialitas, genus, casus, numeralis) &&
        StringUtils.isNoneBlank(lemma, scriptio)) {
      final Nomen hoc = Nomen.builder().specialitas(specialitas).genus(genus).casus(casus).numeralis(numeralis)
                                       .tempus(tempus).lemma(lemma).scriptio(scriptio).build();
      refero(hoc);
      return hoc;
    } else {
      nuntius.moneo("N\u014Dminis", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @param hoc rem tentanda
   */
  @Override
  protected void refero(@Nullable Nomen hoc) {
    if (hoc == null) {
      nuntius.moneo("N\u014Dminis", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
    } else {
      nuntius.certioro("N\u014Dmen", scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
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
  @Override public void allego(@NonNull final String nomen, @NonNull final String descriptor) {
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
      nuntius.moneo("N\u014Dminis attrib\u016Bta inop\u012Bnata \u016Bsa'st:", nomen, descriptor);
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

  /**
   * Classis {@link NuntiusConditoriNominibus} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorNominibus}
   * @see ConditorNominibus
   */
  @Singleton
  private static final class NuntiusConditoriNominibus extends Nuntius {
    @Nullable private static NuntiusConditoriNominibus instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriNominibus> fac =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriNominibus());

    private NuntiusConditoriNominibus() {
      super(ParametriNuntii.para(ConditorNominibus.class));
    }
  }
}
