package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Numerāle {
  NŪLLUM(StringUtils.EMPTY),
  SINGULĀRE("singulāre"),
  PLŪRĀLE("plūrāle");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Numerāle(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Numerāle dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Numerāle dēfīniam(@NotNull final String scrīptiō, @Nullable final Numerāle dēfecta) {
    return Stream.of(values())
                 .filter(numerāle -> numerāle.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Numerāle ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Numerāle dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Numerāle ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Numerāle hoc = (Numerāle) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
