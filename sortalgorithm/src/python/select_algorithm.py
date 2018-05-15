"""
    select algorithm.  I am surprised that the time complexity of select
    algorithm is O(n).
"""

import numpy as np


def partition(arr, left, right):
    """partition arr into two part, all elements from left part is less
    than the right part.
    """
    t = arr[left]
    i = left
    for j in range(left + 1, right + 1):
        if arr[j] <= t:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[left], arr[i] = arr[i], arr[left]
    return i


def random_partition(arr, left, right):
    """Shuffle before do partition."""
    np.random.shuffle(arr[left:right + 1])
    return partition(arr, left, right)


def random_select(arr, left, right, k):
    """Select k-th great element from arr[left:right+1].

    The average complexity of this select algorithm is :

        \mathcal{O}(n), n is the length of the arr.

    Reference 'an Introduction to algorithm' chapter 9.
    """
    i = random_partition(arr, left, right)
    i_th = i - left + 1
    if i_th == k:
        return arr[i]

    if i_th < k:
        return random_select(arr, i + 1, right, k - i_th)

    if i_th > k:
        return random_select(arr, left, i - 1, k)


def _get_median_order(length):
    if length % 2:
        return (length + 1) // 2
    else:
        return length // 2


def _get_median(arr):
    arr.sort()
    median_order = _get_median_order(len(arr))
    return arr[median_order - 1]


def _partition_by_div(arr, left, right, div):
    """partition `arr` by `div`.  `div` must be a element of
    arr[left:right+1].
    """
    div_index = None
    i = left - 1
    for j in range(left, right + 1):
        if arr[j] <= div:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

        if arr[i] == div:
            div_index = i

    arr[div_index], arr[i] = arr[i], arr[div_index]
    return i


def select(arr, left, right, k):
    """Select k-th great element from arr[left:right+1].  The **Worst
    time complexity** of this algorithm is:

        \mathcal{O}(n), n is the length of the arr.

    Reference 'an Introduction to algorithm' chapter 9.
    """
    if right - left + 1 <= 5:
        arr.sort()
        return arr[left + k - 1]

    c_5 = [arr[i: i + 5] for i in range(left, right + 1, 5)]
    medians = [_get_median(a) for a in c_5]
    length = len(c_5)
    div = select(medians, 0, length - 1, _get_median_order(length))
    i = _partition_by_div(arr, left, right, div)
    i_th = i - left + 1
    if i_th == k:
        return arr[i]
    if i_th > k:
        return select(arr, left, i - 1, k)
    if i_th < k:
        return select(arr, i + 1, right, k - i_th)


def test_partition():
    arr = np.random.rand(10)
    p = partition(arr, 0, len(arr) - 1)
    assert all(arr[:p] <= arr[p])
    assert all(arr[p + 1:] > arr[p])


def test_random_select():
    arr = np.random.rand(10)
    sorted_arr = arr[:]
    sorted_arr.sort()

    for i in range(1, 10 + 1):
        assert random_select(arr, 0, 9, i) == sorted_arr[i - 1]


def test_select():
    arr = np.random.rand(10)
    sorted_arr = arr[:]
    sorted_arr.sort()

    for i in range(1, 10 + 1):
        assert select(arr, 0, 9, i) == sorted_arr[i - 1]
