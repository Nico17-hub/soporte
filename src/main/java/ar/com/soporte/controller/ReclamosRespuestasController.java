package ar.com.soporte.controller;

import ar.com.soporte.entities.Reclamos;
import ar.com.soporte.entities.ReclamosRespuestas;
import ar.com.soporte.services.IReclamosRespuestasService;
import ar.com.soporte.services.IReclamosService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReclamosRespuestasController {

    @Autowired
    private IReclamosRespuestasService entityService;

    @Autowired
    private IReclamosService reclamosService;

    @RequestMapping(
            value = "/reclamos/{reclamoId}/respuestas",
            method = RequestMethod.GET
    )
    public String list(
            @PathVariable String reclamoId,
            Model model) {

        Reclamos reclamo = reclamosService.get(reclamoId);

        ReclamosRespuestas entity = new ReclamosRespuestas();
        entity.setReclamo(reclamo);

        model.addAttribute("reclamo", reclamo);
        model.addAttribute(
                "entities",
                entityService.findByReclamo(reclamoId)
        );
        model.addAttribute("entity", entity);

        return "../respuestas/index";
    }

    @RequestMapping(
            value = "/reclamos/{reclamoId}/respuestas",
            method = RequestMethod.POST
    )
    public String save(
            @PathVariable String reclamoId,
            ReclamosRespuestas entity) {

        if (entity.getId() != null && entity.getId().isBlank()) {
            entity.setId(null);
        }

        Reclamos reclamo = reclamosService.get(reclamoId);

        entity.setReclamo(reclamo);
        entity.setFecha(new Date());
        entity.setFechahora(new Date());

        entityService.save(entity);

        return "redirect:/reclamos/"
                + reclamoId
                + "/respuestas";
    }

    @RequestMapping(
            value = "/reclamos/{reclamoId}/respuestas/delete/{id}",
            method = RequestMethod.GET
    )
    public String delete(
            @PathVariable String reclamoId,
            @PathVariable String id) {

        ReclamosRespuestas entity = entityService.get(id);

        entityService.delete(entity);

        return "redirect:/reclamos/"
                + reclamoId
                + "/respuestas";
    }
}