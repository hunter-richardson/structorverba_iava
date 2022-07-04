package com.structorverba.officia.verba;

import androidx.annotation.*;
import androidx.annotation.NonNull;
import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import com.github.chaosfirebolt.converter.util.Validator;
import com.structorverba.officia.conditores.ConditorSimplicibus;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.inventores.Inventor;
import com.structorverba.officia.lectores.*;
import com.structorverba.officia.miscella.Utilitas;
import com.structorverba.officia.nuntii.*;
import com.structorverba.officia.tenores.TenorSimplicibus;
import jakarta.ejb.Singleton;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link VerbumSimplex} repraesentat verbum aliquem quod fōrmam ūnam sōlum habet. <br>
 * Rēs classis {@link Inventor} rēbus huius classis absunt atque inūtilēs fuerint. <br>
 * @param <Hoc> Hāc tabellā classis {@link Hoc} extēnsiōnem aptam datīs petītīs repraesentat.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class VerbumSimplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param ctgr valōrem {@link #catagoria} indicat.
   * @param lm valōrem {@link #lemma} indicat.
   */
  protected VerbumSimplex(@NonNull final Categoria ctgr, @NonNull final String lm) {
    super(ctgr, lm);
  }

  /**
   * @return Repraesentātiōnem scrīpta reī classis {@link VerbumSimplex}. <br>
   * Sōlum valōrem {@link Verbum#lemma} potest referre cum fōrmā ūnā.
   */
  @Override @NonNull
  public String toString() {
    return lemma;
  }

  /**
   * Classis {@link Coniunctio} repraesentat coniūnctīva ut coniectēris. <br>
   * Rēs huius classis catēgoriam {@link Categoria#CONIUNCTIO} ūtuntur cōnservātaque sunt
   * in scrīniō <a href="{@docRoot}/../src/main/resources">auxiliāres</a>/coniūnctīva.
   * Haec classis classisque {@link Interiectio} ā cōnspectiōne programmātis StrūctorVerba est eaedem.
   * @see LectorSimplicibus.LectorConiunctionibus
   * @see TenorSimplicibus.TenorConiunctionibus
   * @see ConditorSimplicibus.ConditorConiunctionibus
   * @see NuntiusConiunctivorum
   */
  public static final class Coniunctio extends VerbumSimplex <Coniunctio> {
    @Getter(lazy = true)
    @NonNull private final NuntiusConiunctivorum nuntius = NuntiusConiunctivorum.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Coniunctio(@NonNull final String lemma) {
      super(Categoria.CONIUNCTIO, lemma);
      nuntius.plusGarrio("Scrībor ut", lemma);
    }

    /**
     * Classis {@link NuntiusConiunctivorum} est vās classis {@link Nuntius} classī {@link Coniunctio}}
     * @see Coniunctio
     */
    @Singleton
    private static final class NuntiusConiunctivorum extends Nuntius {
      @Nullable private static NuntiusConiunctivorum instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      @NonNull private static final Supplier <NuntiusConiunctivorum> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusConiunctivorum());

      private NuntiusConiunctivorum() {
        super(ParametriNuntii.para(Coniunctio.class));
      }
    }
  }

  /**
   * Classis {@link Interiectio} repraesentat interiectiōnem ut coniectēris. <br>
   * Rēs huius classis catēgoriam {@link Categoria#CONIUNCTIO} ūtuntur cōnservātaque sunt in
   * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/interiectiōnēs.
   * Haec classis classisque {@link Coniunctio} ā cōnspectiōne programmātis StrūctorVerba est eaedem.
   * @see LectorSimplicibus.LectorInteriectionibus
   * @see TenorSimplicibus.TenorInteriectionibus
   * @see ConditorSimplicibus.ConditorInteriectionibus
   * @see NuntiusInteriectionum
   */
  public static final class Interiectio extends VerbumSimplex <Interiectio> {
    @Getter(lazy = true)
    @NonNull private final NuntiusInteriectionum nuntius = NuntiusInteriectionum.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Interiectio(@NonNull final String lemma) {
      super(Categoria.INTERIECTIO, lemma);
      nuntius.plusGarrio("Scrībor ut", lemma);
    }

    /**
     * Classis {@link NuntiusInteriectionum} est vās classis {@link Nuntius} classī {@link VerbumSimplex.Interiectio}}
     * @see VerbumSimplex.Interiectio
     */
    @Singleton
    static final class NuntiusInteriectionum extends Nuntius {
      @Nullable static NuntiusInteriectionum instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      static @NonNull Supplier <NuntiusInteriectionum> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusInteriectionum());

      NuntiusInteriectionum() {
        super(ParametriNuntii.para(VerbumSimplex.Interiectio.class));
      }
    }
  }

  /**
   * Classis {@link Praepositio} repraesentat praepositiōnēs ut coniecteris. <br>
   * Rēs huius classis catēgoriam {@link Categoria#PRAEPOSITIO} ūtuntur cōnservātaque sunt in
   * scrīniō <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>/praepositiōnēs.
   * @see LectorPraepositionibus
   * @see NuntiusPraepositionum
   */
  public static final class Praepositio extends VerbumSimplex <Praepositio> {
    /**
     * Hic valor supplet rem classis {@link Praepositio} quam praepositiōnem nūlla repraesentat.
     */
    @NonNull public static final Supplier <Praepositio> assume =
      () -> Praepositio.builder().build();
    @Getter(lazy = true)
    @NonNull private final NuntiusPraepositionum nuntius = NuntiusPraepositionum.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Praepositio(@NonNull final String lemma) {
      super(Categoria.PRAEPOSITIO, lemma);
      nuntius.plusGarrio("Scrībor ut", lemma);
    }

    /**
     * Classis {@link NuntiusPraepositionum} est vās classis {@link Nuntius} classī {@link VerbumSimplex.Praepositio}}
     * @see VerbumSimplex.Praepositio
     */
    @Singleton
    static final class NuntiusPraepositionum extends Nuntius {
      @Nullable static NuntiusPraepositionum instantia = null;

      /**
       * Hic valor viam reī huius classis facit.
       * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
       */
      static @NonNull Supplier <NuntiusPraepositionum> faciendum =
              () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusPraepositionum());

      NuntiusPraepositionum() {
        super(ParametriNuntii.para(VerbumSimplex.Praepositio.class));
      }
    }
  }

  /**
   * Classis {@link Numerus} repraesentat numerōs ut coniectēris. <br>
   * Rēs huius classis catēgoriam {@link Categoria#NUMERUS} ūtuntur dataque eīs nōn
   * inveniet scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>.
   * <br> Magis rēs huius classis ā numerīs classis <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
   * per ūsum classis <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * fīant.
   * @see NuntiusNumerorum
   * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
   */
  public static final class Numerus extends VerbumSimplex <Numerus> {
    /**
     * Hic valor numerum maximum possibilem repraesentat.
     */
    public static final short MINUMUM = 1;

    /**
     * Hic valor numerum minumum possibilem repraesentat.
     */
    public static final short MAXIMUM = 3999;

    /**
     * Hic valor repraesentātiōnem numeriam huic reī tenet.
     */
    @IntRange(from = MINUMUM, to = MAXIMUM)
    private final int numerus;
    @Getter(lazy = true)
    @NonNull private final NuntiusNumerorum nuntius = NuntiusNumerorum.faciendum.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Numerus(final short numerus) throws IllegalArgumentException {
      super(Categoria.NUMERUS, String.valueOf(numerus));
      this.numerus = Validator.range(Short.toUnsignedInt(numerus));
      nuntius.plusGarrio("Scrībor ut", toString());
    }

    public short numerus() {
      return Integer.valueOf(numerus).shortValue();
    }

    @NonNull private RomanInteger ostendam() throws IllegalArgumentException {
      return RomanInteger.parse(String.valueOf(numerus), IntegerType.ARABIC);
    }

    /**
     * @return Repraesentātiōnem scrīpta reī huius classis. <br>
     * Hic modus valōrem <a href="https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#EMPTY">StringUtils.EMPTY</a>
     * refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Override @NonNull
    public String toString() throws IllegalArgumentException {
      try {
        return Utilitas.capitaneasScribo(ostendam().toString());
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        return StringUtils.EMPTY;
      }
    }

    /**
     * @param alius rēs classis {@link Numerus} ūsa additiōnī.
     * @return Rem classis {@link Numerus} quae ēventum additiōnis cum valōre {@code alius} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus addo(final @NonNull Numerus alius) {
      try {
        return new Numerus(Integer.valueOf(ostendam().add(alius.ostendam()).getArabic()).shortValue());
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        return null;
      }
    }

    /**
     * @param alius rēs classis {@link Numerus} ūsa subtractiōnī.
     * @return Rem classis {@link Numerus} quae ēventum subtractiōnis cum valōre {@code alius} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus subtraho(final @NonNull Numerus alius) {
      try {
        return new Numerus(Integer.valueOf(ostendam().subtract(alius.ostendam()).getArabic()).shortValue());
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        return null;
      }
    }

    /**
     * @param alius rēs classis {@link Numerus} ūsa multiplicātiōnī.
     * @return Rem classis {@link Numerus} quae ēventum multiplicātiōnis cum valōre {@code alius} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus multiplico(final @NonNull Numerus alius) {
      try {
        return new Numerus(Integer.valueOf(ostendam().multiply(alius.ostendam()).getArabic()).shortValue());
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        return null;
      }
    }

    /**
     * @param alius rēs classis {@link Numerus} ūsa dīvīsiōnī.
     * @return Rem classis {@link Numerus} quae ēventum dīvīsiōnis cum valōre {@code alius} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus divido(final @NonNull Numerus alius) {
      try {
        return new Numerus(Integer.valueOf(ostendam().divide(alius.ostendam()).getArabic()).shortValue());
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        return null;
      }
    }

    /**
     * @param alius rēs classis {@link Numerus} ūsa mānsiōnī.
     * @return Rem classis {@link Numerus} quae ēventum mānsiōnis cum valōre {@code alius} repraesentat. <br>
     * Hic modus valōrem {@code null} refert sī <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * errōrem continuātur.
     * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     */
    @Nullable public Numerus maneo(final @NonNull Numerus alius) {
      try {
        return new Numerus(Integer.valueOf(ostendam().remainder(alius.ostendam()).getArabic()).shortValue());
      } catch (IllegalArgumentException e) {
        nuntius.terreo(e);
        return null;
      }
    }
  }

  /**
   * Classis {@link NuntiusNumerorum} est vās classis {@link Nuntius} classī {@link VerbumSimplex.Numerus}}
   * @see VerbumSimplex.Numerus
   */
  @Singleton
  static final class NuntiusNumerorum extends Nuntius {
    @Nullable static NuntiusNumerorum instantia = null;

    /**
     * Hic valor viam reī huius classis facit.
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
     */
    @NonNull static final Supplier <NuntiusNumerorum> faciendum =
            () -> ObjectUtils.firstNonNull(instantia, instantia = new NuntiusNumerorum());

    NuntiusNumerorum() {
      super(ParametriNuntii.para(VerbumSimplex.Numerus.class));
    }
  }
}
