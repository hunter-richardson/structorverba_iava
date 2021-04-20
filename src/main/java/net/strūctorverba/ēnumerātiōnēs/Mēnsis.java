package net.strūctorverba.ēnumerātiōnēs;

import org.jetbrains.annotations.NotNull;

import java.time.Month;

/**
 * Ēnumerātiō haec mēnsēs annī dēsignat.
 * @see Month
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public enum Mēnsis {
  /**
   * Valor hic mēnsem Iānuāriī dēsignat.
   */
  IANUĀRIĪ("Iānuāriī"),

  /**
   * Valor hic mēnsem Februāriī dēsignat.
   */
  FEBRUĀRIĪ("Februāriī"),

  /**
   * Valor hic mēnsem Martis dēsignat.
   */
  MĀRTIS("Mārtis"),

  /**
   * Valor hic mēnsem Aprīlis dēsignat.
   */
  APRĪLIS("Aprīlis"),

  /**
   * Valor hic mēnsem Maiī dēsignat.
   */
  MAIĪ("Maiī"),

  /**
   * Valor hic mēnsem Iūniī dēsignat.
   */
  IŪNIĪ("Iūniī"),

  /**
   * Valor hic mēnsem Iūliī dēsignat.
   */
  IŪLIUS("Iūliī"),

  /**
   * Valor hic mēnsem Augustī dēsignat.
   */
  AUGUSTĪ("Augustī"),

  /**
   * Valor hic mēnsem Septembris dēsignat.
   */
  SEPTEMBRIS("Septembris"),

  /**
   * Valor hic mēnsem Octobris dēsignat.
   */
  OCTŌBRIS("Octōbris"),

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
  public final @NotNull String scrīptiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param scrpt valōrem {@link #scrīptiō} indicat.
   */
  Mēnsis(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  /**
   * Modus hic societās intrā rēs ēnumerātiōnēs et huius et <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html">Month</a> dēmōnstrat.
   * <ul>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JANUARY">JANUARY</a> valōrem {@link #IANUĀRIĪ} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#FEBRUARY">FEBRUARY</a> valōrem {@link #FEBRUĀRIĪ} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#MARCH">MARCH</a> valōrem {@link #MĀRTIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#APRIL">APRIL</a> valōrem {@link #APRĪLIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#MAY">MAY</a> valōrem {@link #MAIĪ} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JUNE">JUNE</a> valōrem {@link #IŪNIĪ} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JULY">JULY</a> valōrem {@link #IŪLIUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#AUGUST">AUGUST</a> valōrem {@link #AUGUSTĪ} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#SEPTEMBER">SEPTEMBER</a> valōrem {@link #SEPTEMBRIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#OCTOBER">OCTOBER</a> valōrem {@link #OCTŌBRIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#NOVEMBER">NOVEMBER</a> valōrem {@link #NOVEMBRIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#DECEMBER">DECEMBER</a> valōrem {@link #DECEMBRIS} cōnsociat.</li>
   * </ul>
   * @param ēnumerātiō valor tentandus.
   * @return Rem petītam ēnumerātiōnis {@link Mēnsis}
   */
  public static @NotNull Mēnsis indīcam(@NotNull final Month ēnumerātiō) {
    return switch (ēnumerātiō) {
             case JANUARY -> IANUĀRIĪ;
             case FEBRUARY -> FEBRUĀRIĪ;
             case MARCH -> MĀRTIS;
             case APRIL -> APRĪLIS;
             case MAY -> MAIĪ;
             case JUNE -> IŪNIĪ;
             case JULY -> IŪLIUS;
             case AUGUST -> AUGUSTĪ;
             case SEPTEMBER -> SEPTEMBRIS;
             case OCTOBER -> OCTŌBRIS;
             case NOVEMBER -> NOVEMBRIS;
             case DECEMBER -> DECEMBRIS;
    };
  }

  /**
   * @return {@link #scrīptiō}
   */
  public @NotNull String toString() {
    return scrīptiō;
  }
}
