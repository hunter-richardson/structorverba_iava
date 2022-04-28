package officia.src.main.java.com.structorverba.officia.miscella;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.charset.*;
import java.nio.file.Path;
import java.util.*;

/**
 * Classis {@link Utilitas} mod\u014Ds val\u014Dr\u0113sque \u016Btil\u0113s programm\u0101t\u012D Str\u016BctorVerba d\u0113f\u012Dnit.
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Utilitas extends Omne {
  /**
   * Valor hic litter\u0101s omn\u0113s \u016Bs\u0101s per programm\u0101te Str\u016BctorVerba tenet.
   */
  @NotNull public static final Charset LITTERAE = StandardCharsets.UTF_8;
  @NotNull private static final Locale LOCULUS = Locale.forLanguageTag("Latn");

  /**
   * @param haec valor scr\u012Dbendus
   * @return {@code haec} cum litter\u012Ds capit\u0101ne\u012Ds
   */
  @NotNull public static String capitaneasScribo(@NotNull final String haec) {
    return haec.trim().toUpperCase(LOCULUS);
  }

  /**
   * @param haec valor scr\u012Dbendus
   * @return {@code haec} cum litter\u012Ds minuscul\u012Ds
   */
  @NotNull public static String minusculasScribo(@NotNull final String haec) {
    return haec.trim().toLowerCase(LOCULUS);
  }

  /**
   * @param haec valor scr\u012Dbendus
   * @return {@code haec} cum litter\u012Ds minuscul\u012Ds praeter pr\u012Dmam capit\u0101neam
   */
  @NotNull public static String primamCapitaneamScribo(@NotNull final String haec) {
    return String.format("%s%s", String.valueOf(haec.charAt(0)).toUpperCase(LOCULUS),
                         haec.substring(1).trim());
  }

  /**
   * @param locus locus adveniendus
   * @return Locus sc\u0101p\u012D pet\u012Dt\u012D intr\u0101 scr\u012Dnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>
   * @see #auxilior(String...)
   */
  @NotNull public static String auxilior(@NotNull final String locus) {
    return auxilior(locus.split(File.pathSeparator));
  }

  /**
   * @param locus part\u0113s loc\u012D adveniend\u012D
   * @return Locus sc\u0101p\u012D pet\u012Dt\u012D intr\u0101 scr\u012Dnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>
   */
  @NotNull public static String auxilior(@NotNull final String... locus) {
    final String[] plus = Arrays.copyOfRange(locus, 1, locus.length);
    return Path.of("src", "main", "resources", Path.of(locus[ 0 ], plus).toString())
               .toAbsolutePath().toString();
  }
}
