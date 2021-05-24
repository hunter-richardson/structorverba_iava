package net.strūctorverba.tentāmina;

import net.strūctorverba.mīscella.*;
import net.strūctorverba.verba.*;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;

import java.util.function.BiFunction;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Tentāmen <Illud, Hoc> {
  @NotNull private final BiFunction <Hoc, Illud, String> exsecūtiō;
  @NotNull private final Hoc                             hoc;

  protected Tentāmen(@NotNull final Hoc hc, @NotNull final BiFunction <Hoc, Illud, String> exsct) {
    hoc = hc;
    exsecūtiō = exsct;
  }

  public String exsequar(@Nullable final Illud illud) {
    return exsecūtiō.apply(hoc, illud);
  }

  public static final class TentāmenVerbāle extends Tentāmen <Verba, String> {
    protected TentāmenVerbāle(@NotNull final String data, @NotNull final String nōmen) {
      super(data, (hoc, illud) -> {
        new Tentāmiculum.TentāmiculumReī(illud)
          .existat(String.format("Verba prōducta %s vacant.", nōmen));
        new Tentāmiculum.TentāmiculumNumerālis <>(0, illud.seriēs.size())
          .superet(String.format("Verba prōducta %s vacant.", nōmen));
        for (int index = 0; index < illud.seriēs.size(); index++) {
          new Tentāmiculum.TentāmiculumReī(illud.seriēs.get(index))
            .existat(String.format("Prōductā %s est relicta prōductiō verbī %s.",
                                   nōmen, Ūtilitās.minusculāsScrībō(hoc.split(String.valueOf(' '))[ index ])));
          new Tentāmiculum.TentāmiculumVersiculī(illud.seriēs.get(index).toString())
            .aliamContineat(String.format("Prōductā %s est relicta prōductiō verbī %s.",
                                          nōmen, Ūtilitās.minusculāsScrībō(hoc.split(String.valueOf(' '))[ index ])));
        }

        new Tentāmiculum.TentāmiculumVersiculī(illud.toString())
          .aliamContineat(String.format("Verba prōducta %s expectātiōne eius differt.", nōmen));
        return String.format("Prōducta %s: %s", nōmen, illud);
      });
    }
  }

  public static final class TentāmenNumerāleConversiōnis extends Tentāmen <VerbumSimplex.Numerus, String> {
    protected TentāmenNumerāleConversiōnis(@NotNull final String data, final short numerus) {
      super(data, (hoc, illud) -> {
        new Tentāmiculum.TentāmiculumReī(illud)
          .existat(String.format("Prōductā conversiōnis est relicta prōductiō numerī %d.", numerus));
        new Tentāmiculum.TentāmiculumVersiculī(illud.toString())
          .aliamContineat("Numerum prōductum conversiōnis vacat.");
        new Tentāmiculum.TentāmiculumVersiculī(data, illud.toString())
          .aequentur("Numerum prōductum conversiōnis expectātiōne eius differt.");
        return String.format("%d = %s", numerus, illud);
      });
    }
  }

  public static final class TentāmenNumerāleReversiōnis extends Tentāmen <VerbumSimplex.Numerus, Short> {
    protected TentāmenNumerāleReversiōnis(@NotNull final Short numerus, @NotNull final String scrīptiō) {
      super(numerus, (hoc, illud) -> {
        new Tentāmiculum.TentāmiculumReī(illud)
          .existat(String.format("Prōductā reversiōnis est relicta prōductiō numerī %s.", scrīptiō));
        new Tentāmiculum.TentāmiculumNumerālis <>(numerus, illud.numerus)
          .aequentur("Numerum prōductum reversiōnis expectātiōne eius differt.");
        return String.format("%s = %d", scrīptiō, illud.numerus);
      });
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static final class TentāmenNumerāleCombīnātiōnis extends Tentāmen <VerbumSimplex.Numerus, Short> {
    protected TentāmenNumerāleCombīnātiōnis(@NotNull final Short numerus) {
      super(numerus, (hoc, prīmus) -> {
        new Tentāmiculum.TentāmiculumReī(prīmus)
          .existat(String.format("Prōductā conversiōnis est relicta prōductiō numerī %d.", numerus));
        new Tentāmiculum.TentāmiculumVersiculī(prīmus.toString())
          .aliamContineat("Numerum prōductum conversiōnis vacat.");

        @NotNull final StrūctorVerba strūctor = StrūctorVerba.fac.get();
        @NotNull final VerbumSimplex.Numerus secundus = strūctor.numerus(prīmus.toString());
        new Tentāmiculum.TentāmiculumReī(secundus)
          .existat(String.format("Prōductā conversiōnis est relicta prōductiō numerī %d.", numerus));
        new Tentāmiculum.TentāmiculumNumerālis <>(numerus, secundus.numerus)
          .aequentur("Numerum prōductum combīnātiōnis expectātiōne eius differt.");

        return String.format("%s = %d%n%d = %s%n", prīmus, numerus, numerus, secundus);
      });
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static final class TentāmenMathēmaticum extends Tentāmen <VerbumSimplex.Numerus, Range <Short>> {
    protected TentāmenMathēmaticum(@NotNull final Range <Short> range, final char operātiō) {
      super(range, (hoc, prīmus) -> {
        new Tentāmiculum.TentāmiculumReī(prīmus)
          .existat(String.format("Prōductā %s est relicta prōductiō numerī %d.", operātiō, range.getMaximum()));
        new Tentāmiculum.TentāmiculumVersiculī(prīmus.toString())
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operātiō));

        final String labor = switch (operātiō) {
          case '+' -> "additiōnis";
          case '-' -> "subtractiōnis";
          case '*' -> "multiplicātiōnis";
          case '/' -> "dīvīsiōnis";
          case '%' -> "mānsiōnis";
          default -> StringUtils.EMPTY;
        };

        short expectātus = 0;
        if (StringUtils.isNotBlank(labor)) {
          expectātus = switch (operātiō) {
            case '+' -> (short) (range.getMaximum() + range.getMinimum());
            case '-' -> (short) (range.getMaximum() - range.getMinimum());
            case '*' -> (short) (range.getMaximum() * range.getMinimum());
            case '/' -> (short) (range.getMaximum() / range.getMinimum());
            case '%' -> (short) (range.getMaximum() % range.getMinimum());
            default -> (short) 0;
          };
        }

        @NotNull final StrūctorVerba strūctor = StrūctorVerba.fac.get();
        @NotNull final VerbumSimplex.Numerus secundus = strūctor.numerus(range.getMinimum());
        new Tentāmiculum.TentāmiculumReī(secundus)
          .existat(String.format("Prōductā %s est relicta prōductiō numerī %d.", operātiō, range.getMinimum()));
        new Tentāmiculum.TentāmiculumVersiculī(secundus.toString())
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operātiō));

        final VerbumSimplex.Numerus ēventus = switch (operātiō) {
          case '+' -> prīmus.addō(secundus);
          case '-' -> prīmus.subtrahō(secundus);
          case '*' -> prīmus.multiplicō(secundus);
          case '/' -> prīmus.dīvidō(secundus);
          case '%' -> prīmus.maneō(secundus);
          default -> null;
        };

        new Tentāmiculum.TentāmiculumReī(ēventus)
          .existat(String.format("Prōductā %s est relicta prōductiō numerī %d.", operātiō, expectātus));
        new Tentāmiculum.TentāmiculumVersiculī(ēventus.toString())
          .aliamContineat(String.format("Numerum prōductum %s vacat.", operātiō));
        new Tentāmiculum.TentāmiculumNumerālis <>(expectātus, ēventus.numerus)
          .aequentur(String.format("Numerum prōductum %s expectātiōne eius differt.", operātiō));

        return String.format("%d = %s%n%d = %s%n%d %c %d = %d = %s",
                             range.getMaximum(), prīmus, range.getMinimum(), secundus,
                             range.getMaximum(), operātiō, range.getMinimum(), expectātus, ēventus);
      });
    }
  }
}
