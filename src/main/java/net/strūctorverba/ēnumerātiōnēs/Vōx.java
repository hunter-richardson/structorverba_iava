package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Vōx {
  NŪLLUM(StringUtils.EMPTY),
  ĀCTĪVUM("āctīvum"),
  PASSĪVUM("passīvum");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  final @NotNull String scrīptiō;

  Vōx(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Vōx dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Vōx dēfīniam(@NotNull final String scrīptiō, @Nullable final Vōx dēfecta) {
    return Stream.of(values())
                 .filter(vōx -> vōx.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Vōx ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Vōx dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Vōx ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Vōx hoc = (Vōx) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
