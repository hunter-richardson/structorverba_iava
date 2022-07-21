package com.structorverba.officia.verba;

import androidx.annotation.NonNull;
import androidx.annotation.*;
import com.structorverba.officia.miscella.*;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Classis {@link Verba} seriēs rērum classis {@link Verbum} cōnstat.
 */
@SuppressWarnings({"SpellCheckingInspection", "unused", "SimplifyStreamApiCallChains"})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class Verba extends Omne {
  /**
   * Hic valor seriem cōnstātam rērum classis {@link Verbum} continet.
   */
  public final @NonNull LinkedList <Verbum <?>> series = new LinkedList <>();

  /**
   * Hic modus valōrem {@code verbum} addit to {@link #series}.
   * @param verbum valōrem addendum
   * @return haec
   */
  @NonNull public Verba addo(@NonNull final Verbum <?> verbum) {
    if (StringUtils.isNotBlank(verbum.toString())) {
      series.add(verbum);
    }

    return this;
  }

  /**
   * Hic modus seriēs {@code ordo} addit to {@link #series}.
   * @param ordo seriēs valōrum addendōrum
   * @return haec
   */
  @NonNull public Verba addo(@Nullable final Verbum <?>... ordo) {
    if (ordo == null) {
      //noinspection ConstantConditions
      series.addAll(Arrays.stream(ordo)
                          .filter(Objects::nonNull)
                          .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                          .collect(Collectors.toList()));
    }
    return this;
  }

  /**
   * Hic modus seriēs {@code verba} addit to {@link #series}.
   * @param verba seriēs valōrum addendōrum
   * @return haec
   */
  @SuppressWarnings("UnusedReturnValue")
  @NonNull public Verba superaddo(@NonNull final Verba verba) {
    series.addAll(verba.series.stream()
                              .filter(Objects::nonNull)
                              .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                              .collect(Collectors.toList()));
    return this;
  }

  /**
   * Hic modus seriēs {@code ordo} addit to {@link #series}.
   * @param ordo seriēs seriērum addendārum
   * @return haec
   */
  @NonNull public Verba superaddo(@Nullable final Verba... ordo) {
    if (ordo != null) {
      Arrays.stream(ordo)
            .filter(Objects::nonNull)
            .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
            .forEach(this::superaddo);
    }

    return this;
  }

  /**
   * @return Repraesentātiōnem scrīpta huius reī. <br>
   * Rēs omnēs contentās cōnsit cumque spatiīs distinet.
   */
  @NonNull @Override
  public String toString() {
    final StringBuilder structor = new StringBuilder();
    series.forEach(verbum -> structor.append(verbum).append(' '));
    return Utilitas.primaCapitanea.apply(structor.toString());
  }
}
