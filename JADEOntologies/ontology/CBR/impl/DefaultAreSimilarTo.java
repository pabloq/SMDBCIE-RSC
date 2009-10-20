package ontology.CBR.impl;

import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import jade.util.leap.*;
import ontology.CBR.*;

/**
* Protege name: AreSimilarTo
* @author ontology bean generator
* @version 2009/10/17, 19:00:46
*/
public class DefaultAreSimilarTo implements AreSimilarTo, Serializable {
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

  public DefaultAreSimilarTo() {
    this._internalInstanceName = "";
  }

  public DefaultAreSimilarTo(String instance_name) {
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
   * Protege name: successfulConflictSet
   */
   private List successfulConflictSet = new ArrayList();
   public void addSuccessfulConflictSet(Hypothesis elem) { 
     successfulConflictSet.add(elem);
     pcs.firePropertyChange("successfulConflictSet", oldList, this.successfulConflictSet);
   }
   public boolean removeSuccessfulConflictSet(Hypothesis elem) {
     boolean result = successfulConflictSet.remove(elem);
     pcs.firePropertyChange("successfulConflictSet", oldList, this.successfulConflictSet);
     return result;
   }
   public void clearAllSuccessfulConflictSet() {
     successfulConflictSet.clear();
     pcs.firePropertyChange("successfulConflictSet", oldList, this.successfulConflictSet);
   }
   public Iterator getAllSuccessfulConflictSet() {return successfulConflictSet.iterator(); }
   public List getSuccessfulConflictSet() {return successfulConflictSet; }
   public void setSuccessfulConflictSet(List l) {successfulConflictSet = l; }

   /**
   * Protege name: failureConflictSet
   */
   private List failureConflictSet = new ArrayList();
   public void addFailureConflictSet(Hypothesis elem) { 
     failureConflictSet.add(elem);
     pcs.firePropertyChange("failureConflictSet", oldList, this.failureConflictSet);
   }
   public boolean removeFailureConflictSet(Hypothesis elem) {
     boolean result = failureConflictSet.remove(elem);
     pcs.firePropertyChange("failureConflictSet", oldList, this.failureConflictSet);
     return result;
   }
   public void clearAllFailureConflictSet() {
     failureConflictSet.clear();
     pcs.firePropertyChange("failureConflictSet", oldList, this.failureConflictSet);
   }
   public Iterator getAllFailureConflictSet() {return failureConflictSet.iterator(); }
   public List getFailureConflictSet() {return failureConflictSet; }
   public void setFailureConflictSet(List l) {failureConflictSet = l; }

}
