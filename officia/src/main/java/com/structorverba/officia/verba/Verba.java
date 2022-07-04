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
   * Valor hic seriem cōnstātam rērum classis {@link Verbum} continet.
   */
  public final @NonNull LinkedList <Verbum <?>> series = new LinkedList <>();

  /**
   * Modus hic valōrem {@code verbum} addit to {@link #series}.
   * @param verbum valōrem addendum
   * @return Rem haec
   */
  @NonNull public Verba addo(@NonNull final Verbum <?> verbum) {
    if (StringUtils.isNotBlank(verbum.toString())) {
      series.add(verbum);
    }

    return this;
  }

  /**
   * Modus hic seriēs {@code ordo} addit to {@link #series}.
   * @param ordo seriēs valōrum addendōrum
   * @return Rem haec
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
   * Modus hic seriēs {@code verba} addit to {@link #series}.
   * @param verba seriēs valōrum addendōrum
   * @return Rem haec
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
   * Modus hic seriēs {@code ordo} addit to {@link #series}.
   * @param ordo seriēs seriērum addendārum
   * @return Rem haec
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
   * @return Repraesentātiōnem scrīpta reī huius. <br>
   * Rēs omnēs contentās cōnsit cumque spatiīs distinet.
   */
  @NonNull @Override
  public String toString() {
    final StringBuilder structor = new StringBuilder();
    series.forEach(verbum -> structor.append(verbum).append(' '));
    return Utilitas.primamCapitaneamScribo(structor.toString());
  }
}
