package net.strūctorverba.nūntiī;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import net.strūctorverba.ēnumerātiōnēs.Mēnsis;
import org.jetbrains.annotations.NotNull;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.function.BiFunction;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
final class FōrmaTemporis {
  private final boolean pūnctillaPraecīdamne;

  private static final @NotNull BiFunction <@NotNull ZonedDateTime, @NotNull Boolean, @NotNull String> fōrmātiō =
    (tempus, praecīsiō) -> {
      String zona = tempus.getZone().getId();
      if(tempus.getZone().getId().length() > 3) {
        if(tempus.getZone().getRules().isDaylightSavings(tempus.toInstant())) {
          zona = zona.substring(zona.length() - 3);
        } else {
          zona = zona.substring(0, 3);
        }
      }

      if(praecīsiō) {
        return String.format("[%s %s %s, %s:%s:%s.%s %s]",
                             RomanInteger.parse(String.valueOf(tempus.getDayOfMonth()), IntegerType.ARABIC),
                             Mēnsis.indīcam(tempus.getMonth()),
                             RomanInteger.parse(String.valueOf(tempus.getYear()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getHour()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getMinute()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getSecond()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.get(ChronoField.MILLI_OF_SECOND)), IntegerType.ARABIC), zona);
      } else {
        return String.format("[%s %s %s, %s:%s:%s %s]",
                             RomanInteger.parse(String.valueOf(tempus.getDayOfMonth()), IntegerType.ARABIC),
                             Mēnsis.indīcam(tempus.getMonth()),
                             RomanInteger.parse(String.valueOf(tempus.getYear()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getHour()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getMinute()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getSecond()), IntegerType.ARABIC), zona);
      }
    };

  private final @NotNull ZonedDateTime tempus;

  private FōrmaTemporis() {
    tempus = ZonedDateTime.now();
    pūnctillaPraecīdamne = false;
  }

  private FōrmaTemporis(final long īnstāns) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(īnstāns), ZoneId.systemDefault());
    pūnctillaPraecīdamne = false;
  }

  private FōrmaTemporis(@NotNull final Instant īnstāns) {
    tempus = ZonedDateTime.ofInstant(īnstāns, ZoneId.systemDefault());
    pūnctillaPraecīdamne = false;
  }

  private FōrmaTemporis(final boolean pūnctillaPraecīdamne) {
    tempus = ZonedDateTime.now();
    this.pūnctillaPraecīdamne = pūnctillaPraecīdamne;
  }

  private FōrmaTemporis(final long īnstāns, final boolean pūnctillaPraecīdamne) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(īnstāns), ZoneId.systemDefault());
    this.pūnctillaPraecīdamne = pūnctillaPraecīdamne;
  }

  private FōrmaTemporis(@NotNull final Instant īnstāns, final boolean pūnctillaPraecīdamne) {
    tempus = ZonedDateTime.ofInstant(īnstāns, ZoneId.systemDefault());
    this.pūnctillaPraecīdamne = pūnctillaPraecīdamne;
  }

  public @NotNull String fōrmō( ) {
    return fōrmātiō.apply(tempus, pūnctillaPraecīdamne);
  }

  public static @NotNull String fōrmem(final long tempus) {
    return new FōrmaTemporis(tempus).fōrmō();
  }

  public static @NotNull String fōrmem(@NotNull final Instant tempus) {
    return new FōrmaTemporis(tempus).fōrmō();
  }

  public static @NotNull String fōrmem() {
    return new FōrmaTemporis().fōrmō();
  }

  public static @NotNull String fōrmem(final long tempus, final boolean pūnctillaPraecīdamne) {
    return new FōrmaTemporis(tempus, pūnctillaPraecīdamne).fōrmō();
  }

  public static @NotNull String fōrmem(@NotNull final Instant tempus, final boolean pūnctillaPraecīdamne) {
    return new FōrmaTemporis(tempus, pūnctillaPraecīdamne).fōrmō();
  }

  public static @NotNull String fōrmem(final boolean pūnctillaPraecīdamne) {
    return new FōrmaTemporis(pūnctillaPraecīdamne).fōrmō();
  }
}
