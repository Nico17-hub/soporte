package ar.com.soporte.controller;

import ar.com.soporte.entities.Clientes;
import ar.com.soporte.entities.TiposDoc;
import ar.com.soporte.entities.Usuarios;
import ar.com.soporte.services.IClientesService;
import ar.com.soporte.services.ITiposDocService;
import ar.com.soporte.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientesController {

    @Autowired
    IClientesService entityService;

    @Autowired
    ITiposDocService tiposDocService;

    @Autowired
    IUsuariosService usuariosService;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {

        Page<Clientes> page = entityService.findAll(pageable);

        model.addAttribute("entities", page.getContent());
        model.addAttribute("entity", new Clientes());

        return "../clientes/index";
    }

    @RequestMapping("clientes/refresh")
    public String refresh() {
        return "redirect:/clientes";
    }

    @RequestMapping(value = "clientes/search", method = RequestMethod.POST)
    public String search(Model model, Clientes entity) {

        if (entity.getApellido().equals("")) {
            return refresh();
        }

        model.addAttribute(
                "entities",
                entityService.findByApellido(entity.getApellido())
        );

        model.addAttribute("entity", new Clientes());

        return "../clientes/index";
    }

    @RequestMapping("clientes/create/{id}")
    public String create(@PathVariable String id, Model model) {

        Clientes entity = new Clientes();
        entity.setTipodoc(new TiposDoc());
        entity.setUsuario(new Usuarios());

        model.addAttribute("entity", entity);
        model.addAttribute("tiposdoc", tiposDocService.getAll());
        model.addAttribute("usuarios", usuariosService.getAll());

        return "../clientes/edit";
    }

    @RequestMapping("clientes/edit/{id}")
    public String edit(@PathVariable String id, Model model) {

        model.addAttribute("entity", entityService.get(id));
        model.addAttribute("tiposdoc", tiposDocService.getAll());
        model.addAttribute("usuarios", usuariosService.getAll());

        return "../clientes/edit";
    }

    @RequestMapping(value = "clientes", method = RequestMethod.POST)
    public String save(Model model, @Validated Clientes entity) {

        if (entity.getNombre().equals("")) {

            model.addAttribute("message", "Nombre Incorrecto");
            model.addAttribute("entity", entity);
            model.addAttribute("tiposdoc", tiposDocService.getAll());
            model.addAttribute("usuarios", usuariosService.getAll());

            return "../clientes/edit";
        }

        if (entity.getId() != null && entity.getId().isBlank()) {
            entity.setId(null);
        }

        entityService.save(entity);

        return "redirect:/clientes";
    }

    @RequestMapping("clientes/delete/{id}")
    public String delete(@PathVariable String id) {

        Clientes entity = entityService.get(id);

        entityService.delete(entity);

        return "redirect:/clientes";
    }
}
