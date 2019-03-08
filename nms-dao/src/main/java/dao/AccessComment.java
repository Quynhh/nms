/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THAI SON
 */
@Entity
@Table(name = "access_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessComment.findAll", query = "SELECT a FROM AccessComment a")
    , @NamedQuery(name = "AccessComment.findById", query = "SELECT a FROM AccessComment a WHERE a.id = :id")
    , @NamedQuery(name = "AccessComment.findByCreated", query = "SELECT a FROM AccessComment a WHERE a.created = :created")
    , @NamedQuery(name = "AccessComment.findByCreatedbyUsername", query = "SELECT a FROM AccessComment a WHERE a.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "AccessComment.findByLastmodified", query = "SELECT a FROM AccessComment a WHERE a.lastmodified = :lastmodified")
    , @NamedQuery(name = "AccessComment.findByLastmodifiedbyUsername", query = "SELECT a FROM AccessComment a WHERE a.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class AccessComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date created;
    @Basic(optional = false)
    @Column(name = "createdby_username", nullable = false, length = 150)
    private String createdbyUsername;
    @Column(name = "lastmodified")
    @Temporal(TemporalType.DATE)
    private Date lastmodified;
    @Column(name = "lastmodifiedby_username", length = 150)
    private String lastmodifiedbyUsername;
    @JoinColumn(name = "news_access_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NewsAccess newsAccessId;

    public AccessComment() {
    }

    public AccessComment(Integer id) {
        this.id = id;
    }

    public AccessComment(Integer id, Date created, String createdbyUsername) {
        this.id = id;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedbyUsername() {
        return createdbyUsername;
    }

    public void setCreatedbyUsername(String createdbyUsername) {
        this.createdbyUsername = createdbyUsername;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public String getLastmodifiedbyUsername() {
        return lastmodifiedbyUsername;
    }

    public void setLastmodifiedbyUsername(String lastmodifiedbyUsername) {
        this.lastmodifiedbyUsername = lastmodifiedbyUsername;
    }

    public NewsAccess getNewsAccessId() {
        return newsAccessId;
    }

    public void setNewsAccessId(NewsAccess newsAccessId) {
        this.newsAccessId = newsAccessId;
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
        if (!(object instanceof AccessComment)) {
            return false;
        }
        AccessComment other = (AccessComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.AccessComment[ id=" + id + " ]";
    }
    
}
