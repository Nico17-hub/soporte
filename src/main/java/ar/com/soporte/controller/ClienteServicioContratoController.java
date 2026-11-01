package ar.com.soporte.controller;

import ar.com.soporte.entities.ClienteServicioContrato;
import ar.com.soporte.entities.Servicios;
import ar.com.soporte.services.IClienteServicioContratoService;
import ar.com.soporte.services.IClientesService;
import ar.com.soporte.services.IServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ClienteServicioContratoController {

    @Autowired
    IClienteServicioContratoService entityService;

    @Autowired
    IClientesService clientesService;

    @Autowired
    IServiciosService serviciosService;

    @RequestMapping(value = "/contratos/{clienteId}", method = RequestMethod.GET)
    public String list(@PathVariable String clienteId, Model model) {

        ClienteServicioContrato entity = new ClienteServicioContrato();
        entity.setServicio(new Servicios());

        model.addAttribute(
                "entities",
                entityService.findByCliente(clienteId)
        );

        model.addAttribute(
                "cliente",
                clientesService.get(clienteId)
        );

        model.addAttribute(
                "servicios",
                serviciosService.getAll()
        );

        model.addAttribute(
                "entity",
                entity
        );

        return "../contratos/index";
    }

    @RequestMapping(value = "/contratos/{clienteId}", method = RequestMethod.POST)
    public String save(
            @PathVariable String clienteId,
            ClienteServicioContrato entity) {

        if (entity.getId() != null && entity.getId().isBlank()) {
            entity.setId(null);
        }

        entity.setCliente(clientesService.get(clienteId));
        entity.setFechaalta(new Date());

        entityService.save(entity);

        return "redirect:/contratos/" + clienteId;
    }

    @RequestMapping("/contratos/delete/{clienteId}/{id}")
    public String delete(
            @PathVariable String clienteId,
            @PathVariable String id) {

        ClienteServicioContrato entity = entityService.get(id);

        entityService.delete(entity);

        return "redirect:/contratos/" + clienteId;
    }
}
