package com.empresa.controller;

import com.empresa.model.TipoContratacion;
import com.empresa.repository.TipoContratacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tipos-contratacion")
public class TipoContratacionController {
    
    @Autowired
    private TipoContratacionRepository tipoContratacionRepository;
    
    @GetMapping
    public String listarTiposContratacion(Model model) {
        model.addAttribute("tiposContratacion", tipoContratacionRepository.findAll());
        return "tipo-contratacion";
    }
    
    @PostMapping("/guardar")
    public String guardarTipoContratacion(@ModelAttribute TipoContratacion tipoContratacion) {
        tipoContratacionRepository.save(tipoContratacion);
        return "redirect:/tipos-contratacion";
    }
    
    @GetMapping("/editar/{id}")
    @ResponseBody
    public TipoContratacion obtenerTipoContratacion(@PathVariable Integer id) {
        return tipoContratacionRepository.findById(id).orElse(null);
    }
    
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public void eliminarTipoContratacion(@PathVariable Integer id) {
        tipoContratacionRepository.deleteById(id);
    }
}
