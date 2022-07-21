package com.structorverba.officia.miscella;

import androidx.annotation.NonNull;
import com.structorverba.officia.enumerationes.Categoria;
import com.structorverba.officia.quadriiugia.*;
import com.structorverba.officia.verba.Verbum;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.*;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
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
   * Hic modus litterās capitāneās scrībit
   */
  @NonNull public static final Function<String, String> capitaneae = hoc -> hoc.trim().toUpperCase(LOCULUS);

  /**
   * Hic modus litterās capitāneās scrībit
   */
  @NonNull public static final Function<String, String> minisculae = hoc -> hoc.trim().toLowerCase(LOCULUS);

  /**
   * Hic modus litterās capitāneās scrībit
   */
  @NonNull public static final Function<String, String> primaCapitanea =
          hoc -> String.format("%s%s", capitaneae.apply(String.valueOf(hoc.charAt(0))),
                                       minisculae.apply(hoc.substring(1)));

  /**
   * Hic valor classem {@link Random} invocat ut dēcrēta bīnāria agat.
   * @see Random#nextBoolean()
   * */
  @NonNull public static BinaryOperator<?> fors = (primum, secundum) -> new Random().nextBoolean() ? primum : secundum;

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

  /**
   * Hic modus nōminem scāpī <a href="{@docRoot}/../src/main/resources">dictiōnāriō</a> temere sēligit.
   * @param categoria  Rēs classis {@link Categoria} quae extēnsiōnem nōminandam classis {@link Verbum} repraesentat.
   * @return Nōminem scāpī fortuītī
   * @see #fors
   * */
  @SuppressWarnings({"unchecked", "ConstantConditions"})
  @NonNull public static String fortuitumLegam(@NonNull final Categoria categoria) throws IOException {
    switch (categoria) {
      case PRAEPOSITIO: case NUMERUS:
        return (switch (categoria) {
          case PRAEPOSITIO -> Lector.Praepositionibus.faciendum.get().fortuitumLegam();
          case NUMERUS -> Curator.Numeris.faciendum.get().fortuitumNumeram();
          default -> null;
        }).lemma;
      default:
        final Path via = Paths.get(auxilior(categoria.scriptio));
        if(via != null && via.toFile() != null &&
           via.toFile().exists() && via.toFile().isDirectory()) {
          try (final Stream<Path> loci = Files.walk(via, 0).distinct().filter(Objects::nonNull)
                                              .filter(Files::isRegularFile).filter(Files::isReadable)) {
            final Path hoc = loci.reduce((BinaryOperator<Path>) fors).orElseGet(null);
            return ObjectUtils.allNotNull(hoc, hoc.toFile()) ? FilenameUtils.getBaseName(hoc.toFile().getName())
                                                             : StringUtils.EMPTY;
          }
        } else {
          return StringUtils.EMPTY;
        }
    }
  }

  /**
   * Hic modus nōminem scāpī <a href="{@docRoot}/../src/main/resources">dictiōnāriō</a> temere sēligit.
   * @return Nōminem scāpī fortuītī
   * @see #fortuitumLegam(Categoria)
   * @see #fors
   * */
  @SuppressWarnings({"unchecked", "OptionalGetWithoutIsPresent", "unused"})
  @NonNull public static String fortitumLegam() throws IOException {
    return fortuitumLegam(Arrays.stream(Categoria.values())
                                .reduce((BinaryOperator<Categoria>) fors)
                                .get());
  }
}
