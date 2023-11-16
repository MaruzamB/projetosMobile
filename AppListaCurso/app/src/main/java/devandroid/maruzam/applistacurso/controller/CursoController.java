package devandroid.maruzam.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.maruzam.applistacurso.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaCursos(){

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("PHP"));
        listCursos.add(new Curso("Python"));

        return listCursos;
    }

    public ArrayList<String> dadosSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size() ; i++) {

            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;

    }



}
