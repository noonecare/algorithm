# coding: utf-8

"""
python is more concise than Java. it's quicker to use python to implement algorithms than use Java.

python implements quick sort algorithm.
"""

import numpy


def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp


def quick_sort(arr, left, right):
    # 只有一个元素，立马返回
    if left == right:
        return

    # 有多个元素时，递归求解
    middle_index = int((left + right) / 2)
    middle_element = arr[middle_index]

    i = 0
    j = 0

    while i + j != right + 1 - left:
        if arr[i + left] > middle_element:
            swap(arr, i + left, right - j)
            j += 1
        if arr[i + left] < middle_element:
            i += 1
        if arr[i + left] == middle_element:
            first_middle_element = i + left
            i += 1

    # 注意 middle_element 必须出现在分割点上
    swap(arr, first_middle_element, i + left - 1)

    quick_sort(arr, left, max(i - 2 + left, left))
    quick_sort(arr, min(i + left, right), right)


def test_quick_sort():
    test_arr = numpy.random.rand(10)
    length = len(test_arr)

    quick_sort(test_arr, 0, length - 1)
    for i in range(length - 1):
        assert (test_arr[i] <= test_arr[i + 1])
