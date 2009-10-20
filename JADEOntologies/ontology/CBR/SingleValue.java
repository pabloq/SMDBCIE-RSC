package ontology.CBR;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


/**
* Protege name: SingleValue
* @author ontology bean generator
* @version 2009/10/17, 19:00:45
*/
public interface SingleValue extends Value, Serializable {
   // bean stuff
   public void addPropertyChangeListener(PropertyChangeListener pcl);
   public void removePropertyChangeListener(PropertyChangeListener pcl);

   /**
   * Protege name: value
   */
   public void setValue(float value);
   public float getValue();

}
