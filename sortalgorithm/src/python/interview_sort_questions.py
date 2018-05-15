import heapq
from random import choice

import numpy as np

"""
    记录面试时，被问到的排序问题。
    
    下面使用 heap 找中位数的方法，也能找到中位数。但不是时间复杂度最近的方法。
    我惊奇地发现找中位数的时间复杂度是:
    
        \mathcal{O}(n)
        
    而且现在的算法就在《算法导论》第九章。
    select_algorithm.py 是我照着《算法导论》书实现的选择算法。
"""


def find_median(arr):
    """找到中位数。

    我使用 heapq 的做法，结果上是对的。

    向 size 为 n 的 heap 中插入一个元素的时间复杂度是 lgn,
    从 size 为 n 的 heap 中抛出一个元素的时间复杂度是 lgn
    所以整个算法的时间复杂度是

        .. :math:

            O(nlgn)

    和排序是同一个量级的。所以基本没有多大优势。
    """
    length = len(arr)
    middle = int(length / 2) + (1 if length % 2 else 0)
    # middle = int(length / 2)
    h = arr[:middle]
    heapq.heapify(h)

    for item in arr[middle:]:
        heapq.heappush(h, item)
        heapq.heappop(h)
    # when arr_length is 2k + 1, return k + 1 max value.
    # when arr_length is 2k, return k + 1 max value
    return heapq.heappop(h)


def test_find_median():
    def test_case(arr_length):
        test_arr = list(np.random.rand(arr_length))
        median_found = find_median(test_arr)
        test_arr.sort()
        median = test_arr[int(arr_length / 2)]
        assert median_found == median, ("find_median cannot find the median "
                                        "as expected.")

    test_case(7)  # arr_length is odd
    test_case(8)  # arr length is even
