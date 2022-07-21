package com.structorverba.officia.tentamina;

import androidx.annotation.*;
import com.structorverba.officia.miscella.Omne;
import lombok.Getter;
import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.lang3.*;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.function.*;

/**
 * Classis {@link Tentamiculum} tentāmen singulārem repraesentat exsequendum datā simplicī.
 * @param <Hoc> Classis datī tentandī
 */
@SuppressWarnings({ "SpellCheckingInspection", "UnusedReturnValue", "unused" })
abstract class Tentamiculum<Hoc> extends Omne {
  @NonNull private final BooleanSupplier ens;

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
    expectatio = null;
    productum = prdctm;

    ens = () -> Objects.nonNull(productum);
  }

  /**
   * Hoc officium cōnstrūctōrem reī huius classis perpetrat.
   * @param expct  valor {@link #expectatio} indicat.
   * @param prdctm valor {@link #productum} indicat.
   */
  protected Tentamiculum(@NonNull final Hoc expct, @Nullable final Hoc prdctm) {
    productum = prdctm;
    expectatio = expct;

    ens = () -> Objects.nonNull(productum);
  }

  /**
   * Hic modus tentat utrum {@link #productum} existat necne
   * @param error Error scrībendus sī hoc aborītur
   * @return Hic valor
   */
  public Tentamiculum<Hoc> existat(@NonNull final String error) {
    Assertions.assertTrue(ens, error);
    return this;
  }

  /**
   * Classis est vās classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html">Object</a>que aliae
   */
  static final class Rei extends Tentamiculum<Object> {
    /**
     * {@inheritDoc}
     * @param prdctm valor {@link #productum} indicat.
     */
    public Rei(@Nullable Object prdctm) {
      super(prdctm);
    }
  }

  /**
   * Classis est vās classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html">Comparable</a> aliae
   */
  static final class Comparabilium<Illud extends Comparable <Illud>> extends Tentamiculum<Illud> {
    @NonNull @Getter(lazy = true)
    private final Comparator<Illud> comparatio = new NullComparator<>(Comparable::compareTo, false);
    @NonNull private final BooleanSupplier aequatio;
    @NonNull private final BooleanSupplier differentia;
    @NonNull private final BooleanSupplier parvitas;
    @NonNull private final BooleanSupplier magnitas;
    @NonNull private final BooleanSupplier parvitasNulla;
    @NonNull private final BooleanSupplier magnitasNulla;

    /**
     * {@inheritDoc}
     * @param expectatio  valor {@link #expectatio} indicat.
     * @param productum valor {@link #productum} indicat.
     */
    public Comparabilium(@NonNull Illud expectatio, @Nullable Illud productum) {
      super(expectatio, productum);

      aequatio      = () -> comparatio.compare(this.expectatio, this.productum) == 0;
      differentia   = () -> comparatio.compare(this.expectatio, this.productum) != 0;
      parvitas      = () -> comparatio.compare(this.expectatio, this.productum) > 0;
      magnitas      = () -> comparatio.compare(this.expectatio, this.productum) < 0;
      parvitasNulla = () -> comparatio.compare(this.expectatio, this.productum) <= 0;
      magnitasNulla = () -> comparatio.compare(this.expectatio, this.productum) >= 0;
    }

    /**
     * Hic modus tentat utrum valōrēs {@link #productum} {@link #expectatio}que aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Comparabilium<Illud> aequentur(@NonNull final String error) {
      Assertions.assertTrue(aequatio, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valōrēs {@link #productum} {@link #expectatio}que differant necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Comparabilium<Illud> differant(@NonNull final String error) {
      Assertions.assertTrue(differentia, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} subsit quam valōrem {@link #expectatio} necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Comparabilium<Illud> subsit(@NonNull final String error) {
      Assertions.assertTrue(parvitas, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} superet quam valōrem {@link #expectatio} necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Comparabilium<Illud> superet(@NonNull final String error) {
      Assertions.assertTrue(magnitas, error);
      return this;
    }

    /**
     * Hic modus tentat utrum aut valor {@link #productum} subsit quam valūrem {@link #expectatio} aut aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Comparabilium<Illud> autSubsitAutAequentur(@NonNull final String error) {
      Assertions.assertTrue(magnitasNulla, error);
      return this;
    }

    /**
     * Hic modus tentat utrum aut valor {@link #productum} superet quam valōrem {@link #expectatio} aut aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Comparabilium<Illud> autSuperetAutAequentur(@NonNull final String error) {
      Assertions.assertTrue(parvitasNulla, error);
      return this;
    }
  }

  /**
   * Classis est vās classibus {@link Tentamiculum}
   * <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a>que aliae
   */
  static final class Versiculi extends Tentamiculum<String> {
    @NonNull @Getter(lazy = true)
    private final Comparator<String> comparatio = new NullComparator<>(String::compareTo, false);
    @Nullable private BooleanSupplier aequatio    = null;
    @Nullable private BooleanSupplier differentia = null;
    @NonNull private final BooleanSupplier vacatio;
    @NonNull private final BooleanSupplier continentia;

    /**
     * {@inheritDoc}
     * @param productum valor {@link #productum} indicat.
     */
    public Versiculi(@Nullable String productum) {
      super(productum);
      vacatio     = () -> Objects.nonNull(this.productum) &&
                           StringUtils.isWhitespace(this.productum);
      continentia = () -> Objects.nonNull(this.productum) &&
                          !StringUtils.isWhitespace(this.productum);
    }

    /**
     * {@inheritDoc}
     * @param expectatio  valor {@link #expectatio} indicat.
     * @param productum valor {@link #productum} indicat.
     */
    @SuppressWarnings("ConstantConditions")
    public Versiculi(@NonNull String expectatio, @NonNull String productum) {
      super(expectatio, productum);

      aequatio    = () -> comparatio.compare(this.expectatio, this.productum) == 0;
      differentia = () -> comparatio.compare(this.expectatio, this.productum) != 0;

      vacatio     = () -> Objects.nonNull(this.productum) &&
                          StringUtils.isWhitespace(this.productum);
      continentia = () -> ObjectUtils.allNotNull(this.expectatio, this.productum) &&
                          this.productum.contains(this.expectatio);
    }

    /**
     * {@inheritDoc}
     *
     * @param productum valor {@link #productum} indicat.
     */
    public Versiculi(@NonNull Object productum) {
      super(productum.toString());
      vacatio     = () -> Objects.nonNull(this.productum) &&
                           StringUtils.isWhitespace(this.productum);
      continentia = () -> Objects.nonNull(this.productum) &&
                          !StringUtils.isWhitespace(this.productum);
    }

    /**
     * {@inheritDoc}
     *
     * @param exepctatio  valor {@link #expectatio} indicat.
     * @param productum valor {@link #productum} indicat.
     */
    @SuppressWarnings("ConstantConditions")
    public Versiculi(@NonNull String exepctatio, @NonNull Object productum) {
      super(exepctatio, productum.toString());

      aequatio    = () -> comparatio.compare(this.expectatio, this.productum) == 0;
      differentia = () -> comparatio.compare(this.expectatio, this.productum) != 0;

      vacatio     = () -> StringUtils.isWhitespace(this.productum);
      continentia = () -> ObjectUtils.allNotNull(this.expectatio, this.productum) &&
                          this.productum.contains(this.expectatio);
    }

    /**
     * Hic modus tentat utrum valōrīs {@link #productum} et {@link #expectatio} aequentur necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Versiculi aequentur(@NonNull final String error) {
      Assertions.assertNotNull(aequatio);
      Assertions.assertTrue(aequatio, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valōrīs {@link #productum} et {@link #expectatio} differant necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Versiculi differant(@NonNull final String error) {
      Assertions.assertNotNull(differentia);
      Assertions.assertTrue(differentia, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} valōrem {@link #expectatio} contineat necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Versiculi contineat(@NonNull final String error) {
      Assertions.assertTrue(continentia, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} vacet necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Versiculi vacet(@NonNull final String error) {
      Assertions.assertTrue(vacatio, error);
      return this;
    }

    /**
     * Hic modus tentat utrum valor {@link #productum} aliam contineat necne. <br>
     * Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Hic valor
     */
    public Versiculi aliamContineat(@NonNull final String error) {
      Assertions.assertTrue(continentia, error);
      return this;
    }
  }
}
