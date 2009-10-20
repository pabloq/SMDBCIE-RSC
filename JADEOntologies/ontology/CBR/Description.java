package ontology.CBR;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import jade.util.leap.*;

/**
* Protege name: Description
* @author ontology bean generator
* @version 2009/10/17, 19:00:45
*/
public interface Description extends jade.content.Concept, Serializable {
   // bean stuff
   public void addPropertyChangeListener(PropertyChangeListener pcl);
   public void removePropertyChangeListener(PropertyChangeListener pcl);

   /**
   * Protege name: descriptors
   */
   public void addDescriptors(Descriptor elem);
   public boolean removeDescriptors(Descriptor elem);
   public void clearAllDescriptors();
   public Iterator getAllDescriptors();
   public List getDescriptors();
   public void setDescriptors(List l);

}
