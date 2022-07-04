package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;

import java.time.Month;

/**
 * Ēnumerātiō haec mēnsās annī dēsignat.
 * @see Month
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Mensis {
  /**
   * Valor hic mēnsem Iānuāriī dēsignat.
   */
  IANUARII("Iānuāriī"),

  /**
   * Valor hic mēnsem Februāriī dēsignat.
   */
  FEBRUARII("Februāriī"),

  /**
   * Valor hic mēnsem Mārtis dēsignat.
   */
  MARTIS("Mārtis"),

  /**
   * Valor hic mēnsem Aprīlis dēsignat.
   */
  APRILIS("Aprīlis"),

  /**
   * Valor hic mēnsem Maiī dēsignat.
   */
  MAII("Maiī"),

  /**
   * Valor hic mēnsem Iūniī dēsignat.
   */
  IUNII("Iūniī"),

  /**
   * Valor hic mēnsem Iūliī dēsignat.
   */
  IULIUS("Iūliī"),

  /**
   * Valor hic mēnsem Augustī dēsignat.
   */
  AUGUSTI("Augustī"),

  /**
   * Valor hic mēnsem Septembris dēsignat.
   */
  SEPTEMBRIS("Septembris"),

  /**
   * Valor hic mēnsem Octobris dēsignat.
   */
  OCTOBRIS("Octōbris"),

  /**
   * Valor hic mēnsem Novembris dēsignat.
   */
  NOVEMBRIS("Novembris"),

  /**
   * Valor hic mēnsem Decembris dēsignat.
   */
  DECEMBRIS("Decembris");

  /**
   * Valor hic repraesentātiōnem scrīpta reī huius dēsignat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scriptio} indicat.
   */
  Mensis(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic societās intrā rās ēnumerātiōnēs huius rēsque
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
