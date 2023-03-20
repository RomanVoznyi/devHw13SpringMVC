package homework.controller;

import homework.model.note.Note;
import homework.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/add")
    public ModelAndView getMarkupToCreateNote() {
        ModelAndView result = new ModelAndView("note/add");
        result.addObject("note", new Note());
        return result;
    }

    @PostMapping("/add")
    public String addNewNote(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("noteList", noteService.listAll());
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView getNoteById(@RequestParam(name = "id") long id) {
        ModelAndView result = new ModelAndView("note/edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public String updateNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
