package ontology.CBR;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


/**
* Protege name: IsPositive
* @author ontology bean generator
* @version 2009/10/17, 19:00:46
*/
public interface IsPositive extends jade.content.Predicate, Serializable {
   // bean stuff
   public void addPropertyChangeListener(PropertyChangeListener pcl);
   public void removePropertyChangeListener(PropertyChangeListener pcl);

   /**
   * Protege name: case
   */
   public void setCase(Case value);
   public Case getCase();

}
