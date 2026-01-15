package ca.tetervak.abcblocks.controller;

import ca.tetervak.abcblocks.domain.Blocks;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class BlocksController {

    @GetMapping("/")
    public String redirectToBlocks() {
        log.trace("redirectToBlocks() is called");
        return "redirect:/blocks";
    }

    @GetMapping("/blocks")
    public String displayBlocks(
            HttpSession session,
            Model model
    ) {
        log.trace("displayBlocks() is called");
        Blocks blocks = getBlocks(session);
        model.addAttribute("letters", blocks.getLetters());
        return "blocks-data";
    }

    private Blocks getBlocks(HttpSession session) {
        log.trace("getBlocks() is called");
        Blocks blocks = (Blocks) session.getAttribute("blocks");
        if(blocks == null){
            log.trace("Blocks object is not found in the Session; making new Blocks object");
            blocks = new Blocks();
            session.setAttribute("blocks", blocks);
        }else{
            log.trace("Previous Blocks object is found in the Session");
        }
        return blocks;
    }

    @PostMapping("/process")
    public String processBlocks(
            @RequestParam String todo,
            HttpSession session
    ) {
        log.trace("processBlocks() is called");
        Blocks blocks = getBlocks(session);
        switch (todo) {
            case "reverse" -> blocks.reverseBlocks();
            case "sort" -> blocks.sortBlocks();
            case "shuffle" -> blocks.shuffleBlocks();
        }
        return "redirect:/blocks";
    }


}
