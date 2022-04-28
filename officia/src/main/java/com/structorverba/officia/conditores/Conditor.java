package officia.src.main.java.com.structorverba.officia.conditores;

import officia.src.main.java.com.structorverba.officia.miscella.Omne;
import officia.src.main.java.com.structorverba.officia.nuntii.Nuntius;
import officia.src.main.java.com.structorverba.officia.tenores.Tenor;
import officia.src.main.java.com.structorverba.officia.verba.Verbum;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.function.Supplier;

/**
 * Classis {@link Conditor} data \u0101 r\u0113bus classis {@link Tenor} accipit eacumque r\u0113s classis extent\u0101rum {@link Verbum}
 * c\u014Dnstruet.
 * @param <Hoc> classis extenta classis {@link Verbum}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Conditor <Hoc extends Verbum <Hoc>> extends Omne {
  /**
   * Valor hic est v\u0101s classis {@link Nuntius} class\u012B hui.
   */
  @NotNull protected final Nuntius nuntius;

  /**
   * Valor hic val\u014Drem {@link Verbum#lemma} re\u012B pr\u014Dductae repraehentat.
   */
  @NotNull protected String lemma = StringUtils.EMPTY;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param nts val\u014Drem {@link #nuntius} supplet.
   */
  protected Conditor(@NotNull final Supplier <@NotNull ? extends Nuntius> nts) {
    nuntius = nts.get();
  }

  /**
   * Modus hic val\u014Drem {@link #lemma} indit.
   * @param lm val\u014Drem indendum
   */
  public final void funde(@NotNull final String lm) {
    lemma = lm.trim();
  }

  /**
   * Modus hic rem classis {@link Hoc} c\u014Dn\u0101bitur c\u014Dnstruere.
   * @return Rem novam classis {@link Hoc}. <br> Modus hid val\u014Drem {@code null} refert s\u012B n\u014Dn valet valor aliquis r\u0113s
   *   haec continet.
   */
  @Nullable public abstract Hoc condam();
}
