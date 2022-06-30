# Strūctor Verba : Iava  [![CodeFactor](https://codefactor.io/repository/github/hunter-richardson/structorverba_iava/badge)](https://www.codefactor.io/repository/github/hunter-richardson/structorverba_iava)

Verba Latīna scrībere tetendistisne sed coniugātiōnem āctārum hārum generemve nōminum illōrum nequīstis meminisse?

Nōn iam! Vōbīs intrōdūcō programma StrūctorVerba scrīptum in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis.

Programma hoc dēfīnit classēs novem quās catēgoriās novem verbōrum repraesentent:

I. [Coniunctivum](officia/src/main/java/com/structorverba/officia/verba/VerbumSimplex.java#L56)

II. [Interiectio](officia/src/main/java/com/structorverba/officia/verba/VerbumSimplex.java#L97)

III. [Praepositio](officia/src/main/java/com/structorverba/officia/verba/VerbumSimplex.java#L135)

IV. [Numerus](officia/src/main/java/com/structorverba/officia/verba/VerbumSimplex.java#L182)

V. [Adverbium](officia/src/main/java/com/structorverba/officia/verba/multiplicia/Adverbium.java)

VI. [Nomen](officia/src/main/java/com/structorverba/officia/verba/multiplicia/Nomen.java)

VII. [Pronomen](officia/src/main/java/com/structorverba/officia/verba/multiplicia/Pronomen.java)

VIII. [Adiectivum](officia/src/main/java/com/structorverba/officia/verba/multiplicia/Adiectivum.java)

IX. [Actus](officia/src/main/java/com/structorverba/officia/verba/multiplicia/Actus.java)

Omne quālitātēs ipsās prōpositaque ipsa habet et ligāmina illa vōs dūcent ut tabellās aptās perlēgātis.

___

Praetereā tentāmina quattuor sunt scrīpsī ut exsecūtiō modōsque programmātis recēnseantur.

I. [DolōremIpsum](officium/src/test/net/strūctorverba/tentāmina/DolōremIpsum.java)

II. [Carthāgō](officium/src/test/net/strūctorverba/tentāmina/Carthāgō.java)

III. [Exempla](officium/src/test/net/strūctorverba/tentāmina/Exempla.java)

IV. [Numerī](officium/src/test/net/strūctorverba/tentāmina/Numerī.java)

Valōrem [StructorVerba.faciendum](officia/src/main/java/com/structorverba/officia/miscella/StructorVerba.java#L32) invocāte ut fūnctiōnēs omnēs programmātis StrūctorVerba accēdātis:

```java
import net.structorverba.enumerationes.*;
import net.structorverba.miscella.StructorVerba;
import net.structorverba.verba.Verba;
import net.structorverba.verba.multiplicia.*;

@SuppressWarnings({ "ConstantConditions", "SpellCheckingInspection" })
class Tentamen {
  public void main(String[] args) {
    final StructorVerba structor = StructorVerba.faciendum.get();
    final Verba verba = structor.strue(
          structor.adveniam("ecce", Categoria.INTERIECTIO),
          structor.adveniam("lingua", Categoria.NOMEN,
                            Specialitas.COMMUNE, Genus.FEMININUM,
                            Casus.NOMINATIVUS, Numeralis.SINGULARIS),
          structor.adveniam("latīnum", Categoria.ADIECTIVUM,
                            Specialitas.PROPRIUM, Genus.FEMININUM,
                            Casus.NOMINATIVUS, Numeralis.SINGULARIS, Gradus.POSITIVUS),
          structor.adveniam("placēre", Catēgoria.ACTUM,
                            Modus.INDICATIVUS, Vōx.ACTIVA, Tempus.PRAESENS,
                            Numeralis.SINGULARIS, Persona.TERTIA),
 ((Actus) structor.adveniam("prōdesse", Categoria.ACTUM,
                            Modus.INDICATIVUS, Vōx.ACTIVA, Tempus.PRAESENS,
                            Numeralis.SINGULARIS, Persona.TERTIA))
                  .allego(Encliticum.CONIUGANS));
    System.out.println(verba); // Ecce lingua Latīna placet prōdestque
  }
}
```

Versiō simplificātus cōdicis superī est scrīptus in tentāmine [Exempla.prōducta](officia/src/test/java/com/structorverba/officia/Exempla.java#L28)

___

Significētur quod programma hoc per ipse officia lexicōnī dēest. Verba servat nōn dēfīnīre quam sōlum in formīs īnflexīs petītīs eōrum scrībere. Officia haec forsit aliquandō acquīrat in coniūnctiōne cum programmātis aliā quae fungitur ut lexicon. Autem experiendus modestē in linguā Latīnā iam est vōbīs ut ūsūfructuāriī competentēs programmātis StrūctorVerba.

Significētur etiam quod programma hoc cum ūsūfructuāriīs nōn congreditur in modīs sīve vīsuālite sīve scrīptile dum vicem īnfantiae praesertim adest. Iam scrīptum est ut bibliothēcula cōdicis. Officia haec forsit aliquandō acquīrat dum veterēscat autem experiendus modestē in linguā [Iavā](https://docs.oracle.com/javase/10/docs/api/overview-summary.html) cōdicis iam est vōbīs ut ūsūfructuāriī competentēs programmātis StrūctorVerba.

___

> Ingeniārius invenit problēmata quae ignōrābātis.
> 
> Ea vōbīs etiamtum solvat in modīs quōs vix intellegātis.
> 
> Vōbīs atque petet pecūniam quam nōn poteritis solvere.
