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
 * Classis {@link Utilitas} modōs valōrēsque ūtilēs programmātī StrūctorVerba dēfīnit.
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Utilitas extends Omne {
  /**
   * Hic valor litterās omnēs ūsās per programmāte StrūctorVerba tenet.
   */
  @NonNull public static final Charset LITTERAE = StandardCharsets.UTF_8;
  @NonNull public static final Locale LOCULUS = Locale.forLanguageTag("Latn");

  /**
   * @param haec valor scrībendus
   * @return Valor {@code haec} cum litterīs capitāneīs
   */
  @NonNull public static String capitaneasScribo(@NonNull final String haec) {
    return haec.trim().toUpperCase(LOCULUS);
  }

  /**
   * @param haec valor scrībendus
   * @return Valor {@code haec} cum litterīs minusculīs
   */
  @NonNull public static String minusculasScribo(@NonNull final String haec) {
    return haec.trim().toLowerCase(LOCULUS);
  }

  /**
   * @param haec valor scrībendus
   * @return Valor {@code haec} cum litterīs minusculīs praeter prīmam capitāneam
   */
  @NonNull public static String primamCapitaneamScribo(@NonNull final String haec) {
    return String.format("%s%s", String.valueOf(haec.charAt(0)).toUpperCase(LOCULUS),
                         haec.substring(1).trim());
  }

  /**
   * @param locus locus adveniendus
   * @return Locus scāpī petītī intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>
   * @see #auxilior(String...)
   */
  @NonNull public static String auxilior(@NonNull final String locus) {
    return auxilior(locus.split(File.pathSeparator));
  }

  /**
   * @param locus partēs locī adveniendī
   * @return Locus scāpī petītī intrā scrīnium <a href="{@docRoot}/../src/main/resources">auxiliārēs</a>
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
          case PRAEPOSITIO -> LectorPraepositionibus.faciendum.get().fortuitumLegam();
          case NUMERUS -> StructorVerba.faciendum.get().fortuitumNumeram();
          default -> null;
        }).lemma;
      default:
        final Path via = Paths.get(auxilior(categoria.scriptio));
        if(via != null && via.toFile() != null &&
           via.toFile().exists() && via.toFile().isDirectory()) {
          try (final Stream<Path> loci = Files.walk(via, 0).distinct().filter(Objects::nonNull)
                                              .filter(Files::isRegularFile).filter(Files::isReadable)) {
            final Path hoc = loci.reduce((BinaryOperator<Path>) invocaFortem).orElseGet(null);
            return ObjectUtils.allNotNull(hoc, hoc.toFile()) ? FilenameUtils.getBaseName(hoc.toFile().getName())
                                                             : StringUtils.EMPTY;
          }
        } else {
          return StringUtils.EMPTY;
        }
    }
  }

  @NonNull public static BinaryOperator<?> invocaFortem = (primum, secundum) -> new Random().nextBoolean() ? primum : secundum;
}
