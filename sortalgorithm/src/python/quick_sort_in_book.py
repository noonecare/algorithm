import random

import numpy as np

"""
原来我早就用 python 实现过 quick sort 算法。
这份代码是照着《算法导论》中给的算法写的，还是要比我想的精巧一些。
"""


def exchange(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp


# this version is better than my implementation in my_quick_sort.py.
def partition(arr, p, r):
    x = arr[r]
    i = p - 1

    for j in range(p, r):
        if arr[j] <= x:
            i += 1
            exchange(arr, i, j)
    exchange(arr, i + 1, r)
    return i + 1


def quick_sort(arr, p, r):
    if p < r:
        q = partition(arr, p, r)
        quick_sort(arr, p, q - 1)
        quick_sort(arr, q + 1, r)


def randomized_partition(arr, p, r):
    if p < r:
        i = random.randint(p, r)
        exchange(arr, i, r)
        return partition(arr, p, r)


def randomized_quick_sort(arr, p, r):
    if p < r:
        q = randomized_partition(arr, p, r)
        randomized_partition(arr, p, q - 1)
        randomized_partition(arr, q + 1, r)


def test_quick_sort_suite():
    test_partition = np.array([1, 2, 3, 4, 5, 6])
    length = len(test_partition)
    assert (partition(test_partition, 0, length - 1) == length - 1)
    test_partition = np.array([6, 5, 4, 3, 2, 1])
    length = len(test_partition)
    assert (partition(test_partition, 0, length - 1) == 0)

    test_quick_sort = [12, 16, 21, 93, 27, 51]
    expected_result = [12, 16, 21, 27, 51, 93]
    length = len(test_quick_sort)
    quick_sort(test_quick_sort, 0, length - 1)
    for i in range(length):
        assert (test_quick_sort[i] == expected_result[i])

    test_randomized_quick_sort = [12, 16, 21, 93, 27, 51]
    randomized_quick_sort(test_randomized_quick_sort, 0, length - 1)
    for i in range(length):
        assert (test_randomized_quick_sort[i] == expected_result[i])
