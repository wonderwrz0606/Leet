// Task:
// 1. Using recursion to reverse the String
// 2. Redo the reverse linkedlist by pairs
// 3. Understand how to solve the N-queens using the 2 methods from Laicode
// 4. Finish the Spiral array I
// 5. Finish cut rope(recursion, 左大段+右大段， 左大段+右小段), Longest ascending array, Jump game
// 6. Work on the dicitionary problem and shortest jump game

// Reserve String using recursion
// Time complexity: O(n)
// Space complexity: O(2n) = O(n)
public class Solution {
  // Using recursion to reverse the string
  public String reverse(String input) {
    // Write your solution here.
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    this.helper(array, 0, array.length-1);
    return new String(array);
  }

  private void helper(char[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    // Swap [start] and [end]
    this.swap(array, start, end);
    // Recursion for start++ and end--
    this.helper(array, start+1, end-1);
  }

  private void swap(char[] array, int i, int j) {
    char c = array[i];
    array[i] = array[j];
    array[j] = c;
  }
}

// Spiral array
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> result = new LinkedList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    int rowShift = 0;
    int colShift = 0;
    int rowTotalIndex = matrix.length-1;
    int colTotalIndex = matrix[0].length-1;
    while (rowShift <= rowTotalIndex-rowShift) { // Using <= since the length of the row may be odd
      if (rowShift == rowTotalIndex-rowShift) {
        for (int i = rowShift; i <= colTotalIndex-colShift-1; i++) {
          result.add(matrix[rowShift][i]);
        }
        break;
      }
      // Top side
      for (int i = rowShift; i <= colTotalIndex-colShift-1; i++) {
        result.add(matrix[rowShift][i]);
      }
      // Right side
      for (int i = 0; i <= rowTotalIndex-rowShift-1; i++) {
        result.add(matrix[i][colTotalIndex-colShift]);
      }
      // Bottom side
      for (int i = colTotalIndex-colShift; i > colShift; i--) {
        result.add(matrix[rowTotalIndex-rowShift][i]);
      }
      // Left side
      for (int i = rowTotalIndex-rowShift; i > rowShift; i--) {
        result.add(matrix[i][colShift]);
      }
      rowShift++;
      colShift++;
    }
    return result;
  }
}
