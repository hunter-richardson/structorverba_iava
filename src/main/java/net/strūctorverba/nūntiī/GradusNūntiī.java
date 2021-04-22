package net.strūctorverba.nūntiī;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * Ēnumerātiō hic persignat et gravitātem nūntiae singulārem et quam verbōsa rēs classis {@link Nūntius} scrībētur.
 * @see ParametrīNūntiī#gradusMinimus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
enum GradusNūntiī {
  /**
   * Valor hic indicat rem taciturna classis {@link Nūntius}.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a>
   */
  INERS(Level.OFF),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae errōrēs sōlum persignat.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a>
   */
  GRAVIS(Level.SEVERE),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae persignat errōrēs nūntiāsque quās errōrem addūcant.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a>
   */
  PRAEMONITŌRIUS(Level.WARNING),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae persignat nūntiās quās ūsūfructuāriīs programmātis intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a>
   */
  ĪNFŌRMĀTĪVUS(Level.INFO),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae persignat nūntiās quās auctōribus programmātis intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a>
   */
  PRAEGRESSŪRUS(Level.CONFIG),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae persignat nūntiās quās nēminī fortasse intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a>
   */
  SCRŪTĀNS(Level.FINE),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae persignat nūntiās quās nēminī probābiliter intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a>
   */
  SCRŪTĀNTIOR(Level.FINER),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae persignat nūntiās quās nēminī certissime intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a>
   */
  SCRŪTĀNTISSIMUS(Level.FINEST),

  /**
   * Valor hic indicat rem classis {@link Nūntius} quae nūntiās omnēs persignat.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a>
   */
  OMNIS(Level.ALL);

  /**
   * Valor hic comparātiōnī rērum ēnumerātiōnis huius licet.
   */
  public final int praecellentia;

  GradusNūntiī(@NotNull final Level gressus) {
    praecellentia = gressus.intValue();
  }

  /**
   * Modus hic comparātiōnī intrā rēs ēnumerātiōnis huius classisque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a> licet.
   * @param gressus valor tentandus
   * @return rēs ēnumerātiōnis huius quam valor {@code gressus} quadrat
   */
  @NotNull public static GradusNūntiī gradior(@NotNull final Level gressus) {
    return Stream.of(values())
                 .filter(gradus -> gradus.gressus.get().intValue() == gressus.intValue())
                 .findFirst().orElse(OMNIS);
  }

  /**
   * Modus hic comparātiōnī intrā rēs ēnumerātiōnis huius licet.
   * @param prīmus valor tentandus
   * @param secundus valor tentandus
   * @return valor aut positīvus sī valor {@code prīmus} est maior quam valor {@code secundus} aut negātīvus sī valor {@code prīmus} est minor quam valor {@code secundus} aut nūllus sī valor {@code prīmus} est aequālis valōrī {@code secundus}
   */
  public static int compareTo(@NotNull final GradusNūntiī prīmus, @NotNull final GradusNūntiī secundus) {
    return Integer.compare(prīmus.praecellentia, secundus.praecellentia);
  }

  /**
   * Modus hic societās intrā rēs ēnumerātiōnēs et huius et <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a> dēmōnstrat.
   * <ul>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a> valōrem {@link #INERS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a> valōrem {@link #GRAVIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a> valōrem {@link #PRAEMONITŌRIUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a> valōrem {@link #ĪNFŌRMĀTĪVUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a> valōrem {@link #PRAEGRESSŪRUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a> valōrem {@link #SCRŪTĀNS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a> valōrem {@link #SCRŪTĀNTIOR} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a> valōrem {@link #SCRŪTĀNTISSIMUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a> valōrem {@link #OMNIS} cōnsociat.</li>
   * </ul>
   */
  @NotNull public final Supplier<@NotNull Level> gressus = () -> switch (this) {
                                                                   case INERS -> Level.OFF;
                                                                   case GRAVIS -> Level.SEVERE;
                                                                   case PRAEMONITŌRIUS -> Level.WARNING;
                                                                   case ĪNFŌRMĀTĪVUS -> Level.INFO;
                                                                   case PRAEGRESSŪRUS -> Level.CONFIG;
                                                                   case SCRŪTĀNS -> Level.FINE;
                                                                   case SCRŪTĀNTIOR -> Level.FINER;
                                                                   case SCRŪTĀNTISSIMUS -> Level.FINEST;
                                                                   case OMNIS -> Level.ALL;
                                                                 };
}
