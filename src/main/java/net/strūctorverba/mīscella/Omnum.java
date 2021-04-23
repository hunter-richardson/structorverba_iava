package net.strūctorverba.mīscella;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;

/**
 * Classem {@link Omnum} classēs omnēs intrā programmāte StrūctorVerba extendit absque classibus et {@link Tenor} et {@link Nūntius} propter natūram eārum. <br>
 * Officiīs classum illārum ergō prīmō scrībendus scrīptusque est cōdex sequens: <br>
 * {@code Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());} <br>
 * Classis haec errōrēs inopīnātōs servat intercipere.
 * @see Nūntius.NūntiusErrōribus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)">Thread.setUncaughtExceptionHandler</a>
 */
public abstract class Omnum {
  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat. <br>
   * Cōnstat cōdicem sequentem: <br>
   * {@code Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());}
   */
  protected Omnum() {
    Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());
  }
}
