package net.strūctorverba.mīscella;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.charset.*;
import java.nio.file.Path;
import java.util.*;

/**
 * Classis {@link Ūtilitās} modōs valōrēsque ūtilēs programmātī StrūctorVerba dēfīnit.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public final class Ūtilitās extends Omnum {
  @NotNull private static final Locale LOCULUS  = Locale.forLanguageTag("Latn");

  /**
   * Valor hic litterās omnēs ūsās per programmāte StrūctorVerba tenet.
   */
  @NotNull public static final Charset LITTERAE = StandardCharsets.UTF_8;

  /**
   * @param haec valor scrībendus
   * @return {@code haec} cum litterīs capitāneīs
   */
  @NotNull public static String capitāneāsScrībō(@NotNull final String haec) {
    return haec.trim().toUpperCase(LOCULUS);
  }

  /**
   * @param haec valor scrībendus
   * @return {@code haec} cum litterīs minusculīs
   */
  @NotNull public static String minusculāsScrībō(@NotNull final String haec) {
    return haec.trim().toLowerCase(LOCULUS);
  }

  /**
   * @param haec valor scrībendus
   * @return {@code haec} cum litterīs minusculīs praeter prīmam capitāneam
   */
  @NotNull public static String prīmamCapitāneamScrībō(@NotNull final String haec) {
    return String.format("%s%s", String.valueOf(haec.charAt(0)).toUpperCase(LOCULUS),
                         haec.substring(1).trim());
  }

  /**
   * @param locus locus adveniendus
   * @return Locus scāpī petītī intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>
   * @see #auxilior(String...)
   */
  @NotNull public static String auxilior(@NotNull final String locus) {
    return auxilior(locus.split(File.pathSeparator));
  }

  /**
   * @param locus partēs locī adveniendī
   * @return Locus scāpī petītī intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>
   */
  @NotNull public static String auxilior(@NotNull final String... locus) {
    final String[] plūs = Arrays.copyOfRange(locus, 1, locus.length);
    return Path.of("src", "main", "resources", Path.of(locus[0], plūs).toString())
               .toAbsolutePath().toString();
  }
}
