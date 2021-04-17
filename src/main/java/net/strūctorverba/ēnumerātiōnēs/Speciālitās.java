package net.strūctorverba.ēnumerātiōnēs;

import lombok.Getter;
import net.strūctorverba.nūntiī.Nūntius;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;

import java.util.stream.Stream;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public enum Speciālitās {
  NŪLLUM(StringUtils.EMPTY),
  COMMŪNE("commūne"),
  PROPRIUM("proprium");

  @Getter(lazy = true)
  private static final @NotNull Nūntius.NūntiusErrōribus nūntius = Nūntius.NūntiusErrōribus.fac.get();

  public final @NotNull String scrīptiō;

  Speciālitās(@NotNull final String scrpt) {
    scrīptiō = scrpt;
  }

  public static @Nullable Speciālitās dēfīniam(@NotNull final String scrīptiō) {
    return dēfīniam(scrīptiō, null);
  }

  public static @Nullable Speciālitās dēfīniam(@NotNull final String scrīptiō, @Nullable final Speciālitās dēfecta) {
    return Stream.of(values())
                 .filter(speciālitās -> speciālitās.scrīptiō.equals(scrīptiō))
                 .findFirst().orElse(dēfecta);
  }

  public static @NotNull Speciālitās ut(@NotNull final Enum<@NotNull ?> illud, @NotNull final Speciālitās dēfecta) {
    try {
      return ut(illud);
    } catch (EnumConstantNotPresentException e) {
      getNūntius().terreō(e);
      return dēfecta;
    }
  }

  @SuppressWarnings("ConstantConditions")
  public static @NotNull Speciālitās ut(@NotNull final Enum<@NotNull ?> illud) throws EnumConstantNotPresentException {
    final Speciālitās hoc = (Speciālitās) illud;
    if(hoc.equals(illud)) {
      return hoc;
    } else {
      throw new EnumConstantNotPresentException(Cāsus.class, illud.name());
    }
  }
}
