package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Gradus {
  NŪLLUM(StringUtils.EMPTY),
  NŌRMĀlE("nōrmāle"),
  COMPARĀTĪVUM("comparātīvum"),
  SUPERLĀTĪVUM("superlātīvum");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Gradus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Gradus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Gradus dēfīniam(@NotNull final String scrīptiō, @Nullable final Gradus dēfecta) {
    return Stream.of(values())
                 .filter(gradus -> gradus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Gradus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Gradus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Gradus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Gradus hoc = (Gradus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
