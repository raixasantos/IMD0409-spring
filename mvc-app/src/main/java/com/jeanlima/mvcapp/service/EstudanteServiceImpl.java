package com.jeanlima.mvcapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jeanlima.mvcapp.model.Estudante;

@Component
public class EstudanteServiceImpl implements EstudanteService{

    public List<Estudante> estudantes = new ArrayList<Estudante>();    

    @Override
    public void salvarEstudante(Estudante estudante) {
        System.out.println(estudante.toString());
        try{
            estudante.setId(estudantes.size());
            this.estudantes.add(estudante);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        
    }

    @Override
    public void deletarEstudante(Integer id) { 
        Estudante estudanteRequisitado = new Estudante();
        for (Estudante estudante : estudantes) {
            if(estudante.getId() == id){
                estudanteRequisitado = estudante; 
            }
        }    
        this.estudantes.remove(estudanteRequisitado); 
    }

    @Override
    public Estudante getEstudanteById(Integer id) {
        for (Estudante estudante : estudantes) {
            if(estudante.getId() == id){
                return estudante;
            }
        }
        return null;
    }

    @Override
    public List<Estudante> getListaEstudante() {
        return this.estudantes;
    }
    
    @Override
    public List<Estudante> getEstudantesByCurso(String curso) {
        List<Estudante> estudantesPorCurso = new ArrayList<Estudante>();
        for (Estudante estudante : estudantes) {
            if(estudante.getCurso() == curso){
                estudantesPorCurso.add(estudante);
            }
        }
        return estudantesPorCurso;
    }
    
    @Override
    public List<Estudante> getEstudantesByLinguagem(String linguagem) {
        List<Estudante> estudantesPorLinguagem = new ArrayList<Estudante>();
        for (Estudante estudante : estudantes) {
            if(estudante.getLinguagem() == linguagem){
                estudantesPorLinguagem.add(estudante);
            }
        }
        return estudantesPorLinguagem;
    }
}
