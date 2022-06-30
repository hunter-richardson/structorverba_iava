package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.enumerationes.Gradus;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.*;
import jakarta.ejb.Singleton;
import org.apache.commons.lang3.*;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Classis {@link ConditorAdverbiis} est v\u0101s classis {@link Conditor} class\u012B {@link Adverbium}.
 * @see Adverbium
 * @see NuntiusConditoriAdverbiis
 */
@SuppressWarnings("SpellCheckingInspection")
public class ConditorAdverbiis extends ConditorMultiplicibus <Adverbium> {
  @Nullable private static ConditorAdverbiis instantia = null;

  /**
   * Valor hic viam re\u012B classis huiuc facit.
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public static final Supplier <ConditorAdverbiis> faciendum =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorAdverbiis());

  @NonNull private Gradus gradus = Gradus.NULLUS;

  private ConditorAdverbiis() {
    super(NuntiusConditoriAdverbiis.faciendum);
    nuntius.plurimumGarrio("Factus sum");
  }

  /**
   * {@inheritDoc}
   * @return Rem novam classis {@link Adiectivum}. <br>
   * Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s haec continet.
   */
  @Override @Nullable
  public Adverbium condam() {
    if (Objects.nonNull(gradus) &&
        StringUtils.isNoneBlank(lemma, scriptio)) {
      final Adverbium hoc = Adverbium.builder().gradus(gradus).lemma(lemma).scriptio(scriptio).build();
      refero(hoc);
      return hoc;
    } else {
      nuntius.moneo("Adverbi\u012B", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
      return null;
    }
  }

  /**
   * {@inheritDoc}
   * @param hoc rem tentanda
   */
  @Override
  protected void refero(@Nullable Adverbium hoc) {
    if (hoc == null) {
      nuntius.moneo("Adverbi\u012B", StringUtils.firstNonBlank(lemma, scriptio),
                    "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
    } else {
      nuntius.certioro("Adverbium", scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
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
  @Override public void allegam(@NonNull final String nomen, @NonNull final String descriptor) {
    if(Gradus.pittacium.equals(nomen)) {
      gradus = Gradus.definiam(descriptor);
    } else if(pittaciumLemmae.equals(nomen)) {
      lemma = descriptor.trim();
    } else {
        nuntius.moneo("Adverbi\u012B attrib\u016Bta inop\u012Bn\u0101ta est \u016Bsa:",
                      nomen, descriptor);
        return;
      }

    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adi\u0113c\u012B conditi\u014Dnem novam:",
                   nomen, descriptor);
  }

  /**
   * Classis {@link NuntiusConditoriAdverbiis} est v\u0101s classis {@link Nuntius} class\u012B {@link ConditorAdverbiis}
   * @see ConditorAdverbiis
   */
  @Singleton
  private static final class NuntiusConditoriAdverbiis extends Nuntius {
    @Nullable private static NuntiusConditoriAdverbiis instantia = null;

    /**
     * Valor hic viam re\u012B classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull private static final Supplier <NuntiusConditoriAdverbiis> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConditoriAdverbiis());

    private NuntiusConditoriAdverbiis() {
      super(ParametriNuntii.para(ConditorAdverbiis.class));
    }
  }
}
