package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;

import java.time.Month;

/**
 * Haec ēnumerātiō mēnsās annī dēsignat.
 * @see Month
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Mensis {
  /**
   * Hic valor mēnsem Iānuāriī dēsignat.
   */
  IANUARII("Iānuāriī"),

  /**
   * Hic valor mēnsem Februāriī dēsignat.
   */
  FEBRUARII("Februāriī"),

  /**
   * Hic valor mēnsem Mārtis dēsignat.
   */
  MARTIS("Mārtis"),

  /**
   * Hic valor mēnsem Aprīlis dēsignat.
   */
  APRILIS("Aprīlis"),

  /**
   * Hic valor mēnsem Maiī dēsignat.
   */
  MAII("Maiī"),

  /**
   * Hic valor mēnsem Iūniī dēsignat.
   */
  IUNII("Iūniī"),

  /**
   * Hic valor mēnsem Iūliī dēsignat.
   */
  IULIUS("Iūliī"),

  /**
   * Hic valor mēnsem Augustī dēsignat.
   */
  AUGUSTI("Augustī"),

  /**
   * Hic valor mēnsem Septembris dēsignat.
   */
  SEPTEMBRIS("Septembris"),

  /**
   * Hic valor mēnsem Octobris dēsignat.
   */
  OCTOBRIS("Octōbris"),

  /**
   * Hic valor mēnsem Novembris dēsignat.
   */
  NOVEMBRIS("Novembris"),

  /**
   * Hic valor mēnsem Decembris dēsignat.
   */
  DECEMBRIS("Decembris");

  /**
   * Hic valor repraesentātiōnem scrīpta huius reī dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Mensis(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Hic modus societās intrā rās huius ēnumerātiōnēs rēsque
   * <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html">Month</a> dēmōnstrat.
   * <ul>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JANUARY">JANUARY</a>
   *   valōrem {@link #IANUARII} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#FEBRUARY">FEBRUARY</a>
   *   valōrem {@link #FEBRUARII} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#MARCH">MARCH</a>
   *   valōrem {@link #MARTIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#APRIL">APRIL</a>
   *   valōrem {@link #APRILIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#MAY">MAY</a>
   *   valōrem {@link #MAII} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JUNE">JUNE</a>
   *   valōrem {@link #IUNII} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JULY">JULY</a>
   *   valōrem {@link #IULIUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#AUGUST">AUGUST</a>
   *   valōrem {@link #AUGUSTI} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#SEPTEMBER">SEPTEMBER</a>
   *   valōrem {@link #SEPTEMBRIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#OCTOBER">OCTOBER</a>
   *   valōrem {@link #OCTOBRIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#NOVEMBER">NOVEMBER</a>
   *   valōrem {@link #NOVEMBRIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#DECEMBER">DECEMBER</a>
   *   valōrem {@link #DECEMBRIS} cōnsociat.</li>
   * </ul>
   * @param enumeratio valor tentandus.
   * @return Rem petītam ēnumerātiōnis {@link Mensis}
   */
  @NonNull public static Mensis indicam(@NonNull final Month enumeratio) {
    return switch (enumeratio) {
      case JANUARY -> IANUARII;
      case FEBRUARY -> FEBRUARII;
      case MARCH -> MARTIS;
      case APRIL -> APRILIS;
      case MAY -> MAII;
      case JUNE -> IUNII;
      case JULY -> IULIUS;
      case AUGUST -> AUGUSTI;
      case SEPTEMBER -> SEPTEMBRIS;
      case OCTOBER -> OCTOBRIS;
      case NOVEMBER -> NOVEMBRIS;
      case DECEMBER -> DECEMBRIS;
    };
  }

  /**
   * @return {@link #scriptio}
   */
  @NonNull public String toString() {
    return scriptio;
  }
}
