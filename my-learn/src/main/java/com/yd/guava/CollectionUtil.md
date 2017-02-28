###不可变集合的有点
-   当对象被不可信的库调用时，不可变形时是安全的
-   不可变对象被对多个线程调用时，不存在竞态条件问题
-   不可变集合不需要考虑变化，因此可以节省时间和空间。所有的不可变的集合都比他们的可变形时有更好的内存利用率
-   不可变对象因为有固定不变，可以作为常量来安全使用

###使用
    copyOf 方法，如 ImmutableSet.copyOf(set);
    of 方法，如 ImmutableSet.of(“a”, “b”, “c”)或 ImmutableMap.of(“a”, 1, “b”, 2);
    Builder工具
    
###Multiset
 可以用两种方式看待 Multiset：
-   没有元素顺序限制的 ArrayList
-   Map<E, Integer>，键为元素，值为计数


    count(E) 给定元素在 Multiset 中的计数
    elementSet() Multiset 中不重复元素的集合，类型为 Set<E>
    entrySet() 和 Map 的 entrySet 类似，返回 Set<Multiset.Entry<E>>，其中包含的 Entry 支持 getElement()和 getCount()方法
    add(E, int) 增加给定元素在 Multiset 中的计数
    remove(E, int) 减少给定元素在 Multiset 中的计数
    setCount(E, int) 设置给定元素在 Multiset 中的计数，不可以为负数
    size() 返回集合元素的总个数（包括重复的元素）
    
###Multimap

    put(K, V) 添加键到单个值的映射 multimap.get(key).add(value)
    putAll(K, Iterabl e<V>)  依次添加键到多个值的映射 Iterables.addAll(multimap.get(key), v alues)
    remove(K, V) 移除键到值的映射；如果有这样的键值并成功移除，返回 true。
    multimap.get(key).remove(value)
    removeAll(K) 清除键对应的所有值，返回的集合包含所有之前映射到 K 的值，但修改这个集合就不会影响 Multimap 了。multimap.get(key).clear()
    replaceValues(K, Ite  rable<V>) 清除键对应的所有值，并重新把 key 关联到 Iterable 中的每个元素。返回的集合包含所有之前映射到 K 的值。multimap.get(key).clear(); Iterables.adAll(multimap.get(key), values)