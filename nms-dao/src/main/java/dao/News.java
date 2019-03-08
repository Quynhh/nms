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
import javax.persistence.Lob;
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
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n")
    , @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id")
    , @NamedQuery(name = "News.findByShortDesc", query = "SELECT n FROM News n WHERE n.shortDesc = :shortDesc")
    , @NamedQuery(name = "News.findByCreated", query = "SELECT n FROM News n WHERE n.created = :created")
    , @NamedQuery(name = "News.findByCreatedbyUsername", query = "SELECT n FROM News n WHERE n.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "News.findByLastmodified", query = "SELECT n FROM News n WHERE n.lastmodified = :lastmodified")
    , @NamedQuery(name = "News.findByLastmodifiedbyUsername", query = "SELECT n FROM News n WHERE n.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "short_desc", length = 400)
    private String shortDesc;
    @Lob
    @Column(name = "content", length = 65535)
    private String content;
    @Lob
    @Column(name = "main_image")
    private byte[] mainImage;
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
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category catId;
    @OneToMany(mappedBy = "newsId", fetch = FetchType.LAZY)
    private List<AttachLink> attachLinkList;
    @OneToMany(mappedBy = "newsId", fetch = FetchType.LAZY)
    private List<AttachFile> attachFileList;
    @OneToMany(mappedBy = "newsId", fetch = FetchType.LAZY)
    private List<NewsAccess> newsAccessList;

    public News() {
    }

    public News(Integer id) {
        this.id = id;
    }

    public News(Integer id, Date created, String createdbyUsername) {
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getMainImage() {
        return mainImage;
    }

    public void setMainImage(byte[] mainImage) {
        this.mainImage = mainImage;
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

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @XmlTransient
    public List<AttachLink> getAttachLinkList() {
        return attachLinkList;
    }

    public void setAttachLinkList(List<AttachLink> attachLinkList) {
        this.attachLinkList = attachLinkList;
    }

    @XmlTransient
    public List<AttachFile> getAttachFileList() {
        return attachFileList;
    }

    public void setAttachFileList(List<AttachFile> attachFileList) {
        this.attachFileList = attachFileList;
    }

    @XmlTransient
    public List<NewsAccess> getNewsAccessList() {
        return newsAccessList;
    }

    public void setNewsAccessList(List<NewsAccess> newsAccessList) {
        this.newsAccessList = newsAccessList;
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
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.News[ id=" + id + " ]";
    }
    
}
