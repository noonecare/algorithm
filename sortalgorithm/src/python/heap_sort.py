# coding: utf-8

"""
python implements heap sort.
"""

import heapq
import random
import numpy as np


# python 中有现成的 heapq 数据结构，这使得实现 heap sort 显得太简单
def heap_sort(l):
    heap = []
    for element in l:
        heapq.heappush(heap, element)
    result = []
    while heap:
        result.append(heapq.heappop(heap))
    return result


def test_sort():
    test_arr = np.random.rand(10)
    random.shuffle(test_arr)
    length = len(test_arr)
    print(test_arr)

    result = heap_sort(test_arr)
    # 按照从小打到排序，每个元素都应该小于它后面的元素
    for i in range(length - 1):
        assert (result[i] <= result[i + 1])
