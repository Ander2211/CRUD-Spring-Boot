package com.empresa.controller;

import com.empresa.model.Departamento;
import com.empresa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    @GetMapping
    public String listarDepartamentos(Model model) {
        model.addAttribute("departamentos", departamentoRepository.findAll());
        return "departamento";
    }
    
    @PostMapping("/guardar")
    public String guardarDepartamento(@ModelAttribute Departamento departamento) {
        departamentoRepository.save(departamento);
        return "redirect:/departamentos";
    }
    
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Departamento obtenerDepartamento(@PathVariable Integer id) {
        return departamentoRepository.findById(id).orElse(null);
    }
    
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public void eliminarDepartamento(@PathVariable Integer id) {
        departamentoRepository.deleteById(id);
    }
}
