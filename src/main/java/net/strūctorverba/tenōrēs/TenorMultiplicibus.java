package net.strūctorverba.tenōrēs;

import net.strūctorverba.conditōrēs.multiplicia.*;
import net.strūctorverba.nūntiī.Nūntius;
import net.strūctorverba.verba.multiplicia.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.*;
import org.xml.sax.Attributes;

import javax.ejb.*;
import java.util.Objects;
import java.util.function.Supplier;

@SuppressWarnings({ "NonAsciiCharacters", "SpellCheckingInspection" })
public abstract class TenorMultiplicibus <Hoc extends VerbumMultiplex <Hoc>> extends Tenor <Hoc> {
  protected final @NotNull ConditōrMultiplicibus <Hoc> condītōr;

  protected TenorMultiplicibus(@NotNull final Supplier <? extends Nūntius> nūntius,
                               @NotNull final Supplier <@NotNull ? extends ConditōrMultiplicibus <Hoc>> cndtr) {
    super(nūntius);
    condītōr = cndtr.get();
  }

  public final @Override void startElement(@NotNull final String nōmen, @NotNull final String locus,
                           @NotNull final String quālis, @NotNull final Attributes attribūta) {
    for (int i = 0; i < attribūta.getLength(); i++) {
      nūntius.garriō("Teneō adicere attribūtum novum:",
                     attribūta.getLocalName(i), "est", attribūta.getValue(i));
      condītōr.allegō(attribūta.getLocalName(i), attribūta.getValue(i));
    }
  }

  public final @Override void endElement(@NotNull final String nōmen, @NotNull final String locus, @NotNull final String quālis) {
    condītōr.restituō();
  }

  protected final @Override void fīniam( ) {
    hoc = condītōr.condam();
    if (Objects.isNull(hoc)) {
      nūntius.moneō("Prōductiō verbī prōcessimus nūllae fōrmae.");
    } else {
      nūntius.garriō("Aggregāvī verbum novum", hoc);
      seriēs.add(hoc);
    }
  }

  protected @Override void scrībō(@NotNull String scrīptiō) {
    condītōr.ut(scrīptiō);
  }

  @Singleton @DependsOn({ "CondītōrNōminibus", "NūntiusTenōrīNōminibus" })
  public static final class TenorNōminibus extends TenorMultiplicibus <Nōmen> {
    private static @Nullable TenorNōminibus īnstantia = null;

    public static @NotNull final Supplier <TenorNōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorNōminibus());

    private TenorNōminibus( ) {
      super(Nūntius.NūntiusTenōrīNōminibus.fac, ConditōrNōminibus.fac);
    }
  }

  @Singleton @DependsOn({ "CondītōrAdiectīvīs", "NūntiusTenōrīAdiectīvīs" })
  public static final class TenorAdiectīvīs extends TenorMultiplicibus <Adiectīvum> {
    private static @Nullable TenorAdiectīvīs īnstantia = null;

    public static @NotNull final Supplier <TenorAdiectīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorAdiectīvīs());

    private TenorAdiectīvīs( ) {
      super(Nūntius.NūntiusTenōrīAdiectīvīs.fac, ConditōrAdiectīvīs.fac);
    }
  }

  @Singleton @DependsOn({ "CondītōrPrōnōminibus", "NūntiusTenōrīPrōnōminibus" })
  public static final class TenorPrōnōminibus extends TenorMultiplicibus <Prōnōmen> {
    private static @Nullable TenorPrōnōminibus īnstantia = null;

    public static @NotNull final Supplier <TenorPrōnōminibus> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorPrōnōminibus());

    private TenorPrōnōminibus( ) {
      super(Nūntius.NūntiusTenōrīPrōnōminibus.fac, ConditōrPrōnōminibus.fac);
    }
  }

  @Singleton @DependsOn({ "CondītōrPrōnōminiusConiūnctīvīs", "NūntiusTenōrīPrōnōmibusConiūnctīvīs" })
  public static final class TenorPrōnōminibusConiūnctīvīs extends TenorMultiplicibus <PrōnōmenConiūnctīvum> {
    private static @Nullable TenorPrōnōminibusConiūnctīvīs īnstantia = null;

    public static @NotNull final Supplier <TenorPrōnōminibusConiūnctīvīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorPrōnōminibusConiūnctīvīs());

    private TenorPrōnōminibusConiūnctīvīs( ) {
      super(Nūntius.NūntiusTenōrīPrōnōmibusConiūnctīvīs.fac, ConditōrPrōnōminibusConiūnctīvīs.fac);
    }
  }

  @Singleton @DependsOn({ "CondītōrĀctīs", "NūntiusTenōrīĀctīs" })
  public static final class TenorĀctīs extends TenorMultiplicibus <Āctum> {
    private static @Nullable TenorĀctīs īnstantia = null;

    public static @NotNull final Supplier <TenorĀctīs> fac =
      () -> ObjectUtils.firstNonNull(īnstantia, īnstantia = new TenorĀctīs());

    private TenorĀctīs( ) {
      super(Nūntius.NūntiusTenōrīĀctīs.fac, ConditōrĀctīs.fac);
    }
  }
}
