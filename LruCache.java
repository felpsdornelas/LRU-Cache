import java.util.LinkedHashMap;
import java.util.Map;

// Classe genérica que implementa um cache LRU (Least Recently Used)
// K = tipo da chave (Key)
// V = tipo do valor (Value)
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    // Quantidade máxima de elementos que o cache pode armazenar
    private final int capacidade;

    // Construtor da classe
    public LruCache(int capacidade) {

        /*
         * Chama o construtor da classe LinkedHashMap
         *
         * capacidade -> capacidade inicial do mapa
         * 0.75f -> fator de carga (load factor)
         * true -> accessOrder
         *
         * Quando accessOrder = true, os elementos são organizados
         * pela ordem de acesso. Sempre que um get() é realizado,
         * o elemento acessado é movido para o final da lista.
         *
         * Isso permite implementar a política LRU.
         */
        super(capacidade, 0.75f, true);

        // Armazena a capacidade máxima do cache
        this.capacidade = capacidade;
    }

    /*
     * Método chamado automaticamente após cada inserção (put).
     *
     * eldest representa o elemento mais antigo da estrutura.
     *
     * Se retornar true, o elemento mais antigo será removido.
     * Se retornar false, nenhum elemento será removido.
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        // Quando o tamanho ultrapassar a capacidade definida,
        // remove automaticamente o elemento menos recentemente utilizado.
        return size() > capacidade;
    }
}