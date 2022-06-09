package com.structorverba.officia.enumerationes;

import androidx.annotation.NonNull;

import java.time.Month;

/**
 * \u0112numer\u0101ti\u014D haec m\u0113ns\u0113s ann\u012B d\u0113signat.
 * @see Month
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Mensis {
  /**
   * Valor hic m\u0113nsem I\u0101nu\u0101ri\u012B d\u0113signat.
   */
  IANUARII("I\u0101nu\u0101ri\u012B"),

  /**
   * Valor hic m\u0113nsem Febru\u0101ri\u012B d\u0113signat.
   */
  FEBRUARII("Febru\u0101ri\u012B"),

  /**
   * Valor hic m\u0113nsem M\u0101rtis d\u0113signat.
   */
  MARTIS("M\u0101rtis"),

  /**
   * Valor hic m\u0113nsem Apr\u012Blis d\u0113signat.
   */
  APRILIS("Apr\u012Blis"),

  /**
   * Valor hic m\u0113nsem Mai\u012B d\u0113signat.
   */
  MAII("Mai\u012B"),

  /**
   * Valor hic m\u0113nsem I\u016Bni\u012B d\u0113signat.
   */
  IUNII("I\u016Bni\u012B"),

  /**
   * Valor hic m\u0113nsem I\u016Bli\u012B d\u0113signat.
   */
  IULIUS("I\u016Bli\u012B"),

  /**
   * Valor hic m\u0113nsem August\u012B d\u0113signat.
   */
  AUGUSTI("August\u012B"),

  /**
   * Valor hic m\u0113nsem Septembris d\u0113signat.
   */
  SEPTEMBRIS("Septembris"),

  /**
   * Valor hic m\u0113nsem Octobris d\u0113signat.
   */
  OCTOBRIS("Oct\u014Dbris"),

  /**
   * Valor hic m\u0113nsem Novembris d\u0113signat.
   */
  NOVEMBRIS("Novembris"),

  /**
   * Valor hic m\u0113nsem Decembris d\u0113signat.
   */
  DECEMBRIS("Decembris");

  /**
   * Valor hic repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius d\u0113signat.
   */
  public final @NonNull String scriptio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param scrpt val\u014Drem {@link #scriptio} indicat.
   */
  Mensis(@NonNull final String scrpt) {
    scriptio = scrpt;
  }

  /**
   * Modus hic societ\u0101s intr\u0101 r\u0113s \u0113numer\u0101ti\u014Dn\u0113s huius r\u0113sque
   * <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html">Month</a> d\u0113m\u014Dnstrat.
   * <ul>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JANUARY">JANUARY</a>
   *   val\u014Drem {@link #IANUARII} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#FEBRUARY">FEBRUARY</a>
   *   val\u014Drem {@link #FEBRUARII} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#MARCH">MARCH</a>
   *   val\u014Drem {@link #MARTIS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#APRIL">APRIL</a>
   *   val\u014Drem {@link #APRILIS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#MAY">MAY</a>
   *   val\u014Drem {@link #MAII} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JUNE">JUNE</a>
   *   val\u014Drem {@link #IUNII} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#JULY">JULY</a>
   *   val\u014Drem {@link #IULIUS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#AUGUST">AUGUST</a>
   *   val\u014Drem {@link #AUGUSTI} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#SEPTEMBER">SEPTEMBER</a>
   *   val\u014Drem {@link #SEPTEMBRIS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#OCTOBER">OCTOBER</a>
   *   val\u014Drem {@link #OCTOBRIS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#NOVEMBER">NOVEMBER</a>
   *   val\u014Drem {@link #NOVEMBRIS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/8/docs/api/java/time/Month.html#DECEMBER">DECEMBER</a>
   *   val\u014Drem {@link #DECEMBRIS} c\u014Dnsociat.</li>
   * </ul>
   * @param enumeratio valor tentandus.
   * @return Rem pet\u012Btam \u0113numer\u0101ti\u014Dnis {@link Mensis}
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
  @NonNull public String toString( ) {
    return scriptio;
  }
}
