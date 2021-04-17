package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Cāsus {
  NŪLLUM(StringUtils.EMPTY),
  NŌMINĀTĪVUM("nōminātīvum"),
  GENITĪVUM("genitīvum"),
  DATĪVUM("datīvum"),
  ACCŪSĀTĪVUM("accūsātīvum"),
  ABLĀTĪVUM("ablātīvum"),
  VOCĀTĪVUM("vocātīvum"),
  LOCĀTĪVUM("locātīvum"),
  ĪNSTRŪMENTĀLE("īnstrūmentāle");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Cāsus(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }


  public static @Nullable Cāsus dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Cāsus dēfīniam(@NotNull final String scrīptiō, @Nullable final Cāsus dēfecta) {
    return Stream.of(values())
                 .filter(cāsus -> cāsus.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Cāsus ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Cāsus dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Cāsus ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Cāsus hoc = (Cāsus) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
