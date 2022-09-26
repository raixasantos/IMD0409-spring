package com.jeanlima.mvcapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jeanlima.mvcapp.model.Curso;

@Service
@Component
public class CursoService {

    public List<Curso> cursos = new ArrayList<>(Arrays.asList(new Curso("BTI", 0), 
        new Curso("EngSoft", 1), new Curso("EngComp", 2)));

    public void adicionarCurso(Curso curso) {
        try{
            curso.setId(cursos.size());
            this.cursos.add(curso);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }       
    }

    public Curso getCursoById(Integer id) {
        for (Curso curso : cursos) {
            if(curso.getId() == id){
                return curso;
            }
        }
        return null;
    }

    public List<Curso> getListaCurso() {
        return this.cursos;
    }
}
