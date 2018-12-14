package us.bennowak.tts.TechTalentBlog.BlogPost;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author  extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String website;

    @Column
    @CreationTimestamp
    private Date joinDate;

    public Author(String name, String website){
        super();
        this.name = name;
        this.website = website;
    }

    public Author(String name){
        super();
        this.name = name;
        this.website = null;
    }

    @Override
    public String toString(){
        return String.format("Author [id=%s, name=%s, website=%, joinDate=%s]",
                id,
                name,
                website,
                joinDate);
    }
}
