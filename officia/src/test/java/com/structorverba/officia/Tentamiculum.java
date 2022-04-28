package officia.src.test.java.com.structorverba.officia;

import officia.src.main.java.com.structorverba.officia.miscella.Omnum;

import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * Classis {@link Tentamiculum} tent\u0101men singul\u0101rem repraesentat exsequendum dat\u0101 simplic\u012B.
 * @param <Hoc> Classis dat\u012B tentand\u012B
 */
@SuppressWarnings({ "SpellCheckingInspection", "UnusedReturnValue", "unused" })
abstract class Tentamiculum<Hoc> extends Omnum {
  /**
   * Valor hic repraesentat datum exspectandum
   */
  @Nullable protected final Hoc expectatio;

  /**
   * Valor hic repraesentat datum tentandum
   */
  @Nullable protected final Hoc productum;

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param prdctm valor {@link #productum} indicat.
   */
  protected Tentamiculum(@Nullable final Hoc prdctm) {
    productum = prdctm;
    expectatio = null;
  }

  /**
   * Officium hoc c\u014Dnstr\u016Bct\u014Drem re\u012B classis huius perpetrat.
   * @param expct  valor {@link #expectatio} indicat.
   * @param prdctm valor {@link #productum} indicat.
   */
  protected Tentamiculum(@NotNull final Hoc expct, @Nullable final Hoc prdctm) {
    productum = prdctm;
    expectatio = expct;
  }

  private boolean existitne( ) {
    return Objects.nonNull(productum);
  }

  /**
   * Modus hic tentat utrum {@link #productum} existat necne
   * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
   * @return Valor hic
   */
  public Tentamiculum<Hoc> existat(@NotNull final String error) {
    Assertions.assertTrue(existitne(), error);
    return this;
  }

  /**
   * Classis est v\u0101s classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html">Object</a>que aliae
   */
  static final class TentamiculumRei extends Tentamiculum<Object> {
    /**
     * {@inheritDoc}
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumRei(@Nullable Object prdctm) {
      super(prdctm);
    }
  }

  /**
   * Classis est v\u0101s classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html">Comparable</a> aliae
   */
  static final class TentamiculumNumeralis <Illud extends Comparable <Illud>> extends Tentamiculum<Illud> {
    /**
     * {@inheritDoc}
     * @param expct  valor {@link #expectatio} indicat.
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumNumeralis(@NotNull Illud expct, @Nullable Illud prdctm) {
      super(expct, prdctm);
    }

    private int comparo( ) {
      return new NullComparator <>((Comparator <Illud>) Comparable::compareTo, false).compare(expectatio, productum);
    }

    private boolean aequanturne( ) {
      return comparo() == 0;
    }

    private boolean differuntne( ) {
      return comparo() != 0;
    }

    private boolean subestne( ) {
      return comparo() > 0;
    }

    private boolean superatne( ) {
      return comparo() < 0;
    }

    private boolean autSubestneAutAequanturne( ) {
      return comparo() >= 0;
    }

    private boolean autSuperatneAutAequanturne( ) {
      return comparo() <= 0;
    }

    /**
     * Modus hic tentat utrum val\u014Dr\u0113s {@link #productum} {@link #expectatio}que aequentur necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumNumeralis <Illud> aequentur(@NotNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum val\u014Dr\u0113s {@link #productum} {@link #expectatio}que differant necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumNumeralis <Illud> differant(@NotNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #productum} subsit quam val\u014Drem {@link #expectatio} necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumNumeralis <Illud> subsit(@NotNull final String error) {
      Assertions.assertTrue(subestne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #productum} superet quam val\u014Drem {@link #expectatio} necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumNumeralis <Illud> superet(@NotNull final String error) {
      Assertions.assertTrue(superatne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum aut valor {@link #productum} subsit quam val\u016Brem {@link #expectatio} aut aequentur necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumNumeralis <Illud> autSubsitAutAequentur(@NotNull final String error) {
      Assertions.assertTrue(autSubestneAutAequanturne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum aut valor {@link #productum} superet quam val\u014Drem {@link #expectatio} aut aequentur necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumNumeralis <Illud> autSuperetAutAequentur(@NotNull final String error) {
      Assertions.assertTrue(autSuperatneAutAequanturne(), error);
      return this;
    }
  }

  /**
   * Classis est v\u0101s classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a>que aliae
   */
  static final class TentamiculumVersiculi extends Tentamiculum<String> {
    /**
     * {@inheritDoc}
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumVersiculi(@Nullable String prdctm) {
      super(prdctm);
    }

    /**
     * {@inheritDoc}
     * @param expct  valor {@link #expectatio} indicat.
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumVersiculi(@NotNull String expct, @Nullable String prdctm) {
      super(expct, prdctm);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean aequanturne( ) {
      return ObjectUtils.allNotNull(expectatio, productum) && expectatio.equals(productum);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean differuntne( ) {
      return ObjectUtils.allNotNull(expectatio, productum) && !expectatio.equals(productum);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean continetne( ) {
      return ObjectUtils.allNotNull(expectatio, productum) && productum.contains(expectatio);
    }

    private boolean vacatne( ) {
      return StringUtils.isEmpty(productum) || StringUtils.isWhitespace(productum);
    }

    private boolean aliamContinetne( ) {
      return StringUtils.isNotEmpty(productum) && !StringUtils.isWhitespace(productum);
    }

    /**
     * Modus hic tentat utrum val\u014Dr\u012Bs {@link #productum} et {@link #expectatio} aequentur necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumVersiculi aequentur(@NotNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum val\u014Dr\u012Bs {@link #productum} et {@link #expectatio} differant necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumVersiculi differant(@NotNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #productum} val\u014Drem {@link #expectatio} contineat necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumVersiculi contineat(@NotNull final String error) {
      Assertions.assertTrue(continetne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #productum} vacet necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumVersiculi vacet(@NotNull final String error) {
      Assertions.assertTrue(vacatne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #productum} aliam contineat necne. <br>
     * Err\u014Drem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum val\u014Dre {@code error} iacit s\u012B hoc abor\u012Btur
     * @param error Error scr\u012Bbendus s\u012B hoc abor\u012Btur
     * @return Valor hic
     */
    public TentamiculumVersiculi aliamContineat(@NotNull final String error) {
      Assertions.assertTrue(aliamContinetne(), error);
      return this;
    }
  }
}
