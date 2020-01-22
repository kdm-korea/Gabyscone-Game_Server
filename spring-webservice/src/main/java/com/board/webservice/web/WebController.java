package com.board.webservice.web;

import com.board.webservice.dto.posts.PostsSaveRequestDto;
import com.board.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        //System.out.println(model.getAttribute("posts"));
        return "main";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        postsService.delete(id);
        return "redirect:/";
    }
}
