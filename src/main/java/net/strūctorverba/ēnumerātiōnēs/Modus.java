package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Modus {
  NŪLLUM(StringUtils.EMPTY),
  INDICĀTĪVUM("indicātīvum"),
  SUBIŪNCTĪVUM("subiūnctīvum"),
  ĪNFĪNĪTĪVUM("īnfīnītīvum"),
  IMPERĀTĪVUM("imperātīvum"),
  PARTICIPIUM("participium");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Modus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Modus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Modus dēfīniam(@NotNull final String scrīptiō, @Nullable final Modus dēfecta) {
    return Stream.of(values())
                 .filter(modus -> modus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Modus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Modus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Modus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Modus hoc = (Modus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
