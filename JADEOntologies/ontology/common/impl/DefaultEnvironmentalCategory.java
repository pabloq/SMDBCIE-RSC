package ontology.common.impl;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import jade.util.leap.*;
import ontology.common.*;

/**
* Protege name: EnvironmentalCategory
* @author ontology bean generator
* @version 2009/09/15, 18:06:25
*/
public class DefaultEnvironmentalCategory implements EnvironmentalCategory, Serializable {
   // bean stuff
   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);

   public void addPropertyChangeListener(PropertyChangeListener pcl) {
     pcs.addPropertyChangeListener(pcl);
   }

   public void removePropertyChangeListener(PropertyChangeListener pcl) {
     pcs.removePropertyChangeListener(pcl);
   }


  private static final long serialVersionUID = -2693500281773954763L;

  private String _internalInstanceName = null;

  public DefaultEnvironmentalCategory() {
    this._internalInstanceName = "";
  }

  public DefaultEnvironmentalCategory(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: definition
   */
   private String definition;
   public void setDefinition(String value) { 
     pcs.firePropertyChange("definition", (this.definition==null?new String():this.definition), value);
    this.definition=value;
   }
   public String getDefinition() {
     return this.definition;
   }

   /**
   * Protege name: owns
   */
   private List owns = new ArrayList();
   public void addOwns(Attribute elem) { 
     owns.add(elem);
     pcs.firePropertyChange("owns", oldList, this.owns);
   }
   public boolean removeOwns(Attribute elem) {
     boolean result = owns.remove(elem);
     pcs.firePropertyChange("owns", oldList, this.owns);
     return result;
   }
   public void clearAllOwns() {
     owns.clear();
     pcs.firePropertyChange("owns", oldList, this.owns);
   }
   public Iterator getAllOwns() {return owns.iterator(); }
   public List getOwns() {return owns; }
   public void setOwns(List l) {owns = l; }

   /**
   * Protege name: term
   */
   private String term;
   public void setTerm(String value) { 
     pcs.firePropertyChange("term", (this.term==null?new String():this.term), value);
    this.term=value;
   }
   public String getTerm() {
     return this.term;
   }

}
