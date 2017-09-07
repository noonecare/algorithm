import heapq


def k_array_sort(k_array):
    """
    :param k_array: 二维数组，代表多个已经排好序的数列
    :return: 把 k_array 排好序后的结果
    """

    k = len(k_array)
    # k 个数组，每个数组的长度
    k_length = [len(arr) for arr in k_array]
    # k_array 中一共有 n 个元素
    n = sum(k_length)

    h = []
    # 把 k 个数组每个数组的第一个元素放到堆中
    for i in range(k):
        # tuple 比大小时，是字典序
        heapq.heappush(h, (k_array[i][0], i, 0))
    count = 0
    result = []
    # 只要没有把数组中所有的数都过一遍，就一直继续
    while count < n:
        value, i_th_array, index = heapq.heappop(h)
        # 把 value 添加到 result 序列中
        result.append(value)
        count += 1
        next_index = index + 1
        if next_index < k_length[i_th_array]:
            heapq.heappush(h, (k_array[i_th_array][next_index], i_th_array, next_index))

    return result


if __name__ == '__main__':
    a = [1, 5, 18, 20]
    b = [3, 6, 7, 10]
    c = [1, 5, 8, 10]
    print(k_array_sort([a, b, c]))
