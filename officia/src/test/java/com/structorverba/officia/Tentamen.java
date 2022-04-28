package officia.src.test.java.com.structorverba.officia;

import officia.src.main.java.com.structorverba.officia.miscella.*;
import officia.src.main.java.com.structorverba.officia.verba.*;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.function.Function;

/**
 * Classis {@link Tentamen} tent\u0101men magnum iter\u0101bile repraesentat. <br>
 * R\u0113s omnis classis huius invoc\u0101ti\u014Dn\u0113s pl\u016Br\u0113s continet.
 * @param <Illud> Classis re\u012B tentand\u012B
 * @param <Hoc>   Classis dat\u012B exspectand\u012B
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
abstract class Tentamen<Illud, Hoc> {
  @NotNull private final Function <Illud, String> exsecutio;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param exsct modus oper\u0101ti\u014Dn\u0113s d\u0113f\u012Bnit re\u012B classis {@link Illud} perfung\u012B.
   */
  protected Tentamen(@NotNull final Function <Illud, String> exsct) {
    exsecutio = exsct;
  }

  /**
   * Modus oper\u0101ti\u014Dn\u0113s praefin\u012Bt\u0101s perfungitur. <br>
   * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
   * cum err\u014Dre scr\u012Bpt\u014D iacit s\u012B tent\u0101men abor\u012Btur
   * @param illud R\u0113s classis {@link Illud} cui oper\u0101ti\u014Dn\u0113s praefin\u012Bt\u0101s perfungitur
   * @return Scr\u012Bptula quae successum indicat
   */
  public String exsequar(@Nullable final Illud illud) {
    return exsecutio.apply(illud);
  }

  /**
   * Classis est classem {@link Tentamen} \u016Btitur r\u0113s classum {@link Verba}
   * et <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> compar\u0101re.
   */
  static final class TentamenVerbale extends Tentamen<Verba, String> {
    /**
     * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
     * @param data  valor datum exspectandum continet.
     * @param nomen valor hoc inter multa identificat.
     */
    public TentamenVerbale(@NotNull final String data, @NotNull final String nomen) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
          .existat(String.format("Verba pr\u014Dducta %s vacant.", nomen));
        new Tentamiculum.TentamiculumNumeralis <>(0, illud.series.size())
          .superet(String.format("Verba pr\u014Dducta %s vacant.", nomen));
        for (int index = 0; index < illud.series.size(); index++) {
          new Tentamiculum.TentamiculumRei(illud.series.get(index))
            .existat(String.format("Pr\u014Dduct\u0101 %s relicta'st pr\u014Dducti\u014D verb\u012B %s.",
                                   nomen, Utilitas.minusculasScribo(data.split(String.valueOf(' '))[ index ])));
          new Tentamiculum.TentamiculumVersiculi(illud.series.get(index))
            .aliamContineat(String.format("Pr\u014Dduct\u0101 %s relicta'st pr\u014Dducti\u014D verb\u012B %s.",
                                          nomen, Utilitas.minusculasScribo(data.split(String.valueOf(' '))[ index ])));
        }

        new Tentamiculum.TentamiculumVersiculi(data, illud)
          .aequentur(String.format("Verba pr\u014Dducta %s expect\u0101ti\u014Dne eius differt.", nomen));
        return String.format("Pr\u014Dducta %s: %s", nomen, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} \u016Btitur r\u0113s classum {@link VerbumSimplex.Numerus} et
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> compar\u0101re.
   */
  static final class TentamenNumeraleConversionis extends Tentamen<VerbumSimplex.Numerus, String> {
    /**
     * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
     * @param data    valor datum exspectandum continet.
     * @param numerus valor hoc inter multa identificat.
     */
    public TentamenNumeraleConversionis(@NotNull final String data, final short numerus) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
          .existat(String.format("Pr\u014Dduct\u0101 conversi\u014Dnis relicta'st pr\u014Dducti\u014D numer\u012B %d.", numerus));
        new Tentamiculum.TentamiculumVersiculi(illud)
          .aliamContineat("Numerum pr\u014Dductum conversi\u014Dnis vacat.");
        new Tentamiculum.TentamiculumVersiculi(data, illud)
          .aequentur("Numerum pr\u014Dductum conversi\u014Dnis expect\u0101ti\u014Dne eius differt.");
        return String.format("%d = %s", numerus, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} \u016Btitur r\u0113s classum {@link VerbumSimplex.Numerus} et
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Short.html">Short</a> compar\u0101re.
   */
  static final class TentamenNumeraleReversionis extends Tentamen<VerbumSimplex.Numerus, Short> {
    /**
     * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
     * @param numerus  valor datum exspectandum continet.
     * @param scriptio valor hoc inter multa identificat.
     */
    public TentamenNumeraleReversionis(@NotNull final Short numerus, @NotNull final String scriptio) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud)
          .existat(String.format("Pr\u014Dduct\u0101 reversi\u014Dnis relicta'st pr\u014Dducti\u014D numer\u012B %s.", scriptio));
        new Tentamiculum.TentamiculumNumeralis <>(numerus, illud.numerus)
          .aequentur("Numerum pr\u014Dductum reversi\u014Dnis expect\u0101ti\u014Dne eius differt.");
        return String.format("%s = %d", scriptio, illud.numerus);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} class\u0113s {@link TentamenNumeraleConversionis}
   * {@link TentamenNumeraleReversionis}que comb\u012Bnat.
   */
  @SuppressWarnings("ConstantConditions")
  static final class TentamenNumeraleCombinationis extends Tentamen<VerbumSimplex.Numerus, Short> {
    /**
     * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
     * @param numerus valor datum exspectandum continet.
     */
    public TentamenNumeraleCombinationis(@NotNull final Short numerus) {
      super(primus -> {
        new Tentamiculum.TentamiculumRei(primus)
          .existat(String.format("Pr\u014Dduct\u0101 conversi\u014Dnis relicta'st pr\u014Dducti\u014D numer\u012B %d.", numerus));
        new Tentamiculum.TentamiculumVersiculi(primus)
          .aliamContineat("Numerum pr\u014Dductum conversi\u014Dnis vacat.");

        @NotNull final StructorVerba structor = StructorVerba.fac.get();
        @NotNull final VerbumSimplex.Numerus secundus = structor.numerus(primus.toString());
        new Tentamiculum.TentamiculumRei(secundus)
          .existat(String.format("Pr\u014Dduct\u0101 conversi\u014Dnis relicta'st pr\u014Dducti\u014D numer\u012B %d.", numerus));
        new Tentamiculum.TentamiculumNumeralis <>(numerus, secundus.numerus)
          .aequentur("Numerum pr\u014Dductum comb\u012Bn\u0101ti\u014Dnis expect\u0101ti\u014Dne eius differt.");

        return String.format("%s = %d%n%d = %s%n", primus, numerus, numerus, secundus);
      });
    }
  }

  /**
   * Classis {@link TentamenMathematicum} tent\u0101men oper\u0101ti\u014Dn\u012B math\u0113maticae d\u0113f\u012Bnit.
   */
  @SuppressWarnings("ConstantConditions")
  static final class TentamenMathematicum extends Tentamen<VerbumSimplex.Numerus, Range <Short>> {
    /**
     * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
     * @param range    valor datum exspectandum continet.
     * @param operatio valor oper\u0101ti\u014Dnem math\u0113maticam identificat.
     */
    public TentamenMathematicum(@NotNull final Range <Short> range, final char operatio) {
      super(primus -> {
        new Tentamiculum.TentamiculumRei(primus)
          .existat(String.format("Pr\u014Dduct\u0101 %s relicta'st pr\u014Dducti\u014D numer\u012B %d.", operatio, range.getMaximum()));
        new Tentamiculum.TentamiculumVersiculi(primus)
          .aliamContineat(String.format("Numerum pr\u014Dductum %s vacat.", operatio));

        final String labor = switch (operatio) {
          case '+' -> "additi\u014Dnis";
          case '-' -> "subtracti\u014Dnis";
          case '*' -> "multiplic\u0101ti\u014Dnis";
          case '/' -> "d\u012Bv\u012Bsi\u014Dnis";
          case '%' -> "m\u0101nsi\u014Dnis";
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

        @NotNull final StructorVerba structor = StructorVerba.fac.get();
        @NotNull final VerbumSimplex.Numerus secundus = structor.numerus(range.getMinimum());
        new Tentamiculum.TentamiculumRei(secundus)
          .existat(String.format("Pr\u014Dduct\u0101 %s relicta'st pr\u014Dducti\u014D numer\u012B %d.", operatio, range.getMinimum()));
        new Tentamiculum.TentamiculumVersiculi(secundus)
          .aliamContineat(String.format("Numerum pr\u014Dductum %s vacat.", operatio));

        final VerbumSimplex.Numerus eventus = switch (operatio) {
          case '+' -> primus.addo(secundus);
          case '-' -> primus.subtraho(secundus);
          case '*' -> primus.multiplico(secundus);
          case '/' -> primus.divido(secundus);
          case '%' -> primus.maneo(secundus);
          default -> null;
        };

        new Tentamiculum.TentamiculumRei(eventus)
          .existat(String.format("Pr\u014Dduct\u0101 %s relicta'st pr\u014Dducti\u014D numer\u012B %d.", operatio, expectatus));
        new Tentamiculum.TentamiculumVersiculi(eventus)
          .aliamContineat(String.format("Numerum pr\u014Dductum %s vacat.", operatio));
        new Tentamiculum.TentamiculumNumeralis <>(expectatus, eventus.numerus)
          .aequentur(String.format("Numerum pr\u014Dductum %s expect\u0101ti\u014Dne eius differt.", operatio));

        return String.format("%d = %s%n%d = %s%n%d %c %d = %d = %s",
                             range.getMaximum(), primus, range.getMinimum(), secundus,
                             range.getMaximum(), operatio, range.getMinimum(), expectatus, eventus);
      });
    }
  }
}
