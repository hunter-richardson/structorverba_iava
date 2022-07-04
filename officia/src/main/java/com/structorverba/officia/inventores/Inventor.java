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
 * Classis {@link Inventor} cōlit rēs classis {@link VerbumMultiplex} quās rēs classis {@link TenorMultiplicibus}
 * referat.
 * @param <Hoc> classis extenta classis {@link VerbumMultiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Inventor <Hoc extends VerbumMultiplex <Hoc>> extends Omne {
  /**
   * Valor hic est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Officium hoc cōnstructōrem reī classis huius perpetrat.
   * @param nts valōrem {@link #nuntius} supplet.
   */
  protected Inventor(@NonNull final Supplier <? extends Nuntius> nts) {
    nuntius = nts.get();
  }

  /**
   * Modus hic seriem {@code illa} reī huic indit.
   * @param illa seriem ēnumerātiōnum indendam
   * @return Rem huius
   * @see #allegam(Enum)
   */
  @NonNull public final Inventor <Hoc> allego(@NonNull final Enum <?>... illa) {
    Arrays.stream(illa).forEach(this::allegam);
    return this;
  }

  /**
   * @return Quaestiōnem quam rēs classis {@link LectorMultiplicibus} ūtātur rēs classis {@link Hoc} percolere
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Prediate</a>
   */
  @NonNull public abstract Predicate <Hoc> inquiram();

  /**
   * Modus hic rem hanc restituit.
   */
  public abstract void restituo();

  /**
   * Modus hic ēnumerātiōnem singulum {@code illud} reī huic indit.
   * @param illud ēnumerātiōnem indendam
   */
  protected abstract void allegam(final Enum <?> illud);
}