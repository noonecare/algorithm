# coding: utf-8

"""
在有其他信息帮助的情况下，排序算法可以在 O(n) 时间内完成。
计数排序(counting sort)就是一种在 O(n) 时间内完成的排序算法。
"""

import numpy as np


def counting_sort(arr, length, upper_bound):
    """
    counting_sort 对 arr 使用 counting sort 算法排序。
    :param arr: 要排序的 arr, arr 中的元素是属于 0 .. upper_bound 的整数
    :param length: arr 的长度
    :param upper_bound: arr 中元素的上界
    :return 对 arr 排序后的结果
    """
    counting_arr = np.zeros(upper_bound + 1, dtype=int)
    for i in range(length):
        counting_arr[arr[i]] += 1

    result = []
    for i, value in enumerate(counting_arr):
        for j in range(value):
            result.append(i)
    return result


def test_sort():
    upper_bound = 10
    test_arr = [int(upper_bound * i) for i in np.random.rand(1000)]
    length = len(test_arr)

    result = counting_sort(test_arr, length, upper_bound)
    # 按照从小打到排序，每个元素都应该小于它后面的元素
    for i in range(length - 1):
        assert (result[i] <= result[i + 1])
