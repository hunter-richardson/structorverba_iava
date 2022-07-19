package com.structorverba.officia.nuntii;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;

import com.structorverba.officia.enumerationes.Mensis;
import androidx.annotation.NonNull;
import com.structorverba.officia.miscella.Utilitas;

import java.time.*;
import java.time.temporal.*;
import java.util.function.BiFunction;

/**
 * Classis {@link FormaTemporis} temporem fōrmat scrībī.
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
final class FormaTemporis {
  @NonNull private static final BiFunction<ZonedDateTime, Boolean, String> formatio =
    (tempus, praecisio) -> {
      String zona = tempus.getZone().getId();
      if (tempus.getZone().getId().length() > 3) {
        if (tempus.getZone().getRules().isDaylightSavings(tempus.toInstant())) {
          zona = zona.substring(zona.length() - 3);
        } else {
          zona = zona.substring(0, 3);
        }
      }

      if (praecisio) {
        return String.format(Utilitas.LOCULUS, "[%d %s %d, %d:%d:%d.%d %s]",
                             tempus.getDayOfMonth(), Mensis.indicam(tempus.getMonth()),
                             tempus.getYear(), tempus.getHour(), tempus.getMinute(), tempus.getSecond(),
                             tempus.get(ChronoField.MILLI_OF_SECOND), zona);
      } else {
        return String.format("[%s %s %s, %s:%s:%s %s]",
                             RomanInteger.parse(String.valueOf(tempus.getDayOfMonth()), IntegerType.ARABIC),
                             Mensis.indicam(tempus.getMonth()),
                             RomanInteger.parse(String.valueOf(tempus.getYear()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getHour()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getMinute()), IntegerType.ARABIC),
                             RomanInteger.parse(String.valueOf(tempus.getSecond()), IntegerType.ARABIC), zona);
      }
    };
  @NonNull private final ZonedDateTime tempus;
           private final boolean       punctillaPraecidemne;

  private FormaTemporis() {
    tempus = ZonedDateTime.now();
    punctillaPraecidemne = false;
  }

  private FormaTemporis(final long instans) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(instans), ZoneId.systemDefault());
    punctillaPraecidemne = false;
  }

  private FormaTemporis(@NonNull final Instant instans) {
    tempus = ZonedDateTime.ofInstant(instans, ZoneId.systemDefault());
    punctillaPraecidemne = false;
  }

  private FormaTemporis(final boolean punctillaPraecidemne) {
    tempus = ZonedDateTime.now();
    this.punctillaPraecidemne = punctillaPraecidemne;
  }

  private FormaTemporis(final long instans, final boolean punctillaPraecidemne) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(instans), ZoneId.systemDefault());
    this.punctillaPraecidemne = punctillaPraecidemne;
  }

  private FormaTemporis(@NonNull final Instant instans, final boolean punctillaPraecidemne) {
    tempus = ZonedDateTime.ofInstant(instans, ZoneId.systemDefault());
    this.punctillaPraecidemne = punctillaPraecidemne;
  }

  /**
   * @param tempus tempus fōrmandus
   * @return scrīptiōnem temporis prōvīsī
   */
  @NonNull public static String formem(final long tempus) {
    return new FormaTemporis(tempus).formo();
  }

  /**
   * @param tempus tempus fōrmandus
   * @return scrīptiōnem temporis prōvīsī
   */
  @NonNull public static String formem(@NonNull final Instant tempus) {
    return new FormaTemporis(tempus).formo();
  }

  /**
   * @return scrīptiōnem temporis praesentis
   */
  @NonNull public static String formem() {
    return new FormaTemporis().formo();
  }

  /**
   * @param tempus               tempus fōrmandus
   * @param punctillaPraecidemne valōrem {@code true} sī haec rēs valōrem {@code tempus} pūnctilla praecidemne;
   *                             valōrem {@code false} aliter
   * @return scrīptiōnem temporis prōvīsī
   */
  @NonNull public static String formem(final long tempus, final boolean punctillaPraecidemne) {
    return new FormaTemporis(tempus, punctillaPraecidemne).formo();
  }

  /**
   * @param tempus               tempus fōrmandus
   * @param punctillaPraecidemne valōrem {@code true} sī haec rēs valōrem {@code tempus} pūnctilla praecidemne;
   *                             valōrem {@code false} aliter
   * @return scrīptiōnem temporis prōvīsī
   */
  @NonNull public static String formem(@NonNull final Instant tempus, final boolean punctillaPraecidemne) {
    return new FormaTemporis(tempus, punctillaPraecidemne).formo();
  }

  /**
   * @param punctillaPraecidemne valōrem {@code true} sī haec rēs temporem praesentem pūnctilla praecidemne;
   *                             valōrem {@code false} aliter
   * @return scrīptiōnem temporis praesentis
   */
  @NonNull public static String formem(final boolean punctillaPraecidemne) {
    return new FormaTemporis(punctillaPraecidemne).formo();
  }

  /**
   * @return scrīptiōnem temporis quem haec rēs continet.
   */
  @NonNull public String formo() {
    return formatio.apply(tempus, punctillaPraecidemne);
  }
}
