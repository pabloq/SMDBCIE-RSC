package ontology.taxonomy.impl;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import ontology.taxonomy.*;

/**
* Protege name: IsRootTaxon
* @author ontology bean generator
* @version 2009/09/30, 13:34:31
*/
public class DefaultIsRootTaxon implements IsRootTaxon, Serializable {
   // bean stuff
   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);

   public void addPropertyChangeListener(PropertyChangeListener pcl) {
     pcs.addPropertyChangeListener(pcl);
   }

   public void removePropertyChangeListener(PropertyChangeListener pcl) {
     pcs.removePropertyChangeListener(pcl);
   }


  private static final long serialVersionUID = -8627856865395943317L;

  private String _internalInstanceName = null;

  public DefaultIsRootTaxon() {
    this._internalInstanceName = "";
  }

  public DefaultIsRootTaxon(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: taxon
   */
   private Taxon taxon;
   public void setTaxon(Taxon value) { 
     pcs.firePropertyChange("taxon", (this.taxon==null?new Taxon():this.taxon), value);
    this.taxon=value;
   }
   public Taxon getTaxon() {
     return this.taxon;
   }

}
