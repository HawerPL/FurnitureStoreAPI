package com.furniturestoreapi.controllers;
import com.furniturestoreapi.accessingDataJPA.SectionRepository;
import com.furniturestoreapi.models.Message;
import com.furniturestoreapi.models.Section;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("Section")
public class SectionController {

    SectionRepository sectionRepository;

    public SectionController(SectionRepository repository){
        this.sectionRepository = repository;

        Section section0 = new Section("O nas", "<hr><p><span class=\"text-big\" style=\"color:hsl(0, 0%, 90%);font-family:Arial, Helvetica, sans-serif;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec posuere nec leo ut aliquam. Proin faucibus porta turpis ut lacinia. Nam volutpat massa a interdum facilisis. Curabitur blandit magna a imperdiet vulputate. <strong>Curabitur </strong>sit amet arcu non odio rutrum laoreet. Donec ultricies cursus justo, <strong>eget mattis</strong> nulla faucibus quis. Morbi fringilla ac risus sed tristique. Nulla tincidunt pretium mauris non pretium. Quisque porta tristique nibh, sit amet venenatis ante pretium a. Sed sed sagittis turpis.</span></p><hr><p>&nbsp;</p>", 10);
        Section section1 = new Section("Kontakt", "<hr><h2 style=\"text-align:center;\"><strong>Godziny otwarcia</strong></h2><p style=\"text-align:center;\"><strong>Poniedziałek - Piątek</strong></p><p style=\"text-align:center;\">9:00 - 15:00</p><p style=\"text-align:center;\"><strong>Sobota&nbsp;</strong></p><p style=\"text-align:center;\">12:00 - 14:00</p><h2 style=\"text-align:center;\"><strong>Odwiedź nasz salony</strong></h2><p style=\"text-align:center;\">Warszawa, aleje Jerozolimskie 329</p><p style=\"text-align:center;\">Kraków, ul. Kasztanowa 23</p><p style=\"text-align:center;\">Wrocław, ul. Lecha Wałęsy 86</p><hr><p>&nbsp;</p>", 20);

        if(sectionRepository.count() == 0){
            sectionRepository.save(section0);
            sectionRepository.save(section1);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Section>> Get(){
        return ResponseEntity.ok(sectionRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Section>> Get(@PathVariable Long id) {

        return ResponseEntity.ok(sectionRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> Delete(@PathVariable Long id){

        sectionRepository.deleteById(id);
        Message message = new Message("Section was deleted successfully");

        return ResponseEntity.ok(message);
    }

    @PostMapping()
    public ResponseEntity<Message> Add(@RequestBody Section Section){

        sectionRepository.save(Section);
        Message message = new Message("Section was added successfully");

        return ResponseEntity.ok(message);
    }
}
