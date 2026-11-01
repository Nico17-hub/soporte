package ar.com.soporte.controller;

import ar.com.soporte.entities.ClienteServicioContrato;
import ar.com.soporte.entities.Clientes;
import ar.com.soporte.entities.MotivosReclamos;
import ar.com.soporte.entities.Reclamos;
import ar.com.soporte.entities.ReclamosEstados;
import ar.com.soporte.services.IClienteServicioContratoService;
import ar.com.soporte.services.IClientesService;
import ar.com.soporte.services.IMotivosReclamosService;
import ar.com.soporte.services.IReclamosEstadosService;
import ar.com.soporte.services.IReclamosService;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReclamosController {

    @Autowired
    private IReclamosService entityService;

    @Autowired
    private IClientesService clientesService;

    @Autowired
    private IClienteServicioContratoService contratosService;

    @Autowired
    private IMotivosReclamosService motivosService;

    @Autowired
    private IReclamosEstadosService estadosService;

    @RequestMapping(value = "/reclamos", method = RequestMethod.GET)
    public String list(Model model) {

        Pageable pageable = PageRequest.of(0, 20);
        Page<Reclamos> entities = entityService.findAll(pageable);

        model.addAttribute("entities", entities);
        model.addAttribute("entity", new Reclamos());

        return "../reclamos/index";
    }

    @RequestMapping(value = "/reclamos/create/{id}", method = RequestMethod.GET)
    public String create(@PathVariable String id, Map<String, Object> model) {

        Reclamos entity = new Reclamos();

        entity.setClienteservicio(new ClienteServicioContrato());
        entity.setMotivo(new MotivosReclamos());
        entity.setEstado(new ReclamosEstados());

        if (!id.equals("0")) {

            Clientes cliente = clientesService.get(id);

            entity.setCliente(cliente);

            model.put("contratos", contratosService.findByCliente(id));
            model.put("clienteSeleccionado", true);

        } else {

            entity.setCliente(new Clientes());

            model.put("contratos", contratosService.getAll());
            model.put("clienteSeleccionado", false);
        }

        model.put("entity", entity);
        model.put("clientes", clientesService.getAll());
        model.put("motivos", motivosService.getAll());
        model.put("estados", estadosService.getAll());

        return "../reclamos/edit";
    }

    @RequestMapping(value = "/reclamos/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Map<String, Object> model) {

        Reclamos entity = entityService.get(id);

        model.put("entity", entity);
        model.put("clientes", clientesService.getAll());
        model.put(
                "contratos",
                contratosService.findByCliente(entity.getCliente().getId())
        );
        model.put("motivos", motivosService.getAll());
        model.put("estados", estadosService.getAll());

        model.put("clienteSeleccionado", true);

        return "../reclamos/edit";
    }

    @RequestMapping(value = "/reclamos", method = RequestMethod.POST)
    public String save(@Validated Reclamos entity, Model model) {

        if (entity.getId() != null && entity.getId().isBlank()) {
            entity.setId(null);
        }

        if (entity.getId() == null) {

            entity.setFecha(new Date());
            entity.setFechahora(new Date());

        } else {

            Reclamos anterior = entityService.get(entity.getId());

            entity.setFecha(anterior.getFecha());
            entity.setFechahora(anterior.getFechahora());
        }

        entityService.save(entity);

        return "redirect:/reclamos/cliente/" + entity.getCliente().getId();
    }

    @RequestMapping(value = "/reclamos/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id) {

        Reclamos entity = entityService.get(id);

        entityService.delete(entity);

        return "redirect:/reclamos";
    }

    @RequestMapping(value = "/reclamos/cliente/{clienteId}", method = RequestMethod.GET)
    public String reclamosCliente(
            @PathVariable String clienteId,
            Model model) {

        Clientes cliente = clientesService.get(clienteId);

        model.addAttribute(
                "entities",
                entityService.findByCliente(clienteId)
        );

        model.addAttribute("cliente", cliente);

        return "../reclamos/index";
    }
}
