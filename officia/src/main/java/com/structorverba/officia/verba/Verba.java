package officia.src.main.java.com.structorverba.officia.verba;

import officia.src.main.java.com.structorverba.officia.miscella.*;

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
 * Classis {@link Verba} seri\u0113s r\u0113rum classis {@link Verbum} c\u014Dnstat.
 */
@SuppressWarnings( "SpellCheckingInspection", "unused" })
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class Verba extends Omne {
  /**
   * Valor hic seriem c\u014Dnst\u0101tam r\u0113rum classis {@link Verbum} continet.
   */
  public final @NotNull LinkedList <Verbum <?>> series = new LinkedList <>();

  /**
   * Modus hic val\u014Drem {@code verbum} addit to {@link #series}.
   * @param verbum val\u014Drem addendum
   * @return Rem haec
   */
  @NotNull public Verba addo(@NotNull final Verbum <?> verbum) {
    if (StringUtils.isNotBlank(verbum.toString())) {
      series.add(verbum);
    }

    return this;
  }

  /**
   * Modus hic seri\u0113s {@code ordo} addit to {@link #series}.
   * @param ordo seri\u0113s val\u014Drum addend\u014Drum
   * @return Rem haec
   */
  @NotNull public Verba addo(@Nullable final Verbum <@Nullable ?>... ordo) {
    if (Objects.nonNull(ordo)) {
      series.addAll(Arrays.stream(ordo)
                          .filter(Objects::nonNull)
                          .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                          .collect(Collectors.toList()));
    }
    return this;
  }

  /**
   * Modus hic seri\u0113s {@code verba} addit to {@link #series}.
   * @param verba seri\u0113s val\u014Drum addend\u014Drum
   * @return Rem haec
   */
  @SuppressWarnings("UnusedReturnValue")
  @NotNull public Verba superaddo(@NotNull final Verba verba) {
    series.addAll(verba.series.stream()
                              .filter(Objects::nonNull)
                              .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
                              .collect(Collectors.toList()));
    return this;
  }

  /**
   * Modus hic seri\u0113s {@code ordo} addit to {@link #series}.
   * @param ordo seri\u0113s seri\u0113rum addend\u0101rum
   * @return Rem haec
   */
  @NotNull public Verba superaddo(@Nullable final Verba... ordo) {
    if (ordo != null) {
      Arrays.stream(ordo)
            .filter(Objects::nonNull)
            .filter(verbum -> StringUtils.isNotBlank(verbum.toString()))
            .forEach(this::superaddo);
    }

    return this;
  }

  /**
   * @return Repraesent\u0101ti\u014Dnem scr\u012Bpta re\u012B huius. <br>
   * R\u0113s omn\u0113s content\u0101s c\u014Dnsit cumque spati\u012Bs distinet.
   */
  @NotNull @Override
  public String toString() {
    final StringBuilder structor = new StringBuilder();
    series.forEach(verbum -> structor.append(verbum).append(' '));
    return Utilitas.primamCapitaneamScribo(structor.toString());
  }
}
