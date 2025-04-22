import lombok.Data; //não está sendo usado
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; //não está sendo usado

import java.util.List;

@NoArgsConstructor
@Setter
public class Grafo {
    private boolean isDirecionado;
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private int ordem;
    private int tamanho;

    public Grafo(boolean isDirecionado) {
        this.isDirecionado = isDirecionado;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
        ordem = vertices.size();
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
        tamanho = arestas.size();
        if (!isDirecionado) {
            verificaDirecionado();
        }
        preencherAdjancencias();
    }

    public void preencherAdjancencias() {
        for (Aresta aresta : arestas) {
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();
            avaliarGrausDosVertices(origem, destino);

            destino.addAdjacencia(origem);
            if (!isDirecionado) {
                origem.addAdjacencia(destino);
            }
        }
    }

    private void avaliarGrausDosVertices(Vertice origem, Vertice destino) {
        if (isDirecionado) {
            origem.incrementaOutDegree();
            destino.incrementaInDegree();
        }
        destino.incrementaGrau();
        origem.incrementaGrau();
    }

    public void verificaDirecionado() {
        for (int i = 0; i < arestas.size();i++) {
            if (isSelfLoop(arestas.get(i))) {
                defineComoDirecionado();
                return;
            }
            for (int j = 0; j < arestas.size(); j++) {
                if (naoEaMesmaAresta(i, j)) {
                    if (isViaMaoDupla(arestas.get(i), arestas.get(j))) {
                        defineComoDirecionado();
                        return;
                    } else if (isMesmoSentido(arestas.get(i), arestas.get(j))) {
                        defineComoDirecionado();
                        return;
                    }
                }

            }
        }
    }

    public void imprimirMatrizAdjacenciaComPeso() {
        int n = vertices.size();
        double[][] matriz = new double[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriz[i][j] = 0;
            }
        }

        for(Aresta a : arestas){
            int i = vertices.indexOf(a.getOrigem());
            int j = vertices.indexOf(a.getDestino());

            matriz[i][j] = a.getPeso();
            if(!isDirecionado){
                matriz[j][i] = a.getPeso();
            }
        }

        System.out.println("\nMatriz de Adjacências:");
        System.out.print("    ");
        for(Vertice v : vertices) {
            System.out.printf("%-10s", v.getNome());
        }
        System.out.println();

        for(int i = 0; i < n; i++) {
            System.out.printf("%-10s", vertices.get(i).getNome() + " |");
            for(int j = 0; j < n; j++) {
                System.out.printf("%-10s", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public void imprimirMatrizIncidencia() {
        int n = vertices.size();
        int m = arestas.size();
        int[][] matriz = new int[n][m];

        for(int j = 0; j < m; j++) {
            Aresta aresta = arestas.get(j);
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();

            int iOrigem = vertices.indexOf(origem);
            int iDestino = vertices.indexOf(destino);

            if(isDirecionado) {
                if(origem == destino) {
                    matriz[iOrigem][j] = 2;
                }else {
                    matriz[iOrigem][j] = -1;
                    matriz[iDestino][j] = 1;
                }
            }else {
                if(origem == destino) {
                    matriz[iOrigem][j] = 2;
                }else {
                    matriz[iOrigem][j] = 1;
                    matriz[iDestino][j] = 1;
                }
            }
        }
        System.out.println("\nMatriz de Incidência");
        System.out.printf("%-5s", "");

        for(int j = 0; j < m; j++) {
            System.out.printf("%4s", "e" + j);
        }
        System.out.println();

        for(int i = 0; i < n; i++) {
            System.out.printf("%-3s |", vertices.get(i).getNome());
            for(int j = 0; j < m; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean naoEaMesmaAresta(int i, int j) {
        return i != j;
    }

    private boolean isMesmoSentido(Aresta i, Aresta j) {
        return i.getOrigem() == j.getOrigem() && i.getDestino() == j.getDestino();
    }

    private void defineComoDirecionado() {
        isDirecionado = true;
    }

    private static boolean isViaMaoDupla(Aresta arestaAlvo, Aresta arestaInterna) {
        return arestaAlvo.getOrigem() == arestaInterna.getDestino()
                && arestaAlvo.getDestino() == arestaInterna.getOrigem();
    }

    private static boolean isSelfLoop(Aresta arestaAlvo) {
        return arestaAlvo.getOrigem() == arestaAlvo.getDestino();
    }

    @Override
    public String toString() {
        System.out.println("É direcionado: "+isDirecionado);
        System.out.println("Ordem: "+ordem);
        System.out.println("Tamanho: "+tamanho);

        System.out.println("Vértices:");
        for(Vertice v : vertices) {
            System.out.println(" * "+v);
        }

        System.out.println("Arestas:");
        for(Aresta a : arestas) {
            System.out.println(" * "+a);
        }

        return "";
    }
}