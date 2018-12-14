package us.bennowak.tts.TechTalentBlog.BlogPost;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;
    private String name_first;
    private String name_last;
    private String hash;
    private String salt;
    private String email;
    private String website;
    private String join_date;
    private String verified;
}
