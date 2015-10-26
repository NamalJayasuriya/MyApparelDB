/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author namal
 */
@Entity
@Table(name = "subCategory")
@NamedQueries({
    @NamedQuery(name = "SubCategory.findAll", query = "SELECT s FROM SubCategory s")})
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "subCategoryID")
    private String subCategoryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "subCategoryName")
    private String subCategoryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "caregoryID")
    private String caregoryID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;

    public SubCategory() {
    }

    public SubCategory(String subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public SubCategory(String subCategoryID, String subCategoryName, String caregoryID, String description) {
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.caregoryID = caregoryID;
        this.description = description;
    }

    public String getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(String subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCaregoryID() {
        return caregoryID;
    }

    public void setCaregoryID(String caregoryID) {
        this.caregoryID = caregoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subCategoryID != null ? subCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategory)) {
            return false;
        }
        SubCategory other = (SubCategory) object;
        if ((this.subCategoryID == null && other.subCategoryID != null) || (this.subCategoryID != null && !this.subCategoryID.equals(other.subCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.SubCategory[ subCategoryID=" + subCategoryID + " ]";
    }
    
}
