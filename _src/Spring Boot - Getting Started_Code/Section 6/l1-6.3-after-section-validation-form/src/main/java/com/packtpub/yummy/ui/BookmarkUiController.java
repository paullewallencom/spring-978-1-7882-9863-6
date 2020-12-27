package com.packtpub.yummy.ui;

import com.packtpub.yummy.model.Bookmark;
import com.packtpub.yummy.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/bookmark/")
public class BookmarkUiController {
    @Autowired
    BookmarkService bookmarkService;

    @GetMapping("{id}")
    public String details(@PathVariable UUID id, Model model) {
        model.addAttribute("bookmark", bookmarkService.find(id));
        return "bookmark/details";
    }

    @GetMapping(value = "{id}", params = "edit=true")
    public String editForm(@PathVariable UUID id, Model model) {
        model.addAttribute("bookmark", bookmarkService.find(id));
        model.addAttribute("isEdit", true);
        return "bookmark/edit";
    }

    @GetMapping()
    public String addForm(Model model) {
        model.addAttribute("bookmark", new Bookmark());
        model.addAttribute("isEdit", false);
        return "bookmark/edit";
    }

    @PostMapping("{id}")
    public String saveBookmark(@PathVariable UUID id, Bookmark bookmark) {
        bookmark.setUuid(id);
        bookmarkService.update(bookmark);
        return "redirect:/";
    }

    @PostMapping
    public String addBookmark(Bookmark bookmark) {
        bookmarkService.addBookmark(bookmark);
        return "redirect:/";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable UUID id) {
        bookmarkService.delete(id);
        return "redirect:/";
    }
}
