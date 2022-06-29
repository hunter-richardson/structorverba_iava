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
import com.structorverba.officia.nuntii.Nuntius;
import com.structorverba.officia.tenores.TenorSimplicibus;
import lombok.*;
import org.apache.commons.lang3.*;

import java.util.function.Supplier;

/**
 * Classis {@link VerbumSimplex} repraesentat verbum aliquem quod f\u014Drmam \u016Bnam s\u014Dlum habet. <br>
 * R\u0113s classis {@link Inventor} r\u0113bus classis huius absunt atque in\u016Btil\u0113s fuerint. <br>
 * @param <Hoc> Tabell\u0101 h\u0101c classis {@link Hoc} ext\u0113nsi\u014Dnem aptam dat\u012Bs pet\u012Bt\u012Bs repraesentat.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class VerbumSimplex <Hoc extends Verbum <Hoc>> extends Verbum <Hoc> {
  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param ctgr val\u014Drem {@link #catagoria} indicat.
   * @param lm val\u014Drem {@link #lemma} indicat.
   */
  protected VerbumSimplex(@NonNull final Categoria ctgr, @NonNull final String lm) {
    super(ctgr, lm);
  }

  /**
   * @return Repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B classis {@link VerbumSimplex}. <br>
   * S\u014Dlum val\u014Drem {@link Verbum#lemma} potest referre cum f\u014Drm\u0101 \u016Bn\u0101.
   */
  @Override @NonNull
  public String toString() {
    return lemma;
  }

  /**
   * Classis {@link Coniunctivum} repraesentat coni\u016Bnct\u012Bva ut coniect\u0113ris. <br>
   * R\u0113s classis huius cat\u0113goriam {@link Categoria#CONIUNCTIVUM} \u016Btuntur c\u014Dnserv\u0101taque sunt
   * in scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101res</a>/coni\u016Bnct\u012Bva.
   * Classis haec classisque {@link Interiectio} \u0101 c\u014Dnspecti\u014Dne programm\u0101tis Str\u016BctorVerba est eaedem.
   * @see LectorSimplicibus.LectorConiunctivis
   * @see TenorSimplicibus.TenorConiunctivis
   * @see ConditorSimplicibus.ConditorConiunctivis
   * @see Nuntius.NuntiusConiunctivorum
   */
  public static final class Coniunctivum extends VerbumSimplex <Coniunctivum> {
    @Getter(lazy = true)
    @NonNull private final Nuntius.NuntiusConiunctivorum nuntius = Nuntius.NuntiusConiunctivorum.fac.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Coniunctivum(@NonNull final String lemma) {
      super(Categoria.CONIUNCTIVUM, lemma);
      nuntius.plusGarrio("Scr\u012Bbor ut", lemma);
    }
  }

  /**
   * Classis {@link Interiectio} repraesentat interiecti\u014Dnem ut coniect\u0113ris. <br>
   * R\u0113s classis huius cat\u0113goriam {@link Categoria#CONIUNCTIVUM} \u016Btuntur c\u014Dnserv\u0101taque sunt in
   * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/interiecti\u014Dn\u0113s.
   * Classis haec classisque {@link Coniunctivum} \u0101 c\u014Dnspecti\u014Dne programm\u0101tis Str\u016BctorVerba est eaedem.
   * @see LectorSimplicibus.LectorInteriectionibus
   * @see TenorSimplicibus.TenorInteriectionibus
   * @see ConditorSimplicibus.ConditorInteriectionibus
   * @see Nuntius.NuntiusInteriectionum
   */
  public static final class Interiectio extends VerbumSimplex <Interiectio> {
    @Getter(lazy = true)
    @NonNull private final Nuntius.NuntiusInteriectionum nuntius = Nuntius.NuntiusInteriectionum.fac.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Interiectio(@NonNull final String lemma) {
      super(Categoria.INTERIECTIO, lemma);
      nuntius.plusGarrio("Scr\u012Bbor ut", lemma);
    }
  }

  /**
   * Classis {@link Praepositio} repraesentat praepositi\u014Dn\u0113s ut coniecteris. <br>
   * R\u0113s classis huius cat\u0113goriam {@link Categoria#PRAEPOSITIO} \u016Btuntur c\u014Dnserv\u0101taque sunt in
   * scr\u012Bni\u014D <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>/praepositi\u014Dn\u0113s.
   * @see LectorPraepositionibus
   * @see Nuntius.NuntiusPraepositionum
   */
  public static final class Praepositio extends VerbumSimplex <Praepositio> {
    /**
     * Valor hic supplet rem classis {@link Praepositio} quam praepositi\u014Dnem n\u016Blla repraesentat.
     */
    @NonNull public static final Supplier <Praepositio> assume =
      () -> Praepositio.builder().build();
    @Getter(lazy = true)
    @NonNull private final Nuntius.NuntiusPraepositionum nuntius = Nuntius.NuntiusPraepositionum.fac.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Praepositio(@NonNull final String lemma) {
      super(Categoria.PRAEPOSITIO, lemma);
      nuntius.plusGarrio("Scr\u012Bbor ut", lemma);
    }
  }

  /**
   * Classis {@link Numerus} repraesentat numer\u014Ds ut coniect\u0113ris. <br>
   * R\u0113s classis huius cat\u0113goriam {@link Categoria#NUMERUS} \u016Btuntur dataque e\u012Bs n\u014Dn
   * inveniet scr\u012Bnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>.
   * <br> Magis r\u0113s classis huius \u0101 numer\u012Bs classis <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
   * per \u016Bsum classis <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * f\u012Bant.
   * @see Nuntius.NuntiusNumerorum
   * @see <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Short.html">Short</a>
   */
  public static final class Numerus extends VerbumSimplex <Numerus> {
    /**
     * Valor hic numerum maximum possibilem repraesentat.
     */
    public static final short MINUMUM = 1;

    /**
     * Valor hic numerum minumum possibilem repraesentat.
     */
    public static final short MAXIMUM = 3999;

    /**
     * Valor hic repraesent\u0101ti\u014Dnem numeriam tenet re\u012B huic.
     */
    @IntRange(from = MINUMUM, to = MAXIMUM)
    private final int numerus;
    @Getter(lazy = true)
    @NonNull private final Nuntius.NuntiusNumerorum nuntius = Nuntius.NuntiusNumerorum.fac.get();

    @Builder(access = AccessLevel.PUBLIC, toBuilder = true)
    private Numerus(final short numerus) throws IllegalArgumentException {
      super(Categoria.NUMERUS, String.valueOf(numerus));
      this.numerus = Validator.range(Short.toUnsignedInt(numerus));
      nuntius.plusGarrio("Scr\u012Bbor ut", toString());
    }

    public short numerus() {
      return Integer.valueOf(Validator.range(numerus)).shortValue();
    }

    @NonNull private RomanInteger ostendam() throws IllegalArgumentException {
      return RomanInteger.parse(String.valueOf(numerus), IntegerType.ARABIC);
    }

    /**
     * @return Repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B classis huic. <br>
     * Modus hic val\u014Drem <a href="https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#EMPTY">StringUtils.EMPTY</a>
     * refert s\u012B <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * err\u014Drem continu\u0101tur.
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
     * @param alius r\u0113s classis {@link Numerus} \u016Bsa additi\u014Dn\u012B.
     * @return Rem classis {@link Numerus} quae \u0113ventum additi\u014Dnis cum val\u014Dre {@code alius} repraesentat. <br>
     * Modus hic val\u014Drem {@code null} refert s\u012B <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * err\u014Drem continu\u0101tur.
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
     * @param alius r\u0113s classis {@link Numerus} \u016Bsa subtracti\u014Dn\u012B.
     * @return Rem classis {@link Numerus} quae \u0113ventum subtracti\u014Dnis cum val\u014Dre {@code alius} repraesentat. <br>
     * Modus hic val\u014Drem {@code null} refert s\u012B <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * err\u014Drem continu\u0101tur.
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
     * @param alius r\u0113s classis {@link Numerus} \u016Bsa multiplic\u0101ti\u014Dn\u012B.
     * @return Rem classis {@link Numerus} quae \u0113ventum multiplic\u0101ti\u014Dnis cum val\u014Dre {@code alius} repraesentat. <br>
     * Modus hic val\u014Drem {@code null} refert s\u012B <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * err\u014Drem continu\u0101tur.
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
     * @param alius r\u0113s classis {@link Numerus} \u016Bsa d\u012Bv\u012Bsi\u014Dn\u012B.
     * @return Rem classis {@link Numerus} quae \u0113ventum d\u012Bv\u012Bsi\u014Dnis cum val\u014Dre {@code alius} repraesentat. <br>
     * Modus hic val\u014Drem {@code null} refert s\u012B <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * err\u014Drem continu\u0101tur.
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
     * @param alius r\u0113s classis {@link Numerus} \u016Bsa m\u0101nsi\u014Dn\u012B.
     * @return Rem classis {@link Numerus} quae \u0113ventum m\u0101nsi\u014Dnis cum val\u014Dre {@code alius} repraesentat. <br>
     * Modus hic val\u014Drem {@code null} refert s\u012B <a href="https://github.com/Chaosfirebolt/RomanNumeralConverter/blob/master/src/main/java/com/github/chaosfirebolt/converter/RomanInteger.java">RomanInteger</a>
     * err\u014Drem continu\u0101tur.
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
}
