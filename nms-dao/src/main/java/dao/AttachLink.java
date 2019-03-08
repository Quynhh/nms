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
@Table(name = "attach_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttachLink.findAll", query = "SELECT a FROM AttachLink a")
    , @NamedQuery(name = "AttachLink.findById", query = "SELECT a FROM AttachLink a WHERE a.id = :id")
    , @NamedQuery(name = "AttachLink.findByAttachLink", query = "SELECT a FROM AttachLink a WHERE a.attachLink = :attachLink")
    , @NamedQuery(name = "AttachLink.findByClasssifyData", query = "SELECT a FROM AttachLink a WHERE a.classsifyData = :classsifyData")
    , @NamedQuery(name = "AttachLink.findByCreated", query = "SELECT a FROM AttachLink a WHERE a.created = :created")
    , @NamedQuery(name = "AttachLink.findByCreatedbyUsername", query = "SELECT a FROM AttachLink a WHERE a.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "AttachLink.findByLastmodified", query = "SELECT a FROM AttachLink a WHERE a.lastmodified = :lastmodified")
    , @NamedQuery(name = "AttachLink.findByLastmodifiedbyUsername", query = "SELECT a FROM AttachLink a WHERE a.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class AttachLink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "attach_link", length = 300)
    private String attachLink;
    @Column(name = "classsify_data")
    private Integer classsifyData;
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
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private News newsId;

    public AttachLink() {
    }

    public AttachLink(Integer id) {
        this.id = id;
    }

    public AttachLink(Integer id, Date created, String createdbyUsername) {
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

    public String getAttachLink() {
        return attachLink;
    }

    public void setAttachLink(String attachLink) {
        this.attachLink = attachLink;
    }

    public Integer getClasssifyData() {
        return classsifyData;
    }

    public void setClasssifyData(Integer classsifyData) {
        this.classsifyData = classsifyData;
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

    public News getNewsId() {
        return newsId;
    }

    public void setNewsId(News newsId) {
        this.newsId = newsId;
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
        if (!(object instanceof AttachLink)) {
            return false;
        }
        AttachLink other = (AttachLink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.AttachLink[ id=" + id + " ]";
    }
    
}
