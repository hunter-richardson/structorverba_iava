package com.structorverba.officia.conditores.multiplicia;

import androidx.annotation.*;
import com.structorverba.officia.conditores.Conditor;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorMultiplicibus} est v\u0101s classis {@link Conditor} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class ConditorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Conditor <Hoc> {
  /**
   * Valor hic reparesent\u0101ti\u014Dnem scr\u012Bpta lemmae d\u0113signat.
   */
  public static final @NonNull String pittaciumLemmae = "lemma";

  /**
   * Valor hic val\u014Drem {@link VerbumMultiplex#scriptio} re\u012B pr\u014Dductae repraehentat.
   */
  @NonNull protected String scriptio = StringUtils.EMPTY;

  @Nullable protected Hoc hoc = null;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param nuntius val\u014Drem {@link Conditor#nuntius} supplet.
   */
  public ConditorMultiplicibus(@NonNull final Supplier <? extends Nuntius> nuntius) {
    super(nuntius);
  }

  /**
   * Modus hic val\u014Drem {@link #scriptio} indit.
   * @param scrpt val\u014Drem indendum
   */
  public final void ut(@NonNull final String scrpt) {
    scriptio = scrpt;
    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adiec\u012B conditi\u014Dnem novam: scr\u012Bptu'st", scrpt);
  }

  /**
   * Modus hic val\u014Drem cognitum per val\u014Dre {@code nomen} cum val\u014Dre {@code descriptor} indit.
   * @param nomen      val\u014Drem cognendum
   * @param descriptor val\u014Drem indendum
   */
  public abstract void allego(@NonNull final String nomen, @NonNull final String descriptor);

  /**
   * Modus hic rem hanc restituit.
   */
  public abstract void restituo();
}
