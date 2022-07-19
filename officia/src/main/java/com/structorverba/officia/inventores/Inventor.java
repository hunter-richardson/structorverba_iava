package com.structorverba.officia.inventores;

import com.structorverba.officia.interfacta.*;
import com.structorverba.officia.lectores.LectorMultiplicibus;
import com.structorverba.officia.miscella.Omne;
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorMultiplicibus;
import com.structorverba.officia.verba.multiplicia.Multiplex;

import androidx.annotation.*;

import java.util.Arrays;
import java.util.function.*;

/**
 * Classis {@link Inventor} cōlit rēs classis {@link Multiplex} quās rēs classis {@link TenorMultiplicibus}
 * referat.
 * @param <Hoc> classis extenta classis {@link Multiplex}
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Inventor <Hoc extends Inventabile<Hoc> & Inflectabile<Hoc>> extends Omne {
  /**
   * Hic valor est vās classis {@link Nuntius} classī hui.
   */
  @NonNull protected final Nuntius nuntius;

  /**
   * Hoc officium cōnstructōrem reī huius classis perpetrat.
   * @param nts valōrem {@link #nuntius} supplet.
   */
  protected Inventor(@NonNull final Supplier <? extends Nuntius> nts) {
    nuntius = nts.get();
  }

  /**
   * Hic modus seriem {@code illa} huic reī indit.
   * @param illa seriem ēnumerātiōnum indendam
   * @return Huius rem
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
   * Hic modus hanc rem restituit.
   */
  public abstract void restituo();

  /**
   * Hic modus ēnumerātiōnem singulum {@code illud} huic reī indit.
   * @param illud ēnumerātiōnem indendam
   */
  protected abstract void allegam(final Enum <?> illud);
}