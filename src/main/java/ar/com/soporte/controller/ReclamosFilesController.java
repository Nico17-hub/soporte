package ar.com.soporte.controller;

import ar.com.soporte.entities.Reclamos;
import ar.com.soporte.entities.ReclamosFiles;
import ar.com.soporte.services.IReclamosFilesService;
import ar.com.soporte.services.IReclamosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReclamosFilesController {

    @Autowired
    private IReclamosFilesService entityService;

    @Autowired
    private IReclamosService reclamosService;

    @RequestMapping(
            value = "/reclamos/{reclamoId}/files",
            method = RequestMethod.GET
    )
    public String list(
            @PathVariable String reclamoId,
            Model model) {

        Reclamos reclamo = reclamosService.get(reclamoId);

        ReclamosFiles entity = new ReclamosFiles();
        entity.setReclamo(reclamo);

        model.addAttribute("reclamo", reclamo);
        model.addAttribute(
                "entities",
                entityService.findByReclamo(reclamoId)
        );
        model.addAttribute("entity", entity);

        return "../files/index";
    }

    @RequestMapping(
            value = "/reclamos/{reclamoId}/files",
            method = RequestMethod.POST
    )
    public String save(
            @PathVariable String reclamoId,
            ReclamosFiles entity) {

        if (entity.getId() != null && entity.getId().isBlank()) {
            entity.setId(null);
        }

        Reclamos reclamo = reclamosService.get(reclamoId);

        entity.setReclamo(reclamo);

        entityService.save(entity);

        return "redirect:/reclamos/"
                + reclamoId
                + "/files";
    }

    @RequestMapping(
            value = "/reclamos/{reclamoId}/files/delete/{id}",
            method = RequestMethod.GET
    )
    public String delete(
            @PathVariable String reclamoId,
            @PathVariable String id) {

        ReclamosFiles entity = entityService.get(id);

        entityService.delete(entity);

        return "redirect:/reclamos/"
                + reclamoId
                + "/files";
    }
}