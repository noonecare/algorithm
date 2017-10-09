import random

import numpy as np


def exchange(A: np.array, i: int, j: int):
    temp = A[i]
    A[i] = A[j]
    A[j] = temp


def partition(A: np.array, p: int, r: int):
    x = A[r]
    i = p - 1

    for j in range(p, r):
        if A[j] <= x:
            i += 1
            exchange(A, i, j)
    exchange(A, i + 1, r)
    return i + 1


def quick_sort(A: np.array, p: int, r: int):
    if p < r:
        q = partition(A, p, r)
        quick_sort(A, p, q - 1)
        quick_sort(A, q + 1, r)


def randomized_partition(A: np.array, p: int, r: int):
    if p < r:
        i = random.randint(p, r)
        exchange(A, i, r)
        return partition(A, p, r)


def randomized_quick_sort(A: np.array, p: int, r: int):
    if p < r:
        q = randomized_partition(A, p, r)
        randomized_partition(A, p, q - 1)
        randomized_partition(A, q + 1, r)


if __name__ == '__main__':
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

