package net.strūctorverba.nūntiī;

import net.strūctorverba.mīscella.Ūtilitās;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.logging.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
final class ParametrīNūntiī {
  private final @NotNull GradusNūntiī gradusMaximus = GradusNūntiī.OMNIS;
  private final @NotNull String       locus         = "logs";

  public final @NotNull Supplier <@NotNull Logger> praecōnium;

  public ParametrīNūntiī(@NotNull final Class <?> cls) {
    praecōnium = () -> {
        final Logger praecō = Logger.getLogger(cls.getSimpleName());
        praecō.setParent(Logger.getGlobal());
        praecō.setUseParentHandlers(false);
        praecō.setLevel(gradusMaximus.gressus);

        StreamHandler tenor;
        try {
          if(StringUtils.isNotBlank(locus)) {
            tenor = new FileHandler(Path.of(locus, String.format("%s.log", cls.getSimpleName()))
                                        .toString(), true);
            tenor.setEncoding(Ūtilitās.LITTERAE.displayName());
          } else {
            tenor = new ConsoleHandler();
          }
        } catch (IOException e) {
          tenor = new ConsoleHandler();
        }

        tenor.setLevel(gradusMaximus.gressus);
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

  public static @NotNull ParametrīNūntiī parā(@NotNull final Class<?> classis) {
    return new ParametrīNūntiī(classis);
  }
}
