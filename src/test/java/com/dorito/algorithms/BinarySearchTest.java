package com.dorito.algorithms;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Binary Search Algorithm Tests")
class BinarySearchTest {
    
    private BinarySearch binarySearch;
    
    @BeforeEach
     @SuppressWarnings("unused")
    void setUp() {
        binarySearch = new BinarySearch();
    }
    
    @Nested
    @DisplayName("Iterative Binary Search")
    @SuppressWarnings("unused")
    class IterativeSearchTests {
        
        @Test
        @DisplayName("Should find target in middle of array")
        void shouldFindTargetInMiddleOfArray() {
            // Given
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 9;
            
            // When
            int result = binarySearch.search(nums, target);
            
            // Then
            assertThat(result).isEqualTo(4);
        }
        
        @Test
        @DisplayName("Should return -1 when target not found")
        void shouldReturnMinusOneWhenTargetNotFound() {
            // Given
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 2;
            
            // When
            int result = binarySearch.search(nums, target);
            
            // Then
            assertThat(result).isEqualTo(-1);
        }
        
        @Test
        @DisplayName("Should find target at first position")
        void shouldFindTargetAtFirstPosition() {
            // Given
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = -1;
            
            // When
            int result = binarySearch.search(nums, target);
            
            // Then
            assertThat(result).isEqualTo(0);
        }
        
        @Test
        @DisplayName("Should find target at last position")
        void shouldFindTargetAtLastPosition() {
            // Given
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 12;
            
            // When
            int result = binarySearch.search(nums, target);
            
            // Then
            assertThat(result).isEqualTo(5);
        }
        
        @Test
        @DisplayName("Should handle single element array")
        void shouldHandleSingleElementArray() {
            // Given
            int[] nums = {5};
            int target = 5;
            
            // When
            int result = binarySearch.search(nums, target);
            
            // Then
            assertThat(result).isEqualTo(0);
        }
        
        @Test
        @DisplayName("Should return -1 for single element array when target not found")
        void shouldReturnMinusOneForSingleElementArrayWhenTargetNotFound() {
            // Given
            int[] nums = {5};
            int target = 3;
            
            // When
            int result = binarySearch.search(nums, target);
            
            // Then
            assertThat(result).isEqualTo(-1);
        }
    }
    
    @Nested
    @DisplayName("Recursive Binary Search")
    @SuppressWarnings("unused")
    class RecursiveSearchTests {
        
        @Test
        @DisplayName("Should find target using recursive approach")
        void shouldFindTargetUsingRecursiveApproach() {
            // Given
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 9;
            
            // When
            int result = binarySearch.searchRecursive(nums, target);
            
            // Then
            assertThat(result).isEqualTo(4);
        }
        
        @Test
        @DisplayName("Should return -1 when target not found (recursive)")
        void shouldReturnMinusOneWhenTargetNotFoundRecursive() {
            // Given
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 2;
            
            // When
            int result = binarySearch.searchRecursive(nums, target);
            
            // Then
            assertThat(result).isEqualTo(-1);
        }
    }
    
    @Nested
    @DisplayName("Search First and Last Occurrence")
    @SuppressWarnings("unused")
    class SearchFirstLastTests {
        
        @Test
        @DisplayName("Should find first occurrence of target")
        void shouldFindFirstOccurrenceOfTarget() {
            // Given
            int[] nums = {1, 2, 2, 2, 3, 4, 5};
            int target = 2;
            
            // When
            int result = binarySearch.searchFirst(nums, target);
            
            // Then
            assertThat(result).isEqualTo(1);
        }
        
        @Test
        @DisplayName("Should find last occurrence of target")
        void shouldFindLastOccurrenceOfTarget() {
            // Given
            int[] nums = {1, 2, 2, 2, 3, 4, 5};
            int target = 2;
            
            // When
            int result = binarySearch.searchLast(nums, target);
            
            // Then
            assertThat(result).isEqualTo(3);
        }
        
        @Test
        @DisplayName("Should return -1 when target not found (searchFirst)")
        void shouldReturnMinusOneWhenTargetNotFoundSearchFirst() {
            // Given
            int[] nums = {1, 2, 2, 2, 3, 4, 5};
            int target = 6;
            
            // When
            int result = binarySearch.searchFirst(nums, target);
            
            // Then
            assertThat(result).isEqualTo(-1);
        }
        
        @Test
        @DisplayName("Should return -1 when target not found (searchLast)")
        void shouldReturnMinusOneWhenTargetNotFoundSearchLast() {
            // Given
            int[] nums = {1, 2, 2, 2, 3, 4, 5};
            int target = 6;
            
            // When
            int result = binarySearch.searchLast(nums, target);
            
            // Then
            assertThat(result).isEqualTo(-1);
        }
    }
    
    @ParameterizedTest
    @MethodSource("provideBinarySearchTestCases")
    @DisplayName("Should solve various binary search cases")
    void shouldSolveVariousBinarySearchCases(int[] nums, int target, int expected) {
        // When
        int result = binarySearch.search(nums, target);
        
        // Then
        assertThat(result).isEqualTo(expected);
    }
}

