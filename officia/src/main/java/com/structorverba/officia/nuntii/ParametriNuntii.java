package officia.src.main.java.com.structorverba.officia.nuntii;

import officia.src.main.java.com.structorverba.officia.miscella.Utilitas;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.*;

/**
 * Classis {@link ParametriNuntii} val\u014Dr\u0113s continet qu\u014Ds rem classis {@link Nuntius} iuvat gener\u0101re.
 */
@SuppressWarnings("SpellCheckingInspection")
final class ParametriNuntii {
  /**
   * Valor hic incidat quam verb\u014Dsa r\u0113s haec scr\u012Bb\u0113tur.
   */
  @NotNull public final GradusNuntii gradusMinimus = GradusNuntii.OMNIS;
  /**
   * Valor hic viam re\u012B classis <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
   * facit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public final Supplier <@NotNull Logger> praeconium;
  private final @NotNull String locus = "logs";

  private ParametriNuntii(@NotNull final Class <?> classis) {
    praeconium = ( ) -> {
      final Logger praeco = Logger.getLogger(classis.getSimpleName());
      praeco.setParent(Logger.getGlobal());
      praeco.setUseParentHandlers(false);
      praeco.setLevel(gradusMinimus.gressus.get());

      StreamHandler tenor;
      try {
        if (StringUtils.isNotBlank(locus)) {
          tenor = new FileHandler(Path.of(locus, String.format("%s.log", classis.getSimpleName()))
                                      .toString(), true);
          tenor.setEncoding(Utilitas.LITTERAE.displayName());
        } else {
          tenor = new ConsoleHandler();
        }
      } catch (IOException e) {
        tenor = new ConsoleHandler();
      }

      tenor.setLevel(gradusMinimus.gressus.get());
      tenor.setFormatter(new Formatter() {
        @Override
        public String format(LogRecord eventus) {
          return String.format("%s %s <%s> %s%n", FormaTemporis.formem(eventus.getMillis(), true),
                               GradusNuntii.gradior(eventus.getLevel()), eventus.getLoggerName(),
                               eventus.getMessage());
        }
      });

      praeco.addHandler(tenor);
      return praeco;
    };
  }

  /**
   * @param classis classis apta
   * @return Rem novam classis huius
   */
  @NotNull public static ParametriNuntii para(@NotNull final Class <?> classis) {
    return new ParametriNuntii(classis);
  }
}
