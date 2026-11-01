package ar.com.soporte.controller;

import ar.com.soporte.entities.Usuarios;
import ar.com.soporte.services.IRolesService;
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
public class UsuariosController {

    @Autowired
    IUsuariosService entityService;

    @Autowired
    IRolesService rolesService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {

        Page<Usuarios> page = entityService.findAll(pageable);

        model.addAttribute("entities", page.getContent());
        model.addAttribute("entity", new Usuarios());

        return "../usuarios/index";
    }

    @RequestMapping("usuarios/refresh")
    public String refresh() {
        return "redirect:/usuarios";
    }

    @RequestMapping(value = "usuarios/search", method = RequestMethod.POST)
    public String search(Model model, Usuarios entity) {

        if (entity.getUsername().equals("")) {
            return refresh();
        }

        model.addAttribute(
                "entities",
                entityService.findByUsername(entity.getUsername())
        );

        model.addAttribute("entity", new Usuarios());

        return "../usuarios/index";
    }

    @RequestMapping("usuarios/create/{id}")
    public String create(@PathVariable Integer id, Model model) {

        model.addAttribute("entity", new Usuarios());
        model.addAttribute("roles", rolesService.getAll());

        return "../usuarios/edit";
    }

    @RequestMapping("usuarios/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("entity", entityService.get(id));
        model.addAttribute("roles", rolesService.getAll());

        return "../usuarios/edit";
    }

    @RequestMapping(value = "usuarios", method = RequestMethod.POST)
    public String save(Model model, @Validated Usuarios entity) {

        if (entity.getUsername().equals("")) {

            model.addAttribute("message", "Usuario Incorrecto");
            model.addAttribute("entity", entity);
            model.addAttribute("roles", rolesService.getAll());

            return "../usuarios/edit";
        }

        entityService.save(entity);

        return "redirect:/usuarios";
    }

    @RequestMapping("usuarios/delete/{id}")
    public String delete(@PathVariable Integer id) {

        Usuarios entity = entityService.get(id);

        entityService.delete(entity);

        return "redirect:/usuarios";
    }
}
