# Strūctor Verba : Iava  [![CodeFactor](https://codefactor.io/repository/github/hunter-richardson/structorverba_iava/badge)](https://www.codefactor.io/repository/github/hunter-richardson/structorverba_iava)

Verba Latīna scrībere tetendistisne sed coniugātiōnem āctārum hārum generemve nōminum illōrum nequīstis meminisse?

Nōn iam! Vōbīs intrōdūcō programma StrūctorVerba scrīptum in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis.

Programma hoc dēfīnit classēs novem quās catēgoriās novem verbōrum repraesentent:

I. [Coniūnctīvum](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L46)

II. [Interiectiō](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L67)

III. [Praepositiō](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L88)

IV. [Numerus](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L112)

V. [Adverbium](src/main/java/net/strūctorverba/verba/multiplicia/Adverbium.java)

VI. [Nōmen](src/main/java/net/strūctorverba/verba/multiplicia/Nōmen.java)

VII. [Prōnōmen](src/main/java/net/strūctorverba/verba/multiplicia/Prōnōmen.java)

VIII. [Adiectīvum](src/main/java/net/strūctorverba/verba/multiplicia/Adiectīvum.java)

IX. [Āctus](src/main/java/net/strūctorverba/verba/multiplicia/Āctus.java)

Omne quālitātēs ipsās prōpositaque ipsa habet et ligāmina illa vōs dūcent ut tabellās aptās perlēgātis.

___

Praetereā tentāmina tria sunt scrīpsī ut exsecūtiō modōsque programmātis recēnseantur.

I. [DolōremIpsum](src/main/test/net/strūctorverba/tentāmina/DolōremIpsum.java)

II. [Carthāgō](src/main/test/net/strūctorverba/tentāmina/Carthāgō.java)

III. [Exempla](src/main/test/net/strūctorverba/tentāmina/Exempla.java)

IV. [Numerī](src/main/test/net/strūctorverba/tentāmina/Numerī.java)

Valōrem [StrūctorVerba.fac](src/main/java/net/strūctorverba/mīscella/StrūctorVerba.java#L28) invocāte ut fūnctiōnēs omnēs programmātis StrūctorVerba accēdātis:

```java
import net.strūctorverba.ēnumerātiōnēs.*;
import net.strūctorverba.mīscella.StrūctorVerba;
import net.strūctorverba.verba.Verba;
import net.strūctorverba.verba.multiplicia.*;

class Tentāmen {
  @SuppressWarnings("ConstantConditions")
  public void main(String[] args) {
    final StrūctorVerba strūctor = StrūctorVerba.fac.get();
    final Verba verba = strūctor.strue(
          strūctor.adveniam("ecce", Catēgoria.INTERIECTIŌ),
          strūctor.adveniam("lingua", Catēgoria.NŌMEN,
                            Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                            Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
          strūctor.adveniam("latīnus", Catēgoria.ADIECTĪVUM,
                            Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                            Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS, Gradus.POSITĪVUS),
          strūctor.adveniam("plācēre", Catēgoria.ĀCTUM,
                            Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                            Numerālis.SINGULĀRIS, Persōna.TERTIA),
 ((Āctus) strūctor.adveniam("prōdesse", Catēgoria.ĀCTUM,
                            Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                            Numerālis.SINGULĀRIS, Persōna.TERTIA))
                  .allegō(Encliticum.CONIUGĀNS));
    System.out.println(verba); // Ecce lingua Latīna placet prōdestque
  }
}
```

Versiō simplificātus cōdicis superī est scrīptus in tentāmine [Exempla.prōducta](src/main/test/net/strūctorverba/tentāmina/Exempla.java#L26)

___

Significētur quod programma hoc per ipse officia lexicōnī dēest. Verba servat nōn dēfīnīre quam sōlum in formīs īnflexīs petītīs eōrum scrībere. Officia haec forsit aliquandō acquīrat in coniūnctiōne cum programmātis aliā quā fungitur ut lexicon. Autem experiendus modestē in linguā Latīnā iam est vōbīs ut ūsūfructuāriī competentēs programmātis StrūctorVerba.

Significētur etiam quod programma hoc cum ūsūfructuāriīs nōn congreditur in modīs sīve vīsuālite sīve scrīptile dum vicem īnfantiae praesertim adest. Iam scrīptum est ut bibliothēcula cōdicis. Officia haec forsit aliquandō acquīrat dum veterēscat autem experiendus modestē in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis iam est vōbīs ut ūsūfructuāriī competentēs programmātis StrūctorVerba.

___

> Ingeniārius invenit problēmata quae ignōrābātis.
> 
> Ea vōbīs etiamtum solvat in modīs quōs vix intellegātis.
> 
> Vōbīs atque petet pecūniam quam nōn poteritis solvere.
