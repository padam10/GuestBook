/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Padam
 */
@Entity
@Table(name = "guestbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guestbook.findAll", query = "SELECT g FROM Guestbook g"),
    @NamedQuery(name = "Guestbook.findById", query = "SELECT g FROM Guestbook g WHERE g.id = :id"),
    @NamedQuery(name = "Guestbook.findByFirstname", query = "SELECT g FROM Guestbook g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "Guestbook.findByLastname", query = "SELECT g FROM Guestbook g WHERE g.lastname = :lastname")})
public class Guestbook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LASTNAME")
    private String lastname;

    public Guestbook() {
    }

    public Guestbook(Integer id) {
        this.id = id;
    }

    public Guestbook(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guestbook)) {
            return false;
        }
        Guestbook other = (Guestbook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Guestbook[ id=" + id + " ]";
    }
    
}

