import java.util.Map;

// Classe de teste para demonstrar o funcionamento do LRU Cache
public class TesteLRU {

    public static void main(String[] args) {

        // Cria um cache LRU com capacidade máxima de 3 elementos
        Map<String, Integer> cache = new LruCache<>(3);         

        // Adiciona 3 elementos ao cache (a=1, b=2, c=3)
        // O cache está cheio com estes 3 elementos
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        // Acessa o elemento "a", movendo-o para o final (mais recentemente usado)
        cache.get("a");
        
        // Adiciona um novo elemento "d" ao cache
        // Como o cache está cheio (tamanho 3), o elemento menos recentemente usado ("b") é removido
        cache.put("d", 4);

        // Verifica quais elementos ainda estão no cache
        // Resultado esperado: a, c, d estão presentes; b foi removido
        System.out.println("Contém a? " + cache.containsKey("a"));  // true (foi acessado antes de d ser adicionado)
        System.out.println("Contém b? " + cache.containsKey("b"));  // false (foi removido por ser o menos usado)
        System.out.println("Contém c? " + cache.containsKey("c"));  // true (ainda está na cache)
        System.out.println("Contém d? " + cache.containsKey("d"));  // true (foi adicionado recentemente)
    }
}