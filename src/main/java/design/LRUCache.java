package design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/4/20 14:39
 * 基于LinkedHashMap实现一个简单的LRU缓存,每次访问过的元素会被放到链表尾部,当超出cacheSize后,会删除头结点
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;


    /**
     * 初始化方法
     *
     * @param cacheSize
     */
    public LRUCache(int cacheSize) {
        super((int) (Math.ceil(cacheSize / 0.75f) + 1), 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 父类提供的钩子方法: 插入新元素时如果需要删除老数据,则返回true,否则返回false
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //当设置的cacheSize小于map的size时,删除旧的数据
        return cacheSize < size();
    }
}
