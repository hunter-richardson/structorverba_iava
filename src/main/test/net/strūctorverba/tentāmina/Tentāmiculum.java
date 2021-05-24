package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.Omnum;
import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * Classis {@link Tentāmiculum} tentāmen singulārem repraesentat exsequendum datō simplicī.
 * @param <Hoc> Classis datī tentandī
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "UnusedReturnValue", "unused" })
abstract class Tentāmiculum <Hoc> extends Omnum {
  /**
   * Valor hic repraesentat datum exspectandum
   */
  @Nullable protected final Hoc expectātiō;

  /**
   * Valor hic repraesentat datum tentandum
   */
  @Nullable protected final Hoc prōductum;

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param prdctm valor {@link #prōductum} indicat.
   */
  protected Tentāmiculum(@Nullable final Hoc prdctm) {
    prōductum = prdctm;
    expectātiō = null;
  }

  /**
   * Officium hoc cōnstrūctōrem reī classis huius perpetrat.
   * @param expct  valor {@link #expectātiō} indicat.
   * @param prdctm valor {@link #prōductum} indicat.
   */
  protected Tentāmiculum(@NotNull final Hoc expct, @Nullable final Hoc prdctm) {
    prōductum = prdctm;
    expectātiō = expct;
  }

  private boolean existitne( ) {
    return Objects.nonNull(prōductum);
  }

  /**
   * Modus hic tentat utrum {@link #prōductum} existat necne
   * @param error Error scrībendus sī hoc aborītur
   * @return Valor hic
   */
  public Tentāmiculum <Hoc> existat(@NotNull final String error) {
    Assertions.assertTrue(existitne(), error);
    return this;
  }

  /**
   * Classis est vās classī {@link Tentāmiculum} classīque <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html">Object</a>
   * aliae
   */
  static final class TentāmiculumReī extends Tentāmiculum <Object> {
    /**
     * {@inheritDoc}
     * @param prdctm valor {@link #prōductum} indicat.
     */
    public TentāmiculumReī(@Nullable Object prdctm) {
      super(prdctm);
    }
  }

  /**
   * Classis est vās classī {@link Tentāmiculum} classīque <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html">Comparable</a>
   * aliae
   */
  static final class TentāmiculumNumerālis <Illud extends Comparable <Illud>> extends Tentāmiculum <Illud> {
    /**
     * {@inheritDoc}
     * @param expct  valor {@link #expectātiō} indicat.
     * @param prdctm valor {@link #prōductum} indicat.
     */
    public TentāmiculumNumerālis(@NotNull Illud expct, @Nullable Illud prdctm) {
      super(expct, prdctm);
    }

    private int comparō( ) {
      return new NullComparator <>((Comparator <Illud>) Comparable::compareTo, false)
        .compare(expectātiō, prōductum);
    }

    private boolean aequanturne( ) {
      return comparō() == 0;
    }

    private boolean differuntne( ) {
      return comparō() != 0;
    }

    private boolean subestne( ) {
      return comparō() > 0;
    }

    private boolean superatne( ) {
      return comparō() < 0;
    }

    private boolean autSubestneAutAequanturne( ) {
      return comparō() >= 0;
    }

    private boolean autSuperatneAutAequanturne( ) {
      return comparō() <= 0;
    }

    /**
     * Modus hic tentat utrum valōrēs {@link #prōductum} et {@link #expectātiō} aequentur necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumNumerālis <Illud> aequentur(@NotNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valōrēs {@link #prōductum} et {@link #expectātiō} differant necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumNumerālis <Illud> differant(@NotNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #prōductum} subsit quam valōrem {@link #expectātiō} necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumNumerālis <Illud> subsit(@NotNull final String error) {
      Assertions.assertTrue(subestne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #prōductum} superet quam valōrem {@link #expectātiō} necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumNumerālis <Illud> superet(@NotNull final String error) {
      Assertions.assertTrue(superatne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum aut valor {@link #prōductum} subsit quam valōrem {@link #expectātiō} aut aequentur necne.
     * <br> Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumNumerālis <Illud> autSubsitAutAequentur(@NotNull final String error) {
      Assertions.assertTrue(autSubestneAutAequanturne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum aut valor {@link #prōductum} superet quam valōrem {@link #expectātiō} aut aequentur
     * necne.
     * <br> Errōrem <a href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumNumerālis <Illud> autSuperetAutAequentur(@NotNull final String error) {
      Assertions.assertTrue(autSuperatneAutAequanturne(), error);
      return this;
    }
  }

  /**
   * Classis est vās classī {@link Tentāmiculum} classīque <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html">String</a>
   * aliae
   */
  static final class TentāmiculumVersiculī extends Tentāmiculum <String> {
    /**
     * {@inheritDoc}
     * @param prdctm valor {@link #prōductum} indicat.
     */
    public TentāmiculumVersiculī(@Nullable String prdctm) {
      super(prdctm);
    }

    /**
     * {@inheritDoc}
     * @param expct  valor {@link #expectātiō} indicat.
     * @param prdctm valor {@link #prōductum} indicat.
     */
    public TentāmiculumVersiculī(@NotNull String expct, @Nullable String prdctm) {
      super(expct, prdctm);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean aequanturne( ) {
      return ObjectUtils.allNotNull(expectātiō, prōductum) && expectātiō.equals(prōductum);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean differuntne( ) {
      return ObjectUtils.allNotNull(expectātiō, prōductum) && !expectātiō.equals(prōductum);
    }

    @SuppressWarnings("ConstantConditions")
    private boolean continetne( ) {
      return ObjectUtils.allNotNull(expectātiō, prōductum) && prōductum.contains(expectātiō);
    }

    private boolean vacatne( ) {
      return StringUtils.isEmpty(prōductum) || StringUtils.isWhitespace(prōductum);
    }

    private boolean aliamContinetne( ) {
      return StringUtils.isNotEmpty(prōductum) && !StringUtils.isWhitespace(prōductum);
    }

    /**
     * Modus hic tentat utrum valōrēs {@link #prōductum} et {@link #expectātiō} aequentur necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumVersiculī aequentur(@NotNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valōrēs {@link #prōductum} et {@link #expectātiō} differant necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumVersiculī differant(@NotNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #prōductum} valōrem {@link #expectātiō} contineat necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumVersiculī contineat(@NotNull final String error) {
      Assertions.assertTrue(continetne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #prōductum} vacet necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumVersiculī vacet(@NotNull final String error) {
      Assertions.assertTrue(vacatne(), error);
      return this;
    }

    /**
     * Modus hic tentat utrum valor {@link #prōductum} aliam contineat necne. <br> Errōrem <a
     * href="http://junit.sourceforge.net/junit3.8.1/javadoc/junit/framework/AssertionFailedError.html">AssertionFailedError</a>
     * cum valōre {@code error} iacit sī hoc aborītur
     * @param error Error scrībendus sī hoc aborītur
     * @return Valor hic
     */
    public TentāmiculumVersiculī aliamContineat(@NotNull final String error) {
      Assertions.assertTrue(aliamContinetne(), error);
      return this;
    }
  }
}
