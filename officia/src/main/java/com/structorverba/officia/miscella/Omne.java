package com.structorverba.officia.miscella;

import androidx.annotation.*;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.Tenor;
import jakarta.ejb.Singleton;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

/**
 * Classis {@link Omne} errōrēs inopīnātōs servat intercipere. <br> Classem haec classēs omnēs intrā programmāte
 * StrūctorVerba extendit absque classibus {@link Tenor}que {@link Nuntius}que manifesteque hāc propter natūram eārum.
 * <br> Officiīs classum {@link Tenor} ergō prīmō scrībendus scrīptusque est cōdex sequens: <br> {@code
 * Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.faciendum.get());}
 * @see NuntiusErroribus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)">Thread.setUncaughtExceptionHandler</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class Omne {
  @NonNull @Getter(lazy = true)
  private final NuntiusErroribus nuntius = NuntiusErroribus.faciendum.get();

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat. <br>
   * Cōnstat cōdicem sequentem: <br>
   * {@code Thread.currentThread().setUncaughtExceptionHandler(Nuntius.NuntiusErroribus.faciendum.get());}
   */
  public Omne() {
    Thread.currentThread().setUncaughtExceptionHandler(nuntius);
  }


  /**
   * Classis {@link NuntiusErroribus} est vās classis {@link Nuntius} ipsīusmet. <br> Indicat quod exsecūtiōnem
   * programmātis StrūctorVerba errōrem inopīnātum continuātur.
   * @see Omne
   * @see <a href="https://docs.oracle.com/javase/9/docs/api/java/lang/Thread.UncaughtExceptionHandler.html">Thread.UncaughtExceptionHandler</a>
   */
  @Singleton
  public static final class NuntiusErroribus extends Nuntius implements Thread.UncaughtExceptionHandler {
    @Nullable private static NuntiusErroribus instantia = null;

    /**
     * Valor hic viam reī classis huiuc facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull public static final Supplier<NuntiusErroribus> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusErroribus());

    private NuntiusErroribus() {
      super(ParametriNuntii.para(NuntiusErroribus.class));
    }

    /**
     * Modus hic invocātur quandōque exsecūtiōnem programmātis StrūctorVerba errōrem inopīnātum continuātur.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.UncaughtExceptionHandler.html#uncaughtException(java.lang.Thread,%20java.lang.Throwable)">UncaughtExceptionHandler.uncaughtException</a>
     */
    public @Override void uncaughtException(@NonNull final Thread linea, @NonNull final Throwable error) {
      terreo(error);
    }
  }
}
