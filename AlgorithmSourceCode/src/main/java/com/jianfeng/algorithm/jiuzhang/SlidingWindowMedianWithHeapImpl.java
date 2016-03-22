package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SlidingWindowMedianWithHeapImpl {
	class HashHeap<T> {
		ArrayList<T> heap;
		int size_t;
		HashMap<T, Node> hash;
		Comparator<T> comparator;

		class Node {
			public Integer id;
			public Integer num;

			Node(Node now) {
				id = now.id;
				num = now.num;
			}

			Node(Integer first, Integer second) {

				this.id = first;
				this.num = second;
			}
		}

		public HashHeap(Comparator<T> comparator) {
			// TODO Auto-generated constructor stub
			heap = new ArrayList<T>();
			this.comparator = comparator;
			hash = new HashMap<T, Node>();
			size_t = 0;
		}

		T peaK() {
			return heap.get(0);
		}

		int size() {
			return size_t;
		}

		Boolean empty() {
			return (heap.size() == 0);
		}

		int parent(int id) {
			if (id == 0) {
				return -1;
			}
			return (id - 1) / 2;
		}

		int lson(int id) {
			return id * 2 + 1;
		}

		int rson(int id) {
			return id * 2 + 2;
		}

		boolean comparesmall(T a, T b) {
			return comparator.compare(a, b) == -1 ? true : false;

		}

		void swap(int idA, int idB) {
			T valA = heap.get(idA);
			T valB = heap.get(idB);

			int numA = hash.get(valA).num;
			int numB = hash.get(valB).num;
			hash.put(valB, new Node(idA, numB));
			hash.put(valA, new Node(idB, numA));
			heap.set(idA, valB);
			heap.set(idB, valA);
		}

		T poll() {
			size_t--;
			T now = heap.get(0);
			Node hashnow = hash.get(now);
			if (hashnow.num == 1) {
				swap(0, heap.size() - 1);
				hash.remove(now);
				heap.remove(heap.size() - 1);
				if (heap.size() > 0) {
					siftdown(0);
				}
			} else {
				hash.put(now, new Node(0, hashnow.num - 1));
			}
			return now;
		}

		void add(T now) {
			size_t++;
			if (hash.containsKey(now)) {
				Node hashnow = hash.get(now);
				hash.put(now, new Node(hashnow.id, hashnow.num + 1));

			} else {
				heap.add(now);
				hash.put(now, new Node(heap.size() - 1, 1));
			}

			siftup(heap.size() - 1);
		}

		void delete(T now) {
			size_t--;
			Node hashnow = hash.get(now);
			int id = hashnow.id;
			int num = hashnow.num;
			if (hashnow.num == 1) {

				swap(id, heap.size() - 1);
				hash.remove(now);
				heap.remove(heap.size() - 1);
				if (heap.size() > id) {
					siftup(id);
					siftdown(id);
				}
			} else {
				hash.put(now, new Node(id, num - 1));
			}
		}

		void siftup(int id) {
			while (parent(id) > -1) {
				int parentId = parent(id);
				if (comparesmall(heap.get(parentId), heap.get(id)) == true) {
					break;
				} else {
					swap(id, parentId);
				}
				id = parentId;
			}
		}

		void siftdown(int id) {
			while (lson(id) < heap.size()) {
				int leftId = lson(id);
				int rightId = rson(id);
				int son;
				if (rightId >= heap.size()
						|| (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
					son = leftId;
				} else {
					son = rightId;
				}
				if (comparesmall(heap.get(id), heap.get(son)) == true) {
					break;
				} else {
					swap(id, son);
				}
				id = son;
			}
		}
	}

	public class Solution {
		/**
		 * @param nums
		 *            : A list of integers.
		 * @return: The median of the element inside the window at each moving.
		 */
		public ArrayList<Integer> medianSlidingWindow(int[] nums, int T) {
			// write your code here

			ArrayList<Integer> ans = new ArrayList<Integer>();
			if (nums.length == 0)
				return ans;
			int median = nums[0];
			HashHeap<Integer> minheap = new HashHeap<Integer>(new Comparator<Integer>(){

				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
				
			});
			HashHeap<Integer> maxheap = new HashHeap<Integer>(new Comparator<Integer>(){

				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
				
			});
			for (int i = 0; i < nums.length; i++) {
				if (i != 0) {
					if (nums[i] > median) {
						minheap.add(nums[i]);
					} else {
						maxheap.add(nums[i]);
					}
				}

				if (i >= T) {
					if (median == nums[i - T]) {
						if (maxheap.size() > 0) {
							median = maxheap.poll();
						} else if (minheap.size() > 0) {
							median = minheap.poll();
						}

					} else if (median < nums[i - T]) {
						minheap.delete(nums[i - T]);
					} else {
						maxheap.delete(nums[i - T]);
					}
				}

				while (maxheap.size() > minheap.size()) {
					minheap.add(median);
					median = maxheap.poll();
				}
				while (minheap.size() > maxheap.size() + 1) {
					maxheap.add(median);
					median = minheap.poll();
				}

				if (i + 1 >= T) {
					ans.add(median);
				}
			}
			return ans;
		}

		ArrayList<Integer> getmedian(int[] nums, int T) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int j = i; j < i + T && j < nums.length; j++)
					temp.add(nums[j]);
				Collections.sort(temp);
				Collections.reverse(temp);
				ans.add(temp.get(temp.size() / 2));
			}
			return ans;
		}

	}
	
	public static void main(String[] args){
		SlidingWindowMedianWithHeapImpl sl = new SlidingWindowMedianWithHeapImpl();
		sl.testHashHeap();
	}
	
	public void testHashHeap(){
		HashHeap<Integer> minheap = new HashHeap<Integer>(new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		minheap.add(1);
		minheap.add(1);
		minheap.add(4);
		minheap.add(2);
		minheap.add(5);
		minheap.peaK();
		System.out.println(minheap.heap);
	}
}
