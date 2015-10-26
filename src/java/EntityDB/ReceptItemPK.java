/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author namal
 */
@Embeddable
public class ReceptItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "receptID")
    private int receptID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemID")
    private int itemID;

    public ReceptItemPK() {
    }

    public ReceptItemPK(int receptID, int itemID) {
        this.receptID = receptID;
        this.itemID = itemID;
    }

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) receptID;
        hash += (int) itemID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceptItemPK)) {
            return false;
        }
        ReceptItemPK other = (ReceptItemPK) object;
        if (this.receptID != other.receptID) {
            return false;
        }
        if (this.itemID != other.itemID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.ReceptItemPK[ receptID=" + receptID + ", itemID=" + itemID + " ]";
    }
    
}
