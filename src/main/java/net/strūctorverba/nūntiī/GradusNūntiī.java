package net.strūctorverba.nūntiī;

import lombok.AllArgsConstructor;
import net.strūctorverba.mīscella.Ūtilitās;
import org.apache.commons.lang3.EnumUtils;
import org.jetbrains.annotations.*;

import java.util.logging.Level;
import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
@AllArgsConstructor
enum GradusNūntiī {
  INERS(Level.OFF,              8),
  GRAVIS(Level.SEVERE,          7),
  PRAEMONITŌRIUS(Level.WARNING, 6),
  ĪNFŌRMĀTĪVUS(Level.INFO,      5),
  PRAEGRESSŪRUS(Level.CONFIG,   4),
  SCRŪTĀNS(Level.FINE,          3),
  SCRŪTĀNTIOR(Level.FINER,      2),
  SCRŪTĀNTISSIMUS(Level.FINEST, 1),
  OMNIS(Level.ALL,              0);

  public final @NotNull Level gressus;
  public final          int   praecellentia;

  public static @Nullable GradusNūntiī dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable GradusNūntiī dēfīniam(@NotNull final String scrīptiō, @Nullable final GradusNūntiī dēfecta) {
    return EnumUtils.getEnum(GradusNūntiī.class, Ūtilitās.capitāneāsScrībō(scrīptiō), dēfecta);
  }

  public static @NotNull GradusNūntiī gradior(@NotNull final Level grs) {
    return Stream.of(values())
                 .filter(gradus -> gradus.gressus.intValue() == grs.intValue())
                 .findFirst().orElse(OMNIS);
  }

  public static int compareTo(@NotNull final GradusNūntiī prīmus, @NotNull final GradusNūntiī secundus) {
    return Integer.compare(prīmus.praecellentia, secundus.praecellentia);
  }
}
