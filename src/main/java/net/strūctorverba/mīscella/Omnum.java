package net.strūctorverba.mīscella;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.tenōrēs.Tenor;

/**
 * Classis {@link Omnum} errōrēs inopīnātōs servat intercipere. <br>
 * Classem haec classēs omnēs intrā programmāte StrūctorVerba extendit absque classibus et {@link Tenor} et {@link Nūntius} et manifeste hāc propter natūram eārum. <br>
 * Officiīs classum illārum ergō prīmō scrībendus scrīptusque est cōdex sequens: <br>
 * {@code Thread.currentThread().setUncaughtExceptionHandler(Nūntius.NūntiusErrōribus.fac.get());}
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
