package net.strūctorverba.verba;

import net.strūctorverba.verba.disposita.Verba;
import org.jetbrains.annotations.*;

import java.util.LinkedList;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection", "unused" })
public interface Coniugiāle {
  <Illud extends Verbum <Illud>> @NotNull LinkedList <Verbum <@Nullable ?>> coniugō(@Nullable final Illud prīma, @Nullable final Illud secunda);
  @NotNull Verba coniugō(@NotNull final Verba prīma, @NotNull final Verba secunda);
  @NotNull Verba coniugō(@NotNull final Verba prīma, @NotNull final LinkedList <Verbum <@Nullable ?>> secunda);
  @Override @NotNull String toString( );
}
