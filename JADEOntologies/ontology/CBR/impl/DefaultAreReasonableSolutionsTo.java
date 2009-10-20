package ontology.CBR.impl;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import jade.util.leap.*;
import ontology.CBR.*;

/**
* Protege name: AreReasonableSolutionsTo
* @author ontology bean generator
* @version 2009/10/17, 19:00:46
*/
public class DefaultAreReasonableSolutionsTo implements AreReasonableSolutionsTo, Serializable {
   // bean stuff
   protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);

   public void addPropertyChangeListener(PropertyChangeListener pcl) {
     pcs.addPropertyChangeListener(pcl);
   }

   public void removePropertyChangeListener(PropertyChangeListener pcl) {
     pcs.removePropertyChangeListener(pcl);
   }


  private static final long serialVersionUID = 1907932705116471396L;

  private String _internalInstanceName = null;

  public DefaultAreReasonableSolutionsTo() {
    this._internalInstanceName = "";
  }

  public DefaultAreReasonableSolutionsTo(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: problem
   */
   private Problem problem;
   public void setProblem(Problem value) { 
     pcs.firePropertyChange("problem", (this.problem==null?new Problem():this.problem), value);
    this.problem=value;
   }
   public Problem getProblem() {
     return this.problem;
   }

   /**
   * Protege name: proposedSolutions
   */
   private List proposedSolutions = new ArrayList();
   public void addProposedSolutions(ProposedSolution elem) { 
     proposedSolutions.add(elem);
     pcs.firePropertyChange("proposedSolutions", oldList, this.proposedSolutions);
   }
   public boolean removeProposedSolutions(ProposedSolution elem) {
     boolean result = proposedSolutions.remove(elem);
     pcs.firePropertyChange("proposedSolutions", oldList, this.proposedSolutions);
     return result;
   }
   public void clearAllProposedSolutions() {
     proposedSolutions.clear();
     pcs.firePropertyChange("proposedSolutions", oldList, this.proposedSolutions);
   }
   public Iterator getAllProposedSolutions() {return proposedSolutions.iterator(); }
   public List getProposedSolutions() {return proposedSolutions; }
   public void setProposedSolutions(List l) {proposedSolutions = l; }

}
