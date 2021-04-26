package net.strūctorverba.nūntiī;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;
import net.strūctorverba.ēnumerātiōnēs.Mēnsis;
import org.jetbrains.annotations.NotNull;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.function.BiFunction;

/**
 * Classis {@link FōrmaTemporis} temporem fōrmat scrībī.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
final class FōrmaTemporis {
  @NotNull private final ZonedDateTime tempus;
           private final boolean       pūnctillaPraecidemne;

  @NotNull private static final BiFunction <@NotNull ZonedDateTime, @NotNull Boolean, @NotNull String> fōrmātiō =
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

  private FōrmaTemporis() {
    tempus = ZonedDateTime.now();
    pūnctillaPraecidemne = false;
  }

  private FōrmaTemporis(final long īnstāns) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(īnstāns), ZoneId.systemDefault());
    pūnctillaPraecidemne = false;
  }

  private FōrmaTemporis(@NotNull final Instant īnstāns) {
    tempus = ZonedDateTime.ofInstant(īnstāns, ZoneId.systemDefault());
    pūnctillaPraecidemne = false;
  }

  private FōrmaTemporis(final boolean pūnctillaPraecidemne) {
    tempus = ZonedDateTime.now();
    this.pūnctillaPraecidemne = pūnctillaPraecidemne;
  }

  private FōrmaTemporis(final long īnstāns, final boolean pūnctillaPraecidemne) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(īnstāns), ZoneId.systemDefault());
    this.pūnctillaPraecidemne = pūnctillaPraecidemne;
  }

  private FōrmaTemporis(@NotNull final Instant īnstāns, final boolean pūnctillaPraecidemne) {
    tempus = ZonedDateTime.ofInstant(īnstāns, ZoneId.systemDefault());
    this.pūnctillaPraecidemne = pūnctillaPraecidemne;
  }

  /**
   * @return scrīptiōnem temporis quem rēs haec continet.
   */
  @NotNull public String fōrmō( ) {
    return fōrmātiō.apply(tempus, pūnctillaPraecidemne);
  }

  /**
   * @param tempus tempus fōrmandus
   * @return scrīptiōnem temporis prōvīsus
   */
  @NotNull public static String fōrmem(final long tempus) {
    return new FōrmaTemporis(tempus).fōrmō();
  }

  /**
   * @param tempus tempus fōrmandus
   * @return scrīptiōnem temporis prōvīsus
   */
  @NotNull public static String fōrmem(@NotNull final Instant tempus) {
    return new FōrmaTemporis(tempus).fōrmō();
  }

  /**
   * @return scrīptiōnem temporis praesentis
   */
  @NotNull public static String fōrmem() {
    return new FōrmaTemporis().fōrmō();
  }

  /**
   * @param tempus tempus fōrmandus
   * @param pūnctillaPraecidemne valōrem {@code true} sī rēs haec valōrem {@code tempus} pūnctilla praecidemne; valōrem {@code false} aliter
   * @return scrīptiōnem temporis prōvīsus
   */
  @NotNull public static String fōrmem(final long tempus, final boolean pūnctillaPraecidemne) {
    return new FōrmaTemporis(tempus, pūnctillaPraecidemne).fōrmō();
  }

  /**
   * @param tempus tempus fōrmandus
   * @param pūnctillaPraecidemne valōrem {@code true} sī rēs haec valōrem {@code tempus} pūnctilla praecidemne; valōrem {@code false} aliter
   * @return scrīptiōnem temporis prōvīsus
   */
  @NotNull public static String fōrmem(@NotNull final Instant tempus, final boolean pūnctillaPraecidemne) {
    return new FōrmaTemporis(tempus, pūnctillaPraecidemne).fōrmō();
  }

  /**
   * @param pūnctillaPraecidemne valōrem {@code true} sī rēs haec temporem praesentem pūnctilla praecidemne; valōrem {@code false} aliter
   * @return scrīptiōnem temporis praesentis
   */
  @NotNull public static String fōrmem(final boolean pūnctillaPraecidemne) {
    return new FōrmaTemporis(pūnctillaPraecidemne).fōrmō();
  }
}
