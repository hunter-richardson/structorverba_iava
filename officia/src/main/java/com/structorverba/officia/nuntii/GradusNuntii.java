package com.structorverba.officia.nuntii;

import androidx.annotation.NonNull;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Stream;

/**
 * Haec ēnumerātiō persignat gravitātemque nūntiae singulārem et quam verbōsa rēs classis {@link Nuntius} scrībētur.
 * @see ParametriNuntii#gradusMinimus
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
enum GradusNuntii {
  /**
   * Hic valor indicat rem taciturna classis {@link Nuntius}.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a>
   */
  INERS(Level.OFF),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae errōrēs sōlum persignat.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a>
   */
  GRAVIS(Level.SEVERE),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae persignat errōrēs nūntiāsque quās errōrem addūcant.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a>
   */
  PRAEMONITORIUS(Level.WARNING),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās ūsūfructuāriīs programmātis intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a>
   */
  INFORMATIVUS(Level.INFO),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās auctōribus programmātis intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a>
   */
  PRAEGRESSURUS(Level.CONFIG),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās nēminī fortasse intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a>
   */
  SCRUTANS(Level.FINE),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās nēminī probābiliter intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a>
   */
  SAEPE_SCRUTANS(Level.FINER),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae persignat nūntiās quās nēminī certissime intersit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a>
   */
  SEMPER_SCRUTANS(Level.FINEST),

  /**
   * Hic valor indicat rem classis {@link Nuntius} quae nūntiās omnēs persignat.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a>
   */
  OMNIS(Level.ALL);

  /**
   * Hic valor comparātiōnī rērum huius ēnumerātiōnis licet.
   */
  public final int praecellentia;
  /**
   * Hic modus societās intrā rēs huius ēnumerātiōnēs rēsque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
   * dēmōnstrat.
   * <ul>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#OFF">OFF</a> valōrem {@link #INERS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#SEVERE">SEVERE</a> valōrem {@link #GRAVIS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#WARNING">WARNING</a> valōrem {@link #PRAEMONITORIUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#INFO">INFO</a> valōrem {@link #INFORMATIVUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#CONFIG">CONFIG</a> valōrem {@link #PRAEGRESSURUS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINE">FINE</a> valōrem {@link #SCRUTANS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINER">FINER</a> valōrem {@link #SAEPE_SCRUTANS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#FINEST">FINEST</a> valōrem {@link #SEMPER_SCRUTANS} cōnsociat.</li>
   *   <li>Valor <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html#ALL">ALL</a> valōrem {@link #OMNIS} cōnsociat.</li>
   * </ul>
   */
  @NonNull public final Supplier <Level> gressus = () ->
    switch (this) {
      case INERS -> Level.OFF;
      case GRAVIS -> Level.SEVERE;
      case PRAEMONITORIUS -> Level.WARNING;
      case INFORMATIVUS -> Level.INFO;
      case PRAEGRESSURUS -> Level.CONFIG;
      case SCRUTANS -> Level.FINE;
      case SAEPE_SCRUTANS -> Level.FINER;
      case SEMPER_SCRUTANS -> Level.FINEST;
      case OMNIS -> Level.ALL;
    };

  GradusNuntii(@NonNull final Level gressus) {
    praecellentia = gressus.intValue();
  }

  /**
   * Hic modus comparātiōnī intrā rēs ēnumerātiōnis huius classisque <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Level</a>
   * licet.
   * @param gressus valor tentandus
   * @return rēs ēnumerātiōnis huius quam valor {@code gressus} quadrat
   */
  @NonNull public static GradusNuntii gradior(@NonNull final Level gressus) {
    return Stream.of(values())
                 .filter(gradus -> gradus.gressus.get().intValue() == gressus.intValue())
                 .findFirst().orElse(OMNIS);
  }

  /**
   * Hic modus comparātiōnī intrā rēs ēnumerātiōnis huius licet.
   * @param primus   valor tentandus
   * @param secundus valor tentandus
   * @return valor aut positīvus sī valor {@code primus} est maior quam valor {@code secundus} aut negātīvus sī valor
   *   {@code primus} est minor quam valor {@code secundus} aut nūllus sī valor {@code primus} est aequālis valōrī
   *   {@code secundus}
   */
  public static int compareTo(@NonNull final GradusNuntii primus, @NonNull final GradusNuntii secundus) {
    return Integer.compare(primus.praecellentia, secundus.praecellentia);
  }
}
