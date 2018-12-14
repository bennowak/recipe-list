/**
 * 
 */
package us.bennowak.tts.TechTalentBlog.BlogPost;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

/**
 * @author Ben
 *
 */
@Entity
public class BlogPost {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String author;
	private String blogEntry;
	
	@Column
	@CreationTimestamp
	private Date creation_date;

	/**
	 * @param title
	 * @param author
	 * @param blogEntry
	 */
	public BlogPost(String title, String author, String blogEntry) {
		super();
		this.title = title;
		this.author = author;
		this.blogEntry = blogEntry;
	}

	public BlogPost() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the blogEntry
	 */
	public String getBlogEntry() {
		return blogEntry;
	}

	/**
	 * @param blogEntry the blogEntry to set
	 */
	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
	}

	/**
	 * @return the creation_date
	 */
	public Date getCreation_date() {
		return creation_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("BlogPost [id=%s, title=%s, author=%s, blogEntry=%s, creation_date=%s]", id, title, author,
				blogEntry, creation_date);
	}
	
	
	
}
