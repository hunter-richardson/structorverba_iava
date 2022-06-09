package com.structorverba.officia.inventores;

import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.verba.multiplicia.VerbumMultiplex;

import androidx.annotation.*;

import java.util.Arrays;
import java.util.function.*;

/**
 * Classis {@link Inventor} c\014Dlit r\u0113s classis {@link VerbumMultiplex} qu\u0101s r\u0113s classis {@link TenorMultiplicibus}
 * referat.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Inventor <Hoc extends VerbumMultiplex <Hoc>> extends Omne {
  /**
   * Valor hic est v\u0101s classis {@link Nuntius} class\u012B hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Officium hoc c\014Dnstruct\014Drem re\u012B classis huius perpetrat.
   * @param nts val\014Drem {@link #nuntius} supplet.
   */
  protected Inventor(@NonNull final Supplier <? extends Nuntius> nts) {
    nuntius = nts.get();
  }

  /**
   * Modus hic seriem {@code illa} re\u012B huic indit.
   * @param illa seriem \u0113numer\u0101ti\014Dnum indendam
   * @return Rem huius
   * @see #allegam(Enum)
   */
  @NonNull public final Inventor <Hoc> allego(@NonNull final Enum <?>... illa) {
    Arrays.stream(illa).forEach(this::allegam);
    return this;
  }

  /**
   * @return Quaesti\014Dnem quam r\u0113s classis {@link LectorMultiplicibus} \u016Bt\u0101tur r\u0113s classis {@link Hoc} percolere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @NonNull public abstract Predicate <Hoc> inquiram();

  /**
   * Modus hic rem hanc restituit.
   */
  public abstract void restituo();

  /**
   * Modus hic \u0113numer\u0101ti\014Dnem singulum {@code illud} re\u012B huic indit.
   * @param illud \u0113numer\u0101ti\014Dnem indendam
   */
  protected abstract void allegam(final Enum <?> illud);
}