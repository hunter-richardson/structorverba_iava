package net.strūctorverba.mīscella;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.charset.*;
import java.nio.file.Path;
import java.util.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public class Ūtilitās {
  public static final @NotNull Charset LITTERAE = StandardCharsets.UTF_8;
  public static final @NotNull Locale  LOCULUS  = Locale.forLanguageTag("Latn");

  public static @NotNull String capitāneāsScrībō(@NotNull final String haec) {
    return haec.trim().toUpperCase(LOCULUS);
  }

  public static  @NotNull String minusculāsScrībō(@NotNull final String haec) {
    return haec.trim().toLowerCase(LOCULUS);
  }

  public static @NotNull String prīmamCapitāneamScrībō(@NotNull final String haec) {
    return String.format("%s%s", String.valueOf(haec.charAt(0)).toUpperCase(LOCULUS),
                         haec.substring(1).trim());
  }

  public static @NotNull String auxilior(@NotNull final String locus) {
    return auxilior(locus.split(File.pathSeparator));
  }

  public static @NotNull String auxilior(@NotNull final String... locus) {
    final String[] plūs = Arrays.copyOfRange(locus, 1, locus.length);
    return Path.of("src", "main", "resources", Path.of(locus[0], plūs).toString())
               .toAbsolutePath().toString();
  }
}
