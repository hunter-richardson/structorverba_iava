package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Genus {
  NŪLLUM(StringUtils.EMPTY),
  NEUTRUM("neutrum"),
  MASCULĪNUM("masculīnum"),
  FĒMINĪNUM("fēminīnum");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Genus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Genus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Genus dēfīniam(@NotNull final String scrīptiō, @Nullable final Genus dēfecta) {
    return Stream.of(values())
                 .filter(genus -> genus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Genus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Genus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Genus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Genus hoc = (Genus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
