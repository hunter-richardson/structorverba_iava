package com.structorverba.officia.tentamina;

import androidx.annotation.*;
import com.structorverba.officia.miscella.Omne;

import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.lang3.*;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

/**
 * Classis {@link Tentamiculum} tentāmen singulārem repraesentat exsequendum datā simplicī.
 * @param <Hoc> Classis datī tentandī
 */
@SuppressWarnings({ "SpellCheckingInspection", "UnusedReturnValue", "unused" })
abstract class Tentamiculum<Hoc> extends Omne {
  /**
   * Hic valor datum exspectandum repraesentat
   */
  @Nullable protected final Hoc expectatio;

  /**
   * Hic valor datum tentandum repraesentat
   */
  @Nullable protected final Hoc productum;

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param prdctm valor {@link #productum} indicat.
   */
  protected Tentamiculum(@Nullable final Hoc prdctm) {
    productum = prdctm;
    expectatio = null;
  }

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param expct  valor {@link #expectatio} indicat.
   * @param prdctm valor {@link #productum} indicat.
   */
  protected Tentamiculum(@NonNull final Hoc expct, @Nullable final Hoc prdctm) {
    productum = prdctm;
    expectatio = expct;
  }

  private boolean existitne() {
    return productum != null;
  }

  /**
   * Hic modus tentat utrum {@link #productum} existat necne
   * @param error Error scrībendus sī hoc aborītur
   * @return Hic valor
   */
  public Tentamiculum<Hoc> existat(@NonNull final String error) {
    Assertions.assertTrue(existitne(), error);
    return this;
  }

  /**
   * Classis est vās classibus {@link Tentamiculum}
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
   * Classis est vās classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html">Comparable</a> aliae
   */
  static final class TentamiculumNumeralis <Illud extends Comparable <Illud>> extends Tentamiculum<Illud> {
    /**
     * {@inheritDoc}
     * @param expct  valor {@link #expectatio} indicat.
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumNumeralis(@NonNull Illud expct, @Nullable Illud prdctm) {
      super(expct, prdctm);
    }

    private int comparo() {
      return new NullComparator <>((Comparator<Illud>) Comparable::compareTo, false).compare(expectatio, productum);
    }

    private boolean aequanturne() {
      return comparo() == 0;
    }

    private boolean differuntne() {
      return comparo() != 0;
    }

    private boolean subestne() {
      return comparo() > 0;
    }

    private boolean superatne() {
      return comparo() < 0;
    }

    private boolean autSubestneAutAequanturne() {
      return comparo() >= 0;
    }

    private boolean autSuperatneAutAequanturne() {
      return comparo() <= 0;
    }

    /**
     * Hic modus tentat utrum valōrēs {@link #productum} {@link #expectatio}que aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumNumeralis <Illud> aequentur(@NonNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valōrēs {@link #productum} {@link #expectatio}que differant necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumNumeralis <Illud> differant(@NonNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} subsit quam valōrem {@link #expectatio} necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumNumeralis <Illud> subsit(@NonNull final String error) {
      Assertions.assertTrue(subestne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} superet quam valōrem {@link #expectatio} necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumNumeralis <Illud> superet(@NonNull final String error) {
      Assertions.assertTrue(superatne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum aut valor {@link #productum} subsit quam valūrem {@link #expectatio} aut aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumNumeralis <Illud> autSubsitAutAequentur(@NonNull final String error) {
      Assertions.assertTrue(autSubestneAutAequanturne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum aut valor {@link #productum} superet quam valōrem {@link #expectatio} aut aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumNumeralis <Illud> autSuperetAutAequentur(@NonNull final String error) {
      Assertions.assertTrue(autSuperatneAutAequanturne(), error);
      return this;
    }
  }

  /**
   * Classis est vās classibus {@link Tentamiculum}
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
    public TentamiculumVersiculi(@NonNull String expct, @Nullable String prdctm) {
      super(expct, prdctm);
    }

    /**
     * {@inheritDoc}
     *
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumVersiculi(@NonNull Object prdctm) {
      super(prdctm.toString());
    }

    /**
     * {@inheritDoc}
     *
     * @param expct  valor {@link #expectatio} indicat.
     * @param prdctm valor {@link #productum} indicat.
     */
    public TentamiculumVersiculi(@NonNull String expct, @NonNull Object prdctm) {
      super(expct, prdctm.toString());
    }

    private boolean aequanturne() {
      //noinspection ConstantConditions
      return ObjectUtils.allNotNull(expectatio, productum) && expectatio.equals(productum);
    }

    private boolean differuntne() {
      //noinspection ConstantConditions
      return ObjectUtils.allNotNull(expectatio, productum) && !expectatio.equals(productum);
    }

    private boolean continetne() {
      //noinspection ConstantConditions
      return ObjectUtils.allNotNull(expectatio, productum) && productum.contains(expectatio);
    }

    private boolean vacatne() {
      return StringUtils.isEmpty(productum) || StringUtils.isWhitespace(productum);
    }

    private boolean aliamContinetne() {
      return StringUtils.isNotEmpty(productum) && !StringUtils.isWhitespace(productum);
    }

    /**
     * Hic modus tentat utrum valōrīs {@link #productum} et {@link #expectatio} aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumVersiculi aequentur(@NonNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valōrīs {@link #productum} et {@link #expectatio} differant necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumVersiculi differant(@NonNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} valōrem {@link #expectatio} contineat necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumVersiculi contineat(@NonNull final String error) {
      Assertions.assertTrue(continetne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} vacet necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumVersiculi vacet(@NonNull final String error) {
      Assertions.assertTrue(vacatne(), error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} aliam contineat necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public TentamiculumVersiculi aliamContineat(@NonNull final String error) {
      Assertions.assertTrue(aliamContinetne(), error);
      return this;
    }
  }
}
