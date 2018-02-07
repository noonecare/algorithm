# coding: utf-8

"""
python is more concise than Java. it's quicker to use python to implement algorithms than use Java.

python implements quick sort algorithm.
"""

import numpy as np


def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp


def quick_sort(arr, left, right):
    # 只有一个元素，立马返回
    if left == right:
        return

    # 有多个元素时，递归求解
    elem = arr[left]

    i = 0
    j = 0

    while i + j != right - left:
        if arr[i + left + 1] >= elem:
            swap(arr, i + left + 1, right - j)
        else:
            i += 1
    swap(arr, left, max(left + i - 1, left))

    quick_sort(arr, left, max(i - 2 + left, left))
    quick_sort(arr, min(i + left, right), right)


def test_sort():
    test_arr = np.random.rand(10)
    length = len(test_arr)
    print(test_arr)

    quick_sort(test_arr, 0, length - 1)
    # 按照从小打到排序，每个元素都应该小于它后面的元素
    for i in range(length - 1):
        assert (test_arr[i] <= test_arr[i + 1])
