/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author namal
 */
@Entity
@Table(name = "receptItem")
@NamedQueries({
    @NamedQuery(name = "ReceptItem.findAll", query = "SELECT r FROM ReceptItem r")})
public class ReceptItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceptItemPK receptItemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;

    public ReceptItem() {
    }

    public ReceptItem(ReceptItemPK receptItemPK) {
        this.receptItemPK = receptItemPK;
    }

    public ReceptItem(ReceptItemPK receptItemPK, int qty) {
        this.receptItemPK = receptItemPK;
        this.qty = qty;
    }

    public ReceptItem(int receptID, int itemID) {
        this.receptItemPK = new ReceptItemPK(receptID, itemID);
    }

    public ReceptItemPK getReceptItemPK() {
        return receptItemPK;
    }

    public void setReceptItemPK(ReceptItemPK receptItemPK) {
        this.receptItemPK = receptItemPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receptItemPK != null ? receptItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceptItem)) {
            return false;
        }
        ReceptItem other = (ReceptItem) object;
        if ((this.receptItemPK == null && other.receptItemPK != null) || (this.receptItemPK != null && !this.receptItemPK.equals(other.receptItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.ReceptItem[ receptItemPK=" + receptItemPK + " ]";
    }
    
}
