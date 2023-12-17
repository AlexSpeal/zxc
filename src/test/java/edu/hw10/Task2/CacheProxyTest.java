package edu.hw10.Task2;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CacheProxyTest {
    @Test
    @DisplayName("Кеширующий прокси работает для fib")
    void test1() {
        FibCalculator fib = new FibCalculatorImp();
        FibCalculator proxyFib = (FibCalculator) CacheProxy.create(fib, fib.getClass());

        long result = proxyFib.fib(5);
        Map<String, Object[]> cache = CacheProxy.getCache();

        assertEquals(5, result);
        assertNotNull(cache);
        assertEquals("[[5]]", Arrays.toString(cache.keySet().toArray()));
        assertEquals("[5, fib]", Arrays.toString(cache.get(Arrays.toString(new Object[] {5}))));
    }

    @Test
    @DisplayName("Сохраняются только уникальные значения")
    void test3() {
        FibCalculator fib = new FibCalculatorImp();
        FibCalculator proxyFib = (FibCalculator) CacheProxy.create(fib, fib.getClass());

        proxyFib.fib(5);
        proxyFib.fib(5);
        proxyFib.fib(5);
        proxyFib.fib(5);
        proxyFib.fib(5);
        Map<String, Object[]> cache = CacheProxy.getCache();

        assertNotNull(cache);
        assertEquals(1, cache.size());
    }

    @Test
    @DisplayName("Сохраняются только уникальные значения")
    void test4() {
        FibCalculator fib = new FibCalculatorImp();
        FibCalculator proxyFib = (FibCalculator) CacheProxy.create(fib, fib.getClass());

        proxyFib.fib(5);
        proxyFib.fib(1);
        proxyFib.fib(2);
        proxyFib.fib(3);
        proxyFib.fib(4);
        Map<String, Object[]> cache = CacheProxy.getCache();

        assertNotNull(cache);
        assertEquals(5, cache.size());
    }

}
