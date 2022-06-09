package com.structorverba.officia.conditores.multiplicia;

import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.Verbum;
import com.structorverba.officia.verba.multiplicia.Actus;
import com.structorverba.officia.enumerationes.*;

import org.apache.commons.lang3.*;
import androidx.annotation.*;

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
  @NonNull public static final Supplier <ConditorActis> fac =
    () -> ObjectUtils.firstNonNull(instantia, instantia = new ConditorActis());

  @NonNull private Modus     modus     = Modus.NULLUS;
  @NonNull private Vox       vox       = Vox.NULLA;
  @NonNull private Tempus    tempus    = Tempus.INTEMPORALE;
  @NonNull private Numeralis numeralis = Numeralis.NULLUS;
  @NonNull private Persona   persona   = Persona.NULLA;

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
    if (ObjectUtils.allNonNull(modus, vox, tempus, numeralis, persona, numeralis) &&
        StringUtils.isNoneBlank(lemma, scriptio)) {
      final Actus hoc = new Actus(modus, vox, tempus, numeralis, persona, lemma, scriptio);
      if (hoc == null) {
        nuntius.moneo(Utilitas.primamCapitaneamScribo(Categoria.ACTUS.scriptio),
                      StringUtils.firstNonBlank(lemma, scriptio),
                      "pr\u014Dducti\u014D f\u014Drmae n\u016Bllae pr\u014Dcessit.");
        return null;
      } else {
        nuntius.certioro(Utilitas.primamCapitaneamScribo(Categoria.ACTUS.scriptio.replace("a", "us")),
                         scriptio, "f\u012Bn\u012Btur pr\u014Dd\u016Bcere.");
        return hoc;
      }
    } else {
      nuntius.moneo(Utilitas.primamCapitaneamScribo(Categoria.ACTUS.scriptio),
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
  @Override public void allego(@NonNull final String nomen, @NonNull final String descriptor) {
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
      nuntius.moneo(Utilitas.primamCapitaneamScribo(Categoria.ACTUS.scriptio),
                    "attrib\u016Bta inop\u012Bnata \u016Bsa'st:",
                    nomen, descriptor);
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
