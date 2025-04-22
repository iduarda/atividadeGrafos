import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Vertice {
    private String nome;
    private List<Vertice> adjacencias = new ArrayList<>();
    private int grau; //direc = inDegree + outDegree
    private int inDegree;
    private int outDegree;

    public Vertice(String nome) {
        this.nome = nome;
    }

    public void addAdjacencia(Vertice vertice) {
        adjacencias.add(vertice);
    }
    public void incrementaGrau(){
        grau++;
    }
    public void incrementaInDegree(){
        inDegree++;
    }
    public void incrementaOutDegree(){
        outDegree++;
    }

    @Override
    public String toString() {
        String resultado = nome+"[grau: "+grau;

        if (inDegree > 0 || outDegree > 0){
            resultado += ", inDegree: "+inDegree+", outDegree: "+outDegree;
        }

        if(!adjacencias.isEmpty()){
            String adjacenciasNome = adjacencias.stream()
                    .map(Vertice::getNome)
                    .collect(Collectors.joining(", "));
            resultado += ", adjacências: "+adjacenciasNome;
        }

        return resultado + "]";
    }
}