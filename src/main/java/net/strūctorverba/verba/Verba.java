package net.strūctorverba.verba;

import net.strūctorverba.mīscella.Omnum;
import net.strūctorverba.mīscella.Ūtilitās;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Classis {@link Verba} seriēs rērum classis {@link Verbum} cōnstat.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class Verba extends Omnum {
  /**
   * Valor hic seriem cōnstātam rērum classis {@link Verbum} continet.
   */
  public final @NotNull LinkedList <Verbum <?>> seriēs = new LinkedList <>();

  /**
   * Modus hic valōrem {@code verbum} addit to {@link #seriēs}.
   * @param verbum valōrem addendum
   * @return Rem haec
   */
  @NotNull public Verba addō(@NotNull final Verbum <?> verbum) {
    if (StringUtils.isNotBlank(verbum.toString())) {
      seriēs.add(verbum);
    }

    return this;
  }

  /**
   * Modus hic seriēs {@code ōrdō} addit to {@link #seriēs}.
   * @param ōrdō seriēs valōrum addendōrum
   * @return Rem haec
   */
  @NotNull public Verba addō(@Nullable final Verbum <@Nullable ?>... ōrdō) {
    if (Objects.nonNull(ōrdō)) {
      seriēs.addAll(Arrays.stream(ōrdō)
                          .filter(Objects::nonNull)
                          .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                          .collect(Collectors.toList()));
    }
    return this;
  }

  /**
   * Modus hic seriēs {@code verba} addit to {@link #seriēs}.
   * @param verba seriēs valōrum addendōrum
   * @return Rem haec
   */
  @SuppressWarnings("UnusedReturnValue")
  @NotNull public Verba superaddō(@NotNull final Verba verba) {
    seriēs.addAll(verba.seriēs.stream()
                              .filter(Objects::nonNull)
                              .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                              .collect(Collectors.toList()));
    return this;
  }

  /**
   * Modus hic seriēs {@code ōrdō} addit to {@link #seriēs}.
   * @param ōrdō seriēs seriērum addendārum
   * @return Rem haec
   */
  @NotNull public Verba superaddō(@Nullable final Verba... ōrdō) {
    if (ōrdō != null) {
      Arrays.stream(ōrdō)
            .filter(Objects::nonNull)
            .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
            .forEach(this::superaddō);
    }

    return this;
  }

  /**
   * @return Repraesentātiōnem scrīpta reī huius. <br> Rēs omnēs contentās cōnsit cumque spatiīs distinet.
   */
  @NotNull @Override
  public String toString( ) {
    final StringBuilder strūctor = new StringBuilder();
    seriēs.forEach(verbum -> strūctor.append(verbum).append(' '));
    return Ūtilitās.prīmamCapitāneamScrībō(strūctor.toString());
  }
}
