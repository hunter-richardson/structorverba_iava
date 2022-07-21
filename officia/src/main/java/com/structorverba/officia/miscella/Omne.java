package com.structorverba.officia.miscella;

import androidx.annotation.NonNull;
import com.structorverba.officia.quadriiugia.Tenor;
import com.structorverba.officia.nuntii.Nuntius;
import lombok.Getter;

/**
 * Classis {@link Omne} errōrēs inopīnātōs servat intercipere. <br> Classem haec classēs omnēs intrā programmāte
 * StrūctorVerba extendit absque classibus {@link Tenor}que {@link Nuntius}que manifesteque hāc propter natūram eārum.
 * <br> Officiīs classum {@link Tenor} ergō prīmō scrībendus scrīptusque est cōdex sequens: <br> {@code
 * Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.faciendum.get());}
 * @see Nuntius.Erroribus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)">Thread.setUncaughtExceptionHandler</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Omne {
  @NonNull @Getter(lazy = true)
  private final Nuntius.Erroribus nuntius = Nuntius.Erroribus.faciendum.get();

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat. <br>
   * Cōnstat cōdicem sequentem: <br>
   * {@code Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.faciendum.get());}
   */
  public Omne() {
    Thread.currentThread().setUncaughtExceptionHandler(nuntius);
  }
}
