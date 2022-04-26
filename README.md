# Strūctor Verba : Iava  [![CodeFactor](https://codefactor.io/repository/github/hunter-richardson/structorverba_iava/badge)](https://www.codefactor.io/repository/github/hunter-richardson/structorverba_iava)

Verba Latīna scrībere tetendistisne sed coniugātiōnem āctārum hārum generemve nōminum illōrum nequīstis meminisse?

Nōn iam! Vōbīs intrōdūcō programma StrūctorVerba scrīptum in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis.

Programma hoc dēfīnit classēs novem quās catēgoriās novem verbōrum repraesentent:

I. [Coniūnctīvum](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/VerbumSimplex.java#L46)

II. [Interiectiō](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/VerbumSimplex.java#L67)

III. [Praepositiō](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/VerbumSimplex.java#L88)

IV. [Numerus](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/VerbumSimplex.java#L112)

V. [Adverbium](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/multiplicia/Adverbium.java)

VI. [Nōmen](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/multiplicia/Nomen.java)

VII. [Prōnōmen](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/multiplicia/Pronomen.java)

VIII. [Adiectīvum](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/multiplicia/Adiectivum.java)

IX. [Āctus](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/verba/multiplicia/Actus.java)

Omne quālitātēs ipsās prōpositaque ipsa habet et ligāmina illa vōs dūcent ut tabellās aptās perlēgātis.

___

Praetereā tentāmina quattuor sunt scrīpsī ut exsecūtiō modōsque programmātis recēnseantur.

I. [DolōremIpsum](structorverba-lib/src/test/net/strūctorverba/tentāmina/DolōremIpsum.java)

II. [Carthāgō](structorverba-lib/src/test/net/strūctorverba/tentāmina/Carthāgō.java)

III. [Exempla](structorverba-lib/src/test/net/strūctorverba/tentāmina/Exempla.java)

IV. [Numerī](structorverba-lib/src/test/net/strūctorverba/tentāmina/Numerī.java)

Valōrem [StrūctorVerba.fac](structorverba-lib/src/main/java/java/net/structorverba/bibliotheca/miscella/StructorVerba.java#L28) invocāte ut fūnctiōnēs omnēs programmātis StrūctorVerba accēdātis:

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
          strūctor.adveniam("latīnum", Catēgoria.ADIECTĪVUM,
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

Versiō simplificātus cōdicis superī est scrīptus in tentāmine [Exempla.prōducta](structorverba-lib/src/test/net/strūctorverba/tentāmina/Exempla.java#L26)

___

Significētur quod programma hoc per ipse officia lexicōnī dēest. Verba servat nōn dēfīnīre quam sōlum in formīs īnflexīs petītīs eōrum scrībere. Officia haec forsit aliquandō acquīrat in coniūnctiōne cum programmātis aliā quae fungitur ut lexicon. Autem experiendus modestē in linguā Latīnā iam est vōbīs ut ūsūfructuāriī competentēs programmātis StrūctorVerba.

Significētur etiam quod programma hoc cum ūsūfructuāriīs nōn congreditur in modīs sīve vīsuālite sīve scrīptile dum vicem īnfantiae praesertim adest. Iam scrīptum est ut bibliothēcula cōdicis. Officia haec forsit aliquandō acquīrat dum veterēscat autem experiendus modestē in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis iam est vōbīs ut ūsūfructuāriī competentēs programmātis StrūctorVerba.

___

> Ingeniārius invenit problēmata quae ignōrābātis.
> 
> Ea vōbīs etiamtum solvat in modīs quōs vix intellegātis.
> 
> Vōbīs atque petet pecūniam quam nōn poteritis solvere.
