package net.strūctorverba.verba.disposita;

import lombok.*;
import net.strūctorverba.mīscella.Ūtilitās;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.surefire.util.internal.ObjectUtils;
import org.jetbrains.annotations.*;

import java.util.*;

/**
 * Classis {@link Verba} rēs classis {@link Verbum} cōnsit. <br>
 * Rēs classis huius et seriem rērum classis {@link Verbum} et rēs classis {@link Coniugiāle} et aliam classis {@link Verba} constat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public final class Verba {
  private final @NotNull LinkedList <Verbum <?>> seriēs       = new LinkedList <>();
  private      @Nullable Coniugiāle              coniūnctīvum = null;
  private      @Nullable Verba                   continuāta   = null;

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Verba(@NotNull final Collection <Verbum <@Nullable ?>> seriēs,
                @NotNull final Coniugiāle coniūnctīvum, @NotNull final Verba continuāta) {
    seriēs.removeIf(ObjectUtils::isNull);
    seriēs.removeIf(verbum -> StringUtils.isBlank(verbum.toString()));
    this.seriēs.addAll(seriēs);
    this.coniūnctīvum = coniūnctīvum;
    this.continuāta = continuāta;
  }

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Verba(@NotNull final Collection <Verbum <@Nullable ?>> seriēs, @NotNull final Coniugiāle coniūnctīvum) {
    seriēs.removeIf(ObjectUtils::isNull);
    seriēs.removeIf(verbum -> StringUtils.isBlank(verbum.toString()));
    this.seriēs.addAll(seriēs);
    this.coniūnctīvum = coniūnctīvum;
  }

  @Builder(access = AccessLevel.PUBLIC, builderClassName = "Conditōr", builderMethodName = "conditōr", buildMethodName = "condam")
  private Verba(@NotNull final Collection <Verbum <@Nullable ?>> seriēs) {
    seriēs.removeIf(ObjectUtils::isNull);
    seriēs.removeIf(verbum -> StringUtils.isBlank(verbum.toString()));
    this.seriēs.addAll(seriēs);
  }

  /**
   * Modus hic ūsūfructuāriōs licet rem classis {@link Coniugiāle} huius allegere.
   * @param coniūnctīvum coniūnctīvum allegendum
   */
  public void coniūnctīvumAllegō(@NotNull final Coniugiāle coniūnctīvum) {
    this.coniūnctīvum = coniūnctīvum;
  }

  /**
   * Modus hic ūsūfructuāriōs licet rēs et classis {@link Coniugiāle} et classis {@link Verba} huius allegere.
   * @param coniūnctīvum rēs et classis {@link Coniugiāle} allegendum
   * @param continuāta rēs et classis {@link Verba} allegendum
   */
  public void coniūnctīvumAllegōContinuōque(@NotNull final Coniugiāle coniūnctīvum, @NotNull final Verba continuāta) {
    this.coniūnctīvum = coniūnctīvum;
    this.continuāta = continuāta;
  }

  /**
   * @return Repraesentātiōnem scrīpta reī huius. <br>
   * Rēs omnēs contentās cōnsit et cum spatiīs distinet.
   */
  public @NotNull @Override String toString( ) {
    final StringBuilder strūctor = new StringBuilder();
    seriēs.forEach(verbum -> strūctor.append(verbum).append(' '));
    if (ObjectUtils.nonNull(coniūnctīvum)
     && StringUtils.isNotBlank(coniūnctīvum.toString())) {
      strūctor.append(coniūnctīvum).append(' ');

      if (ObjectUtils.nonNull(continuāta)
       && StringUtils.isNotBlank(continuāta.toString())) {
        strūctor.append(continuāta);
      }
    }

    return Ūtilitās.prīmamCapitāneamScrībō(strūctor.toString());
  }
}
