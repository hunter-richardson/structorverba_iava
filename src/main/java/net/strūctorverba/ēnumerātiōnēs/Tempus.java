package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Tempus {
  NŪLLUM(StringUtils.EMPTY),
  PRAESĒNS("praesēns"),
  INFECTUM("infectum"),
  FUTŪRUM("futūrum"),
  PERFECTUM("perfectum"),
  PLUPERFECTUM("plūperfectum"),
  PERFUTŪRUM("perfutūrum");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Tempus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Tempus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Tempus dēfīniam(@NotNull final String scrīptiō, @Nullable final Tempus dēfecta) {
    return Stream.of(values())
                 .filter(tempus -> tempus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Tempus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Tempus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Tempus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Tempus hoc = (Tempus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
