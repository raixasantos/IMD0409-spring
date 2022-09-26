package com.jeanlima.mvcapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeanlima.mvcapp.model.Estudante;

@Service
public interface EstudanteService {

    

    public void salvarEstudante(Estudante estudante);
    public void deletarEstudante(Integer id);
    public Estudante getEstudanteById(Integer id);
    public List<Estudante> getListaEstudante();
    public List<Estudante> getEstudantesByCurso(String curso);
    public List<Estudante> getEstudantesByLinguagem(String linguagem);



    
    
    
}
