/**
 * 
 */
package system.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ontology.CBR.Case;
import ontology.common.Descriptor;
import ontology.common.MeasuringUnit;
import ontology.common.RVCharacterDescriptor;
import ontology.common.RVHeuristicDescriptor;
import ontology.common.RangeValue;
import ontology.common.SSCharacterDescriptor;
import ontology.common.SSHeuristicDescriptor;
import ontology.common.SVCharacterDescriptor;
import ontology.common.SVHeuristicDescriptor;
import ontology.common.SingleValue;
import ontology.taxonomy.Modifier;
import ontology.taxonomy.Taxon;
import ontology.taxonomy.TaxonomicRank;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import system.OracleIDSystem;
import system.Reasoner;

/**
 * @author Armando
 *
 */
public class ReasonerTest {
	private static system.OracleIDSystem oracleIDSystem;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando pruebas para la clase " + Reasoner.class.getName());
		Taxon taxon1, taxon2, taxon3, taxon4, taxon5, taxon6, taxon7, taxon8;

		oracleIDSystem = OracleIDSystem.getInstance();
		
		Taxon rootTaxon = new Taxon(TaxonomicRank.ROOT, null);
		
		oracleIDSystem.getTaxonomy().setRootTaxon(rootTaxon);
        
		//-----------------------Taxon No. 1---------------------
        taxon1 = new Taxon(TaxonomicRank.FAMILY, "Chromodorididae");
        //-----------------------Structure No. 1---------------------
        taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alargado"),
                new Modifier(1.0,1.0,0.8));
  		taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Ovalado"),
  		        new Modifier(1.0,1.0,0.1));
  		taxon1.addToDescription(new RVCharacterDescriptor("Cuerpo","Longitud", new RangeValue(0.3, 4.0,
  				MeasuringUnit.CM)), new Modifier(1.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","Tiene cerata"),
  		        new Modifier(1.0,1.0,1.0));
  		//-----------------------Structure No. 2---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Pie","Disposici�n","Sobresale al manto"),
  		        new Modifier(0.8,1.0,0.8));
  		taxon1.addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n","Blanquecino"),
  		        new Modifier(0.8,1.0,0.7));
  		taxon1.addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n","Crema"),
  		        new Modifier(0.8,1.0,0.7));
  		taxon1.addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n","Gris oscuro casi negro"),
  		        new Modifier(0.8,1.0,0.2));
  		//-----------------------Structure No. 3---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Posici�n durante desplazamiento",
  				"Hacia atr�s"), new Modifier(0.8,1.0,0.8));
  		taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Posici�n del ano con respecto a la " +
  				"branquia","En el centro"), new Modifier(0.8,1.0,0.8));
  		taxon1.addToDescription(new RVCharacterDescriptor("Branquia","N�mero hojas branquiales",
  				new RangeValue(6.0, 9.0)), new Modifier(0.8,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales","Bipinnada"),
  		        new Modifier(0.8,1.0,0.6));
  		taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales","Tripinnada"),
  		        new Modifier(0.8,1.0,0.4));
  		//-----------------------Structure No. 4---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Manto","Textura","Lisa"),
  		        new Modifier(1.0,1.0,0.8));
  		taxon1.addToDescription(new SSCharacterDescriptor("Manto","Textura","Con tuberculos"),
  		        new Modifier(1.0,1.0,0.4));
  		taxon1.addToDescription(new SSCharacterDescriptor("Manto","Forma del borde","Ondulado"),
  		        new Modifier(1.0,1.0,0.3));
  		taxon1.addToDescription(new SSCharacterDescriptor("Manto","Textura del borde","Lisa"),
  		        new Modifier(1.0,1.0,0.7));
  		//-----------------------Structure No. 5---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Posici�n","Delante"),
  		        new Modifier(1.0,1.0,0.2));
  		taxon1.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Posici�n",
  				"Delante y atras"), new Modifier(1.0,1.0,0.2));
  		taxon1.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Posici�n",
  				"Alrededor del manto"), new Modifier(1.0,1.0,0.4));
  		//-----------------------Structure No. 6---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Rinoforos","Forma","Laminados"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon1.addToDescription(new RVCharacterDescriptor("Rinoforos","N�mero de laminillas",
  				new RangeValue(6.0, 20.0)), new Modifier(1.0,1.0,1.0));
  		//-----------------------Structure No. 7---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Tent�culos orales","Contextura","Macizo"),
  		        new Modifier(1.0,1.0,0.7));
  		taxon1.addToDescription(new SSCharacterDescriptor("Tent�culos orales","Contextura","Surcado"),
  		        new Modifier(1.0,1.0,0.2));
  		//-----------------------Grouping Heuristic No. 1---------------------
  		taxon1.addToDescription(new SSHeuristicDescriptor("Factor bi�tico", "Alimentaci�n","Esponjas"),
  		        new Modifier(1.0,1.0,1.0));
  		//-----------------------Grouping Heuristic No. 2---------------------
  		taxon1.addToDescription(new RVHeuristicDescriptor("Factor abi�tico",
  				"Profundidad donde se encuentra", new RangeValue(0.0, 20.0, MeasuringUnit.M)),
  				new Modifier(1.0,1.0,1.0));
  		//-----------------------Grouping Heuristic No. 3---------------------
  		taxon1.addToDescription(new SSHeuristicDescriptor("Factor abi�tico",
  				"Medio de preservacion tenido","Azul marino"), new Modifier(1.0,1.0,1.0));
  		taxon1.addToDescription(new SSHeuristicDescriptor("Factor abi�tico",
  				"Medio de preservacion tenido","Celeste"), new Modifier(1.0,1.0,0.8));
  		taxon1.addToDescription(new SSHeuristicDescriptor("Factor abi�tico",
  				"Medio de preservacion tenido","Amarillento"), new Modifier(1.0,1.0,0.2));
//-----------------------Taxon No. 2---------------------
	    taxon2 = new Taxon(TaxonomicRank.GENUS, "Chromodoris");
	    //-----------------------Structure No. 1---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Posici�n de la banda dorsal " +
	      		"continua", "Centro"), new Modifier(1.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Brillante azul rojo " +
	      		"blanco anaranjado purpura"), new Modifier(1.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma ventral","Aplanado"),
	                  new Modifier(1.0,1.0,0.6));
	    //-----------------------Structure No. 2---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Manto","Forma","Elongado y ovalado"),
	              new Modifier(0.8,1.0,0.7));
	    taxon2.addToDescription(new SSCharacterDescriptor("Manto","Contextura","Con gl�ndulas"),
	                  new Modifier(0.8,1.0,0.8));
	    //-----------------------Structure No. 3---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Radula","Forma de los dientes","Denticulados"),
	              new Modifier(0.3,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Radula","Posici�n del diente m�s conspicuo",
	    		  "Centro"), new Modifier(0.3,1.0,0.5));
//-----------------------Taxon No. 3---------------------
	    taxon3 = new Taxon(TaxonomicRank.SPECIES, "Chromodoris sphoni");
	    //-----------------------Structure No. 1---------------------
	    taxon3.addToDescription(new RVCharacterDescriptor("Cuerpo","Longitud", new RangeValue(0.3, 0.35,
  				MeasuringUnit.CM)), new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Ovalado"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","No tiene tuberculos ni espiculas"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Verde fosforescente"),
  		        new Modifier(0.0,1.0,0.8));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Caf� rojizo"),
  		        new Modifier(0.0,1.0,0.8));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fonfo","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fonfo","Crema"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Contextura","Lisa"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales","Unipinnada"),
	        new Modifier(0.9,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","Blanco"),
		        new Modifier(0.9,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","Blanquecino"),
		        new Modifier(0.9,1.0,0.9));
	    taxon3.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Morado"),
		        new Modifier(0.9,1.0,1.0));
	    //-----------------------Structure No. 3---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del patron de rayas en forma de cruz","Rojo violaceo"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del patron de rayas en forma de cruz","Granate"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de puntos conspicuos","Amarillo"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea exterior del borde","Naranja"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea interior del borde","Rojo violaceo"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de los puntos irregulares localizados entre las l�neas del borde","Amarillo oro"),
  		        new Modifier(1.0,1.0,1.0));
  		//-----------------------Structure No. 4---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Blanco"),
  		        new Modifier(0.9,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Blanquecino"),
  		        new Modifier(0.9,1.0,0.9));
  		taxon3.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de los �pices","Morado"),
  		        new Modifier(0.9,1.0,1.0));
  		//-----------------------Structure No. 5---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n","Violaceo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n","Blanco"),
  		        new Modifier(0.0,1.0,0.9));
  		taxon3.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n","Crema"),
  		        new Modifier(0.0,1.0,0.9));
  		taxon3.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n del borde","Verde azulado moteado de amarillo"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 6---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n","Blanco hialino"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n del borde","Blanco opaco"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 7---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Aparato genital","Tama�o de la gl�ndula vestibular",
  				"Peque�o"), new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 4---------------------
	    taxon4 = new Taxon(TaxonomicRank.SPECIES, "Chromodoris clenchi");
	    //-----------------------Structure No. 1---------------------
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Rojo"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Rojizo"),
  		        new Modifier(0.0,1.0,0.8));
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Cafesuzco"),
  		        new Modifier(0.0,1.0,0.5));
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Blanquecino"),
  		        new Modifier(0.0,1.0,0.1));
	    //-----------------------Structure No. 2---------------------
  		taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de numerosas manchas","Blanco con borde amarillento"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea exterior del borde","Rojizo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Manto","Visibilidad l�nea exterior del borde cuando muerto","Ninguna"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 4---------------------
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de dos manchas localizadas en el centro","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Visibilidad de dos manchas localizadas en el centro cuando muerto","Ninguna"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de la base","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de los apices","Rojo purpura"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de los apices","Blanco"),
  		        new Modifier(0.0,1.0,0.1));
//-----------------------Taxon No. 5---------------------
	    taxon5 = new Taxon(TaxonomicRank.SPECIES, "Chromodoris kempfi");
	    //-----------------------Structure No. 1---------------------
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Amarillo brillante"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Crema blanquecino"),
  		        new Modifier(1.0,1.0,0.1));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Verde azulado"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Verde grisaceo"),
  		        new Modifier(1.0,1.0,0.1));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de la banda dorsal continua","Blanco"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de las manchas","Azul oscuro"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de las manchas","Negro"),
  		        new Modifier(1.0,1.0,0.8));
  		taxon5.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de las manchas","Celeste"),
  		        new Modifier(1.0,1.0,0.5));
  		//-----------------------Structure No. 2---------------------
  		taxon5.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Purpura"),
  		        new Modifier(0.8,1.0,0.8));
  		taxon5.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","De azul a purpura"),
  		        new Modifier(0.8,1.0,1.0));
  		taxon5.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Celeste p�lido"),
  		        new Modifier(0.8,1.0,0.5));
  		//-----------------------Structure No. 3---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","Purpura"),
		        new Modifier(0.8,1.0,0.8));
	    taxon5.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","De azul a purpura"),
		        new Modifier(0.8,1.0,1.0));
	    taxon5.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","Celeste p�lido"),
		        new Modifier(0.8,1.0,0.5));
	    
	    oracleIDSystem.getTaxonomy().addTaxon(taxon1, oracleIDSystem.getTaxonomy().getRootTaxon());
	    oracleIDSystem.getTaxonomy().addTaxon(taxon2, taxon1);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon3, taxon2);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon4, taxon2);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon5, taxon2);

	  //-----------------------Taxon No. 6---------------------
	    taxon1 = new Taxon(TaxonomicRank.GENUS, "Cadlina");
	    //-----------------------Structure No. 1---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Manto","Consistencia","Firme"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Manto","Contextura","Cubierto de espiculas con peque�os tuberculos"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 2---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Tama�o","Grandes en proporci�n al cuerpo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Disposici�n",
  				"Rodean completamente al manto"), new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 3---------------------
	    taxon1.addToDescription(new SSCharacterDescriptor("Radula","Forma del diente central","Denticulado"),
	            new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 7---------------------
	    taxon2 = new Taxon(TaxonomicRank.SPECIES, "Cadlina sparsa");
	    //-----------------------Structure No. 1---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Salm�n"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Amarillento"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon2.addToDescription(new RVCharacterDescriptor("Cuerpo","Longitud", new RangeValue(1.0, 3.6,
  				MeasuringUnit.CM)), new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de peque�as manchas laterales","Amarillo"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 3---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","Blancuzco"),
		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 4---------------------
  		taxon2.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Blancuzco"),
  		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 8---------------------
	    taxon3 = new Taxon(TaxonomicRank.GENUS, "Hypselodoris");
	    //-----------------------Structure No. 1---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Abultado dorsalmente"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Manto","Forma","Angosto"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 3---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Localizaci�n","A lo largo del manto"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Disposici�n",
  				"Rodean completamente al manto"), new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 4---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Branquia","Disposici�n","Forman un circulo alrededor del ano"),
		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 5---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Radula","Conformaci�n","No tiene diente central"),
	            new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 9---------------------
	    taxon4 = new Taxon(TaxonomicRank.SPECIES, "Hypselodoris agassizii");
	    //-----------------------Structure No. 1---------------------
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Azul negruzco"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Celeste claro"),
  		        new Modifier(0.0,1.0,0.9));
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n de numerosas manchas","Blanco y amarillo"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new RVCharacterDescriptor("Cuerpo","Longitud", new RangeValue(0.3, 0.38,
  				MeasuringUnit.CM)), new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
	    taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de las marcas ovaladas","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea exterior del borde","Amarillo"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea exterior del borde","Amarillo p�lido"),
  		        new Modifier(0.0,1.0,0.8));
	    taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n linea media del borde","Azul marino a negro"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea interior del borde","Verde claro"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 3---------------------
	    taxon4.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n hojas branquiales","Crema amarillento"),
		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n hojas branquiales","Blanco opaco"),
		        new Modifier(0.0,1.0,0.7));
	    taxon4.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Azul oscuro a negro"),
		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Celeste claro"),
		        new Modifier(0.0,1.0,0.6));
	    //-----------------------Structure No. 4---------------------
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Negro"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Celeste claro"),
  		        new Modifier(0.0,1.0,0.6));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n del raquis","Amarillo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon4.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n del raquis","Blanco"),
  		        new Modifier(0.0,1.0,0.6));
//-----------------------Taxon No. 10---------------------
	    taxon5 = new Taxon(TaxonomicRank.GENUS, "Glossodoris");
	    //-----------------------Structure No. 1---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Cuerpo","Alto","Considerable"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Manto","Forma","Plegado"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 3---------------------
  		taxon5.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Disposici�n",
  				"Forman un circulo alrededor del ano"), new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 4---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Branquia","Movimiento hojas branquiales durante desplazamiento","Ritmico"),
		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 4---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Vagina","Forma","Angosta"),
		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 11---------------------
	    taxon6 = new Taxon(TaxonomicRank.SPECIES, "Glossodoris dalli");
	//-----------------------Structure No. 1---------------------
	    taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alargado"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Ovalado"),
	            new Modifier(0.0,1.0,0.95));
	    taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Consistencia","Rigida"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","No tiene espiculas"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Blanco"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Gris claro"),
	            new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Forma numerosos tuberculos peque�os","Redondeado"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de manchas de diferentes tama�os y disposici�n irregular","Pardo"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de manchas de diferentes tama�os y disposici�n irregular","Negro"),
	            new Modifier(0.0,1.0,0.9));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de los puntos","Crema"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de los puntos","Naranja"),
	            new Modifier(0.0,1.0,0.9));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de los puntos","Rojo"),
	            new Modifier(0.0,1.0,0.9));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de banda submarginal rodeada de fina l�nea trasl�cida","Rojo"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de banda que contiene hilera de gl�ndulas","Blanco"),
	            new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 3---------------------
	    taxon6.addToDescription(new SSCharacterDescriptor("Cola","Tama�o","Largo"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Cola","Disposici�n","Sobresale claramente por detras del notum"),
	            new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 4---------------------
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales","Unipinnada"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Disposicion hojas branquiales","Forman un arco alrededor del ano"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Movimiento Hojas branquiales durante desplazamiento","Ritmico"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Tama�o Hojas branquiales posteriores con respecto a las anteriores","M�s peque�as"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n hojas branquiales","Blanco"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Rojo"),
	            new Modifier(0.0,1.0,1.0));
	    taxon6.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Blanco"),
	            new Modifier(0.0,1.0,0.9));
	//-----------------------Structure No. 5---------------------
	    taxon6.addToDescription(new SSCharacterDescriptor("Aparato genital","Conformaci�n","Tiene gl�ndula vestibular"),
	            new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 12---------------------
	    taxon7 = new Taxon(TaxonomicRank.SPECIES, "Glossodoris sedna");
	    //-----------------------Structure No. 1---------------------
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alargado"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Ovalado"),
  		        new Modifier(0.0,1.0,0.95));
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","No tiene espiculas"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Blanco hueso"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Contextura","Lisa"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Forma","Fuertemente ondulado"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Amarillo"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Posici�n de la fila de gl�ndulas subepiteliales " +
	    		"cuando fijado","A lo largo del borde"), new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea exterior del borde","Amarillo"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n linea media del borde","Rojo"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea interior del borde","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 3---------------------
  		taxon7.addToDescription(new SSCharacterDescriptor("Cola","Disposici�n","Sobresale claramente por detr�s del notum"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon7.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n l�nea exterior del borde","Amarillo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon7.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n linea media del borde","Rojo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon7.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n l�nea interior del borde","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 4---------------------
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales","Unipinnada"),
		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Disposici�n hojas branquiales","Forman un arco alrededor del ano"),
		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Movimiento hojas branquiales durante desplazamiento","Ritmico"),
		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Tama�o hojas branquiales posteriores con respecto a las anteriores","M�s peque�as"),
		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n hojas branquiales","Blanco hueso a trasl�cido"),
		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Rojo"),
		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Blanco"),
		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 5---------------------
  		taxon7.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Blanco hueso a trasl�cido"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon7.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de los �pices","Rojo"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 6---------------------
  		taxon7.addToDescription(new SSCharacterDescriptor("Aparato genital","conformacion",
  				"Tiene gl�ndula vestibular"), new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 13---------------------
	    taxon8 = new Taxon(TaxonomicRank.GENUS, "Mexichromis");
	//-----------------------Structure No. 1---------------------
        taxon8.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Disposici�n","Posteriormente unas pocas y grandes"),
        		new Modifier(0.0,1.0,1.0));
        taxon8.addToDescription(new SSCharacterDescriptor("Gl�ndulas del manto","Disposici�n","Lateralmente unas pocas y peque�as"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 2---------------------
        taxon8.addToDescription(new SSCharacterDescriptor("Aparato genital","Forma de la Glandula Vestibular","Ramificada"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 3---------------------
        taxon8.addToDescription(new SSCharacterDescriptor("Radula","Forma de los dientes","Bicuspidos y denticulados"),
        		new Modifier(0.0,1.0,1.0));   	    
	    
	    oracleIDSystem.getTaxonomy().addTaxon(taxon1, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Chromodorididae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon2, taxon1);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon3, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Chromodorididae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon4, taxon3);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon5, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Chromodorididae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon6, taxon5);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon7, taxon5);
	    oracleIDSystem.getTaxonomy().addTaxon(taxon8, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Chromodorididae"));
	    
	  //-----------------------Taxon No. 14---------------------
	    taxon1 = new Taxon(TaxonomicRank.SPECIES, "Mexichromis antonii");
	    //-----------------------Structure No. 1---------------------
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alargado"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","No tiene tuberculos ni espiculas"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Azul p�lido"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Rinoforos","Forma","C�nico multilaminado"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n","Gris rojizo"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de los �pices","Negro"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 3---------------------
	    taxon1.addToDescription(new RVCharacterDescriptor("Branquia","N�mero hojas branquiales",new RangeValue(6, 7)),
		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales","Unipinnada"),
		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n","Gris rojizo"),
		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices","Negro"),
		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 4---------------------
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Textura","Lisa"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Forma del borde","Estrecho"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea exterior del borde","Amarillo naranja"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea interior del borde","Azul oscuro a negro"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea interrumpida en el centro","Blanco"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n �rea circundante de l�nea interrumpida en el centro",
	    		"Gris rojizo"), new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Manto","Disposici�n l�nea interrumpida en el centro","Desde los rinoforos hacia la branquia"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 5---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n","Azul oscuro a negro"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n de la mancha en forma de V","Azul p�lido"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n base de la mancha en forma de V","Naranja"),
  		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 15-------------------
	    taxon2 = new Taxon(TaxonomicRank.FAMILY, "Aplysiidae");
	//-----------------------Structure No. 1---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Consistencia","Voluminoso"),
	            new Modifier(0.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Textura de la superficie","Lisa"),
	            new Modifier(0.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","Tiene una concha interna"),
	            new Modifier(0.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Verduzco"),
	            new Modifier(0.0,1.0,0.9));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Grisaceo"),
	            new Modifier(0.0,1.0,0.85));
	    taxon2.addToDescription(new RVCharacterDescriptor("Cuerpo","Longitud",new RangeValue(0.5, 25.0,
	  			MeasuringUnit.CM)), new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
        taxon2.addToDescription(new SSCharacterDescriptor("Parapodio","Grado de desarrollo","Mucho"),
        		new Modifier(0.0,1.0,1.0));
        taxon2.addToDescription(new SSCharacterDescriptor("Parapodio","Simetr�a","Sim�trico o asim�trico"),
        		new Modifier(0.0,1.0,1.0));
        taxon2.addToDescription(new SSCharacterDescriptor("Parapodio","Tiene movilidad","Si"),
        		new Modifier(0.0,1.0,1.0));
        taxon2.addToDescription(new SSCharacterDescriptor("Parapodio","Tiene movilidad","No"),
        		new Modifier(0.0,1.0,0.0));
    //-----------------------Structure No. 3---------------------
        taxon2.addToDescription(new SSCharacterDescriptor("Pene","Conformaci�n","Tiene espinas"),
        		new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 16---------------------
	    taxon3 = new Taxon(TaxonomicRank.GENUS, "Dolabrifera");
	    //-----------------------Structure No. 1---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Aplanado dorsoventralmente"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma de las papilas","Ramificada"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma de las papilas","Simple"),
  		        new Modifier(0.0,1.0,1.0));
	    //-----------------------Structure No. 2---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Pie","Ancho","Mismo que el cuerpo"),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 3---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Parapodio","Disposici�n","Asim�trica y reducida"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon3.addToDescription(new RVCharacterDescriptor("Parapodio","N�mero de aberturas en la cavidad paleal",new RangeValue(2, 10)),
  		        new Modifier(0.0,1.0,1.0));
  		//-----------------------Structure No. 4---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Concha interna","Aspecto","Lamina peque�a y fr�gil"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Concha interna","Disposici�n","M�s larga que ancha rodeada por el manto totalmente"),
  		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 17---------------------
	    taxon4 = new Taxon(TaxonomicRank.GENUS, "Aplysiia");
	//-----------------------Structure No. 1---------------------
        taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alto alargado y contractil"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 2---------------------
        taxon4.addToDescription(new SSCharacterDescriptor("Concha interna","Aspecto","Delgada y trasl�cida"),
        		new Modifier(0.0,1.0,1.0));
        taxon4.addToDescription(new SSCharacterDescriptor("Concha interna","Disposicion","Envuelta por un l�bulo del manto"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 3---------------------
        taxon4.addToDescription(new SSCharacterDescriptor("Parapodio","Simetr�a","Sim�tricos libres"),
        		new Modifier(0.0,1.0,1.0));
        taxon4.addToDescription(new SSCharacterDescriptor("Parapodio","Simetr�a","Fusionados"),
        		new Modifier(0.0,1.0,0.9));
    //-----------------------Structure No. 4---------------------
        taxon4.addToDescription(new SSCharacterDescriptor("Tent�culos orales","Forma","Anchos en la parte final"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 5---------------------
        taxon4.addToDescription(new SSCharacterDescriptor("Pie","Forma","Relativamente ancho"),
        		new Modifier(0.0,1.0,1.0));
        taxon4.addToDescription(new SSCharacterDescriptor("Pie","Prolongaci�n","Forma una cola corta"),
        		new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 18---------------------
	    taxon5 = new Taxon(TaxonomicRank.GENUS, "Petalifera");
	//-----------------------Structure No. 1---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Cuerpo","Tama�o","Generalmente m�s peque�as que las dolabriferas aplisias y notarchus"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
  		taxon5.addToDescription(new SSCharacterDescriptor("Parapodio","Simetr�a","Asimetricos y reducidos el derecho m�s desarrollado"),
  		        new Modifier(0.0,1.0,1.0));
  	//-----------------------Structure No. 3---------------------
  		taxon5.addToDescription(new SSCharacterDescriptor("Dorso","Contextura","Lisa con papilas m�s o menos ramificadas"),
  		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 19---------------------
	    taxon6 = new Taxon(TaxonomicRank.GENUS, "Notarchus");
	//-----------------------Structure No. 1---------------------
        taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alto y globoso"),
        		new Modifier(0.0,1.0,1.0));
        taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma de las papilas contractiles sobre el dorso","Simple y ramificada"),
        		new Modifier(0.0,1.0,1.0));
        taxon6.addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n","No tiene concha interna"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 2---------------------
        taxon6.addToDescription(new SSCharacterDescriptor("Pie","Forma","Muy estrecho"),
        		new Modifier(0.0,1.0,1.0));
    //-----------------------Structure No. 3---------------------
        taxon6.addToDescription(new SSCharacterDescriptor("Parapodio","Disposici�n","Fusionados a lo largo de las margenes dejando peque�a abertura en la mitad anterior del cuerpo"),
        		new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 20---------------------
	    taxon7 = new Taxon(TaxonomicRank.GENUS, "Phyllaplysia");
	//-----------------------Structure No. 1---------------------
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Aplanado dorsoventralmente"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Verde"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon7.addToDescription(new SSCharacterDescriptor("Cuerpo","Camuflaje","Dise�o de manchas caracter�stico de las algas"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
	    taxon7.addToDescription(new SSCharacterDescriptor("Concha interna","Forma","Laminar con el �pice central"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 3---------------------
	    taxon7.addToDescription(new SSCharacterDescriptor("Manto","Disposici�n","No cubre dorsalmente a la concha ni los bordes"),
  		        new Modifier(0.0,1.0,1.0));
	    
	    oracleIDSystem.getTaxonomy().addTaxon(taxon1, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Mexichromis"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon2, oracleIDSystem.getTaxonomy().getRootTaxon());
	    oracleIDSystem.getTaxonomy().addTaxon(taxon3, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Aplysiidae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon4, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Aplysiidae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon5, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Aplysiidae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon6, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Aplysiidae"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon7, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Aplysiidae"));

	  //-----------------------Taxon No. 21---------------------
	    taxon1 = new Taxon(TaxonomicRank.SPECIES, "Dolabrifera dolabrifera");
	//-----------------------Structure No. 1---------------------
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Tama�o","M�s de 7 cm cuando vivos"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Tama�o","Hasta 4 cm cuando muertos"),
  		        new Modifier(0.0,1.0,0.85));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Deprimido dorsoventralmente"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Verde oliva a marr�n oscuro"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Verde oliva p�lido"),
  		        new Modifier(0.0,1.0,0.8));
	    taxon1.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Crema p�lido"),
  		        new Modifier(0.0,1.0,0.7));
	//-----------------------Structure No. 2---------------------
  		taxon1.addToDescription(new SSCharacterDescriptor("Papilas","Coloraci�n","Violeta rosaceo"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon1.addToDescription(new SSCharacterDescriptor("Papilas","Coloraci�n","Blanquecinas"),
  		        new Modifier(1.0,1.0,0.9));
  		taxon1.addToDescription(new SSCharacterDescriptor("Papilas","Coloraci�n","Verde oliva p�lido"),
  		        new Modifier(1.0,1.0,0.8));
  		taxon1.addToDescription(new SSCharacterDescriptor("Papilas","Coloraci�n","Crema p�lido"),
  		        new Modifier(1.0,1.0,0.8));
  	//-----------------------Structure No. 3---------------------
	    taxon1.addToDescription(new SSCharacterDescriptor("Concha interna","Disposici�n","Completamente rodeada por el manto"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon1.addToDescription(new SSCharacterDescriptor("Concha interna","Tama�o","Reducido"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Grouping Heuristic No. 1---------------------
  		taxon1.addToDescription(new SSHeuristicDescriptor("Factor abi�tico", "Lugar donde se encuentra","Generalmente en las pozas de marea"),
  		        new Modifier(1.0,1.0,1.0));
//-----------------------Taxon No. 22---------------------
	    taxon2 = new Taxon(TaxonomicRank.SPECIES, "Petalifera ramosa");
	//-----------------------Structure No. 1---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Verde claro a intenso"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n","Blanco trasl�cido"),
  		        new Modifier(0.0,1.0,0.6));
	    taxon2.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n de los puntos","Rojizo"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
  		taxon2.addToDescription(new SSCharacterDescriptor("Parapodio","Grado de desarrollo","Poco"),
  		        new Modifier(0.0,1.0,1.0));
  	//-----------------------Structure No. 3---------------------
  		taxon2.addToDescription(new SSCharacterDescriptor("Dorso","Contextura","Lisa"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon2.addToDescription(new SSCharacterDescriptor("Dorso","Contextura","Con papilas simples o ramificadas"),
  		        new Modifier(0.0,1.0,0.8));
  	//-----------------------Structure No. 4---------------------
  		taxon2.addToDescription(new SSCharacterDescriptor("Rinoforos","Contextura","Lisa"),
  		        new Modifier(0.0,1.0,1.0));
  		taxon2.addToDescription(new SSCharacterDescriptor("Rinoforos","Contextura","Con papilas simples o ramificadas"),
  		        new Modifier(0.0,1.0,0.8));
  	//-----------------------Structure No. 5---------------------
  		taxon2.addToDescription(new SSCharacterDescriptor("Tent�culos orales","Contextura","Lisa"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon2.addToDescription(new SSCharacterDescriptor("Tentaculos orales","Contextura","Con papilas simples o ramificadas"),
  		        new Modifier(1.0,1.0,0.8));
  	//-----------------------Structure No. 6---------------------
  		taxon2.addToDescription(new SSCharacterDescriptor("Palpos labiales","Grado de desarrollo","Mucho"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon2.addToDescription(new SSCharacterDescriptor("Palpos labiales","Secci�n en la que son visibles","En la parte dorsal"),
  		        new Modifier(1.0,1.0,1.0));
  	//-----------------------Structure No. 7---------------------
	    taxon2.addToDescription(new SSCharacterDescriptor("Concha interna","Disposici�n","Semicubiera"),
  		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 23---------------------
	    taxon3 = new Taxon(TaxonomicRank.SPECIES, "Phyllaplysia engeli");
	//-----------------------Structure No. 1---------------------
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Estrecho y aplanado"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Verde intenso con agrupaciones de pigmento verde"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon3.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n de los puntos","Rojizo"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Tent�culos orales","Forma","Largos y aplanados"),
  		        new Modifier(1.0,1.0,1.0));
  	//-----------------------Structure No. 3---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Palpos labiales","Tama�o","Peque�o"),
  		        new Modifier(1.0,1.0,1.0));
  	//-----------------------Structure No. 4---------------------
  		taxon3.addToDescription(new SSCharacterDescriptor("Papilas","Tama�o","Peque�o"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Papilas","Disposici�n","Simples y ramificadas"),
  		        new Modifier(1.0,1.0,1.0));
  		taxon3.addToDescription(new SSCharacterDescriptor("Papilas","Distribuci�n","En el dorso y tambi�n sobre los rinoforos"),
  		        new Modifier(1.0,1.0,1.0));
//-----------------------Taxon No. 24---------------------
	    taxon4 = new Taxon(TaxonomicRank.SPECIES, "Aplysiia dactylomela");
	//-----------------------Structure No. 1---------------------
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Forma","Alto y voluminoso"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon4.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Cafesuzco a verde oliva con anillos u ocelos de pigmento oscuro"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
  		taxon4.addToDescription(new SSCharacterDescriptor("Pie","Forma","Estrecho y prolongado en cola larga"),
  		        new Modifier(0.0,1.0,1.0));
//-----------------------Taxon No. 25---------------------
	    taxon5 = new Taxon(TaxonomicRank.SPECIES, "Notarchus punctatus");
	//-----------------------Structure No. 1---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo","Marron claro a beige con pequenas manchas de pigmento oscuro"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 2---------------------
	    taxon5.addToDescription(new SSCharacterDescriptor("Papilas","Tama�o","Peque�o"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon5.addToDescription(new SSCharacterDescriptor("Papilas","Distribuci�n","En todo el cuerpo a excepci�n de los rinoforos y tent�culos orales"),
  		        new Modifier(0.0,1.0,1.0));
	    taxon5.addToDescription(new SSCharacterDescriptor("Papilas","Forma","Simples y ramificadas"),
  		        new Modifier(0.0,1.0,1.0));
	//-----------------------Structure No. 3---------------------
  		taxon5.addToDescription(new SSCharacterDescriptor("Pie","Forma","Estrecho y alargado"),
  		        new Modifier(0.0,1.0,1.0)); 
  		
	    oracleIDSystem.getTaxonomy().addTaxon(taxon1, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Dolabrifera"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon2, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Petalifera"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon3, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Phyllaplysia"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon4, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Aplysiia"));
	    oracleIDSystem.getTaxonomy().addTaxon(taxon5, oracleIDSystem.getTaxonomy()
	    		.getTaxonFromLevelIndex("Notarchus"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Terminando pruebas para la clase " + Reasoner.class.getName());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link system.Reasoner#identify()}.
	 */
	@Test
	public void testIdentify() {
		Case c4, c5914, c67, c8, c10, c11, c12;
		
//---------------------------Caso problema 1---------------------------------		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
	//-----------------------Structure No. 1---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
				"Rosado p�lido y crema"));
	//-----------------------Structure No. 2---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
				"Rosado p�lido y crema"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales",
				"Tripinnada"));
	//-----------------------Structure No. 3---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Forma del borde","Ondulado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Textura","Lisa"));
	//-----------------------Structure No. 4---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
				"Rosado p�lido y crema"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());

//---------------------------Caso problema 2---------------------------------
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
	//-----------------------Structure No. 1---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
				"Blanquecino"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
				"Ovalado"));
	//-----------------------Structure No. 2---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde","Amarillo"));
	//-----------------------Structure No. 3---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n de los �pices",
				"Rojo"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 3---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
		//-----------------------Structure No. 1---------------------
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n de numerosas manchas",
					"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n l�nea interrumpida en el centro","Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices",
					"Celeste"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n del raquis",
					"Blanco"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 4---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices",
			"Azul oscuro a negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n del borde",
			"Verde y amarillo"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());

//---------------------------Caso problema 5---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Azul a negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n del raquis",
			"Amarillo"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices",
			"Azul oscuro a negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Tama�o",
			"Largo"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto",
				"Coloraci�n de peque�as manchas laterales","Amarillo"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto",
				"Coloraci�n l�nea exterior del borde","Amarillo"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto",
				"Coloraci�n l�nea interior del borde","Verde claro"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 6---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n de numerosas manchas",
			"Negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo",
			"Celeste"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Ovalado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Blanco"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 7---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Blanco"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 8---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n",
			"Tiene una concha interna"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Amarillento"));
		// OJO: la descripci�n original declara un rango
		oracleIDSystem.getReasonerAID().addToDescription(new SVCharacterDescriptor("Cuerpo","Longitud",
			new SingleValue(10, MeasuringUnit.CM)));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Parapodio","Grado de desarrollo",
			"Mucho"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSHeuristicDescriptor("Lugar donde se encuentra","Lugar donde se encuentra",
			"Generalmente en las pozas de marea"));
		
		//oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 9---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de la banda dorsal continua",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde",
			"Rosado a crema"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de numerosas manchas",
			"Azul"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Celeste"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 10---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Verduzco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Consistencia",
			"Voluminoso"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n",
			"Tiene una concha interna"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSHeuristicDescriptor("Lugar donde se encuentra","Lugar donde se encuentra",
			"Generalmente en las pozas de marea"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 11---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n del raquis",
			"Purpura"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Purpura"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales",
			"Unipinnada"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n",
				"Purpura"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde",
			"Anaranjado amarillento"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de numerosas manchas",
			"Blanco"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
//---------------------------Caso problema 12---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de numerosas manchas",
			"Azul a negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de la banda dorsal continua",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde",
			"Amarillo brillante"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n",
			"Azul"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Azul oscuro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Azul oscuro"));
		
		assertTrue(oracleIDSystem.getReasonerAID().identify());
		
		/**
		 * Agregando casos a la memoria
		 */
//-----------------------Caso resuelto No. 1---------------------
		c4 = new Case();
		c4.getSolution().setTaxonLevel(TaxonomicRank.SPECIES);
		c4.getSolution().setTaxonName("Glossodoris sedna");
		c4.setState(true);
		
		assertTrue(c4.addToDescription(new SSCharacterDescriptor("Manto", "Coloraci�n del borde", "Amarillo")));
		assertTrue(c4.addToDescription(new SSCharacterDescriptor("Manto", "Coloraci�n de los �pices", "Rojo")));
		
//-----------------------Caso resuelto No. 2---------------------
		c5914 = new Case();
		c5914.getSolution().setTaxonLevel(TaxonomicRank.FAMILY);
		c5914.getSolution().setTaxonName("Chromodorididae");
		c5914.setState(true);
		
		assertTrue((c5914.addToDescription(new SSCharacterDescriptor("Rinoforos", "Coloraci�n del raquis", "Blanco"))));
		assertTrue((c5914.addToDescription(new SSCharacterDescriptor("Rinoforos", "Coloraci�n", "Blanco"))));
		assertTrue((c5914.addToDescription(new SSCharacterDescriptor("Branquia", "Coloraci�n", "Blanco"))));
		assertTrue((c5914.addToDescription(new SSCharacterDescriptor("Pie", "Disposici�n", "Sobresale al manto"))));
		
//-----------------------Caso resuelto No. 3---------------------
		c67 = new Case();
		c67.getSolution().setTaxonLevel(TaxonomicRank.SPECIES);
		c67.getSolution().setTaxonName("Hypselodoris agassizii");
		c67.setState(true);
		
		assertTrue(c67.addToDescription(new SSCharacterDescriptor("Branquia", "Coloraci�n de los �pices", "Azul oscuro a negro")));
		assertTrue((c67.addToDescription(new SSCharacterDescriptor("Pie", "Disposici�n", "Sobresale al manto"))));
		assertTrue((c67.addToDescription(new SSCharacterDescriptor("Manto", "Coloraci�n l�nea exterior del borde", "Amarillo"))));
		assertTrue((c67.addToDescription(new SSCharacterDescriptor("Manto", "Coloraci�n l�nea interior del borde", "Verde claro"))));
		assertTrue((c67.addToDescription(new SSCharacterDescriptor("Rinoforos", "Coloraci�n del raquis", "Blanco"))));
		
//-----------------------Caso resuelto No. 4---------------------
		c8 = new Case();
		c8.getSolution().setTaxonLevel(TaxonomicRank.SPECIES);
		c8.getSolution().setTaxonName("Glossodoris dalli");
		c8.setState(true);
		
		assertTrue((c8.addToDescription(new SSCharacterDescriptor("Cuerpo", "Forma", "Ovalado"))));

//-----------------------Caso resuelto No. 5---------------------
		c10 = new Case();
		c10.getSolution().setTaxonLevel(TaxonomicRank.SPECIES);
		c10.getSolution().setTaxonName("Aplysiia dactylomela");
		c10.setState(true);
		
		assertTrue((c10.addToDescription(new SSCharacterDescriptor("Cuerpo", "Conformaci�n", "Tiene una concha interna"))));
		assertTrue((c10.addToDescription(new SSCharacterDescriptor("Cuerpo", "Coloraci�n del fondo", "Cafesuzco a verde oliva con anillos u ocelos de pigmento oscuro"))));
		assertTrue((c10.addToDescription(new SSCharacterDescriptor("Cuerpo", "Forma", "Alto alargado y contractil"))));
		assertTrue((c10.addToDescription(new SSCharacterDescriptor("Parapodio", "Grado de desarrollo", "Mucho"))));
		assertTrue((c10.addToDescription(new SSCharacterDescriptor("Parapodio", "Simetr�a", "Sim�tricos libres"))));
		
//-----------------------Caso resuelto No. 6---------------------
		c11 = new Case();
		c11.getSolution().setTaxonLevel(TaxonomicRank.SPECIES);
		c11.getSolution().setTaxonName("Chromodoris kempfi");
		c11.setState(true);
		
		assertTrue((c11.addToDescription(new SSCharacterDescriptor("Manto", "Coloraci�n de la banda dorsal continua", "Blanco"))));
		
//-----------------------Caso resuelto No. 7---------------------
		c12 = new Case();
		c12.getSolution().setTaxonLevel(TaxonomicRank.SPECIES);
		c12.getSolution().setTaxonName("Chromodoris kempfi");
		c12.setState(true);
		
		assertTrue((c12.addToDescription(new SSCharacterDescriptor("Cuerpo", "Coloraci�n", "Verduzco"))));
		assertTrue((c12.addToDescription(new SSCharacterDescriptor("Cuerpo", "Conformaci�n", "Tiene una concha interna"))));
		assertTrue((c12.addToDescription(new SSCharacterDescriptor("Cuerpo", "Consistencia", "Voluminoso"))));
		
		/**
		 * Agregar casos a la memoria
		 */
		oracleIDSystem.getCaseMemory().add(c4);
		oracleIDSystem.getCaseMemory().add(c5914);
		oracleIDSystem.getCaseMemory().add(c67);
		oracleIDSystem.getCaseMemory().add(c8);
		oracleIDSystem.getCaseMemory().add(c10);
		oracleIDSystem.getCaseMemory().add(c11);
		oracleIDSystem.getCaseMemory().add(c12);
		
		/**
		 * Casos de prueba utilizando tanto la taxonom�a y la memoria de casos
		 */
//---------------------------Caso problema 13---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Ovalado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Parapodio","Grado de desarrollo",
			"Poco"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());

//---------------------------Caso problema 14---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Anaranjado claro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Anaranjado claro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Anaranjado claro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales",
			"Tripinnada"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Forma",
			"Ondulado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Textura",
			"Lisa"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 15---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Ovalado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n",
			"No tiene espiculas"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Textura",
			"Lisa"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Forma hojas branquiales",
			"Tripinnada"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 16---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Azul"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices",
			"Azul"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cola","Coloraci�n",
			"Azul"));
		//OJO: este descriptor tiene una observaci�n en SUKIA
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cola","Disposici�n",
			"Sobresale claramente por detr�s del notum"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Crema blanquecino"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Alargado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde",
			"Mel�n tenue"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n",
			"Blanquecino"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 17---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Ovalado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Textura",
			"Lisa"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde",
			"Amarillo"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n del borde",
			"Amarillo"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 18---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.GENUS);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Ovalado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Contextura",
			"Con gl�ndulas"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Amarillento"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Coloraci�n",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"No sobresale al manto"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 19---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Consistencia",
			"Voluminoso"));	
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Alargado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Disposici�n",
			"Sobresale al manto"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Blanco amarillento"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n del raquis",
			"Negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Caf�"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n de los �pices",
			"Crema"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Contextura",
			"Con tuberculos"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de las manchas",
			"Negro"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n del borde",
			"Crema blanquecino"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 20---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.FAMILY);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Alargado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Azul p�lido"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cola","Disposici�n",
			"Sobresale claramente por detr�s del notum"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Coloraci�n de las manchas",
			"Blanco"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Manto","Textura",
			"Lisa"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Coloraci�n",
			"Azul"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Branquia","Coloraci�n",
			"Azul"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 21---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.GENUS);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Consistencia",
			"Voluminoso"));	
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Caf�"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Rinoforos","Contextura",
			"Lisa"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Parapodio","Disposici�n",
			"Libre"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Parapodio","Grado de desarrollo",
			"Mucho"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Parapodio","Simetr�a",
			"Fusionados"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
//---------------------------Caso problema 22---------------------------------		
		oracleIDSystem.getReasonerAID().initialize();
		
		oracleIDSystem.getReasonerAID().setIdentGoal(TaxonomicRank.SPECIES);
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n",
			"Gris"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Coloraci�n del fondo",
			"Verde"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Forma",
			"Alargado"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Consistencia",
			"Voluminoso"));	
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Cuerpo","Conformaci�n",
			"Tiene una concha interna"));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Parapodio","Grado de desarrollo",
			"Poco"));
		
		//assertTrue(oracleIDSystem.getReasoner().identify());
		
		oracleIDSystem.getReasonerAID().initialize();
	}

	/**
	 * Test method for {@link system.Reasoner#getCharacterList()}.
	 */
	@Test
	public void testGetCharacterList() {
		List<Descriptor> sl;
		
		System.out.println("Iniciando pruebas para el m�todo GetCharacterList()");
		
		oracleIDSystem.getReasonerAID().getDescription().getDescriptors().clear();
		System.out.println("Verificar que se obtenga una lista de descriptores de caracter");
		
		assertTrue(oracleIDSystem.getReasonerAID().addToDescription(new SVCharacterDescriptor("Cuerpo", "Longitud",
				new SingleValue(0.3))));
		assertTrue(oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Forma",
				"Estrecho y alargado")));
		
		sl = new ArrayList<Descriptor>();
		sl.add(new SVCharacterDescriptor("Cuerpo", "Longitud", new SingleValue(0.3)));
		sl.add(new SSCharacterDescriptor("Pie","Forma", "Estrecho y alargado"));
		
		assertEquals(sl, oracleIDSystem.getReasonerAID().getCharacterList());
		
		oracleIDSystem.getReasonerAID().getDescription().getDescriptors().clear();
	}

	/**
	 * Test method for {@link system.Reasoner#getHeuristicList()}.
	 */
	@Test
	public void testGetHeuristicList() {
		List<Descriptor> sl;
		
		System.out.println("Iniciando pruebas para el m�todo GetHeuristicList()");
		
		System.out.println("Verificar que se obtenga una lista de descriptores de heuristicas");
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSHeuristicDescriptor("Alimentaci�n", 
				"Alimentaci�n","Esponjas"));
		oracleIDSystem.getReasonerAID().addToDescription(new SVHeuristicDescriptor("Profundidad donde se encuentra",
  				"Profundidad donde se encuentra", new SingleValue(16, MeasuringUnit.M)));
		
		sl = new ArrayList<Descriptor>();
		sl.add(new SSHeuristicDescriptor("Alimentaci�n", "Alimentaci�n","Esponjas"));
		sl.add(new SVHeuristicDescriptor("Profundidad donde se encuentra",
  				"Profundidad donde se encuentra", new SingleValue(16, MeasuringUnit.M)));
		
		assertEquals(sl, oracleIDSystem.getReasonerAID().getHeuristicList());
		
		oracleIDSystem.getReasonerAID().getDescription().getDescriptors().clear();
	}

	/**
	 * Test method for {@link system.Reasoner#getCharacterStructuresList()}.
	 */
	@Test
	public void testGetCharacterStructuresList() {
		List<String> sl;
		
		System.out.println("Iniciando pruebas para el m�todo GetCharacterStructuresList()");
		
		System.out.println("Verificar que se obtenga una lista de nombres de estructura");
		
		oracleIDSystem.getReasonerAID().addToDescription(new SVCharacterDescriptor("Cuerpo", "Longitud",
				new SingleValue(0.3)));
		oracleIDSystem.getReasonerAID().addToDescription(new SSCharacterDescriptor("Pie","Forma",
				"Estrecho y alargado"));
		
		sl = new ArrayList<String>();
		sl.addAll(Arrays.asList("Cuerpo", "Pie"));
		
		assertEquals(sl, oracleIDSystem.getReasonerAID().getCharacterStructuresList());
		
		oracleIDSystem.getReasonerAID().getDescription().getDescriptors().clear();
	}

	/**
	 * Test method for {@link system.Reasoner#getHeuristicStructuresList()}.
	 */
	@Test
	public void testGetHeuristicStructuresList() {
		List<String> sl;
		
		System.out.println("Iniciando pruebas para el m�todo GetHeuristicStructuresList()");
		
		System.out.println("Verificar que se obtenga una lista de nombres de heuristicas");
		
		oracleIDSystem.getReasonerAID().addToDescription(new SSHeuristicDescriptor("Alimentaci�n", 
				"Alimentaci�n","Esponjas"));
		oracleIDSystem.getReasonerAID().addToDescription(new SVHeuristicDescriptor("Profundidad donde se encuentra",
  				"Profundidad donde se encuentra", new SingleValue(16, MeasuringUnit.M)));
		
		sl = new ArrayList<String>();
		sl.addAll(Arrays.asList("Alimentaci�n", "Profundidad donde se encuentra"));
		
		assertEquals(sl, oracleIDSystem.getReasonerAID().getHeuristicStructuresList());
		
		oracleIDSystem.getReasonerAID().getDescription().getDescriptors().clear();
	}

	/**
	 * Test method for {@link system.Reasoner#getDescription(java.lang.String)}.
	 */
	@Test
	public void testGetDescriptionString() {
		List<Descriptor> dl = new ArrayList<Descriptor>();
		
		System.out.println("Iniciando pruebas para el m�todo GetDescription()");
		
		oracleIDSystem.getReasonerAID().addToDescription(new SVCharacterDescriptor("Cuerpo", "Longitud",
				new SingleValue(0.3)));
		
		System.out.println("Verificar que se obtenga una descripci�n asociada a una estructura");
		dl.add(new SVCharacterDescriptor("Cuerpo", "Longitud", new SingleValue(0.3)));
		assertEquals(dl, oracleIDSystem.getReasonerAID().getDescription("Cuerpo"));
		
		oracleIDSystem.getReasonerAID().getDescription().getDescriptors().clear();
	}

}
