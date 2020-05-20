import java.io.IOException;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AiQueFrio {

    public static void main(String[] args) throws IOException {
        
        LinkedList<LinkedList<Integer>> grafo = ProcessaDados();  
        
        List<Integer> componentes = new LinkedList<>();

        Collection<Integer> visitados = new HashSet<>();

        for(int i = 1; i < 86319; i++){
            System.out.println(i);
            if(!visitados.contains(i)){
                int inicio = visitados.size();
                Busca(grafo, visitados, i);
                int fim = visitados.size();
                int componente = fim - inicio;
                componentes.add(componente);
            }
        }  
        
        FileWriter file = new FileWriter("Componentes.txt");
        PrintWriter saida = new PrintWriter(file);

        for(int i : componentes) saida.println(i);

        saida.close();
    }

    private static void Busca(LinkedList<LinkedList<Integer>> grafo, Collection<Integer> visitados, int no_atual){
    
        visitados.add(no_atual);

        for(int i : grafo.get(no_atual)) {

            if(!visitados.contains(i)){
                Busca(grafo, visitados, i);
            }
        }
    }

    private static LinkedList<LinkedList<Integer>> ProcessaDados() throws IOException {

        String caminho = "/home/lorenabraghini/Documents/Arquivos Faculdade/EPs/AED/OD_graph.txt"; 

        File graph = new File(caminho);
        Scanner sc = new Scanner(graph);
                
        LinkedList<LinkedList<Integer>> nosss = new LinkedList<LinkedList<Integer>>();
        
        for(int i = 0; i < 86319; i++) nosss.add(new LinkedList<Integer>());
                
        sc.nextLine();
        sc.nextLine();
    
        while(sc.hasNext()){
    
            String afff = sc.nextLine();
            String [] saco = afff.split(" ");
            
            int maria = Integer.parseInt(saco[1]);
            
            nosss.get(maria).add(Integer.parseInt(saco[0]));
        }
        sc.close();

        return nosss;   
    }    
}