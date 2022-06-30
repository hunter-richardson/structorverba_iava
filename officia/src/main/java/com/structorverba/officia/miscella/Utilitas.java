package com.structorverba.officia.miscella;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.lectores.LectorPraepositionibus;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.*;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Classis {@link Utilitas} mod\u014Ds val\u014Dr\u0113sque \u016Btil\u0113s programm\u0101t\u012D Str\u016BctorVerba d\u0113f\u012Dnit.
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Utilitas extends Omne {
  /**
   * Valor hic litter\u0101s omn\u0113s \u016Bs\u0101s per programm\u0101te Str\u016BctorVerba tenet.
   */
  @NonNull public static final Charset LITTERAE = StandardCharsets.UTF_8;
  @NonNull public static final Locale LOCULUS = Locale.forLanguageTag("Latn");

  /**
   * @param haec valor scr\u012Dbendus
   * @return {@code haec} cum litter\u012Ds capit\u0101ne\u012Ds
   */
  @NonNull public static String capitaneasScribo(@NonNull final String haec) {
    return haec.trim().toUpperCase(LOCULUS);
  }

  /**
   * @param haec valor scr\u012Dbendus
   * @return {@code haec} cum litter\u012Ds minuscul\u012Ds
   */
  @NonNull public static String minusculasScribo(@NonNull final String haec) {
    return haec.trim().toLowerCase(LOCULUS);
  }

  /**
   * @param haec valor scr\u012Dbendus
   * @return {@code haec} cum litter\u012Ds minuscul\u012Ds praeter pr\u012Dmam capit\u0101neam
   */
  @NonNull public static String primamCapitaneamScribo(@NonNull final String haec) {
    return String.format("%s%s", String.valueOf(haec.charAt(0)).toUpperCase(LOCULUS),
                         haec.substring(1).trim());
  }

  /**
   * @param locus locus adveniendus
   * @return Locus sc\u0101p\u012D pet\u012Dt\u012D intr\u0101 scr\u012Dnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>
   * @see #auxilior(String...)
   */
  @NonNull public static String auxilior(@NonNull final String locus) {
    return auxilior(locus.split(File.pathSeparator));
  }

  /**
   * @param locus part\u0113s loc\u012D adveniend\u012D
   * @return Locus sc\u0101p\u012D pet\u012Dt\u012D intr\u0101 scr\u012Dnium <a href="{@docRoot}/../src/main/resources">auxili\u0101r\u0113s</a>
   */
  @NonNull public static String auxilior(@NonNull final String... locus) {
    final String[] plus = Arrays.copyOfRange(locus, 1, locus.length);
    return Paths.get("src", "main", "resources", Paths.get(locus[ 0 ], plus).toString())
                .toAbsolutePath().toString();
  }

  @SuppressWarnings({"unchecked", "ConstantConditions"})
  @NonNull public static String fortuitumLegam(@NonNull final Categoria categoria) throws IOException {
    switch (categoria) {
      case PRAEPOSITIO: case NUMERUS:
        return (switch (categoria) {
          case PRAEPOSITIO -> LectorPraepositionibus.fac.get().fortuitumLegam();
          case NUMERUS -> StructorVerba.fac.get().fortuitumNumeram();
          default -> null;
        }).lemma;
      default:
        final Path via = Paths.get(auxilior(categoria.scriptio));
        if(via != null && via.toFile() != null &&
           via.toFile().exists() && via.toFile().isDirectory()) {
          try (final Stream<Path> loci = Files.walk(via, 0).distinct().filter(Objects::nonNull)
                                              .filter(Files::isRegularFile).filter(Files::isReadable)) {
            final Path hoc = loci.reduce((BinaryOperator<Path>) fortemInvoca).orElseGet(null);
            return ObjectUtils.allNotNull(hoc, hoc.toFile()) ? FilenameUtils.getBaseName(hoc.toFile().getName())
                                                             : StringUtils.EMPTY;
          }
        } else {
          return StringUtils.EMPTY;
        }
    }
  }

  @NonNull public static BinaryOperator<?> fortemInvoca = (primum, secundum) -> new Random().nextBoolean() ? primum : secundum;
}
