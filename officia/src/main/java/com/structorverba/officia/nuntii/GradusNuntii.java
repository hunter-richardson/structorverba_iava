package officia.src.main.java.com.structorverba.officia.nuntii;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * \u0112numer\u0101ti\u014D haec persignat gravit\u0101temque n\u016Bntiae singul\u0101rem et quam verb\u014Dsa r\u0113s classis {@link Nuntius} scr\u012Bb\u0113tur.
 * @see ParametriNuntii#gradusMinimus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
enum GradusNuntii {
  /**
   * Valor hic indicat rem taciturna classis {@link Nuntius}.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a>
   */
  INERS(Level.OFF),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae err\u014Dr\u0113s s\u014Dlum persignat.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a>
   */
  GRAVIS(Level.SEVERE),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae persignat err\u014Dr\u0113s n\u016Bnti\u0101sque qu\u0101s err\u014Drem add\u016Bcant.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a>
   */
  PRAEMONITORIUS(Level.WARNING),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae persignat n\u016Bnti\u0101s qu\u0101s \u016Bs\u016Bfructu\u0101ri\u012Bs programm\u0101tis intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a>
   */
  INFORMATIVUS(Level.INFO),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae persignat n\u016Bnti\u0101s qu\u0101s auct\u014Dribus programm\u0101tis intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a>
   */
  PRAEGRESSURUS(Level.CONFIG),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae persignat n\u016Bnti\u0101s qu\u0101s n\u0113min\u012B fortasse intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a>
   */
  SCRUTANS(Level.FINE),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae persignat n\u016Bnti\u0101s qu\u0101s n\u0113min\u012B prob\u0101biliter intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a>
   */
  SCRUTANTIOR(Level.FINER),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae persignat n\u016Bnti\u0101s qu\u0101s n\u0113min\u012B certissime intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a>
   */
  SCRUTANTISSIMUS(Level.FINEST),

  /**
   * Valor hic indicat rem classis {@link Nuntius} quae n\u016Bnti\u0101s omn\u0113s persignat.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a>
   */
  OMNIS(Level.ALL);

  /**
   * Valor hic compar\u0101ti\u014Dn\u012B r\u0113rum \u0113numer\u0101ti\u014Dnis huius licet.
   */
  public final int praecellentia;
  /**
   * Modus hic societ\u0101s intr\u0101 r\u0113s \u0113numer\u0101ti\u014Dn\u0113s huius r\u0113sque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
   * d\u0113m\u014Dnstrat.
   * <ul>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a> val\u014Drem {@link #INERS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a> val\u014Drem {@link #GRAVIS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a> val\u014Drem {@link #PRAEMONITORIUS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a> val\u014Drem {@link #INFORMATIVUS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a> val\u014Drem {@link #PRAEGRESSURUS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a> val\u014Drem {@link #SCRUTANS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a> val\u014Drem {@link #SCRUTANTIOR} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a> val\u014Drem {@link #SCRUTANTISSIMUS} c\u014Dnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a> val\u014Drem {@link #OMNIS} c\u014Dnsociat.</li>
   * </ul>
   */
  @NotNull public final Supplier <@NotNull Level> gressus = () ->
    switch (this) {
      case INERS -> Level.OFF;
      case GRAVIS -> Level.SEVERE;
      case PRAEMONITORIUS -> Level.WARNING;
      case INFORMATIVUS -> Level.INFO;
      case PRAEGRESSURUS -> Level.CONFIG;
      case SCRUTANS -> Level.FINE;
      case SCRUTANTIOR -> Level.FINER;
      case SCRUTANTISSIMUS -> Level.FINEST;
      case OMNIS -> Level.ALL;
    };

  GradusNuntii(@NotNull final Level gressus) {
    praecellentia = gressus.intValue();
  }

  /**
   * Modus hic compar\u0101ti\u014Dn\u012B intr\u0101 r\u0113s \u0113numer\u0101ti\u014Dnis huius classisque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
   * licet.
   * @param gressus valor tentandus
   * @return r\u0113s \u0113numer\u0101ti\u014Dnis huius quam valor {@code gressus} quadrat
   */
  @NotNull public static GradusNuntii gradior(@NotNull final Level gressus) {
    return Stream.of(values())
                 .filter(gradus -> gradus.gressus.get().intValue() == gressus.intValue())
                 .findFirst().orElse(OMNIS);
  }

  /**
   * Modus hic compar\u0101ti\u014Dn\u012B intr\u0101 r\u0113s \u0113numer\u0101ti\u014Dnis huius licet.
   * @param primus   valor tentandus
   * @param secundus valor tentandus
   * @return valor aut posit\u012Bvus s\u012B valor {@code primus} est maior quam valor {@code secundus} aut neg\u0101t\u012Bvus s\u012B valor
   *   {@code primus} est minor quam valor {@code secundus} aut n\u016Bllus s\u012B valor {@code primus} est aequ\u0101lis val\u014Dr\u012B
   *   {@code secundus}
   */
  public static int compareTo(@NotNull final GradusNuntii primus, @NotNull final GradusNuntii secundus) {
    return Integer.compare(primus.praecellentia, secundus.praecellentia);
  }
}
