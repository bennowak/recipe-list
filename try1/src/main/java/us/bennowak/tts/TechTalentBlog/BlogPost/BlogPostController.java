/**
 * 
 */
package us.bennowak.tts.TechTalentBlog.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ben
 *
 */
@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;

	private static List<BlogPost> posts = new ArrayList<>();

	//private BlogPost blogPost;

	@GetMapping("/")
//  PREVIOUS BAD CODE
//	public String index(BlogPost blogPost, Model model) {
//		model.addAttribute("pageTitle", "Home");
//		model.addAttribute("posts", blogPostRepository.findAll());
//		return "blogpost/index";
//	}
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("blogpost/index");
		mv.addObject("blogPosts", blogPostRepository.findAll());
		return mv;
	}

	@GetMapping("/blogs")
	public String blogs(BlogPost blogPost, Model model) {
		model.addAttribute("pageTitle", "Blogs");
		return "blogpost/blogs";
	}

	@GetMapping("/authors")
	public String authors(BlogPost blogPost, Model model) {
		model.addAttribute("pageTitle", "Authors");
		return "blogpost/authors";
	}

	@GetMapping("/featured")
	public String featured(BlogPost blogPost, Model model) {
		model.addAttribute("pageTitle", "Featured");
		return "blogpost/featured";
	}

	@GetMapping("/collections")
	public String collections(BlogPost blogPost, Model model) {
		model.addAttribute("pageTitle", "Collections");
		return "blogpost/collections";
	}

	@GetMapping(value = "/blog_posts/new")
	public ModelAndView newPostForm (BlogPost blogPost) {
		return new ModelAndView("blogpost/newPost");

	}

	@PostMapping(value = "/blog_posts/newPost")
	public ModelAndView createNewPost(BlogPost blogPost) {
		ModelAndView mv = new ModelAndView("blogpost/result");
		BlogPost post = blogPostRepository.save(blogPost);
		mv.addObject("post", post);
		return mv;
//		blogPostRepository.save(blogPost);
//		posts.add(blogPost);
//		model.addAttribute("title", blogPost.getTitle());
//		model.addAttribute("author", blogPost.getAuthor());
//		model.addAttribute("blogEntry", blogPost.getBlogEntry());
//		return "blogpost/result";
	}

	@GetMapping(value = "/blog_post/detail/{id}")
	public ModelAndView showPostDetail(@PathVariable("id") long id){
		ModelAndView mv = new ModelAndView("blogpost/detail/view");
		Optional<BlogPost> post = blogPostRepository.findById(id);
		if(post.isPresent()){
			mv.addObject("blogPost", post.get());
		} else {
			mv.addObject("blogPost", new BlogPost("ERROR", "None", "You have attempted to view a blog that doesn't exist)"));
		}
		return mv;
	}
	///////WORK ON THIS
//	@GetMapping(value = "/blog_post/editPost")
//	public String postDetail(BlogPost blogPost, Model model){
//
//		return "blogpost/edit";
//	}
//
//	@RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.DELETE)
//	public String deletePostWithId(@PathVariable Long id,
//								   BlogPost blogPost) {
//
//		blogPostRepository.deleteById(id);
//		return "blogpost/delete";
//
//	}
}
