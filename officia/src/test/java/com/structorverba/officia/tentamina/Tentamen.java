package com.structorverba.officia.tentamina;

import androidx.annotation.*;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.verba.*;
import org.apache.commons.lang3.*;

import java.util.function.Function;

/**
 * Classis {@link Tentamen} tentāmen magnum iterābile repraesentat. <br>
 * Rēs omnis classis huius invocātiōnēs plūrēs continet.
 * @param <Illud> Classis reī tentandī
 * @param <Hoc>   Classis datī exspectandī
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public abstract class Tentamen<Illud, Hoc> {
  @NonNull private final Function <Illud, String> exsecutio;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param exsct modus operātiōnēs dēfīnit reī classis {@link Illud} perfungī.
   */
  protected Tentamen(@NonNull final Function <Illud, String> exsct) {
    exsecutio = exsct;
  }

  /**
   * Modus operātiōnēs praefinītās perfungitur. <br>
   * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
   * cum errōre scrīptō iacit sī tentāmen aborītur
   * @param illud Rēs classis {@link Illud} cui operātiōnēs praefinītās perfungitur
   * @return Scrīptula quae successum indicat
   */
  public String exsequar(@Nullable final Illud illud) {
    return exsecutio.apply(illud);
  }

  /**
   * Classis est classem {@link Tentamen} ūtitur rēs classum {@link Verba}
   * et <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> comparāre.
   */
  public static final class TentamenVerbale extends Tentamen<Verba, String> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param data  valor datum exspectandum continet.
     * @param nomen valor hoc inter multa identificat.
     */
    public TentamenVerbale(@NonNull final String data, @NonNull final String nomen) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
          .existat(String.format("Verba prōducta %s vacant.", nomen));
        new Tentamiculum.TentamiculumNumeralis <>(0, illud.series.size())
          .superet(String.format("Verba prōducta %s vacant.", nomen));
        for (int index = 0; index < illud.series.size(); index++) {
          new Tentamiculum.TentamiculumRei(illud.series.get(index))
            .existat(String.format("Prōductā %s relicta'st prōductiō verbī %s.",
                                   nomen, Utilitas.minusculasScribo(data.split(String.valueOf(' '))[ index ])));
          new Tentamiculum.TentamiculumVersiculi(illud.series.get(index))
            .aliamContineat(String.format("Prōductā %s relicta'st prōductiō verbī %s.",
                                          nomen, Utilitas.minusculasScribo(data.split(String.valueOf(' '))[ index ])));
        }

        new Tentamiculum.TentamiculumVersiculi(data, illud)
          .aequentur(String.format("Verba prōducta %s expectātiōne eius differt.", nomen));
        return String.format("Prōducta %s: %s", nomen, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} ūtitur rēs classum {@link Verba}
   * et <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> comparāre.
   */
  public static final class TentamenVerbi extends Tentamen<Verbum<? extends Verbum<?>>, String> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param data  valor datum exspectandum continet.
     * @param nomen valor hoc inter multa identificat.
     */
    public TentamenVerbi(@NonNull final String data, @NonNull final String nomen) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
                .existat(String.format("Verba prōducta %s vacant.", nomen));
        new Tentamiculum.TentamiculumRei(illud)
                .existat(String.format("Prōductā %s relicta'st prōductiō verbī %s.",
                         nomen, Utilitas.minusculasScribo(data)));
        new Tentamiculum.TentamiculumVersiculi(illud)
                .aliamContineat(String.format("Prōductā %s relicta'st prōductiō verbī %s.",
                                nomen, Utilitas.minusculasScribo(data)));
        return String.format("Prōducta %s: %s", nomen, illud);
      });
    }

    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param nomen valor hoc inter multa identificat.
     */
    public TentamenVerbi(@NonNull final String nomen) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud).existat(String.format("Verba prōducta %s vacant.", nomen));
        return String.format("Prōducta %s: %s", nomen, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} ūtitur rēs classum {@link VerbumSimplex.Numerus} et
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> comparāre.
   */
  public static final class TentamenNumeraleConversionis extends Tentamen<VerbumSimplex.Numerus, String> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param data    valor datum exspectandum continet.
     * @param numerus valor hoc inter multa identificat.
     */
    public TentamenNumeraleConversionis(@NonNull final String data, final short numerus) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
          .existat(String.format("Prōductā conversiōnis relicta'st prōductiō numerī %d.", numerus));
        new Tentamiculum.TentamiculumVersiculi(illud)
          .aliamContineat("Numerum prōductum conversiōnis vacat.");
        new Tentamiculum.TentamiculumVersiculi(data, illud)
          .aequentur("Numerum prōductum conversiōnis expectātiōne eius differt.");
        return String.format("%d = %s", numerus, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} ūtitur rēs classum {@link VerbumSimplex.Numerus} et
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Short.html">Short</a> comparāre.
   */
  public static final class TentamenNumeraleReversionis extends Tentamen<VerbumSimplex.Numerus, Short> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param numerus  valor datum exspectandum continet.
     * @param scriptio valor hoc inter multa identificat.
     */
    public TentamenNumeraleReversionis(@NonNull final Short numerus, @NonNull final String scriptio) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
          .existat(String.format("Prōductā reversiōnis relicta'st prōductiō numerī %s.", scriptio));
        new Tentamiculum.TentamiculumNumeralis <>(numerus, illud.numerus())
          .aequentur("Numerum prōductum reversiōnis expectātiōne eius differt.");
        return String.format("%s = %d", scriptio, illud.numerus());
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} classēs {@link TentamenNumeraleConversionis}
   * {@link TentamenNumeraleReversionis}que combīnat.
   */
  @SuppressWarnings("ConstantConditions")
  public static final class TentamenNumeraleCombinationis extends Tentamen<VerbumSimplex.Numerus, Short> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param numerus valor datum exspectandum continet.
     */
    public TentamenNumeraleCombinationis(@NonNull final Short numerus) {
      super(primus -> {
        new Tentamiculum.TentamiculumRei(primus)
          .existat(String.format("Prōductā conversiōnis relicta'st prōductiō numerī %d.", numerus));
        new Tentamiculum.TentamiculumVersiculi(primus)
          .aliamContineat("Numerum prōductum conversiōnis vacat.");

        @NonNull final StructorVerba structor = StructorVerba.faciendum.get();
        @NonNull final VerbumSimplex.Numerus secundus = structor.numeram(primus.toString());
        new Tentamiculum.TentamiculumRei(secundus)
          .existat(String.format("Prōductā conversiōnis relicta'st prōductiō numerī %d.", numerus));
        new Tentamiculum.TentamiculumNumeralis <>(numerus, secundus.numerus())
          .aequentur("Numerum prōductum combīnātiōnis expectātiōne eius differt.");

        return String.format("%s = %d%n%d = %s%n", primus, numerus, numerus, secundus);
      });
    }
  }

  /**
   * Classis {@link TentamenMathematicum} tentāmen operātiōnī mathēmaticae dēfīnit.
   */
  @SuppressWarnings("ConstantConditions")
  public static final class TentamenMathematicum extends Tentamen<VerbumSimplex.Numerus, Range <Short>> {
    /**
     * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
     * @param range    valor datum exspectandum continet.
     * @param operatio valor operātiōnem mathēmaticam identificat.
     */
    public TentamenMathematicum(@NonNull final Range <Short> range, final char operatio) {
      super(primus -> {
        new Tentamiculum.TentamiculumRei(primus)
          .existat(String.format("Prōductā %s relicta'st prōductiō numerī %d.", operatio, range.getMaximum()));
        new Tentamiculum.TentamiculumVersiculi(primus)
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operatio));

        final String labor = switch (operatio) {
          case '+' -> "additiōnis";
          case '-' -> "subtractiōnis";
          case '*' -> "multiplicātiōnis";
          case '/' -> "dīvīsiōnis";
          case '%' -> "mānsiōnis";
          default -> StringUtils.EMPTY;
        };

        short expectatus = switch (operatio) {
          case '+' -> (short) (range.getMaximum() + range.getMinimum());
          case '-' -> (short) (range.getMaximum() - range.getMinimum());
          case '*' -> (short) (range.getMaximum() * range.getMinimum());
          case '/' -> (short) (range.getMaximum() / range.getMinimum());
          case '%' -> (short) (range.getMaximum() % range.getMinimum());
          default -> (short) 0;
        };

        @NonNull final StructorVerba structor = StructorVerba.faciendum.get();
        @NonNull final VerbumSimplex.Numerus secundus = structor.numeram(range.getMinimum());
        new Tentamiculum.TentamiculumRei(secundus)
          .existat(String.format("Prōductā %s relicta'st prōductiō numerī %d.", operatio, range.getMinimum()));
        new Tentamiculum.TentamiculumVersiculi(secundus)
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operatio));

        final VerbumSimplex.Numerus eventus = switch (operatio) {
          case '+' -> primus.addo(secundus);
          case '-' -> primus.subtraho(secundus);
          case '*' -> primus.multiplico(secundus);
          case '/' -> primus.divido(secundus);
          case '%' -> primus.maneo(secundus);
          default -> null;
        };

        new Tentamiculum.TentamiculumRei(eventus)
          .existat(String.format("Prōductā %s relicta'st prōductiō numerī %d.", operatio, expectatus));
        new Tentamiculum.TentamiculumVersiculi(eventus)
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operatio));
        new Tentamiculum.TentamiculumNumeralis <>(expectatus, eventus.numerus())
          .aequentur(String.format("Numerum prōductum %s expectātiōne eius differt.", operatio));

        return String.format("%d = %s%n%d = %s%n%d %c %d = %d = %s",
                             range.getMaximum(), primus, range.getMinimum(), secundus,
                             range.getMaximum(), operatio, range.getMinimum(), expectatus, eventus);
      });
    }
  }
}
