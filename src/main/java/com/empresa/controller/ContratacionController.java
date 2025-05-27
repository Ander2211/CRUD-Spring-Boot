package com.empresa.controller;

import com.empresa.model.Contratacion;
import com.empresa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contrataciones")
public class ContratacionController {
    
    @Autowired
    private ContratacionRepository contratacionRepository;
    
    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private CargoRepository cargoRepository;
    
    @Autowired
    private TipoContratacionRepository tipoContratacionRepository;
    
    @GetMapping
    public String listarContrataciones(Model model) {
        model.addAttribute("contrataciones", contratacionRepository.findAll());
        model.addAttribute("departamentos", departamentoRepository.findAll());
        model.addAttribute("empleados", empleadoRepository.findAll());
        model.addAttribute("cargos", cargoRepository.findAll());
        model.addAttribute("tiposContratacion", tipoContratacionRepository.findAll());
        return "contratacion";
    }
    
    @PostMapping("/guardar")
    public String guardarContratacion(@ModelAttribute Contratacion contratacion) {
        contratacionRepository.save(contratacion);
        return "redirect:/contrataciones";
    }
    
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Contratacion obtenerContratacion(@PathVariable Integer id) {
        return contratacionRepository.findById(id).orElse(null);
    }
    
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public void eliminarContratacion(@PathVariable Integer id) {
        contratacionRepository.deleteById(id);
    }
}
