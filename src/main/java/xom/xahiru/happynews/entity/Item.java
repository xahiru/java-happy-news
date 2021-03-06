package xom.xahiru.happynews.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=5, message="invalid message, should be more than 5 chars")
	private String title;
	
	@Column(name="published_date")
	private Date publishedDate ;
	
	@Size(min=5, message="invalid description, should be more than 5 chars")
	private String description;

	@Size(min=3)
	@URL(message="invalid link")
	private String link;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
