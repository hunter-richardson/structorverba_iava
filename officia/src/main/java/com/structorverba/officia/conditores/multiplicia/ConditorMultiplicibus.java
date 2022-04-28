package officia.src.main.java.com.structorverba.officia.conditores.multiplicia;

import officia.src.main.java.com.structorverba.officia.conditores.Conditor;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.verba.multiplicia.VerbumMultiplex;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Classis {@link ConditorMultiplicibus} est v\u0101s classis {@link Conditor} classibus omnibus quibus classem {@link
 * VerbumMultiplex} extendit.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class ConditorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Conditor <Hoc> {
  /**
   * Valor hic val\u014Drem {@link VerbumMultiplex#scriptio} re\u012B pr\u014Dductae repraehentat.
   */
  @NotNull protected String scriptio = StringUtils.EMPTY;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param nuntius val\u014Drem {@link Conditor#nuntius} supplet.
   */
  public ConditorMultiplicibus(@NotNull final Supplier <@NotNull ? extends Nuntius> nuntius) {
    super(nuntius);
  }

  /**
   * Modus hic val\u014Drem {@link #scriptio} indit.
   * @param scrpt val\u014Drem indendum
   */
  public final void ut(@NotNull final String scrpt) {
    scriptio = scrpt;
    nuntius.garrio("C\u014Dntr\u016Bcti\u014Dn\u012B adiec\u012B conditi\u014Dnem novam: scr\u012Bpti\u014D est", scrpt);
  }

  /**
   * Modus hic val\u014Drem cognitum per val\u014Dre {@code nomen} cum val\u014Dre {@code descriptor} indit.
   * @param nomen      val\u014Drem cognendum
   * @param descriptor val\u014Drem indendum
   */
  public abstract void allego(@NotNull final String nomen, @NotNull final String descriptor);

  /**
   * Modus hic rem hanc restituit.
   */
  public abstract void restituo();
}
