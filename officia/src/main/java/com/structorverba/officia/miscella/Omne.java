package officia.src.main.java.com.structorverba.officia.miscella;

import com.structorverba.nuntii.Nuntius;
import com.structorverba.tenores.Tenor;

/**
 * Classis {@link Omne} err\u014Dr\u0013s inop\u012Bn\u0101t\u014Ds servat intercipere. <br> Classem haec class\u0013s omn\u0013s intr\u0101 programm\u0101te
 * Str\u016BctorVerba extendit absque classibus {@link Tenor}que {@link Nuntius}que manifesteque h\u0101c propter nat\u016Bram e\u0101rum.
 * <br> Offici\u012Bs classum {@link Tenor} erg\u014D pr\u012Bm\u014D scr\u012Bbendus scr\u012Bptusque est c\u014Ddex sequens: <br> {@code
 * Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.fac.get());}
 * @see Nuntius.NuntiusErroribus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)">Thread.setUncaughtExceptionHandler</a>
 */
public abstract class Omne {
  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat. <br>
   * C\u014Dnstat c\u014Ddicem sequentem: <br>
   * {@code Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.fac.get());}
   */
  protected Omne() {
    Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.fac.get());
  }
}
