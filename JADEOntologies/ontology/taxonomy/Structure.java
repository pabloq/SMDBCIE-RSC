package ontology.taxonomy;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import jade.util.leap.*;

/**
* It's a subclass of a defined term
* Protege name: Structure
* @author ontology bean generator
* @version 2009/09/30, 13:34:31
*/
public interface Structure extends DefinedTerm, Serializable {
   // bean stuff
   public void addPropertyChangeListener(PropertyChangeListener pcl);
   public void removePropertyChangeListener(PropertyChangeListener pcl);

   /**
   * Protege name: owns
   */
   public void addOwns(Attribute elem);
   public boolean removeOwns(Attribute elem);
   public void clearAllOwns();
   public Iterator getAllOwns();
   public List getOwns();
   public void setOwns(List l);

}
