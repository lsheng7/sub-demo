package com.example.subdemo.guava;

import cn.hutool.core.lang.Assert;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 布鲁姆演示
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2022/02/08 09:55
 */
public class BloomFilterDemo {

    public static void main(String[] args) {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(), 10000000, 0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
            System.out.println(filter.mightContain(i));
            System.out.println(filter.mightContain(i+1));
            Assert.isTrue(filter.mightContain(i));
            Assert.isFalse(filter.mightContain(i + 1));
        }
    }
}
