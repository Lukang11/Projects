import sys
import numpy as np
from timeit import default_timer as timer
from datetime import timedelta

def mergeSort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        L = arr[:mid]
        R = arr[mid:]
        mergeSort(L)
        mergeSort(R)
        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1
        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1
        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1
def printList(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print()


def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and arr[largest] < arr[l]:
        largest = l
    if r < n and arr[largest] < arr[r]:
        largest = r
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap
        heapify(arr, n, largest)

def heapSort(arr):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)

def partition(arr, low, high):
    i = (low - 1)  # index of smaller element
    pivot = arr[high]  # pivot

    for j in range(low, high):
        if arr[j] <= pivot:
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return (i + 1)


def quicksort(arr, low, high):
    if len(arr) == 1:
        return arr
    if low < high:
        pi = partition(arr, low, high)
        quicksort(arr, low, pi - 1)
        quicksort(arr, pi + 1, high)

def shellSort(arr):
    gap = len(arr) // 2  # initialize the gap

    while gap > 0:
        i = 0
        j = gap
        while j < len(arr):

            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j += 1
            k = i
            while k - gap > -1:

                if arr[k - gap] > arr[k]:
                    arr[k - gap], arr[k] = arr[k], arr[k - gap]
                k -= 1

        gap //= 2
if __name__ == '__main__':

    sys.setrecursionlimit(10000)
    arr = np.random.randint(1, 101, 3900)
    arrSorted = sorted(arr)
    arrRevSort = sorted(arr, reverse=True)
    n = len(arr)
    print("Sorted , starting heap sort")
    start = timer()
    heapSort(arr)
    end = timer()
    print("Heap Sort were sorting  random array for :", timedelta(seconds=end-start))
    start1 = timer()
    heapSort(arrSorted)
    end1 = timer()
    print("Were sorting sorted array for : ", timedelta(seconds=end1-start1))

    start2 = timer()
    heapSort(arrRevSort)
    end2 = timer()
    print("Were sorting reversed array for : ", timedelta(seconds=end2-start2))
    print("----------------------------------------------------------")
    start6 = timer()
    mergeSort(arr)
    end6 =timer()
    print("Were sorting for random array: ", timedelta(seconds=end6 - start6))

    start7 = timer()
    mergeSort(arrSorted)
    end7 = timer()
    print("Were sorting for sorted array: ", timedelta(seconds=end7 - start7))
    start8 = timer()
    mergeSort(arrRevSort)
    end8 = timer()
    print("Were sorting for reverse sorted array: ", timedelta(seconds=end8 - start8))
    print("----------------------------------------------------------")
    print("Start quicksort : ")

    start3 = timer()
    quicksort(arr, 0, n-1)
    end3 = timer()
    print("Quick sort were working on random data for :", timedelta(seconds=end3-start3))
    start4 = timer()
    quicksort(arrSorted, 0, n - 1)
    end4 = timer()
    print("Quick sort were working on sorted data for :", timedelta(seconds=end4 - start4))
    start5 = timer()
    quicksort(arrRevSort, 0, n - 1)
    end5 = timer()
    print("Quick sort were working on revers sorted data for :", timedelta(seconds=end5 - start5))
    print("----------------------------------------------------------")
    print("Start Shellsorting : ", )
    start9 = timer()
    shellSort(arr)
    end9 = timer()
    print("Shelling sort were working for : ", timedelta(seconds=end9-start9))
    start90 = timer()
    shellSort(arrSorted)
    end90 = timer()
    print("Shelling sort were working for : ", timedelta(seconds=end90 - start90))
    start91 = timer()
    shellSort(arrRevSort)
    end91 = timer()
    print("Shelling sort were working for : ", timedelta(seconds=end91 - start91))