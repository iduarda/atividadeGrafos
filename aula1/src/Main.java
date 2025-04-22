import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        Vertice ac = new Vertice("AC"); // Acre
        Vertice al = new Vertice("AL"); // Alagoas
        Vertice am = new Vertice("AM"); // Amazonas
        Vertice ap = new Vertice("AP"); // Amapá
        Vertice ba = new Vertice("BA"); // Bahia
        Vertice ce = new Vertice("CE"); // Ceará
        Vertice df = new Vertice("DF"); // Distrito Federal
        Vertice es = new Vertice("ES"); // Espírito Santo
        Vertice go = new Vertice("GO"); // Goiás
        Vertice ma = new Vertice("MA"); // Maranhão
        Vertice mg = new Vertice("MG"); // Minas Gerais
        Vertice ms = new Vertice("MS"); // Mato Grosso do Sul
        Vertice mt = new Vertice("MT"); // Mato Grosso
        Vertice pa = new Vertice("PA"); // Pará
        Vertice pb = new Vertice("PB"); // Paraíba
        Vertice pe = new Vertice("PE"); // Pernambuco
        Vertice pi = new Vertice("PI"); // Piauí
        Vertice pr = new Vertice("PR"); // Paraná
        Vertice rj = new Vertice("RJ"); // Rio de Janeiro
        Vertice rn = new Vertice("RN"); // Rio Grande do Norte
        Vertice ro = new Vertice("RO"); // Rondônia
        Vertice rr = new Vertice("RR"); // Roraima
        Vertice rs = new Vertice("RS"); // Rio Grande do Sul
        Vertice sc = new Vertice("SC"); // Santa Catarina
        Vertice se = new Vertice("SE"); // Sergipe
        Vertice sp = new Vertice("SP"); // São Paulo
        Vertice to = new Vertice("TO"); // Tocantins

        g.setVertices(Arrays.asList(ac, al, am, ap, ba, ce, df, es, go, ma, mg, ms, mt, pa, pb, pe, pi, pr, rj, rn, ro, rr, rs, sc, se, sp, to));

        Aresta a1 = new Aresta(am, pa, 1783.0);
        Aresta a2 = new Aresta(am, rr, 958.0);
        Aresta a3 = new Aresta(am, ac, 1165.0);
        Aresta a4 = new Aresta(am, ro, 1230.0);
        Aresta a5 = new Aresta(am, mt, 1118.0);
        Aresta a6 = new Aresta(am, to, 526.0);
        Aresta a7 = new Aresta(ac, ro, 610.0);
        Aresta a8 = new Aresta(pa, ma, 815.0);
        Aresta a9 = new Aresta(pa, to, 1245.0);
        Aresta a10 = new Aresta(pa, mt, 1207.0);
        Aresta a11 = new Aresta(pa, ap, 597.0);
        Aresta a12 = new Aresta(ma, pi, 764.0);
        Aresta a13 = new Aresta(ma, to, 860.0);
        Aresta a14 = new Aresta(to, go, 935.0);
        Aresta a15 = new Aresta(to, ba, 970.0);
        Aresta a16 = new Aresta(to, pi, 790.0);
        Aresta a17 = new Aresta(ba, go, 1017.0);
        Aresta a18 = new Aresta(ba, mg, 1360.0);
        Aresta a19 = new Aresta(ba, pe, 670.0);
        Aresta a20 = new Aresta(ba, pi, 570.0);
        Aresta a21 = new Aresta(ba, se, 330.0);
        Aresta a22 = new Aresta(mg, sp, 997.0);
        Aresta a23 = new Aresta(mg, rj, 837.0);
        Aresta a24 = new Aresta(mg, es, 1013.0);
        Aresta a25 = new Aresta(go, mt, 755.0);
        Aresta a26 = new Aresta(go, ms, 740.0);
        Aresta a27 = new Aresta(go, df, 210.0);
        Aresta a28 = new Aresta(mt, ms, 1119.0);
        Aresta a29 = new Aresta(ms, pr, 1055.0);
        Aresta a30 = new Aresta(pr, sc, 620.0);
        Aresta a31 = new Aresta(sc, rs, 722.0);
        Aresta a32 = new Aresta(sp, pr, 622.0);
        Aresta a33 = new Aresta(sp, rj, 442.0);
        Aresta a34 = new Aresta(es, rj, 317.0);
        Aresta a35 = new Aresta(pe, pb, 516.0);
        Aresta a36 = new Aresta(pe, al, 305.0);
        Aresta a37 = new Aresta(al, se, 224.0);
        Aresta a38 = new Aresta(ce, pi, 484.0);
        Aresta a39 = new Aresta(ce, pe, 563.0);
        Aresta a40 = new Aresta(ce, pb, 248.0);
        Aresta a41 = new Aresta(pb, rn, 195.0);
        Aresta a42 = new Aresta(rn, ce, 395.0);

        g.setArestas(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38, a39, a40, a41, a42));

        System.out.println(g);
        g.imprimirMatrizAdjacenciaComPeso();
        //g.imprimirMatrizIncidencia();
    }
}