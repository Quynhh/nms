/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THAI SON
 */
@Entity
@Table(name = "news_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsAccess.findAll", query = "SELECT n FROM NewsAccess n")
    , @NamedQuery(name = "NewsAccess.findById", query = "SELECT n FROM NewsAccess n WHERE n.id = :id")
    , @NamedQuery(name = "NewsAccess.findByTypeAccess", query = "SELECT n FROM NewsAccess n WHERE n.typeAccess = :typeAccess")
    , @NamedQuery(name = "NewsAccess.findByCreated", query = "SELECT n FROM NewsAccess n WHERE n.created = :created")
    , @NamedQuery(name = "NewsAccess.findByCreatedbyUsername", query = "SELECT n FROM NewsAccess n WHERE n.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "NewsAccess.findByLastmodified", query = "SELECT n FROM NewsAccess n WHERE n.lastmodified = :lastmodified")
    , @NamedQuery(name = "NewsAccess.findByLastmodifiedbyUsername", query = "SELECT n FROM NewsAccess n WHERE n.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class NewsAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "type_access")
    private Integer typeAccess;
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
    @OneToMany(mappedBy = "newsAccessId", fetch = FetchType.LAZY)
    private List<AccessLike> accessLikeList;
    @OneToMany(mappedBy = "newsAccessId", fetch = FetchType.LAZY)
    private List<AccessComment> accessCommentList;
    @OneToMany(mappedBy = "newsAccessId", fetch = FetchType.LAZY)
    private List<AccessView> accessViewList;
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private News newsId;

    public NewsAccess() {
    }

    public NewsAccess(Integer id) {
        this.id = id;
    }

    public NewsAccess(Integer id, Date created, String createdbyUsername) {
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

    public Integer getTypeAccess() {
        return typeAccess;
    }

    public void setTypeAccess(Integer typeAccess) {
        this.typeAccess = typeAccess;
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

    @XmlTransient
    public List<AccessLike> getAccessLikeList() {
        return accessLikeList;
    }

    public void setAccessLikeList(List<AccessLike> accessLikeList) {
        this.accessLikeList = accessLikeList;
    }

    @XmlTransient
    public List<AccessComment> getAccessCommentList() {
        return accessCommentList;
    }

    public void setAccessCommentList(List<AccessComment> accessCommentList) {
        this.accessCommentList = accessCommentList;
    }

    @XmlTransient
    public List<AccessView> getAccessViewList() {
        return accessViewList;
    }

    public void setAccessViewList(List<AccessView> accessViewList) {
        this.accessViewList = accessViewList;
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
        if (!(object instanceof NewsAccess)) {
            return false;
        }
        NewsAccess other = (NewsAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.NewsAccess[ id=" + id + " ]";
    }
    
}
