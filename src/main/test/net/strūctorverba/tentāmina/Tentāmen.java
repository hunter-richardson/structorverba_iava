package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.function.Function;

/**
 * Classis {@link Tentāmen} tentāmen magnum iterābile repraesentat. Rēs omnis classis huius invocātiōnēs plūrēs
 * continet.
 * @param <Illud> Classis reī tentandī
 * @param <Hoc>   Classis datī exspectandī
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
abstract class Tentāmen <Illud, Hoc> {
  @NotNull private final Function <Illud, String> exsecūtiō;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param exsct modus operātiōnēs dēfīnit reī classis {@link Illud} perfungī.
   */
  protected Tentāmen(@NotNull final Function <Illud, String> exsct) {
    exsecūtiō = exsct;
  }

  /**
   * Modus operātiōnēs praefinītās perfungitur. <br> Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
   * cum errōre scrīptō iacit sī tentāmen aborītur
   * @param illud Rēs classis {@link Illud} cui operātiōnēs praefinītās perfungitur
   * @return Scrīptula quae successum indicat
   */
  public String exsequar(@Nullable final Illud illud) {
    return exsecūtiō.apply(illud);
  }

  /**
   * Classis est classem {@link Tentāmen} ūtitur rēs classum {@link Verba} et <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a>
   * comparāre.
   */
  static final class TentāmenVerbāle extends Tentāmen <Verba, String> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param data  valor datum exspectandum continet.
     * @param nōmen valor hoc inter multa identificat.
     */
    public TentāmenVerbāle(@NotNull final String data, @NotNull final String nōmen) {
      super(illud -> {
        new Tentāmiculum.TentāmiculumReī(illud)
          .existat(String.format("Verba prōducta %s vacant.", nōmen));
        new Tentāmiculum.TentāmiculumNumerālis <>(0, illud.seriēs.size())
          .superet(String.format("Verba prōducta %s vacant.", nōmen));
        for (int index = 0; index < illud.seriēs.size(); index++) {
          new Tentāmiculum.TentāmiculumReī(illud.seriēs.get(index))
            .existat(String.format("Prōductā %s est relicta prōductiō verbī %s.",
                                   nōmen, Ūtilitās.minusculāsScrībō(data.split(String.valueOf(' '))[ index ])));
          new Tentāmiculum.TentāmiculumVersiculī(illud.seriēs.get(index).toString())
            .aliamContineat(String.format("Prōductā %s est relicta prōductiō verbī %s.",
                                          nōmen, Ūtilitās.minusculāsScrībō(data.split(String.valueOf(' '))[ index ])));
        }

        new Tentāmiculum.TentāmiculumVersiculī(data, illud.toString())
          .aequentur(String.format("Verba prōducta %s expectātiōne eius differt.", nōmen));
        return String.format("Prōducta %s: %s", nōmen, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentāmen} ūtitur rēs classum {@link VerbumSimplex.Numerus} et <a
   * href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> comparāre.
   */
  static final class TentāmenNumerāleConversiōnis extends Tentāmen <VerbumSimplex.Numerus, String> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param data    valor datum exspectandum continet.
     * @param numerus valor hoc inter multa identificat.
     */
    public TentāmenNumerāleConversiōnis(@NotNull final String data, final short numerus) {
      super(illud -> {
        new Tentāmiculum.TentāmiculumReī(illud)
          .existat(String.format("Prōductā conversiōnis est relicta prōductiō numerī %d.", numerus));
        new Tentāmiculum.TentāmiculumVersiculī(illud.toString())
          .aliamContineat("Numerum prōductum conversiōnis vacat.");
        new Tentāmiculum.TentāmiculumVersiculī(data, illud.toString())
          .aequentur("Numerum prōductum conversiōnis expectātiōne eius differt.");
        return String.format("%d = %s", numerus, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentāmen} ūtitur rēs classum {@link VerbumSimplex.Numerus} et <a
   * href="https://docs.oracle.com/javase/10/docs/api/java/lang/Short.html">Short</a> comparāre.
   */
  static final class TentāmenNumerāleReversiōnis extends Tentāmen <VerbumSimplex.Numerus, Short> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param numerus  valor datum exspectandum continet.
     * @param scrīptiō valor hoc inter multa identificat.
     */
    public TentāmenNumerāleReversiōnis(@NotNull final Short numerus, @NotNull final String scrīptiō) {
      super(illud -> {
        new Tentāmiculum.TentāmiculumReī(illud)
          .existat(String.format("Prōductā reversiōnis est relicta prōductiō numerī %s.", scrīptiō));
        new Tentāmiculum.TentāmiculumNumerālis <>(numerus, illud.numerus)
          .aequentur("Numerum prōductum reversiōnis expectātiōne eius differt.");
        return String.format("%s = %d", scrīptiō, illud.numerus);
      });
    }
  }

  /**
   * Classis est classem {@link Tentāmen} classēs {@link TentāmenNumerāleConversiōnis} et {@link
   * TentāmenNumerāleReversiōnis} combīnat.
   */
  @SuppressWarnings("ConstantConditions")
  static final class TentāmenNumerāleCombīnātiōnis extends Tentāmen <VerbumSimplex.Numerus, Short> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param numerus valor datum exspectandum continet.
     */
    public TentāmenNumerāleCombīnātiōnis(@NotNull final Short numerus) {
      super(prīmus -> {
        new Tentāmiculum.TentāmiculumReī(prīmus)
          .existat(String.format("Prōductā conversiōnis est relicta prōductiō numerī %d.", numerus));
        new Tentāmiculum.TentāmiculumVersiculī(prīmus.toString())
          .aliamContineat("Numerum prōductum conversiōnis vacat.");

        @NotNull final StrūctorVerba strūctor = StrūctorVerba.fac.get();
        @NotNull final VerbumSimplex.Numerus secundus = strūctor.numerus(prīmus.toString());
        new Tentāmiculum.TentāmiculumReī(secundus)
          .existat(String.format("Prōductā conversiōnis est relicta prōductiō numerī %d.", numerus));
        new Tentāmiculum.TentāmiculumNumerālis <>(numerus, secundus.numerus)
          .aequentur("Numerum prōductum combīnātiōnis expectātiōne eius differt.");

        return String.format("%s = %d%n%d = %s%n", prīmus, numerus, numerus, secundus);
      });
    }
  }

  /**
   * Classis {@link TentāmenMathēmaticum} tentāmen operātiōnī mathēmaticae dēfīnit.
   */
  @SuppressWarnings("ConstantConditions")
  static final class TentāmenMathēmaticum extends Tentāmen <VerbumSimplex.Numerus, Range <Short>> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param range    valor datum exspectandum continet.
     * @param operātiō valor operātiōnem mathēmaticam identificat.
     */
    public TentāmenMathēmaticum(@NotNull final Range <Short> range, final char operātiō) {
      super(prīmus -> {
        new Tentāmiculum.TentāmiculumReī(prīmus)
          .existat(String.format("Prōductā %s est relicta prōductiō numerī %d.", operātiō, range.getMaximum()));
        new Tentāmiculum.TentāmiculumVersiculī(prīmus.toString())
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operātiō));

        final String labor = switch (operātiō) {
          case '+' -> "additiōnis";
          case '-' -> "subtractiōnis";
          case '*' -> "multiplicātiōnis";
          case '/' -> "dīvīsiōnis";
          case '%' -> "mānsiōnis";
          default -> StringUtils.EMPTY;
        };

        short expectātus = switch (operātiō) {
          case '+' -> (short) (range.getMaximum() + range.getMinimum());
          case '-' -> (short) (range.getMaximum() - range.getMinimum());
          case '*' -> (short) (range.getMaximum() * range.getMinimum());
          case '/' -> (short) (range.getMaximum() / range.getMinimum());
          case '%' -> (short) (range.getMaximum() % range.getMinimum());
          default -> (short) 0;
        };

        @NotNull final StrūctorVerba strūctor = StrūctorVerba.fac.get();
        @NotNull final VerbumSimplex.Numerus secundus = strūctor.numerus(range.getMinimum());
        new Tentāmiculum.TentāmiculumReī(secundus)
          .existat(String.format("Prōductā %s est relicta prōductiō numerī %d.", operātiō, range.getMinimum()));
        new Tentāmiculum.TentāmiculumVersiculī(secundus.toString())
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operātiō));

        final VerbumSimplex.Numerus ēventus = switch (operātiō) {
          case '+' -> prīmus.addō(secundus);
          case '-' -> prīmus.subtrahō(secundus);
          case '*' -> prīmus.multiplicō(secundus);
          case '/' -> prīmus.dīvidō(secundus);
          case '%' -> prīmus.maneō(secundus);
          default -> null;
        };

        new Tentāmiculum.TentāmiculumReī(ēventus)
          .existat(String.format("Prōductā %s est relicta prōductiō numerī %d.", operātiō, expectātus));
        new Tentāmiculum.TentāmiculumVersiculī(ēventus.toString())
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operātiō));
        new Tentāmiculum.TentāmiculumNumerālis <>(expectātus, ēventus.numerus)
          .aequentur(String.format("Numerum prōductum %s expectātiōne eius differt.", operātiō));

        return String.format("%d = %s%n%d = %s%n%d %c %d = %d = %s",
                             range.getMaximum(), prīmus, range.getMinimum(), secundus,
                             range.getMaximum(), operātiō, range.getMinimum(), expectātus, ēventus);
      });
    }
  }
}
