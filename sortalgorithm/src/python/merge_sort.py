# coding: utf-8

"""
python implements merge sort.
"""
import numpy as np


def merge(arr_1, l_1, r_1, arr_2, l_2, r_2):
    temp_arr = np.zeros(r_1 - l_1 + 1 + r_2 - l_2 + 1)
    k = -1

    i, j = l_1, l_2

    while i <= r_1 or j <= r_2:

        k += 1

        if i > r_1:
            temp_arr[k] = arr_2[j]
            j += 1
            break

        if j > r_2:
            temp_arr[k] = arr_1[i]
            i += 1
            k += 1
            break

        if arr_1[i] <= arr_2[j]:
            temp_arr[k] = arr_1[i]
            i += 1
        else:
            temp_arr[k] = arr_2[j]
            j += 1


def merge_sort(arr, left, right):
    if left == right:
        return

    middle = int((left + right) / 2)

    merge(arr, left, middle)
    merge(arr, middle + 1, right)


def test_sort():
    test_arr = np.random.rand(10)
    length = len(test_arr)

    merge_sort(test_arr, 0, length - 1)
    # 按照从小打到排序，每个元素都应该小于它后面的元素
    for i in range(length - 1):
        assert (test_arr[i] <= test_arr[i + 1])
