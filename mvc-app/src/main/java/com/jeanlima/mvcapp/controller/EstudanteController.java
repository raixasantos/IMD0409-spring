package com.jeanlima.mvcapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeanlima.mvcapp.model.Curso;
import com.jeanlima.mvcapp.model.Estudante;
import com.jeanlima.mvcapp.service.CursoService;
import com.jeanlima.mvcapp.service.EstudanteService;

@Controller
@RequestMapping("/estudante")
public class EstudanteController {


    @Autowired
    @Qualifier("estudanteServiceImpl")
    EstudanteService estudanteService;

    @Autowired
    @Qualifier("cursoService")
    CursoService cursoService;

    @RequestMapping("/showForm")
    public String showFormEstudante(Model model){
 
        model.addAttribute("estudante", new Estudante());
        List<Curso> cursos = cursoService.getListaCurso();
        model.addAttribute("cursos", cursos);
        return "estudante/formEstudante";
    }

    @RequestMapping("/addEstudante")
    public String showFormEstudante(@ModelAttribute("estudante") Estudante estudante,  Model model){

        estudanteService.salvarEstudante(estudante);
        model.addAttribute("estudante", estudante);
        return "estudante/paginaEstudante";
    }

    @RequestMapping("/getListaEstudantes")
    public String showListaEstudante(Model model){

        List<Estudante> estudantes = estudanteService.getListaEstudante();
        model.addAttribute("estudantes",estudantes);
        return "estudante/listaEstudantes";

    }

    @RequestMapping("/getEstudante")
    public String showEstudante(@RequestParam(value = "id", required = true) Integer id, 
        Model model){
        
        model.addAttribute("id", id);
        Estudante estudante = estudanteService.getEstudanteById(id);
        model.addAttribute("estudante",estudante);
        return "estudante/detalhesEstudante";

    }

    @RequestMapping("/deleteEstudante")
    public String deleteEstudante(@RequestParam(value = "id", required = true) Integer id, 
        Model model){
        
        model.addAttribute("id", id);
        estudanteService.deletarEstudante(id);
        List<Estudante> estudantes = estudanteService.getListaEstudante();
        model.addAttribute("estudantes",estudantes);
        return "estudante/listaEstudantes";

    }
    
    @RequestMapping("/getEstudantesByCurso")
    public String showEstudantesByCurso(Model model){
        List<Curso> cursos = cursoService.getListaCurso();
        model.addAttribute("cursos", cursos);
        List<Estudante> estudantes = estudanteService.getListaEstudante();
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("numEstudantes", estudantes.size());
        return "estudante/estudantesPorCurso";
    
    }
    
    @RequestMapping("/getEstudantesByLinguagem")
    public String showEstudantesByLinguagem(Model model){
        List<String> linguagens = new ArrayList<>(Arrays.asList("Java", "C", "Python", "Javascript"));
        model.addAttribute("linguagens",linguagens);
        List<Estudante> estudantes = estudanteService.getListaEstudante();
        model.addAttribute("estudantes",estudantes);
        model.addAttribute("numEstudantes", estudantes.size());    
        return "estudante/estudantesPorLinguagem";
    
    }

}
