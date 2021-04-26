package net.strūctorverba.nūntiī;

import net.strūctorverba.mīscella.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.logging.*;

/**
 * Classis {@link ParametrīNūntiī} valōrēs continet quōs rem classis {@link Nūntius} iuvat generāre.
 */
@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
final class ParametrīNūntiī {
  private final @NotNull String locus = "logs";

  /**
   * Valor hic incidat quam verbōsa rēs haec scrībētur.
   */
  @NotNull public final GradusNūntiī gradusMinimus = GradusNūntiī.OMNIS;

  /**
   * Valor hic viam reī classis <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a> facit.
   * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html">Logger</a>
   * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html">Supplier</a>
   */
  @NotNull public final Supplier <@NotNull Logger> praecōnium;

  private ParametrīNūntiī(@NotNull final Class <?> classis) {
    praecōnium = () -> {
        final Logger praecō = Logger.getLogger(classis.getSimpleName());
        praecō.setParent(Logger.getGlobal());
        praecō.setUseParentHandlers(false);
        praecō.setLevel(gradusMinimus.gressus.get());

        StreamHandler tenor;
        try {
          if(StringUtils.isNotBlank(locus)) {
            tenor = new FileHandler(Path.of(locus, String.format("%s.log", classis.getSimpleName()))
                                        .toString(), true);
            tenor.setEncoding(Ūtilitās.LITTERAE.displayName());
          } else {
            tenor = new ConsoleHandler();
          }
        } catch (IOException e) {
          tenor = new ConsoleHandler();
        }

        tenor.setLevel(gradusMinimus.gressus.get());
        tenor.setFormatter(new Formatter() {
          @Override
          public String format(LogRecord ēventus) {
            return String.format("%s %s <%s> %s%n", FōrmaTemporis.fōrmem(ēventus.getMillis(), true),
                                 GradusNūntiī.gradior(ēventus.getLevel()), ēventus.getLoggerName(),
                                 ēventus.getMessage());
          }
        });

        praecō.addHandler(tenor);
        return praecō;
      };
  }

  /**
   * @param classis classis apta
   * @return Rem novam classis huius
   */
  @NotNull public static ParametrīNūntiī parā(@NotNull final Class<?> classis) {
    return new ParametrīNūntiī(classis);
  }
}
