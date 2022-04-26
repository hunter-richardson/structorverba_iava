package net.structorverba.bibliothēca.mīscella;

import net.structorverba.nūntiī.Nūntius;
import net.structorverba.tenōrēs.Tenor;

/**
 * Classis {@link Omne} errōrēs inopīnātōs servat intercipere. <br> Classem haec classēs omnēs intrā programmāte
 * StrūctorVerba extendit absque classibus {@link Tenor}que {@link Nūntius}que manifesteque hāc propter natūram eārum.
 * <br> Officiīs classum {@link Tenor} ergō prīmō scrībendus scrīptusque est cōdex sequens: <br> {@code
 * Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());}
 * @see Nūntius.NūntiusErrōribus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)">Thread.setUncaughtExceptionHandler</a>
 */
public abstract class Omne {
  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat. <br> Cōnstat cōdicem sequentem: <br> {@code
   * Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());}
   */
  protected Omne() {
    Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());
  }
}
