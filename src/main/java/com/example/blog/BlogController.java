package com.example.blog;

import com.example.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BlogController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public ModelAndView homePage(Model model){
        ModelAndView modelAndView = new ModelAndView("blog");
        modelAndView.addObject("title", "Your Geek Mate");
        modelAndView.addObject("articles",articleRepository.findAllByOrderByCreatedAtDesc());
        return modelAndView;
    }

    @GetMapping("/article/{slug}")
    public ModelAndView articleBySlug(@PathVariable String slug){
        ModelAndView modelAndView = new ModelAndView("article");
        modelAndView.addObject("title", "Your Geek Mate");
        modelAndView.addObject("article",articleRepository.findByPostSlug(slug));
        return modelAndView;
    }
}
