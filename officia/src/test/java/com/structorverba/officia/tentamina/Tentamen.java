package com.structorverba.officia.tentamina;

import androidx.annotation.*;
import com.structorverba.officia.enumerationes.Operatio;
import com.structorverba.officia.miscella.*;
import com.structorverba.officia.verba.*;

import java.util.Map;
import java.util.function.*;

/**
 * Classis {@link Tentamen} tentāmen magnum iterābile repraesentat. <br>
 * Rēs omnis huius classis invocātiōnēs plūrēs continet.
 * @param <Illud> Classis reī tentandī
 * @param <Hoc>   Classis datī exspectandī
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
public abstract class Tentamen<Illud, Hoc> {
  @NonNull private final Function <Illud, String> exsecutio;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
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
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param data  Hic valor datum exspectandum continet.
     * @param nomen Hic valor inter multa identificat.
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
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param data  Hic valor datum exspectandum continet.
     * @param nomen Hic valor inter multa identificat.
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
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param nomen Hic valor inter multa identificat.
     */
    public TentamenVerbi(@NonNull final String nomen) {
      super(illud -> {
        new Tentamiculum.TentamiculumRei(illud).existat(String.format("Verba prōducta %s vacant.", nomen));
        return String.format("Prōducta %s: %s", nomen, illud);
      });
    }
  }

  /**
   * Classis est classem {@link Tentamen} ūtitur rēs classum {@link Numerus} et
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a> comparāre.
   */
  public static final class TentamenNumeraleConversionis extends Tentamen<Numerus, String> {
    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param data    Hic valor datum exspectandum continet.
     * @param numerus Hic valor inter multa identificat.
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
   * Classis est classem {@link Tentamen} ūtitur rēs classum {@link Numerus} et
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Short.html">Short</a> comparāre.
   */
  public static final class TentamenNumeraleReversionis extends Tentamen<Numerus, Short> {
    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param numerus  Hic valor datum exspectandum continet.
     * @param scriptio Hic valor inter multa identificat.
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
  public static final class TentamenNumeraleCombinationis extends Tentamen<Numerus, Short> {
    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param numerus valor datum exspectandum continet.
     */
    public TentamenNumeraleCombinationis(@NonNull final Short numerus) {
      super(primus -> {
        new Tentamiculum.TentamiculumRei(primus)
          .existat(String.format("Prōductā conversiōnis relicta'st prōductiō numerī %d.", numerus));
        new Tentamiculum.TentamiculumVersiculi(primus)
          .aliamContineat("Numerum prōductum conversiōnis vacat.");

        @NonNull final StructorVerba structor = StructorVerba.faciendum.get();
        @NonNull final Numerus secundus = structor.numeram(primus.toString());
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
  public static final class TentamenMathematicum extends Tentamen<Numerus, Map.Entry<Short, Short>> {
    /**
     * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
     * @param numeri    valor datum exspectandum continet.
     * @param operatio valor operātiōnem mathēmaticam identificat.
     */
    public TentamenMathematicum(@NonNull final Map.Entry<Short, Short> numeri,
                                @NonNull final Operatio operatio) {
      super(primus -> {
        new Tentamiculum.TentamiculumRei(primus)
          .existat(String.format("Prōductā %s relicta'st prōductiō numerī %d.", operatio.name(), numeri.getKey()));
        new Tentamiculum.TentamiculumVersiculi(primus)
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operatio.name()));

        @NonNull final StructorVerba structor = StructorVerba.faciendum.get();
        @NonNull final Numerus secundus = structor.numeram(numeri.getValue());
        new Tentamiculum.TentamiculumRei(secundus)
          .existat(String.format("Prōductā %s relicta'st prōductiō numerī %d.", operatio.name(), numeri.getValue()));
        new Tentamiculum.TentamiculumVersiculi(secundus)
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operatio.name()));

        short expectatus = operatio.arabicus.apply(numeri.getKey().intValue(), numeri.getValue().intValue())
                                            .shortValue();

        try {
          final Numerus eventus = Numerus.agam(primus, secundus, operatio);

          new Tentamiculum.TentamiculumRei(eventus)
                  .existat(String.format("Prōductā %s relicta'st prōductiō numerī %d.", operatio.name(), expectatus));
          new Tentamiculum.TentamiculumVersiculi(eventus)
                  .aliamContineat(String.format("Numerum prōductum %s vacat.", operatio.name()));
          new Tentamiculum.TentamiculumNumeralis <>(expectatus, eventus.numerus())
                  .aequentur(String.format("Numerum prōductum %s expectātiōne eius differt.", operatio.name()));

          return String.format("%d = %s%n%d = %s%n%d %c %d = %d = %s",
                  numeri.getKey(), primus, numeri.getValue(), secundus,
                  numeri.getKey(), operatio.symbolum, numeri.getValue(), expectatus, eventus);
        } catch (IllegalArgumentException e) {
          return String.format("Prōductā %s relicta'st  prōductiō numerī %d.", operatio.name(), expectatus);
        }
      });
    }
  }
}
