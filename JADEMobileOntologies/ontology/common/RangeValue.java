package ontology.common;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: RangeValue
* @author ontology bean generator
* @version 2009/10/20, 13:36:12
*/
public interface RangeValue extends Value, Introspectable {

   /**
   * Protege name: upperBound
   */
   public void setUpperBound(float value);
   public float getUpperBound();

   /**
   * Protege name: lowerBound
   */
   public void setLowerBound(float value);
   public float getLowerBound();

}
