import java.util.Map;

// Classe de teste para demonstrar o funcionamento do LRU Cache
public class TesteLRU {

    public static void main(String[] args) {

        // Cria um cache LRU com capacidade máxima de 3 elementos
        Map<String, Integer> cache = new LruCache<>(3);         

        // Adiciona 3 elementos ao cache
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        // Acessa o elemento "a", movendo-o para o final (mais recentemente usado)
        cache.get("a");
        
        // Adiciona um novo elemento "d" ao cache       
        cache.put("d", 4);

        // Verifica quais elementos ainda estão no cache
        System.out.println("Contém a? " + cache.containsKey("a"));  
        System.out.println("Contém b? " + cache.containsKey("b"));  
        System.out.println("Contém c? " + cache.containsKey("c"));  
        System.out.println("Contém d? " + cache.containsKey("d"));
    }
}
