package officia.src.main.java.com.structorverba.officia.nuntii;

import com.github.chaosfirebolt.converter.RomanInteger;
import com.github.chaosfirebolt.converter.constants.IntegerType;

import com.structorverba.enumerationes.Mensis;

import org.jetbrains.annotations.NotNull;

import java.time.*;
import java.time.temporal.*;

/**
 * Classis {@link FormaTemporis} temporem f\u014Drmat scr\u012Bb\u012B.
 */
@SuppressWarnings({ "SpellCheckingInspection", "unused" })
final class FormaTemporis {
  @NotNull private static final BiFunction <@NotNull ZonedDateTime, @NotNull Boolean, @NotNull String> formatio =
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
        return String.format("[%d %s %d, %d:%d:%d.%d %s]",
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
  @NotNull private final ZonedDateTime tempus;
  private final          boolean       punctillaPraecidemne;

  private FormaTemporis( ) {
    tempus = ZonedDateTime.now();
    punctillaPraecidemne = false;
  }

  private FormaTemporis(final long instans) {
    tempus = ZonedDateTime.ofInstant(Instant.ofEpochMilli(instans), ZoneId.systemDefault());
    punctillaPraecidemne = false;
  }

  private FormaTemporis(@NotNull final Instant instans) {
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

  private FormaTemporis(@NotNull final Instant instans, final boolean punctillaPraecidemne) {
    tempus = ZonedDateTime.ofInstant(instans, ZoneId.systemDefault());
    this.punctillaPraecidemne = punctillaPraecidemne;
  }

  /**
   * @param tempus tempus f\u014Drmandus
   * @return scr\u012Bpti\u014Dnem temporis pr\u014Dv\u012Bs\u012B
   */
  @NotNull public static String formem(final long tempus) {
    return new FormaTemporis(tempus).formo();
  }

  /**
   * @param tempus tempus f\u014Drmandus
   * @return scr\u012Bpti\u014Dnem temporis pr\u014Dv\u012Bs\u012B
   */
  @NotNull public static String formem(@NotNull final Instant tempus) {
    return new FormaTemporis(tempus).formo();
  }

  /**
   * @return scr\u012Bpti\u014Dnem temporis praesentis
   */
  @NotNull public static String formem() {
    return new FormaTemporis().formo();
  }

  /**
   * @param tempus               tempus f\u014Drmandus
   * @param punctillaPraecidemne val\u014Drem {@code true} s\u012B r\u0113s haec val\u014Drem {@code tempus} p\u016Bnctilla praecidemne;
   *                             val\u014Drem {@code false} aliter
   * @return scr\u012Bpti\u014Dnem temporis pr\u014Dv\u012Bs\u012B
   */
  @NotNull public static String formem(final long tempus, final boolean punctillaPraecidemne) {
    return new FormaTemporis(tempus, punctillaPraecidemne).formo();
  }

  /**
   * @param tempus               tempus f\u014Drmandus
   * @param punctillaPraecidemne val\u014Drem {@code true} s\u012B r\u0113s haec val\u014Drem {@code tempus} p\u016Bnctilla praecidemne;
   *                             val\u014Drem {@code false} aliter
   * @return scr\u012Bpti\u014Dnem temporis pr\u014Dv\u012Bs\u012B
   */
  @NotNull public static String formem(@NotNull final Instant tempus, final boolean punctillaPraecidemne) {
    return new FormaTemporis(tempus, punctillaPraecidemne).formo();
  }

  /**
   * @param punctillaPraecidemne val\u014Drem {@code true} s\u012B r\u0113s haec temporem praesentem p\u016Bnctilla praecidemne;
   *                             val\u014Drem {@code false} aliter
   * @return scr\u012Bpti\u014Dnem temporis praesentis
   */
  @NotNull public static String formem(final boolean punctillaPraecidemne) {
    return new FormaTemporis(punctillaPraecidemne).formo();
  }

  /**
   * @return scr\u012Bpti\u014Dnem temporis quem r\u0113s haec continet.
   */
  @NotNull public String formo() {
    return formatio.apply(tempus, punctillaPraecidemne);
  }
}
