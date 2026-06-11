import java.util.LinkedHashMap; // Importa LinkedHashMap
import java.util.Map; // Importa a interface Map

// Classe genérica de cache LRU (Least Recently Used)
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacidade; // Capacidade máxima do cache

    // Construtor que recebe a capacidade máxima
    public LruCache(int capacidade) {

        // Chama o construtor do LinkedHashMap
        // capacidade = tamanho inicial
        // 0.75f = fator de carga
        // true = ordenação por acesso (accessOrder)
        super(capacidade, 0.75f, true);

        this.capacidade = capacidade; // Armazena a capacidade máxima
    }

    @Override // Sobrescreve método do LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        // Remove automaticamente o elemento mais antigo
        // quando o tamanho ultrapassar a capacidade definida
        return size() > capacidade;
    }
}
