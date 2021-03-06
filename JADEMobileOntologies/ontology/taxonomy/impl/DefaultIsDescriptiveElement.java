package ontology.taxonomy.impl;


import jade.content.abs.*;
import jade.content.onto.*;
import ontology.taxonomy.*;

/**
* Protege name: IsDescriptiveElement
* @author ontology bean generator
* @version 2009/10/20, 16:33:54
*/
public class DefaultIsDescriptiveElement implements IsDescriptiveElement, Introspectable {

  private static final long serialVersionUID = 8335714681696847814L;

  private String _internalInstanceName = null;

  public DefaultIsDescriptiveElement() {
    this._internalInstanceName = "";
  }

  public DefaultIsDescriptiveElement(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: descriptiveElement
   */
   private Object descriptiveElement;
   public void setDescriptiveElement(Object value) { 
    this.descriptiveElement=value;
   }
   public Object getDescriptiveElement() {
     return this.descriptiveElement;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(TaxonomyOntology.ISDESCRIPTIVEELEMENT_DESCRIPTIVEELEMENT, (AbsTerm) onto.fromObject(getDescriptiveElement()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsDescriptiveElement");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      descriptiveElement = (Object)onto.toObject(abs.getAbsObject(TaxonomyOntology.ISDESCRIPTIVEELEMENT_DESCRIPTIVEELEMENT));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsDescriptiveElement");
     }
   }

}
