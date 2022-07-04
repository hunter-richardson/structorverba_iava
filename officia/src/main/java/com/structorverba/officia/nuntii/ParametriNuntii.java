package com.structorverba.officia.nuntii;

import androidx.annotation.NonNull;
import com.structorverba.officia.miscella.Utilitas;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.*;

/**
 * Classis {@link ParametriNuntii} valōrēs continet quōs rem classis {@link Nuntius} iuvat generāre.
 */
@SuppressWarnings("SpellCheckingInspection")
public final class ParametriNuntii {
  /**
   * Valor hic incidat quam verbōsa rēs haec scrībētur.
   */
  @NonNull public final GradusNuntii gradusMinimus = GradusNuntii.OMNIS;
  /**
   * Valor hic viam reī classis <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
   * facit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NonNull public final Supplier<Logger> praeconium;
  private final @NonNull String locus = "logs";

  private ParametriNuntii(@NonNull final Class <?> classis) {
    praeconium = () -> {
      final Logger praeco = Logger.getLogger(classis.getSimpleName());
      praeco.setParent(Logger.getGlobal());
      praeco.setUseParentHandlers(false);
      praeco.setLevel(gradusMinimus.gressus.get());

      StreamHandler tenor;
      try {
        if (StringUtils.isNotBlank(locus)) {
          tenor = new FileHandler(Paths.get(locus, String.format("%s.log", classis.getSimpleName()))
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
  @NonNull public static ParametriNuntii para(@NonNull final Class <?> classis) {
    return new ParametriNuntii(classis);
  }
}
