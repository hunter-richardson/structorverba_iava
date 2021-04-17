package net.strūctorverba.tenōrēs;

import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.Verbum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.*;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.function.*;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class Tenor <Hoc extends Verbum <Hoc>> extends DefaultHandler {
  protected final  @NotNull Nūntius nūntius;
  protected       @Nullable Hoc     hoc;

  protected final @NotNull List <@NotNull Hoc> seriēs = new ArrayList <>();

  protected Tenor(@NotNull final Supplier <@NotNull ? extends Nūntius> nts) {
    nūntius = nts.get();
  }

  public final @Nullable Hoc referō(Predicate <@NotNull Hoc> quaesītiō) {
    return seriēs.stream().filter(quaesītiō)
                 .findFirst().orElse(null);
  }

  public final @Override void characters(final char[] littera, final int inceptus, final int longitia) {
    String fōrma = new String(littera, inceptus, longitia).trim();
    if(StringUtils.isNotBlank(fōrma)) {
      nūntius.garriō("Verbum illud est", fōrma);
      scrībō(fōrma);
      fīniam();
    } else {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    }
  }

  public @Nullable Hoc referō( ) {
    return hoc;
  }

  protected abstract void fīniam( );
  protected abstract void scrībō(@NotNull final String scrīptiō);
}
