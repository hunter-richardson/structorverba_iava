# Strūctor Verba : Iava

Verba Latīna scrībere tetendistisne sed nōn potuistisne meminisse coniugātiōnem quam āctārum hārum aut generem nōminum illōrum?

Nōn iam! Vōbīs intrōdūcō programma StrūctorVerba scrīptum in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis.

Programma hoc dēfīnit classēs novem quās catēgoriās novem verbōrum repraesentent:

I. [Coniūnctīvum](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L46)

II. [Interiectiō](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L66)

III. [Praepositiō](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L82)

IV. [Numerus](src/main/java/net/strūctorverba/verba/VerbumSimplex.java#L106)

V. [Adverbium](src/main/java/net/strūctorverba/verba/multiplicia/Adverbium.java)

VI. [Nōmen](src/main/java/net/strūctorverba/verba/multiplicia/Nōmen.java)

VII. [Prōnōmen](src/main/java/net/strūctorverba/verba/multiplicia/Prōnōmen.java)

VIII. [Adiectīvum](src/main/java/net/strūctorverba/verba/multiplicia/Adiectīvum.java)

IX. [Āctum](src/main/java/net/strūctorverba/verba/multiplicia/Āctum.java)

Omne quālitātēs ipsās prōpositaque ipsa habet et ligāmina illa vōs dūcent ut tabellās aptās perlēgātis.

Praetereā tentāmina duo scrīpsī exsecūtiōnem modōsque programmātis recēnsēre.

I. [DolōremIpsum](src/main/test/net/strūctorverba/tentāmina/DolōremIpsum.java)

II. [Numerī](src/main/test/net/strūctorverba/tentāmina/Numerī.java)

Valōrem [StrūctorVerba.fac](src/main/java/net/strūctorverba/mīscella/StrūctorVerba.java#L28) invocāte ut fūnctiōnēs omnēs programmātis StrūctorVerba accēdātis:

```java
class Tentāmen {
  @SuppressWarning("ConstantConditions")
  private void main(String[] args) {
    final StrūctorVerba strūctor = StrūctorVerba.fac.get();
    final Verba verba = strūctor.strue(
      strūctor.adveniam("lingua", Catēgoria.NŌMEN,
                        Speciālitās.COMMŪNE, Genus.FĒMINĪNUM,
                        Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor.adveniam("Latīnus", Catēgoria.ADIECTĪVUM,
                        Speciālitās.PROPRIUM, Genus.FĒMINĪNUM,
                        Cāsus.NŌMINĀTĪVUS, Numerālis.SINGULĀRIS),
      strūctor.adveniam("plācēre", Catēgoria.ĀCTUM,
                        Modus.INDICĀTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS,
                        Numerālis.SINGULĀRIS, Persōna.TERTIA),
      strūctor.adveniam("prōdesse", Catēgoria.ĀCTUM,
                        Modus.ĪNFĪNĪTĪVUS, Vōx.ĀCTĪVA, Tempus.PRAESĒNS)
              .allegō(Encliticum.INTERRŌGANS);
    System.out.println(verba); // Lingua Latīna placet prōdestque
  }
}
```

Significētur quod programma hoc per ipse officia lexicōnī dēest. Verba servat nōn dēfīnīre quam sōlum in formīs īnflexīs petītīs eōrum scrībere. Officia haec forsit aliquandō acquīrat in coniūnctiōne cum programmātis aliā quā fungitur ut lexicon. Autem experiendus modestē in linguā Latīnā iam est vōbīs ut ūsūfructuāriī programmātis StrūctorVerbae.

Significētur etiam quod programma hoc cum ūsūfructuāriīs nōn congreditur in modīs sīve vīsuālite sīve scrīptile dum vicem īnfantiae praesertim adest. Iam scrīptum est ut bibliothēcula cōdicis. Officia haec forsit aliquandō acquīrat dum veterēscat 
autem experiendus modestē in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis iam est vōbīs ut ūsūfructuāriī programmātis StrūctorVerbae.

> Ingeniārius invenit problēmata quae ignōrābās.
> 
> Ea tibi etiamtum solvat in modīs quōs vix intellegās.
> 
> Tibi atque petet pecūniam quam nōn poteris solvere.
