package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.Omnum;
import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;
import org.junit.jupiter.api.Assertions;

import java.util.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "UnusedReturnValue", "unused" })
public class Tentāmiculum <Hoc> extends Omnum {
  @Nullable protected final Hoc expectātiō;

  @Nullable protected final Hoc prōductum;

  protected Tentāmiculum(@Nullable final Hoc prdctm) {
    prōductum = prdctm;
    expectātiō = null;
  }

  protected Tentāmiculum(@NotNull final Hoc expct, @Nullable final Hoc prdctm) {
    prōductum = prdctm;
    expectātiō = expct;
  }

  protected boolean existetne( ) {
    return Objects.nonNull(prōductum);
  }

  public Tentāmiculum <Hoc> existat(@NotNull final String error) {
    Assertions.assertTrue(existetne(), error);
    return this;
  }

  public static final class TentāmiculumReī extends Tentāmiculum <Object> {
    public TentāmiculumReī(@Nullable Object prdctm) {
      super(prdctm);
    }
  }

  public static final class TentāmiculumNumerālis <Illud extends Comparable <Illud>> extends Tentāmiculum <Illud> {
    public TentāmiculumNumerālis(@NotNull Illud expct, @Nullable Illud prdctm) {
      super(expct, prdctm);
    }

    private int comparō( ) {
      return new NullComparator<>((Comparator <Illud>) Comparable::compareTo, false)
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

    public TentāmiculumNumerālis <Illud> aequentur(@NotNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    public TentāmiculumNumerālis <Illud> differant(@NotNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    public TentāmiculumNumerālis <Illud> subsit(@NotNull final String error) {
      Assertions.assertTrue(subestne(), error);
      return this;
    }

    public TentāmiculumNumerālis <Illud> superet(@NotNull final String error) {
      Assertions.assertTrue(superatne(), error);
      return this;
    }

    public TentāmiculumNumerālis <Illud> autSubsitAutAequentur(@NotNull final String error) {
      Assertions.assertTrue(autSubestneAutAequanturne(), error);
      return this;
    }

    public TentāmiculumNumerālis <Illud> autSuperetAutAequentur(@NotNull final String error) {
      Assertions.assertTrue(autSuperatneAutAequanturne(), error);
      return this;
    }
  }

  public static final class TentāmiculumVersiculī extends Tentāmiculum <String> {
    public TentāmiculumVersiculī(@Nullable String prdctm) {
      super(prdctm);
    }

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

    public TentāmiculumVersiculī aequentur(@NotNull final String error) {
      Assertions.assertTrue(aequanturne(), error);
      return this;
    }

    public TentāmiculumVersiculī differant(@NotNull final String error) {
      Assertions.assertTrue(differuntne(), error);
      return this;
    }

    public TentāmiculumVersiculī contineat(@NotNull final String error) {
      Assertions.assertTrue(continetne(), error);
      return this;
    }

    public TentāmiculumVersiculī vacet(@NotNull final String error) {
      Assertions.assertTrue(vacatne(), error);
      return this;
    }

    public TentāmiculumVersiculī aliamContineat(@NotNull final String error) {
      Assertions.assertTrue(aliamContinetne(), error);
      return this;
    }
  }
}
