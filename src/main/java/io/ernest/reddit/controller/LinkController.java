package io.ernest.reddit.controller;

import io.ernest.reddit.domain.Link;
import io.ernest.reddit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkRepository linkRepository;

    @Autowired
    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public List<Link> list() {
        return linkRepository.findAll();
    }

    @PostMapping("/create")
    public Link create(@ModelAttribute Link link) {
        return linkRepository.save(link);
    }

    @GetMapping("/{id}")
    public Optional<Link> get(@PathVariable("id") Long id) {
        return linkRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Link update(@ModelAttribute Link link, @PathVariable("id") Long id) {
        return linkRepository.save(link);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable("id") Long id) {
        linkRepository.deleteById(id);
    }
}
